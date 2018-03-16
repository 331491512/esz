/**
 * 
 */
package com.esuizhen.cloudservice.questionnaire.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.questionnaire.dao.FollowupTaskDao;
import com.esuizhen.cloudservice.questionnaire.service.FollowupTaskService;

/**
 * @author bigdragon 2016/8/6
 */
@Service
public class FollowupTaskServiceImpl implements FollowupTaskService {
	@Autowired
	FollowupTaskDao dao;

	/**
	 * 随访任务患者列表
	 */
	@Override
	public List<Map<String,Object>> queryFollowupTaskPatientList(FollowupMsgSendReq req) {
		List<Map<String,Object>> list = dao.queryFollowupTaskPatientList(req);
		return list;
	}

	@Override
	public Map<String, Number> queryUserByFollowupTaskId(String followupTaskId) {
		return dao.queryUserByFollowupTaskId(followupTaskId);
	}

	@Override
	public void updateFollowupTaskPatient(Map<String, Object> paramsMap) {
		dao.updateFollowupTaskPatient(paramsMap);
	}

}
