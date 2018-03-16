package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;

public class TreatmentChemotherapyMedicationDetailInfo {
	private String chemotherapyMedicationDetailId;

	private String treatmentId;

	private String chemotherapyMedicationRecordId;

	private String inhospitalId;

	private Long patientId;

	private String patientNo;

	private Integer hospitalId;

	private Integer medicationType;

	private Integer medicationId;

	private String medicationName;
	private String commodityName;
	private Integer treatmentSchemeId;
	private String treatmentName;
	private Integer treatmentTypeId;

	private String computingMethod;

	private String theoreticalDose;

	private Float actualDose;
	private String measurementUnit;

	private String drugUsage;

	private String treatmentPeriod;

	private String totalCourse;

	private Integer delay;

	private Integer decrement;

	private Integer route;

	private Integer frequency;

	private String remark;

	private Date beginTime;

	private Date endTime;

	private Date createTime;
	private Date updateTime;
	
	private String concatFlag;
	
	private Integer medicationMetaDataType; // add by xueyongyan 20170502 化疗用药的metaDataType


	public Integer getMedicationMetaDataType() {
		return medicationMetaDataType;
	}

	public void setMedicationMetaDataType(Integer medicationMetaDataType) {
		this.medicationMetaDataType = medicationMetaDataType;
	}

	/**
	 * 门诊记录
	 */
	private String clinicMedicalId;
	/**
	 * 给药途径
	 */
	private String routeName;
	/**
	 * 给药频率
	 */
	private String frequencyName;
	
	private String measurementUnitName; // 剂量单位名称  做页面显示用 add by xueyongyan
	
	public String getMeasurementUnitName() {
		return measurementUnitName;
	}
	public void setMeasurementUnitName(String measurementUnitName) {
		this.measurementUnitName = measurementUnitName;
	}
	public String getChemotherapyMedicationDetailId() {
		return chemotherapyMedicationDetailId;
	}
	public void setChemotherapyMedicationDetailId(
			String chemotherapyMedicationDetailId) {
		this.chemotherapyMedicationDetailId = chemotherapyMedicationDetailId;
	}
	public String getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	public String getChemotherapyMedicationRecordId() {
		return chemotherapyMedicationRecordId;
	}
	public void setChemotherapyMedicationRecordId(
			String chemotherapyMedicationRecordId) {
		this.chemotherapyMedicationRecordId = chemotherapyMedicationRecordId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getMedicationType() {
		return medicationType;
	}
	public void setMedicationType(Integer medicationType) {
		this.medicationType = medicationType;
	}
	public Integer getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(Integer medicationId) {
		this.medicationId = medicationId;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getComputingMethod() {
		return computingMethod;
	}
	public void setComputingMethod(String computingMethod) {
		this.computingMethod = computingMethod;
	}
	public String getTheoreticalDose() {
		return theoreticalDose;
	}
	public void setTheoreticalDose(String theoreticalDose) {
		this.theoreticalDose = theoreticalDose;
	}
	public Float getActualDose() {
		return actualDose;
	}
	public void setActualDose(Float actualDose) {
		this.actualDose = actualDose;
	}

	public String getDrugUsage() {
		return drugUsage;
	}

	public void setDrugUsage(String drugUsage) {
		this.drugUsage = drugUsage;
	}

	public String getTreatmentPeriod() {
		return treatmentPeriod;
	}

	public void setTreatmentPeriod(String treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	public String getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(String totalCourse) {
		this.totalCourse = totalCourse;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Integer getDecrement() {
		return decrement;
	}

	public void setDecrement(Integer decrement) {
		this.decrement = decrement;
	}

	public Integer getRoute() {
		return route;
	}

	public void setRoute(Integer route) {
		this.route = route;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFrequencyName() {
		return frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}

	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getConcatFlag() {
		return concatFlag;
	}

	public void setConcatFlag(String concatFlag) {
		this.concatFlag = concatFlag;
	}

}