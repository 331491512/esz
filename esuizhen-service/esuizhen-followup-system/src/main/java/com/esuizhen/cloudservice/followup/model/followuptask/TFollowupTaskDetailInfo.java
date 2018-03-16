/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

import java.util.Date;
import java.util.List;

/**
 * @author DaLoong
 * @date  2016-8-9 下午12:36:16
 */
public class TFollowupTaskDetailInfo {
	String followupTaskId	;	//随访任务ID。
	String followupAssignId	;	//随访任务ID。
	String followupTaskName	;	//随访任务名称
	Integer followupType	;   //	随访任务类型。
	 //1：常规随访（默认）；2：专题随访
	Date planFinishTime	;//任务预计完成时间。
	Date finishTime		;//实际完成(结束/终止)时间
	Date beginTime		;//随访开始时间
	Integer creator		;//任务创建人。(注：非任务执行人）
	Integer state	;//任务状态：
	/*0：未开始（默认）；
	1：进行中； 
	2：已完成
	3：已终止*/
	Integer diseaseTypeId	; //任务对应的病种。
	//按病种分配任务时记录。
	Integer totalPatientNum; //总患者数（随访任务量）。
	 //当随访主任角色查看时，为任务表中的随访患者总量；
	 //当随访人员角色查看时，为任务分配表中的随访患者总量。
	Integer operatorNum	; //	随访人员数量
	//全局随访周期。即任务详情页的最近 xx 天就诊患者。
	Integer followupTaskCycle;
	//就诊患者数
	Integer outPatientNum;
	//本任务就诊患者数
	Integer thisTaskOutPatientNum;
	List<TFollowupTaskAssign>  followupTaskAssignList;//随访人员列表
	
	List<TFollowupTaskContentTemplateRelation> contentTemplateList;
	Float progress;       //随访进度。如0.1，表示随访完成10%。
	Float effectiveRate;  //	随访有效率。如0.8，表示随访有效率为80%。
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public String getFollowupAssignId() {
		return followupAssignId;
	}
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}
	public String getFollowupTaskName() {
		return followupTaskName;
	}
	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}
	public Integer getFollowupType() {
		return followupType;
	}
	public void setFollowupType(Integer followupType) {
		this.followupType = followupType;
	}
	public Date getPlanFinishTime() {
		return planFinishTime;
	}
	public void setPlanFinishTime(Date planFinishTime) {
		this.planFinishTime = planFinishTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public Integer getTotalPatientNum() {
		return totalPatientNum;
	}
	public void setTotalPatientNum(Integer totalPatientNum) {
		this.totalPatientNum = totalPatientNum;
	}
	public Integer getOperatorNum() {
		return operatorNum;
	}
	public void setOperatorNum(Integer operatorNum) {
		this.operatorNum = operatorNum;
	}
	public Integer getFollowupTaskCycle() {
		return followupTaskCycle;
	}
	public void setFollowupTaskCycle(Integer followupTaskCycle) {
		this.followupTaskCycle = followupTaskCycle;
	}
	public Integer getOutPatientNum() {
		return outPatientNum;
	}
	public void setOutPatientNum(Integer outPatientNum) {
		this.outPatientNum = outPatientNum;
	}
	public Integer getThisTaskOutPatientNum() {
		return thisTaskOutPatientNum;
	}
	public void setThisTaskOutPatientNum(Integer thisTaskOutPatientNum) {
		this.thisTaskOutPatientNum = thisTaskOutPatientNum;
	}
	public List<TFollowupTaskAssign> getFollowupTaskAssignList() {
		return followupTaskAssignList;
	}
	public void setFollowupTaskAssignList(
			List<TFollowupTaskAssign> followupTaskAssignList) {
		this.followupTaskAssignList = followupTaskAssignList;
	}
	public List<TFollowupTaskContentTemplateRelation> getContentTemplateList() {
		return contentTemplateList;
	}
	public void setContentTemplateList(
			List<TFollowupTaskContentTemplateRelation> contentTemplateList) {
		this.contentTemplateList = contentTemplateList;
	}
	public Float getProgress() {
		return progress;
	}
	public void setProgress(Float progress) {
		this.progress = progress;
	}
	public Float getEffectiveRate() {
		return effectiveRate;
	}
	public void setEffectiveRate(Float effectiveRate) {
		this.effectiveRate = effectiveRate;
	}
}
