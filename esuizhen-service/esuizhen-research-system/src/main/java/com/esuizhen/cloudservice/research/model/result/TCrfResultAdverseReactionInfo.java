package com.esuizhen.cloudservice.research.model.result;

import java.util.Date;


public class TCrfResultAdverseReactionInfo{
	
	/**
	 * 不良反应结果ID
	 */
	private String crfAdverseReactionResultId;
	/**
	 * Crf结果ID
	 */
	private String crfResultId;
	/**
	 * 不良反应Id
	 */
	private Integer adverseReactionId;
	/**
	 * 不良反应名称
	 */
	private String adverseReactionName;
	/**
	 * 程度等级
	 */
	private Integer level;
	/**
	 * 采取措施
	 */
	private String takeSteps;
	/**
	 * 与研究关系
	 */
	private String researchRelationship;
	/**
	 * 转归
	 */
	private String theOutcome;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	//排序索引
	private Integer index;
	/**
	 * 创建时间（单据上传时间）
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCrfAdverseReactionResultId(String crfAdverseReactionResultId) {
		this.crfAdverseReactionResultId = crfAdverseReactionResultId;
	}
	
	public String getCrfAdverseReactionResultId() {
		return this.crfAdverseReactionResultId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	
	public String getCrfResultId() {
		return this.crfResultId;
	}
	public void setAdverseReactionId(Integer adverseReactionId) {
		this.adverseReactionId = adverseReactionId;
	}
	
	public Integer getAdverseReactionId() {
		return this.adverseReactionId;
	}
	public void setAdverseReactionName(String adverseReactionName) {
		this.adverseReactionName = adverseReactionName;
	}
	
	public String getAdverseReactionName() {
		return this.adverseReactionName;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	public void setTakeSteps(String takeSteps) {
		this.takeSteps = takeSteps;
	}
	
	public String getTakeSteps() {
		return this.takeSteps;
	}
	public void setResearchRelationship(String researchRelationship) {
		this.researchRelationship = researchRelationship;
	}
	
	public String getResearchRelationship() {
		return this.researchRelationship;
	}
	public void setTheOutcome(String theOutcome) {
		this.theOutcome = theOutcome;
	}
	
	public String getTheOutcome() {
		return this.theOutcome;
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

