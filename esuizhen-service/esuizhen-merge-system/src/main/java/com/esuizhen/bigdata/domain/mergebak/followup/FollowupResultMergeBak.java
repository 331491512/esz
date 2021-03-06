package com.esuizhen.bigdata.domain.mergebak.followup;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/29.
 */
@Entity
@Table(name = "followup_result_merge_bak", schema = "followup_db", catalog="")
public class FollowupResultMergeBak {
    private String followupResultId;
    private Integer tempId;
    private String followupTaskId;
    private String followupAssignId;
    private long patientId;
    private Integer hospitalId;
    private long operator;
    private int followupResultValue;
    private String relapseParts;
    private Date relapseDate;
    private String transferParts;
    private Date transferDate;
    private Date deathDate;
    private Integer isInHospitalDeath;
    private Integer isTumourDeath;
    private String deathCause;
    private String otherCause;
    private int followupWay;
    private Integer contentTemplateId;
    private String followupResultPhone;
    private Timestamp followupTime;
    private Integer lostFollowupFlag;
    private Integer lostFollowupCauseResultValue;
    private Integer oldLostFollowupFlag;
    private Integer oldLostFollowupCauseResultValue;
    private String phoneRecordUrl;
    private String remark;
    private int state;
    private Integer syncFlag;
    private Integer sourceFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer seq;
    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    //@Basic
    @Id
    @Column(name = "followupResultId", nullable = false, length = 60)
    public String getFollowupResultId() {
        return followupResultId;
    }

    public void setFollowupResultId(String followupResultId) {
        this.followupResultId = followupResultId;
    }

    @Basic
    @Column(name = "tempId", nullable = true)
    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
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
    @Column(name = "followupAssignId", nullable = true, length = 128)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
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
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "operator", nullable = false)
    public long getOperator() {
        return operator;
    }

    public void setOperator(long operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "followupResultValue", nullable = false)
    public int getFollowupResultValue() {
        return followupResultValue;
    }

    public void setFollowupResultValue(int followupResultValue) {
        this.followupResultValue = followupResultValue;
    }

    @Basic
    @Column(name = "relapseParts", nullable = true, length = 50)
    public String getRelapseParts() {
        return relapseParts;
    }

    public void setRelapseParts(String relapseParts) {
        this.relapseParts = relapseParts;
    }

    @Basic
    @Column(name = "relapseDate", nullable = true)
    public Date getRelapseDate() {
        return relapseDate;
    }

    public void setRelapseDate(Date relapseDate) {
        this.relapseDate = relapseDate;
    }

    @Basic
    @Column(name = "transferParts", nullable = true, length = 50)
    public String getTransferParts() {
        return transferParts;
    }

    public void setTransferParts(String transferParts) {
        this.transferParts = transferParts;
    }

    @Basic
    @Column(name = "transferDate", nullable = true)
    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    @Basic
    @Column(name = "deathDate", nullable = true)
    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    @Basic
    @Column(name = "isInHospitalDeath", nullable = true)
    public Integer getIsInHospitalDeath() {
        return isInHospitalDeath;
    }

    public void setIsInHospitalDeath(Integer isInHospitalDeath) {
        this.isInHospitalDeath = isInHospitalDeath;
    }

    @Basic
    @Column(name = "isTumourDeath", nullable = true)
    public Integer getIsTumourDeath() {
        return isTumourDeath;
    }

    public void setIsTumourDeath(Integer isTumourDeath) {
        this.isTumourDeath = isTumourDeath;
    }

    @Basic
    @Column(name = "deathCause", nullable = true, length = 100)
    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
    }

    @Basic
    @Column(name = "otherCause", nullable = true, length = 100)
    public String getOtherCause() {
        return otherCause;
    }

    public void setOtherCause(String otherCause) {
        this.otherCause = otherCause;
    }

    @Basic
    @Column(name = "followupWay", nullable = false)
    public int getFollowupWay() {
        return followupWay;
    }

    public void setFollowupWay(int followupWay) {
        this.followupWay = followupWay;
    }

    @Basic
    @Column(name = "contentTemplateId", nullable = true)
    public Integer getContentTemplateId() {
        return contentTemplateId;
    }

    public void setContentTemplateId(Integer contentTemplateId) {
        this.contentTemplateId = contentTemplateId;
    }

    @Basic
    @Column(name = "followupResultPhone", nullable = true, length = 15)
    public String getFollowupResultPhone() {
        return followupResultPhone;
    }

    public void setFollowupResultPhone(String followupResultPhone) {
        this.followupResultPhone = followupResultPhone;
    }

    @Basic
    @Column(name = "followupTime", nullable = false)
    public Timestamp getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(Timestamp followupTime) {
        this.followupTime = followupTime;
    }

    @Basic
    @Column(name = "lostFollowupFlag", nullable = true)
    public Integer getLostFollowupFlag() {
        return lostFollowupFlag;
    }

    public void setLostFollowupFlag(Integer lostFollowupFlag) {
        this.lostFollowupFlag = lostFollowupFlag;
    }

    @Basic
    @Column(name = "lostFollowupCauseResultValue", nullable = true)
    public Integer getLostFollowupCauseResultValue() {
        return lostFollowupCauseResultValue;
    }

    public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
        this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
    }

    @Basic
    @Column(name = "oldLostFollowupFlag", nullable = true)
    public Integer getOldLostFollowupFlag() {
        return oldLostFollowupFlag;
    }

    public void setOldLostFollowupFlag(Integer oldLostFollowupFlag) {
        this.oldLostFollowupFlag = oldLostFollowupFlag;
    }

    @Basic
    @Column(name = "oldLostFollowupCauseResultValue", nullable = true)
    public Integer getOldLostFollowupCauseResultValue() {
        return oldLostFollowupCauseResultValue;
    }

    public void setOldLostFollowupCauseResultValue(Integer oldLostFollowupCauseResultValue) {
        this.oldLostFollowupCauseResultValue = oldLostFollowupCauseResultValue;
    }

    @Basic
    @Column(name = "phoneRecordUrl", nullable = true, length = 255)
    public String getPhoneRecordUrl() {
        return phoneRecordUrl;
    }

    public void setPhoneRecordUrl(String phoneRecordUrl) {
        this.phoneRecordUrl = phoneRecordUrl;
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
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
    @Column(name = "sourceFlag", nullable = true)
    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
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

    @Basic
    @Column(name = "seq", nullable = true)
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

        FollowupResultMergeBak that = (FollowupResultMergeBak) o;

        if (patientId != that.patientId) return false;
        if (operator != that.operator) return false;
        if (followupResultValue != that.followupResultValue) return false;
        if (followupWay != that.followupWay) return false;
        if (state != that.state) return false;
        if (followupResultId != null ? !followupResultId.equals(that.followupResultId) : that.followupResultId != null)
            return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (relapseParts != null ? !relapseParts.equals(that.relapseParts) : that.relapseParts != null) return false;
        if (relapseDate != null ? !relapseDate.equals(that.relapseDate) : that.relapseDate != null) return false;
        if (transferParts != null ? !transferParts.equals(that.transferParts) : that.transferParts != null)
            return false;
        if (transferDate != null ? !transferDate.equals(that.transferDate) : that.transferDate != null) return false;
        if (deathDate != null ? !deathDate.equals(that.deathDate) : that.deathDate != null) return false;
        if (isInHospitalDeath != null ? !isInHospitalDeath.equals(that.isInHospitalDeath) : that.isInHospitalDeath != null)
            return false;
        if (isTumourDeath != null ? !isTumourDeath.equals(that.isTumourDeath) : that.isTumourDeath != null)
            return false;
        if (deathCause != null ? !deathCause.equals(that.deathCause) : that.deathCause != null) return false;
        if (otherCause != null ? !otherCause.equals(that.otherCause) : that.otherCause != null) return false;
        if (contentTemplateId != null ? !contentTemplateId.equals(that.contentTemplateId) : that.contentTemplateId != null)
            return false;
        if (followupResultPhone != null ? !followupResultPhone.equals(that.followupResultPhone) : that.followupResultPhone != null)
            return false;
        if (followupTime != null ? !followupTime.equals(that.followupTime) : that.followupTime != null) return false;
        if (lostFollowupFlag != null ? !lostFollowupFlag.equals(that.lostFollowupFlag) : that.lostFollowupFlag != null)
            return false;
        if (lostFollowupCauseResultValue != null ? !lostFollowupCauseResultValue.equals(that.lostFollowupCauseResultValue) : that.lostFollowupCauseResultValue != null)
            return false;
        if (oldLostFollowupFlag != null ? !oldLostFollowupFlag.equals(that.oldLostFollowupFlag) : that.oldLostFollowupFlag != null)
            return false;
        if (oldLostFollowupCauseResultValue != null ? !oldLostFollowupCauseResultValue.equals(that.oldLostFollowupCauseResultValue) : that.oldLostFollowupCauseResultValue != null)
            return false;
        if (phoneRecordUrl != null ? !phoneRecordUrl.equals(that.phoneRecordUrl) : that.phoneRecordUrl != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;
        if (mergeFlag != null ? !mergeFlag.equals(that.mergeFlag) : that.mergeFlag != null) return false;
        if (mergeFrom != null ? !mergeFrom.equals(that.mergeFrom) : that.mergeFrom != null) return false;
        if (mergeTarget != null ? !mergeTarget.equals(that.mergeTarget) : that.mergeTarget != null) return false;
        if (mergeTime != null ? !mergeTime.equals(that.mergeTime) : that.mergeTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupResultId != null ? followupResultId.hashCode() : 0;
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (int) (operator ^ (operator >>> 32));
        result = 31 * result + followupResultValue;
        result = 31 * result + (relapseParts != null ? relapseParts.hashCode() : 0);
        result = 31 * result + (relapseDate != null ? relapseDate.hashCode() : 0);
        result = 31 * result + (transferParts != null ? transferParts.hashCode() : 0);
        result = 31 * result + (transferDate != null ? transferDate.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (isInHospitalDeath != null ? isInHospitalDeath.hashCode() : 0);
        result = 31 * result + (isTumourDeath != null ? isTumourDeath.hashCode() : 0);
        result = 31 * result + (deathCause != null ? deathCause.hashCode() : 0);
        result = 31 * result + (otherCause != null ? otherCause.hashCode() : 0);
        result = 31 * result + followupWay;
        result = 31 * result + (contentTemplateId != null ? contentTemplateId.hashCode() : 0);
        result = 31 * result + (followupResultPhone != null ? followupResultPhone.hashCode() : 0);
        result = 31 * result + (followupTime != null ? followupTime.hashCode() : 0);
        result = 31 * result + (lostFollowupFlag != null ? lostFollowupFlag.hashCode() : 0);
        result = 31 * result + (lostFollowupCauseResultValue != null ? lostFollowupCauseResultValue.hashCode() : 0);
        result = 31 * result + (oldLostFollowupFlag != null ? oldLostFollowupFlag.hashCode() : 0);
        result = 31 * result + (oldLostFollowupCauseResultValue != null ? oldLostFollowupCauseResultValue.hashCode() : 0);
        result = 31 * result + (phoneRecordUrl != null ? phoneRecordUrl.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (mergeFlag != null ? mergeFlag.hashCode() : 0);
        result = 31 * result + (mergeFrom != null ? mergeFrom.hashCode() : 0);
        result = 31 * result + (mergeTarget != null ? mergeTarget.hashCode() : 0);
        result = 31 * result + (mergeTime != null ? mergeTime.hashCode() : 0);
        return result;
    }
}
