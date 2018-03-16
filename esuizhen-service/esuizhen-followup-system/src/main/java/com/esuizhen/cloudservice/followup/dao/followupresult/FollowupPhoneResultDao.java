package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.TFollowupPhoneResultSearchInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupTaskPatient;

public interface FollowupPhoneResultDao {

	public List<TFollowupResultDetailInfo> queryFollowupPhoneResult(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo);

	public List<TFollowupResultValueInfo> statisFollowupPhoneResult(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo);

	public Long statisFollowupPhoneResultTotal(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo);
	
	public Integer statisFollowupOperatorTotal(TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo);

	public TFollowupTaskPatient queryFollowupTaskPatient(Map<String,Object> searchInfo);

	public TFollowupTaskPatient queryFirstFollowupTaskPatient(Map<String,Object> searchInfo);

	public TFollowupTaskPatient queryLastFollowupTaskPatient(Map<String,Object> searchInfo);
}
