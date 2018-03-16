package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 电子病历主表bean
 * @author YYCHEN
 *
 */
public class MedicalRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String emrId;
	private String emrNo;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer emrType;
	private Integer emrSubType;
	private Integer subdivision;
	private String remark;
	private Long creatorId;
	private String creatorUuid;
	private Integer hospitalId;
	private String hospitalUuid;
	private Integer sourceFlag;
	private Integer structFlag;
	private Integer visibleFlag;
	private Date visitTime;
	
	/*
	  	处理标识。
		0：待处理（增量用户）；（默认）
		1：已处理
		数据采集时的临时表，以及采集后的目标表，均使用此标识表示记录是否需要处理（0表示需要处理）。
	 */
	private Integer handleFlag;
	private Date createTime;
	private Date updateTime;
	private Integer syncFlag;
	private Date syncTime;
	private Date rawCreateTime;
	/**
	 * @return the emrId
	 */
	public String getEmrId() {
		return emrId;
	}
	/**
	 * @param emrId the emrId to set
	 */
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public String getCreatorUuid() {
		return creatorUuid;
	}
	public void setCreatorUuid(String creatorUuid) {
		this.creatorUuid = creatorUuid;
	}
	/**
	 * @return the emrNo
	 */
	public String getEmrNo() {
		return emrNo;
	}
	/**
	 * @param emrNo the emrNo to set
	 */
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
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
	 * @return the patientUuid
	 */
	public String getPatientUuid() {
		return patientUuid;
	}
	/**
	 * @param patientUuid the patientUuid to set
	 */
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	/**
	 * @return the patientNo
	 */
	public String getPatientNo() {
		return patientNo;
	}
	/**
	 * @param patientNo the patientNo to set
	 */
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	/**
	 * @return the emrType
	 */
	public Integer getEmrType() {
		return emrType;
	}
	/**
	 * @param emrType the emrType to set
	 */
	public void setEmrType(Integer emrType) {
		this.emrType = emrType;
	}
	/**
	 * @return the emrSubType
	 */
	public Integer getEmrSubType() {
		return emrSubType;
	}
	/**
	 * @param emrSubType the emrSubType to set
	 */
	public void setEmrSubType(Integer emrSubType) {
		this.emrSubType = emrSubType;
	}
	/**
	 * @return the subdivision
	 */
	public Integer getSubdivision() {
		return subdivision;
	}
	/**
	 * @param subdivision the subdivision to set
	 */
	public void setSubdivision(Integer subdivision) {
		this.subdivision = subdivision;
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
	 * @return the creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}
	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}
	/**
	 * @return the sourceFlag
	 */
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	/**
	 * @param sourceFlag the sourceFlag to set
	 */
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	/**
	 * @return the structFlag
	 */
	public Integer getStructFlag() {
		return structFlag;
	}
	/**
	 * @param structFlag the structFlag to set
	 */
	public void setStructFlag(Integer structFlag) {
		this.structFlag = structFlag;
	}
	/**
	 * @return the visibleFlag
	 */
	public Integer getVisibleFlag() {
		return visibleFlag;
	}
	/**
	 * @param visibleFlag the visibleFlag to set
	 */
	public void setVisibleFlag(Integer visibleFlag) {
		this.visibleFlag = visibleFlag;
	}
	/**
	 * @return the visitTime
	 */
	public Date getVisitTime() {
		return visitTime;
	}
	/**
	 * @param visitTime the visitTime to set
	 */
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
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
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
}
