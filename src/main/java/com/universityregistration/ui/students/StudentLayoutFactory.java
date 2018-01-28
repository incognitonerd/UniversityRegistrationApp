package com.universityregistration.ui.students;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.ui.common.MainUI;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutFactory.NAME, ui = MainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {
	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	@Autowired
	private AddStudentMainLayoutFactory asmlf;
	
	public void enter(ViewChangeEvent event){
		removeAllComponents();
		addLayout();
	}
	
	private void addLayout(){
		setMargin(true);
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		// Component addStudentTab = new Label("main menu tab");
		Component showStudentsTab = new Label("show students tab");
		Component addStudentTab = asmlf.createComponent();
		tabSheet.addTab(addStudentTab, Constants.STUDENT_MAIN_MENU.getStr());
		tabSheet.addTab(showStudentsTab, Constants.STUDENT_SHOW_ALL_STUDENTS.getStr());
		addComponent(tabSheet);
	}
}
