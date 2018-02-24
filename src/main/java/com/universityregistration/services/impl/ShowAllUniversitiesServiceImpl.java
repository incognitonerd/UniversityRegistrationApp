package com.universityregistration.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.model.entities.University;
import com.universityregistration.repository.adduniversity.ShowAllUniversitiesRepository;
import com.universityregistration.services.ShowAllUniversitiesService;

@Service
public class ShowAllUniversitiesServiceImpl implements ShowAllUniversitiesService {
	@Autowired
	private ShowAllUniversitiesRepository showAllUniversitiesRepository;
	
	public List<University> getAllUniversities(){
		return showAllUniversitiesRepository.getAllUniversities();
	}
}
