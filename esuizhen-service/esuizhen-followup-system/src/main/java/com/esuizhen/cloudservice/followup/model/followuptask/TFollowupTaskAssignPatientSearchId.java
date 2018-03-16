/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

import java.util.List;

/**
 * @author DaLoong
 * @date  2016-8-11 下午8:39:06
 */
public class TFollowupTaskAssignPatientSearchId {

	private String followupAssignId;
	private String followupTaskId;
	private Integer searchId;
	private Integer patientNum;
	
	private String searchTableName;
	private String searchColumnName;
	private Long Operator;
	private List<Long> patientIds;
	
	public String getFollowupAssignId() {
		return followupAssignId;
	}
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public Integer getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(Integer patientNum) {
		this.patientNum = patientNum;
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
	public Long getOperator() {
		return Operator;
	}
	public void setOperator(Long operator) {
		Operator = operator;
	}
	public List<Long> getPatientIds() {
		return patientIds;
	}
	public void setPatientIds(List<Long> patientIds) {
		this.patientIds = patientIds;
	}
}
