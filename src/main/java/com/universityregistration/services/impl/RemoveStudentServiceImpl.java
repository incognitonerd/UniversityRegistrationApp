package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.Student;
import com.universityregistration.repository.removestudent.RemoveStudentRepository;
import com.universityregistration.services.RemoveStudentService;

@Service
public class RemoveStudentServiceImpl implements RemoveStudentService {
	@Autowired
	private RemoveStudentRepository removeStudentRepository;
	
	public void removeStudent(Student student){
		removeStudentRepository.delete(student);
	}
}
