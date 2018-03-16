package com.westangel.common.bean.ehr;


public class MetaEicd10{
	
	/**
	 * 疾病编码。主键。
	 */
	private java.lang.String diseaseCode;
	/**
	 * 疾病名
	 */
	private java.lang.String diseaseName;
	/**
	 * 性别限制。 1：仅男；2：仅女
	 */
	private java.lang.Integer sexLimit;
	/**
	 * 疗效限制
	 */
	private java.lang.String curativeEffect;
	/**
	 * 助记码
	 */
	private java.lang.String helpRememberCode;

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
	
	public void setDiseaseCode(java.lang.String value) {
		this.diseaseCode = value;
	}
	
	public java.lang.String getDiseaseCode() {
		return this.diseaseCode;
	}
	public void setDiseaseName(java.lang.String value) {
		this.diseaseName = value;
	}
	
	public java.lang.String getDiseaseName() {
		return this.diseaseName;
	}
	public void setSexLimit(java.lang.Integer value) {
		this.sexLimit = value;
	}
	
	public java.lang.Integer getSexLimit() {
		return this.sexLimit;
	}
	public void setCurativeEffect(java.lang.String value) {
		this.curativeEffect = value;
	}
	
	public java.lang.String getCurativeEffect() {
		return this.curativeEffect;
	}
	public void setHelpRememberCode(java.lang.String value) {
		this.helpRememberCode = value;
	}
	
	public java.lang.String getHelpRememberCode() {
		return this.helpRememberCode;
	}

	public String getDiseaseTypeId()
	{
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(String diseaseTypeId)
	{
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName()
	{
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName)
	{
		this.diseaseTypeName = diseaseTypeName;
	}

	public String getDeseaseBodyPartId()
	{
		return deseaseBodyPartId;
	}

	public void setDeseaseBodyPartId(String deseaseBodyPartId)
	{
		this.deseaseBodyPartId = deseaseBodyPartId;
	}

	public String getDeseaseBodyPartName()
	{
		return deseaseBodyPartName;
	}

	public void setDeseaseBodyPartName(String deseaseBodyPartName)
	{
		this.deseaseBodyPartName = deseaseBodyPartName;
	}
	
	

}

