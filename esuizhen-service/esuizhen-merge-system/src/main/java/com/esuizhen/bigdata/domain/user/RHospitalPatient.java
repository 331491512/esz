package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "r_hospital_patient", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "r_hospital_patient_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class RHospitalPatient {
    private int id;
    private long patientId;
    private int hospitalId;
    private String patientNo;
    private int sourceFlag;
    private int syncFlag;
    private Timestamp lastestFollowupResultSyncTime;
    private Integer hospitalCertificateState;
    private Timestamp createTime;
//    private UPatient uPatientByPatientId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "hospitalId", nullable = false)
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "patientNo", nullable = false, length = 20)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
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
    @Column(name = "syncFlag", nullable = false)
    public int getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(int syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "lastestFollowupResultSyncTime", nullable = true)
    public Timestamp getLastestFollowupResultSyncTime() {
        return lastestFollowupResultSyncTime;
    }

    public void setLastestFollowupResultSyncTime(Timestamp lastestFollowupResultSyncTime) {
        this.lastestFollowupResultSyncTime = lastestFollowupResultSyncTime;
    }

    @Basic
    @Column(name = "hospitalCertificateState", nullable = true)
    public Integer getHospitalCertificateState() {
        return hospitalCertificateState;
    }

    public void setHospitalCertificateState(Integer hospitalCertificateState) {
        this.hospitalCertificateState = hospitalCertificateState;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RHospitalPatient that = (RHospitalPatient) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (sourceFlag != that.sourceFlag) return false;
        if (syncFlag != that.syncFlag) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (lastestFollowupResultSyncTime != null ? !lastestFollowupResultSyncTime.equals(that.lastestFollowupResultSyncTime) : that.lastestFollowupResultSyncTime != null)
            return false;
        if (hospitalCertificateState != null ? !hospitalCertificateState.equals(that.hospitalCertificateState) : that.hospitalCertificateState != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + hospitalId;
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + sourceFlag;
        result = 31 * result + syncFlag;
        result = 31 * result + (lastestFollowupResultSyncTime != null ? lastestFollowupResultSyncTime.hashCode() : 0);
        result = 31 * result + (hospitalCertificateState != null ? hospitalCertificateState.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
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
}
