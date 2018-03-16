package com.esuizhen.cloudservice.ehr.model.patientinfo;

import java.util.Date;

public class TPatientProfile
{
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 患者病案号
	 */
	private String patientNo;
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 生日
	 */
	private Date birthDate;

	/**
	 * 证件类型
	 */
	private Integer idType;
	
	/**
	 * 证件号码
	 */
	private String identification;

	/**
	 * 患者姓名
	 */
	private String trueName;
	
	/**
	 * 现住地址
	 */
	private String address;
	
	private Integer patientType;
	/**
	 * 患者基本信息登记Id
	 */
	private Long specialDiseaseRegisterId;
	
	/**
	 * 编目状态，新定义
	 */
	private Integer catalogState;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 主治医师
	 */
	private Long inchargeDoctor;
	
	private String mobile;
	
	private String familyPhone;
	
	private Integer liveStatus;
	
	private Integer medicalPayType;
	
	
	
	public Integer getMedicalPayType() {
		return medicalPayType;
	}

	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}

	public String getPatientNo()
	{
		return patientNo;
	}

	public void setPatientNo(String patientNo)
	{
		this.patientNo = patientNo;
	}

	public Integer getSex()
	{
		return sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Integer getIdType()
	{
		return idType;
	}

	public void setIdType(Integer idType)
	{
		this.idType = idType;
	}

	public String getIdentification()
	{
		return identification;
	}

	public void setIdentification(String identification)
	{
		this.identification = identification;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Integer getPatientType() {
		return patientType;
	}

	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}

	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}

	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInchargeDoctor() {
		return inchargeDoctor;
	}

	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}

