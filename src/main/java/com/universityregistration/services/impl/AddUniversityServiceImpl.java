package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entity.University;
import com.universityregistration.repository.university.AddUniversityRepository;
import com.universityregistration.services.AddUniversityService;

@Service
public class AddUniversityServiceImpl implements AddUniversityService {
	@Autowired
	private AddUniversityRepository addUniversityRepository;
	
	public void addUniversity(University uniDAO){
		University uni = new University();
		uni.setName(uniDAO.getName());
		uni.setCountry(uniDAO.getCountry());
		uni.setCity(uniDAO.getCity());
		addUniversityRepository.save(uni);
	}
}
