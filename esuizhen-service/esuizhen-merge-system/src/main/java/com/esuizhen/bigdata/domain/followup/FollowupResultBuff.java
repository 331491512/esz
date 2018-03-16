package com.esuizhen.bigdata.domain.followup;

import com.esuizhen.bigdata.domain.user.UPatient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_result_buff", schema = "followup_db", catalog="")
public class FollowupResultBuff {
    private String followupResultBuffId;
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
    private int followUpWay;
    private Integer contentTemplateId;
    private String followupResultPhone;
    private Timestamp followupTime;
    private String phoneRecordUrl;
    private String remark;
    private String replyContent;
    private Timestamp replyTime;
    private Integer syncFlag;
    private Integer sourceFlag;
    private String followupResultId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private MetaFollowupResultValue metaFollowupResultValueByFollowupResultValue;
    private MetaFollowupWay metaFollowupWayByFollowUpWay;
    private UPatient uPatientByPatientId;

    private Long mergeFrom;
    private Long mergeTarget;
    private Integer mergeFlag;
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
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "followupResultBuffId", nullable = false, length = 60)
    public String getFollowupResultBuffId() {
        return followupResultBuffId;
    }

    public void setFollowupResultBuffId(String followupResultBuffId) {
        this.followupResultBuffId = followupResultBuffId;
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
    @Column(name = "followUpWay", nullable = false)
    public int getFollowUpWay() {
        return followUpWay;
    }

    public void setFollowUpWay(int followUpWay) {
        this.followUpWay = followUpWay;
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
    @Column(name = "replyContent", nullable = true, length = 255)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "replyTime", nullable = true)
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
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

        FollowupResultBuff that = (FollowupResultBuff) o;

        if (patientId != that.patientId) return false;
        if (operator != that.operator) return false;
        if (followupResultValue != that.followupResultValue) return false;
        if (followUpWay != that.followUpWay) return false;
        if (followupResultBuffId != null ? !followupResultBuffId.equals(that.followupResultBuffId) : that.followupResultBuffId != null)
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
        if (phoneRecordUrl != null ? !phoneRecordUrl.equals(that.phoneRecordUrl) : that.phoneRecordUrl != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (followupResultId != null ? !followupResultId.equals(that.followupResultId) : that.followupResultId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupResultBuffId != null ? followupResultBuffId.hashCode() : 0;
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
        result = 31 * result + followUpWay;
        result = 31 * result + (contentTemplateId != null ? contentTemplateId.hashCode() : 0);
        result = 31 * result + (followupResultPhone != null ? followupResultPhone.hashCode() : 0);
        result = 31 * result + (followupTime != null ? followupTime.hashCode() : 0);
        result = 31 * result + (phoneRecordUrl != null ? phoneRecordUrl.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (followupResultId != null ? followupResultId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "followupResultValue", referencedColumnName = "followupResultValueId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_buff_ibfk_3"))
    public MetaFollowupResultValue getMetaFollowupResultValueByFollowupResultValue() {
        return metaFollowupResultValueByFollowupResultValue;
    }

    public void setMetaFollowupResultValueByFollowupResultValue(MetaFollowupResultValue metaFollowupResultValueByFollowupResultValue) {
        this.metaFollowupResultValueByFollowupResultValue = metaFollowupResultValueByFollowupResultValue;
    }

    @ManyToOne
    @JoinColumn(name = "followUpWay", referencedColumnName = "followupWayId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_buff_ibfk_1"))
    public MetaFollowupWay getMetaFollowupWayByFollowUpWay() {
        return metaFollowupWayByFollowUpWay;
    }

    public void setMetaFollowupWayByFollowUpWay(MetaFollowupWay metaFollowupWayByFollowUpWay) {
        this.metaFollowupWayByFollowUpWay = metaFollowupWayByFollowUpWay;
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "patientId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_buff_ibfk_2"))
    public UPatient getuPatientByPatientId() {
        return uPatientByPatientId;
    }

    public void setuPatientByPatientId(UPatient uPatientByPatientId) {
        this.uPatientByPatientId = uPatientByPatientId;
    }

    @Override
    public String toString() {
        return "FollowupResultBuff{" +
                "followupResultBuffId='" + followupResultId + '\'' +
                ", patientId=" + patientId +
                ", mergeFrom=" + mergeFrom +
                ", mergeTarget=" + mergeTarget +
                ", mergeFlag=" + mergeFlag +
                ", mergeTime=" + mergeTime +
                '}';
    }
}