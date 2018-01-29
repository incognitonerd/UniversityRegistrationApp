package com.universityregistration.ui.universities;
import com.universityregistration.ui.common.MainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = UniversityLayoutFactory.NAME, ui = MainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View{
	public static final String NAME = "operations";
	
	public void enter(ViewChangeEvent event){
		addComponent(new Label("Operations Layout..."));
	}
}
