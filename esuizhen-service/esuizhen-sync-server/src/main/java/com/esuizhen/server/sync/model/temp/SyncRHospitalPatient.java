package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 *	医院患者bean
 * @author LHY
 */
public class SyncRHospitalPatient implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Long id;   
	private Long patientId;   
	private String patientUuid;  
	private Integer hospitalId;   
	private String patientNo;
	private Integer sourceFlag;   
	private Date lastestFollowupResultSyncTime;
	private Integer hospitalCertificateState;   
	private Date createTime;
	private String batchId;
	
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Date getLastestFollowupResultSyncTime() {
		return lastestFollowupResultSyncTime;
	}
	public void setLastestFollowupResultSyncTime(Date lastestFollowupResultSyncTime) {
		this.lastestFollowupResultSyncTime = lastestFollowupResultSyncTime;
	}
	public Integer getHospitalCertificateState() {
		return hospitalCertificateState;
	}
	public void setHospitalCertificateState(Integer hospitalCertificateState) {
		this.hospitalCertificateState = hospitalCertificateState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}