package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "e_search_template_result", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "e_search_template_result_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class ESearchTemplateResult {
    private Integer templateId;
    private String templateName;
    private String bussinessType;
    private Integer sqlId;
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "templateId", nullable = false)
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "templateName", nullable = false, length = 255)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "bussinessType", nullable = false, length = 255)
    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    @Basic
    @Column(name = "sqlId", nullable = false)
    public Integer getSqlId() {
        return sqlId;
    }

    public void setSqlId(Integer sqlId) {
        this.sqlId = sqlId;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
    @Column(name = "updateTime", nullable = false)
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

        ESearchTemplateResult that = (ESearchTemplateResult) o;

        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (bussinessType != null ? !bussinessType.equals(that.bussinessType) : that.bussinessType != null)
            return false;
        if (sqlId != null ? !sqlId.equals(that.sqlId) : that.sqlId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId != null ? templateId.hashCode() : 0;
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (bussinessType != null ? bussinessType.hashCode() : 0);
        result = 31 * result + (sqlId != null ? sqlId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
