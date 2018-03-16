package com.esuizhen.cloudservice.ehr.model.icd10;

import java.util.Date;

public class IcdDiseaseType{
	
	/**
	 * 疾病编码。
	 */
	private Integer icdDiseaseTypeId;
	/**
	 * 疾病名
	 */
	private String icdDiseaseTypeName;
	/**
	 * 前缀
	 */
	private String diseaseCodePrefix;
	
	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}
	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}
	public String getIcdDiseaseTypeName() {
		return icdDiseaseTypeName;
	}
	public void setIcdDiseaseTypeName(String icdDiseaseTypeName) {
		this.icdDiseaseTypeName = icdDiseaseTypeName;
	}
	public String getDiseaseCodePrefix() {
		return diseaseCodePrefix;
	}
	public void setDiseaseCodePrefix(String diseaseCodePrefix) {
		this.diseaseCodePrefix = diseaseCodePrefix;
	}
	
	

}

