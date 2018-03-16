package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

public class TreatmentDetailReq {
	
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer treatmentTypeId;
	private Date treatmentTime;
	private String treatmentDesc;
	private Integer treatmentNum;
	private String treatmentTypeName;
	private String continualTimeDesc;
	private Date startTime;
	private Date endTime;
	private Integer sortNum;
	
	private Integer isDel;//0:不删除此条数据，1：删除此条数据 
	
	
	public Long getMainQuestionItemId() {
		return mainQuestionItemId;
	}
	public void setMainQuestionItemId(Long mainQuestionItemId) {
		this.mainQuestionItemId = mainQuestionItemId;
	}
	public Long getFollowupConvQuestionId() {
		return followupConvQuestionId;
	}
	public void setFollowupConvQuestionId(Long followupConvQuestionId) {
		this.followupConvQuestionId = followupConvQuestionId;
	}
	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}
	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	public Date getTreatmentTime() {
		return treatmentTime;
	}
	public void setTreatmentTime(Date treatmentTime) {
		this.treatmentTime = treatmentTime;
	}
	
	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}
	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}
	public String getTreatmentDesc() {
		return treatmentDesc;
	}
	public void setTreatmentDesc(String treatmentDesc) {
		this.treatmentDesc = treatmentDesc;
	}
	public Integer getTreatmentNum() {
		return treatmentNum;
	}
	public void setTreatmentNum(Integer treatmentNum) {
		this.treatmentNum = treatmentNum;
	}
	public String getContinualTimeDesc() {
		return continualTimeDesc;
	}
	public void setContinualTimeDesc(String continualTimeDesc) {
		this.continualTimeDesc = continualTimeDesc;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}
