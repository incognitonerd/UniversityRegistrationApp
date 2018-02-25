package com.unireg.ui.universities;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.ui.commons.MainUI;
import com.unireg.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

//ui tells it which view it belongs to
@SpringView(name = UniLayoutFactory.NAME, ui = MainUI.class)
public class UniLayoutFactory extends VerticalLayout implements View, UniSavedListener {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "adduniversity";
	private TabSheet tabSheet;
	@Autowired
	private AddUniLayoutFactory addUniFactory;
	@Autowired
	private ShowAllUniLayoutFactory showUnisFactory;
	@Autowired
	private UniStatsLayoutFactory uniStatsFactory;
	
	private void addLayout(){
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		Component addUniTab = addUniFactory.createComponent(this);
		Component showUnisTab = showUnisFactory.buildComponent();
		Component uniStatsTab = uniStatsFactory.buildComponent();
		tabSheet.addTab(addUniTab, Constants.ADD_UNIVERSITY_MAIN_MENU.getStr());
		tabSheet.addTab(showUnisTab, Constants.MENU_SHOW_UNIVERSITY.getStr());
		tabSheet.addTab(uniStatsTab, Constants.MENU_CHART_UNIVERSITY.getStr());
		addComponent(tabSheet);
	}
	
	public void uniSaved(){
		showUnisFactory.refreshTables();
	}
	
	public void enter(ViewChangeEvent e){
		removeAllComponents();
		addLayout();
	}
}
