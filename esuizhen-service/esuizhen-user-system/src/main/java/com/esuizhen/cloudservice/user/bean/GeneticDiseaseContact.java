package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: GeneticDiseaseList.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月23日
 */
public class GeneticDiseaseContact implements Serializable {

	private Integer geneId;
	private Long patientId;
	private Integer relationId;
	private String familyName;
	private Integer diseaseTypeId;
	private String otherGeneDisease;
	private Integer liveStatus;
	private Date deathDate;
	private Long specialDiseaseRegisterId;
	public Integer getId() {
		return geneId;
	}
	public void setId(Integer id) {
		this.geneId = id;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public String getOtherGeneDisease() {
		return otherGeneDisease;
	}
	public void setOtherGeneDisease(String otherGeneDisease) {
		this.otherGeneDisease = otherGeneDisease;
	}
	public Integer getLiveStatus() {
		return liveStatus;
	}
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}

}
