package com.esuizhen.cloudservice.ehr.model.meta;

import java.io.Serializable;


public class SpecialDiseaseDiagnosisMeta implements Serializable
{
	
	private Integer specialDiseaseDiagnosisId; //	主键ID
	private String specialDiseaseDiagnosisName;	//特病诊断名称
	
	public Integer getSpecialDiseaseDiagnosisId() {
		return specialDiseaseDiagnosisId;
	}
	public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
		this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
	}
	public String getSpecialDiseaseDiagnosisName() {
		return specialDiseaseDiagnosisName;
	}
	public void setSpecialDiseaseDiagnosisName(
			String specialDiseaseDiagnosisName) {
		this.specialDiseaseDiagnosisName = specialDiseaseDiagnosisName;
	}
}

