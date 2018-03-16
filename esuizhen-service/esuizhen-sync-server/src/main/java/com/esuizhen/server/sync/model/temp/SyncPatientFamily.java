package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/**
 * 联系人bean
 * @author LHY
 */
public class SyncPatientFamily implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Long id;  
	private String contactId;
	private Integer opFlag;
	private Long patientId;  
	private String patientUuid;   
	private Integer patientRelation;   
	private String familyName;   
	private String familyPhone;   
	private String zipcode;   
	private String address;  
	private Integer isDefault;   
	private Integer isValid;   
	private Date createTime;   
	private Date updateTime;   
	private Integer phoneStatus;  
	private Long operator;   
	private String operatorUuid;  
	private Integer handleFlag;   
	private String remark;   
	private Date rawCreateTime;   
	private Integer sourceFlag;   
	private Integer mergeFlag;  
	private Long mergeFrom;  
	private String mergeFromUuid;  
	private Long mergeTarget; 
	private String mergeTargetUuid;  
	private Date mergeTime;  
	private Long specialDiseaseRegisterId;
	private String batchId;
	
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
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
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Long getOperator() {
		return operator;
	}
	public void setOperator(Long operator) {
		this.operator = operator;
	}
	public String getOperatorUuid() {
		return operatorUuid;
	}
	public void setOperatorUuid(String operatorUuid) {
		this.operatorUuid = operatorUuid;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public Integer getOpFlag() {
		return opFlag;
	}
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}
	public TBatchDataResultInfo createResultInfo() {
		TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
		resultInfo.setSyncTime(new Date());
		resultInfo.setResultId(this.contactId);
		return resultInfo;
	} 
}