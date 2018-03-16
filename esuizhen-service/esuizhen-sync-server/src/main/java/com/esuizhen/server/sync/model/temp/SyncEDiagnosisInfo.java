package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 诊断bean
 * 
 * @author LHY
 */
public class SyncEDiagnosisInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String diagnosisId;
	private String emrId;
	private String mainID;
	private Integer tempId;
	private long patientId;
	private String patientUuid;
	private String patientNo;
	private String oldPatientNo;
	private Integer inhospitalTimes;
	private Integer oldInhospitalTimes;
	private String inhospitalNo;
	private String inhospitalId;
	private Integer diagnosisTypeId;
	private String diagnosis;
	private String diseaseCode;
	private String zdyCode;
	private String eszCode;
	private Integer diseaseTypeId;
	private Integer icdDiseaseTypeId;
	private String diseaseBasis;
	private Integer diagnosisExplain;
	private Integer inHospitalCondition;
	private String organCode;
	private String organName;
	private Integer treatmentHistory;
	private Integer isFollowup;
	private Integer sourceCancerCount;
	private Integer diseaseBodyPartId;
	private String pathologyDiagnosis;
	private String pathologyDiagnosisCode;
	private Integer disagnosisPeriodizationId;
	private Integer diagnosisBasisId;
	private Integer isSourceDiagnosis;
	private String remark;
	private Date visitTime;
	private Long operatorId;
	private String operatorUuid;
	private Date createTime;
	private Date updateTime;
	private Integer outhospitalCondition;
	private Integer handleFlag;
	private Long firstdiagnosisHospitalId;
	private String firstdiagnosisHospitalName;
	private Date firstdiagnosisTime;
	private Integer specialDiseaseDiagnosisId;
	private Long diagnosisDoctorId;
	private String diagnosisDoctorUuid;
	private String diagnosisDoctorName;
	private Integer suspectedDiagnosisFlag;
	private Integer surgeryFlag;
	private Integer outhospitalDeptId;
	private String outhospitalDeptUuid;
	private String tumourPeriodizationT;
	private String tumourPeriodizationN;
	private String tumourPeriodizationM1;
	private String tumourPeriodizationClinic;
	private String tumourPeriodization;
	private String outhospitalDiagnosis;
	private String outhospitalDiagnosisCode;
	private String clinicNo;
	private Date rawCreateTime;
	private Integer seq;
	private Long creator;
	private String creatorUuid;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private Date mergeTime;
	private Long specialDiseaseRegisterId;
	private String batchId;
	private Integer sourceFlag;
	
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}
	public Integer getTempId() {
		return tempId;
	}
	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getOldPatientNo() {
		return oldPatientNo;
	}
	public void setOldPatientNo(String oldPatientNo) {
		this.oldPatientNo = oldPatientNo;
	}
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public Integer getOldInhospitalTimes() {
		return oldInhospitalTimes;
	}
	public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
		this.oldInhospitalTimes = oldInhospitalTimes;
	}
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getZdyCode() {
		return zdyCode;
	}
	public void setZdyCode(String zdyCode) {
		this.zdyCode = zdyCode;
	}
	public String getEszCode() {
		return eszCode;
	}
	public void setEszCode(String eszCode) {
		this.eszCode = eszCode;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}
	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}
	public String getDiseaseBasis() {
		return diseaseBasis;
	}
	public void setDiseaseBasis(String diseaseBasis) {
		this.diseaseBasis = diseaseBasis;
	}
	public Integer getDiagnosisExplain() {
		return diagnosisExplain;
	}
	public void setDiagnosisExplain(Integer diagnosisExplain) {
		this.diagnosisExplain = diagnosisExplain;
	}
	public Integer getInHospitalCondition() {
		return inHospitalCondition;
	}
	public void setInHospitalCondition(Integer inHospitalCondition) {
		this.inHospitalCondition = inHospitalCondition;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public Integer getTreatmentHistory() {
		return treatmentHistory;
	}
	public void setTreatmentHistory(Integer treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}
	public Integer getIsFollowup() {
		return isFollowup;
	}
	public void setIsFollowup(Integer isFollowup) {
		this.isFollowup = isFollowup;
	}
	public Integer getSourceCancerCount() {
		return sourceCancerCount;
	}
	public void setSourceCancerCount(Integer sourceCancerCount) {
		this.sourceCancerCount = sourceCancerCount;
	}
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
	public Integer getDiagnosisBasisId() {
		return diagnosisBasisId;
	}
	public void setDiagnosisBasisId(Integer diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorUuid() {
		return operatorUuid;
	}
	public void setOperatorUuid(String operatorUuid) {
		this.operatorUuid = operatorUuid;
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
	public Integer getOuthospitalCondition() {
		return outhospitalCondition;
	}
	public void setOuthospitalCondition(Integer outhospitalCondition) {
		this.outhospitalCondition = outhospitalCondition;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public Long getFirstdiagnosisHospitalId() {
		return firstdiagnosisHospitalId;
	}
	public void setFirstdiagnosisHospitalId(Long firstdiagnosisHospitalId) {
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
	public Long getDiagnosisDoctorId() {
		return diagnosisDoctorId;
	}
	public void setDiagnosisDoctorId(Long diagnosisDoctorId) {
		this.diagnosisDoctorId = diagnosisDoctorId;
	}
	public String getDiagnosisDoctorUuid() {
		return diagnosisDoctorUuid;
	}
	public void setDiagnosisDoctorUuid(String diagnosisDoctorUuid) {
		this.diagnosisDoctorUuid = diagnosisDoctorUuid;
	}
	public String getDiagnosisDoctorName() {
		return diagnosisDoctorName;
	}
	public void setDiagnosisDoctorName(String diagnosisDoctorName) {
		this.diagnosisDoctorName = diagnosisDoctorName;
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
	public String getOuthospitalDiagnosis() {
		return outhospitalDiagnosis;
	}
	public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
		this.outhospitalDiagnosis = outhospitalDiagnosis;
	}
	public String getOuthospitalDiagnosisCode() {
		return outhospitalDiagnosisCode;
	}
	public void setOuthospitalDiagnosisCode(String outhospitalDiagnosisCode) {
		this.outhospitalDiagnosisCode = outhospitalDiagnosisCode;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
	public String getCreatorUuid() {
		return creatorUuid;
	}
	public void setCreatorUuid(String creatorUuid) {
		this.creatorUuid = creatorUuid;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getOuthospitalDeptUuid() {
		return outhospitalDeptUuid;
	}
	public void setOuthospitalDeptUuid(String outhospitalDeptUuid) {
		this.outhospitalDeptUuid = outhospitalDeptUuid;
	}
	
}