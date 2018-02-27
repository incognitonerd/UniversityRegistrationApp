package com.unireg.ui.commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import com.unireg.ui.navigator.UiNavigator;
import com.unireg.ui.views.ComponentBuilder;
import com.unireg.utils.Constants;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class MenuLayoutFactory implements ComponentBuilder {
	private static final Logger LOG = LoggerFactory.getLogger(MenuLayoutFactory.class);
	
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
			mainMenu.expandItem(Constants.STUDENTS_PARENT.getStr());
			mainMenu.addItem(Constants.STUDENTS_ADD_STUDENT.getStr());
			mainMenu.addItem(Constants.STUDENTS_REMOVE_STUDENT.getStr());
			mainMenu.setChildrenAllowed(Constants.STUDENTS_ADD_STUDENT.getStr(), false);
			mainMenu.setChildrenAllowed(Constants.STUDENTS_REMOVE_STUDENT.getStr(), false);
			mainMenu.setParent(Constants.STUDENTS_ADD_STUDENT.getStr(), Constants.STUDENTS_PARENT.getStr());
			mainMenu.setParent(Constants.STUDENTS_REMOVE_STUDENT.getStr(), Constants.STUDENTS_PARENT.getStr());
			mainMenu.addItem(Constants.UNIVERSITIES_PARENT.getStr());
			mainMenu.expandItem(Constants.UNIVERSITIES_PARENT.getStr());
			mainMenu.addItem(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr());
			mainMenu.setChildrenAllowed(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr(), false);
			mainMenu.setParent(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr(), Constants.UNIVERSITIES_PARENT.getStr());
			mainMenu.addItem(Constants.LOG_OUT_PARENT.getStr());
			mainMenu.addItem(Constants.LOG_OUT.getStr());
			mainMenu.setChildrenAllowed(Constants.LOG_OUT.getStr(), false);
			mainMenu.setParent(Constants.LOG_OUT.getStr(), Constants.LOG_OUT_PARENT.getStr());
			addComponent(mainMenu);
			return this;
		}
		
		public void valueChange(ValueChangeEvent e){
			try{
				String tab = (String) e.getProperty().getValue();
				if(tab == null){
					return;
				}
				if(tab.compareTo(Constants.LOG_OUT.getStr()) == 0){
					SecurityContextHolder.clearContext();
					UI.getCurrent().getPage().setLocation(Constants.LOGIN_URL.getStr());
				}
				if(tab.compareToIgnoreCase(Constants.STUDENTS_ADD_STUDENT.getStr()) == 0
						|| tab.compareToIgnoreCase(Constants.STUDENTS_REMOVE_STUDENT.getStr()) == 0
						|| tab.compareToIgnoreCase(Constants.UNIVERSITIES_ADD_UNIVERSITY.getStr()) == 0){
					String path = tab.toLowerCase().replaceAll("\\s+", "");
					UiNavigator.navigate(path);
				} else{
					return;
				}
			} catch(Exception ex){
				LOG.info("Exception: " + e);
			}
		}
	}
	
	public Component buildComponent(){
		return new UniversityMenu().init().layout();
	}
}
