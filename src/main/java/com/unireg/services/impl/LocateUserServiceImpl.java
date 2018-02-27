package com.unireg.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG = LoggerFactory.getLogger(LocateUserServiceImpl.class);
	@Autowired
	private LocateUserRepo locateUserRepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		try{
			User u = locateUserRepo.locateByUsername(username);
			return new CustomUser(u.getUsername(), u.getPassword(), true, true, true, true, u.getAuthorities());
		} catch(Exception e){
			LOG.info("Exception: " + e);
			return null;
		}
	}
}
