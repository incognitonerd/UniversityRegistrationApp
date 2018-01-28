package com.universityregistration.ui.navigator;
import com.google.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UniversityNavigator extends Navigator {
	public UniversityNavigator(UI ui, SingleComponentContainer container){
		super(ui, container);
	}
	
	public static void navigate(String path){
		try{
			UniversityNavigator.getNavigator().navigateTo(path);
		} catch(Exception e){
			e.printStackTrace();
			return;
		}
	}
	
	private static UniversityNavigator getNavigator(){
		UI ui = UI.getCurrent();
		Navigator nav = ui.getNavigator();
		return (UniversityNavigator) nav;
	}
	
	@Override
	public void navigateTo(String viewName){
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
