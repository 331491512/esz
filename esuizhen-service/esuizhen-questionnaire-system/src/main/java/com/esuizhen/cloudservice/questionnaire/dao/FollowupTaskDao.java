/**
 * 
 */
package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;

/**
 * @author yuanwenming
 * @date  2016-8-7 下午5:53:40
 */
public interface FollowupTaskDao {
	public List<Map<String,Object>> queryFollowupTaskPatientList(FollowupMsgSendReq req);

	Map<String,Number> queryUserByFollowupTaskId(@Param("followupTaskId")String followupTaskId);
	
	void updateFollowupTaskPatient(Map<String, Object> paramsMap);
}
