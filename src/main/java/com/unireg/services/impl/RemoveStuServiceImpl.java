package com.unireg.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.Student;
import com.unireg.repo.removestudent.RemoveStuRepo;
import com.unireg.services.RemoveStuService;

@Service
@Transactional(readOnly = true)
public class RemoveStuServiceImpl implements RemoveStuService {
	private static final Logger LOG = LoggerFactory.getLogger(RemoveStuServiceImpl.class);
	@Autowired
	private RemoveStuRepo removeStuRepo;
	
	@Transactional
	public void removeStu(Student stu){
		try{
			removeStuRepo.delete(stu);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
}
