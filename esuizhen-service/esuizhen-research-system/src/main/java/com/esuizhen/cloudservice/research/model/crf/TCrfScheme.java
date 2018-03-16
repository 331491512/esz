package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;
import java.util.List;


public class TCrfScheme{
	/**
	 * crfObserveSchemeId
	 */
	private String crfObserveSchemeId;
	/**
	 * 观察项ID。外键。
	 */
	private String crfObserveId;
	/**
	 * 观察项。三级标题。外键。meta_crf_subject_element.subjectElementId 如化疗、靶向对应的Id。
	 */
	private String subjectElementId;
	/**
	 * 方案名称
	 */
	private String schemeName;
	/**
	 * 如果是从标准元数据表而来的方案，则须记录标准方案Id 外键：ehr_db. meta_e_treatment_scheme. treatmentSchemeId
	 */
	private Integer treatmentSchemeId;
	
	/**
	 * 化疗用药列表
	 */
	private List<TCrfMedicationInfo> medicationList;
	
	/**
	 * 放疗部位列表
	 */
	private List<TCrfRadiotherapyPartInfo> bodyPartList;
	//排序索引
	private Integer index;
	/**
	 * 记录创建时间。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfObserveSchemeId(String value) {
		this.crfObserveSchemeId = value;
	}
	
	public String getCrfObserveSchemeId() {
		return this.crfObserveSchemeId;
	}
	public void setCrfObserveId(String value) {
		this.crfObserveId = value;
	}
	
	public String getCrfObserveId() {
		return this.crfObserveId;
	}
	public void setSubjectElementId(String value) {
		this.subjectElementId = value;
	}
	
	public String getSubjectElementId() {
		return this.subjectElementId;
	}
	public void setSchemeName(String value) {
		this.schemeName = value;
	}
	
	public String getSchemeName() {
		return this.schemeName;
	}
	public void setTreatmentSchemeId(Integer value) {
		this.treatmentSchemeId = value;
	}
	
	public Integer getTreatmentSchemeId() {
		return this.treatmentSchemeId;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public List<TCrfMedicationInfo> getMedicationList()
	{
		return medicationList;
	}

	public void setMedicationList(List<TCrfMedicationInfo> medicationList)
	{
		this.medicationList = medicationList;
	}

	public List<TCrfRadiotherapyPartInfo> getBodyPartList()
	{
		return bodyPartList;
	}

	public void setBodyPartList(List<TCrfRadiotherapyPartInfo> bodyPartList)
	{
		this.bodyPartList = bodyPartList;
	}

	

}

