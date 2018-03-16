package com.esuizhen.cloudservice.ehr.model.diagnose;

import java.util.Date;

public class TDiagnosisInfo {
	
	/**
	 * 诊断id
	 */
	private String diagnosisId;
	
	/**
	 * 电子病历ID
	 */
	private String emrId;
	
	/**
	 * 住院首页id
	 */
	private String inhospitalId;
	
	/**
	 * 患者id
	 */
	private Long patientId;
	
	/**
	 * 患者病案号
	 */
	private String patientNo;
	
	/**
	 * 疾病类型
	 */
	private Integer diseaseTypeId;
	
	/**
	 *诊断类型 
	 */
	private Integer diagnosisTypeId;
	
	/**
	 * 诊断内容
	 */
	private String diagnosis;
	
	/**
	 * 诊断编码
	 */
	private String diagnosisCode;
	
	/**
	 * 病理诊断内容
	 */
	private String pathologyDiagnosis;
	
	/**
	 * 病理诊断编码
	 */
	private String pathologyDiagnosisCode;
	
	/**
	 * 入院病情id
	 */
	private Integer inHospitalCondition;
	
	/**
	 * 诊断依据id
	 */
	private Integer diagnosisBasisId;
	/**
	 * 
	 */
	private String diseaseBasis;
	
	/**
	 * 诊断分期id
	 */
	private Integer disagnosisPeriodizationId;
	
	/**
	 * 诊断说明id
	 */
	private Integer diagnosisExplain;
	
	/**
	 * 肿瘤部位
	 */
	private String organName;
	
	/**
	 * 肿瘤部位编码
	 */
	private String organCode;
	
	// add by zhuguo
	/**
	 * 肿瘤部位
	 */
	private String organName1;
	
	/**
	 * 肿瘤部位编码
	 */
	private String organCode1;
	
	/**
	 * 肿瘤部位
	 */
	private String organName2;
	
	/**
	 * 肿瘤部位编码
	 */
	private String organCode2;
	// end

	/**
	 * 是否随访id
	 */
	private Integer isFollowup;
	
	/**
	 * 原发癌数
	 */
	private Integer sourceCancerCount;
	
	/**
	 * 既往治疗id
	 */
	private Integer treatmentHistory;
	
	/**
	 * 是否原发诊断id
	 */
	private Integer isSourceDiagnosis;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 就诊时间
	 */
	private Date visitTime;
	
	/**
	 * 创建者id
	 */
	private Long creator;
	
	/**
	 * 操作者id
	 */
	private Long operatorId;
	/**
	 * 操作者名称
	 */
	private String operatorName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/*
	 * 操作行为 ：A-创建,U-更新,D-删除
	 */
	private String operateAction;
	
	private Integer outhospitalCondition;
	/**
	 * 疑似诊断
	 */
	private Integer suspectedDiagnosisFlag;
	/**
	 * 是否手术
	 */
	private Integer surgeryFlag;
	/**
	 * 首诊医院ID
	 */
	private Integer firstdiagnosisHospitalId;
	/**
	 * 首诊医院名称
	 */
	private String firstdiagnosisHospitalName;
	/**
	 * 首诊日期
	 */
	private Date firstdiagnosisTime;
	/**
	 * 特病诊断ID
	 */
	private Integer specialDiseaseDiagnosisId;
	/**
	 * 诊断医生ID
	 */
	private Integer diagnosisDoctorId;
	/**
	 * 诊断医生名称
	 */
	private String diagnosisDoctorName;
	/**
	 * 出院科别（特病专用）
	 */
	private Integer outhospitalDeptId;
	/**
	 * 肿瘤分期T（特病专用）
	 */
	private String tumourPeriodizationTId;
	private String tumourPeriodizationT;
	/**
	 * 肿瘤分期N（特病专用）
	 */
	private String tumourPeriodizationNId;
	private String tumourPeriodizationN;
	/**
	 * 肿瘤分期M（特病专用）
	 */
	private String tumourPeriodizationM1Id;

	private Integer actionFlag; // 操作标识
								// 1代表增加，2代表更新，3代表删除

	public Integer getActionFlag() {
		return actionFlag;
	}

	public String getOrganName1() {
		return organName1;
	}

	public void setOrganName1(String organName1) {
		this.organName1 = organName1;
	}

	public String getOrganCode1() {
		return organCode1;
	}

	public void setOrganCode1(String organCode1) {
		this.organCode1 = organCode1;
	}

	public String getOrganName2() {
		return organName2;
	}

	public void setOrganName2(String organName2) {
		this.organName2 = organName2;
	}

	public String getOrganCode2() {
		return organCode2;
	}

	public void setOrganCode2(String organCode2) {
		this.organCode2 = organCode2;
	}

	public void setActionFlag(Integer actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getTumourPeriodizationTId() {
		return tumourPeriodizationTId;
	}
	public void setTumourPeriodizationTId(String tumourPeriodizationTId) {
		this.tumourPeriodizationTId = tumourPeriodizationTId;
	}
	public String getTumourPeriodizationNId() {
		return tumourPeriodizationNId;
	}
	public void setTumourPeriodizationNId(String tumourPeriodizationNId) {
		this.tumourPeriodizationNId = tumourPeriodizationNId;
	}
	public String getTumourPeriodizationM1Id() {
		return tumourPeriodizationM1Id;
	}
	public void setTumourPeriodizationM1Id(String tumourPeriodizationM1Id) {
		this.tumourPeriodizationM1Id = tumourPeriodizationM1Id;
	}
	private String tumourPeriodizationM1;
	/**
	 * 肿瘤临床分期，如0期,Ⅰ期,Ⅱ期 ,Ⅲ期 ,Ⅳ期
	 */
	private String tumourPeriodizationClinic;
	/**
	 * 肿瘤分期，为上述TNM和临床分期组合。如：TxN3M1 IV期。（特病专用）
	 */
	private String tumourPeriodization;
	/**
	 * 出院诊断
	 */
	private String outhospitalDiagnosisCode;
	private String outhospitalDiagnosis;
	/**
	 * 门诊号
	 */
	private String clinicNo;
	
	/**
	 * 患者基本信息登记Id
	 */
	private Long specialDiseaseRegisterId;
	/**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	/**
	 * 门诊记录
	 */
	private String clinicMedicalId;
	
	private Integer hospitalId; 
	
	/**
	 * icd病种
	 */
	private Integer icdDiseaseTypeId;
	
	/**
	 * icd病种
	 */
	private Integer tumorFlag;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public String getEmrId() {
		return emrId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public String getDiagnosisCode() {
		return diagnosisCode;
	}
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public Integer getInHospitalCondition() {
		return inHospitalCondition;
	}
	public Integer getDiagnosisExplain() {
		return diagnosisExplain;
	}
	public String getOrganName() {
		return organName;
	}
	public String getOrganCode() {
		return organCode;
	}
	public Integer getIsFollowup() {
		return isFollowup;
	}
	public Integer getSourceCancerCount() {
		return sourceCancerCount;
	}
	public Integer getTreatmentHistory() {
		return treatmentHistory;
	}
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	public String getRemark() {
		return remark;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public Long getCreator() {
		return creator;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public void setInHospitalCondition(Integer inHospitalCondition) {
		this.inHospitalCondition = inHospitalCondition;
	}
	public void setDiagnosisExplain(Integer diagnosisExplain) {
		this.diagnosisExplain = diagnosisExplain;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public void setIsFollowup(Integer isFollowup) {
		this.isFollowup = isFollowup;
	}
	public void setSourceCancerCount(Integer sourceCancerCount) {
		this.sourceCancerCount = sourceCancerCount;
	}
	public void setTreatmentHistory(Integer treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOperateAction() {
		return operateAction;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getDiagnosisBasisId() {
		return diagnosisBasisId;
	}

	public void setDiagnosisBasisId(Integer diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public Integer getOuthospitalCondition() {
		return outhospitalCondition;
	}
	public void setOuthospitalCondition(Integer outhospitalCondition) {
		this.outhospitalCondition = outhospitalCondition;
	}
	public Integer getSuspectedDiagnosisFlag() {
		return suspectedDiagnosisFlag;
	}
	public void setSuspectedDiagnosisFlag(Integer suspectedDiagnosisFlag) {
		this.suspectedDiagnosisFlag = suspectedDiagnosisFlag;
	}
	public Integer getSurgeryFlag() {
		return surgeryFlag;
	}
	public void setSurgeryFlag(Integer surgeryFlag) {
		this.surgeryFlag = surgeryFlag;
	}
	public Integer getFirstdiagnosisHospitalId() {
		return firstdiagnosisHospitalId;
	}
	public void setFirstdiagnosisHospitalId(Integer firstdiagnosisHospitalId) {
		this.firstdiagnosisHospitalId = firstdiagnosisHospitalId;
	}
	public String getFirstdiagnosisHospitalName() {
		return firstdiagnosisHospitalName;
	}
	public void setFirstdiagnosisHospitalName(String firstdiagnosisHospitalName) {
		this.firstdiagnosisHospitalName = firstdiagnosisHospitalName;
	}
	public Date getFirstdiagnosisTime() {
		return firstdiagnosisTime;
	}
	public void setFirstdiagnosisTime(Date firstdiagnosisTime) {
		this.firstdiagnosisTime = firstdiagnosisTime;
	}
	public Integer getSpecialDiseaseDiagnosisId() {
		return specialDiseaseDiagnosisId;
	}
	public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
		this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
	}
	public Integer getDiagnosisDoctorId() {
		return diagnosisDoctorId;
	}
	public void setDiagnosisDoctorId(Integer diagnosisDoctorId) {
		this.diagnosisDoctorId = diagnosisDoctorId;
	}
	public String getDiagnosisDoctorName() {
		return diagnosisDoctorName;
	}
	public void setDiagnosisDoctorName(String diagnosisDoctorName) {
		this.diagnosisDoctorName = diagnosisDoctorName;
	}
	public Integer getOuthospitalDeptId() {
		return outhospitalDeptId;
	}
	public void setOuthospitalDeptId(Integer outhospitalDeptId) {
		this.outhospitalDeptId = outhospitalDeptId;
	}
	public String getTumourPeriodizationT() {
		return tumourPeriodizationT;
	}
	public void setTumourPeriodizationT(String tumourPeriodizationT) {
		this.tumourPeriodizationT = tumourPeriodizationT;
	}
	public String getTumourPeriodizationN() {
		return tumourPeriodizationN;
	}
	public void setTumourPeriodizationN(String tumourPeriodizationN) {
		this.tumourPeriodizationN = tumourPeriodizationN;
	}
	public String getTumourPeriodizationM1() {
		return tumourPeriodizationM1;
	}
	public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
		this.tumourPeriodizationM1 = tumourPeriodizationM1;
	}
	public String getTumourPeriodizationClinic() {
		return tumourPeriodizationClinic;
	}
	public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
		this.tumourPeriodizationClinic = tumourPeriodizationClinic;
	}
	public String getTumourPeriodization() {
		return tumourPeriodization;
	}
	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
	}
	public String getDiseaseBasis() {
		return diseaseBasis;
	}
	public void setDiseaseBasis(String diseaseBasis) {
		this.diseaseBasis = diseaseBasis;
	}
	public String getOuthospitalDiagnosisCode() {
		return outhospitalDiagnosisCode;
	}
	public void setOuthospitalDiagnosisCode(String outhospitalDiagnosisCode) {
		this.outhospitalDiagnosisCode = outhospitalDiagnosisCode;
	}
	public String getOuthospitalDiagnosis() {
		return outhospitalDiagnosis;
	}
	public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
		this.outhospitalDiagnosis = outhospitalDiagnosis;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public Integer getOperateFlag() {
		return operateFlag;
	}
	public void setOperateFlag(Integer operateFlag) {
		this.operateFlag = operateFlag;
	}
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}
	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}
	public Integer getTumorFlag() {
		return tumorFlag;
	}
	public void setTumorFlag(Integer tumorFlag) {
		this.tumorFlag = tumorFlag;
	}
}
