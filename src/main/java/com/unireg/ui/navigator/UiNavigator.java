package com.unireg.ui.navigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class UiNavigator extends Navigator {
	private static final Logger LOG = LoggerFactory.getLogger(UiNavigator.class);
	private static final long serialVersionUID = 1L;
	
	public UiNavigator(UI ui, SingleComponentContainer container){
		super(ui, container);
	}
	
	private static UiNavigator getNavigator(){
		try{
			UI ui = UI.getCurrent();
			Navigator nav = ui.getNavigator();
			return (UiNavigator) nav;
		} catch(Exception e){
			LOG.info("Exception: " + e);
			return null;
		}
	}
	
	public static void navigate(String path){
		try{
			UiNavigator.getNavigator().navigateTo(path);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	@Override
	public void navigateTo(String viewName){
		super.navigateTo(Strings.nullToEmpty(viewName));
	}
}
