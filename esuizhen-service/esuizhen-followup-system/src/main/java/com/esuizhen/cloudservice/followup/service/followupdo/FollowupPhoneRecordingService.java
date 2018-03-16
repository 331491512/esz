package com.esuizhen.cloudservice.followup.service.followupdo;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.TelephoneRecordingReq;

public interface FollowupPhoneRecordingService {

	/**
	 * 保存电话录音记录
	 * 
	 * @param phoneCallReq
	 * @return
	 */
	public int savePhoneRecording(TelephoneRecordingReq phoneCallReq);

	public int updatePhoneCallRecord(TelephoneRecordingReq phoneCallReq);

	public List<TelephoneRecordingReq> queryFollowupPhoneRecordList(TelephoneRecordingReq phoneCallReq);
}
