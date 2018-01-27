package com.universityregistration.ui.common;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversityMenuFactory implements UIComponentBuilder {
	private class UniversityMenu extends VerticalLayout {// implements HasValue.ValueChangeListener {
		private Tree<String> mainMenu;
		private TreeData<String> mainMenuData;
		private TreeDataProvider<String> inMemoryDataProvider;
		
		public UniversityMenu init(){
			mainMenu = new Tree<>();
			mainMenuData = new TreeData<>();
			/*
			 * mainMenu.addItemClickListener(event->Notification.show("Click", Notification.Type.HUMANIZED_MESSAGE) );
			 */
			return this;
		}
		
		public UniversityMenu layout(){
			setWidth("100%");
			setHeight("100%");
			setMargin(false);
			mainMenuData.addItem(null, Constants.MENU_STUDENT.getString());
			mainMenuData.addItem(Constants.MENU_STUDENT.getString(), Constants.MENU_ADD_STUDENT.getString());
			mainMenuData.addItem(Constants.MENU_STUDENT.getString(), Constants.MENU_REMOVE_STUDENT.getString());
			mainMenuData.addItem(null, Constants.MENU_UNIVERSITY.getString());
			mainMenuData.addItem(Constants.MENU_UNIVERSITY.getString(), Constants.MENU_OPERATIONS.getString());
			inMemoryDataProvider = new TreeDataProvider<>(mainMenuData);
			mainMenu.setDataProvider(inMemoryDataProvider);
			mainMenu.expand(Constants.MENU_STUDENT.getString());
			mainMenu.expand(Constants.MENU_UNIVERSITY.getString());
			addComponent(mainMenu);
			return this;
		}
		/*
		 * @Override public void valueChange(ValueChangeEvent event){ // TODO Auto-generated method stub }
		 */
	}
	
	@Override
	public Component createComponent(){
		return new UniversityMenu().init().layout();
	}
}
