package com.unireg.ui.security;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path = SignupUi.PATH)
@Theme(SignupUi.THEME)
public class SignupUi extends UI {
	private static final long serialVersionUID = 1176981398310394304L;
	public static final String PATH = "/signup";
	public static final String THEME = "valo";
	@Autowired
	private SignupFactory signupFactory;
	
	@Override
	protected void init(VaadinRequest request){
		setContent(signupFactory.createComponent());
	}
}
