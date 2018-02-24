package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.University;
import com.universityregistration.repository.adduniversity.AddUniRepo;
import com.universityregistration.services.AddUniService;

@Service
public class AddUniServiceImpl implements AddUniService {
	@Autowired
	private AddUniRepo addUniRepo;
	
	public void addUni(University uniDAO){
		University uni = new University();
		uni.setName(uniDAO.getName());
		uni.setCountry(uniDAO.getCountry());
		uni.setCity(uniDAO.getCity());
		addUniRepo.save(uni);
	}
}
