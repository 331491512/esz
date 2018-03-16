/**
 * 
 */
package com.esuizhen.cloudservice.questionnaire.service;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;

/**
 * @author bigdragon
 *
 */
public interface FollowupTaskService {
	List<Map<String,Object>> queryFollowupTaskPatientList(
			FollowupMsgSendReq req);
	
	Map<String,Number> queryUserByFollowupTaskId(String followupTaskId);
	
	void updateFollowupTaskPatient(Map<String, Object> paramsMap);
}
