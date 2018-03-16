package com.esuizhen.cloudservice.research.model.crf;

import java.util.Date;

/**
* @ClassName: TCrfMedicationInfo 
* @Description: 用药信息实体
* @author wang_hw
* @date 2016年4月14日 下午6:40:25
 */
public class TCrfMedicationInfo{
	/**
	 * 明细ID。主键。
	 */
	private String crfObserveItemId;
	/**
	 * 方案ID。外键。
	 */
	private String crfObserveSchemeId;
	/**
	 * 用药类型 1: 化疗 2：靶向
	 */
	private Integer medicationType;
	/**
	 * 药物ID。 外键：ehr_db.meta_e_medication
	 */
	private Integer medicationId;
	/**
	 * medicationName
	 */
	private String medicationName;
	/**
	 * commodityName
	 */
	private String commodityName;
	/**
	 * computingMethod
	 */
	private String computingMethod;
	/**
	 * 记录创建时间。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	/**
	 * 理论剂量
	 */
	private Float theoreticalDose;
	/**
	 * 计量单位
	 */
	private String measurementUnit;
	/**
	 * drugUsage
	 */
	private String drugUsage;
	/**
	 * 治疗周期（周）
	 */
	private String treatmentPeriod;
	/**
	 * 总疗程
	 */
	private String totalCourse;
	//排序索引
	private Integer index;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfObserveItemId(String value) {
		this.crfObserveItemId = value;
	}
	
	public String getCrfObserveItemId() {
		return this.crfObserveItemId;
	}
	public void setCrfObserveSchemeId(String value) {
		this.crfObserveSchemeId = value;
	}
	
	public String getCrfObserveSchemeId() {
		return this.crfObserveSchemeId;
	}
	public void setMedicationType(Integer value) {
		this.medicationType = value;
	}
	
	public Integer getMedicationType() {
		return this.medicationType;
	}
	public void setMedicationId(Integer value) {
		this.medicationId = value;
	}
	
	public Integer getMedicationId() {
		return this.medicationId;
	}
	public void setMedicationName(String value) {
		this.medicationName = value;
	}
	
	public String getMedicationName() {
		return this.medicationName;
	}
	public void setCommodityName(String value) {
		this.commodityName = value;
	}
	
	public String getCommodityName() {
		return this.commodityName;
	}
	public void setComputingMethod(String value) {
		this.computingMethod = value;
	}
	
	public String getComputingMethod() {
		return this.computingMethod;
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
	public void setTheoreticalDose(Float value) {
		this.theoreticalDose = value;
	}
	
	public Float getTheoreticalDose() {
		return this.theoreticalDose;
	}
	public void setMeasurementUnit(String value) {
		this.measurementUnit = value;
	}
	
	public String getMeasurementUnit() {
		return this.measurementUnit;
	}
	public void setDrugUsage(String value) {
		this.drugUsage = value;
	}
	
	public String getDrugUsage() {
		return this.drugUsage;
	}
	public void setTreatmentPeriod(String value) {
		this.treatmentPeriod = value;
	}
	
	public String getTreatmentPeriod() {
		return this.treatmentPeriod;
	}
	public void setTotalCourse(String value) {
		this.totalCourse = value;
	}
	
	public String getTotalCourse() {
		return this.totalCourse;
	}


}

