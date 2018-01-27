package com.universityregistration.ui.students;
import com.universityregistration.ui.common.MainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutFactory.NAME, ui = MainUI.class)
public class StudentLayoutFactory extends VerticalLayout implements View {
	public static final String NAME = "addStudents";
	
	public void enter(ViewChangeEvent event){
		addComponent(new Label("Student Layout..."));
	}
}
