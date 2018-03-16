package com.esuizhen.cloudservice.followup.bean;

public class TFollowupConfigDiseaseType {
	
	private Integer id;
	
	private Integer diseaseTypeId;
	
	private String diseaseTypeName;
	
	private Integer tumorFlag;
	
	private Integer diseaseBodyPartId;
	
	private String diseaseBodyPartName;


	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}

	public Integer getTumorFlag() {
		return tumorFlag;
	}

	public void setTumorFlag(Integer tumorFlag) {
		this.tumorFlag = tumorFlag;
	}

	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}

	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}

	public String getDiseaseBodyPartName() {
		return diseaseBodyPartName;
	}

	public void setDiseaseBodyPartName(String diseaseBodyPartName) {
		this.diseaseBodyPartName = diseaseBodyPartName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
