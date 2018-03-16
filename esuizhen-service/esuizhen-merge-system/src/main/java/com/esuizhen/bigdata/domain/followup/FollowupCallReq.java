package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_call_req", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_call_req_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupCallReq {
    private long reqId;
    private String followupTaskId;
    private String followupAssignId;
    private int hospitalId;
    private Long patientId;
    private String callId;
    private Timestamp followupDate;
    private String trueName;
    private String telphone;
    private int state;
    private int resultProcessState;
    private String followupResultBuffId;
    private String followupResultId;
    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "reqId", nullable = false)
    @GeneratedValue
    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
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
    @Column(name = "callId", nullable = true, length = 50)
    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    @Basic
    @Column(name = "followupDate", nullable = false)
    public Timestamp getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(Timestamp followupDate) {
        this.followupDate = followupDate;
    }

    @Basic
    @Column(name = "trueName", nullable = false, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "telphone", nullable = false, length = 100)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
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

        FollowupCallReq that = (FollowupCallReq) o;

        if (reqId != that.reqId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (state != that.state) return false;
        if (resultProcessState != that.resultProcessState) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (callId != null ? !callId.equals(that.callId) : that.callId != null) return false;
        if (followupDate != null ? !followupDate.equals(that.followupDate) : that.followupDate != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        if (telphone != null ? !telphone.equals(that.telphone) : that.telphone != null) return false;
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
        int result = (int) (reqId ^ (reqId >>> 32));
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + hospitalId;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (callId != null ? callId.hashCode() : 0);
        result = 31 * result + (followupDate != null ? followupDate.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + resultProcessState;
        result = 31 * result + (followupResultBuffId != null ? followupResultBuffId.hashCode() : 0);
        result = 31 * result + (followupResultId != null ? followupResultId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
