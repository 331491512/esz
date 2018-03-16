package com.esuizhen.cloudservice.ehr.model.medicalRecord;

import java.util.Date;

public class ExamReportDetail {
	private String examReportDetailId;

	private String examReportId;

	private Integer seqNo;

	private String organCode;

	private String organ;

	private String nidusCode;

	private String nidus;

	private Integer nidusSourceFlag;

	private Float longestDiameter;

	private Float shortestDiameter;

	private Integer flag;

	private Date createTime;

	private Date updateTime;

	private Integer isDelete;

	public String getExamReportDetailId() {
		return examReportDetailId;
	}

	public void setExamReportDetailId(String examReportDetailId) {
		this.examReportDetailId = examReportDetailId;
	}

	public String getExamReportId() {
		return examReportId;
	}

	public void setExamReportId(String examReportId) {
		this.examReportId = examReportId;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getNidusCode() {
		return nidusCode;
	}

	public void setNidusCode(String nidusCode) {
		this.nidusCode = nidusCode;
	}

	public String getNidus() {
		return nidus;
	}

	public void setNidus(String nidus) {
		this.nidus = nidus;
	}

	public Integer getNidusSourceFlag() {
		return nidusSourceFlag;
	}

	public void setNidusSourceFlag(Integer nidusSourceFlag) {
		this.nidusSourceFlag = nidusSourceFlag;
	}

	public Float getLongestDiameter() {
		return longestDiameter;
	}

	public void setLongestDiameter(Float longestDiameter) {
		this.longestDiameter = longestDiameter;
	}

	public Float getShortestDiameter() {
		return shortestDiameter;
	}

	public void setShortestDiameter(Float shortestDiameter) {
		this.shortestDiameter = shortestDiameter;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}