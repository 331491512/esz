package com.esuizhen.cloudservice.followup.service.followupdo;

import com.esuizhen.cloudservice.followup.bean.FollowupPhoneCallIncomingQueryReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallIncomingInfo;
import com.westangel.common.bean.Page;

public interface FollowupCallIncomingService {

	public TFollowupPhoneCallIncomingInfo insertFollowupCallIncoming(TFollowupPhoneCallIncomingInfo followupPhoneCallIncomingInfo);
	
	Page<TFollowupPhoneCallIncomingInfo> queryFollowupCallIncoming(FollowupPhoneCallIncomingQueryReq req);
	
	/**
	 * 修改来电患者的状态
	 * @author zhuguo
	 * @date 2017-8-9 17:40:45
	 * @param patientId
	 * @param taskId
	 * @param callIncomingPhone
	 * @return
	 */
	public int patienPhoneCallIncomingStateModify(String incomingCallId);
}
