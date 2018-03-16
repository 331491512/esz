package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

public class FollowupMsgSendReq {

	private String templateId;
	
	private String followupTaskId;
	
	private String followupAssignId;
	
	private Long patientId;
	
	private String content;
	
	private Integer hospitalId;
	
	private String openId;
	
	private String mobile;
	
	private String trueName;
	
	private Date timerTaskDate;
	
	private String searchPatientNo;
	
	private String searchTrueName;
	
	private String searchSourceDiagnosis;
	
	private String searchMobile;
	
	private Integer searchFollowupResultValue;
	
	private Integer searchState;
	
	/**
	 * 后台逻辑用到的属性（有效微信）
	 */
	private String isValidWx;
	
	/**
	 * 后台逻辑用到的属性（有效手机号）
	 */
	private String isValidSms;
	
	private Long operator;
	
	private List<FollowupPatientInfo> patientInfoList;
	
	private String nationIdStr;
	private String sourceDiseaseTypeIdStr;
	
	private String judgeValidFlag;
	
	private TFollowupTaskPatientListQueryReq taskPatientListQueryReq;
	public String getIsValidWx() {
		return isValidWx;
	}

	public void setIsValidWx(String isValidWx) {
		this.isValidWx = isValidWx;
	}

	public String getIsValidSms() {
		return isValidSms;
	}

	public void setIsValidSms(String isValidSms) {
		this.isValidSms = isValidSms;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Date getTimerTaskDate() {
		return timerTaskDate;
	}

	public void setTimerTaskDate(Date timerTaskDate) {
		this.timerTaskDate = timerTaskDate;
	}

	public String getSearchPatientNo() {
		return searchPatientNo;
	}

	public void setSearchPatientNo(String searchPatientNo) {
		this.searchPatientNo = searchPatientNo;
	}

	public String getSearchTrueName() {
		return searchTrueName;
	}

	public void setSearchTrueName(String searchTrueName) {
		this.searchTrueName = searchTrueName;
	}

	public String getSearchSourceDiagnosis() {
		return searchSourceDiagnosis;
	}

	public void setSearchSourceDiagnosis(String searchSourceDiagnosis) {
		this.searchSourceDiagnosis = searchSourceDiagnosis;
	}

	public String getSearchMobile() {
		return searchMobile;
	}

	public void setSearchMobile(String searchMobile) {
		this.searchMobile = searchMobile;
	}

	public Integer getSearchFollowupResultValue() {
		return searchFollowupResultValue;
	}

	public void setSearchFollowupResultValue(Integer searchFollowupResultValue) {
		this.searchFollowupResultValue = searchFollowupResultValue;
	}

	public Integer getSearchState() {
		return searchState;
	}

	public void setSearchState(Integer searchState) {
		this.searchState = searchState;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public List<FollowupPatientInfo> getPatientInfoList() {
		return patientInfoList;
	}

	public void setPatientInfoList(List<FollowupPatientInfo> patientInfoList) {
		this.patientInfoList = patientInfoList;
	}

	public String getNationIdStr() {
		return nationIdStr;
	}

	public void setNationIdStr(String nationIdStr) {
		this.nationIdStr = nationIdStr;
	}

	public String getSourceDiseaseTypeIdStr() {
		return sourceDiseaseTypeIdStr;
	}

	public void setSourceDiseaseTypeIdStr(String sourceDiseaseTypeIdStr) {
		this.sourceDiseaseTypeIdStr = sourceDiseaseTypeIdStr;
	}

	public String getJudgeValidFlag() {
		return judgeValidFlag;
	}

	public void setJudgeValidFlag(String judgeValidFlag) {
		this.judgeValidFlag = judgeValidFlag;
	}

	public TFollowupTaskPatientListQueryReq getTaskPatientListQueryReq() {
		return taskPatientListQueryReq;
	}

	public void setTaskPatientListQueryReq(TFollowupTaskPatientListQueryReq taskPatientListQueryReq) {
		this.taskPatientListQueryReq = taskPatientListQueryReq;
	}
}
