package com.esuizhen.cloudservice.ehr.model.patientinfo;

import java.util.Date;


public class TPatientInfo{
	
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 患者病案号
	 */
	private String patientNo;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * UUID。 toB同步时填写。
	 */
	private String uuid;
	/**
	 * 同步标识。0：未同步；-1：待同步或同步失败；1：已同步 默认0.  注意：syncFlag+mobile唯一。
	 */
	private Integer syncFlag;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 真实姓名全名
	 */
	private String trueName;
	/**
	 * 表示实名认证时，待审核时的患者姓名。（审核通过后，将此preTrueName覆盖到u_patient.trueName）
	 */
	private String preTrueName;
	/**
	 * 患者审核状态。 0：未审核（默认）； 2：初级审核通过（只要填写了诊断信息即可）； 3：实名认证待审核； 4：实名认证审核通过。
	 */
	private Integer auditState;
	/**
	 * 审核意见
	 */
	private String auditRemark;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 此患者有病历生成，且医生和患者自己可见。0：否（默认）；1：是
	 */
	private Integer hasVisibleMedicalRecord;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 生日
	 */
	private Date birthDate;
	/**
	 * 头像URL
	 */
	private String userPictureUrl;
	/**
	 * 与患者关系。 0: 本人；(默认) 1：家属
	 */
	private Integer patientRelation;
	/**
	 * 家属姓名
	 */
	private String familyName;
	/**
	 * 家属电话
	 */
	private String familyPhone;
	/**
	 * 生存状态;1：健在 （默认）0：死亡
	 */
	private Integer liveStatus;
	/**
	 * 死亡日期
	 */
	private Date deathDate;
	/**
	 * 死亡原因
	 */
	private String causeOfDeath;
	/**
	 * 血型
	 */
	private String bloodType;
	/**
	 * 血型RH阴性
	 */
	private Integer bloodTypeRh;
	/**
	 * 体重KG
	 */
	private Integer bodyHeight;
	/**
	 * 残疾情况
	 */
	private String disabilityStatus;
	/**
	 * 遗传病史
	 */
	private String geneticDiseaseHistory;
	/**
	 * 药物过敏史
	 */
	private String drugAllergyHistory;
	/**
	 * 医疗支付方式.1、城镇职工基本医疗保险；2、城镇居民基本医疗保险；3、新型农村合作医疗；4、贫困救助； 5、商业医疗保险；6、全公费；7、全自费；8、其他社会保险；9、其他
	 */
	private Integer medicalPayType;
	/**
	 * 药物过敏史
	 */
	private String sourceDiagnosis;
	/**
	 * 药物过敏史
	 */
	private String sourceDiseaseCode;
	/**
	 * sourceDiseaseTypeId
	 */
	private Integer sourceDiseaseTypeId;
	/**
	 * 首次确诊日期
	 */
	private Date confirmedDate;
	/**
	 * sourceDiagnosis2
	 */
	private String sourceDiagnosis2;
	/**
	 * sourceDiseaseCode2
	 */
	private String sourceDiseaseCode2;
	/**
	 * sourceDiseaseTypeId2
	 */
	private Integer sourceDiseaseTypeId2;
	/**
	 * confirmedDate2
	 */
	private Date confirmedDate2;
	/**
	 * sourceDiagnosis3
	 */
	private String sourceDiagnosis3;
	/**
	 * sourceDiseaseCode3
	 */
	private String sourceDiseaseCode3;
	/**
	 * sourceDiseaseTypeId3
	 */
	private Integer sourceDiseaseTypeId3;
	/**
	 * confirmedDate3
	 */
	private Date confirmedDate3;
	/**
	 * 药物过敏史
	 */
	private String sourcePathologyDiagnosis;
	/**
	 * 药物过敏史
	 */
	private String sourcePathologyDiseaseCode;
	/**
	 * 主诊医师
	 */
	private Integer attendingDoctor;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 个人资料更新时间
	 */
	private Date updateTime;
	
	/**
	 * 编目状态，新定义
	 */
	private Integer catalogState;
	
	/**
	 * 匹配合并结果.9-导入
	 */
	private Integer matchFlag;
	
	/**
	 * 主治医师
	 */
	private Long inchargeDoctor;
	
	/**
	 * 处理标识
	 */
	private Integer handleFlag;
	
	/**
	 * 医院ID。
	 */
	private Integer hospitalId;
	
	/**
	 * 门诊住院标示
	 */
	private Integer outPatientFlag;

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public Long getPatientId() {
		return this.patientId;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	
	public String getPatientNo() {
		return this.patientNo;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return this.uuid;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	
	public Integer getSyncFlag() {
		return this.syncFlag;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	public String getTrueName() {
		return this.trueName;
	}
	public void setPreTrueName(String preTrueName) {
		this.preTrueName = preTrueName;
	}
	
	public String getPreTrueName() {
		return this.preTrueName;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	
	public Integer getAuditState() {
		return this.auditState;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	
	public String getAuditRemark() {
		return this.auditRemark;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
	}
	
	public Integer getHasVisibleMedicalRecord() {
		return this.hasVisibleMedicalRecord;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getSex() {
		return this.sex;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	
	public String getUserPictureUrl() {
		return this.userPictureUrl;
	}
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}
	
	public Integer getPatientRelation() {
		return this.patientRelation;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFamilyName() {
		return this.familyName;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	
	public String getFamilyPhone() {
		return this.familyPhone;
	}
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	
	public Integer getLiveStatus() {
		return this.liveStatus;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	
	public Date getDeathDate() {
		return this.deathDate;
	}
	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}
	
	public String getCauseOfDeath() {
		return this.causeOfDeath;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}
	public void setBloodTypeRh(Integer bloodTypeRh) {
		this.bloodTypeRh = bloodTypeRh;
	}
	
	public Integer getBloodTypeRh() {
		return this.bloodTypeRh;
	}
	public void setBodyHeight(Integer bodyHeight) {
		this.bodyHeight = bodyHeight;
	}
	
	public Integer getBodyHeight() {
		return this.bodyHeight;
	}
	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}
	
	public String getDisabilityStatus() {
		return this.disabilityStatus;
	}
	public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
		this.geneticDiseaseHistory = geneticDiseaseHistory;
	}
	
	public String getGeneticDiseaseHistory() {
		return this.geneticDiseaseHistory;
	}
	public void setDrugAllergyHistory(String drugAllergyHistory) {
		this.drugAllergyHistory = drugAllergyHistory;
	}
	
	public String getDrugAllergyHistory() {
		return this.drugAllergyHistory;
	}
	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}
	
	public Integer getMedicalPayType() {
		return this.medicalPayType;
	}
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}
	
	public String getSourceDiagnosis() {
		return this.sourceDiagnosis;
	}
	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}
	
	public String getSourceDiseaseCode() {
		return this.sourceDiseaseCode;
	}
	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}
	
	public Integer getSourceDiseaseTypeId() {
		return this.sourceDiseaseTypeId;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	
	public Date getConfirmedDate() {
		return this.confirmedDate;
	}
	public void setSourceDiagnosis2(String sourceDiagnosis2) {
		this.sourceDiagnosis2 = sourceDiagnosis2;
	}
	
	public String getSourceDiagnosis2() {
		return this.sourceDiagnosis2;
	}
	public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
		this.sourceDiseaseCode2 = sourceDiseaseCode2;
	}
	
	public String getSourceDiseaseCode2() {
		return this.sourceDiseaseCode2;
	}
	public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
		this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
	}
	
	public Integer getSourceDiseaseTypeId2() {
		return this.sourceDiseaseTypeId2;
	}
	public void setConfirmedDate2(Date confirmedDate2) {
		this.confirmedDate2 = confirmedDate2;
	}
	
	public Date getConfirmedDate2() {
		return this.confirmedDate2;
	}
	public void setSourceDiagnosis3(String sourceDiagnosis3) {
		this.sourceDiagnosis3 = sourceDiagnosis3;
	}
	
	public String getSourceDiagnosis3() {
		return this.sourceDiagnosis3;
	}
	public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
		this.sourceDiseaseCode3 = sourceDiseaseCode3;
	}
	
	public String getSourceDiseaseCode3() {
		return this.sourceDiseaseCode3;
	}
	public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
		this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
	}
	
	public Integer getSourceDiseaseTypeId3() {
		return this.sourceDiseaseTypeId3;
	}
	public void setConfirmedDate3(Date confirmedDate3) {
		this.confirmedDate3 = confirmedDate3;
	}
	
	public Date getConfirmedDate3() {
		return this.confirmedDate3;
	}
	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}
	
	public String getSourcePathologyDiagnosis() {
		return this.sourcePathologyDiagnosis;
	}
	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
	}
	
	public String getSourcePathologyDiseaseCode() {
		return this.sourcePathologyDiseaseCode;
	}
	public void setAttendingDoctor(Integer attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}
	
	public Integer getAttendingDoctor() {
		return this.attendingDoctor;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Integer getMatchFlag() {
		return matchFlag;
	}

	public void setMatchFlag(Integer matchFlag) {
		this.matchFlag = matchFlag;
	}

	public Long getInchargeDoctor() {
		return inchargeDoctor;
	}

	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}

	public Integer getHandleFlag() {
		return handleFlag;
	}

	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}


}

