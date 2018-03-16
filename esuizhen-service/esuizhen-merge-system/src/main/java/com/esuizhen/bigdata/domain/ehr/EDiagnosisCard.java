package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_diagnosis_card", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_diagnosis_card_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EDiagnosisCard {
    private String diagnosisCardId;
    private String inhospitalId;
    private String diagnosisId;
    private String emrId;
    private Long patientId;
    private String patientNo;
    private String diagnosis;
    private String diseaseCode;
    private Integer diagnosisBasisId;
    private String pathologyDiagnosis;
    private String pathologyDiagnosisCode;
    private String organCode;
    private String bodyPartName;
    private Timestamp initialTreatmentDate;
    private Integer treatmentHistoryId;
    private Integer disagnosisPeriodizationId;
    private String outDeptType;
    private String treatmentMethod;
    private Timestamp deathTime;
    private String deathCause;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "diagnosisCardId", nullable = false, length = 128)
    public String getDiagnosisCardId() {
        return diagnosisCardId;
    }

    public void setDiagnosisCardId(String diagnosisCardId) {
        this.diagnosisCardId = diagnosisCardId;
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
    @Column(name = "diagnosisId", nullable = true, length = 128)
    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Basic
    @Column(name = "emrId", nullable = true, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "patientId", nullable = true)
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
    @Column(name = "diagnosis", nullable = true, length = 128)
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
    @Column(name = "diagnosisBasisId", nullable = true)
    public Integer getDiagnosisBasisId() {
        return diagnosisBasisId;
    }

    public void setDiagnosisBasisId(Integer diagnosisBasisId) {
        this.diagnosisBasisId = diagnosisBasisId;
    }

    @Basic
    @Column(name = "pathologyDiagnosis", nullable = true, length = 300)
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
    @Column(name = "organCode", nullable = true, length = 30)
    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    @Basic
    @Column(name = "bodyPartName", nullable = true, length = 100)
    public String getBodyPartName() {
        return bodyPartName;
    }

    public void setBodyPartName(String bodyPartName) {
        this.bodyPartName = bodyPartName;
    }

    @Basic
    @Column(name = "initialTreatmentDate", nullable = true)
    public Timestamp getInitialTreatmentDate() {
        return initialTreatmentDate;
    }

    public void setInitialTreatmentDate(Timestamp initialTreatmentDate) {
        this.initialTreatmentDate = initialTreatmentDate;
    }

    @Basic
    @Column(name = "treatmentHistoryId", nullable = true)
    public Integer getTreatmentHistoryId() {
        return treatmentHistoryId;
    }

    public void setTreatmentHistoryId(Integer treatmentHistoryId) {
        this.treatmentHistoryId = treatmentHistoryId;
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
    @Column(name = "outDeptType", nullable = true, length = 128)
    public String getOutDeptType() {
        return outDeptType;
    }

    public void setOutDeptType(String outDeptType) {
        this.outDeptType = outDeptType;
    }

    @Basic
    @Column(name = "treatmentMethod", nullable = true, length = 256)
    public String getTreatmentMethod() {
        return treatmentMethod;
    }

    public void setTreatmentMethod(String treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    @Basic
    @Column(name = "deathTime", nullable = true)
    public Timestamp getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Timestamp deathTime) {
        this.deathTime = deathTime;
    }

    @Basic
    @Column(name = "deathCause", nullable = true, length = 128)
    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EDiagnosisCard that = (EDiagnosisCard) o;

        if (diagnosisCardId != null ? !diagnosisCardId.equals(that.diagnosisCardId) : that.diagnosisCardId != null)
            return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (diagnosisId != null ? !diagnosisId.equals(that.diagnosisId) : that.diagnosisId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (diagnosisBasisId != null ? !diagnosisBasisId.equals(that.diagnosisBasisId) : that.diagnosisBasisId != null)
            return false;
        if (pathologyDiagnosis != null ? !pathologyDiagnosis.equals(that.pathologyDiagnosis) : that.pathologyDiagnosis != null)
            return false;
        if (pathologyDiagnosisCode != null ? !pathologyDiagnosisCode.equals(that.pathologyDiagnosisCode) : that.pathologyDiagnosisCode != null)
            return false;
        if (organCode != null ? !organCode.equals(that.organCode) : that.organCode != null) return false;
        if (bodyPartName != null ? !bodyPartName.equals(that.bodyPartName) : that.bodyPartName != null) return false;
        if (initialTreatmentDate != null ? !initialTreatmentDate.equals(that.initialTreatmentDate) : that.initialTreatmentDate != null)
            return false;
        if (treatmentHistoryId != null ? !treatmentHistoryId.equals(that.treatmentHistoryId) : that.treatmentHistoryId != null)
            return false;
        if (disagnosisPeriodizationId != null ? !disagnosisPeriodizationId.equals(that.disagnosisPeriodizationId) : that.disagnosisPeriodizationId != null)
            return false;
        if (outDeptType != null ? !outDeptType.equals(that.outDeptType) : that.outDeptType != null) return false;
        if (treatmentMethod != null ? !treatmentMethod.equals(that.treatmentMethod) : that.treatmentMethod != null)
            return false;
        if (deathTime != null ? !deathTime.equals(that.deathTime) : that.deathTime != null) return false;
        if (deathCause != null ? !deathCause.equals(that.deathCause) : that.deathCause != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisCardId != null ? diagnosisCardId.hashCode() : 0;
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (diagnosisId != null ? diagnosisId.hashCode() : 0);
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (diagnosisBasisId != null ? diagnosisBasisId.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis != null ? pathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode != null ? pathologyDiagnosisCode.hashCode() : 0);
        result = 31 * result + (organCode != null ? organCode.hashCode() : 0);
        result = 31 * result + (bodyPartName != null ? bodyPartName.hashCode() : 0);
        result = 31 * result + (initialTreatmentDate != null ? initialTreatmentDate.hashCode() : 0);
        result = 31 * result + (treatmentHistoryId != null ? treatmentHistoryId.hashCode() : 0);
        result = 31 * result + (disagnosisPeriodizationId != null ? disagnosisPeriodizationId.hashCode() : 0);
        result = 31 * result + (outDeptType != null ? outDeptType.hashCode() : 0);
        result = 31 * result + (treatmentMethod != null ? treatmentMethod.hashCode() : 0);
        result = 31 * result + (deathTime != null ? deathTime.hashCode() : 0);
        result = 31 * result + (deathCause != null ? deathCause.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
