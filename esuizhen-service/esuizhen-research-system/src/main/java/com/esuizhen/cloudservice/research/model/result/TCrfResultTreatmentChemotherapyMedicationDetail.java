package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;

public class TCrfResultTreatmentChemotherapyMedicationDetail{
	
	/**
	 * 用药ID
	 */
	private String crfChemotherapyMedicationResultDetailId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
	/**
	 * 放疗ID
	 */
	private String crfTreatmentChemotherapyResultId;
	/**
	 * 用药类型1: 化疗 2：靶向
	 */
	private Integer medicationType;
	/**
	 * 药物ID。
	 */
	private Long medicationId;
	/**
	 * 药物名称
	 */
	private String medicationName;
	/**
	 * 商品名
	 */
	private String commodityName;
	/**
	 * 计算方法
	 */
	private String computingMethod;
	/**
	 * 理论剂量
	 */
	private Float theoreticalDose;
	/**
	 * 计量单位
	 */
	private String measurementUnit;
	/**
	 * 药物用法
	 */
	private String drugUsage;
	/**
	 * 实际剂量
	 */
	private Float actualDose;
	/**
	 * 治疗周期（周）
	 */
	private String treatmentPeriod;
	/**
	 * 总疗程
	 */
	private String totalCourse;
	/**
	 * 延期
	 */
	private Integer delay;
	/**
	 * 减量
	 */
	private Integer decrement;
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
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfChemotherapyMedicationResultDetailId(String crfChemotherapyMedicationResultDetailId) {
		this.crfChemotherapyMedicationResultDetailId = crfChemotherapyMedicationResultDetailId;
	}
	
	public String getCrfChemotherapyMedicationResultDetailId() {
		return this.crfChemotherapyMedicationResultDetailId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setMedicationType(Integer medicationType) {
		this.medicationType = medicationType;
	}
	
	public Integer getMedicationType() {
		return this.medicationType;
	}
	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}
	
	public Long getMedicationId() {
		return this.medicationId;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	
	public String getMedicationName() {
		return this.medicationName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	
	public String getCommodityName() {
		return this.commodityName;
	}
	public void setComputingMethod(String computingMethod) {
		this.computingMethod = computingMethod;
	}
	
	public String getComputingMethod() {
		return this.computingMethod;
	}
	public void setTheoreticalDose(Float theoreticalDose) {
		this.theoreticalDose = theoreticalDose;
	}
	
	public Float getTheoreticalDose() {
		return this.theoreticalDose;
	}
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	
	public String getMeasurementUnit() {
		return this.measurementUnit;
	}
	public void setDrugUsage(String drugUsage) {
		this.drugUsage = drugUsage;
	}
	
	public String getDrugUsage() {
		return this.drugUsage;
	}
	public void setActualDose(Float actualDose) {
		this.actualDose = actualDose;
	}
	
	public Float getActualDose() {
		return this.actualDose;
	}
	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}
	
	public String getTreatmentPeriod() {
		return this.treatmentPeriod;
	}
	public void setTotalCourse(String totalCourse) {
		this.totalCourse = totalCourse;
	}
	
	public String getTotalCourse() {
		return this.totalCourse;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	
	public Integer getDelay() {
		return this.delay;
	}
	public void setDecrement(Integer decrement) {
		this.decrement = decrement;
	}
	
	public Integer getDecrement() {
		return this.decrement;
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

	public String getCrfTreatmentChemotherapyResultId()
	{
		return crfTreatmentChemotherapyResultId;
	}

	public void setCrfTreatmentChemotherapyResultId(String crfTreatmentChemotherapyResultId)
	{
		this.crfTreatmentChemotherapyResultId = crfTreatmentChemotherapyResultId;
	}


}

