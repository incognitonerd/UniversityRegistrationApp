package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.Student;
import com.universityregistration.repository.addstudent.AddStuRepo;
import com.universityregistration.services.AddStuService;

@Service
public class AddStuServiceImpl implements AddStuService {
	@Autowired
	private AddStuRepo addStuRepo;
	
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
