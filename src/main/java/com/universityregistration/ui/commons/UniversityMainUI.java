package com.universityregistration.ui.commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import com.universityregistration.ui.navigator.UniversityNavigator;
import com.universityregistration.ui.students.StudentLayoutFactory;
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

@SpringUI(path = UniversityMainUI.NAME)
@Title("University App")
@Theme("valo")
public class UniversityMainUI extends UI {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "/ui";
	private Component logo;
	private Component menu;
	private VerticalLayout rL;
	private Panel logoPanel;
	private Panel contentPanel;
	private HorizontalLayout hL;
	private UniversityNavigator nav;
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private SpringViewProvider viewProvider;
	@Autowired
	private UniversityMenuLayoutFactory menuFactory;
	@Autowired
	private UniversityLogoPanelLayoutFactory logoFactory;
	private Panel changeTab;
	
	// entry point of the application
	@Override
	protected void init(VaadinRequest request){
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
		logo = logoFactory.createComponent();
		menu = menuFactory.createComponent();
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
		initNavigator();
		setContent(rL);
	}
	
	private void initNavigator(){
		nav = new UniversityNavigator(this, changeTab);
		appContext.getAutowireCapableBeanFactory().autowireBean(nav);
		nav.addProvider(viewProvider);
		nav.navigateTo(StudentLayoutFactory.NAME);
	}
}
