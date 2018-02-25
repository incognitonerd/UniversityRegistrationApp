package com.unireg.services.impl;
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
	@Autowired
	private LocateUserRepo locateUserRepo;
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@Transactional
	public void save(String username, String password){
		User u = new User();
		u.setUsername(username);
		u.setPassword(pwEncoder.encode(password));
		locateUserRepo.save(u);
	}
}
