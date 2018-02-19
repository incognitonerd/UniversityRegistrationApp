package com.universityregistration.ui.navigator;
import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UniversityNavigator extends Navigator {
	private static final long serialVersionUID = 1L;
	
	public UniversityNavigator(UI ui, SingleComponentContainer container){
		super(ui, container);
	}
	
	private static UniversityNavigator getNavigator(){
		UI ui = UI.getCurrent();
		Navigator navigator = ui.getNavigator();
		return (UniversityNavigator) navigator;
	}
	
	public static void navigate(String path){
		try{
			UniversityNavigator.getNavigator().navigateTo(path);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void navigateTo(String viewName){
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
