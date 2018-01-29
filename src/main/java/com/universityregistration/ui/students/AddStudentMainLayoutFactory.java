package com.universityregistration.ui.students;
import java.util.ArrayList;
import com.universityregistration.model.entity.Student;
import com.universityregistration.utils.constants.Constants;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
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
			age.setValue(" ");
			save = new Button(Constants.SAVE.getStr());
			clear = new Button(Constants.CLEAR.getStr());
			save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			clear.setStyleName(ValoTheme.BUTTON_PRIMARY);
			clear.addClickListener(this);
			save.addClickListener(this);
			ArrayList<String> genders = new ArrayList<>();
			genders.add(new String(Constants.FEMALE.getStr()));
			genders.add(new String(Constants.MALE.getStr()));
			gender.setItems(genders);
			return this;
		}
		
		public AddStudentMainLayout bind(){
			binder.forField(fName).withNullRepresentation("").withValidator(fName->fName.length() >= 0, "Cannot be blank!")
					.bind(Student::getfName, Student::setfName);
			binder.forField(lName).withNullRepresentation("").withValidator(lName->lName.length() >= 0, "Cannot be blank!")
					.bind(Student::getlName, Student::setlName);
			binder.forField(age).withNullRepresentation("").withConverter(new StringToIntegerConverter(age.toString()))
					.withValidator(age->age == null, "Cannot be blank!").withValidator(age->age > 0, "Invalid Age")
					.bind(Student::getAge, Student::setAge);
			binder.forField(gender).withNullRepresentation("")
					.withValidator(gender->gender.length() >= 0, "Cannot be blank!")
					.bind(Student::getGender, Student::setGender);
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
			age.clear();
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
			// Notification.show("In the clear");
			/*
			 * fName.clear(); lName.clear(); age.clear(); gender.clear();
			 */
			fName.setValue("");
			lName.setValue("");
			age.setValue("");
			gender.setValue("");
		}
		
		private void saveStudent(){
			try{
				// Notification.show("In the save");
				// binder.writeBeanIfValid(student);
				binder.writeBean(student);
			} catch(ValidationException e){
				Notification.show(Constants.ERROR.getStr(), Constants.STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE);
				return;
			}
			Notification.show("how did it make it here");
			clearFields();
		}
	}
	
	public Component createComponent(){
		return new AddStudentMainLayout().init().bind().layout();
	}
}
