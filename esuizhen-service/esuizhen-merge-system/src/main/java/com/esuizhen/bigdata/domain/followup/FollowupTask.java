package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_task", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_task_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupTask {
    private String followupTaskId;
    private String followupTaskName;
    private String followupTaskDescrption;
    private int followupType;
    private Timestamp planFinishTime;
    private Timestamp finishTime;
    private Timestamp followupTime;
    private Timestamp beginTime;
    private long creator;
    private int state;
    private Integer auditScore;
    private String auditRemark;
    private Long auditUserId;
    private Timestamp auditTime;
    private Integer diseaseTypeId;
    private int totalPatientNum;
    private int operatorNum;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private Collection<RFollowupTaskAssign> rFollowupTaskAssignsByFollowupTaskId;
//    private Collection<RFollowupTaskContentTemplate> rFollowupTaskContentTemplatesByFollowupTaskId;
//    private Collection<RFollowupTaskPatient> rFollowupTaskPatientsByFollowupTaskId;

    @Id
    @Column(name = "followupTaskId", nullable = false, length = 60)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "followupTaskName", nullable = false, length = 200)
    public String getFollowupTaskName() {
        return followupTaskName;
    }

    public void setFollowupTaskName(String followupTaskName) {
        this.followupTaskName = followupTaskName;
    }

    @Basic
    @Column(name = "followupTaskDescrption", nullable = true, length = 1000)
    public String getFollowupTaskDescrption() {
        return followupTaskDescrption;
    }

    public void setFollowupTaskDescrption(String followupTaskDescrption) {
        this.followupTaskDescrption = followupTaskDescrption;
    }

    @Basic
    @Column(name = "followupType", nullable = false)
    public int getFollowupType() {
        return followupType;
    }

    public void setFollowupType(int followupType) {
        this.followupType = followupType;
    }

    @Basic
    @Column(name = "planFinishTime", nullable = true)
    public Timestamp getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Timestamp planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    @Basic
    @Column(name = "finishTime", nullable = true)
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "followupTime", nullable = true)
    public Timestamp getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(Timestamp followupTime) {
        this.followupTime = followupTime;
    }

    @Basic
    @Column(name = "beginTime", nullable = true)
    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "creator", nullable = false)
    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
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
    @Column(name = "auditScore", nullable = true)
    public Integer getAuditScore() {
        return auditScore;
    }

    public void setAuditScore(Integer auditScore) {
        this.auditScore = auditScore;
    }

    @Basic
    @Column(name = "auditRemark", nullable = true, length = 255)
    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Basic
    @Column(name = "auditUserId", nullable = true)
    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    @Basic
    @Column(name = "auditTime", nullable = true)
    public Timestamp getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Timestamp auditTime) {
        this.auditTime = auditTime;
    }

    @Basic
    @Column(name = "diseaseTypeId", nullable = true)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "totalPatientNum", nullable = false)
    public int getTotalPatientNum() {
        return totalPatientNum;
    }

    public void setTotalPatientNum(int totalPatientNum) {
        this.totalPatientNum = totalPatientNum;
    }

    @Basic
    @Column(name = "operatorNum", nullable = false)
    public int getOperatorNum() {
        return operatorNum;
    }

    public void setOperatorNum(int operatorNum) {
        this.operatorNum = operatorNum;
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

        FollowupTask that = (FollowupTask) o;

        if (followupType != that.followupType) return false;
        if (creator != that.creator) return false;
        if (state != that.state) return false;
        if (totalPatientNum != that.totalPatientNum) return false;
        if (operatorNum != that.operatorNum) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupTaskName != null ? !followupTaskName.equals(that.followupTaskName) : that.followupTaskName != null)
            return false;
        if (followupTaskDescrption != null ? !followupTaskDescrption.equals(that.followupTaskDescrption) : that.followupTaskDescrption != null)
            return false;
        if (planFinishTime != null ? !planFinishTime.equals(that.planFinishTime) : that.planFinishTime != null)
            return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (followupTime != null ? !followupTime.equals(that.followupTime) : that.followupTime != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (auditScore != null ? !auditScore.equals(that.auditScore) : that.auditScore != null) return false;
        if (auditRemark != null ? !auditRemark.equals(that.auditRemark) : that.auditRemark != null) return false;
        if (auditUserId != null ? !auditUserId.equals(that.auditUserId) : that.auditUserId != null) return false;
        if (auditTime != null ? !auditTime.equals(that.auditTime) : that.auditTime != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupTaskId != null ? followupTaskId.hashCode() : 0;
        result = 31 * result + (followupTaskName != null ? followupTaskName.hashCode() : 0);
        result = 31 * result + (followupTaskDescrption != null ? followupTaskDescrption.hashCode() : 0);
        result = 31 * result + followupType;
        result = 31 * result + (planFinishTime != null ? planFinishTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (followupTime != null ? followupTime.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (int) (creator ^ (creator >>> 32));
        result = 31 * result + state;
        result = 31 * result + (auditScore != null ? auditScore.hashCode() : 0);
        result = 31 * result + (auditRemark != null ? auditRemark.hashCode() : 0);
        result = 31 * result + (auditUserId != null ? auditUserId.hashCode() : 0);
        result = 31 * result + (auditTime != null ? auditTime.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + totalPatientNum;
        result = 31 * result + operatorNum;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "followupTaskByFollowupTaskId")
//    public Collection<RFollowupTaskAssign> getrFollowupTaskAssignsByFollowupTaskId() {
//        return rFollowupTaskAssignsByFollowupTaskId;
//    }
//
//    public void setrFollowupTaskAssignsByFollowupTaskId(Collection<RFollowupTaskAssign> rFollowupTaskAssignsByFollowupTaskId) {
//        this.rFollowupTaskAssignsByFollowupTaskId = rFollowupTaskAssignsByFollowupTaskId;
//    }
//
//    @OneToMany(mappedBy = "followupTaskByFollowupTaskId")
//    public Collection<RFollowupTaskContentTemplate> getrFollowupTaskContentTemplatesByFollowupTaskId() {
//        return rFollowupTaskContentTemplatesByFollowupTaskId;
//    }
//
//    public void setrFollowupTaskContentTemplatesByFollowupTaskId(Collection<RFollowupTaskContentTemplate> rFollowupTaskContentTemplatesByFollowupTaskId) {
//        this.rFollowupTaskContentTemplatesByFollowupTaskId = rFollowupTaskContentTemplatesByFollowupTaskId;
//    }
//
//    @OneToMany(mappedBy = "followupTaskByFollowupTaskId")
//    public Collection<RFollowupTaskPatient> getrFollowupTaskPatientsByFollowupTaskId() {
//        return rFollowupTaskPatientsByFollowupTaskId;
//    }
//
//    public void setrFollowupTaskPatientsByFollowupTaskId(Collection<RFollowupTaskPatient> rFollowupTaskPatientsByFollowupTaskId) {
//        this.rFollowupTaskPatientsByFollowupTaskId = rFollowupTaskPatientsByFollowupTaskId;
//    }
}
