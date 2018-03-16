package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "s_operation_history", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "s_operation_history_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class SOperationHistory {
    private int operationId;
    private String operationName;
    private String description;
    private int actionType;
    private Long operatorId;
    private Integer operationCount;
    private Timestamp createTime;

    @Id
    @Column(name = "operationId", nullable = false)
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "operationName", nullable = true, length = 50)
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "actionType", nullable = false)
    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    @Basic
    @Column(name = "operatorId", nullable = true)
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operationCount", nullable = true)
    public Integer getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(Integer operationCount) {
        this.operationCount = operationCount;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
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

        SOperationHistory that = (SOperationHistory) o;

        if (operationId != that.operationId) return false;
        if (actionType != that.actionType) return false;
        if (operationName != null ? !operationName.equals(that.operationName) : that.operationName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operationCount != null ? !operationCount.equals(that.operationCount) : that.operationCount != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operationId;
        result = 31 * result + (operationName != null ? operationName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + actionType;
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operationCount != null ? operationCount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
