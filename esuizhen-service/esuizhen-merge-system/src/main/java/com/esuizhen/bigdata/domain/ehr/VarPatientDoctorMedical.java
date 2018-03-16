package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "var_patient_doctor_medical", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "var_patient_doctor_medical_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class VarPatientDoctorMedical {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Integer medicalRecordCount;
    private Timestamp latestMedicalRecordUploadTime;
    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "doctorId", nullable = false)
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "medicalRecordCount", nullable = false)
    public Integer getMedicalRecordCount() {
        return medicalRecordCount;
    }

    public void setMedicalRecordCount(Integer medicalRecordCount) {
        this.medicalRecordCount = medicalRecordCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VarPatientDoctorMedical that = (VarPatientDoctorMedical) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (doctorId != null ? !doctorId.equals(that.doctorId) : that.doctorId != null) return false;
        if (medicalRecordCount != null ? !medicalRecordCount.equals(that.medicalRecordCount) : that.medicalRecordCount != null)
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
        result = 31 * result + (doctorId != null ? doctorId.hashCode() : 0);
        result = 31 * result + (medicalRecordCount != null ? medicalRecordCount.hashCode() : 0);
        result = 31 * result + (latestMedicalRecordUploadTime != null ? latestMedicalRecordUploadTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
