package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.constant.Constant;

/**
 * 患者诊断信息
 * @author YYCHEN
 *
 */
public class TPatientDiagnosisNoteDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String emrNo;
	private Integer emrType;
	
	private String diagnosisId;
	private String emrId;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer hospitalId;
	private Integer diseaseTypeId;
	private String diagnosis;
	private Integer diseaseBodyPartId;
	private String diseaseCode;
	private String pathologyDiagnosis;
	private String pathologyDiagnosisCode;
	private Integer diagnosisTypeId;
	private Integer isSourceDiagnosis;
	private String remark;
	private Date visitTime;
	private Date createTime;
	private Date updateTime;
//	private String iCD_1OCode;
//	private Integer tumorPosition;
//	private String diagnosisExplaination;
//	private String diagnosisBasis;
	private List<TSourceDiagnosisInfo> sourceDiagnosisList;
	
	private String outHospitalCondition;
	private Integer inhospitalCondition;
	private Integer bodyPartId;
	private String hospitalUuid;
	private Date inhospitalDate;
	private Date confirmedDate;
	private String inhospitalId;
	private String mainID;
	private Integer inhospitalTimes;
	private String organCode;
	private String organName;
	private Integer diagnosisExplain;
	private Integer diagnosisBasisId;
	private String diseaseBasis;
	private String creatorUuid;
	private Long creator;
	private String operatorUuid;
	private Long operatorId;
	private Integer firstdiagnosisHospitalId;
	private String firstdiagnosisHospitalName;
	private Date firstdiagnosisTime;
	private String diagnosisDoctorUuid;
	private Long diagnosisDoctorId;
	private String diagnosisDoctorName;
	private String zdyCode;
	private String eszCode;
	private Integer treatmentHistory;
	private Integer sourceCancerCount;
	private Integer disagnosisPeriodizationId;
	private String clinicNo;
	private String tumourPeriodizationClinic;
	private String tumourPeriodization;
	private String outhospitalDiagnosis;
	private String outhospitalDiagnosisCode;
	private Date rawCreateTime;
	private Date syncTime;
	private Integer icdDiseaseTypeId;
	
	private String inhospitalNo;
	private Integer isFollowup;
	private Integer specialDiseaseDiagnosisId;
	private Integer suspectedDiagnosisFlag;
	private Integer surgeryFlag;
	private String seq;
	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	public Integer getEmrType() {
		return emrType;
	}

	public Date getInhospitalDate() {
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public void setEmrType(Integer emrType) {
		this.emrType = emrType;
	}

	public String getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the confirmedDate
	 */
	public Date getConfirmedDate() {
		return confirmedDate;
	}

	/**
	 * @param confirmedDate the confirmedDate to set
	 */
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	/**
	 * @return the emrNo
	 */
	public String getEmrNo() {
		return emrNo;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @param emrNo the emrNo to set
	 */
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
	}

	/**
	 * @return the hospitalId
	 */
	public Integer getHospitalId() {
		return hospitalId;
	}

	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return the emrId
	 */
	public String getEmrId() {
		return emrId;
	}

	/**
	 * @param emrId the emrId to set
	 */
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	/**
	 * @return the patientUuid
	 */
	public String getPatientUuid() {
		return patientUuid;
	}

	/**
	 * @param patientUuid the patientUuid to set
	 */
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	/**
	 * @return the diseaseTypeId
	 */
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	/**
	 * @param diseaseTypeId the diseaseTypeId to set
	 */
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}

	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}

	/**
	 * @return the outHospitalCondition
	 */
	public String getOutHospitalCondition() {
		return outHospitalCondition;
	}

	/**
	 * @param outHospitalCondition the outHospitalCondition to set
	 */
	public void setOutHospitalCondition(String outHospitalCondition) {
		this.outHospitalCondition = outHospitalCondition;
	}


	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the diseaseCode
	 */
	public String getDiseaseCode() {
		return diseaseCode;
	}

	/**
	 * @param diseaseCode the diseaseCode to set
	 */
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	/**
	 * @return the pathologyDiagnosis
	 */
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}

	/**
	 * @param pathologyDiagnosis the pathologyDiagnosis to set
	 */
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}

	/**
	 * @return the pathologyDiagnosisCode
	 */
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}

	/**
	 * @param pathologyDiagnosisCode the pathologyDiagnosisCode to set
	 */
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}

	/**
	 * @return the bodyPartId
	 */
	public Integer getBodyPartId() {
		return bodyPartId;
	}

	/**
	 * @param bodyPartId the bodyPartId to set
	 */
	public void setBodyPartId(Integer bodyPartId) {
		this.bodyPartId = bodyPartId;
	}

	/**
	 * @return the isSourceDiagnosis
	 */
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}

	/**
	 * @param isSourceDiagnosis the isSourceDiagnosis to set
	 */
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}

	/**
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}

	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
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
	 * @return the visitTime
	 */
	public Date getVisitTime() {
		return visitTime;
	}

	/**
	 * @param visitTime the visitTime to set
	 */
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
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

	/**
	 * @return the diseaseBodyPartId
	 */
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}

	/**
	 * @param diseaseBodyPartId the diseaseBodyPartId to set
	 */
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}

	/**
	 * @return the sourceDiagnosisList
	 */
	public List<TSourceDiagnosisInfo> getSourceDiagnosisList() {
		return sourceDiagnosisList;
	}

	public Integer getInhospitalCondition() {
		return inhospitalCondition;
	}

	public void setInhospitalCondition(Integer inhospitalCondition) {
		this.inhospitalCondition = inhospitalCondition;
	}

	/**
	 * @param sourceDiagnosisList the sourceDiagnosisList to set
	 */
	public void setSourceDiagnosisList(List<TSourceDiagnosisInfo> sourceDiagnosisList) {
		this.sourceDiagnosisList = sourceDiagnosisList;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getMainID() {
		return mainID;
	}

	public void setMainID(String mainID) {
		this.mainID = mainID;
	}

	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}

	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
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

	public Integer getDiagnosisExplain() {
		return diagnosisExplain;
	}

	public void setDiagnosisExplain(Integer diagnosisExplain) {
		this.diagnosisExplain = diagnosisExplain;
	}

	public Integer getDiagnosisBasisId() {
		return diagnosisBasisId;
	}

	public void setDiagnosisBasisId(Integer diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}

	public String getCreatorUuid() {
		return creatorUuid;
	}

	public void setCreatorUuid(String creatorUuid) {
		this.creatorUuid = creatorUuid;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public String getOperatorUuid() {
		return operatorUuid;
	}

	public void setOperatorUuid(String operatorUuid) {
		this.operatorUuid = operatorUuid;
	}

	
	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
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


	public Integer getTreatmentHistory() {
		return treatmentHistory;
	}

	public void setTreatmentHistory(Integer treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}

	public Integer getSourceCancerCount() {
		return sourceCancerCount;
	}

	public void setSourceCancerCount(Integer sourceCancerCount) {
		this.sourceCancerCount = sourceCancerCount;
	}

	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}

	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}

	public String getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
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

	public Date getRawCreateTime() {
		return rawCreateTime;
	}

	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	public String getDiseaseBasis() {
		return diseaseBasis;
	}

	public void setDiseaseBasis(String diseaseBasis) {
		this.diseaseBasis = diseaseBasis;
	}

	public Long getDiagnosisDoctorId() {
		return diagnosisDoctorId;
	}

	public void setDiagnosisDoctorId(Long diagnosisDoctorId) {
		this.diagnosisDoctorId = diagnosisDoctorId;
	}

	public MedicalRecord createMedicalRecord(){
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanUtils.copyProperties(this, medicalRecord);
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_DIAGNOSIS);
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		medicalRecord.setSyncFlag(Constant.SYNC_OK);
		if(visitTime==null)
			medicalRecord.setVisitTime(confirmedDate==null?new Date():confirmedDate);
		return medicalRecord;
	}
	
	public DiagnosisInfo createDiagnosisInfo(){
		DiagnosisInfo diagnosisInfo = new DiagnosisInfo();
		BeanUtils.copyProperties(this, diagnosisInfo);
		if(visitTime==null)
			diagnosisInfo.setVisitTime(confirmedDate==null?new Date():confirmedDate);
		return diagnosisInfo;
	}

	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}

	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}

	public String getInhospitalNo() {
		return inhospitalNo;
	}

	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}

	public Integer getIsFollowup() {
		return isFollowup;
	}

	public void setIsFollowup(Integer isFollowup) {
		this.isFollowup = isFollowup;
	}

	public Integer getSpecialDiseaseDiagnosisId() {
		return specialDiseaseDiagnosisId;
	}

	public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
		this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
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

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
}
