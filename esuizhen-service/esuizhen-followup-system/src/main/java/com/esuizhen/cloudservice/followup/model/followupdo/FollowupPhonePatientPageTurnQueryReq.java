package com.esuizhen.cloudservice.followup.model.followupdo;

import java.util.ArrayList;
import java.util.List;

public class FollowupPhonePatientPageTurnQueryReq {

	private String followupTaskId;
	private String followupAssignId;
	private Long patientId;
	private Integer userRole;
	private Integer pageTurn;

	private String patientNo; // 病案号
	private String patientTrueName; // 姓名
	private String sourceDiagnosis;
	private String phone;
	private List<Integer> followupResultValue = new ArrayList<Integer>();
	private List<Integer> state = new ArrayList<Integer>();

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

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getPageTurn() {
		return pageTurn;
	}

	public void setPageTurn(Integer pageTurn) {
		this.pageTurn = pageTurn;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientTrueName() {
		return patientTrueName;
	}

	public void setPatientTrueName(String patientTrueName) {
		this.patientTrueName = patientTrueName;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Integer> getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(List<Integer> followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public List<Integer> getState() {
		return state;
	}

	public void setState(List<Integer> state) {
		this.state = state;
	}
}
