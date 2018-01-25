package com.universityregistration.ui;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = MainUI.NAME)
@Title("University App")
@Theme("valo")
public class MainUI extends UI {
	@Autowired
	private UniversityLogoLayoutFactory universeLogoLayoutFactory;
	@Autowired
	private UniversityMenuFactory universeMenuFactory;
	public static final String NAME = "/ui";
	private Panel changeTab;
	
	// entry point of the application
	@Override
	protected void init(VaadinRequest request){
		/*
		 * VerticalLayout rL = new VerticalLayout(); rL.addComponent(new Label("Zay's Web App Is Coming Soon! Dushi Bidaaaa!! boston")); setContent(rL);
		 */
		changeTab = new Panel();
		changeTab.setHeight("100%");
		// changeTab.setWidth("50%");
		//changeTab.setWidthUndefined();
		VerticalLayout rL = new VerticalLayout();
		rL.setSizeFull();
		rL.setMargin(true);
		Panel contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");
		//contentPanel.setHeightUndefined();
		Panel logoPanel = new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeightUndefined();
		HorizontalLayout hL = new HorizontalLayout();
		hL.setSizeFull();
		hL.setMargin(true);
		Component logo = universeLogoLayoutFactory.createComponent();
		Component menu = universeMenuFactory.createComponent();
		hL.addComponent(menu);
		hL.addComponent(changeTab);
		hL.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		hL.setComponentAlignment(menu, Alignment.TOP_LEFT);
		hL.setExpandRatio(menu, 1);
		hL.setExpandRatio(changeTab, 2);
		logoPanel.setContent(logo);
		contentPanel.setContent(hL);
		rL.addComponent(logoPanel);
		rL.addComponent(contentPanel);
		rL.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rL.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rL.setExpandRatio(contentPanel, 1);
		setContent(rL);
	}
}