package com.universityregistration.ui.common;
import com.universityregistration.ui.navigator.UniversityNavigator;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ItemClick;
import com.vaadin.ui.Tree.ItemClickListener;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder {
	private class UniversityMenu extends VerticalLayout {
		private Tree<String> mainMenu;
		private TreeData<String> mainMenuData;
		private TreeDataProvider<String> inMemoryDataProvider;
		
		public UniversityMenu init(){
			mainMenu = new Tree<>();
			mainMenuData = new TreeData<>();
			mainMenu.addItemClickListener(new ItemClickListener<String>() {
				@Override
				public void itemClick(ItemClick<String> event){
					String selected = (event.getItem().toString());
					if(selected == null)
						return;
					String path = selected.toLowerCase().replaceAll("\\s+", "");
					UniversityNavigator.navigate(path);
					//Notification.show(selected);
				}
			});
			return this;
		}
		
		public UniversityMenu layout(){
			setWidth("100%");
			setHeight("100%");
			setMargin(false);
			mainMenuData.addItem(null, Constants.MENU_STUDENT.getStr());
			mainMenuData.addItem(Constants.MENU_STUDENT.getStr(), Constants.MENU_ADD_STUDENT.getStr());
			mainMenuData.addItem(Constants.MENU_STUDENT.getStr(), Constants.MENU_REMOVE_STUDENT.getStr());
			mainMenuData.addItem(null, Constants.MENU_UNIVERSITY.getStr());
			mainMenuData.addItem(Constants.MENU_UNIVERSITY.getStr(), Constants.MENU_OPERATIONS.getStr());
			inMemoryDataProvider = new TreeDataProvider<>(mainMenuData);
			mainMenu.setDataProvider(inMemoryDataProvider);
			mainMenu.expand(Constants.MENU_STUDENT.getStr());
			mainMenu.expand(Constants.MENU_UNIVERSITY.getStr());
			mainMenu.setSelectionMode(SelectionMode.SINGLE);
			addComponent(mainMenu);
			return this;
		}
	}
	
	@Override
	public Component createComponent(){
		return new UniversityMenu().init().layout();
	}
}
