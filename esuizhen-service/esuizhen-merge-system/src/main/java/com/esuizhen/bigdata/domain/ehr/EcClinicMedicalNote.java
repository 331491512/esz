package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "ec_clinic_medical_note", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "ec_clinic_medical_note_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EcClinicMedicalNote {
    private String clinicMedicalId;
    private String emrId;
    private Integer tempId;
    private String clinicNo;
    private Long patientId;
    private String patientNo;
    private Integer hospitalId;
    private Integer symptomSummary;
    private String diagnosis;
    private String diseaseCode;
    private String remark;
    private Long clinicDoctor;
    private Integer visitTimes;
    private Timestamp visitTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer syncFlag;
    private Timestamp rawCreateTime;
    private Integer handleFlag;

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
    @Column(name = "clinicMedicalId", nullable = false, length = 128)
    public String getClinicMedicalId() {
        return clinicMedicalId;
    }

    public void setClinicMedicalId(String clinicMedicalId) {
        this.clinicMedicalId = clinicMedicalId;
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
    @Column(name = "tempId", nullable = true)
    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Basic
    @Column(name = "clinicNo", nullable = false, length = 128)
    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo;
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
    @Column(name = "hospitalId", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "symptomSummary", nullable = true)
    public Integer getSymptomSummary() {
        return symptomSummary;
    }

    public void setSymptomSummary(Integer symptomSummary) {
        this.symptomSummary = symptomSummary;
    }

    @Basic
    @Column(name = "diagnosis", nullable = true, length = 300)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "diseaseCode", nullable = true, length = 100)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 1000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "clinicDoctor", nullable = true)
    public Long getClinicDoctor() {
        return clinicDoctor;
    }

    public void setClinicDoctor(Long clinicDoctor) {
        this.clinicDoctor = clinicDoctor;
    }

    @Basic
    @Column(name = "visitTimes", nullable = true)
    public Integer getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(Integer visitTimes) {
        this.visitTimes = visitTimes;
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
    @Column(name = "createTime", nullable = false)
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

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
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
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcClinicMedicalNote that = (EcClinicMedicalNote) o;

        if (clinicMedicalId != null ? !clinicMedicalId.equals(that.clinicMedicalId) : that.clinicMedicalId != null)
            return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (clinicNo != null ? !clinicNo.equals(that.clinicNo) : that.clinicNo != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (symptomSummary != null ? !symptomSummary.equals(that.symptomSummary) : that.symptomSummary != null)
            return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (clinicDoctor != null ? !clinicDoctor.equals(that.clinicDoctor) : that.clinicDoctor != null) return false;
        if (visitTimes != null ? !visitTimes.equals(that.visitTimes) : that.visitTimes != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clinicMedicalId != null ? clinicMedicalId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (clinicNo != null ? clinicNo.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (symptomSummary != null ? symptomSummary.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (clinicDoctor != null ? clinicDoctor.hashCode() : 0);
        result = 31 * result + (visitTimes != null ? visitTimes.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        return result;
    }
}
