package com.universityregistration.ui.universities;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.ui.commons.UniMainUI;
import com.universityregistration.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

//ui tells it which view it belongs to
@SpringView(name = UniLayoutFactory.NAME, ui = UniMainUI.class)
public class UniLayoutFactory extends VerticalLayout implements View, UniSavedListener {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "adduniversity";
	private TabSheet tabSheet;
	@Autowired
	private AddUniLayoutFactory addUniversityFactory;
	@Autowired
	private ShowAllUniLayoutFactory showUniversitiesFactory;
	@Autowired
	private UniStatsLayoutFactory statisticsUniversityFactory;
	
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
