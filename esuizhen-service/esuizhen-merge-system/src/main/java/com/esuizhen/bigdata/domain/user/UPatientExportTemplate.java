package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_patient_export_template", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_patient_export_template_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UPatientExportTemplate {
    private String exportTemplateId;
    private int templateType;
    private long operator;
    private String heads;
    private String fields;
    private String exportSort;
    private String title;
    private String sqlContent;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "exportTemplateId", nullable = false, length = 60)
    public String getExportTemplateId() {
        return exportTemplateId;
    }

    public void setExportTemplateId(String exportTemplateId) {
        this.exportTemplateId = exportTemplateId;
    }

    @Basic
    @Column(name = "templateType", nullable = false)
    public int getTemplateType() {
        return templateType;
    }

    public void setTemplateType(int templateType) {
        this.templateType = templateType;
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
    @Column(name = "heads", nullable = false)
    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads;
    }

    @Basic
    @Column(name = "fields", nullable = false)
    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    @Basic
    @Column(name = "exportSort", nullable = true, length = 512)
    public String getExportSort() {
        return exportSort;
    }

    public void setExportSort(String exportSort) {
        this.exportSort = exportSort;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "sqlContent", nullable = false)
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

        UPatientExportTemplate that = (UPatientExportTemplate) o;

        if (templateType != that.templateType) return false;
        if (operator != that.operator) return false;
        if (exportTemplateId != null ? !exportTemplateId.equals(that.exportTemplateId) : that.exportTemplateId != null)
            return false;
        if (heads != null ? !heads.equals(that.heads) : that.heads != null) return false;
        if (fields != null ? !fields.equals(that.fields) : that.fields != null) return false;
        if (exportSort != null ? !exportSort.equals(that.exportSort) : that.exportSort != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (sqlContent != null ? !sqlContent.equals(that.sqlContent) : that.sqlContent != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exportTemplateId != null ? exportTemplateId.hashCode() : 0;
        result = 31 * result + templateType;
        result = 31 * result + (int) (operator ^ (operator >>> 32));
        result = 31 * result + (heads != null ? heads.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        result = 31 * result + (exportSort != null ? exportSort.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (sqlContent != null ? sqlContent.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
