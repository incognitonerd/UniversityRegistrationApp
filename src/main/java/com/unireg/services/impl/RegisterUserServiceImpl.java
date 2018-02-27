package com.unireg.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.User;
import com.unireg.repo.security.LocateUserRepo;
import com.unireg.services.RegisterUserService;

@Service
@Transactional(readOnly = true)
public class RegisterUserServiceImpl implements RegisterUserService {
	private static final Logger LOG = LoggerFactory.getLogger(RegisterUserServiceImpl.class);
	@Autowired
	private LocateUserRepo locateUserRepo;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@Transactional
	public void save(String username, String password){
		try{
			User u = new User();
			u.setUsername(username);
			u.setPassword(pwEncoder.encode(password));
			locateUserRepo.save(u);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
}
