package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultTreatmentRadiotherapyDetail{
	
	/**
	 * 放疗明细结果ID
	 */
	private String crfTreatmentRadiotherapyResultDetailId;
	/**
	 * 放疗结果ID
	 */
	private String crfTreatmentRadiotherapyResultId;
	/**
	 * 放疗部位
	 */
	private Integer radiotherapyBodyPart;
	/**
	 * 放疗部位名称
	 */
	private String radiotherapyPartName;
	/**
	 * 总剂量
	 */
	private Float totalDose;
	/**
	 * 单次剂量
	 */
	private Float singleDose;
	/**
	 * 总次数
	 */
	private Integer counts;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getRadiotherapyPartName() {
		return radiotherapyPartName;
	}

	public void setRadiotherapyPartName(String radiotherapyPartName) {
		this.radiotherapyPartName = radiotherapyPartName;
	}

	public void setCrfTreatmentRadiotherapyResultDetailId(String crfTreatmentRadiotherapyResultDetailId) {
		this.crfTreatmentRadiotherapyResultDetailId = crfTreatmentRadiotherapyResultDetailId;
	}
	
	public String getCrfTreatmentRadiotherapyResultDetailId() {
		return this.crfTreatmentRadiotherapyResultDetailId;
	}
	public void setCrfTreatmentRadiotherapyResultId(String crfTreatmentRadiotherapyResultId) {
		this.crfTreatmentRadiotherapyResultId = crfTreatmentRadiotherapyResultId;
	}
	
	public String getCrfTreatmentRadiotherapyResultId() {
		return this.crfTreatmentRadiotherapyResultId;
	}
	public void setRadiotherapyBodyPart(Integer radiotherapyBodyPart) {
		this.radiotherapyBodyPart = radiotherapyBodyPart;
	}
	
	public Integer getRadiotherapyBodyPart() {
		return this.radiotherapyBodyPart;
	}
	public void setTotalDose(Float totalDose) {
		this.totalDose = totalDose;
	}
	
	public Float getTotalDose() {
		return this.totalDose;
	}
	public void setSingleDose(Float singleDose) {
		this.singleDose = singleDose;
	}
	
	public Float getSingleDose() {
		return this.singleDose;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	public Integer getCounts() {
		return this.counts;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public Date getBeginTime() {
		return this.beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}


}

