package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;
import java.util.List;


public class TCrfResultTreatmentChemotherapyInfo
{
	
	/**
	 * 化疗结果ID
	 */
	private String crfTreatmentChemotherapyResultId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
	//方案索引
	private Integer schemeIndex;
	/**
	 * 方案名称
	 */
	private String schemeName;
	/**
	 * 方案类别
	 */
	private String schemeCategory;
	/**
	 * 方案类别其他描述
	 */
	private String schemeCategoryDesc;
	/**
	 * 化疗类型
	 */
	private String chemotherapyType;
	/**
	 * 化疗类型其他描述
	 */
	private String chemotherapyTypeDesc;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	//排序号
	private Integer index;
	/**
	 * createTime
	 */
	private Date createTime;
	/**
	 * updateTime
	 */
	private Date updateTime;

	/**
	 * 化疗结果明细列表
	 */
	private List<TCrfResultTreatmentChemotherapyMedicationDetail> crfResultTreatmentChemotherapyMedicationDetailList;
	
	public Integer getIndex() {
		return index;
	}

	public Integer getSchemeIndex() {
		return schemeIndex;
	}

	public void setSchemeIndex(Integer schemeIndex) {
		this.schemeIndex = schemeIndex;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfTreatmentChemotherapyResultId(String crfTreatmentChemotherapyResultId) {
		this.crfTreatmentChemotherapyResultId = crfTreatmentChemotherapyResultId;
	}
	
	public String getCrfTreatmentChemotherapyResultId() {
		return this.crfTreatmentChemotherapyResultId;
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
	public void setSchemeCategory(String schemeCategory) {
		this.schemeCategory = schemeCategory;
	}
	
	public String getSchemeCategory() {
		return this.schemeCategory;
	}
	public void setSchemeCategoryDesc(String schemeCategoryDesc) {
		this.schemeCategoryDesc = schemeCategoryDesc;
	}
	
	public String getSchemeCategoryDesc() {
		return this.schemeCategoryDesc;
	}
	public String getChemotherapyType() {
		return chemotherapyType;
	}

	public void setChemotherapyType(String chemotherapyType) {
		this.chemotherapyType = chemotherapyType;
	}

	public void setChemotherapyTypeDesc(String chemotherapyTypeDesc) {
		this.chemotherapyTypeDesc = chemotherapyTypeDesc;
	}
	
	public String getChemotherapyTypeDesc() {
		return this.chemotherapyTypeDesc;
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

	public List<TCrfResultTreatmentChemotherapyMedicationDetail> getCrfResultTreatmentChemotherapyMedicationDetailList()
	{
		return crfResultTreatmentChemotherapyMedicationDetailList;
	}

	public void setCrfResultTreatmentChemotherapyMedicationDetailList(List<TCrfResultTreatmentChemotherapyMedicationDetail> crfResultTreatmentChemotherapyMedicationDetailList)
	{
		this.crfResultTreatmentChemotherapyMedicationDetailList = crfResultTreatmentChemotherapyMedicationDetailList;
	}

	

}

