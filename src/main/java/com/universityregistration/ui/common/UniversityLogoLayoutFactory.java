package com.universityregistration.ui.common;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversityLogoLayoutFactory implements UIComponentBuilder {
	private class LogoLayout extends VerticalLayout {
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
	
	@Override
	public Component createComponent(){
		return new LogoLayout().init().layout();
	}
}
