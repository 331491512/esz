/**
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;
import java.util.List;

import com.westangel.common.bean.PatientGroup;


public class DoctorSendKnowledgeArticleReq {
	
	//发送医生userId
	private Long doctorUserId;
	
	//接收患者的userId
	private List<Long> patientUserIds;
	
	//接收分组
	private List<PatientGroup>groups;
	
	//疾病知识编号
	private String articleId;
	
	//加入患教库
	private Integer inData;
	
	//发送类型
	private Integer sendFlag;
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public List<Long> getPatientUserIds() {
		return patientUserIds;
	}
	public void setPatientUserIds(List<Long> patientUserIds) {
		this.patientUserIds = patientUserIds;
	}
	public List<PatientGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<PatientGroup> groups) {
		this.groups = groups;
	}
	public Integer getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(Integer sendFlag) {
		this.sendFlag = sendFlag;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	public Integer getInData() {
		return inData;
	}
	public void setInData(Integer inData) {
		this.inData = inData;
	}
}
