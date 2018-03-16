package com.esuizhen.cloudservice.statistics.model;

public class TStatsExportTemplateInfo {
	/**
	 * 
	 */
	private String exportTemplateId;
	/**
	 * 导出表头信息
	 */
	private String titles;
	/**
	 * 模板标题
	 */
	private String subject;
	/**
	 * 对应的excel文件名前缀。如“工作量统计”。最后的生成的文件名按 filename_操作员姓名_YYYYMMDDHHMMSS+nnnnnn(六位随机数)
	 */
	private String filename;
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
