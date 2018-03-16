package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "r_doctor_patient", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "r_doctor_patient_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class RDoctorPatient {
    private long id;
    private long patientId;
    private long doctorId;
    private Integer hasMedicalRecord;
    private Integer vipFlag;
    private Integer firstVisitFlag;
    private Timestamp attentionTime;
    private Timestamp createTime;
    private int sourceFlag;
    private Integer syncFlag;
    private Integer sourceDiagnosisFlag;
//    private UPatient uPatientByPatientId;
//    private UDoctor uDoctorByDoctorId;

    private Long mergeFrom;
    private Long mergeTarget;
    private Integer mergeFlag;
    private Integer patientType;
    private Timestamp mergeTime;


    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Basic
    @Column(name = "patientType", nullable = true)
    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

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
    @Column(name = "doctorId", nullable = false)
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "hasMedicalRecord", nullable = true)
    public Integer getHasMedicalRecord() {
        return hasMedicalRecord;
    }

    public void setHasMedicalRecord(Integer hasMedicalRecord) {
        this.hasMedicalRecord = hasMedicalRecord;
    }

    @Basic
    @Column(name = "vipFlag", nullable = true)
    public Integer getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(Integer vipFlag) {
        this.vipFlag = vipFlag;
    }

    @Basic
    @Column(name = "firstVisitFlag", nullable = true)
    public Integer getFirstVisitFlag() {
        return firstVisitFlag;
    }

    public void setFirstVisitFlag(Integer firstVisitFlag) {
        this.firstVisitFlag = firstVisitFlag;
    }

    @Basic
    @Column(name = "attentionTime", nullable = true)
    public Timestamp getAttentionTime() {
        return attentionTime;
    }

    public void setAttentionTime(Timestamp attentionTime) {
        this.attentionTime = attentionTime;
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
    @Column(name = "sourceFlag", nullable = false)
    public int getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(int sourceFlag) {
        this.sourceFlag = sourceFlag;
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
    @Column(name = "sourceDiagnosisFlag", nullable = true)
    public Integer getSourceDiagnosisFlag() {
        return sourceDiagnosisFlag;
    }

    public void setSourceDiagnosisFlag(Integer sourceDiagnosisFlag) {
        this.sourceDiagnosisFlag = sourceDiagnosisFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RDoctorPatient that = (RDoctorPatient) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (doctorId != that.doctorId) return false;
        if (sourceFlag != that.sourceFlag) return false;
        if (hasMedicalRecord != null ? !hasMedicalRecord.equals(that.hasMedicalRecord) : that.hasMedicalRecord != null)
            return false;
        if (vipFlag != null ? !vipFlag.equals(that.vipFlag) : that.vipFlag != null) return false;
        if (firstVisitFlag != null ? !firstVisitFlag.equals(that.firstVisitFlag) : that.firstVisitFlag != null)
            return false;
        if (attentionTime != null ? !attentionTime.equals(that.attentionTime) : that.attentionTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (sourceDiagnosisFlag != null ? !sourceDiagnosisFlag.equals(that.sourceDiagnosisFlag) : that.sourceDiagnosisFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (int) (doctorId ^ (doctorId >>> 32));
        result = 31 * result + (hasMedicalRecord != null ? hasMedicalRecord.hashCode() : 0);
        result = 31 * result + (vipFlag != null ? vipFlag.hashCode() : 0);
        result = 31 * result + (firstVisitFlag != null ? firstVisitFlag.hashCode() : 0);
        result = 31 * result + (attentionTime != null ? attentionTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + sourceFlag;
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (sourceDiagnosisFlag != null ? sourceDiagnosisFlag.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "patientId", referencedColumnName = "patientId", nullable = false, insertable = false, updatable = false)
//    public UPatient getuPatientByPatientId() {
//        return uPatientByPatientId;
//    }
//
//    public void setuPatientByPatientId(UPatient uPatientByPatientId) {
//        this.uPatientByPatientId = uPatientByPatientId;
//    }

//    @ManyToOne
//    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId", nullable = false, insertable = false, updatable = false)
//    public UDoctor getuDoctorByDoctorId() {
//        return uDoctorByDoctorId;
//    }
//
//    public void setuDoctorByDoctorId(UDoctor uDoctorByDoctorId) {
//        this.uDoctorByDoctorId = uDoctorByDoctorId;
//    }
}
