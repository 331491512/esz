package com.esuizhen.cloudservice.followup.service.followupresult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgResultRes;
import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsSendReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TPatientContactInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.excption.ObjectAlreadyExistExcption;

public interface FollowupSmsResultService {

	public Page<TFollowupResultDetailInfo> queryFollowupResultDetail(FollowupResultDetailQueryReq req);
	
	public FollowupMsgResultRes sendSmsMassFollowup(FollowupMsgSendReq followupMsgSendReq);
	
	public void processFollowupSmsReply(TFollowupResultDetailInfo followupResultDetailInfo);

	public Page<TFollowupSmsReqInfo> queryFollowupSmsReply(FollowupSmsSendReq req);

	public void setInvalidSmsFollowup(Long reqId);

	public void modifyUserContactPhoneStatus(TPatientContactInfo patientContactInfo);

	public void replySmsFollowupResult(Map<String,Object> smsItemMap);

	public void replySmsFollowupResult(String fromMobile, String content, String recTime);

	public void receiptSmsSendState(List<SmsSendReportInfo> smsSendReportInfoList);

	Page<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req);

	List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req);

	Long statisFollowupResultTotal(FollowupResultStatisReq req);
	
	/**
	 * add by fanpanwei 查询随访短信答复记录
	 */
	public List<HashMap<String,String>> queryFollowupSmsRecord(FollowupSmsSendReq req);
	//add by fanpanwei 获取指定随访任务的短信回复的buff记录
	public HashMap<String,Object> queryFollowupBuffBySms(TFollowupSmsReqInfo followupSmsReqInfo);

	public FollowupMsgResultRes sendSpecifySmsFollowup(FollowupMsgSendReq followupMsgSendReq);

}
