package com.esuizhen.cloudservice.followup.dao.followupdo;

import java.util.Map;

import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;

public interface FollowupCallReqDao {

	public void insertFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo);
	
	public void updateFollowupCallReq(TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo);
	
	public TFollowupPhoneCallStatusInfo queryFollowupCallReqLast(Map<String,Object>searchParams);
}
