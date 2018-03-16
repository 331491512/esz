package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class ReviewRecordReq {
	/**
	 * 患者姓名
	 */
	private String patientName;
	/**
	 * 患者手机号
	 */
	private String mobile;
	/**
	 * 医生姓名
	 */
	private String appointDoctorName;
	/**
	 * 开始日期
	 */
	private Date beginDate;
	/**
	 * 结束日期
	 */
	private Date endDate;
	/**
	 * 预约结果状态
	 */
	private Integer appointResult;
	/**
	 * 页码
	 */
	private Integer page;
	/**
	 * 每页展示条数
	 */
	private Integer num;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 模板id
	 */
	private String exportTemplateId;
	private String outFilePath;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAppointDoctorName() {
		return appointDoctorName;
	}
	public void setAppointDoctorName(String appointDoctorName) {
		this.appointDoctorName = appointDoctorName;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getAppointResult() {
		return appointResult;
	}
	public void setAppointResult(Integer appointResult) {
		this.appointResult = appointResult;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getExportTemplateId() {
		return exportTemplateId;
	}
	public void setExportTemplateId(String exportTemplateId) {
		this.exportTemplateId = exportTemplateId;
	}
	public String getOutFilePath() {
		return outFilePath;
	}
	public void setOutFilePath(String outFilePath) {
		this.outFilePath = outFilePath;
	}
	
}
