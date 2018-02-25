package com.unireg.model.entities;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	
	public CustomUser(String username, String password, boolean enabled, boolean accNonExpired,
			boolean credsNonExpired, boolean accNonLocked, Collection<? extends GrantedAuthority> auths){
		super(username, password, enabled, accNonExpired, credsNonExpired, accNonLocked, auths);
	}
}
