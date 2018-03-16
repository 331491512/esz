package com.esuizhen.cloudservice.followup.model.followup;

import java.util.Date;


public class FollowupResult{
	/**
	 * 随访结果ID。主键。 唯一标识一项随访结果。格式： RESUYYYYMMDDHHMMSSnnnnnn。 如：RESU20151110152701000001。
	 */
	private String followupResultId;
	/**
	 * 随访任务ID。外键：followup_task.followupTaskId
	 */
	private String followupTaskId;
	/**
	 * 患者ID。外键： u_patient.patientId
	 */
	private Long patientId;
	/**
	 * 随访人员。外键: u_doctor.doctorId
	 */
	private Integer operator;
	/**
	 * 随访结果类型。外键。meta_followup_result_type.followupResultTypeId
	 */
	private Integer followupResultValue;
	/**
	 * 复发部位。
	 */
	private String relapseParts;
	/**
	 * 复发检查时间
	 */
	private Date relapseDate;
	/**
	 * 转移部位
	 */
	private String transferParts;
	/**
	 * 转移检查时间
	 */
	private Date transferDate;
	/**
	 * 死亡时间
	 */
	private Date deathDate;
	/**
	 * 是否在院死亡。 0：否；1：是
	 */
	private Integer isInHospitalDeath;
	/**
	 * 是否肿瘤死亡。 0：否；1：是
	 */
	private Integer isTumourDeath;
	/**
	 * 死亡原因
	 */
	private String deathCause;
	/**
	 * 其他原因
	 */
	private String otherCause;
	/**
	 * 随访方式。外键。 meta_followup_way.followupWayId
	 */
	private Integer followupWay;
	/**
	 * 随访内容模板ID。
	 */
	private Integer contentTemplateId;
	/**
	 * 随访患者电话
	 */
	private String followupResultPhone;
	/**
	 * 随访时间。
	 */
	private Date followupTime;
	/**
	 * 电话录音路径。
	 */
	private String phoneRecordUrl;
	
	/**
	 * 医院ID
	 */
	private Integer hospitalId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 数据同步标识。
	 */
	private Integer syncFlag;
	/**
	 * 数据来源标识。
	 */
	private Integer sourceFlag;
	
	/**
	 * 随访状态：1：暂存；2：正式；
	 */
	private Integer state;
	/**
	 * 记录创建时间。
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	
	public Integer getHospitalId()
	{
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId)
	{
		this.hospitalId = hospitalId;
	}

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}

	public void setFollowupTaskId(String value) {
		this.followupTaskId = value;
	}
	
	public String getFollowupTaskId() {
		return this.followupTaskId;
	}
	public void setPatientId(Long value) {
		this.patientId = value;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setOperator(Integer value) {
		this.operator = value;
	}
	
	public Integer getOperator() {
		return this.operator;
	}
	public void setFollowupResultValue(Integer value) {
		this.followupResultValue = value;
	}
	
	public Integer getFollowupResultValue() {
		return this.followupResultValue;
	}
	public void setRelapseParts(String value) {
		this.relapseParts = value;
	}
	
	public String getRelapseParts() {
		return this.relapseParts;
	}
	public void setRelapseDate(Date value) {
		this.relapseDate = value;
	}
	
	public Date getRelapseDate() {
		return this.relapseDate;
	}
	public void setTransferParts(String value) {
		this.transferParts = value;
	}
	
	public String getTransferParts() {
		return this.transferParts;
	}
	public void setTransferDate(Date value) {
		this.transferDate = value;
	}
	
	public Date getTransferDate() {
		return this.transferDate;
	}
	public void setDeathDate(Date value) {
		this.deathDate = value;
	}
	
	public Date getDeathDate() {
		return this.deathDate;
	}
	public void setIsInHospitalDeath(Integer value) {
		this.isInHospitalDeath = value;
	}
	
	public Integer getIsInHospitalDeath() {
		return this.isInHospitalDeath;
	}
	public void setIsTumourDeath(Integer value) {
		this.isTumourDeath = value;
	}
	
	public Integer getIsTumourDeath() {
		return this.isTumourDeath;
	}
	public void setDeathCause(String value) {
		this.deathCause = value;
	}
	
	public String getDeathCause() {
		return this.deathCause;
	}
	public void setOtherCause(String value) {
		this.otherCause = value;
	}
	
	public String getOtherCause() {
		return this.otherCause;
	}
	public void setFollowupWay(Integer value) {
		this.followupWay = value;
	}
	
	public Integer getFollowupWay() {
		return this.followupWay;
	}
	public void setContentTemplateId(Integer value) {
		this.contentTemplateId = value;
	}
	
	public Integer getContentTemplateId() {
		return this.contentTemplateId;
	}
	public void setFollowupResultPhone(String value) {
		this.followupResultPhone = value;
	}
	
	public String getFollowupResultPhone() {
		return this.followupResultPhone;
	}
	public void setFollowupTime(Date value) {
		this.followupTime = value;
	}
	
	public Date getFollowupTime() {
		return this.followupTime;
	}
	public void setPhoneRecordUrl(String value) {
		this.phoneRecordUrl = value;
	}
	
	public String getPhoneRecordUrl() {
		return this.phoneRecordUrl;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}
	public void setSyncFlag(Integer value) {
		this.syncFlag = value;
	}
	
	public Integer getSyncFlag() {
		return this.syncFlag;
	}
	public void setSourceFlag(Integer value) {
		this.sourceFlag = value;
	}
	
	public Integer getSourceFlag() {
		return this.sourceFlag;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}

