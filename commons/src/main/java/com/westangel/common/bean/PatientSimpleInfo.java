/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.westangel.common.bean<br/>  
 * <b>文件名：</b>PatientSimpleInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月11日-下午3:50:31<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import com.westangel.common.bean.user.ServiceSubscriptionInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: PatientSimpleInfo 
* @Description: 患者简要信息
* @author YYCHEN
* @date 2015年12月11日 下午3:50:31  
*/
public class PatientSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String idFileUrl;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 病人编号
	 */
	private Long patientId;
	
	/**
	 * 待审核姓名
	 */
	private String preTrueName;
	/**
	 * 账号
	 */
	private String userName;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 与患者关系
	 */
	private Integer patientRelation;
	/**
	 * 头像路径
	 */
	private String userPictureUrl;
	/**
	 * 出生日期
	 */
	private Date birthDate;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 原发性诊断
	 */
	private String sourceDiagnosis;
	/**
	 * 原发诊断编码
	 */
	private String sourceDiseaseCode;
	/**
	 * 病种
	 */
	private Integer sourceDiseaseTypeId;
	/**
	 * 病种名称
	 */
	private String sourceDiseaseTypeName;
	/**
	 * 原发病理诊断
	 */
	private String sourcePathologyDiagnosis;
	/**
	 * 原发病理诊断编码
	 */
	private String sourcePathologyDiseaseCode;
	/**
	 * 确诊时间
	 */
	private Date confirmedDate;
	/**
	 * 患病时长
	 */
	private Integer confirmedMonths;
	/**
	 * 随访至多少天
	 */
	private Integer currFollowupPerformDays;
	/**
	 * 关注时间
	 */
	private Date attentionTime;
	/**
	 * 是否有病历
	 */
	private Integer hasVisibleMedicalRecord;
	//应随访时间
	private Date followupDate;
	
	private String followupResultName;
	/**
	 * 常规随访状态
	 */
	private Integer followupState;
	/**
	 * 随访结果
	 */
	private Integer followupResultValue;
	//随访结果名称
	private String followupResultValueName;
	/**
	 * 专题随访状态
	 */
	private Integer projectFollowupState;
	/**
	 * 分中心名称
	 */
	private String subcenterName;
	/**
	 * 账号类型
	 */
	private Integer accountType;
	
	/**
	 * 信息状态
	 */
	private Integer infoState;
	
	/**
	 * 来源
	 */
	private Integer sourceFlag;
	
	/**
	 * 患者病历数
	 */
	private Integer medicalRecordCount;
	
	/**
	 * 最近病历更新时间
	 */
    private Date latestMedicalRecordUploadTime;
    
	private ServiceSubscriptionInfo serviceSubscriptionInfo;
	
	/**
	 * 生存状态
	 */
	private Integer liveStatus;
	
	private String auditRemark;
	private Integer certificateResult;
    
	private Integer weixinFlag;
	
	private Integer tobFlag;
    
	//主治医师姓名
	private String attendingDoctorName;
	//最近随访时间
	private Date lastFollowupDate;
	//随访逾期情况
	private Integer followupOverdue;
	//专题采集状态(0:专题结束并大于等于七天)
	private Integer projectState;
	
	//以下患者随访增加的属性 add by yuan_wm 20160805
	
	private String patientNo;
	
	private String identification;
	
	private String sexText;
	
	/**
	 * 主治医师
	 */
	private String inchargeDoctorName;
	
	private Integer state;
	/**
	 * 合并标示
	 */
	private Long goalpatientid;
	
	
	private Integer doctorFocus;
	
	private Integer isTumourDeath;
	
	private Integer auditState;
	
	private String groupId;
	
	private String lostFollowupCause;
	
	private Integer lostFollowupCauseResultValue;
	
	private Date lostFollowupTime;
	
	private String followupTaskId;
	
	private String followupTaskName;
	
	private Date latestOutHospitalDate;
	
	private Integer confirmedAge;
	
	private Date deathDate;
	
	private String causeOfDeath;
	
	private String followupAssignId;
	
	private String followupResultId;
	
	private Integer flag;
	
	private Integer isSimilar;
	
	private Integer isMerge;
	
	private List<PatientProfile> otherPatients;
	/**
	 * 患者类型。NULL：非疑似重复患者；1：疑似重复患者
	 */
	private Integer patientType;
	/**
	 * 合并标记取值调整： 1：代表合并后的目标患者 2：代表被合并的患者 0 代表普通（默认）
	 */
	private Integer mergeFlag;
	/**
	 * 失访后新增门诊住院标识。1：是；0：否
	 */
	private Integer newVisitFlag;
	/**
	 * 失访后新联系人标记。1：是；0：否
	 */
	private Integer newContactFlag;
	/**
	 * 失访标示2
	 */
	private Integer followupFlag;
	
	private Integer matchFlag;
	/**
	 * 编目状态
	 */
	private Integer catalogState;
	/**
	 * 编目后更新
	 */
	private Integer catalogWithUpdate;
	
	private Long Id;//专题使用 误删

	/**
	 * 是否已同步
	 */
	private Integer isSync;
	
	private String followupInterval;
	private String followupTotal;
	
	private String nationName;
	//0-在院、1-离院  2-门诊
	private String treatmentPlaceState;
	
	//1：门诊；2：住院
	private Integer outPatientFlag;
	//住院状态。0-在院、1-离院。
	private Integer inhospitalState;
	/**
	 * 健康卡号
	 */
	private String healthCardNo;

	public Integer getIsSync() {
		return this.isSync;
	}

	public void setIsSync(Integer isSync) {
		this.isSync = isSync;
	}
	
	public List<PatientProfile> getOtherPatients() {
		return otherPatients;
	}

	public void setOtherPatients(List<PatientProfile> otherPatients) {
		this.otherPatients = otherPatients;
	}
	
	public Integer getIsSimilar() {
		return isSimilar;
	}

	public void setIsSimilar(Integer isSimilar) {
		this.isSimilar = isSimilar;
	}

	public Integer getIsMerge() {
		return isMerge;
	}

	public void setIsMerge(Integer isMerge) {
		this.isMerge = isMerge;
	}
	
	public Integer getProjectState() {
		return projectState;
	}

	public void setProjectState(Integer projectState) {
		this.projectState = projectState;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getFollowupOverdue() {
		return followupOverdue;
	}

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
	}

	public void setFollowupOverdue(Integer followupOverdue) {
		this.followupOverdue = followupOverdue;
	}

	public String getFollowupResultValueName() {
		return followupResultValueName;
	}

	public void setFollowupResultValueName(String followupResultValueName) {
		this.followupResultValueName = followupResultValueName;
	}

	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getFollowupResultName() {
		return followupResultName;
	}

	public void setFollowupResultName(String followupResultName) {
		this.followupResultName = followupResultName;
	}

	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}

	public Date getLastFollowupDate() {
		return lastFollowupDate;
	}

	public void setLastFollowupDate(Date lastFollowupDate) {
		this.lastFollowupDate = lastFollowupDate;
	}

	public Integer getWeixinFlag() {
		return weixinFlag;
	}

	public void setWeixinFlag(Integer weixinFlag) {
		this.weixinFlag = weixinFlag;
	}

	public Date getLatestMedicalRecordUploadTime() {
		return latestMedicalRecordUploadTime;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public Integer getCertificateResult() {
		return certificateResult;
	}

	public void setCertificateResult(Integer certificateResult) {
		this.certificateResult = certificateResult;
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

	public void setLatestMedicalRecordUploadTime(Date latestMedicalRecordUploadTime) {
		this.latestMedicalRecordUploadTime = latestMedicalRecordUploadTime;
	}

	public Integer getInfoState() {
		return infoState;
	}

	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Integer getConfirmedMonths() {
		return confirmedMonths;
	}

	public void setConfirmedMonths(Integer confirmedMonths) {
		this.confirmedMonths = confirmedMonths;
	}

	public Date getAttentionTime() {
		return attentionTime;
	}

	public void setAttentionTime(Date attentionTime) {
		this.attentionTime = attentionTime;
	}

	public Integer getHasVisibleMedicalRecord() {
		return hasVisibleMedicalRecord;
	}

	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
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

	public Integer getProjectFollowupState() {
		return projectFollowupState;
	}

	public void setProjectFollowupState(Integer projectFollowupState) {
		this.projectFollowupState = projectFollowupState;
	}

	public String getSubcenterName() {
		return subcenterName;
	}

	public void setSubcenterName(String subcenterName) {
		this.subcenterName = subcenterName;
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

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getCurrFollowupPerformDays() {
		return currFollowupPerformDays;
	}

	public void setCurrFollowupPerformDays(Integer currFollowupPerformDays) {
		this.currFollowupPerformDays = currFollowupPerformDays;
	}

	/**
	 * @return the sourceDiseaseTypeId
	 */
	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	/**
	 * @param sourceDiseaseTypeId the sourceDiseaseTypeId to set
	 */
	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
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

	/**
	 * @return the patientRelation
	 */
	public Integer getPatientRelation() {
		return patientRelation;
	}

	/**
	 * @param patientRelation the patientRelation to set
	 */
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMedicalRecordCount() {
		return medicalRecordCount;
	}

	public void setMedicalRecordCount(Integer medicalRecordCount) {
		this.medicalRecordCount = medicalRecordCount;
	}

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getInchargeDoctorName() {
		return inchargeDoctorName;
	}

	public void setInchargeDoctorName(String inchargeDoctorName) {
		this.inchargeDoctorName = inchargeDoctorName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getSexText() {
		return sexText;
	}

	public void setSexText(String sexText) {
		this.sexText = sexText;
	}

	public Long getGoalpatientid() {
		return goalpatientid;
	}

	public void setGoalpatientid(Long goalpatientid) {
		this.goalpatientid = goalpatientid;
	}

	public String getLostFollowupCause() {
		return lostFollowupCause;
	}

	public void setLostFollowupCause(String lostFollowupCause) {
		this.lostFollowupCause = lostFollowupCause;
	}

	public Integer getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}

	public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}

	public Date getLostFollowupTime() {
		return lostFollowupTime;
	}

	public void setLostFollowupTime(Date lostFollowupTime) {
		this.lostFollowupTime = lostFollowupTime;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public Date getLatestOutHospitalDate() {
		return latestOutHospitalDate;
	}

	public void setLatestOutHospitalDate(Date latestOutHospitalDate) {
		this.latestOutHospitalDate = latestOutHospitalDate;
	}

	public Integer getConfirmedAge() {
		return confirmedAge;
	}

	public void setConfirmedAge(Integer confirmedAge) {
		this.confirmedAge = confirmedAge;
	}

	public String getFollowupTaskName() {
		return followupTaskName;
	}

	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public String getFollowupAssignId() {
		return followupAssignId;
	}

	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}


	public String getIdFileUrl()
	{
		return idFileUrl;
	}

	public void setIdFileUrl(String idFileUrl)
	{
		this.idFileUrl = idFileUrl;
	}


	public Integer getPatientType() {
		return patientType;
	}

	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}

	public Integer getMergeFlag() {
		return mergeFlag;
	}

	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}

	public Integer getNewVisitFlag() {
		return newVisitFlag;
	}

	public void setNewVisitFlag(Integer newVisitFlag) {
		this.newVisitFlag = newVisitFlag;
	}

	public Integer getNewContactFlag() {
		return newContactFlag;
	}

	public void setNewContactFlag(Integer newContactFlag) {
		this.newContactFlag = newContactFlag;
	}

	public Integer getDoctorFocus() {
		return doctorFocus;
	}

	public void setDoctorFocus(Integer doctorFocus) {
		this.doctorFocus = doctorFocus;
	}

	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}

	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Integer getMatchFlag() {
		return matchFlag;
	}

	public void setMatchFlag(Integer matchFlag) {
		this.matchFlag = matchFlag;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Integer getCatalogWithUpdate() {
		return catalogWithUpdate;
	}

	public void setCatalogWithUpdate(Integer catalogWithUpdate) {
		this.catalogWithUpdate = catalogWithUpdate;
	}

	public Integer getTobFlag() {
		return tobFlag;
	}

	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFollowupInterval() {
		return followupInterval;
	}

	public void setFollowupInterval(String followupInterval) {
		this.followupInterval = followupInterval;
	}

	public String getFollowupTotal() {
		return followupTotal;
	}

	public void setFollowupTotal(String followupTotal) {
		this.followupTotal = followupTotal;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getTreatmentPlaceState() {
		return treatmentPlaceState;
	}

	public void setTreatmentPlaceState(String treatmentPlaceState) {
		this.treatmentPlaceState = treatmentPlaceState;
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

	public String getHealthCardNo() {
		return healthCardNo;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}
}
