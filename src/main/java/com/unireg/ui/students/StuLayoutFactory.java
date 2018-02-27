package com.unireg.ui.students;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.ui.commons.HomeUI;
import com.unireg.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StuLayoutFactory.NAME, ui = HomeUI.class)
public class StuLayoutFactory extends VerticalLayout implements View, StuSavedListener {
	private static final Logger LOG = LoggerFactory.getLogger(StuLayoutFactory.class);
	private static final long serialVersionUID = 1L;
	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	@Autowired
	private AddStuMainLayoutFactory addStuMainFactory;
	@Autowired
	private ShowAllStuLayoutFactory showAllStusFactory;
	
	private void addLayout(){
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		Component addStuMainTab = addStuMainFactory.createComponent(this);
		Component showStusTab = showAllStusFactory.buildComponent();
		tabSheet.addTab(addStuMainTab, Constants.ADD_STUDENT_MAIN_MENU.getStr());
		tabSheet.addTab(showStusTab, Constants.ADD_STUDENT_SHOW_ALL_STUDENTS.getStr());
		addComponent(tabSheet);
	}
	
	public void studentSaved(){
		try{
			showAllStusFactory.refreshTables();
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
	
	public void enter(ViewChangeEvent e){
		removeAllComponents();
		addLayout();
	}
}