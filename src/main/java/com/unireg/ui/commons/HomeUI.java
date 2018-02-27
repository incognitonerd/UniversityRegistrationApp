package com.unireg.ui.commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.unireg.ui.navigator.UiNavigator;
import com.unireg.ui.students.StuLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = HomeUI.NAME)
@Title(HomeUI.TITLE)
@Theme(HomeUI.THEME)
public class HomeUI extends UI {
	private static final Logger LOG = LoggerFactory.getLogger(HomeUI.class);
	private static final long serialVersionUID = 1L;
	public static final String NAME = "/home";
	public static final String TITLE = "Zay's University App";
	public static final String THEME = "valo";
	private Component logo;
	private Component menu;
	private VerticalLayout rL;
	private Panel logoPanel;
	private Panel contentPanel;
	private HorizontalLayout hL;
	private UiNavigator nav;
	// manually add an object to the app context
	@Autowired
	private ApplicationContext appContext;
	// autowire every class with the springview annotation
	@Autowired
	private SpringViewProvider viewProvider;
	@Autowired
	private MenuLayoutFactory menuFactory;
	@Autowired
	private LogoPanelLayoutFactory logoFactory;
	private Panel changeTab;
	
	// entry point of the application
	@Override
	protected void init(VaadinRequest r){
		/*
		 * VerticalLayout rL = new VerticalLayout(); rL.addComponent(new Label("Zay's Web App Is Coming Soon! Dushi Bidaaaa!! boston")); setContent(rL);
		 */
		changeTab = new Panel();
		changeTab.setHeight("100%");
		rL = new VerticalLayout();
		rL.setSizeFull();
		rL.setMargin(true);
		logoPanel = new Panel();
		logoPanel.setWidth("75%");
		logoPanel.setHeightUndefined();
		contentPanel = new Panel();
		contentPanel.setWidth("75%");
		contentPanel.setHeight("100%");
		hL = new HorizontalLayout();
		hL.setSizeFull();
		hL.setMargin(true);
		logo = logoFactory.buildComponent();
		menu = menuFactory.buildComponent();
		hL.addComponent(menu);
		hL.addComponent(changeTab);
		hL.setComponentAlignment(changeTab, Alignment.TOP_CENTER);
		hL.setComponentAlignment(menu, Alignment.TOP_LEFT);
		hL.setExpandRatio(menu, (float) .5);
		hL.setExpandRatio(changeTab, 1);
		logoPanel.setContent(logo);
		contentPanel.setContent(hL);
		rL.addComponent(logoPanel);
		rL.addComponent(contentPanel);
		rL.setComponentAlignment(contentPanel, Alignment.MIDDLE_CENTER);
		rL.setComponentAlignment(logoPanel, Alignment.TOP_CENTER);
		rL.setExpandRatio(contentPanel, 1);
		initNavigator();
		setContent(rL);
	}
	
	private void initNavigator(){
		try{
			nav = new UiNavigator(this, changeTab);
			appContext.getAutowireCapableBeanFactory().autowireBean(nav);
			nav.addProvider(viewProvider);
			nav.navigateTo(StuLayoutFactory.NAME);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
}
