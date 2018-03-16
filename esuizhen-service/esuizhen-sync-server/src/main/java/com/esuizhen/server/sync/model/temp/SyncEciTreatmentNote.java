package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 治疗bean
 * 
 * @author LHY
 */
public class SyncEciTreatmentNote implements Serializable {

	private static final long serialVersionUID = 1L;
	private String treatmentId;
	private String inhospitalId;
	private String emrId;
	private Integer tempId;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer hospitalId;
	private Integer treatmentTypeId;
	private String rawTreatmentType;
	private String opCode;
	private String treatmentName;
	private String treatmentCourse;
	private String totalCourse;
	private Integer treatmentProcessFlag;
	private String treatmentEffect;
	private String treatmentDesc;
	private Date treatmentBeginTime;
	private Date treatmentEndTime;
	private Integer sourceFlag;
	private Date createTime;
	private Date updateTime;
	private Date rawCreateTime;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private Date mergeTime;
	private String batchId;

	public String getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}
	
	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public Integer getTempId() {
		return tempId;
	}

	public void setTempId(Integer tempId) {
		this.tempId = tempId;
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

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}

	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}

	public String getRawTreatmentType() {
		return rawTreatmentType;
	}

	public void setRawTreatmentType(String rawTreatmentType) {
		this.rawTreatmentType = rawTreatmentType;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getTreatmentCourse() {
		return treatmentCourse;
	}

	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}

	public String getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(String totalCourse) {
		this.totalCourse = totalCourse;
	}

	public Integer getTreatmentProcessFlag() {
		return treatmentProcessFlag;
	}

	public void setTreatmentProcessFlag(Integer treatmentProcessFlag) {
		this.treatmentProcessFlag = treatmentProcessFlag;
	}

	public String getTreatmentEffect() {
		return treatmentEffect;
	}

	public void setTreatmentEffect(String treatmentEffect) {
		this.treatmentEffect = treatmentEffect;
	}

	public String getTreatmentDesc() {
		return treatmentDesc;
	}

	public void setTreatmentDesc(String treatmentDesc) {
		this.treatmentDesc = treatmentDesc;
	}

	public Date getTreatmentBeginTime() {
		return treatmentBeginTime;
	}

	public void setTreatmentBeginTime(Date treatmentBeginTime) {
		this.treatmentBeginTime = treatmentBeginTime;
	}

	public Date getTreatmentEndTime() {
		return treatmentEndTime;
	}

	public void setTreatmentEndTime(Date treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
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

	public Date getRawCreateTime() {
		return rawCreateTime;
	}

	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
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

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}