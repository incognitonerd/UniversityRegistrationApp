package com.unireg.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.Student;
import com.unireg.repo.addstudent.AddStuRepo;
import com.unireg.services.AddStuService;

@Service
@Transactional(readOnly = true)
public class AddStuServiceImpl implements AddStuService {
	private static final Logger LOG = LoggerFactory.getLogger(AddStuServiceImpl.class);
	@Autowired
	private AddStuRepo addStuRepo;
	
	@Transactional
	public void saveStu(Student stuDAO){
		try{
			Student stu = new Student();
			stu.setFirstName(stuDAO.getFirstName());
			stu.setLastName(stuDAO.getLastName());
			stu.setUniversity(stuDAO.getUniversity());
			stu.setGender(stuDAO.getGender());
			stu.setAge(stuDAO.getAge());
			addStuRepo.save(stu);
		} catch(Exception e){
			LOG.info("Exception: " + e);
		}
	}
}
