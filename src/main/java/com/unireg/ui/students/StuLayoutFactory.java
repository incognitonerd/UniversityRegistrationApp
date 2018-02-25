package com.unireg.ui.students;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.ui.commons.MainUI;
import com.unireg.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StuLayoutFactory.NAME, ui = MainUI.class)
public class StuLayoutFactory extends VerticalLayout implements View, StuSavedListener {
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
		showAllStusFactory.refreshTables();
	}
	
	public void enter(ViewChangeEvent e){
		removeAllComponents();
		addLayout();
	}
}