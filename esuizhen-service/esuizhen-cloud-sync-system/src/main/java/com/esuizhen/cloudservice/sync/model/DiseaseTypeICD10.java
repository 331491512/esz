package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 病种和ICD-10对应bean
 * @author YYCHEN
 *
 */
public class DiseaseTypeICD10 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer hospitalId;
	private Integer diseaseBodyPartId;
	private Integer diseaseTypeId;
	private String diseaseCode;
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
