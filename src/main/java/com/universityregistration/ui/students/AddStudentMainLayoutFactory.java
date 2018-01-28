package com.universityregistration.ui.students;
import java.util.ArrayList;
import java.util.List;
import com.universityregistration.model.entity.Student;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {
	public class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener {
		private TextField fName;
		private TextField lName;
		private TextField age;
		private ComboBox<String> gender;
		private Button save;
		private Button clear;
		private Binder<Student> binder;
		private Student student;
		
		public AddStudentMainLayout init(){
			student = new Student();
			binder = new Binder<Student>(Student.class);
			fName = new TextField(Constants.FIRST_NAME.getStr());
			lName = new TextField(Constants.LAST_NAME.getStr());
			age = new TextField(Constants.AGE.getStr());
			gender = new ComboBox<String>(Constants.GENDER.getStr());
			// unis = new ComboBox(UniversityAttributes.UNIVERSITY.getStr());
			// unis.setWidth("100%");
			// fname.setNullRepresentation("");
			// lName.setNullRepresentation("");
			// age.setNullRepresentation("");
			fName.setValue(" ");
			lName.setValue(" ");
			save = new Button(Constants.SAVE.getStr());
			clear = new Button(Constants.CLEAR.getStr());
			save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clear.setStyleName(ValoTheme.BUTTON_PRIMARY);
			clear.addClickListener(this);
			save.addClickListener(this);
			List<String> genders = new ArrayList<>();
			genders.add(new String(Constants.FEMALE.getStr()));
			genders.add(new String(Constants.MALE.getStr()));
			gender.setItems(genders);
			return this;
		}
		
		public AddStudentMainLayout bind(){
			// fieldGroup.bindInstanceFields(this);
			// fieldGroup.w
			binder.forField(fName).withNullRepresentation("").bind("fName");
			binder.forField(lName).withNullRepresentation("").bind("lName");
			// binder.forField(fName).withNullRepresentation("").bind("fName");
			binder.setBean(student);
			return this;
		}
		
		public Component layout(){
			setMargin(true);
			GridLayout gL = new GridLayout(2, 3);
			gL.setSizeUndefined();
			gL.setSpacing(true);
			gL.addComponent(fName, 0, 0);
			gL.addComponent(lName, 1, 0);
			gL.addComponent(age, 0, 1);
			gL.addComponent(gender, 1, 1);
			// gL.addComponent(unis, 0, 2, 1, 2);
			gL.addComponent(new HorizontalLayout(clear, save), 0, 2);
			// age.clear();
			return gL;
		}
		
		@Override
		public void buttonClick(ClickEvent event){
			if(event.getButton() == this.save){
				saveStudent();
			} else{
				clearFields();
			}
		}
		
		private void clearFields(){
			Notification.show("In the clear");
			fName.setValue("");
			lName.setValue("");
			age.setValue("");
			gender.setValue("");
		}
		
		private void saveStudent(){
			try{
				binder.writeBean(student);
				Notification.show("In the save");
			} catch(ValidationException e){
				e.printStackTrace();
				return;
			}
		}
	}
	
	public Component createComponent(){
		return new AddStudentMainLayout().init().bind().layout();
	}
}
