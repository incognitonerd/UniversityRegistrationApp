package com.universityregistration.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.universityregistration.repository.adduniversity.UniStatsRepo;
import com.universityregistration.services.UniStatsService;

@Service
public class UniStatsServiceImpl implements UniStatsService {
	@Autowired
	private UniStatsRepo getUniStatsRepo;
	
	public Integer getStats(Integer universityId){
		return getUniStatsRepo.getNumOfStusForUniv(universityId);
	}
}
