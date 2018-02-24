package com.unireg.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.model.entities.University;
import com.unireg.repo.adduniversity.ShowAllUnisRepo;
import com.unireg.services.ShowAllUnisService;

@Service
@Transactional(readOnly = true)
public class ShowAllUnisServiceImpl implements ShowAllUnisService {
	@Autowired
	private ShowAllUnisRepo showAllUnisRepo;
	
	public List<University> getAllUnis(){
		return showAllUnisRepo.getAllUnis();
	}
}
