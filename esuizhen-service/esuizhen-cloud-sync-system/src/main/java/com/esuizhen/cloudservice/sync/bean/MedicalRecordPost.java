package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Title:ProductServiceApply</p>
 * <p>Description:病案邮寄bean类</p>
 * @author fanpanwei
 * @date 2016年10月19日 上午11:36:36
 */
public class MedicalRecordPost implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String productApplyId;
	private String patientNo;
	private String patientName;
	private Integer progressState;
	private String description;
	private String patientMobile;
	private String relatedPatientNos;
	private Date applyTime;
	private String recipientName;
	private String recipientMobile;
	private String postCode;
	private String city;
	private String address;
	private Integer productSubType;
	private String serviceCode;
	private Integer subType;
	private Integer syncFlag;
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	private Integer hospitalId;
	
	private List<MedicalPostDetail> caseExpressList;

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getProgressState() {
		return progressState;
	}
	public void setProgressState(Integer progressState) {
		this.progressState = progressState;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getRelatedPatientNos() {
		return relatedPatientNos;
	}
	public void setRelatedPatientNos(String relatedPatientNos) {
		this.relatedPatientNos = relatedPatientNos;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public List<MedicalPostDetail> getCaseExpressList() {
		return caseExpressList;
	}
	public void setCaseExpressList(List<MedicalPostDetail> caseExpressList) {
		this.caseExpressList = caseExpressList;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientMobile() {
		return recipientMobile;
	}
	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
