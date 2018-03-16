package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;
import java.util.List;

public class SymptomsReq {
	private Long mainQuestionItemId;
	private Long followupConvQuestionId;
	private Integer symptomTypeId;
	private String symptomName;
	private Date startTime;
	private Date endTime;
	private Integer gradeType;
	private Integer lapseTo;
	
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
	public Integer getSymptomTypeId() {
		return symptomTypeId;
	}
	public void setSymptomTypeId(Integer symptomTypeId) {
		this.symptomTypeId = symptomTypeId;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
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
	public Integer getGradeType() {
		return gradeType;
	}
	public void setGradeType(Integer gradeType) {
		this.gradeType = gradeType;
	}
	public Integer getLapseTo() {
		return lapseTo;
	}
	public void setLapseTo(Integer lapseTo) {
		this.lapseTo = lapseTo;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}
