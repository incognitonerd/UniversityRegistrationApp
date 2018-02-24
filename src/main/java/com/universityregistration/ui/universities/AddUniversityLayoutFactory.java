package com.universityregistration.ui.universities;
import org.springframework.beans.factory.annotation.Autowired;
import com.universityregistration.model.entities.University;
import com.universityregistration.services.AddUniversityService;
import com.universityregistration.utils.Constants;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class AddUniversityLayoutFactory {
	@Autowired
	private AddUniversityService addUniversityService;
	
	private class AddUniversityLayout extends VerticalLayout implements Button.ClickListener {
		private static final long serialVersionUID = 1L;
		private TextField name;
		private TextField country;
		private TextField city;
		private Button cancelButton;
		private Button saveButton;
		private BeanFieldGroup<University> fieldGroup;
		private University university;
		private UniversitySavedListener universitySavedListener;
		
		public AddUniversityLayout(UniversitySavedListener universitySavedListener){
			this.universitySavedListener = universitySavedListener;
			this.university = new University();
		}
		
		public AddUniversityLayout init(){
			name = new TextField(Constants.ADD_UNIVERSITY_NAME.getStr());
			country = new TextField(Constants.ADD_UNIVERSITY_COUNTRY.getStr());
			city = new TextField(Constants.ADD_UNIVERSITY_CITY.getStr());
			saveButton = new Button(Constants.SAVE.getStr(), this);
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			cancelButton = new Button(Constants.CANCEL.getStr(), this);
			cancelButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
			name.setNullRepresentation("");
			country.setNullRepresentation("");
			city.setNullRepresentation("");
			return this;
		}
		
		public AddUniversityLayout bind(){
			fieldGroup = new BeanFieldGroup<University>(University.class);
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(university);
			return this;
		}
		
		public Component layout(){
			setWidth("100%");
			GridLayout grid = new GridLayout(2, 4);
			// grid.setHeightUndefined();
			grid.setSpacing(true);
			grid.addComponent(name, 0, 0, 1, 0);
			grid.addComponent(country, 0, 1, 1, 1);
			grid.addComponent(city, 0, 2, 1, 2);
			grid.addComponent(new HorizontalLayout(cancelButton, saveButton), 0, 3, 0, 3);
			return grid;
		}
		
		public void buttonClick(ClickEvent event){
			if(event.getSource() == this.saveButton){
				save();
			} else{
				clearFields();
			}
		}
		
		private void save(){
			Notification n;
			if(isOperationInValid()){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE);
				n.setDelayMsec(200000);
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
			} else{
				saveUniversity();
			}
		}
		
		private void saveUniversity(){
			Notification n;
			try{
				fieldGroup.commit();
			} catch(CommitException e){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE);
				n.setDelayMsec(200000);
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
				return;
			}
			addUniversityService.addUniversity(university);
			universitySavedListener.universitySaved();
			n = new Notification(Constants.SUCCESSFULLY_SAVED.getStr(), Type.WARNING_MESSAGE);
			n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.setDelayMsec(200000);
			n.show(Page.getCurrent());
			clearFields();
		}
		
		private boolean isOperationInValid(){
			return name.isEmpty() || country.isEmpty() || city.isEmpty();
		}
		
		private void clearFields(){
			name.setValue(null);
			country.setValue(null);
			city.setValue(null);
		}
	}
	
	public Component createComponent(UniversitySavedListener universitySavedListener){
		return new AddUniversityLayout(universitySavedListener).init().bind().layout();
	}
}
