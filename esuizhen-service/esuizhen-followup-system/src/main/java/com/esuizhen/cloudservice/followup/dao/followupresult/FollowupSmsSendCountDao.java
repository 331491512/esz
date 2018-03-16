package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupSmsSendCountInfo;

public interface FollowupSmsSendCountDao {

	public List<TFollowupSmsSendCountInfo> queryFollowupSmsSendCount(Map<String,Object> searchParams);
	
	public void insertFollowupSmsSendCount(TFollowupSmsSendCountInfo info);
	
	public void updateFollowupSmsSendCount(TFollowupSmsSendCountInfo info);
}
