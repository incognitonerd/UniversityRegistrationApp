package com.unireg.ui.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class LoginFactory {
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;
	
	private class LoginForm {
		private VerticalLayout vl;
		private Panel mainPanel;
		private TextField username;
		private PasswordField password;
		private Button login;
		private Button signup;
		
		public LoginForm init(){
			vl = new VerticalLayout();
			vl.setMargin(true);
			vl.setHeight("100%");
			mainPanel = new Panel(Constants.LOGIN.getStr());
			mainPanel.setSizeUndefined();
			login = new Button(Constants.LOGIN.getStr());
			signup = new Button(Constants.SIGN_UP.getStr());
			login.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			signup.setStyleName(ValoTheme.BUTTON_PRIMARY);
			username = new TextField(Constants.USERNAME.getStr());
			password = new PasswordField(Constants.PASSWORD.getStr());
			return this;
		}
		
		public Component layout(){
			vl.addComponent(mainPanel);
			vl.setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
			FormLayout form = new FormLayout();
			form.addComponent(username);
			form.addComponent(password);
			form.addComponent(new HorizontalLayout(signup, login));
			form.setSizeUndefined();
			form.setMargin(true);
			login.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;
				
				public void buttonClick(ClickEvent event){
					Notification n;
					if(username.getValue().isEmpty() || password.getValue().isEmpty()){
						clearFields();
						n = new Notification(Constants.ERROR.getStr(), Constants.BLANK_FIELDS_SAVE_ERROR_DESCRIPTION
								.getStr(), Type.ERROR_MESSAGE, true);
						n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
						n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
						n.show(Page.getCurrent());
						return;
					}
					try{
						Authentication auth = new UsernamePasswordAuthenticationToken(username.getValue(), password
								.getValue());
						Authentication authenticate = daoAuthenticationProvider.authenticate(auth);
						SecurityContextHolder.getContext().setAuthentication(authenticate);
						UI.getCurrent().getPage().setLocation(Constants.UI_URL.getStr());
					} catch(AuthenticationException e){
						clearFields();
						n = new Notification(Constants.ERROR.getStr(), Constants.UNRECOGNIZED_USERNAME_PASSWORD.getStr(),
								Type.ERROR_MESSAGE, true);
						n.setDelayMsec(Integer.parseInt(Constants.TEN_SECS.getStr()));
						n.setStyleName(ValoTheme.NOTIFICATION_ERROR + " " + ValoTheme.NOTIFICATION_CLOSABLE);
						n.show(Page.getCurrent());
					}
				}
			});
			signup.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;
				
				public void buttonClick(ClickEvent event){
					UI.getCurrent().getPage().setLocation(Constants.SIGNUP_URL.getStr());
				}
			});
			mainPanel.setContent(form);
			return vl;
		}
		
		public void clearFields(){
			username.clear();
			password.clear();
		}
	}
	
	public Component createComponent(){
		return new LoginForm().init().layout();
	}
}
