package com.esuizhen.cloudservice.followup.bean;

public class PatientExportTemplate {
	private String exportTemplateId;
	private Integer templateType;
	private String heads;
	private String fields;
	private String exportSort;
	private String title;
	private String sqlContent;
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
	public String getHeads() {
		return heads;
	}
	public void setHeads(String heads) {
		this.heads = heads;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
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
	
}
