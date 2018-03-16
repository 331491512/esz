package com.esuizhen.cloudservice.followup.bean;

import java.util.List;

/** 
 * @ClassName: FollowupTaskOperatorAlloPatientReq.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年12月1日
 */
public class FollowupTaskOperatorAlloPatientReq {

	private Integer searchId;        //":1234,
	private Long conditionId;    //":1,
	private List<Long> operators;      //":"1,2,3",
	private List<Long> patientIdList; //":[1,3,9,20,343],
	private Integer taskPatientCount;  //":300
	
	private String searchTableName;
	private String searchColumnName;
	
	
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public Long getConditionId() {
		return conditionId;
	}
	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}
	public List<Long> getOperators() {
		return operators;
	}
	public void setOperators(List<Long> operators) {
		this.operators = operators;
	}
	public List<Long> getPatientIdList() {
		return patientIdList;
	}
	public void setPatientIdList(List<Long> patientIdList) {
		this.patientIdList = patientIdList;
	}
	public Integer getTaskPatientCount() {
		return taskPatientCount;
	}
	public void setTaskPatientCount(Integer taskPatientCount) {
		this.taskPatientCount = taskPatientCount;
	}
	public String getSearchTableName() {
		return searchTableName;
	}
	public void setSearchTableName(String searchTableName) {
		this.searchTableName = searchTableName;
	}
	public String getSearchColumnName() {
		return searchColumnName;
	}
	public void setSearchColumnName(String searchColumnName) {
		this.searchColumnName = searchColumnName;
	}
}
