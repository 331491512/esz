/**
 * 
 */
package com.esuizhen.cloudservice.followup.service.followuptask;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.esuizhen.cloudservice.followup.bean.FollowupTask;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskOperatorAlloPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskCreateReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskStopReq;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.ParamMismatchExcption;

/**
 * @author bigdragon
 *
 */
public interface FollowupTaskService {

	Page<TFollowupTaskSimpleInfo> queryFollowupTaskListByLeader(
			TFollowupTaskListByLeaderQueryReq req);

	Page<TFollowupTaskSimpleInfo> queryFollowupTaskListByOperator(
			TFollowupTaskListByOperatorQueryReq req);

	TFollowupTaskDetailInfo queryFollowupTaskDetail(Long userId, String taskId,
			String assignId);

	Page<TFollowupPatientInfo> queryFollowupTaskPatientList(
			TFollowupTaskPatientListQueryReq req);

	String createFollowupTask(TFollowupTaskCreateReq req) throws ParamMismatchExcption;

	boolean stopFollowupTask(TFollowupTaskStopReq req);

	void underwayFollowupTask(String followupTaskId, String followupAssignId);

	List<FollowupTask> getMetaInfoFollowupTaskList();

	
	void updateFollowupTask(TFollowupTaskSimpleInfo req) throws ParamMismatchExcption;



	String createFollowupTaskForLastFollowup(TFollowupTaskCreateReq req)
			throws ParamMismatchExcption;
	/**
	 * 
	* @author fanpanwei
	* @date 2016年12月1日
	* @param 
	* @description: 更具带随访患者反查，最后随访各患者的随访员列表即其随访人数
	* @return
	 */
	List<HashMap<String, Object>> getOperatorsFollowUpInfoByPatients(FollowupTaskOperatorAlloPatientReq req);

	

}
