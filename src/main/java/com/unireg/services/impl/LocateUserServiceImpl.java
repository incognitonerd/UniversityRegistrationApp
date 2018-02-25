package com.unireg.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.unireg.model.entities.CustomUser;
import com.unireg.model.entities.User;
import com.unireg.repo.security.LocateUserRepo;

@Service
public class LocateUserServiceImpl implements UserDetailsService {
	@Autowired
	private LocateUserRepo locateUserRepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User u = locateUserRepo.locateByUsername(username);
		return new CustomUser(u.getUsername(), u.getPassword(), true, true, true, true, u.getAuthorities());
	}
}
