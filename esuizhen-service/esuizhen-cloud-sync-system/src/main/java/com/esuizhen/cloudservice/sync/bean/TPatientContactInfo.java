package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 医生基本信息
 * @author YYCHEN
 *
 */
public class TPatientContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String patientUuid;
	private Long patientId;
	private Integer patientRelation;
	private String familyName;
	private String familyPhone;
	private String contactId;
	private String flag;
	private Integer phoneStatus;
	private String zipcode;
	private Integer isDefault;
	private Integer isValid;
	private String address;
	private String remark;
	private Date createTime;
	private Date updateTime;
	private Integer sourceFlag;
	private Integer hospitalId;
	
	/**
	 * @return the patientUuid
	 */
	public String getPatientUuid() {
		return patientUuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param patientUuid the patientUuid to set
	 */
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the patientRelation
	 */
	public Integer getPatientRelation() {
		return patientRelation;
	}

	/**
	 * @param patientRelation the patientRelation to set
	 */
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the familyPhone
	 */
	public String getFamilyPhone() {
		return familyPhone;
	}

	/**
	 * @param familyPhone the familyPhone to set
	 */
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(Integer phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public String getZipCode() {
		return zipcode;
	}

	public void setZipCode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
}
