package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "var_patient_medical", schema = "ehr_db", catalog="")
//@Audited
//@AuditTable(value = "var_patient_medical_audit", schema = "ehr_db_audit", catalog = "ehr_db_audit")
public class VarPatientMedical {
    private Long id;
    private Long patientId;
    private Timestamp latestClinicDate;
    private Timestamp latestOutHospitalDate;
    private Timestamp latestInHospitalDate;
    private Timestamp latestMedicalRecordUploadTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    /**
     * 最近就诊时间：是指通过患者最近一次门诊时间和最近一次住院时间中，取距当前时间最近的时间为最近就诊时间
     */
    private Timestamp visitingTime;

    @Transient
    public Timestamp getVisitingTime() {
        Timestamp latestClinicDate = this.getLatestClinicDate();
        Timestamp latestInHospitalDate = this.getLatestInHospitalDate();
        if (latestInHospitalDate != null && latestClinicDate != null) {
            if (latestInHospitalDate.after(latestClinicDate)) {
                this.visitingTime = latestInHospitalDate;
            } else {
                this.visitingTime = latestClinicDate;
            }
        }
        if (latestInHospitalDate == null) {
            this.visitingTime = latestClinicDate;
        }
        if (latestClinicDate == null) {
            this.visitingTime = latestInHospitalDate;
        }
        return visitingTime;
    }

    /**
     * 最近就诊时间
     *
     * @param visitingTime
     */

    public void setVisitingTime(Timestamp visitingTime) {
        this.visitingTime = visitingTime;
    }

    public VarPatientMedical() {
        //Timestamp latestClinicDate = this.getLatestClinicDate();
        //Timestamp latestInHospitalDate = this.getLatestInHospitalDate();
        //if (latestInHospitalDate.after(latestClinicDate)) {
        //    this.visitingTime = latestInHospitalDate;
        //} else {
        //    this.visitingTime = latestClinicDate;
        //}
    }

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Column(name = "latestClinicDate", nullable = true)
    public Timestamp getLatestClinicDate() {
        return latestClinicDate;
    }

    public void setLatestClinicDate(Timestamp latestClinicDate) {
        this.latestClinicDate = latestClinicDate;
    }

    @Basic
    @Column(name = "latestOutHospitalDate", nullable = true)
    public Timestamp getLatestOutHospitalDate() {
        return latestOutHospitalDate;
    }

    public void setLatestOutHospitalDate(Timestamp latestOutHospitalDate) {
        this.latestOutHospitalDate = latestOutHospitalDate;
    }

    @Basic
    @Column(name = "latestInHospitalDate", nullable = true)
    public Timestamp getLatestInHospitalDate() {
        return latestInHospitalDate;
    }

    public void setLatestInHospitalDate(Timestamp latestInHospitalDate) {
        this.latestInHospitalDate = latestInHospitalDate;
    }

    @Basic
    @Column(name = "latestMedicalRecordUploadTime", nullable = true)
    public Timestamp getLatestMedicalRecordUploadTime() {
        return latestMedicalRecordUploadTime;
    }

    public void setLatestMedicalRecordUploadTime(Timestamp latestMedicalRecordUploadTime) {
        this.latestMedicalRecordUploadTime = latestMedicalRecordUploadTime;
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

        VarPatientMedical that = (VarPatientMedical) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (latestClinicDate != null ? !latestClinicDate.equals(that.latestClinicDate) : that.latestClinicDate != null)
            return false;
        if (latestOutHospitalDate != null ? !latestOutHospitalDate.equals(that.latestOutHospitalDate) : that.latestOutHospitalDate != null)
            return false;
        if (latestInHospitalDate != null ? !latestInHospitalDate.equals(that.latestInHospitalDate) : that.latestInHospitalDate != null)
            return false;
        if (latestMedicalRecordUploadTime != null ? !latestMedicalRecordUploadTime.equals(that.latestMedicalRecordUploadTime) : that.latestMedicalRecordUploadTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (latestClinicDate != null ? latestClinicDate.hashCode() : 0);
        result = 31 * result + (latestOutHospitalDate != null ? latestOutHospitalDate.hashCode() : 0);
        result = 31 * result + (latestInHospitalDate != null ? latestInHospitalDate.hashCode() : 0);
        result = 31 * result + (latestMedicalRecordUploadTime != null ? latestMedicalRecordUploadTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
