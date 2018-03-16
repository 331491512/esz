package com.esuizhen.cloudservice.followup.dao.followupdo;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupPhoneCallIncomingQueryReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallIncomingInfo;

public interface FollowupCallIncomingDao {

	public void insertFollowupCallIncoming(TFollowupPhoneCallIncomingInfo followupPhoneCallIncomingInfo);

	public List<TFollowupPhoneCallIncomingInfo> queryFollowupCallIncoming(FollowupPhoneCallIncomingQueryReq req);

	/**
	 * 修改来电患者的状态
	 * 
	 * @author zhuguo
	 * @date 2017-8-9 17:40:45
	 * @param patientId
	 * @param taskId
	 * @param callIncomingPhone
	 * @return
	 */
	public Integer patienPhoneCallIncomingStateModify(Map<String, Object> map);
	public Integer queryRepeatCallIncoming(TFollowupPhoneCallIncomingInfo followupPhoneCallIncomingInfo);
}
