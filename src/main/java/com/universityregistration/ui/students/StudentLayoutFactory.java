package com.universityregistration.ui.students;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.ui.commons.UniversityMainUI;
import com.universityregistration.utils.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutFactory.NAME, ui = UniversityMainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View, StudentSavedListener {
	private static final long serialVersionUID = 1L;
	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	@Autowired
	private AddStudentMainLayoutFactory mainFactory;
	@Autowired
	private ShowAllStudentsLayoutFactory allStudentsFactory;
	
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