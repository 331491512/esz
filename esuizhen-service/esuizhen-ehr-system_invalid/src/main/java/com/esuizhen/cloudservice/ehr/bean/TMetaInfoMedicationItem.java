/**
 * @author: Da Loong
 * @date:   2016年4月12日 上午12:42:56
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-用药
 * @author Da Loong
 * @date   2016年4月12日 上午12:42:56
 */
public class TMetaInfoMedicationItem {

	/**
	 * 药物ID。
	 */
	private int medicationId;
	
	/**
	 * 用药类型
		1: 化疗
		2：靶向
	 */
	private int  medicationType;
	
	/**
	 * 药物名称
	 */
	private  String medicationName;
	
	
	/**
	 * 药物名称
	 */
	private  String medicationEnglishName;
	
	
	/**
	 * 商品名
	 */
	private  String  commodityName;
	
	/**
	 * 计算方法
	 */
	private String computingMethod;
	
	/**
	 * 理论剂量
	 */
	private float theoreticalDose;
	
	/**
	 * 计量单位
	 */
	private String measurementUnit;
	
	/**
	 * 药物用法
	 */
	private String drugUsage;

	/**
	 * 治疗周期（周)
	 */
	private int treatmentPeriod;
	
	/**
	 * 疗程
	 */
	private float totalCourse;
	
	/**
	 * @return the medicationId
	 */
	
	private Integer medicationMetaDataType; //治疗方案对应的用药的metaDataType
	
	public Integer getMedicationMetaDataType() {
		return medicationMetaDataType;
	}

	public void setMedicationMetaDataType(Integer medicationMetaDataType) {
		this.medicationMetaDataType = medicationMetaDataType;
	}

	public int getMedicationId() {
		return medicationId;
	}

	/**
	 * @param medicationId the medicationId to set
	 */
	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	/**
	 * @return the medicationType
	 */
	public int getMedicationType() {
		return medicationType;
	}

	/**
	 * @param medicationType the medicationType to set
	 */
	public void setMedicationType(int medicationType) {
		this.medicationType = medicationType;
	}

	/**
	 * @return the medicationName
	 */
	public String getMedicationName() {
		return medicationName;
	}

	/**
	 * @param medicationName the medicationName to set
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
	 * @return the commodityName
	 */
	public String getCommodityName() {
		return commodityName;
	}

	/**
	 * @param commodityName the commodityName to set
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	/**
	 * @return the computingMethod
	 */
	public String getComputingMethod() {
		return computingMethod;
	}

	/**
	 * @param computingMethod the computingMethod to set
	 */
	public void setComputingMethod(String computingMethod) {
		this.computingMethod = computingMethod;
	}

	/**
	 * @return the theoreticalDose
	 */
	public float getTheoreticalDose() {
		return theoreticalDose;
	}

	/**
	 * @param theoreticalDose the theoreticalDose to set
	 */
	public void setTheoreticalDose(float theoreticalDose) {
		this.theoreticalDose = theoreticalDose;
	}

	/**
	 * @return the measurementUnit
	 */
	public String getMeasurementUnit() {
		return measurementUnit;
	}

	/**
	 * @param measurementUnit the measurementUnit to set
	 */
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	/**
	 * @return the drugUsage
	 */
	public String getDrugUsage() {
		return drugUsage;
	}

	/**
	 * @param drugUsage the drugUsage to set
	 */
	public void setDrugUsage(String drugUsage) {
		this.drugUsage = drugUsage;
	}

	/**
	 * @return the medicationEnglishName
	 */
	public String getMedicationEnglishName() {
		return medicationEnglishName;
	}

	/**
	 * @param medicationEnglishName the medicationEnglishName to set
	 */
	public void setMedicationEnglishName(String medicationEnglishName) {
		this.medicationEnglishName = medicationEnglishName;
	}

	/**
	 * @return the treatmentPeriod
	 */
	public int getTreatmentPeriod() {
		return treatmentPeriod;
	}

	/**
	 * @param treatmentPeriod the treatmentPeriod to set
	 */
	public void setTreatmentPeriod(int treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	/**
	 * @return the totalCourse
	 */
	public float getTotalCourse() {
		return totalCourse;
	}

	/**
	 * @param totalCourse the totalCourse to set
	 */
	public void setTotalCourse(float totalCourse) {
		this.totalCourse = totalCourse;
	}
	

	
	
}
