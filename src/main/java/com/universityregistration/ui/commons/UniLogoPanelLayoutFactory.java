package com.universityregistration.ui.commons;
import com.universityregistration.ui.views.ComponentBuilder;
import com.universityregistration.utils.Constants;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniLogoPanelLayoutFactory implements ComponentBuilder {
	private class LogoLayout extends VerticalLayout {
		private static final long serialVersionUID = 1L;
		private Embedded logo;
		
		public LogoLayout init(){
			logo = new Embedded();
			logo.setSource(new ThemeResource(Constants.LOGO_BANNER.getStr()));
			logo.setWidth("100%");
			logo.setHeight("100%");
			return this;
		}
		
		public LogoLayout layout(){
			addComponent(logo);
			setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
			setMargin(false);
			return this;
		}
	}
	
	public Component createComponent(){
		return new LogoLayout().init().layout();
	}
}
