package com.unireg.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.University;
import com.unireg.repo.adduniversity.AddUniRepo;
import com.unireg.services.AddUniService;

@Service
@Transactional(readOnly = true)
public class AddUniServiceImpl implements AddUniService {
	private static final Logger LOG = LoggerFactory.getLogger(AddUniServiceImpl.class);
	@Autowired
	private AddUniRepo addUniRepo;
	
	@Transactional
	public void addUni(University uniDAO){
		try{
			University uni = new University();
			uni.setName(uniDAO.getName());
			uni.setCity(uniDAO.getCity());
			uni.setCountry(uniDAO.getCountry());
			addUniRepo.save(uni);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
}
