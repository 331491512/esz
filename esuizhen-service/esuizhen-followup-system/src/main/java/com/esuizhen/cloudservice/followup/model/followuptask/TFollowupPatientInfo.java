/**
 * 
 */
package com.esuizhen.cloudservice.followup.model.followuptask;

import java.util.Date;

/**
 * @author DaLoong
 * @date 2016-8-9 下午7:31:25
 */
public class TFollowupPatientInfo {

	String followupTaskId;

	String followupAssignId;

	Long patientId;// 患者ID。
	String patientNo;// 病案号
	String trueName;// 患者姓名
	String sourceDiseaseTypeName;// 病种
	String sourceDiagnosis;// 主要诊断
	String chargeDoctorName;// 主治医师
	Integer wxStateId;
	String wxState;// 微信状态
	Integer smsStateId;
	String smsState;// 短信状态
	Date smsReplyTime;// 短信回复时间
	String smsReplyContent;// 短信回复内容
	Date followupTime;// 随访时间
	Integer followupResultType; // 随访类型；1：有效；2：无效
	Integer followupResultValue;// 随访结果值
	String followupResultValueName;// 随访结果
	Integer followupState;// 随访状态
	String followupStateName;// 随访状态名称
	Integer followupWay;// 随访完成方式
	String followupWayName;// 随访完成方式名称

	Integer wxFlag;// 微信标识。
	// 1：有微信；0：无微信
	Integer mobileFlag; // 手机标识。
	// 1：有有效手机号，可以发短信；0：无有效手机号，不可以发短信
	Integer phoneFlag;// 电话标识。
	// 1：有有效电话，可以拨打电话；0：无有效电话，不可以拨打电话

	Integer followupFlag;// 随访标志
	// 0：不能随访 ;1：能随访（默认）;2：失访 ;3：无需随访

	/**
	 * 生存状态。 1：健在 （默认） 0：死亡
	 */
	Integer liveStatus;

	String inhospitalDoctorName;// 住院医师

	/**
	 * 数据来源标识。 1：医院随访系统 2：患者微信； 4：医生APP
	 * 5：历史导入； 7：医生工作站
	 */
	Integer sourceFlag;

	private Integer phoneRecording; // 是否有录音
									// 1：代表有录音，0：代表无
	private Integer readFlag; // 录音是否已读
								// 1：代表已读，0：未读
	
	private String nationName;
	private String nationIdStr;//多个民族id，用英文逗号隔开，如"1,2,3"
	private String sourceDiseaseTypeIdStr;//病种id，英文逗号分割[]，如"1,2,3"

	private String inhospitalState;//住院状态。0-在院、1-离院。
	
	public Integer getSourceFlag() {
		return sourceFlag;
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

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public String getInhospitalDoctorName() {
		return inhospitalDoctorName;
	}

	public void setInhospitalDoctorName(String inhospitalDoctorName) {
		this.inhospitalDoctorName = inhospitalDoctorName;
	}

	/**
	 * @return the followupResultType
	 */
	public Integer getFollowupResultType() {
		return followupResultType;
	}

	/**
	 * @param followupResultType
	 *            the followupResultType
	 *            to set
	 */
	public void setFollowupResultType(Integer followupResultType) {
		this.followupResultType = followupResultType;
	}

	/**
	 * @return the wxFlag
	 */
	public Integer getWxFlag() {
		return wxFlag;
	}

	/**
	 * @param wxFlag
	 *            the wxFlag to set
	 */
	public void setWxFlag(Integer wxFlag) {
		this.wxFlag = wxFlag;
	}

	/**
	 * @return the mobileFlag
	 */
	public Integer getMobileFlag() {
		return mobileFlag;
	}

	/**
	 * @param mobileFlag
	 *            the mobileFlag to set
	 */
	public void setMobileFlag(Integer mobileFlag) {
		this.mobileFlag = mobileFlag;
	}

	/**
	 * @return the phoneFlag
	 */
	public Integer getPhoneFlag() {
		return phoneFlag;
	}

	/**
	 * @param phoneFlag
	 *            the phoneFlag to set
	 */
	public void setPhoneFlag(Integer phoneFlag) {
		this.phoneFlag = phoneFlag;
	}

	/**
	 * @return the followupTaskId
	 */
	public String getFollowupTaskId() {
		return followupTaskId;
	}

	/**
	 * @param followupTaskId
	 *            the followupTaskId to
	 *            set
	 */
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	/**
	 * @return the followupAssignId
	 */
	public String getFollowupAssignId() {
		return followupAssignId;
	}

	/**
	 * @param followupAssignId
	 *            the followupAssignId
	 *            to set
	 */
	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId
	 *            the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the patientNo
	 */
	public String getPatientNo() {
		return patientNo;
	}

	/**
	 * @param patientNo
	 *            the patientNo to set
	 */
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName
	 *            the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @return the sourceDiseaseTypeName
	 */
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}

	/**
	 * @param sourceDiseaseTypeName
	 *            the
	 *            sourceDiseaseTypeName
	 *            to set
	 */
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}

	/**
	 * @return the sourceDiagnosis
	 */
	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	/**
	 * @param sourceDiagnosis
	 *            the sourceDiagnosis to
	 *            set
	 */
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	/**
	 * @return the chargeDoctorName
	 */
	public String getChargeDoctorName() {
		return chargeDoctorName;
	}

	/**
	 * @param chargeDoctorName
	 *            the chargeDoctorName
	 *            to set
	 */
	public void setChargeDoctorName(String chargeDoctorName) {
		this.chargeDoctorName = chargeDoctorName;
	}

	/**
	 * @return the wxState
	 */
	public String getWxState() {
		return wxState;
	}

	/**
	 * @param wxState
	 *            the wxState to set
	 */
	public void setWxState(String wxState) {
		this.wxState = wxState;
	}

	/**
	 * @return the smsState
	 */
	public String getSmsState() {
		return smsState;
	}

	/**
	 * @param smsState
	 *            the smsState to set
	 */
	public void setSmsState(String smsState) {
		this.smsState = smsState;
	}

	/**
	 * @return the smsReplyTime
	 */
	public Date getSmsReplyTime() {
		return smsReplyTime;
	}

	/**
	 * @param smsReplyTime
	 *            the smsReplyTime to
	 *            set
	 */
	public void setSmsReplyTime(Date smsReplyTime) {
		this.smsReplyTime = smsReplyTime;
	}

	/**
	 * @return the smsReplyContent
	 */
	public String getSmsReplyContent() {
		return smsReplyContent;
	}

	/**
	 * @param smsReplyContent
	 *            the smsReplyContent to
	 *            set
	 */
	public void setSmsReplyContent(String smsReplyContent) {
		this.smsReplyContent = smsReplyContent;
	}

	/**
	 * @return the followupTime
	 */
	public Date getFollowupTime() {
		return followupTime;
	}

	/**
	 * @param followupTime
	 *            the followupTime to
	 *            set
	 */
	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
	}

	/**
	 * @return the followupResultValue
	 */
	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	/**
	 * @param followupResultValue
	 *            the
	 *            followupResultValue to
	 *            set
	 */
	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	/**
	 * @return the
	 *         followupResultValueName
	 */
	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	/**
	 * @param followupResultValueName
	 *            the
	 *            followupResultValueName
	 *            to set
	 */
	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	/**
	 * @return the followupState
	 */
	public Integer getFollowupState() {
		return followupState;
	}

	/**
	 * @param followupState
	 *            the followupState to
	 *            set
	 */
	public void setFollowupState(Integer followupState) {
		this.followupState = followupState;
	}

	/**
	 * @return the followupStateName
	 */
	public String getFollowupStateName() {
		return followupStateName;
	}

	/**
	 * @param followupStateName
	 *            the followupStateName
	 *            to set
	 */
	public void setFollowupStateName(String followupStateName) {
		this.followupStateName = followupStateName;
	}

	/**
	 * @return the followupWay
	 */
	public Integer getFollowupWay() {
		return followupWay;
	}

	/**
	 * @param followupWay
	 *            the followupWay to set
	 */
	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	/**
	 * @return the followupWayName
	 */
	public String getFollowupWayName() {
		return followupWayName;
	}

	/**
	 * @param followupWayName
	 *            the followupWayName to
	 *            set
	 */
	public void setFollowupWayName(String followupWayName) {
		this.followupWayName = followupWayName;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Integer getWxStateId() {
		return wxStateId;
	}

	public void setWxStateId(Integer wxStateId) {
		this.wxStateId = wxStateId;
	}

	public Integer getSmsStateId() {
		return smsStateId;
	}

	public void setSmsStateId(Integer smsStateId) {
		this.smsStateId = smsStateId;
	}

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getNationIdStr() {
		return nationIdStr;
	}

	public void setNationIdStr(String nationIdStr) {
		this.nationIdStr = nationIdStr;
	}

	public String getSourceDiseaseTypeIdStr() {
		return sourceDiseaseTypeIdStr;
	}

	public void setSourceDiseaseTypeIdStr(String sourceDiseaseTypeIdStr) {
		this.sourceDiseaseTypeIdStr = sourceDiseaseTypeIdStr;
	}

	public String getInhospitalState() {
		return inhospitalState;
	}

	public void setInhospitalState(String inhospitalState) {
		this.inhospitalState = inhospitalState;
	}

}
