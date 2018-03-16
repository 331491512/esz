package com.esuizhen.cloudservice.followup.dao.followupdo;

import java.util.List;

import com.esuizhen.cloudservice.followup.bean.TelephoneRecordingReq;

public interface FollowupPhoneCallRecordDao {

	public int insertPhoneCallRecord(TelephoneRecordingReq phoneRecord);

	public int updatePhoneCallRecord(TelephoneRecordingReq phoneCallReq);

	public List<TelephoneRecordingReq> queryFollowupPhoneRecordList(TelephoneRecordingReq phoneCallReq);
}
