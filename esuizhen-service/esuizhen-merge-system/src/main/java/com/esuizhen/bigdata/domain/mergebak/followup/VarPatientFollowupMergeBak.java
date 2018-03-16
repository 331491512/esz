package com.esuizhen.bigdata.domain.mergebak.followup;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/29.
 */
@Entity
@Table(name = "var_patient_followup_merge_bak", schema = "followup_db", catalog="")
public class VarPatientFollowupMergeBak {
    private int id;
    private long patientId;
    private Integer followupAssignFlag;
    private int followupState;
    private int followupResultState;
    private int projectFollowupState;
    private int currFollowupPerformDays;
    private Timestamp latestFollowupFeedbackTime;
    private Timestamp latestFollowupTime;
    private Timestamp latestValidFollowupTime;
    private int followupResultValue;
    private Integer followupValidResultValue;
    private int liveDay;
    private Double liveMonth;
    private Long followupOperator;
    private String followupOperatorName;
    private Long validFollowupOperator;
    private String validFollowupOperatorName;
    private Integer followupWay;
    private String followupWayName;
    private Integer validFollowupWay;
    private String validFollowupWayName;
    private String relapseParts;
    private Date relapseDate;
    private String transferParts;
    private Date transferDate;
    private String followupRemark;
    private String followupTaskId;
    private String followupTaskName;
    private String validFollowupTaskId;
    private String validFollowupTaskName;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer followupFlag;
    private String smsReplyContent;
    private Timestamp smsSendTime;
    private Integer sourceFlag;
    private Integer validSourceFlag;
    private Integer newVisitFlag;
    private Integer newContactFlag;

    //@Basic
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
    @Column(name = "followupAssignFlag", nullable = true)
    public Integer getFollowupAssignFlag() {
        return followupAssignFlag;
    }

    public void setFollowupAssignFlag(Integer followupAssignFlag) {
        this.followupAssignFlag = followupAssignFlag;
    }

    @Basic
    @Column(name = "followupState", nullable = false)
    public int getFollowupState() {
        return followupState;
    }

    public void setFollowupState(int followupState) {
        this.followupState = followupState;
    }

    @Basic
    @Column(name = "followupResultState", nullable = false)
    public int getFollowupResultState() {
        return followupResultState;
    }

    public void setFollowupResultState(int followupResultState) {
        this.followupResultState = followupResultState;
    }

    @Basic
    @Column(name = "projectFollowupState", nullable = false)
    public int getProjectFollowupState() {
        return projectFollowupState;
    }

    public void setProjectFollowupState(int projectFollowupState) {
        this.projectFollowupState = projectFollowupState;
    }

    @Basic
    @Column(name = "currFollowupPerformDays", nullable = false)
    public int getCurrFollowupPerformDays() {
        return currFollowupPerformDays;
    }

    public void setCurrFollowupPerformDays(int currFollowupPerformDays) {
        this.currFollowupPerformDays = currFollowupPerformDays;
    }

    @Basic
    @Column(name = "latestFollowupFeedbackTime", nullable = true)
    public Timestamp getLatestFollowupFeedbackTime() {
        return latestFollowupFeedbackTime;
    }

    public void setLatestFollowupFeedbackTime(Timestamp latestFollowupFeedbackTime) {
        this.latestFollowupFeedbackTime = latestFollowupFeedbackTime;
    }

    @Basic
    @Column(name = "latestFollowupTime", nullable = true)
    public Timestamp getLatestFollowupTime() {
        return latestFollowupTime;
    }

    public void setLatestFollowupTime(Timestamp latestFollowupTime) {
        this.latestFollowupTime = latestFollowupTime;
    }

    @Basic
    @Column(name = "latestValidFollowupTime", nullable = true)
    public Timestamp getLatestValidFollowupTime() {
        return latestValidFollowupTime;
    }

    public void setLatestValidFollowupTime(Timestamp latestValidFollowupTime) {
        this.latestValidFollowupTime = latestValidFollowupTime;
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
    @Column(name = "followupValidResultValue", nullable = true)
    public Integer getFollowupValidResultValue() {
        return followupValidResultValue;
    }

    public void setFollowupValidResultValue(Integer followupValidResultValue) {
        this.followupValidResultValue = followupValidResultValue;
    }

    @Basic
    @Column(name = "liveDay", nullable = false)
    public int getLiveDay() {
        return liveDay;
    }

    public void setLiveDay(int liveDay) {
        this.liveDay = liveDay;
    }

    @Basic
    @Column(name = "liveMonth", nullable = true, precision = 1)
    public Double getLiveMonth() {
        return liveMonth;
    }

    public void setLiveMonth(Double liveMonth) {
        this.liveMonth = liveMonth;
    }

    @Basic
    @Column(name = "followupOperator", nullable = true)
    public Long getFollowupOperator() {
        return followupOperator;
    }

    public void setFollowupOperator(Long followupOperator) {
        this.followupOperator = followupOperator;
    }

    @Basic
    @Column(name = "followupOperatorName", nullable = true, length = 50)
    public String getFollowupOperatorName() {
        return followupOperatorName;
    }

    public void setFollowupOperatorName(String followupOperatorName) {
        this.followupOperatorName = followupOperatorName;
    }

    @Basic
    @Column(name = "validFollowupOperator", nullable = true)
    public Long getValidFollowupOperator() {
        return validFollowupOperator;
    }

    public void setValidFollowupOperator(Long validFollowupOperator) {
        this.validFollowupOperator = validFollowupOperator;
    }

    @Basic
    @Column(name = "validFollowupOperatorName", nullable = true, length = 50)
    public String getValidFollowupOperatorName() {
        return validFollowupOperatorName;
    }

    public void setValidFollowupOperatorName(String validFollowupOperatorName) {
        this.validFollowupOperatorName = validFollowupOperatorName;
    }

    @Basic
    @Column(name = "followupWay", nullable = true)
    public Integer getFollowupWay() {
        return followupWay;
    }

    public void setFollowupWay(Integer followupWay) {
        this.followupWay = followupWay;
    }

    @Basic
    @Column(name = "followupWayName", nullable = true, length = 20)
    public String getFollowupWayName() {
        return followupWayName;
    }

    public void setFollowupWayName(String followupWayName) {
        this.followupWayName = followupWayName;
    }

    @Basic
    @Column(name = "validFollowupWay", nullable = true)
    public Integer getValidFollowupWay() {
        return validFollowupWay;
    }

    public void setValidFollowupWay(Integer validFollowupWay) {
        this.validFollowupWay = validFollowupWay;
    }

    @Basic
    @Column(name = "validFollowupWayName", nullable = true, length = 20)
    public String getValidFollowupWayName() {
        return validFollowupWayName;
    }

    public void setValidFollowupWayName(String validFollowupWayName) {
        this.validFollowupWayName = validFollowupWayName;
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
    @Column(name = "followupRemark", nullable = true, length = 255)
    public String getFollowupRemark() {
        return followupRemark;
    }

    public void setFollowupRemark(String followupRemark) {
        this.followupRemark = followupRemark;
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
    @Column(name = "followupTaskName", nullable = true, length = 255)
    public String getFollowupTaskName() {
        return followupTaskName;
    }

    public void setFollowupTaskName(String followupTaskName) {
        this.followupTaskName = followupTaskName;
    }

    @Basic
    @Column(name = "validFollowupTaskId", nullable = true, length = 128)
    public String getValidFollowupTaskId() {
        return validFollowupTaskId;
    }

    public void setValidFollowupTaskId(String validFollowupTaskId) {
        this.validFollowupTaskId = validFollowupTaskId;
    }

    @Basic
    @Column(name = "validFollowupTaskName", nullable = true, length = 255)
    public String getValidFollowupTaskName() {
        return validFollowupTaskName;
    }

    public void setValidFollowupTaskName(String validFollowupTaskName) {
        this.validFollowupTaskName = validFollowupTaskName;
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
    @Column(name = "followupFlag", nullable = true)
    public Integer getFollowupFlag() {
        return followupFlag;
    }

    public void setFollowupFlag(Integer followupFlag) {
        this.followupFlag = followupFlag;
    }

    @Basic
    @Column(name = "smsReplyContent", nullable = true, length = 255)
    public String getSmsReplyContent() {
        return smsReplyContent;
    }

    public void setSmsReplyContent(String smsReplyContent) {
        this.smsReplyContent = smsReplyContent;
    }

    @Basic
    @Column(name = "smsSendTime", nullable = true)
    public Timestamp getSmsSendTime() {
        return smsSendTime;
    }

    public void setSmsSendTime(Timestamp smsSendTime) {
        this.smsSendTime = smsSendTime;
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
    @Column(name = "validSourceFlag", nullable = true)
    public Integer getValidSourceFlag() {
        return validSourceFlag;
    }

    public void setValidSourceFlag(Integer validSourceFlag) {
        this.validSourceFlag = validSourceFlag;
    }

    @Basic
    @Column(name = "newVisitFlag", nullable = true)
    public Integer getNewVisitFlag() {
        return newVisitFlag;
    }

    public void setNewVisitFlag(Integer newVisitFlag) {
        this.newVisitFlag = newVisitFlag;
    }

    @Basic
    @Column(name = "newContactFlag", nullable = true)
    public Integer getNewContactFlag() {
        return newContactFlag;
    }

    public void setNewContactFlag(Integer newContactFlag) {
        this.newContactFlag = newContactFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VarPatientFollowupMergeBak that = (VarPatientFollowupMergeBak) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (followupState != that.followupState) return false;
        if (followupResultState != that.followupResultState) return false;
        if (projectFollowupState != that.projectFollowupState) return false;
        if (currFollowupPerformDays != that.currFollowupPerformDays) return false;
        if (followupResultValue != that.followupResultValue) return false;
        if (liveDay != that.liveDay) return false;
        if (followupAssignFlag != null ? !followupAssignFlag.equals(that.followupAssignFlag) : that.followupAssignFlag != null)
            return false;
        if (latestFollowupFeedbackTime != null ? !latestFollowupFeedbackTime.equals(that.latestFollowupFeedbackTime) : that.latestFollowupFeedbackTime != null)
            return false;
        if (latestFollowupTime != null ? !latestFollowupTime.equals(that.latestFollowupTime) : that.latestFollowupTime != null)
            return false;
        if (latestValidFollowupTime != null ? !latestValidFollowupTime.equals(that.latestValidFollowupTime) : that.latestValidFollowupTime != null)
            return false;
        if (followupValidResultValue != null ? !followupValidResultValue.equals(that.followupValidResultValue) : that.followupValidResultValue != null)
            return false;
        if (liveMonth != null ? !liveMonth.equals(that.liveMonth) : that.liveMonth != null) return false;
        if (followupOperator != null ? !followupOperator.equals(that.followupOperator) : that.followupOperator != null)
            return false;
        if (followupOperatorName != null ? !followupOperatorName.equals(that.followupOperatorName) : that.followupOperatorName != null)
            return false;
        if (validFollowupOperator != null ? !validFollowupOperator.equals(that.validFollowupOperator) : that.validFollowupOperator != null)
            return false;
        if (validFollowupOperatorName != null ? !validFollowupOperatorName.equals(that.validFollowupOperatorName) : that.validFollowupOperatorName != null)
            return false;
        if (followupWay != null ? !followupWay.equals(that.followupWay) : that.followupWay != null) return false;
        if (followupWayName != null ? !followupWayName.equals(that.followupWayName) : that.followupWayName != null)
            return false;
        if (validFollowupWay != null ? !validFollowupWay.equals(that.validFollowupWay) : that.validFollowupWay != null)
            return false;
        if (validFollowupWayName != null ? !validFollowupWayName.equals(that.validFollowupWayName) : that.validFollowupWayName != null)
            return false;
        if (relapseParts != null ? !relapseParts.equals(that.relapseParts) : that.relapseParts != null) return false;
        if (relapseDate != null ? !relapseDate.equals(that.relapseDate) : that.relapseDate != null) return false;
        if (transferParts != null ? !transferParts.equals(that.transferParts) : that.transferParts != null)
            return false;
        if (transferDate != null ? !transferDate.equals(that.transferDate) : that.transferDate != null) return false;
        if (followupRemark != null ? !followupRemark.equals(that.followupRemark) : that.followupRemark != null)
            return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupTaskName != null ? !followupTaskName.equals(that.followupTaskName) : that.followupTaskName != null)
            return false;
        if (validFollowupTaskId != null ? !validFollowupTaskId.equals(that.validFollowupTaskId) : that.validFollowupTaskId != null)
            return false;
        if (validFollowupTaskName != null ? !validFollowupTaskName.equals(that.validFollowupTaskName) : that.validFollowupTaskName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (followupFlag != null ? !followupFlag.equals(that.followupFlag) : that.followupFlag != null) return false;
        if (smsReplyContent != null ? !smsReplyContent.equals(that.smsReplyContent) : that.smsReplyContent != null)
            return false;
        if (smsSendTime != null ? !smsSendTime.equals(that.smsSendTime) : that.smsSendTime != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (validSourceFlag != null ? !validSourceFlag.equals(that.validSourceFlag) : that.validSourceFlag != null)
            return false;
        if (newVisitFlag != null ? !newVisitFlag.equals(that.newVisitFlag) : that.newVisitFlag != null) return false;
        if (newContactFlag != null ? !newContactFlag.equals(that.newContactFlag) : that.newContactFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (followupAssignFlag != null ? followupAssignFlag.hashCode() : 0);
        result = 31 * result + followupState;
        result = 31 * result + followupResultState;
        result = 31 * result + projectFollowupState;
        result = 31 * result + currFollowupPerformDays;
        result = 31 * result + (latestFollowupFeedbackTime != null ? latestFollowupFeedbackTime.hashCode() : 0);
        result = 31 * result + (latestFollowupTime != null ? latestFollowupTime.hashCode() : 0);
        result = 31 * result + (latestValidFollowupTime != null ? latestValidFollowupTime.hashCode() : 0);
        result = 31 * result + followupResultValue;
        result = 31 * result + (followupValidResultValue != null ? followupValidResultValue.hashCode() : 0);
        result = 31 * result + liveDay;
        result = 31 * result + (liveMonth != null ? liveMonth.hashCode() : 0);
        result = 31 * result + (followupOperator != null ? followupOperator.hashCode() : 0);
        result = 31 * result + (followupOperatorName != null ? followupOperatorName.hashCode() : 0);
        result = 31 * result + (validFollowupOperator != null ? validFollowupOperator.hashCode() : 0);
        result = 31 * result + (validFollowupOperatorName != null ? validFollowupOperatorName.hashCode() : 0);
        result = 31 * result + (followupWay != null ? followupWay.hashCode() : 0);
        result = 31 * result + (followupWayName != null ? followupWayName.hashCode() : 0);
        result = 31 * result + (validFollowupWay != null ? validFollowupWay.hashCode() : 0);
        result = 31 * result + (validFollowupWayName != null ? validFollowupWayName.hashCode() : 0);
        result = 31 * result + (relapseParts != null ? relapseParts.hashCode() : 0);
        result = 31 * result + (relapseDate != null ? relapseDate.hashCode() : 0);
        result = 31 * result + (transferParts != null ? transferParts.hashCode() : 0);
        result = 31 * result + (transferDate != null ? transferDate.hashCode() : 0);
        result = 31 * result + (followupRemark != null ? followupRemark.hashCode() : 0);
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupTaskName != null ? followupTaskName.hashCode() : 0);
        result = 31 * result + (validFollowupTaskId != null ? validFollowupTaskId.hashCode() : 0);
        result = 31 * result + (validFollowupTaskName != null ? validFollowupTaskName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (followupFlag != null ? followupFlag.hashCode() : 0);
        result = 31 * result + (smsReplyContent != null ? smsReplyContent.hashCode() : 0);
        result = 31 * result + (smsSendTime != null ? smsSendTime.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (validSourceFlag != null ? validSourceFlag.hashCode() : 0);
        result = 31 * result + (newVisitFlag != null ? newVisitFlag.hashCode() : 0);
        result = 31 * result + (newContactFlag != null ? newContactFlag.hashCode() : 0);
        return result;
    }
}
