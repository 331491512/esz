package com.esuizhen.cloudservice.followup.model.review;

import java.util.Date;

public class TPatientExportTemplateInfo {
    private String exportTemplateId;

    private Integer templateType;

    private Long operator;

    private String heads;

    private String fields;

    private String exportSort;

    private String title;

    private String sqlContent;

    private Date createTime;

    private Date updateTime;

    public String getExportTemplateId() {
        return exportTemplateId;
    }

    public void setExportTemplateId(String exportTemplateId) {
        this.exportTemplateId = exportTemplateId;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads;
    }

    public String getExportSort() {
        return exportSort;
    }

    public void setExportSort(String exportSort) {
        this.exportSort = exportSort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSqlContent() {
        return sqlContent;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
    
}