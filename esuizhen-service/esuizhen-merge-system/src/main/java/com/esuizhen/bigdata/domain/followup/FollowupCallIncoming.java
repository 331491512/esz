package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_call_incoming", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_call_incoming_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupCallIncoming {
    private int incomingCallId;
    private String followupTaskId;
    private String followupAssignId;
    private int hospitalId;
    private Long patientId;
    private Timestamp callTime;
    private String trueName;
    private String telphone;
    private String telLocale;
    private String localPhone;
    private String patientNo;
    private int state;
    private int resultProcessState;
    private String followupResultBuffId;
    private String followupResultId;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "incomingCallId", nullable = false)
    public int getIncomingCallId() {
        return incomingCallId;
    }

    public void setIncomingCallId(int incomingCallId) {
        this.incomingCallId = incomingCallId;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = true, length = 128)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "followupAssignId", nullable = true, length = 128)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
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
    @Column(name = "patientId", nullable = true)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "callTime", nullable = false)
    public Timestamp getCallTime() {
        return callTime;
    }

    public void setCallTime(Timestamp callTime) {
        this.callTime = callTime;
    }

    @Basic
    @Column(name = "trueName", nullable = true, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "telphone", nullable = false, length = 20)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "telLocale", nullable = true, length = 30)
    public String getTelLocale() {
        return telLocale;
    }

    public void setTelLocale(String telLocale) {
        this.telLocale = telLocale;
    }

    @Basic
    @Column(name = "localPhone", nullable = true, length = 30)
    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone;
    }

    @Basic
    @Column(name = "patientNo", nullable = true, length = 30)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "resultProcessState", nullable = false)
    public int getResultProcessState() {
        return resultProcessState;
    }

    public void setResultProcessState(int resultProcessState) {
        this.resultProcessState = resultProcessState;
    }

    @Basic
    @Column(name = "followupResultBuffId", nullable = true, length = 128)
    public String getFollowupResultBuffId() {
        return followupResultBuffId;
    }

    public void setFollowupResultBuffId(String followupResultBuffId) {
        this.followupResultBuffId = followupResultBuffId;
    }

    @Basic
    @Column(name = "followupResultId", nullable = true, length = 128)
    public String getFollowupResultId() {
        return followupResultId;
    }

    public void setFollowupResultId(String followupResultId) {
        this.followupResultId = followupResultId;
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

        FollowupCallIncoming that = (FollowupCallIncoming) o;

        if (incomingCallId != that.incomingCallId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (state != that.state) return false;
        if (resultProcessState != that.resultProcessState) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (callTime != null ? !callTime.equals(that.callTime) : that.callTime != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        if (telphone != null ? !telphone.equals(that.telphone) : that.telphone != null) return false;
        if (telLocale != null ? !telLocale.equals(that.telLocale) : that.telLocale != null) return false;
        if (localPhone != null ? !localPhone.equals(that.localPhone) : that.localPhone != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (followupResultBuffId != null ? !followupResultBuffId.equals(that.followupResultBuffId) : that.followupResultBuffId != null)
            return false;
        if (followupResultId != null ? !followupResultId.equals(that.followupResultId) : that.followupResultId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = incomingCallId;
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + hospitalId;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (callTime != null ? callTime.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (telLocale != null ? telLocale.hashCode() : 0);
        result = 31 * result + (localPhone != null ? localPhone.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + resultProcessState;
        result = 31 * result + (followupResultBuffId != null ? followupResultBuffId.hashCode() : 0);
        result = 31 * result + (followupResultId != null ? followupResultId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
