package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class TumourFamilyHistoryInfo {
    private String familyHistoryId;

    private Long patientId;

    private String inhospitalId;
    
    private String clinicMedicalId;

    private Integer relationId;

    private String relationName;

    private String diseaseTypeId;

    private String diseaseTypeName;

    private Date morbidityTime;

    private Integer morbidityAge;

    private Long author;

    private Date createTime;

    private Date updateTime;

    public String getFamilyHistoryId() {
        return familyHistoryId;
    }

    public void setFamilyHistoryId(String familyHistoryId) {
        this.familyHistoryId = familyHistoryId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(String diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    public Date getMorbidityTime() {
        return morbidityTime;
    }

    public void setMorbidityTime(Date morbidityTime) {
        this.morbidityTime = morbidityTime;
    }

    public Integer getMorbidityAge() {
        return morbidityAge;
    }

    public void setMorbidityAge(Integer morbidityAge) {
        this.morbidityAge = morbidityAge;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
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
}