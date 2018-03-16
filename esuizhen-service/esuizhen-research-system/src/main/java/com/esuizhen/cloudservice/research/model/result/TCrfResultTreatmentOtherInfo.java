package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultTreatmentOtherInfo{
	
	/**
	 * 其他结果ID
	 */
	private String crfTreatmentOtherResultId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
	
	/**
	 * 结果类型
	 */
	private String crfResultTypeName;
	/**
	 * 方案名称
	 */
	private String schemeName;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	//排序索引
	private Integer index;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	//专题ID
	private String projectId;
	//患者ID
	private Long patientId;
	//随访周期ID
	private String crfCourseItemId;
	//观察项ID
	private String subjectElementId;
	//观察项设置项ID
	private String crfObserveId;
	//应随访时间
	private Date crfCourseItemTime;

	public Date getCrfCourseItemTime() {
		return crfCourseItemTime;
	}

	public void setCrfCourseItemTime(Date crfCourseItemTime) {
		this.crfCourseItemTime = crfCourseItemTime;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getCrfCourseItemId() {
		return crfCourseItemId;
	}

	public void setCrfCourseItemId(String crfCourseItemId) {
		this.crfCourseItemId = crfCourseItemId;
	}

	public String getSubjectElementId() {
		return subjectElementId;
	}

	public void setSubjectElementId(String subjectElementId) {
		this.subjectElementId = subjectElementId;
	}

	public String getCrfObserveId() {
		return crfObserveId;
	}

	public void setCrfObserveId(String crfObserveId) {
		this.crfObserveId = crfObserveId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfTreatmentOtherResultId(String crfTreatmentOtherResultId) {
		this.crfTreatmentOtherResultId = crfTreatmentOtherResultId;
	}
	
	public String getCrfTreatmentOtherResultId() {
		return this.crfTreatmentOtherResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
	public String getSchemeName() {
		return this.schemeName;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public Date getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public String getCrfResultTypeName()
	{
		return crfResultTypeName;
	}

	public void setCrfResultTypeName(String crfResultTypeName)
	{
		this.crfResultTypeName = crfResultTypeName;
	}
	
	
}

