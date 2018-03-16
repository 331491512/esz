package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_issued_record", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_issued_record_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EIssuedRecord {
    private String issuedId;
    private String diagnosisCardId;
    private Long patientId;
    private String patientNo;
    private Timestamp issuedDate;
    private String diseaseCode;
    private String diagnosis;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "issuedId", nullable = false, length = 128)
    public String getIssuedId() {
        return issuedId;
    }

    public void setIssuedId(String issuedId) {
        this.issuedId = issuedId;
    }

    @Basic
    @Column(name = "diagnosisCardId", nullable = true, length = 128)
    public String getDiagnosisCardId() {
        return diagnosisCardId;
    }

    public void setDiagnosisCardId(String diagnosisCardId) {
        this.diagnosisCardId = diagnosisCardId;
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
    @Column(name = "patientNo", nullable = false, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "issuedDate", nullable = true)
    public Timestamp getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Timestamp issuedDate) {
        this.issuedDate = issuedDate;
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
    @Column(name = "diagnosis", nullable = true, length = 300)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EIssuedRecord that = (EIssuedRecord) o;

        if (issuedId != null ? !issuedId.equals(that.issuedId) : that.issuedId != null) return false;
        if (diagnosisCardId != null ? !diagnosisCardId.equals(that.diagnosisCardId) : that.diagnosisCardId != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (issuedDate != null ? !issuedDate.equals(that.issuedDate) : that.issuedDate != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = issuedId != null ? issuedId.hashCode() : 0;
        result = 31 * result + (diagnosisCardId != null ? diagnosisCardId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (issuedDate != null ? issuedDate.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
