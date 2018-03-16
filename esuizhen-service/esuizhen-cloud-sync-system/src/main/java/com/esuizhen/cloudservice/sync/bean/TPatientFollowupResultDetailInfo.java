package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者随访结果信息
 * @author YYCHEN
 *
 */
public class TPatientFollowupResultDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long patientId;
	private String patientUuid;
	private String operatorUuid;
	private Integer hospitalId;
	
	private String followupAssignId;
	private Integer lostFollowupFlag;
	private Integer lostFollowupCauseResultValue;
	private Integer state;
	private Integer seq;

	private String followupResultId;
	private String followupResultBuffId;
	private String followupTaskId;
	private Long operator;
	private Integer followupResultValue;
	private String relapseParts;
	private Date relapseDate;
	private String transferParts;
	private Date transferDate;
	private Date deathDate;
	private Integer isInHospitalDeath;
	private Integer isTumourDeath;
	private String deathCause;
	private String otherCause;
	private Integer followUpWay;
	private Integer followupWay;
	private Integer contentTemplateId;
	private String followupResultPhone;
	private Date followupTime;
	private String phoneRecordUrl;
	
	private String remark;
	//b 端 随访任务编号
	private String messageId;
	
	private Integer sourceFlag;
	private Integer syncFlag;
	private Date createTime;
	private Date updateTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the patientUuid
	 */
	public String getPatientUuid() {
		return patientUuid;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @param patientUuid the patientUuid to set
	 */
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	/**
	 * @return the operatorUuid
	 */
	public String getOperatorUuid() {
		return operatorUuid;
	}

	/**
	 * @param operatorUuid the operatorUuid to set
	 */
	public void setOperatorUuid(String operatorUuid) {
		this.operatorUuid = operatorUuid;
	}

	/**
	 * @return the followupResultValue
	 */
	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	/**
	 * @param followupResultValue the followupResultValue to set
	 */
	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	/**
	 * @return the relapseParts
	 */
	public String getRelapseParts() {
		return relapseParts;
	}

	/**
	 * @param relapseParts the relapseParts to set
	 */
	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}

	/**
	 * @return the relapseDate
	 */
	public Date getRelapseDate() {
		return relapseDate;
	}

	/**
	 * @param relapseDate the relapseDate to set
	 */
	public void setRelapseDate(Date relapseDate) {
		this.relapseDate = relapseDate;
	}

	/**
	 * @return the transferParts
	 */
	public String getTransferParts() {
		return transferParts;
	}

	/**
	 * @param transferParts the transferParts to set
	 */
	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}

	/**
	 * @return the transferDate
	 */
	public Date getTransferDate() {
		return transferDate;
	}

	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return deathDate;
	}

	/**
	 * @param deathDate the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * @return the isInHospitalDeath
	 */
	public Integer getIsInHospitalDeath() {
		return isInHospitalDeath;
	}

	/**
	 * @param isInHospitalDeath the isInHospitalDeath to set
	 */
	public void setIsInHospitalDeath(Integer isInHospitalDeath) {
		this.isInHospitalDeath = isInHospitalDeath;
	}

	/**
	 * @return the isTumourDeath
	 */
	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}

	/**
	 * @param isTumourDeath the isTumourDeath to set
	 */
	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}

	/**
	 * @return the deathCause
	 */
	public String getDeathCause() {
		return deathCause;
	}

	/**
	 * @param deathCause the deathCause to set
	 */
	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	/**
	 * @return the otherCause
	 */
	public String getOtherCause() {
		return otherCause;
	}

	/**
	 * @param otherCause the otherCause to set
	 */
	public void setOtherCause(String otherCause) {
		this.otherCause = otherCause;
	}

	/**
	 * @return the followUpWay
	 */
	public Integer getFollowUpWay() {
		return followUpWay;
	}

	/**
	 * @param followUpWay the followUpWay to set
	 */
	public void setFollowUpWay(Integer followUpWay) {
		this.followUpWay = followUpWay;
	}

	/**
	 * @return the followupResultPhone
	 */
	public String getFollowupResultPhone() {
		return followupResultPhone;
	}

	/**
	 * @param followupResultPhone the followupResultPhone to set
	 */
	public void setFollowupResultPhone(String followupResultPhone) {
		this.followupResultPhone = followupResultPhone;
	}

	/**
	 * @return the followupTime
	 */
	public Date getFollowupTime() {
		return followupTime;
	}

	/**
	 * @param followupTime the followupTime to set
	 */
	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
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
	 * @return the followupTaskId
	 */
	public String getFollowupTaskId() {
		return followupTaskId;
	}

	/**
	 * @param followupTaskId the followupTaskId to set
	 */
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
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

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	/** 
	* @return phoneRecordUrl 
	*/
	public String getPhoneRecordUrl() {
		return phoneRecordUrl;
	}

	/** 
	* @param phoneRecordUrl 要设置的 phoneRecordUrl 
	*/
	public void setPhoneRecordUrl(String phoneRecordUrl) {
		this.phoneRecordUrl = phoneRecordUrl;
	}

	/** 
	* @return syncFlag 
	*/
	public Integer getSyncFlag() {
		return syncFlag;
	}

	/** 
	* @param syncFlag 要设置的 syncFlag 
	*/
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	/** 
	* @return contentTemplateId 
	*/
	public Integer getContentTemplateId() {
		return contentTemplateId;
	}

	/** 
	* @param contentTemplateId 要设置的 contentTemplateId 
	*/
	public void setContentTemplateId(Integer contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}

	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}

	public String getFollowupAssignId() {
		return followupAssignId;
	}

	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}

	public Integer getLostFollowupFlag() {
		return lostFollowupFlag;
	}

	public void setLostFollowupFlag(Integer lostFollowupFlag) {
		this.lostFollowupFlag = lostFollowupFlag;
	}

	public Integer getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}

	public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}
	
}
