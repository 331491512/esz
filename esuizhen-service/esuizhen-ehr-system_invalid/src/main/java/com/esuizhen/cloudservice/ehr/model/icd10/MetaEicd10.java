package com.esuizhen.cloudservice.ehr.model.icd10;

import java.util.Date;

public class MetaEicd10{
	
	/**
	 * 疾病编码。主键。
	 */
	private String diseaseCode;
	/**
	 * 疾病名
	 */
	private String diseaseName;
	/**
	 * 性别限制。 1：仅男；2：仅女
	 */
	private Integer sexLimit;
	/**
	 * 疗效限制
	 */
	private String curativeEffect;
	/**
	 * 助记码
	 */
	private String helpRememberCode;

	/**
	 * 病种类型
	 */
	private String diseaseTypeId ;
	
	/**
	 * 病种名
	 */
	private String diseaseTypeName ; 
	
	/**
	 * 疾病部位ID
	 */
	private String deseaseBodyPartId ; 
	
	/**
	 * 疾病部位名称
	 */
	private String deseaseBodyPartName ;
	private Date createTime;
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public Integer getSexLimit() {
		return sexLimit;
	}
	public void setSexLimit(Integer sexLimit) {
		this.sexLimit = sexLimit;
	}
	public String getCurativeEffect() {
		return curativeEffect;
	}
	public void setCurativeEffect(String curativeEffect) {
		this.curativeEffect = curativeEffect;
	}
	public String getHelpRememberCode() {
		return helpRememberCode;
	}
	public void setHelpRememberCode(String helpRememberCode) {
		this.helpRememberCode = helpRememberCode;
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
	public String getDeseaseBodyPartId() {
		return deseaseBodyPartId;
	}
	public void setDeseaseBodyPartId(String deseaseBodyPartId) {
		this.deseaseBodyPartId = deseaseBodyPartId;
	}
	public String getDeseaseBodyPartName() {
		return deseaseBodyPartName;
	}
	public void setDeseaseBodyPartName(String deseaseBodyPartName) {
		this.deseaseBodyPartName = deseaseBodyPartName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}

