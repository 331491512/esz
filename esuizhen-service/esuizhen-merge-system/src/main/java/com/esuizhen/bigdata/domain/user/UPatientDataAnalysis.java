package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_patient_data_analysis", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_patient_data_analysis_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UPatientDataAnalysis {
    private long id;
    private long patientId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer trueNameDataFlag;
    private Integer diseaseCodeDataFlag;
    private Integer identificationDataFlag;
    private Integer contactDataFlag;
    private Integer patientNoDataFlag;
    private Integer diagnosisDataFlag;
    private Integer diseaseTypeDataFlag;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
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
    @Column(name = "trueNameDataFlag", nullable = true)
    public Integer getTrueNameDataFlag() {
        return trueNameDataFlag;
    }

    public void setTrueNameDataFlag(Integer trueNameDataFlag) {
        this.trueNameDataFlag = trueNameDataFlag;
    }

    @Basic
    @Column(name = "diseaseCodeDataFlag", nullable = true)
    public Integer getDiseaseCodeDataFlag() {
        return diseaseCodeDataFlag;
    }

    public void setDiseaseCodeDataFlag(Integer diseaseCodeDataFlag) {
        this.diseaseCodeDataFlag = diseaseCodeDataFlag;
    }

    @Basic
    @Column(name = "IdentificationDataFlag", nullable = true)
    public Integer getIdentificationDataFlag() {
        return identificationDataFlag;
    }

    public void setIdentificationDataFlag(Integer identificationDataFlag) {
        this.identificationDataFlag = identificationDataFlag;
    }

    @Basic
    @Column(name = "contactDataFlag", nullable = true)
    public Integer getContactDataFlag() {
        return contactDataFlag;
    }

    public void setContactDataFlag(Integer contactDataFlag) {
        this.contactDataFlag = contactDataFlag;
    }

    @Basic
    @Column(name = "patientNoDataFlag", nullable = true)
    public Integer getPatientNoDataFlag() {
        return patientNoDataFlag;
    }

    public void setPatientNoDataFlag(Integer patientNoDataFlag) {
        this.patientNoDataFlag = patientNoDataFlag;
    }

    @Basic
    @Column(name = "diagnosisDataFlag", nullable = true)
    public Integer getDiagnosisDataFlag() {
        return diagnosisDataFlag;
    }

    public void setDiagnosisDataFlag(Integer diagnosisDataFlag) {
        this.diagnosisDataFlag = diagnosisDataFlag;
    }

    @Basic
    @Column(name = "diseaseTypeDataFlag", nullable = true)
    public Integer getDiseaseTypeDataFlag() {
        return diseaseTypeDataFlag;
    }

    public void setDiseaseTypeDataFlag(Integer diseaseTypeDataFlag) {
        this.diseaseTypeDataFlag = diseaseTypeDataFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPatientDataAnalysis that = (UPatientDataAnalysis) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (trueNameDataFlag != null ? !trueNameDataFlag.equals(that.trueNameDataFlag) : that.trueNameDataFlag != null)
            return false;
        if (diseaseCodeDataFlag != null ? !diseaseCodeDataFlag.equals(that.diseaseCodeDataFlag) : that.diseaseCodeDataFlag != null)
            return false;
        if (identificationDataFlag != null ? !identificationDataFlag.equals(that.identificationDataFlag) : that.identificationDataFlag != null)
            return false;
        if (contactDataFlag != null ? !contactDataFlag.equals(that.contactDataFlag) : that.contactDataFlag != null)
            return false;
        if (patientNoDataFlag != null ? !patientNoDataFlag.equals(that.patientNoDataFlag) : that.patientNoDataFlag != null)
            return false;
        if (diagnosisDataFlag != null ? !diagnosisDataFlag.equals(that.diagnosisDataFlag) : that.diagnosisDataFlag != null)
            return false;
        if (diseaseTypeDataFlag != null ? !diseaseTypeDataFlag.equals(that.diseaseTypeDataFlag) : that.diseaseTypeDataFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (trueNameDataFlag != null ? trueNameDataFlag.hashCode() : 0);
        result = 31 * result + (diseaseCodeDataFlag != null ? diseaseCodeDataFlag.hashCode() : 0);
        result = 31 * result + (identificationDataFlag != null ? identificationDataFlag.hashCode() : 0);
        result = 31 * result + (contactDataFlag != null ? contactDataFlag.hashCode() : 0);
        result = 31 * result + (patientNoDataFlag != null ? patientNoDataFlag.hashCode() : 0);
        result = 31 * result + (diagnosisDataFlag != null ? diagnosisDataFlag.hashCode() : 0);
        result = 31 * result + (diseaseTypeDataFlag != null ? diseaseTypeDataFlag.hashCode() : 0);
        return result;
    }
}
