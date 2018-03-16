package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupResultQualityAnalysisDao;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultQualityAnalysisService;

@Service
public class FollowupResultQualityAnalysisServiceImpl implements FollowupResultQualityAnalysisService {
	@Autowired
	private FollowupResultQualityAnalysisDao followupResultQualityAnalysisDao;
	
	@Override
	public void flushFollowupResultQualityFlag() {
		followupResultQualityAnalysisDao.updateMoreDeathFollowupResultFlag();
		followupResultQualityAnalysisDao.updateDeathAfterHasFollowupResultFlag();
		followupResultQualityAnalysisDao.updateDeathBeforeHasFollowupResultFlag();
		followupResultQualityAnalysisDao.updateDeathNotFollowupResultFlag();
		followupResultQualityAnalysisDao.updateDeathNotFollowupTimeFlag();
		followupResultQualityAnalysisDao.updateDeathPatientIntoTask();
		followupResultQualityAnalysisDao.updateLostPatientIntoTask();
		followupResultQualityAnalysisDao.updateMedicalRecordNotFollowupResultFlag();
	}

}
