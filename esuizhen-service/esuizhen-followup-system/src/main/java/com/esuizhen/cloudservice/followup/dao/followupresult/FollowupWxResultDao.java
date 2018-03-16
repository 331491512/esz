package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupWxReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultStatisInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;

public interface FollowupWxResultDao {

	public List<TFollowupResultStatisInfo> queryFollowupResultStatis(FollowupResultReq req);
	
	public List<TFollowupResultDetailInfo> queryFollowupResultDetail(FollowupResultDetailQueryReq req);
	
	public List<TFollowupResultValueInfo> statisFollowupResult(FollowupResultStatisReq req);
	
	public Long statisFollowupResultTotal(FollowupResultStatisReq req);
	
	public List<TFollowupWxReqInfo> queryFollowupWxReply(Map<String,Object>searchParams);
	
	public Integer insertFollowupWxReq(TFollowupWxReqInfo followupWxReqInfo);
	
	public Integer updateFollowupWxReq(TFollowupWxReqInfo followupWxReqInfo);

	public TFollowupWxReqInfo queryFollowupWxReqByMessageId(String messageId);

	public Integer getFollowupWxReqCount(Map<String, Object> searchParams);
}
