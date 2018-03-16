package com.esuizhen.bigdata.domain.mergebak.followup;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/29.
 */
@Entity
@Table(name = "r_followup_task_patient_merge_bak", schema = "followup_db", catalog="")
public class RFollowupTaskPatientMergeBak {
    private long id;
    private String followupAssignId;
    private String followupTaskId;
    private long patientId;
    private int state;
    private Integer smsState;
    private Integer wxState;
    private Long smsReqId;
    private Long wxReqId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    //@Basic
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "followupAssignId", nullable = false, length = 255)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = false, length = 255)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
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
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "smsState", nullable = true)
    public Integer getSmsState() {
        return smsState;
    }

    public void setSmsState(Integer smsState) {
        this.smsState = smsState;
    }

    @Basic
    @Column(name = "wxState", nullable = true)
    public Integer getWxState() {
        return wxState;
    }

    public void setWxState(Integer wxState) {
        this.wxState = wxState;
    }

    @Basic
    @Column(name = "smsReqId", nullable = true)
    public Long getSmsReqId() {
        return smsReqId;
    }

    public void setSmsReqId(Long smsReqId) {
        this.smsReqId = smsReqId;
    }

    @Basic
    @Column(name = "wxReqId", nullable = true)
    public Long getWxReqId() {
        return wxReqId;
    }

    public void setWxReqId(Long wxReqId) {
        this.wxReqId = wxReqId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RFollowupTaskPatientMergeBak that = (RFollowupTaskPatientMergeBak) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (state != that.state) return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (smsState != null ? !smsState.equals(that.smsState) : that.smsState != null) return false;
        if (wxState != null ? !wxState.equals(that.wxState) : that.wxState != null) return false;
        if (smsReqId != null ? !smsReqId.equals(that.smsReqId) : that.smsReqId != null) return false;
        if (wxReqId != null ? !wxReqId.equals(that.wxReqId) : that.wxReqId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (mergeFlag != null ? !mergeFlag.equals(that.mergeFlag) : that.mergeFlag != null) return false;
        if (mergeFrom != null ? !mergeFrom.equals(that.mergeFrom) : that.mergeFrom != null) return false;
        if (mergeTarget != null ? !mergeTarget.equals(that.mergeTarget) : that.mergeTarget != null) return false;
        if (mergeTime != null ? !mergeTime.equals(that.mergeTime) : that.mergeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + state;
        result = 31 * result + (smsState != null ? smsState.hashCode() : 0);
        result = 31 * result + (wxState != null ? wxState.hashCode() : 0);
        result = 31 * result + (smsReqId != null ? smsReqId.hashCode() : 0);
        result = 31 * result + (wxReqId != null ? wxReqId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (mergeFlag != null ? mergeFlag.hashCode() : 0);
        result = 31 * result + (mergeFrom != null ? mergeFrom.hashCode() : 0);
        result = 31 * result + (mergeTarget != null ? mergeTarget.hashCode() : 0);
        result = 31 * result + (mergeTime != null ? mergeTime.hashCode() : 0);
        return result;
    }
}
