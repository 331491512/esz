package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_review_appoint", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_review_appoint_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupReviewAppoint {
    private String appointId;
    private Long patientId;
    private Integer hospitalId;
    private String followupTaskId;
    private String followupAssignId;
    private Timestamp applyTime;
    private Integer appointDeptId;
    private String appointDeptName;
    private String appointDoctorId;
    private String appointDoctorName;
    private Timestamp appointDate;
    private Integer appointTimeRange;
    private String doctorReply;
    private String appointResult;
    private Integer operatorId;
    private String operatorName;
    private String remark;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sourceFlag;
    private String appointCheckItems;
    private String appointDetails;
    private String appointMobile;
    private Integer syncFlag;

    @Id
    @Column(name = "appointId", nullable = false, length = 32)
    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
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
    @Column(name = "hospitalId", nullable = true)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = true, length = 60)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "followupAssignId", nullable = true, length = 60)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
    }

    @Basic
    @Column(name = "applyTime", nullable = true)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "appointDeptId", nullable = true)
    public Integer getAppointDeptId() {
        return appointDeptId;
    }

    public void setAppointDeptId(Integer appointDeptId) {
        this.appointDeptId = appointDeptId;
    }

    @Basic
    @Column(name = "appointDeptName", nullable = true, length = 255)
    public String getAppointDeptName() {
        return appointDeptName;
    }

    public void setAppointDeptName(String appointDeptName) {
        this.appointDeptName = appointDeptName;
    }

    @Basic
    @Column(name = "appointDoctorId", nullable = true, length = 255)
    public String getAppointDoctorId() {
        return appointDoctorId;
    }

    public void setAppointDoctorId(String appointDoctorId) {
        this.appointDoctorId = appointDoctorId;
    }

    @Basic
    @Column(name = "appointDoctorName", nullable = true, length = 255)
    public String getAppointDoctorName() {
        return appointDoctorName;
    }

    public void setAppointDoctorName(String appointDoctorName) {
        this.appointDoctorName = appointDoctorName;
    }

    @Basic
    @Column(name = "appointDate", nullable = false)
    public Timestamp getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(Timestamp appointDate) {
        this.appointDate = appointDate;
    }

    @Basic
    @Column(name = "appointTimeRange", nullable = true)
    public Integer getAppointTimeRange() {
        return appointTimeRange;
    }

    public void setAppointTimeRange(Integer appointTimeRange) {
        this.appointTimeRange = appointTimeRange;
    }

    @Basic
    @Column(name = "doctorReply", nullable = true, length = 255)
    public String getDoctorReply() {
        return doctorReply;
    }

    public void setDoctorReply(String doctorReply) {
        this.doctorReply = doctorReply;
    }

    @Basic
    @Column(name = "appointResult", nullable = true, length = 255)
    public String getAppointResult() {
        return appointResult;
    }

    public void setAppointResult(String appointResult) {
        this.appointResult = appointResult;
    }

    @Basic
    @Column(name = "operatorId", nullable = true)
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operatorName", nullable = true, length = 255)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Basic
    @Column(name = "sourceFlag", nullable = true, length = 255)
    public String getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(String sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    @Basic
    @Column(name = "appointCheckItems", nullable = true, length = 255)
    public String getAppointCheckItems() {
        return appointCheckItems;
    }

    public void setAppointCheckItems(String appointCheckItems) {
        this.appointCheckItems = appointCheckItems;
    }

    @Basic
    @Column(name = "appointDetails", nullable = true, length = 255)
    public String getAppointDetails() {
        return appointDetails;
    }

    public void setAppointDetails(String appointDetails) {
        this.appointDetails = appointDetails;
    }

    @Basic
    @Column(name = "appointMobile", nullable = true, length = 20)
    public String getAppointMobile() {
        return appointMobile;
    }

    public void setAppointMobile(String appointMobile) {
        this.appointMobile = appointMobile;
    }

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowupReviewAppoint that = (FollowupReviewAppoint) o;

        if (appointId != null ? !appointId.equals(that.appointId) : that.appointId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (appointDeptId != null ? !appointDeptId.equals(that.appointDeptId) : that.appointDeptId != null)
            return false;
        if (appointDeptName != null ? !appointDeptName.equals(that.appointDeptName) : that.appointDeptName != null)
            return false;
        if (appointDoctorId != null ? !appointDoctorId.equals(that.appointDoctorId) : that.appointDoctorId != null)
            return false;
        if (appointDoctorName != null ? !appointDoctorName.equals(that.appointDoctorName) : that.appointDoctorName != null)
            return false;
        if (appointDate != null ? !appointDate.equals(that.appointDate) : that.appointDate != null) return false;
        if (appointTimeRange != null ? !appointTimeRange.equals(that.appointTimeRange) : that.appointTimeRange != null)
            return false;
        if (doctorReply != null ? !doctorReply.equals(that.doctorReply) : that.doctorReply != null) return false;
        if (appointResult != null ? !appointResult.equals(that.appointResult) : that.appointResult != null)
            return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (appointCheckItems != null ? !appointCheckItems.equals(that.appointCheckItems) : that.appointCheckItems != null)
            return false;
        if (appointDetails != null ? !appointDetails.equals(that.appointDetails) : that.appointDetails != null)
            return false;
        if (appointMobile != null ? !appointMobile.equals(that.appointMobile) : that.appointMobile != null)
            return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appointId != null ? appointId.hashCode() : 0;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (appointDeptId != null ? appointDeptId.hashCode() : 0);
        result = 31 * result + (appointDeptName != null ? appointDeptName.hashCode() : 0);
        result = 31 * result + (appointDoctorId != null ? appointDoctorId.hashCode() : 0);
        result = 31 * result + (appointDoctorName != null ? appointDoctorName.hashCode() : 0);
        result = 31 * result + (appointDate != null ? appointDate.hashCode() : 0);
        result = 31 * result + (appointTimeRange != null ? appointTimeRange.hashCode() : 0);
        result = 31 * result + (doctorReply != null ? doctorReply.hashCode() : 0);
        result = 31 * result + (appointResult != null ? appointResult.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (appointCheckItems != null ? appointCheckItems.hashCode() : 0);
        result = 31 * result + (appointDetails != null ? appointDetails.hashCode() : 0);
        result = 31 * result + (appointMobile != null ? appointMobile.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        return result;
    }
}
