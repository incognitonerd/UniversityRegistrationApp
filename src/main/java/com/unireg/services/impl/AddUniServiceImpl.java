package com.unireg.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.University;
import com.unireg.repo.adduniversity.AddUniRepo;
import com.unireg.services.AddUniService;

@Service
@Transactional(readOnly = true)
public class AddUniServiceImpl implements AddUniService {
	@Autowired
	private AddUniRepo addUniRepo;
	
	@Transactional
	public void addUni(University uniDAO){
		University uni = new University();
		uni.setName(uniDAO.getName());
		uni.setCity(uniDAO.getCity());
		uni.setCountry(uniDAO.getCountry());
		addUniRepo.save(uni);
	}
}
