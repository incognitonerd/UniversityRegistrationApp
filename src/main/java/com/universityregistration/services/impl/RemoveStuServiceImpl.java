package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.Student;
import com.universityregistration.repository.removestudent.RemoveStuRepo;
import com.universityregistration.services.RemoveStuService;

@Service
public class RemoveStuServiceImpl implements RemoveStuService {
	@Autowired
	private RemoveStuRepo removeStuRepo;
	
	public void removeStu(Student stu){
		removeStuRepo.delete(stu);
	}
}
