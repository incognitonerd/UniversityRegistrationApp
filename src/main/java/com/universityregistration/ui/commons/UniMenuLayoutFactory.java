package com.universityregistration.ui.commons;
import com.universityregistration.ui.navigator.UniNavigator;
import com.universityregistration.ui.views.ComponentBuilder;
import com.universityregistration.utils.Constants;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniMenuLayoutFactory implements ComponentBuilder {
	private class UniversityMenu extends VerticalLayout implements Property.ValueChangeListener {
		private static final long serialVersionUID = 1L;
		private Tree mainMenu;
		
		public UniversityMenu init(){
			mainMenu = new Tree();
			mainMenu.addValueChangeListener(this);
			return this;
		}
		
		public UniversityMenu layout(){
			setWidth("100%");
			setHeight("100%");
			setMargin(false);
			mainMenu.addItem(Constants.STUDENTS_PARENT.getStr());
			mainMenu.addItem(Constants.UNIVERSITIES_PARENT.getStr());
			mainMenu.expandItem(Constants.STUDENTS_PARENT.getStr());
			mainMenu.expandItem(Constants.UNIVERSITIES_PARENT.getStr());
			mainMenu.addItem(Constants.STUDENTS_ADD_STUDENT.getStr());
			mainMenu.addItem(Constants.STUDENTS_REMOVE_STUDENT.getStr());
			mainMenu.setChildrenAllowed(Constants.STUDENTS_ADD_STUDENT.getStr(), false);
			mainMenu.setChildrenAllowed(Constants.STUDENTS_REMOVE_STUDENT.getStr(), false);
			mainMenu.setParent(Constants.STUDENTS_ADD_STUDENT.getStr(), Constants.STUDENTS_PARENT.getStr());
			mainMenu.setParent(Constants.STUDENTS_REMOVE_STUDENT.getStr(), Constants.STUDENTS_PARENT.getStr());
			mainMenu.addItem(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr());
			mainMenu.setChildrenAllowed(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr(), false);
			mainMenu.setParent(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr(), Constants.UNIVERSITIES_PARENT.getStr());
			addComponent(mainMenu);
			return this;
		}
		
		public void valueChange(ValueChangeEvent event){
			String tab = (String) event.getProperty().getValue();
			if(tab == null){
				return;
			}
			if(tab.compareToIgnoreCase("add student") == 0 || tab.compareToIgnoreCase("remove student") == 0
					|| tab.compareToIgnoreCase("add university") == 0){
				String path = tab.toLowerCase().replaceAll("\\s+", "");
				UniNavigator.navigate(path);
			} else{
				return;
			}
		}
	}
	
	public Component createComponent(){
		return new UniversityMenu().init().layout();
	}
}
