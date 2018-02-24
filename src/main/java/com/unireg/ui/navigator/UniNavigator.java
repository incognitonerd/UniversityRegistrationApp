package com.unireg.ui.navigator;
import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UniNavigator extends Navigator {
	private static final long serialVersionUID = 1L;
	
	public UniNavigator(UI ui, SingleComponentContainer container){
		super(ui, container);
	}
	
	private static UniNavigator getNavigator(){
		UI ui = UI.getCurrent();
		Navigator navigator = ui.getNavigator();
		return (UniNavigator) navigator;
	}
	
	public static void navigate(String path){
		try{
			UniNavigator.getNavigator().navigateTo(path);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void navigateTo(String viewName){
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
