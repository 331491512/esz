package com.esuizhen.bigdata.domain.user;

import javax.persistence.*;

/**
 * Created by fqc on 16/12/24.
 */
@Entity
@Table(name = "u_merge_log", schema = "user_db", catalog = "")
public class UMergeLog {
    private int id;
    private Long goalPatientId;
    private String otherPatientIds;
    private String mergeReason;
    private String mergeTime;
    private Integer mergeResult;
    private Long operator;

    public UMergeLog() {
    }

    public UMergeLog(Long goalPatientId, String otherPatientIds, String mergeReason, String mergeTime, Integer mergeResult, Long operator) {
        this.goalPatientId = goalPatientId;
        this.otherPatientIds = otherPatientIds;
        this.mergeReason = mergeReason;
        this.mergeTime = mergeTime;
        this.mergeResult = mergeResult;
        this.operator = operator;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goalPatientId", nullable = true)
    public Long getGoalPatientId() {
        return goalPatientId;
    }

    public void setGoalPatientId(Long goalPatientId) {
        this.goalPatientId = goalPatientId;
    }

    @Basic
    @Column(name = "otherPatientIds", nullable = true)
    public String getOtherPatientIds() {
        return otherPatientIds;
    }

    public void setOtherPatientIds(String otherPatientIds) {
        this.otherPatientIds = otherPatientIds;
    }

    @Basic
    @Column(name = "mergeReason", nullable = true, length = 255)
    public String getMergeReason() {
        return mergeReason;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public String getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(String mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Basic
    @Column(name = "mergeResult", nullable = true, length = 255)
    public Integer getMergeResult() {
        return mergeResult;
    }

    public void setMergeResult(Integer mergeResult) {
        this.mergeResult = mergeResult;
    }

    @Basic
    @Column(name = "operator", nullable = true)
    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UMergeLog uMergeLog = (UMergeLog) o;

        if (id != uMergeLog.id) return false;
        if (goalPatientId != null ? !goalPatientId.equals(uMergeLog.goalPatientId) : uMergeLog.goalPatientId != null)
            return false;

        if (mergeReason != null ? !mergeReason.equals(uMergeLog.mergeReason) : uMergeLog.mergeReason != null)
            return false;
        if (mergeTime != null ? !mergeTime.equals(uMergeLog.mergeTime) : uMergeLog.mergeTime != null) return false;
        if (mergeResult != null ? !mergeResult.equals(uMergeLog.mergeResult) : uMergeLog.mergeResult != null)
            return false;
        if (operator != null ? !operator.equals(uMergeLog.operator) : uMergeLog.operator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goalPatientId != null ? goalPatientId.hashCode() : 0);
        result = 31 * result + (mergeReason != null ? mergeReason.hashCode() : 0);
        result = 31 * result + (mergeTime != null ? mergeTime.hashCode() : 0);
        result = 31 * result + (mergeResult != null ? mergeResult.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }
}
