package com.esuizhen.bigdata.domain.followup;

import com.esuizhen.bigdata.common.TimeUtils;
import com.esuizhen.bigdata.domain.user.UPatient;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 17/01/04.
 */
@Entity
@Table(name = "followup_result", schema = "followup_db", catalog="")
public class FollowupResult {

    private String followupResultId;
    private Integer tempId;
    private String followupTaskId;
    private String followupAssignId;
    private Long patientId;
    private Integer hospitalId;
    private Long operator;
    /**
     * 1	稳定	1
     * 2	复发	1
     * 3	转移	1
     * 4	死亡	1
     * 5	其他情况	1
     * 7	无人接听	2
     * 8	空号	2
     * 9	错号	2
     * 10	拒绝随访	2
     * 11	主动拒接	2
     * 12	关机	2
     * 13	停机	2
     * 14	无法接通	2
     * 15	门诊生存	1
     * 16	住院生存	1
     */
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
    private Integer followupWay;
    private Integer contentTemplateId;
    private String followupResultPhone;
    private Timestamp followupTime;
    //'失妨标识。1：是；0：否'
    private Integer lostFollowupFlag;
    private Integer lostFollowupCauseResultValue;
    private String phoneRecordUrl;
    private String remark;
    private Integer syncFlag;
    private Integer sourceFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private MetaFollowupResultValue metaFollowupResultValueByFollowupResultValue;
    private MetaFollowupWay metaFollowupWayByFollowupWay;
    private UPatient uPatientByPatientId;

    private Long mergeFrom;
    private Long mergeTarget;
    private Integer mergeFlag;
    private Timestamp mergeTime;

    private Integer state;

    // level 和 latestFollowupTime followupResult实体关联设置的
    private Integer level;

    @Transient
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    /*private timestamp visitingtime;

    @Transient
    public Timestamp getVisitingTime() {
        Timestamp latestClinicDate = this.getLatestClinicDate();
        Timestamp latestInHospitalDate = this.getLatestInHospitalDate();
        if (latestInHospitalDate != null && latestClinicDate != null) {
            if (latestInHospitalDate.after(latestClinicDate)) {
                this.visitingTime = latestInHospitalDate;
            } else {
                this.visitingTime = latestClinicDate;
            }
        }
        if (latestInHospitalDate == null) {
            this.visitingTime = latestClinicDate;
        }
        if (latestClinicDate == null) {
            this.visitingTime = latestInHospitalDate;
        }
        return visitingTime;
    }*/

    /**
     * 随访状态优先级计算 ((`followupTaskId`,`patientId`) unique 特指的患者任务)
     * <p> 具体定义FollowupResultValueEnum
     * <p>
     * /**
     * prd描述
     * 一、患者随访完成状态
     * 1、已完成（有效结果，死亡11>转移12>复发13>稳定14>住院生存15>门诊生存16>好转17）
     * 2、已完成（无效结果）指随访中结果为主动拒接21、无人接听22、无法接通 23、关机24、停机25、拒绝随访26、错号27、空号28
     * 3、暂存 31   暂存与未完成  r_followup_task_patient的state来判断 这里特殊处理 在同一任务中的先查出，然后set进行来,然后再进行投票选举.
     * 4、未完成 41
     * 二、随访时间最近；
     * 注：
     * 有效结果：指随访中结果为稳定、复发、转移、死亡、门诊生存、住院生存、好转 ；
     * <p>
     * 无效结果：指随访中结果为 主动拒接21、无人接听22、无法接通23、关机24、停机25、拒绝随访26、错号27、空号28； （无效结果：指随访中结果为无人接听、主动拒接、无法接通、关机、停机、错号、空号、拒绝随访；）
     * <p>
     * 随访结果为“其他情况”时，根据全局开关中“随访结果统计全局设置”开关判断是否为有效结果；
     * “其它情况” 19 或 29
     * <p>
     * 随访任务状态 随访结果
     * 随访时间
     * <p>
     * 保留的是{taskId,patientId} ，之后该追加或更新到目标患者
     * 随访结果也是使用改投票就好了
     *
     * @param taskPatients
     * @return
     */
    private Integer voteFollowupResultStateLevel;
    private String latestFollowupTime;

    @Transient
    public String getLatestFollowupTime() {
        return latestFollowupTime;
    }

    public void setLatestFollowupTime(String latestFollowupTime) {
        this.latestFollowupTime = latestFollowupTime;
    }

    /**
     * 稳定
     * 复发
     * 转移
     * 死亡
     * 其他情况
     * 无人接听
     * 空号
     * 错号
     * 拒绝随访
     * 主动拒接
     * 关机
     * 停机
     * 无法接通
     * 门诊生存
     * 住院生存
     */
    @Transient
    public Integer getVoteFollowupResultStateLevel() {
        String followupResultValueName = this.getMetaFollowupResultValueByFollowupResultValue().getFollowupResultValueName();
        switch (followupResultValueName) {
            case "死亡":
                this.setVoteFollowupResultStateLevel(11);
                break;
            case "转移":
                this.setVoteFollowupResultStateLevel(12);
                break;
            case "复发":
                this.setVoteFollowupResultStateLevel(13);
                break;
            case "稳定":
                this.setVoteFollowupResultStateLevel(14);
                break;
            case "住院生存":
                this.setVoteFollowupResultStateLevel(15);
                break;
            case "门诊生存":
                this.setVoteFollowupResultStateLevel(16);
                break;
            case "好转":
                this.setVoteFollowupResultStateLevel(17);
                break;
            case "主动拒接":
                this.setVoteFollowupResultStateLevel(21);
                break;
            case "无人接听":
                this.setVoteFollowupResultStateLevel(22);
                break;
            case "无法接通":
                this.setVoteFollowupResultStateLevel(23);
                break;
            case "关机":
                this.setVoteFollowupResultStateLevel(24);
                break;
            case "停机":
                this.setVoteFollowupResultStateLevel(25);
                break;
            case "拒绝随访":
                this.setVoteFollowupResultStateLevel(26);
                break;
            case "错号":
                this.setVoteFollowupResultStateLevel(27);
                break;
            case "空号":
                this.setVoteFollowupResultStateLevel(28);
                break;
            case "其它情况"://默认有效，这里需要在后面具体修改下
                if (otherAsValidResultFlag == 1) {
                    this.setVoteFollowupResultStateLevel(19);
                } else {
                    this.setVoteFollowupResultStateLevel(29);
                }
                break;
            //case "暂存": //这里设置无效，单独在代码中处理
            //    this.setVoteFollowupResultStateLevel(31);
            //    break;
            //case "未完成":
            //    this.setVoteFollowupResultStateLevel(41);
            //    break;
            default:
                //为空的情况
                this.setVoteFollowupResultStateLevel(9999);
        }
        return voteFollowupResultStateLevel;
    }

    // `otherAsValidResultFlag` int(2) DEFAULT '0' COMMENT '随访结果统计全局设置. 将其他情况作为有效随访统计.\r\n1：开启；0：关闭（默认）\r\n',
    private Integer otherAsValidResultFlag;

    @Transient
    public Integer getOtherAsValidResultFlag() {
        return otherAsValidResultFlag;
    }

    public void setOtherAsValidResultFlag(Integer otherAsValidResultFlag) {
        this.otherAsValidResultFlag = otherAsValidResultFlag;
    }

    public void setVoteFollowupResultStateLevel(Integer voteFollowupResultStateLevel) {
        this.voteFollowupResultStateLevel = voteFollowupResultStateLevel;
    }


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

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

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
    @Column(name = "operator", nullable = false)
    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    /**
     * `followupResultValue` int(11) NOT NULL COMMENT '随访结果类型。外键。meta_followup_result_type.followupResultTypeId',
     *
     * @return
     */
    @Basic
    @Column(name = "followupResultValue", nullable = false)
    public int getFollowupResultValue() {
        return followupResultValue;
    }

    /**
     * `followupResultValue` int(11) NOT NULL COMMENT '随访结果类型。外键。meta_followup_result_type.followupResultTypeId',
     *
     * @param followupResultValue
     */
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
    public Integer getFollowupWay() {
        return followupWay;
    }

    public void setFollowupWay(Integer followupWay) {
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
        if(createTime==null){
            return TimeUtils.getCurrentTimestamp();
        }
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

        FollowupResult that = (FollowupResult) o;

        if (patientId != that.patientId) return false;
        if (operator != that.operator) return false;
        if (followupResultValue != that.followupResultValue) return false;
        if (followupWay != that.followupWay) return false;
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
        if (phoneRecordUrl != null ? !phoneRecordUrl.equals(that.phoneRecordUrl) : that.phoneRecordUrl != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (sourceFlag != null ? !sourceFlag.equals(that.sourceFlag) : that.sourceFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

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
        result = 31 * result + (phoneRecordUrl != null ? phoneRecordUrl.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (sourceFlag != null ? sourceFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "followupResultValue", referencedColumnName = "followupResultValueId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_ibfk_3"))
    public MetaFollowupResultValue getMetaFollowupResultValueByFollowupResultValue() {
        return metaFollowupResultValueByFollowupResultValue;
    }

    public void setMetaFollowupResultValueByFollowupResultValue(MetaFollowupResultValue metaFollowupResultValueByFollowupResultValue) {
        this.metaFollowupResultValueByFollowupResultValue = metaFollowupResultValueByFollowupResultValue;
    }

    @ManyToOne
    @JoinColumn(name = "followupWay", referencedColumnName = "followupWayId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_ibfk_1"))
    public MetaFollowupWay getMetaFollowupWayByFollowupWay() {
        return metaFollowupWayByFollowupWay;
    }

    public void setMetaFollowupWayByFollowupWay(MetaFollowupWay metaFollowupWayByFollowupWay) {
        this.metaFollowupWayByFollowupWay = metaFollowupWayByFollowupWay;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", referencedColumnName = "patientId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "followup_result_ibfk_2"))
    public UPatient getuPatientByPatientId() {
        return uPatientByPatientId;
    }

    public void setuPatientByPatientId(UPatient uPatientByPatientId) {
        this.uPatientByPatientId = uPatientByPatientId;
    }

    @Override
    public String toString() {
        return "FollowupResult{" +
                "followupResultId='" + followupResultId + '\'' +
                ", patientId=" + patientId +
                ", mergeFrom=" + mergeFrom +
                ", mergeTarget=" + mergeTarget +
                ", mergeFlag=" + mergeFlag +
                ", mergeTime=" + mergeTime +
                '}';
    }
}