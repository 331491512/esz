/**
 * 
 */
package com.esuizhen.cloudservice.followup.dao.followuptask;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.FollowupTask;
import com.esuizhen.cloudservice.followup.bean.FollowupTaskOperatorAlloPatientReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByLeaderQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskListByOperatorQueryReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupTaskPatientListQueryReq;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssignPatient;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssignPatientSearchId;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskContentTemplateRelation;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskDetailInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskSimpleInfo;

/**
 * @author bigdragon
 * @date  2016-8-7 下午5:53:40
 */
public interface FollowupTaskDao {

	public List<TFollowupTaskSimpleInfo> queryFollowupTaskListByLeader(
			TFollowupTaskListByLeaderQueryReq req);

	public List<TFollowupTaskSimpleInfo> queryFollowupTaskEffectiveRate(
			List<String> ids);

	public List<TFollowupTaskSimpleInfo> queryFollowupTaskProgress(
			List<String> ids);
	
	public List<TFollowupTaskSimpleInfo> queryFollowupTaskListByOperator(
			TFollowupTaskListByOperatorQueryReq req);

	public TFollowupTaskDetailInfo queryFollowupTaskDetail(@Param("userId") Long userId,
			@Param("taskId") String taskId);

	public TFollowupTaskDetailInfo queryFollowupTaskAssignDetail(@Param("userId") Long userId,
			@Param("taskId") String taskId, @Param("assignId") String assignId);

	public List<TFollowupPatientInfo> queryFollowupTaskPatientList(
			TFollowupTaskPatientListQueryReq req);

	
	public void createFollowupTask(TFollowupTaskSimpleInfo taskInfo);

	public void createFollowupTaskAssign(List<TFollowupTaskAssign> list);
	
	public void updateFollowupTask(TFollowupTaskSimpleInfo taskInfo);
	
	public void updateFollowupTaskAssign(TFollowupTaskAssign taskAssignInfo);

	public void createFollowupTaskContentTemplate(
			List<TFollowupTaskContentTemplateRelation> taskTemplateList);

	public void createFollowupTaskAssignPatient(
			List<TFollowupTaskAssignPatient> taskPatientList);

	public void createFollowupTaskAssignPatientBySearchId(
			TFollowupTaskAssignPatientSearchId assignSearch);

	public void setSearchPatientFlag(
			TFollowupTaskAssignPatientSearchId assignSearch);

	public Integer queryFollowupTaskCreator(@Param("userId")Long userId,@Param("taskId")String taskId);

	public void stopFollowupTask(List<String> taskId);
	
	public int queryUnfinishedFollowupTaskCount(@Param("followupTaskId")String followupTaskId);
	
	public int queryUnfinishedFollowupTaskAssignCount(@Param("followupAssignId")String followupAssignId);

	public List<TFollowupTaskSimpleInfo> queryFollowupTaskAssignList(
			List<String> ids);

	/**
	 * <p>Title:recoverySearchTable</p>
	 * <p>Description:将宽表中相应的列置位</p>
	 * @author YYCHEN
	 * @date 2016年9月5日 下午2:28:03
	 * @param assignSearch
	 * @return
	 */
	public int recoverySearchTable(TFollowupTaskAssignPatientSearchId assignSearch);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryMetaFollowupTaskList
	 * @Description:查询随访计划元数据
	 * @return List<FollowupTask>
	 * @date 2016年9月14日 上午10:43:35
	 */
	public List<FollowupTask> queryMetaFollowupTaskList();

	public void createLastFollowupPatientBySearchId(TFollowupTaskAssignPatientSearchId assignSearch);
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年12月1日
	* @param 
	* @description：根具带随访患者和医生，查追随信息
	* @return
	 */
	public List<HashMap<String, Object>> queryEpigoneInfoByDOrP(FollowupTaskOperatorAlloPatientReq req);
	
	/**
	 * 
	* @author raox
	* @date 2016年12月9日
	* @param 
	* @description：将宽表中相应的列置位
	* @return
	 */
	public int recoveryLastFollowupPatientSearchTable(TFollowupTaskAssignPatientSearchId assignSearch);
	
	/**
	 * 
	* @author raox
	* @date 2016年12月9日
	* @param 
	* @description：获取末次随访患者ID列表
	* @return
	 */
	public List<Long> getLastFollowupPatientBySearchId(TFollowupTaskAssignPatientSearchId assignSearch);
	
	/**
	 * 
	 * @param followupTaskId
	 * @return
	 */
	public TFollowupTaskDetailInfo queryFollowupTaskByPrimaryKey(String followupTaskId);

}
