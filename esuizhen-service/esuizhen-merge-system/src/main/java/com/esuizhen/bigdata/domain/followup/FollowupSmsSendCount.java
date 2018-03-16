package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_sms_send_count", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_sms_send_count_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupSmsSendCount {
    private long id;
    private long patientId;
    private long patientFamilyId;
    private String mobile;
    private Integer sendFailCount;
    private Timestamp lastSendFailTime;
    private Integer sendSuccessCount;
    private Timestamp lastSendSuccessCount;
    private Integer currSendCount;
    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "patientFamilyId", nullable = false)
    public long getPatientFamilyId() {
        return patientFamilyId;
    }

    public void setPatientFamilyId(long patientFamilyId) {
        this.patientFamilyId = patientFamilyId;
    }

    @Basic
    @Column(name = "mobile", nullable = false, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "sendFailCount", nullable = true)
    public Integer getSendFailCount() {
        return sendFailCount;
    }

    public void setSendFailCount(Integer sendFailCount) {
        this.sendFailCount = sendFailCount;
    }

    @Basic
    @Column(name = "lastSendFailTime", nullable = true)
    public Timestamp getLastSendFailTime() {
        return lastSendFailTime;
    }

    public void setLastSendFailTime(Timestamp lastSendFailTime) {
        this.lastSendFailTime = lastSendFailTime;
    }

    @Basic
    @Column(name = "sendSuccessCount", nullable = true)
    public Integer getSendSuccessCount() {
        return sendSuccessCount;
    }

    public void setSendSuccessCount(Integer sendSuccessCount) {
        this.sendSuccessCount = sendSuccessCount;
    }

    @Basic
    @Column(name = "lastSendSuccessCount", nullable = true)
    public Timestamp getLastSendSuccessCount() {
        return lastSendSuccessCount;
    }

    public void setLastSendSuccessCount(Timestamp lastSendSuccessCount) {
        this.lastSendSuccessCount = lastSendSuccessCount;
    }

    @Basic
    @Column(name = "currSendCount", nullable = true)
    public Integer getCurrSendCount() {
        return currSendCount;
    }

    public void setCurrSendCount(Integer currSendCount) {
        this.currSendCount = currSendCount;
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

        FollowupSmsSendCount that = (FollowupSmsSendCount) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (patientFamilyId != that.patientFamilyId) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (sendFailCount != null ? !sendFailCount.equals(that.sendFailCount) : that.sendFailCount != null)
            return false;
        if (lastSendFailTime != null ? !lastSendFailTime.equals(that.lastSendFailTime) : that.lastSendFailTime != null)
            return false;
        if (sendSuccessCount != null ? !sendSuccessCount.equals(that.sendSuccessCount) : that.sendSuccessCount != null)
            return false;
        if (lastSendSuccessCount != null ? !lastSendSuccessCount.equals(that.lastSendSuccessCount) : that.lastSendSuccessCount != null)
            return false;
        if (currSendCount != null ? !currSendCount.equals(that.currSendCount) : that.currSendCount != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (int) (patientFamilyId ^ (patientFamilyId >>> 32));
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (sendFailCount != null ? sendFailCount.hashCode() : 0);
        result = 31 * result + (lastSendFailTime != null ? lastSendFailTime.hashCode() : 0);
        result = 31 * result + (sendSuccessCount != null ? sendSuccessCount.hashCode() : 0);
        result = 31 * result + (lastSendSuccessCount != null ? lastSendSuccessCount.hashCode() : 0);
        result = 31 * result + (currSendCount != null ? currSendCount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
