package com.unireg.ui.navigator;
import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UiNavigator extends Navigator {
	private static final long serialVersionUID = 1L;
	
	public UiNavigator(UI ui, SingleComponentContainer container){
		super(ui, container);
	}
	
	private static UiNavigator getNavigator(){
		UI ui = UI.getCurrent();
		Navigator nav = ui.getNavigator();
		return (UiNavigator) nav;
	}
	
	public static void navigate(String path){
		try{
			UiNavigator.getNavigator().navigateTo(path);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void navigateTo(String viewName){
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
