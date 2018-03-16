package com.esuizhen.cloudservice.followup.service.followupresult.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.bean.QualityoflifeReq;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupQualityoflifeResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;

@Service
public class FollowupQualityoflifeResultServiceImp implements FollowupQualityoflifeResultService {

	@Autowired
	private FollowupResultService followupResultService;
	
	@Override
	public void saveFollowupQualityoflife(QualityoflifeReq req) {
		
		TFollowupResultDetailInfo followupResultDetailInfo=new TFollowupResultDetailInfo(); 
		followupResultDetailInfo.setPatientId(req.getPatientId());
		followupResultDetailInfo.setFollowupResultValue(4);
		followupResultDetailInfo.setIsInHospitalDeath(1);
		followupResultDetailInfo.setIsTumourDeath(req.getIsTumourDeath());
		followupResultDetailInfo.setFollowupWay(req.getFollowupWay());
		followupResultDetailInfo.setSourceFlag(8);//随访医生空间KPS死亡类型
		followupResultDetailInfo.setDeathDate(req.getDeathDate());
		followupResultDetailInfo.setOperator(req.getOperator());
		followupResultDetailInfo.setFollowupTime(new Date());
		
		followupResultService.insertFollowupResult(followupResultDetailInfo);
		followupResultService.insertFollowupResultBuff(followupResultDetailInfo);
	}

}
