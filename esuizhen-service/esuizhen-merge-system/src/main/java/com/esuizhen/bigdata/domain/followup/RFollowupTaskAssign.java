package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "r_followup_task_assign", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "r_followup_task_assign_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class RFollowupTaskAssign {
    private String followupAssignId;
    private String followupTaskId;
    private long operator;
    private int state;
    private Integer totalPatientNum;
    private Timestamp beginTime;
    private Timestamp createTime;
//    private FollowupTask followupTaskByFollowupTaskId;

    @Id
    @Column(name = "followupAssignId", nullable = false, length = 128)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = false, length = 128)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
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
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "totalPatientNum", nullable = true)
    public Integer getTotalPatientNum() {
        return totalPatientNum;
    }

    public void setTotalPatientNum(Integer totalPatientNum) {
        this.totalPatientNum = totalPatientNum;
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
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RFollowupTaskAssign that = (RFollowupTaskAssign) o;

        if (operator != that.operator) return false;
        if (state != that.state) return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (totalPatientNum != null ? !totalPatientNum.equals(that.totalPatientNum) : that.totalPatientNum != null)
            return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupAssignId != null ? followupAssignId.hashCode() : 0;
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (int) (operator ^ (operator >>> 32));
        result = 31 * result + state;
        result = 31 * result + (totalPatientNum != null ? totalPatientNum.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "followupTaskId", referencedColumnName = "followupTaskId", nullable = false,insertable = false,updatable = false)
//    public FollowupTask getFollowupTaskByFollowupTaskId() {
//        return followupTaskByFollowupTaskId;
//    }
//
//    public void setFollowupTaskByFollowupTaskId(FollowupTask followupTaskByFollowupTaskId) {
//        this.followupTaskByFollowupTaskId = followupTaskByFollowupTaskId;
//    }
}
