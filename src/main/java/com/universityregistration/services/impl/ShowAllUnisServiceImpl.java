package com.universityregistration.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.University;
import com.universityregistration.repository.adduniversity.ShowAllUnisRepo;
import com.universityregistration.services.ShowAllUnisService;

@Service
public class ShowAllUnisServiceImpl implements ShowAllUnisService {
	@Autowired
	private ShowAllUnisRepo showAllUnisRepo;
	
	public List<University> getAllUnis(){
		return showAllUnisRepo.getAllUnis();
	}
}
