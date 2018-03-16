package com.esuizhen.cloudservice.user.model.followuppatient;

public class TFaultSimilarPatientSpread {
	/**
	 * 数据正确
	 */
	private Integer correctCount;
	/**
	 * 数据缺失
	 */
	private Integer missingCount;
	/**
	 * 疑似数据错误
	 */
	private Integer invalidCount;
	// DISTINCT(数据正确+数据缺失+疑似数据错误)
	private Integer patientTotal;
	//缺失患者姓名的总数
	private Integer missingTrueNameCount;
	/**
	 * 缺诊断名称
	 */
	private Integer missingSourceDiagnosisCount;
	/**
	 * 缺诊断编码
	 */
	private Integer missingSourceDiseaseCodeCount;
	/**
	 * 缺联系方式
	 */
	private Integer missingPhoneCount;
	/**
	 * 缺病案号
	 */
	private Integer missingPatientNoCount;
	/**
	 * 缺身份证
	 */
	private Integer missingIdentificationCount;
	/**
	 * 缺病种
	 */
	private Integer missingDiseaseCount;
	/**
	 * 缺治疗方式
	 */
	private Integer missingTreatmentTypeCount;
	/**
	 * 缺肿瘤分期
	 */
	private Integer missingTumourPeriodizationCount;
	/**
	 * 缺病理诊断
	 */
	private Integer missingPathologyDiseaseCount;
	/**
	 * 缺病理诊断编码
	 */
	private Integer missingPathologyDiseaseCodeCount;
	/**
	 * 联系方式错误
	 */
	private Integer invalidPhoneCount;
	/**
	 * 诊断代码错误
	 */
	private Integer invalidSourceDiseaseCodeCount;
	/**
	 * 身份证号码错误
	 */
	private Integer invalidIdentificationCount;
	/**
	 * 姓名错误
	 */
	private Integer invalidTrueNameCount;
	/** 随访错误数据统计 add by yuanwenming start */
	
	/**
	 * 多次死亡随访结果错误标识NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer moreDeathFollowupResultFlagCount;
	/**
	 * 死亡状态无死亡随访结果NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer deathNotFollowupResultFlagCount;
	/**
	 * 死亡状态无死亡时间NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer deathNotFollowupTimeFlagCount;
	/**
	 * 死亡后有随访结果
	 */
	private Integer deathAfterHasFollowupResultFlagCount;
	/**
	 * 有就诊记录无随访结果NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer medicalRecordNotFollowupResultFlagCount;
	/**
	 * 死亡患者又进任务NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer deathPatientIntoTaskCount;
	/**
	 * 失访患者又进任务NULL：未知；1：正确（默认）-1：错误
	 */
	private Integer lostPatientIntoTaskCount;
	/**
	 * 无效随访数据数量
	 */
	private Integer invalidFollowupDataCount;
	/** 随访错误数据统计 add by yuanwenming end */
	
	public Integer getCorrectCount() {
		return correctCount;
	}
	public void setCorrectCount(Integer correctCount) {
		this.correctCount = correctCount;
	}
	public Integer getMissingCount() {
		return missingCount;
	}
	public void setMissingCount(Integer missingCount) {
		this.missingCount = missingCount;
	}
	public Integer getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}
	public Integer getMissingSourceDiagnosisCount() {
		return missingSourceDiagnosisCount;
	}
	public void setMissingSourceDiagnosisCount(Integer missingSourceDiagnosisCount) {
		this.missingSourceDiagnosisCount = missingSourceDiagnosisCount;
	}
	public Integer getMissingSourceDiseaseCodeCount() {
		return missingSourceDiseaseCodeCount;
	}
	public void setMissingSourceDiseaseCodeCount(
			Integer missingSourceDiseaseCodeCount) {
		this.missingSourceDiseaseCodeCount = missingSourceDiseaseCodeCount;
	}
	public Integer getMissingPhoneCount() {
		return missingPhoneCount;
	}
	public void setMissingPhoneCount(Integer missingPhoneCount) {
		this.missingPhoneCount = missingPhoneCount;
	}
	public Integer getMissingPatientNoCount() {
		return missingPatientNoCount;
	}
	public void setMissingPatientNoCount(Integer missingPatientNoCount) {
		this.missingPatientNoCount = missingPatientNoCount;
	}
	public Integer getMissingIdentificationCount() {
		return missingIdentificationCount;
	}
	public Integer getMissingDiseaseCount() {
		return missingDiseaseCount;
	}
	public void setMissingDiseaseCount(Integer missingDiseaseCount) {
		this.missingDiseaseCount = missingDiseaseCount;
	}
	public void setMissingIdentificationCount(Integer missingIdentificationCount) {
		this.missingIdentificationCount = missingIdentificationCount;
	}
	public Integer getMissingTreatmentTypeCount() {
		return missingTreatmentTypeCount;
	}
	public void setMissingTreatmentTypeCount(Integer missingTreatmentTypeCount) {
		this.missingTreatmentTypeCount = missingTreatmentTypeCount;
	}
	public Integer getMissingTumourPeriodizationCount() {
		return missingTumourPeriodizationCount;
	}
	public void setMissingTumourPeriodizationCount(
			Integer missingTumourPeriodizationCount) {
		this.missingTumourPeriodizationCount = missingTumourPeriodizationCount;
	}
	public Integer getMissingPathologyDiseaseCount() {
		return missingPathologyDiseaseCount;
	}
	public void setMissingPathologyDiseaseCount(Integer missingPathologyDiseaseCount) {
		this.missingPathologyDiseaseCount = missingPathologyDiseaseCount;
	}
	public Integer getMissingPathologyDiseaseCodeCount() {
		return missingPathologyDiseaseCodeCount;
	}
	public void setMissingPathologyDiseaseCodeCount(
			Integer missingPathologyDiseaseCodeCount) {
		this.missingPathologyDiseaseCodeCount = missingPathologyDiseaseCodeCount;
	}
	public Integer getInvalidPhoneCount() {
		return invalidPhoneCount;
	}
	public void setInvalidPhoneCount(Integer invalidPhoneCount) {
		this.invalidPhoneCount = invalidPhoneCount;
	}
	public Integer getInvalidSourceDiseaseCodeCount() {
		return invalidSourceDiseaseCodeCount;
	}
	public void setInvalidSourceDiseaseCodeCount(
			Integer invalidSourceDiseaseCodeCount) {
		this.invalidSourceDiseaseCodeCount = invalidSourceDiseaseCodeCount;
	}
	public Integer getInvalidIdentificationCount() {
		return invalidIdentificationCount;
	}
	public void setInvalidIdentificationCount(Integer invalidIdentificationCount) {
		this.invalidIdentificationCount = invalidIdentificationCount;
	}
	public Integer getInvalidTrueNameCount() {
		return invalidTrueNameCount;
	}
	public void setInvalidTrueNameCount(Integer invalidTrueNameCount) {
		this.invalidTrueNameCount = invalidTrueNameCount;
	}
	public Integer getMoreDeathFollowupResultFlagCount() {
		return moreDeathFollowupResultFlagCount;
	}
	public void setMoreDeathFollowupResultFlagCount(
			Integer moreDeathFollowupResultFlagCount) {
		this.moreDeathFollowupResultFlagCount = moreDeathFollowupResultFlagCount;
	}
	public Integer getDeathNotFollowupResultFlagCount() {
		return deathNotFollowupResultFlagCount;
	}
	public void setDeathNotFollowupResultFlagCount(
			Integer deathNotFollowupResultFlagCount) {
		this.deathNotFollowupResultFlagCount = deathNotFollowupResultFlagCount;
	}
	public Integer getDeathNotFollowupTimeFlagCount() {
		return deathNotFollowupTimeFlagCount;
	}
	public void setDeathNotFollowupTimeFlagCount(
			Integer deathNotFollowupTimeFlagCount) {
		this.deathNotFollowupTimeFlagCount = deathNotFollowupTimeFlagCount;
	}
	public Integer getDeathAfterHasFollowupResultFlagCount() {
		return deathAfterHasFollowupResultFlagCount;
	}
	public void setDeathAfterHasFollowupResultFlagCount(
			Integer deathAfterHasFollowupResultFlagCount) {
		this.deathAfterHasFollowupResultFlagCount = deathAfterHasFollowupResultFlagCount;
	}
	public Integer getMedicalRecordNotFollowupResultFlagCount() {
		return medicalRecordNotFollowupResultFlagCount;
	}
	public void setMedicalRecordNotFollowupResultFlagCount(
			Integer medicalRecordNotFollowupResultFlagCount) {
		this.medicalRecordNotFollowupResultFlagCount = medicalRecordNotFollowupResultFlagCount;
	}
	public Integer getDeathPatientIntoTaskCount() {
		return deathPatientIntoTaskCount;
	}
	public void setDeathPatientIntoTaskCount(Integer deathPatientIntoTaskCount) {
		this.deathPatientIntoTaskCount = deathPatientIntoTaskCount;
	}
	public Integer getLostPatientIntoTaskCount() {
		return lostPatientIntoTaskCount;
	}
	public void setLostPatientIntoTaskCount(Integer lostPatientIntoTaskCount) {
		this.lostPatientIntoTaskCount = lostPatientIntoTaskCount;
	}
	public Integer getInvalidFollowupDataCount() {
		return invalidFollowupDataCount;
	}
	public void setInvalidFollowupDataCount(Integer invalidFollowupDataCount) {
		this.invalidFollowupDataCount = invalidFollowupDataCount;
	}
	
}
