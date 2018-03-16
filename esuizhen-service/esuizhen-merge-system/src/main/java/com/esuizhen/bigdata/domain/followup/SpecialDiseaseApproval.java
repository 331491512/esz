package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "special_disease_approval", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "special_disease_approval_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class SpecialDiseaseApproval {
    private long approvalId;
    private long patientId;
    private Long hospitalId;
    private Integer diagnosisDescId;
    private Integer adviceId;
    private String specialFollowupRecord;
    private String specializedFollowupRecord;
    private String specialistName;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "approvalId", nullable = false)
    public long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(long approvalId) {
        this.approvalId = approvalId;
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
    @Column(name = "hospitalId", nullable = true)
    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "diagnosisDescId", nullable = true)
    public Integer getDiagnosisDescId() {
        return diagnosisDescId;
    }

    public void setDiagnosisDescId(Integer diagnosisDescId) {
        this.diagnosisDescId = diagnosisDescId;
    }

    @Basic
    @Column(name = "adviceId", nullable = true)
    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    @Basic
    @Column(name = "specialFollowupRecord", nullable = true, length = 500)
    public String getSpecialFollowupRecord() {
        return specialFollowupRecord;
    }

    public void setSpecialFollowupRecord(String specialFollowupRecord) {
        this.specialFollowupRecord = specialFollowupRecord;
    }

    @Basic
    @Column(name = "specializedFollowupRecord", nullable = true, length = 500)
    public String getSpecializedFollowupRecord() {
        return specializedFollowupRecord;
    }

    public void setSpecializedFollowupRecord(String specializedFollowupRecord) {
        this.specializedFollowupRecord = specializedFollowupRecord;
    }

    @Basic
    @Column(name = "specialistName", nullable = true, length = 30)
    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

        SpecialDiseaseApproval that = (SpecialDiseaseApproval) o;

        if (approvalId != that.approvalId) return false;
        if (patientId != that.patientId) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (diagnosisDescId != null ? !diagnosisDescId.equals(that.diagnosisDescId) : that.diagnosisDescId != null)
            return false;
        if (adviceId != null ? !adviceId.equals(that.adviceId) : that.adviceId != null) return false;
        if (specialFollowupRecord != null ? !specialFollowupRecord.equals(that.specialFollowupRecord) : that.specialFollowupRecord != null)
            return false;
        if (specializedFollowupRecord != null ? !specializedFollowupRecord.equals(that.specializedFollowupRecord) : that.specializedFollowupRecord != null)
            return false;
        if (specialistName != null ? !specialistName.equals(that.specialistName) : that.specialistName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (approvalId ^ (approvalId >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (diagnosisDescId != null ? diagnosisDescId.hashCode() : 0);
        result = 31 * result + (adviceId != null ? adviceId.hashCode() : 0);
        result = 31 * result + (specialFollowupRecord != null ? specialFollowupRecord.hashCode() : 0);
        result = 31 * result + (specializedFollowupRecord != null ? specializedFollowupRecord.hashCode() : 0);
        result = 31 * result + (specialistName != null ? specialistName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
