package com.universityregistration.ui.universities;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.ui.commons.UniversityMainUI;
import com.universityregistration.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = UniversityLayoutFactory.NAME, ui = UniversityMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View, UniversitySavedListener {
	public static final String NAME = "adduniversity";
	private TabSheet tabSheet;
	@Autowired
	private AddUniversityLayoutFactory addUniversityFactory;
	@Autowired
	private ShowUniversityLayoutFactory showUniversitiesFactory;
	@Autowired
	private StatisticsUniversityLayoutFactory statisticsUniversityFactory;
	
	private void addLayout(){
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		Component addUniversityTab = addUniversityFactory.createComponent(this);
		Component showUniversityTab = showUniversitiesFactory.createComponent();
		Component chartUniversityTab = statisticsUniversityFactory.createComponent();
		tabSheet.addTab(addUniversityTab, Constants.ADD_UNIVERSITY_MAIN_MENU.getStr());
		tabSheet.addTab(showUniversityTab, Constants.MENU_SHOW_UNIVERSITY.getStr());
		tabSheet.addTab(chartUniversityTab, Constants.MENU_CHART_UNIVERSITY.getStr());
		addComponent(tabSheet);
	}
	
	public void universitySaved(){
		showUniversitiesFactory.refreshTables();
	}
	
	public void enter(ViewChangeEvent event){
		removeAllComponents();
		addLayout();
	}
}
