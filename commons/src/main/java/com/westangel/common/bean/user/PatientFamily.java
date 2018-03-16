/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DeviceInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:54:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.user;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: PatientFamily 
* @Description: 患者家庭联系人bean
* @author YYCHEN
* @date 2016年1月27日 下午14:27:01  
*/
public class PatientFamily implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long patientId;
	private String contactId;
	private Integer patientRelation;
	private String familyName;
	private String familyPhone;
	private String address;
	private Date createTime;
	private Date updateTime;
	private String remark;
	private long operatorId;
	private Integer sourceFlag;
	
	private String patientUuid;
	
	//以下为患者随访新增字段
	private String zipcode;
	
	private Integer isDefault;
	
	private Integer isValid;
	
	private String patientRelationName;
	
	private Integer phoneStatus;
	/**
	 * 电话状态
	 */
	private String phoneStatusName;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		if(isDefault == null) {
			isDefault = 0;
		}
		this.isDefault = isDefault;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		if(isValid == null) {
			isValid = 1;
		}
		this.isValid = isValid;
	}
	public String getPatientRelationName() {
		return patientRelationName;
	}
	public void setPatientRelationName(String patientRelationName) {
		this.patientRelationName = patientRelationName;
	}
	public Integer getPhoneStatus() {
		return phoneStatus;
	}
	public void setPhoneStatus(Integer phoneStatus) {
		this.phoneStatus = phoneStatus;
	}
	public long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
	public String getPhoneStatusName() {
		return phoneStatusName;
	}
	public void setPhoneStatusName(String phoneStatusName) {
		this.phoneStatusName = phoneStatusName;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
}
