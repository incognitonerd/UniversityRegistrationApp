package com.unireg.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.Student;
import com.unireg.repo.addstudent.AddStuRepo;
import com.unireg.services.AddStuService;

@Service
@Transactional(readOnly = true)
public class AddStuServiceImpl implements AddStuService {
	@Autowired
	private AddStuRepo addStuRepo;
	
	@Transactional
	public void saveStu(Student stuDAO){
		Student stu = new Student();
		stu.setFirstName(stuDAO.getFirstName());
		stu.setLastName(stuDAO.getLastName());
		stu.setAge(stuDAO.getAge());
		stu.setGender(stuDAO.getGender());
		stu.setUniversity(stuDAO.getUniversity());
		addStuRepo.save(stu);
	}
}
