package com.esuizhen.cloudservice.questionnaire.bean;

import java.util.Date;

public class TPatientContactInfo {
	/**
	 * 主键。自增
	 */
	private Long id;

	/**
	 * 患者ID
	 */
	private Long patientId;

	/**
	 * 患者关系。 0: 本人；(默认) >0: 家属或其他
	 */
	private Integer patientRelation;

	private String patientRelationName;

	/**
	 * 家属姓名
	 */
	private String familyName;

	/**
	 * 家属电话
	 */
	private String familyPhone;

	/**
	 * 家属地址。
	 */
	private String address;

	/**
	 * 备注。如“同事”、“舅舅”、“父亲”等。 对关系的详细和具体说明。
	 */
	private String remark;

	/**
	 * 是否默认电话。 1:是；0：否
	 */
	private Integer isDefault;

	/**
	 * 是否有效。 1：是（默认）；0：否
	 */
	private Integer isValid;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	private String zipcode;
	
	/**
	 * 电话最后一次随访状态
	 */
	private Integer phoneStatus;
	
	/**
	 * 电话最后一次随访状态名称
	 */
	private String phoneStatusName;
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPatientRelationName() {
		return patientRelationName;
	}

	public void setPatientRelationName(String patientRelationName) {
		this.patientRelationName = patientRelationName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getPatientRelation() {
		return patientRelation;
	}

	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(Integer phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public String getPhoneStatusName() {
		return phoneStatusName;
	}

	public void setPhoneStatusName(String phoneStatusName) {
		this.phoneStatusName = phoneStatusName;
	}
}
