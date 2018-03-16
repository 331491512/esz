package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultQualityoflifeInfo{
	
	/**
	 * 生存质量结果ID。
	 */
	private String crfQolResultId;
	/**
	 * Crf结果ID。
	 */
	private String crfResultId;
	//量表ID
	private Integer scaleId;
	//评分
	private Integer score;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	//QOL分值
	private Integer QOLScore;
	public Integer getQOLScore() {
		return QOLScore;
	}
	public void setQOLScore(Integer qOLScore) {
		QOLScore = qOLScore;
	}
	public Integer getScaleId() {
		return scaleId;
	}
	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getCrfQolResultId() {
		return crfQolResultId;
	}
	public void setCrfQolResultId(String crfQolResultId) {
		this.crfQolResultId = crfQolResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
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
}

