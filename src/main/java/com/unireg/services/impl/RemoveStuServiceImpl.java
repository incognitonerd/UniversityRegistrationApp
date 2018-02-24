package com.unireg.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.Student;
import com.unireg.repo.removestudent.RemoveStuRepo;
import com.unireg.services.RemoveStuService;

@Service
@Transactional(readOnly = true)
public class RemoveStuServiceImpl implements RemoveStuService {
	@Autowired
	private RemoveStuRepo removeStuRepo;
	
	@Transactional
	public void removeStu(Student stu){
		removeStuRepo.delete(stu);
	}
}
