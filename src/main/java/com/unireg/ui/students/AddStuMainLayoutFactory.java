package com.unireg.ui.students;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.Student;
import com.unireg.model.entities.University;
import com.unireg.services.AddStuService;
import com.unireg.services.ShowAllUnisService;
import com.unireg.utils.Constants;
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
public class AddStuMainLayoutFactory {
	private static final Logger LOG = LoggerFactory.getLogger(AddStuMainLayoutFactory.class);
	@Autowired
	private AddStuService addStuService;
	@Autowired
	private ShowAllUnisService showAllUnisService;
	
	private class AddStuMainLayout extends VerticalLayout implements ClickListener {
		private static final long serialVersionUID = 1L;
		// component names must match the model for the bind
		private TextField firstName;
		private TextField lastName;
		private TextField age;
		private ComboBox gender;
		private ComboBox university;
		private Button save;
		private Button cancel;
		private StuSavedListener stuSavedListener;
		private BeanFieldGroup<Student> beanGroup;
		private Student stu;
		private Notification n;
		
		public AddStuMainLayout(StuSavedListener stuSavedListener){
			this.stuSavedListener = stuSavedListener;
			this.stu = new Student();
		}
		
		public AddStuMainLayout init(){
			beanGroup = new BeanFieldGroup<Student>(Student.class);
			firstName = new TextField(Constants.ADD_STUDENT_FIRST_NAME.getStr());
			lastName = new TextField(Constants.ADD_STUDENT_LAST_NAME.getStr());
			age = new TextField(Constants.ADD_STUDENT_AGE.getStr());
			gender = new ComboBox(Constants.ADD_STUDENT_GENDER.getStr());
			university = new ComboBox(Constants.ADD_STUDENT_UNIVERSITY.getStr());
			university.setWidth("100%");
			firstName.setNullRepresentation("");
			lastName.setNullRepresentation("");
			age.setNullRepresentation("");
			save = new Button(Constants.SAVE.getStr(), this);
			cancel = new Button(Constants.CANCEL.getStr(), this);
			save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			cancel.setStyleName(ValoTheme.BUTTON_PRIMARY);
			gender.addItem(Constants.ADD_STUDENT_FEMALE.getStr());
			gender.addItem(Constants.ADD_STUDENT_MALE.getStr());
			return this;
		}
		
		public AddStuMainLayout bind(){
			try{
				beanGroup.bindMemberFields(this);
				beanGroup.setItemDataSource(stu);
				return this;
			} catch(Exception e){
				LOG.info("Exception: " + e);
				return null;
			}
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
			layout.addComponent(new HorizontalLayout(cancel, save), 0, 3);
			age.clear();
			return layout;
		}
		
		public void buttonClick(ClickEvent e){
			if(e.getSource() == this.save){
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
			if(isOperationInvalid()){
				blankFieldsErr();
			} else{
				saveStu();
			}
		}
		
		private void saveStu(){
			try{
				beanGroup.commit();
				addStuService.saveStu(stu);
				stuSavedListener.studentSaved();
				clearFields();
				successNotification();
			} catch(CommitException e){
				LOG.info("Exception: " + e);
				blankFieldsErr();
				return;
			}
		}
		
		public AddStuMainLayout load(){
			try{
				List<University> unis = showAllUnisService.getAllUnis();
				university.addItems(unis);
				return this;
			} catch(Exception e){
				LOG.info("Exception: " + e);
				return null;
			}
		}
		
		public void blankFieldsErr(){
			n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
					Type.ERROR_MESSAGE, true);
			n.setDelayMsec(Integer.parseInt(Constants.NEG_ONE.getStr()));
			n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.show(Page.getCurrent());
		}
		
		public void successNotification(){
			n = new Notification(Constants.SUCCESSFULLY_SAVED.getStr(), Type.WARNING_MESSAGE);
			n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.setDelayMsec(Integer.parseInt(Constants.NEG_ONE.getStr()));
			n.show(Page.getCurrent());
		}
		
		private boolean isOperationInvalid(){
			return showAllUnisService.getAllUnis().size() < 1 || firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()
					|| gender.isEmpty() || university.isEmpty();
		}
	}
	
	public Component createComponent(StuSavedListener stuSavedListener){
		return new AddStuMainLayout(stuSavedListener).init().load().bind().layout();
	}
}
