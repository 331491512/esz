package com.esuizhen.cloudservice.questionnaire.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FollowupMsgSendReq {

	private String templateId;
	
	private String taskId;
	
	private String assignId;
	
	private Long patientId;
	
	private String content;
	
	private Integer hospitalId;
	
	private String openId;
	
	private String mobile;
	
	private String trueName;
	
	private String patientTrueName;
	
	private Date timerTaskDate;
	
	private String patientNo;
	
	private String sourceDiagnosis;
	
	private List<Integer> followupResultValue;
	
	private List<Integer> state;
	
	/**
	 * 后台逻辑用到的属性（有效微信）
	 */
	private String isValidWx;
	
	/**
	 * 后台逻辑用到的属性（有效手机号）
	 */
	private String isValidSms;
	
	private Long operator;
	
	private List<Map<String,Object>> patientInfoList;
	
	private String nationIdStr;
	
	private String sourceDiseaseTypeIdStr;
	
	private String questionnaireId;
	
	private String phone;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAssignId() {
		return assignId;
	}

	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPatientTrueName() {
		return patientTrueName;
	}

	public void setPatientTrueName(String patientTrueName) {
		this.patientTrueName = patientTrueName;
	}

	public Date getTimerTaskDate() {
		return timerTaskDate;
	}

	public void setTimerTaskDate(Date timerTaskDate) {
		this.timerTaskDate = timerTaskDate;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
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

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public List<Map<String, Object>> getPatientInfoList() {
		return patientInfoList;
	}

	public void setPatientInfoList(List<Map<String, Object>> patientInfoList) {
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

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
