package com.universityregistration.ui;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("deprecation")
@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder {
	@SuppressWarnings("serial")
	private class UniverseMenu extends VerticalLayout {
		private Tree<String> mainMenu;
		private TreeData<String> mainMenuData;
		private TreeDataProvider<String> inMemoryDataProvider;
		
		public UniverseMenu init(){
			mainMenu = new Tree<>();
			mainMenuData = new TreeData<>();
			return this;
		}
		
		public UniverseMenu layout(){
			setWidth("100%");
			setHeight("100%");
			setMargin(false);
			// setHeight("100%");
			// Couple of childless root items
			// mainMenuData.addItem(null,"Mercury");
			// mainMenuData.addItem(null,"Venus");
			// Items with hierarchy
			mainMenuData.addItem(null, "STUDENT");
			mainMenuData.addItem("STUDENT", "Add Student");
			mainMenuData.addItem("STUDENT", "Remove Student");
			mainMenuData.addItem(null, "UNIVERSITY");
			mainMenuData.addItem("UNIVERSITY", "Operations");
			// mainMenuData.addItem("Mars", "Deimos");
			inMemoryDataProvider = new TreeDataProvider<>(mainMenuData);
			mainMenu.setDataProvider(inMemoryDataProvider);
			mainMenu.expand("STUDENT");
			mainMenu.expand("UNIVERSITY");
			/*
			 * mainMenuData.addItem("Add Student", "Student"); mainMenu.addItem("STUDENTS"); mainMenu.addItem("UNIVERSITIES"); mainMenu.expandItem("STUDENTS"); mainMenu.expandItem("UNIVERSITIES"); mainMenu.addItem("Add Student");
			 * mainMenu.addItem("Remove Student"); mainMenu.setChildrenAllowed("Add Student", false); mainMenu.setChildrenAllowed("Remove Student", false); mainMenu.setParent("Add Student", "STUDENT"); mainMenu.setParent("Remove Student", "STUDENT");
			 * mainMenu.addItem("Operations"); mainMenu.setChildrenAllowed("Operations", false); mainMenu.setParent("Operations", "UNIVERSITY");
			 */
			addComponent(mainMenu);
			return this;
		}
	}
	
	@Override
	public Component createComponent(){
		return new UniverseMenu().init().layout();
	}
}
