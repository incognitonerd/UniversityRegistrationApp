package com.universityregistration.ui;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("deprecation")
@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder {
	@SuppressWarnings("serial")
	private class UniverseMenu extends VerticalLayout {
		// private Tree mainMenu;
		public UniverseMenu init(){
			// mainMenu = new Tree();
			return this;
		}
		
		public UniverseMenu layout(){
			/*
			 * setWidth("100%"); setHeightUndefined(); mainMenu.addItem("STUDENTS"); mainMenu.addItem("UNIVERSITIES"); mainMenu.expandItem("STUDENTS"); mainMenu.expandItem("UNIVERSITIES"); mainMenu.addItem("Add Student");
			 * mainMenu.addItem("Remove Student"); mainMenu.setChildrenAllowed("Add Student", false); mainMenu.setChildrenAllowed("Remove Student", false); mainMenu.setParent("Add Student", "STUDENT"); mainMenu.setParent("Remove Student", "STUDENT");
			 * mainMenu.addItem("Operations"); mainMenu.setChildrenAllowed("Operations", false); mainMenu.setParent("Operations", "UNIVERSITY"); addComponent(mainMenu);
			 */
			return this;
		}
	}
	
	@Override
	public Component createComponent(){
		return new UniverseMenu().init().layout();
	}
}
