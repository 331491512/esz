package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_sql", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_sql_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaSql {
    private Integer sqlId;
    private String bussinessType;
    private String sqlType;
    private String sqlContent;
    private Timestamp createTime;

    @Id
    @Column(name = "sqlId", nullable = false)
    public Integer getSqlId() {
        return sqlId;
    }

    public void setSqlId(Integer sqlId) {
        this.sqlId = sqlId;
    }

    @Basic
    @Column(name = "bussinessType", nullable = false, length = 32)
    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    @Basic
    @Column(name = "sqlType", nullable = false, length = 32)
    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    @Basic
    @Column(name = "sqlContent", nullable = false, length = 4096)
    public String getSqlContent() {
        return sqlContent;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent;
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

        MetaSql metaSql = (MetaSql) o;

        if (sqlId != null ? !sqlId.equals(metaSql.sqlId) : metaSql.sqlId != null) return false;
        if (bussinessType != null ? !bussinessType.equals(metaSql.bussinessType) : metaSql.bussinessType != null)
            return false;
        if (sqlType != null ? !sqlType.equals(metaSql.sqlType) : metaSql.sqlType != null) return false;
        if (sqlContent != null ? !sqlContent.equals(metaSql.sqlContent) : metaSql.sqlContent != null) return false;
        if (createTime != null ? !createTime.equals(metaSql.createTime) : metaSql.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sqlId != null ? sqlId.hashCode() : 0;
        result = 31 * result + (bussinessType != null ? bussinessType.hashCode() : 0);
        result = 31 * result + (sqlType != null ? sqlType.hashCode() : 0);
        result = 31 * result + (sqlContent != null ? sqlContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
