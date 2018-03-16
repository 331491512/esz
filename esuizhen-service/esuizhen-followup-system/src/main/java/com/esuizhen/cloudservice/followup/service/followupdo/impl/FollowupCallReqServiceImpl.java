package com.esuizhen.cloudservice.followup.service.followupdo.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.dao.followupdo.FollowupCallReqDao;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupCallReqService;

@Service
public class FollowupCallReqServiceImpl implements FollowupCallReqService{

	@Autowired
	private FollowupCallReqDao followupCallReqDao;
	
	public void insertFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo){
		followupPhoneCallStatusInfo.setFollowupDate(new Date());
		this.followupCallReqDao.insertFollowupCallReq(followupPhoneCallStatusInfo);
	}

	@Override
	public void updateFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo) {
		followupCallReqDao.updateFollowupCallReq(followupPhoneCallStatusInfo);
	}

	@Override
	public TFollowupPhoneCallStatusInfo queryFollowupCallReqLast(Map<String, Object> searchParams) {
		return followupCallReqDao.queryFollowupCallReqLast(searchParams);
	}
	
}
