package com.esuizhen.cloudservice.followup.service.followupresult;

import java.util.Date; 
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgResultRes;
import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupWxReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ObjectAlreadyExistExcption;

public interface FollowupWxResultService {

	public List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req);

	public Long statisFollowupResultTotal(FollowupResultStatisReq req);

	public FollowupMsgResultRes sendWxMassFollowup(FollowupMsgSendReq followupMsgSendReq);

	public Page<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req);

	Page<TFollowupResultDetailInfo> queryFollowupResultDetail(FollowupResultDetailQueryReq req);

	void replyWxFollowupResult(Map<String, Object> detailInfoMap, TFollowupWxReqInfo followupWxReqInfo);

	void scanWxReply();

	void saveSyncFromcloudResult(Integer hospitalId, Map<String, Object> syncFollowupResult);
	/**
	* @author fanpanwei
	* @date 2017年8月8日
	* @param 
	* @description:发送选中短信
	* @return
	 * @throws ObjectAlreadyExistExcption 
	 */
	public FollowupMsgResultRes sendSpecifyWxFollowup(FollowupMsgSendReq followupMsgSendReq);
}
