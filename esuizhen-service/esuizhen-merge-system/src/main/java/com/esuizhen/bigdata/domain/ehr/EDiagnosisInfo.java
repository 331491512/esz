package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_diagnosis_info", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_diagnosis_info_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EDiagnosisInfo {
    private String diagnosisId;
    private String emrId;
    private String mainId;
    private Integer tempId;
    private Long patientId;
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
    private Timestamp visitTime;
    private Long operatorId;
    private Integer syncFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer outhospitalCondition;
    private Integer handleFlag;
    private Long firstdiagnosisHospitalId;
    private String firstdiagnosisHospitalName;
    private Timestamp firstdiagnosisTime;
    private Integer specialDiseaseDiagnosisId;
    private Long diagnosisDoctorId;
    private String diagnosisDoctorName;
    private Integer suspectedDiagnosisFlag;
    private Integer surgeryFlag;
    private Integer outhospitalDeptId;
    private String tumourPeriodizationT;
    private String tumourPeriodizationN;
    private String tumourPeriodizationM1;
    private String tumourPeriodizationClinic;
    private String tumourPeriodization;
    private String outhospitalDiagnosis;
    private String outhospitalDiagnosisCode;
    private String clinicNo;
    private Timestamp rawCreateTime;
    private Integer seq;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    @Basic
    @Column(name = "mergeFlag", nullable = true)
    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    @Basic
    @Column(name = "mergeFrom", nullable = true)
    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    @Basic
    @Column(name = "mergeTarget", nullable = true)
    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Id
    @Column(name = "diagnosisId", nullable = false, length = 128)
    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Basic
    @Column(name = "emrId", nullable = false, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "mainID", nullable = true, length = 128)
    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    @Basic
    @Column(name = "tempId", nullable = true)
    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patientNo", nullable = true, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "oldPatientNo", nullable = true, length = 128)
    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo;
    }

    @Basic
    @Column(name = "inhospitalTimes", nullable = true)
    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    @Basic
    @Column(name = "oldInhospitalTimes", nullable = true)
    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    @Basic
    @Column(name = "inhospitalNo", nullable = true, length = 128)
    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = true, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "diagnosisTypeId", nullable = true)
    public Integer getDiagnosisTypeId() {
        return diagnosisTypeId;
    }

    public void setDiagnosisTypeId(Integer diagnosisTypeId) {
        this.diagnosisTypeId = diagnosisTypeId;
    }

    @Basic
    @Column(name = "diagnosis", nullable = true, length = 512)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "diseaseCode", nullable = true, length = 20)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "zdyCode", nullable = true, length = 20)
    public String getZdyCode() {
        return zdyCode;
    }

    public void setZdyCode(String zdyCode) {
        this.zdyCode = zdyCode;
    }

    @Basic
    @Column(name = "eszCode", nullable = true, length = 20)
    public String getEszCode() {
        return eszCode;
    }

    public void setEszCode(String eszCode) {
        this.eszCode = eszCode;
    }

    @Basic
    @Column(name = "diseaseTypeId", nullable = true)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "icdDiseaseTypeId", nullable = true)
    public Integer getIcdDiseaseTypeId() {
        return icdDiseaseTypeId;
    }

    public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
        this.icdDiseaseTypeId = icdDiseaseTypeId;
    }

    @Basic
    @Column(name = "diseaseBasis", nullable = true, length = 32)
    public String getDiseaseBasis() {
        return diseaseBasis;
    }

    public void setDiseaseBasis(String diseaseBasis) {
        this.diseaseBasis = diseaseBasis;
    }

    @Basic
    @Column(name = "diagnosisExplain", nullable = true)
    public Integer getDiagnosisExplain() {
        return diagnosisExplain;
    }

    public void setDiagnosisExplain(Integer diagnosisExplain) {
        this.diagnosisExplain = diagnosisExplain;
    }

    @Basic
    @Column(name = "inHospitalCondition", nullable = true)
    public Integer getInHospitalCondition() {
        return inHospitalCondition;
    }

    public void setInHospitalCondition(Integer inHospitalCondition) {
        this.inHospitalCondition = inHospitalCondition;
    }

    @Basic
    @Column(name = "organCode", nullable = true, length = 32)
    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    @Basic
    @Column(name = "organName", nullable = true, length = 255)
    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    @Basic
    @Column(name = "treatmentHistory", nullable = true)
    public Integer getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(Integer treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    @Basic
    @Column(name = "isFollowup", nullable = true)
    public Integer getIsFollowup() {
        return isFollowup;
    }

    public void setIsFollowup(Integer isFollowup) {
        this.isFollowup = isFollowup;
    }

    @Basic
    @Column(name = "sourceCancerCount", nullable = true)
    public Integer getSourceCancerCount() {
        return sourceCancerCount;
    }

    public void setSourceCancerCount(Integer sourceCancerCount) {
        this.sourceCancerCount = sourceCancerCount;
    }

    @Basic
    @Column(name = "diseaseBodyPartId", nullable = true)
    public Integer getDiseaseBodyPartId() {
        return diseaseBodyPartId;
    }

    public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
        this.diseaseBodyPartId = diseaseBodyPartId;
    }

    @Basic
    @Column(name = "pathologyDiagnosis", nullable = true, length = 512)
    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode", nullable = true, length = 20)
    public String getPathologyDiagnosisCode() {
        return pathologyDiagnosisCode;
    }

    public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
        this.pathologyDiagnosisCode = pathologyDiagnosisCode;
    }

    @Basic
    @Column(name = "disagnosisPeriodizationId", nullable = true)
    public Integer getDisagnosisPeriodizationId() {
        return disagnosisPeriodizationId;
    }

    public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
        this.disagnosisPeriodizationId = disagnosisPeriodizationId;
    }

    @Basic
    @Column(name = "diagnosisBasisId", nullable = true)
    public Integer getDiagnosisBasisId() {
        return diagnosisBasisId;
    }

    public void setDiagnosisBasisId(Integer diagnosisBasisId) {
        this.diagnosisBasisId = diagnosisBasisId;
    }

    @Basic
    @Column(name = "isSourceDiagnosis", nullable = false)
    public Integer getIsSourceDiagnosis() {
        return isSourceDiagnosis;
    }

    public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
        this.isSourceDiagnosis = isSourceDiagnosis;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 256)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "visitTime", nullable = false)
    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }

    @Basic
    @Column(name = "operatorId", nullable = true)
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "outhospitalCondition", nullable = true)
    public Integer getOuthospitalCondition() {
        return outhospitalCondition;
    }

    public void setOuthospitalCondition(Integer outhospitalCondition) {
        this.outhospitalCondition = outhospitalCondition;
    }

    @Basic
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    @Basic
    @Column(name = "firstdiagnosisHospitalId", nullable = true)
    public Long getFirstdiagnosisHospitalId() {
        return firstdiagnosisHospitalId;
    }

    public void setFirstdiagnosisHospitalId(Long firstdiagnosisHospitalId) {
        this.firstdiagnosisHospitalId = firstdiagnosisHospitalId;
    }

    @Basic
    @Column(name = "firstdiagnosisHospitalName", nullable = true, length = 60)
    public String getFirstdiagnosisHospitalName() {
        return firstdiagnosisHospitalName;
    }

    public void setFirstdiagnosisHospitalName(String firstdiagnosisHospitalName) {
        this.firstdiagnosisHospitalName = firstdiagnosisHospitalName;
    }

    @Basic
    @Column(name = "firstdiagnosisTime", nullable = true)
    public Timestamp getFirstdiagnosisTime() {
        return firstdiagnosisTime;
    }

    public void setFirstdiagnosisTime(Timestamp firstdiagnosisTime) {
        this.firstdiagnosisTime = firstdiagnosisTime;
    }

    @Basic
    @Column(name = "specialDiseaseDiagnosisId", nullable = true)
    public Integer getSpecialDiseaseDiagnosisId() {
        return specialDiseaseDiagnosisId;
    }

    public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
        this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
    }

    @Basic
    @Column(name = "diagnosisDoctorId", nullable = true)
    public Long getDiagnosisDoctorId() {
        return diagnosisDoctorId;
    }

    public void setDiagnosisDoctorId(Long diagnosisDoctorId) {
        this.diagnosisDoctorId = diagnosisDoctorId;
    }

    @Basic
    @Column(name = "diagnosisDoctorName", nullable = true, length = 60)
    public String getDiagnosisDoctorName() {
        return diagnosisDoctorName;
    }

    public void setDiagnosisDoctorName(String diagnosisDoctorName) {
        this.diagnosisDoctorName = diagnosisDoctorName;
    }

    @Basic
    @Column(name = "suspectedDiagnosisFlag", nullable = true)
    public Integer getSuspectedDiagnosisFlag() {
        return suspectedDiagnosisFlag;
    }

    public void setSuspectedDiagnosisFlag(Integer suspectedDiagnosisFlag) {
        this.suspectedDiagnosisFlag = suspectedDiagnosisFlag;
    }

    @Basic
    @Column(name = "surgeryFlag", nullable = true)
    public Integer getSurgeryFlag() {
        return surgeryFlag;
    }

    public void setSurgeryFlag(Integer surgeryFlag) {
        this.surgeryFlag = surgeryFlag;
    }

    @Basic
    @Column(name = "outhospitalDeptId", nullable = true)
    public Integer getOuthospitalDeptId() {
        return outhospitalDeptId;
    }

    public void setOuthospitalDeptId(Integer outhospitalDeptId) {
        this.outhospitalDeptId = outhospitalDeptId;
    }

    @Basic
    @Column(name = "tumourPeriodizationT", nullable = true, length = 32)
    public String getTumourPeriodizationT() {
        return tumourPeriodizationT;
    }

    public void setTumourPeriodizationT(String tumourPeriodizationT) {
        this.tumourPeriodizationT = tumourPeriodizationT;
    }

    @Basic
    @Column(name = "tumourPeriodizationN", nullable = true, length = 32)
    public String getTumourPeriodizationN() {
        return tumourPeriodizationN;
    }

    public void setTumourPeriodizationN(String tumourPeriodizationN) {
        this.tumourPeriodizationN = tumourPeriodizationN;
    }

    @Basic
    @Column(name = "tumourPeriodizationM1", nullable = true, length = 32)
    public String getTumourPeriodizationM1() {
        return tumourPeriodizationM1;
    }

    public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
        this.tumourPeriodizationM1 = tumourPeriodizationM1;
    }

    @Basic
    @Column(name = "tumourPeriodizationClinic", nullable = true, length = 32)
    public String getTumourPeriodizationClinic() {
        return tumourPeriodizationClinic;
    }

    public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
        this.tumourPeriodizationClinic = tumourPeriodizationClinic;
    }

    @Basic
    @Column(name = "tumourPeriodization", nullable = true, length = 128)
    public String getTumourPeriodization() {
        return tumourPeriodization;
    }

    public void setTumourPeriodization(String tumourPeriodization) {
        this.tumourPeriodization = tumourPeriodization;
    }

    @Basic
    @Column(name = "outhospitalDiagnosis", nullable = true, length = 64)
    public String getOuthospitalDiagnosis() {
        return outhospitalDiagnosis;
    }

    public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
        this.outhospitalDiagnosis = outhospitalDiagnosis;
    }

    @Basic
    @Column(name = "outhospitalDiagnosisCode", nullable = true, length = 20)
    public String getOuthospitalDiagnosisCode() {
        return outhospitalDiagnosisCode;
    }

    public void setOuthospitalDiagnosisCode(String outhospitalDiagnosisCode) {
        this.outhospitalDiagnosisCode = outhospitalDiagnosisCode;
    }

    @Basic
    @Column(name = "clinicNo", nullable = true, length = 128)
    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Basic
    @Column(name = "seq", nullable = true)
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EDiagnosisInfo that = (EDiagnosisInfo) o;

        if (diagnosisId != null ? !diagnosisId.equals(that.diagnosisId) : that.diagnosisId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (mainId != null ? !mainId.equals(that.mainId) : that.mainId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (oldPatientNo != null ? !oldPatientNo.equals(that.oldPatientNo) : that.oldPatientNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (oldInhospitalTimes != null ? !oldInhospitalTimes.equals(that.oldInhospitalTimes) : that.oldInhospitalTimes != null)
            return false;
        if (inhospitalNo != null ? !inhospitalNo.equals(that.inhospitalNo) : that.inhospitalNo != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (diagnosisTypeId != null ? !diagnosisTypeId.equals(that.diagnosisTypeId) : that.diagnosisTypeId != null)
            return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (zdyCode != null ? !zdyCode.equals(that.zdyCode) : that.zdyCode != null) return false;
        if (eszCode != null ? !eszCode.equals(that.eszCode) : that.eszCode != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (icdDiseaseTypeId != null ? !icdDiseaseTypeId.equals(that.icdDiseaseTypeId) : that.icdDiseaseTypeId != null)
            return false;
        if (diseaseBasis != null ? !diseaseBasis.equals(that.diseaseBasis) : that.diseaseBasis != null) return false;
        if (diagnosisExplain != null ? !diagnosisExplain.equals(that.diagnosisExplain) : that.diagnosisExplain != null)
            return false;
        if (inHospitalCondition != null ? !inHospitalCondition.equals(that.inHospitalCondition) : that.inHospitalCondition != null)
            return false;
        if (organCode != null ? !organCode.equals(that.organCode) : that.organCode != null) return false;
        if (organName != null ? !organName.equals(that.organName) : that.organName != null) return false;
        if (treatmentHistory != null ? !treatmentHistory.equals(that.treatmentHistory) : that.treatmentHistory != null)
            return false;
        if (isFollowup != null ? !isFollowup.equals(that.isFollowup) : that.isFollowup != null) return false;
        if (sourceCancerCount != null ? !sourceCancerCount.equals(that.sourceCancerCount) : that.sourceCancerCount != null)
            return false;
        if (diseaseBodyPartId != null ? !diseaseBodyPartId.equals(that.diseaseBodyPartId) : that.diseaseBodyPartId != null)
            return false;
        if (pathologyDiagnosis != null ? !pathologyDiagnosis.equals(that.pathologyDiagnosis) : that.pathologyDiagnosis != null)
            return false;
        if (pathologyDiagnosisCode != null ? !pathologyDiagnosisCode.equals(that.pathologyDiagnosisCode) : that.pathologyDiagnosisCode != null)
            return false;
        if (disagnosisPeriodizationId != null ? !disagnosisPeriodizationId.equals(that.disagnosisPeriodizationId) : that.disagnosisPeriodizationId != null)
            return false;
        if (diagnosisBasisId != null ? !diagnosisBasisId.equals(that.diagnosisBasisId) : that.diagnosisBasisId != null)
            return false;
        if (isSourceDiagnosis != null ? !isSourceDiagnosis.equals(that.isSourceDiagnosis) : that.isSourceDiagnosis != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (outhospitalCondition != null ? !outhospitalCondition.equals(that.outhospitalCondition) : that.outhospitalCondition != null)
            return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (firstdiagnosisHospitalId != null ? !firstdiagnosisHospitalId.equals(that.firstdiagnosisHospitalId) : that.firstdiagnosisHospitalId != null)
            return false;
        if (firstdiagnosisHospitalName != null ? !firstdiagnosisHospitalName.equals(that.firstdiagnosisHospitalName) : that.firstdiagnosisHospitalName != null)
            return false;
        if (firstdiagnosisTime != null ? !firstdiagnosisTime.equals(that.firstdiagnosisTime) : that.firstdiagnosisTime != null)
            return false;
        if (specialDiseaseDiagnosisId != null ? !specialDiseaseDiagnosisId.equals(that.specialDiseaseDiagnosisId) : that.specialDiseaseDiagnosisId != null)
            return false;
        if (diagnosisDoctorId != null ? !diagnosisDoctorId.equals(that.diagnosisDoctorId) : that.diagnosisDoctorId != null)
            return false;
        if (diagnosisDoctorName != null ? !diagnosisDoctorName.equals(that.diagnosisDoctorName) : that.diagnosisDoctorName != null)
            return false;
        if (suspectedDiagnosisFlag != null ? !suspectedDiagnosisFlag.equals(that.suspectedDiagnosisFlag) : that.suspectedDiagnosisFlag != null)
            return false;
        if (surgeryFlag != null ? !surgeryFlag.equals(that.surgeryFlag) : that.surgeryFlag != null) return false;
        if (outhospitalDeptId != null ? !outhospitalDeptId.equals(that.outhospitalDeptId) : that.outhospitalDeptId != null)
            return false;
        if (tumourPeriodizationT != null ? !tumourPeriodizationT.equals(that.tumourPeriodizationT) : that.tumourPeriodizationT != null)
            return false;
        if (tumourPeriodizationN != null ? !tumourPeriodizationN.equals(that.tumourPeriodizationN) : that.tumourPeriodizationN != null)
            return false;
        if (tumourPeriodizationM1 != null ? !tumourPeriodizationM1.equals(that.tumourPeriodizationM1) : that.tumourPeriodizationM1 != null)
            return false;
        if (tumourPeriodizationClinic != null ? !tumourPeriodizationClinic.equals(that.tumourPeriodizationClinic) : that.tumourPeriodizationClinic != null)
            return false;
        if (tumourPeriodization != null ? !tumourPeriodization.equals(that.tumourPeriodization) : that.tumourPeriodization != null)
            return false;
        if (outhospitalDiagnosis != null ? !outhospitalDiagnosis.equals(that.outhospitalDiagnosis) : that.outhospitalDiagnosis != null)
            return false;
        if (outhospitalDiagnosisCode != null ? !outhospitalDiagnosisCode.equals(that.outhospitalDiagnosisCode) : that.outhospitalDiagnosisCode != null)
            return false;
        if (clinicNo != null ? !clinicNo.equals(that.clinicNo) : that.clinicNo != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisId != null ? diagnosisId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (oldPatientNo != null ? oldPatientNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (oldInhospitalTimes != null ? oldInhospitalTimes.hashCode() : 0);
        result = 31 * result + (inhospitalNo != null ? inhospitalNo.hashCode() : 0);
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (diagnosisTypeId != null ? diagnosisTypeId.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (zdyCode != null ? zdyCode.hashCode() : 0);
        result = 31 * result + (eszCode != null ? eszCode.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (icdDiseaseTypeId != null ? icdDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (diseaseBasis != null ? diseaseBasis.hashCode() : 0);
        result = 31 * result + (diagnosisExplain != null ? diagnosisExplain.hashCode() : 0);
        result = 31 * result + (inHospitalCondition != null ? inHospitalCondition.hashCode() : 0);
        result = 31 * result + (organCode != null ? organCode.hashCode() : 0);
        result = 31 * result + (organName != null ? organName.hashCode() : 0);
        result = 31 * result + (treatmentHistory != null ? treatmentHistory.hashCode() : 0);
        result = 31 * result + (isFollowup != null ? isFollowup.hashCode() : 0);
        result = 31 * result + (sourceCancerCount != null ? sourceCancerCount.hashCode() : 0);
        result = 31 * result + (diseaseBodyPartId != null ? diseaseBodyPartId.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis != null ? pathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode != null ? pathologyDiagnosisCode.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId != null ? disagnosisPeriodizationId.hashCode() : 0);
        result = 31 * result + (diagnosisBasisId != null ? diagnosisBasisId.hashCode() : 0);
        result = 31 * result + (isSourceDiagnosis != null ? isSourceDiagnosis.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (outhospitalCondition != null ? outhospitalCondition.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (firstdiagnosisHospitalId != null ? firstdiagnosisHospitalId.hashCode() : 0);
        result = 31 * result + (firstdiagnosisHospitalName != null ? firstdiagnosisHospitalName.hashCode() : 0);
        result = 31 * result + (firstdiagnosisTime != null ? firstdiagnosisTime.hashCode() : 0);
        result = 31 * result + (specialDiseaseDiagnosisId != null ? specialDiseaseDiagnosisId.hashCode() : 0);
        result = 31 * result + (diagnosisDoctorId != null ? diagnosisDoctorId.hashCode() : 0);
        result = 31 * result + (diagnosisDoctorName != null ? diagnosisDoctorName.hashCode() : 0);
        result = 31 * result + (suspectedDiagnosisFlag != null ? suspectedDiagnosisFlag.hashCode() : 0);
        result = 31 * result + (surgeryFlag != null ? surgeryFlag.hashCode() : 0);
        result = 31 * result + (outhospitalDeptId != null ? outhospitalDeptId.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationT != null ? tumourPeriodizationT.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationN != null ? tumourPeriodizationN.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationM1 != null ? tumourPeriodizationM1.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationClinic != null ? tumourPeriodizationClinic.hashCode() : 0);
        result = 31 * result + (tumourPeriodization != null ? tumourPeriodization.hashCode() : 0);
        result = 31 * result + (outhospitalDiagnosis != null ? outhospitalDiagnosis.hashCode() : 0);
        result = 31 * result + (outhospitalDiagnosisCode != null ? outhospitalDiagnosisCode.hashCode() : 0);
        result = 31 * result + (clinicNo != null ? clinicNo.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        return result;
    }
}
