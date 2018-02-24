package com.unireg.ui.students;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.ui.commons.UniMainUI;
import com.unireg.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StuLayoutFactory.NAME, ui = UniMainUI.class)
public class StuLayoutFactory extends VerticalLayout implements View, StuSavedListener {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	@Autowired
	private AddStuMainLayoutFactory mainFactory;
	@Autowired
	private ShowAllStuLayoutFactory allStudentsFactory;
	
	private void addLayout(){
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		Component addStudentMainTab = mainFactory.createComponent(this);
		Component showStudentsTab = allStudentsFactory.createComponent();
		tabSheet.addTab(addStudentMainTab, Constants.ADD_STUDENT_MAIN_MENU.getStr());
		tabSheet.addTab(showStudentsTab, Constants.ADD_STUDENT_SHOW_ALL_STUDENTS.getStr());
		addComponent(tabSheet);
	}
	
	public void studentSaved(){
		allStudentsFactory.refreshTables();
	}
	
	public void enter(ViewChangeEvent event){
		removeAllComponents();
		addLayout();
	}
}