package com.esuizhen.cloudservice.followup.model.followupresult;

import java.util.Date;
import java.util.List;

public class TFollowupResultDetailInfo {

	/**
	 * 随访结果ID,主键
	 */
	private String followupResultId;

	/**
	 * 随访结果暂存ID,主键
	 */
	private String followupResultBuffId;

	/**
	 * 回复内容
	 */
	private String replyContent;

	/**
	 * 随访任务分配ID
	 */
	private String followupAssignId;

	/**
	 * 随访任务ID
	 */
	private String followupTaskId;

	/**
	 * 患者ID。外键: u_patient.patientId
	 */
	private Long patientId;

	/**
	 * 医院ID。外键:u_hospital.hospitalId
	 */
	private Integer hospitalId;

	/**
	 * 随访人员。外键: u_doctor.doctorId
	 */
	private Long operator;

	/**
	 * 随访结果类型。外键。
	 * meta_followup_result_value
	 * .followupResultValueId
	 */
	private Integer followupResultValue;

	/**
	 * 随访结果名称
	 */
	private String followupResultValueName;

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
	 * 是否在院死亡。 0:否；1:是
	 */
	private Integer isInHospitalDeath;

	/**
	 * 是否肿瘤死亡。 0:否；1:是
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
	 * 随访方式。外键。
	 * meta_followup_way.followupWayId
	 */
	private Integer followupWay;

	/**
	 * 随访方式名称
	 */
	private String followupWayName;

	private Integer followupResultValueType;

	/**
	 * 随访内容模板ID。
	 */
	private String contentTemplateId;

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
	 * 备注
	 */
	private String remark;

	/**
	 * 短信下发ID
	 */
	private Long reqId;

	private Integer syncFlag;

	private Integer sourceFlag;

	private Date createTime;

	private Date updateTime;

	private String trueName;

	private Date sendTime;

	private Date replyTime;

	private Integer followupFlag;

	private Integer lostFollowupCauseResultValue;

	private String lostFollowupCause;

	private String followupTypeName;

	private String sourceDiagnosis;

	/**
	 * 随访人员名称
	 */
	private String operatorName;

	/**
	 * 确诊时间
	 */
	private Date confirmedDate;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 随访标识结果暂存或正式
	 */
	private String resultFlagName;

	/**
	 * 性别
	 */
	private String sexTxt;

	/**
	 * 患者详细信息
	 */
	private TFollowupResultPatientInfo patient;

	/**
	 * 患者联系方式
	 */
	private List<TPatientContactInfo> patientContactList;

	/**
	 * 治疗方式
	 */
	private List<TTreatmentInfo> treatmentList;

	/**
	 * 随访结果类型
	 */
	private Integer followupResultType;

	/**
	 * 联系人ID
	 */
	private Long patientFamilyId;

	private String patientNo;// 病案号

	/**
	 * 状态 1：暂存； 2：正式；
	 */
	private Integer followupResultState;

	private Long updateOperator;

	private String updateOperatorName;

	private Integer phoneRecording; // 是否有录音
	// 1：代表有录音，0：代表无
	private Integer readFlag; // 录音是否已读

	// 1：代表已读，0：未读
	
	//add by fanpanwei 短信解析修改标识 默认是0：非短信解析修改;1：是短信解析修改
	private Integer followupResultBySmsFlag=0;

	// 全程诊疗 add by zhuguo
	private String wholeProcessFlag;
	
	public String getWholeProcessFlag() {
		return wholeProcessFlag;
	}

	public void setWholeProcessFlag(String wholeProcessFlag) {
		this.wholeProcessFlag = wholeProcessFlag;
	}
	
	public Long getUpdateOperator() {
		return updateOperator;
	}

	public Integer getPhoneRecording() {
		return phoneRecording;
	}

	public void setPhoneRecording(Integer phoneRecording) {
		this.phoneRecording = phoneRecording;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public void setUpdateOperator(Long updateOperator) {
		this.updateOperator = updateOperator;
	}

	public String getUpdateOperatorName() {
		return updateOperatorName;
	}

	public void setUpdateOperatorName(String updateOperatorName) {
		this.updateOperatorName = updateOperatorName;
	}

	public Integer getFollowupResultType() {
		return followupResultType;
	}

	public void setFollowupResultType(Integer followupResultType) {
		this.followupResultType = followupResultType;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public List<TTreatmentInfo> getTreatmentList() {
		return treatmentList;
	}

	public void setTreatmentList(List<TTreatmentInfo> treatmentList) {
		this.treatmentList = treatmentList;
	}

	public Integer getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}

	public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}

	public String getSexTxt() {
		return sexTxt;
	}

	public void setSexTxt(String sexTxt) {
		this.sexTxt = sexTxt;
	}

	public String getResultFlagName() {
		return resultFlagName;
	}

	public void setResultFlagName(String resultFlagName) {
		this.resultFlagName = resultFlagName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public String getLostFollowupCause() {
		return lostFollowupCause;
	}

	public void setLostFollowupCause(String lostFollowupCause) {
		this.lostFollowupCause = lostFollowupCause;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
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

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}

	public String getFollowupAssignId() {
		return followupAssignId;
	}

	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public String getRelapseParts() {
		return relapseParts;
	}

	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}

	public Date getRelapseDate() {
		return relapseDate;
	}

	public void setRelapseDate(Date relapseDate) {
		this.relapseDate = relapseDate;
	}

	public String getTransferParts() {
		return transferParts;
	}

	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public Integer getIsInHospitalDeath() {
		return isInHospitalDeath;
	}

	public void setIsInHospitalDeath(Integer isInHospitalDeath) {
		this.isInHospitalDeath = isInHospitalDeath;
	}

	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}

	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getOtherCause() {
		return otherCause;
	}

	public void setOtherCause(String otherCause) {
		this.otherCause = otherCause;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public String getFollowupResultPhone() {
		return followupResultPhone;
	}

	public void setFollowupResultPhone(String followupResultPhone) {
		this.followupResultPhone = followupResultPhone;
	}

	public Date getFollowupTime() {
		return followupTime;
	}

	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
	}

	public String getPhoneRecordUrl() {
		return phoneRecordUrl;
	}

	public void setPhoneRecordUrl(String phoneRecordUrl) {
		this.phoneRecordUrl = phoneRecordUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public List<TPatientContactInfo> getPatientContactList() {
		return patientContactList;
	}

	public void setPatientContactList(List<TPatientContactInfo> patientContactList) {
		this.patientContactList = patientContactList;
	}

	public TFollowupResultPatientInfo getPatient() {
		return patient;
	}

	public void setPatient(TFollowupResultPatientInfo patient) {
		this.patient = patient;
	}

	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}

	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	public Integer getFollowupResultValueType() {
		return followupResultValueType;
	}

	public void setFollowupResultValueType(Integer followupResultValueType) {
		this.followupResultValueType = followupResultValueType;
	}

	public String getFollowupTypeName() {
		return followupTypeName;
	}

	public void setFollowupTypeName(String followupTypeName) {
		this.followupTypeName = followupTypeName;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getFollowupWayName() {
		return followupWayName;
	}

	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Long getPatientFamilyId() {
		return patientFamilyId;
	}

	public void setPatientFamilyId(Long patientFamilyId) {
		this.patientFamilyId = patientFamilyId;
	}

	public Integer getFollowupResultState() {
		return followupResultState;
	}

	public void setFollowupResultState(Integer followupResultState) {
		this.followupResultState = followupResultState;
	}

	public Integer getFollowupResultBySmsFlag() {
		return followupResultBySmsFlag;
	}

	public void setFollowupResultBySmsFlag(Integer followupResultBySmsFlag) {
		this.followupResultBySmsFlag = followupResultBySmsFlag;
	}
}
