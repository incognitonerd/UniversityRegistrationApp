package com.unireg.ui.security;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path = LoginUi.PATH)
@Title(LoginUi.TITLE)
@Theme(LoginUi.THEME)
public class LoginUi extends UI {
	private static final long serialVersionUID = 1L;
	public static final String PATH = "/login";
	public static final String THEME = "valo";
	public static final String TITLE = "Zay's University App";
	@Autowired
	private LoginFactory loginFactory;
	
	@Override
	protected void init(VaadinRequest request){
		setContent(loginFactory.createComponent());
	}
}
