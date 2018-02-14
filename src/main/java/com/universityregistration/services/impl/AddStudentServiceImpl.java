package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entity.Student;
import com.universityregistration.repository.addstudent.AddStudentRepository;
import com.universityregistration.services.AddStudentService;

@Service
public class AddStudentServiceImpl implements AddStudentService {
	@Autowired
	private AddStudentRepository addStudentRepository;
	
	public void saveStudent(Student studentDAO){
		Student student = new Student();
		student.setFirstName(studentDAO.getFirstName());
		student.setLastName(studentDAO.getLastName());
		student.setAge(studentDAO.getAge());
		student.setGender(studentDAO.getGender());
		student.setUniversity(studentDAO.getUniversity());
		addStudentRepository.save(student);
	}
}
