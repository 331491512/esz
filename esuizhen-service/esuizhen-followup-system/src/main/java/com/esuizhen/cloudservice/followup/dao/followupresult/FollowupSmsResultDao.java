package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsSendReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;

public interface FollowupSmsResultDao {

	public List<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req);
	
	public List<TFollowupResultDetailInfo> queryFollowupResultDetail(FollowupResultDetailQueryReq req);
	
	public List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req);
	
	public Long statisFollowupResultTotal(FollowupResultStatisReq req);

	public int insertFollowupSmsReq(TFollowupSmsReqInfo followupSmsReqInfo);
	
	public int updateFollowupSmsReq(TFollowupSmsReqInfo followupSmsReqInfo);
	
	public List<TFollowupSmsReqInfo> queryFollowupSmsReply(Map<String,Object> paramsMap);
	
	public TFollowupSmsReqInfo queryFollowupSmsReqByMobileLast(String mobile);
	
	public Integer getFollowupSmsReqCount(Map<String,Object>searchParams);
	/**
	* @author fanpanwei
	* @date 2017年7月4日
	* @param 
	* @description:根据患者id和随访任务id获取本次的短息答复记录
	* @return
	 */
	public List<HashMap<String,String>> getFollowupSmsRecord(FollowupSmsSendReq req);
	/**
	* @author fanpanwei
	* @date 2017年7月6日
	* @param 
	* @description:记录所有回复短信
	* @return
	 */
	void addFollowupSmsReplyRecord(Map<String,Object> hm);
	/**
	* @author fanpanwei
	* @date 2017年7月10日
	* @param 
	* @description:获取指定随访任务的短信回复的buff记录
	* @return
	 */
	HashMap<String,Object> getFollowupBuffBySms(TFollowupSmsReqInfo followupSmsReqInfo);
	
}
