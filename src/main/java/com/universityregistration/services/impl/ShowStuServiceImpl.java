package com.universityregistration.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.Student;
import com.universityregistration.repository.addstudent.ShowAllStuRepo;
import com.universityregistration.services.ShowStuService;

@Service
public class ShowStuServiceImpl implements ShowStuService {
	@Autowired
	private ShowAllStuRepo showAllStuRepo;
	
	public List<Student> getAllStu(){
		return showAllStuRepo.getAllStus();
	}
}
