package com.esuizhen.cloudservice.statistics.bean;

public class StatsExportReq {
	
	/**
	 * 导出模板id
	 */
	private String exportTemplateId;
	/**
	 * 导出标题
	 */
	private String title;
	/**
	 * searchid
	 */
	private Integer searchId;
	/**
	 * 电话/短信/微信search
	 */
	private Integer followupWaySearchId;
	/**
	 * 门诊/住院search
	 */
	private Integer outPatientFlagSearchId;
	/**
	 * 合计search
	 */
	private Integer followupWayTotalSearchId;
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public Integer getFollowupWaySearchId() {
		return followupWaySearchId;
	}
	public void setFollowupWaySearchId(Integer followupWaySearchId) {
		this.followupWaySearchId = followupWaySearchId;
	}
	public Integer getOutPatientFlagSearchId() {
		return outPatientFlagSearchId;
	}
	public void setOutPatientFlagSearchId(Integer outPatientFlagSearchId) {
		this.outPatientFlagSearchId = outPatientFlagSearchId;
	}
	public Integer getFollowupWayTotalSearchId() {
		return followupWayTotalSearchId;
	}
	public void setFollowupWayTotalSearchId(Integer followupWayTotalSearchId) {
		this.followupWayTotalSearchId = followupWayTotalSearchId;
	}
}
