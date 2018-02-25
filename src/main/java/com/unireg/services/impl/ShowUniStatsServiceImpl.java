package com.unireg.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unireg.repo.adduniversity.ShowUniStatsRepo;
import com.unireg.services.ShowUniStatsService;

@Service
@Transactional(readOnly = true)
public class ShowUniStatsServiceImpl implements ShowUniStatsService {
	@Autowired
	private ShowUniStatsRepo getUniStatsRepo;
	
	public Integer getStats(Integer uniId){
		return getUniStatsRepo.getNumOfStusForUni(uniId);
	}
}
