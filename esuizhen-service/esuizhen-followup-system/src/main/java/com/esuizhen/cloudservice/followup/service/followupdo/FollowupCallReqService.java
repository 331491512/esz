package com.esuizhen.cloudservice.followup.service.followupdo;

import java.util.Map;

import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;

public interface FollowupCallReqService {
	
	public void insertFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo);
	
	public void updateFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo);
	
	public TFollowupPhoneCallStatusInfo queryFollowupCallReqLast(Map<String,Object>searchParams);
}
