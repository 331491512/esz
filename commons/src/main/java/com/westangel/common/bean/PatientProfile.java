/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.westangel.common.bean<br/>  
 * <b>文件名：</b>PatientProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日-下午2:45:50<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.westangel.common.bean.user.ServiceSubscriptionInfo;

/** 
* @ClassName: PatientProfile 
* @Description: 患者基本信息
* @author YYCHEN
* @date 2015年12月17日 下午2:45:50  
*/
public class PatientProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long patientId;

	private Long userId;
	//待认证
	private String preTrueName;

	private String trueName;

	private String nickName;

	private String mobile;

	private Integer sex;
	
	private Integer age;

	private Date birthDate;
	
	private String userPictureUrl;
	
	private Integer patientRelation;

	private String familyName;

	private String familyPhone;

	private Integer liveStatus;

	private Date deathDate;

	private String causeOfDeath;

	private String bloodType;

	private Integer bloodTypeRH;

	private Integer bodyHeight;

	private String disabilityStatus;

	private String geneticDiseaseHistory;

	private String drugAllergyHistory;

	private Integer medicalPayType;
	
	private Date latestClinicDate;
	
	private Date latestOutHospitalDate;
	
	private Date latestFollowupTime;
	
	private Integer followupFlag;
	
	private Integer currFollowupPerformDays;
	
	private Integer hasVisibleMedicalRecord;
	
	private Integer followupState;
	
	private Integer followupResultValue;
	
	private String sourceDiagnosis;

	private String sourceDiseaseCode;
	
	private Integer sourceDiseaseTypeId;
	
	private String sourceDiseaseTypeName;

	private Date confirmedDate;

	private String sourceDiagnosis2;

	private String sourceDiseaseCode2;
	
	private Integer sourceDiseaseTypeId2;

	private Date confirmedDate2;

	private String sourceDiagnosis3;

	private String sourceDiseaseCode3;
	
	private Integer sourceDiseaseTypeId3;

	private Date confirmedDate3;

	private String sourcePathologyDiagnosis;

	private String sourcePathologyDiseaseCode;

	private Long attendingDoctor;
	
	private String sourceDiagnosises;

	private Integer auditState;
	
	private String auditRemark;
	
	private Date createTime;

	private Date updateTime;
	
	private Integer sourceFlag;
	
	private Integer medicalRecordCount;
	
	private Long sourceDiagnosisCreatorId;
	
	private String sourceDiagnosisCreatorName;
	
	private String patientNo;
	
	private Integer weixinFlag;
	
	//B端同步标识
	private Integer tobFlag;
	
	private Integer wxProductId;
	
	//特殊关注患者
	private Integer doctorFocus;
	
	private List<SourceDiagnosisInfo> sourceDiagnosisList;
	private ServiceSubscriptionInfo serviceSubscriptionInfo;
	private Integer syncFlag;
	
	private String lostFollowupCause;
	
	private Integer lostFollowupState;
	
	private Date lostFollowupTime;
	
	private Integer matchFlag;
	// 电话状态，随访时修改，add by zhuguo
	private Integer phoneStatus;
	
	private String wholeProcessFlag;
	
	private String confirmedDateModCount;
	
	private Integer outPatientFlag;
	private Integer inhospitalState;
	
	public Integer getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(Integer phoneStatus) {
		this.phoneStatus = phoneStatus;
	}
	public Long getPatientId() {
		return patientId;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @return the currFollowupPerformDays
	 */
	public Integer getCurrFollowupPerformDays() {
		return currFollowupPerformDays;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @param currFollowupPerformDays the currFollowupPerformDays to set
	 */
	public void setCurrFollowupPerformDays(Integer currFollowupPerformDays) {
		this.currFollowupPerformDays = currFollowupPerformDays;
	}

	/**
	 * @return the serviceSubscriptionInfo
	 */
	public ServiceSubscriptionInfo getServiceSubscriptionInfo() {
		return serviceSubscriptionInfo;
	}

	/**
	 * @param serviceSubscriptionInfo the serviceSubscriptionInfo to set
	 */
	public void setServiceSubscriptionInfo(ServiceSubscriptionInfo serviceSubscriptionInfo) {
		this.serviceSubscriptionInfo = serviceSubscriptionInfo;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Long getUserId() {
		return userId;
	}

	public Integer getFollowupState() {
		return followupState;
	}

	public void setFollowupState(Integer followupState) {
		this.followupState = followupState;
	}

	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	/**
	 * @return the sourceDiseaseTypeName
	 */
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}

	/**
	 * @param sourceDiseaseTypeName the sourceDiseaseTypeName to set
	 */
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}

	public Integer getPatientRelation() {
		return patientRelation;
	}

	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
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

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getCauseoOfDeath() {
		return causeOfDeath;
	}

	public void setCauseoOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Integer getBloodTypeRH() {
		return bloodTypeRH;
	}

	public void setBloodTypeRH(Integer bloodTypeRH) {
		this.bloodTypeRH = bloodTypeRH;
	}

	public Integer getBodyHeight() {
		return bodyHeight;
	}

	public void setBodyHeight(Integer bodyHeight) {
		this.bodyHeight = bodyHeight;
	}

	public String getDisabilityStatus() {
		return disabilityStatus;
	}

	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}

	public String getGeneticDiseaseHistory() {
		return geneticDiseaseHistory;
	}

	public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
		this.geneticDiseaseHistory = geneticDiseaseHistory;
	}

	public String getDrugAllergyHistory() {
		return drugAllergyHistory;
	}

	public void setDrugAllergyHistory(String drugAllergyHistory) {
		this.drugAllergyHistory = drugAllergyHistory;
	}

	public Integer getMedicalPayType() {
		return medicalPayType;
	}

	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}

	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	public String getSourcePathologyDiagnosis() {
		return sourcePathologyDiagnosis;
	}

	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}

	public String getSourcePathologyDiseaseCode() {
		return sourcePathologyDiseaseCode;
	}

	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
	}

	public Long getAttendingDoctor() {
		return attendingDoctor;
	}

	public void setAttendingDoctor(Long attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Integer getHasVisibleMedicalRecord() {
		return hasVisibleMedicalRecord;
	}

	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getLatestClinicDate() {
		return latestClinicDate;
	}

	public void setLatestClinicDate(Date latestClinicDate) {
		this.latestClinicDate = latestClinicDate;
	}

	public Date getLatestOutHospitalDate() {
		return latestOutHospitalDate;
	}

	public void setLatestOutHospitalDate(Date latestOutHospitalDate) {
		this.latestOutHospitalDate = latestOutHospitalDate;
	}

	public Date getLatestFollowupTime() {
		return latestFollowupTime;
	}

	public void setLatestFollowupTime(Date latestFollowupTime) {
		this.latestFollowupTime = latestFollowupTime;
	}

	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}

	public String getSourceDiagnosis2() {
		return sourceDiagnosis2;
	}

	public void setSourceDiagnosis2(String sourceDiagnosis2) {
		this.sourceDiagnosis2 = sourceDiagnosis2;
	}

	public String getSourceDiseaseCode2() {
		return sourceDiseaseCode2;
	}

	public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
		this.sourceDiseaseCode2 = sourceDiseaseCode2;
	}

	public Integer getSourceDiseaseTypeId2() {
		return sourceDiseaseTypeId2;
	}

	public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
		this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
	}

	public Date getConfirmedDate2() {
		return confirmedDate2;
	}

	public void setConfirmedDate2(Date confirmedDate2) {
		this.confirmedDate2 = confirmedDate2;
	}

	public String getSourceDiagnosis3() {
		return sourceDiagnosis3;
	}

	public void setSourceDiagnosis3(String sourceDiagnosis3) {
		this.sourceDiagnosis3 = sourceDiagnosis3;
	}

	public String getSourceDiseaseCode3() {
		return sourceDiseaseCode3;
	}

	public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
		this.sourceDiseaseCode3 = sourceDiseaseCode3;
	}

	public Integer getSourceDiseaseTypeId3() {
		return sourceDiseaseTypeId3;
	}

	public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
		this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
	}

	public Date getConfirmedDate3() {
		return confirmedDate3;
	}

	public void setConfirmedDate3(Date confirmedDate3) {
		this.confirmedDate3 = confirmedDate3;
	}

	public String getSourceDiagnosises() {
		return sourceDiagnosises;
	}

	public void setSourceDiagnosises(String sourceDiagnosises) {
		this.sourceDiagnosises = sourceDiagnosises;
	}

	public List<SourceDiagnosisInfo> getSourceDiagnosisList() {
		return sourceDiagnosisList;
	}

	public void setSourceDiagnosisList(List<SourceDiagnosisInfo> sourceDiagnosisList) {
		this.sourceDiagnosisList = sourceDiagnosisList;
	}

	public Integer getMedicalRecordCount() {
		return medicalRecordCount;
	}

	public void setMedicalRecordCount(Integer medicalRecordCount) {
		this.medicalRecordCount = medicalRecordCount;
	}
	
	public Long getSourceDiagnosisCreatorId() {
		return sourceDiagnosisCreatorId;
	}

	public void setSourceDiagnosisCreatorId(Long sourceDiagnosisCreatorId) {
		this.sourceDiagnosisCreatorId = sourceDiagnosisCreatorId;
	}

	public String getSourceDiagnosisCreatorName() {
		return sourceDiagnosisCreatorName;
	}

	public void setSourceDiagnosisCreatorName(String sourceDiagnosisCreatorName) {
		this.sourceDiagnosisCreatorName = sourceDiagnosisCreatorName;
	}
	
	
	public Integer getWeixinFlag() {
		return weixinFlag;
	}

	public void setWeixinFlag(Integer weixinFlag) {
		this.weixinFlag = weixinFlag;
	}

	/** 
	* @return preTrueName 
	*/
	public String getPreTrueName() {
		return preTrueName;
	}

	/** 
	* @param preTrueName 要设置的 preTrueName 
	*/
	public void setPreTrueName(String preTrueName) {
		this.preTrueName = preTrueName;
	}

	public Integer getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}

	public Integer getDoctorFocus() {
		return doctorFocus;
	}

	public void setDoctorFocus(Integer doctorFocus) {
		this.doctorFocus = doctorFocus;
	}

	public String getLostFollowupCause() {
		return lostFollowupCause;
	}

	public void setLostFollowupCause(String lostFollowupCause) {
		this.lostFollowupCause = lostFollowupCause;
	}

	public Date getLostFollowupTime() {
		return lostFollowupTime;
	}

	public void setLostFollowupTime(Date lostFollowupTime) {
		this.lostFollowupTime = lostFollowupTime;
	}

	public Integer getLostFollowupState() {
		return lostFollowupState;
	}

	public void setLostFollowupState(Integer lostFollowupState) {
		this.lostFollowupState = lostFollowupState;
	}

	public Integer getMatchFlag() {
		return matchFlag;
	}

	public void setMatchFlag(Integer matchFlag) {
		this.matchFlag = matchFlag;
	}

	public Integer getTobFlag() {
		return tobFlag;
	}

	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}

	public String getWholeProcessFlag() {
		return wholeProcessFlag;
	}

	public void setWholeProcessFlag(String wholeProcessFlag) {
		this.wholeProcessFlag = wholeProcessFlag;
	}

	public String getConfirmedDateModCount() {
		return confirmedDateModCount;
	}

	public void setConfirmedDateModCount(String confirmedDateModCount) {
		this.confirmedDateModCount = confirmedDateModCount;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}

	public Integer getInhospitalState() {
		return inhospitalState;
	}

	public void setInhospitalState(Integer inhospitalState) {
		this.inhospitalState = inhospitalState;
	}
}
