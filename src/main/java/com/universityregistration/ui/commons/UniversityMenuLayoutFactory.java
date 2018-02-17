package com.universityregistration.ui.commons;
import com.universityregistration.ui.navigator.UniversityNavigator;
import com.universityregistration.ui.views.UIComponentBuilder;
import com.universityregistration.utils.Constants;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversityMenuLayoutFactory implements UIComponentBuilder {
	private class UniversityMenu extends VerticalLayout implements Property.ValueChangeListener {
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
			String selectedItemPath = (String) event.getProperty().getValue();
			if(selectedItemPath.compareToIgnoreCase("add student") == 0
					|| selectedItemPath.compareToIgnoreCase("remove student") == 0
					|| selectedItemPath.compareToIgnoreCase("add university") == 0){
				String path = selectedItemPath.toLowerCase().replaceAll("\\s+", "");
				UniversityNavigator.navigate(path);
			} else{
				return;
			}
		}
	}
	
	public Component createComponent(){
		return new UniversityMenu().init().layout();
	}
}
