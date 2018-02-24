package com.unireg.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.Student;
import com.unireg.repo.addstudent.ShowAllStuRepo;
import com.unireg.services.ShowStuService;

@Service
@Transactional(readOnly = true)
public class ShowStuServiceImpl implements ShowStuService {
	@Autowired
	private ShowAllStuRepo showAllStuRepo;
	
	public List<Student> getAllStu(){
		return showAllStuRepo.getAllStus();
	}
}
