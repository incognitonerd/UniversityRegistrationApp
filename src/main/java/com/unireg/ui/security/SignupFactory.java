package com.unireg.ui.security;
import org.springframework.beans.factory.annotation.Autowired;
import com.unireg.services.RegisterUserService;
import com.unireg.utils.Constants;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class SignupFactory {
	@Autowired
	private RegisterUserService regUserService;
	
	private class SignupForm {
		private VerticalLayout vl;
		private Panel mainPanel;
		private TextField username;
		private PasswordField password1;
		private PasswordField password2;
		private Button signup;
		private Button cancel;
		
		public SignupForm init(){
			vl = new VerticalLayout();
			vl.setMargin(true);
			vl.setHeight("100%");
			mainPanel = new Panel(Constants.SIGN_UP.getStr());
			mainPanel.setSizeUndefined();
			signup = new Button(Constants.SIGN_UP.getStr());
			cancel = new Button(Constants.CANCEL.getStr());
			signup.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			cancel.setStyleName(ValoTheme.BUTTON_PRIMARY);
			username = new TextField(Constants.USERNAME.getStr());
			password1 = new PasswordField(Constants.PASSWORD.getStr());
			password2 = new PasswordField(Constants.PASSWORD.getStr());
			signup.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 689532066935231599L;
				
				public void buttonClick(ClickEvent event){
					Notification n;
					if(isValid()){
						try{
							regUserService.save(username.getValue(), password2.getValue());
						} catch(Exception e){
							String errMsg = username.getValue().toString() + Constants.IS_UNAVAILABLE.getStr();
							clearFields();
							n = new Notification(Constants.ERROR.getStr(), errMsg, Type.ERROR_MESSAGE, true);
							n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
							n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
							n.show(Page.getCurrent());
							return;
						}
						clearFields();
						n = new Notification(Constants.SUCCESSFULLY_REGISTERED.getStr(), Type.WARNING_MESSAGE);
						n.setStyleName(ValoTheme.NOTIFICATION_SUCCESS + " " + ValoTheme.NOTIFICATION_CLOSABLE);
						n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
						n.show(Page.getCurrent());
						// UI.getCurrent().getPage().setLocation(Constants.LOGIN_URL.getStr());
					}
					clearFields();
				}
			});
			cancel.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;
				
				public void buttonClick(ClickEvent event){
					clearFields();
					UI.getCurrent().getPage().setLocation(Constants.LOGIN_URL.getStr());
				}
			});
			return this;
		}
		
		public void clearFields(){
			username.clear();
			password1.clear();
			password2.clear();
		}
		
		public Boolean isValid(){
			Notification n;
			if(password2.getValue().isEmpty() || password1.getValue().isEmpty() || username.getValue().isEmpty()){
				n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION.getStr(),
						Type.ERROR_MESSAGE, true);
				n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
				return false;
			} else if(!password2.getValue().equals(password1.getValue())){
				n = new Notification(Constants.ERROR.getStr(), Constants.PASSWORDS_DO_NOT_MATCH.getStr(),
						Type.ERROR_MESSAGE, true);
				n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
				n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
				n.show(Page.getCurrent());
				return false;
			} else{
				return true;
			}
		}
		
		public Component layout(){
			vl.addComponent(mainPanel);
			vl.setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
			FormLayout signupLayout = new FormLayout();
			signupLayout.addComponent(username);
			signupLayout.addComponent(password1);
			signupLayout.addComponent(password2);
			signupLayout.addComponent(new HorizontalLayout(cancel, signup));
			signupLayout.setSizeUndefined();
			signupLayout.setMargin(true);
			mainPanel.setContent(signupLayout);
			return vl;
		}
	}
	
	public Component createComponent(){
		return new SignupForm().init().layout();
	}
}