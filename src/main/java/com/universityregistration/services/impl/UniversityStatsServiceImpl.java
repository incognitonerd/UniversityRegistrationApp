package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.repository.adduniversity.UniversityStatisticsRepository;
import com.universityregistration.services.UniversityStatsService;

@Service
public class UniversityStatsServiceImpl implements UniversityStatsService {
	@Autowired
	private UniversityStatisticsRepository getUniversityStatisticsRepository;
	
	public Integer getStatistics(Integer universityId){
		return getUniversityStatisticsRepository.getNumOfStudentsForUniversity(universityId);
	}
}
