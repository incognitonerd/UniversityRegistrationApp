package com.unireg.ui.universities;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.model.entities.University;
import com.unireg.services.AddUniService;
import com.unireg.utils.Constants;
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
public class AddUniLayoutFactory {
	@Autowired
	private AddUniService addUniService;
	
	private class AddUniLayout extends VerticalLayout implements Button.ClickListener {
		private static final long serialVersionUID = 1L;
		// component names must match the model for the bind
		private TextField name;
		private TextField city;
		private TextField country;
		private Button cancel;
		private Button save;
		private BeanFieldGroup<University> beanGroup;
		private University uni;
		private UniSavedListener uniSavedListener;
		
		public AddUniLayout(UniSavedListener uniSavedListener){
			this.uniSavedListener = uniSavedListener;
			this.uni = new University();
		}
		
		public AddUniLayout init(){
			name = new TextField(Constants.ADD_UNIVERSITY_NAME.getStr());
			city = new TextField(Constants.ADD_UNIVERSITY_CITY.getStr());
			country = new TextField(Constants.ADD_UNIVERSITY_COUNTRY.getStr());
			save = new Button(Constants.SAVE.getStr(), this);
			save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			cancel = new Button(Constants.CANCEL.getStr(), this);
			cancel.setStyleName(ValoTheme.BUTTON_PRIMARY);
			name.setNullRepresentation("");
			city.setNullRepresentation("");
			country.setNullRepresentation("");
			return this;
		}
		
		public AddUniLayout bind(){
			beanGroup = new BeanFieldGroup<University>(University.class);
			beanGroup.bindMemberFields(this);
			beanGroup.setItemDataSource(uni);
			return this;
		}
		
		public Component layout(){
			setWidth("100%");
			GridLayout grid = new GridLayout(2, 4);
			grid.setSpacing(true);
			grid.addComponent(name, 0, 0, 1, 0);
			grid.addComponent(city, 0, 1, 1, 1);
			grid.addComponent(country, 0, 2, 1, 2);
			grid.addComponent(new HorizontalLayout(cancel, save), 0, 3, 0, 3);
			return grid;
		}
		
		public void buttonClick(ClickEvent e){
			if(e.getSource() == this.save){
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
				n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
			} else{
				saveUniversity();
			}
		}
		
		private void saveUniversity(){
			Notification n;
			try{
				beanGroup.commit();
			} catch(CommitException e){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE);
				n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
				return;
			}
			addUniService.addUni(uni);
			uniSavedListener.uniSaved();
			n = new Notification(Constants.SUCCESSFULLY_SAVED.getStr(), Type.WARNING_MESSAGE);
			n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
			n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
			n.show(Page.getCurrent());
			clearFields();
		}
		
		private boolean isOperationInValid(){
			return name.isEmpty() || country.isEmpty() || city.isEmpty();
		}
		
		private void clearFields(){
			name.setValue(null);
			city.setValue(null);
			country.setValue(null);
		}
	}
	
	public Component createComponent(UniSavedListener uniSavedListener){
		return new AddUniLayout(uniSavedListener).init().bind().layout();
	}
}
