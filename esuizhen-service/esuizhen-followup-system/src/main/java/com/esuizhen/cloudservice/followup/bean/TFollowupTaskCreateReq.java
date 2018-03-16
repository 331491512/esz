/**
 * 
 */
package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.followup.model.followup.TFollowupContentTemplateSimpleInfo;
import com.esuizhen.cloudservice.followup.model.followuptask.TFollowupTaskAssign;
import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireSimpleInfo;

/**
 * @author DaLoong
 * @date  2016-8-10 上午9:53:17
 */
public class TFollowupTaskCreateReq {

	Long   userId;
	String followupTaskName	;//	随访任务名称。必填。
	Integer totalPatientNum	;//	任务分配总人数。
	Date    planFinishTime	;//	预计完成时间。YYYY-MM-DD HH:MM:ss
	Integer searchId	;//查询Id
	Integer conditionId	;//	条件Id
	Integer diseaseTypeId; 
	//注：查询Id/条件Id 在患者常规筛选/高级筛选接口中返回。
	List<Long> patientIdList	;//待分配患者列表。当用户手动勾选了患者时有效。
	//注：searchId/conditionId 与 patientIdList两者有一个非空，取非空的那个。
	List<TFollowupTaskAssign> taskAssignList	;//任务分配列表。
	List<TFollowupContentTemplateSimpleInfo> contentTemplateList ;//		微信、短信模板列表
	//List<TQuestionnaireSimpleInfo> questionnaireTemplateList	;//	问卷模板列表
	
	private Integer isLastFollowupControl;
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the diseaseTypeId
	 */
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	/**
	 * @param diseaseTypeId the diseaseTypeId to set
	 */
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	/**
	 * @return the followupTaskName
	 */
	public String getFollowupTaskName() {
		return followupTaskName;
	}
	/**
	 * @param followupTaskName the followupTaskName to set
	 */
	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}
	/**
	 * @return the totalPatientNum
	 */
	public Integer getTotalPatientNum() {
		return totalPatientNum;
	}
	/**
	 * @param totalPatientNum the totalPatientNum to set
	 */
	public void setTotalPatientNum(Integer totalPatientNum) {
		this.totalPatientNum = totalPatientNum;
	}
	/**
	 * @return the planFinishTime
	 */
	public Date getPlanFinishTime() {
		return planFinishTime;
	}
	/**
	 * @param planFinishTime the planFinishTime to set
	 */
	public void setPlanFinishTime(Date planFinishTime) {
		this.planFinishTime = planFinishTime;
	}
	/**
	 * @return the searchId
	 */
	public Integer getSearchId() {
		return searchId;
	}
	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	/**
	 * @return the conditionId
	 */
	public Integer getConditionId() {
		return conditionId;
	}
	/**
	 * @param conditionId the conditionId to set
	 */
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	/**
	 * @return the patientIdList
	 */
	public List<Long> getPatientIdList() {
		return patientIdList;
	}
	/**
	 * @param patientIdList the patientIdList to set
	 */
	public void setPatientIdList(List<Long> patientIdList) {
		this.patientIdList = patientIdList;
	}
	/**
	 * @return the taskAssignList
	 */
	public List<TFollowupTaskAssign> getTaskAssignList() {
		return taskAssignList;
	}
	/**
	 * @param taskAssignList the taskAssignList to set
	 */
	public void setTaskAssignList(List<TFollowupTaskAssign> taskAssignList) {
		this.taskAssignList = taskAssignList;
	}
	/**
	 * @return the contentTemplateList
	 */
	public List<TFollowupContentTemplateSimpleInfo> getContentTemplateList() {
		return contentTemplateList;
	}
	/**
	 * @param contentTemplateList the contentTemplateList to set
	 */
	public void setContentTemplateList(
			List<TFollowupContentTemplateSimpleInfo> contentTemplateList) {
		this.contentTemplateList = contentTemplateList;
	}
	/**
	 * @return the questionnaireTemplateList
	 */
	/*public List<TQuestionnaireSimpleInfo> getQuestionnaireTemplateList() {
		return questionnaireTemplateList;
	}*/
	/**
	 * @param questionnaireTemplateList the questionnaireTemplateList to set
	 */
	/*public void setQuestionnaireTemplateList(
			List<TQuestionnaireSimpleInfo> questionnaireTemplateList) {
		this.questionnaireTemplateList = questionnaireTemplateList;
	}*/
	public Integer getIsLastFollowupControl() {
		return isLastFollowupControl;
	}
	public void setIsLastFollowupControl(Integer isLastFollowupControl) {
		this.isLastFollowupControl = isLastFollowupControl;
	}
	
}
