package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.Student;
import com.universityregistration.repository.addstudent.AddStudentRepository;
import com.universityregistration.services.AddStudentService;

@Service
public class AddStudentServiceImpl implements AddStudentService {
	@Autowired
	private AddStudentRepository addStudentRepository;
	
	public void saveStudent(Student studentDAO){
		Student stu = new Student();
		stu.setFirstName(studentDAO.getFirstName());
		stu.setLastName(studentDAO.getLastName());
		stu.setAge(studentDAO.getAge());
		stu.setGender(studentDAO.getGender());
		stu.setUniversity(studentDAO.getUniversity());
		addStudentRepository.save(stu);
	}
}
