package com.universityregistration.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entity.Student;
import com.universityregistration.repository.addstudent.ShowAllStudentsRepository;
import com.universityregistration.services.ShowStudentsService;

@Service
public class ShowStudentsServiceImpl implements ShowStudentsService {
	@Autowired
	private ShowAllStudentsRepository showAllStudentsRepository;
	
	public List<Student> getAllStudents(){
		return showAllStudentsRepository.getAllStudents();
	}
}
