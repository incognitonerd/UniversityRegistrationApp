package com.universityregistration.ui.students;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entities.Student;
import com.universityregistration.model.entities.University;
import com.universityregistration.services.AddStudentService;
import com.universityregistration.services.ShowAllUniversitiesService;
import com.universityregistration.utils.Constants;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
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
	@Autowired
	private AddStudentService addStudentService;
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	private class AddStudentMainLayout extends VerticalLayout implements ClickListener {
		private static final long serialVersionUID = 1L;
		private TextField firstName;
		private TextField lastName;
		private TextField age;
		private ComboBox gender;
		private Button saveButton;
		private Button cancelButton;
		private ComboBox university;
		private StudentSavedListener studentSavedListener;
		private BeanFieldGroup<Student> fieldGroup;
		private Student student;
		
		public AddStudentMainLayout(StudentSavedListener studentSavedListener){
			this.studentSavedListener = studentSavedListener;
			this.student = new Student();
		}
		
		public AddStudentMainLayout init(){
			fieldGroup = new BeanFieldGroup<Student>(Student.class);
			firstName = new TextField(Constants.ADD_STUDENT_FIRST_NAME.getStr());
			lastName = new TextField(Constants.ADD_STUDENT_LAST_NAME.getStr());
			age = new TextField(Constants.ADD_STUDENT_AGE.getStr());
			gender = new ComboBox(Constants.ADD_STUDENT_GENDER.getStr());
			university = new ComboBox(Constants.ADD_STUDENT_UNIVERSITY.getStr());
			university.setWidth("100%");
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			age.setNullRepresentation("");
			saveButton = new Button(Constants.SAVE.getStr(), this);
			cancelButton = new Button(Constants.CANCEL.getStr(), this);
			// cancelButton.addClickListener(this);
			// saveButton.addClickListener(this);
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			cancelButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			gender.addItem(Constants.ADD_STUDENT_FEMALE.getStr());
			gender.addItem(Constants.ADD_STUDENT_MALE.getStr());
			return this;
		}
		
		public AddStudentMainLayout bind(){
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(student);
			return this;
		}
		
		public Component layout(){
			setMargin(true);
			GridLayout layout = new GridLayout(2, 4);
			layout.setSpacing(true);
			layout.addComponent(firstName, 0, 0);
			layout.addComponent(lastName, 1, 0);
			layout.addComponent(age, 0, 1);
			layout.addComponent(gender, 1, 1);
			layout.addComponent(university, 0, 2, 1, 2);
			layout.addComponent(new HorizontalLayout(cancelButton, saveButton), 0, 3);
			age.clear();
			return layout;
		}
		
		public void buttonClick(ClickEvent event){
			if(event.getSource() == this.saveButton){
				save();
			} else{
				clearFields();
			}
		}
		
		private void clearFields(){
			firstName.setValue(null);
			lastName.setValue(null);
			age.setValue(null);
			gender.setValue(null);
			university.setValue(null);
		}
		
		private void save(){
			Notification n;
			if(!isOperationValid()){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE, true);
				n.setDelayMsec(200000);
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
			} else{
				saveStudent();
			}
		}
		
		private void saveStudent(){
			Notification n;
			try{
				fieldGroup.commit();
			} catch(CommitException e){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE, true);
				n.setDelayMsec(200000);
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
				return;
			}
			addStudentService.saveStudent(student);
			studentSavedListener.studentSaved();
			n = new Notification(Constants.SUCCESSFULLY_SAVED.getStr(), Type.WARNING_MESSAGE);
			n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.setDelayMsec(200000);
			n.show(Page.getCurrent());
			clearFields();
		}
		
		public AddStudentMainLayout load(){
			List<University> universities = showAllUniversitiesService.getAllUniversities();
			university.addItems(universities);
			return this;
		}
	}
	
	private boolean isOperationValid(){
		return showAllUniversitiesService.getAllUniversities().size() != 0;
	}
	
	public Component createComponent(StudentSavedListener studentSavedListener){
		return new AddStudentMainLayout(studentSavedListener).init().load().bind().layout();
	}
}
