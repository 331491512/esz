package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoICD10 {

	/**
	 * 诊断编码
	 */
	private String diseaseCode;

	/**
	 * 诊断名称
	 */
	private String diseaseName;

	/**
	 * 助记词
	 */
	private String helpRememberCode;
	/*
	 * 是否为恶性，1是恶性
	 */
	private Integer tumorFlag;

	public Integer getTumorFlag() {
		return tumorFlag;
	}

	public void setTumorFlag(Integer tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public String getHelpRememberCode() {
		return helpRememberCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public void setHelpRememberCode(String helpRememberCode) {
		this.helpRememberCode = helpRememberCode;
	}
	
}
