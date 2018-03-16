package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/**
 * @ClassName: PatientReportResp
 * @Description: 检查检验
 * @author zhuguo
 * @date 2017-5-31 10:26:07
 */
public class PatientReportResp {

	// 患者id
	private Long patientId;

	// 当前页
	private Integer page;

	// 每页数量
	private Integer num;

	// 检验报告Id
	private String detectionReportId;

	// 检查报告id
	private String examReportId;

	// 申请日期
	private Date applyDate;

	// 内容
	private String content;

	// 报告类型
	private String reportType;

	// 医院id
	private Integer hospitalId;

	// 用来设置查询多少天内核多少天前数据
	private Integer days;

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDetectionReportId() {
		return detectionReportId;
	}

	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}

	public String getExamReportId() {
		return examReportId;
	}

	public void setExamReportId(String examReportId) {
		this.examReportId = examReportId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
