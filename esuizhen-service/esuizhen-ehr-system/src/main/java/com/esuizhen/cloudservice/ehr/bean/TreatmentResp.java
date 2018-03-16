package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/**
 * @ClassName: TreatmentResp
 * @Description: PatientMedicalTreatmentResp的子表
 * @author zhuguo
 * @date 2017-5-31 17:32:33
 */
public class TreatmentResp {

	// 治疗类型名称
	private String treatmentTypeName;

	// 手术名称
	private String surgeryName;

	// 手术日期
	private Date surgeryDate;

	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}

	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}

	public String getSurgeryName() {
		return surgeryName;
	}

	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}
}
