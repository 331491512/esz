package com.esuizhen.cloudservice.statistics.model;

import java.util.Date;

public class TRetrievalParamentMould {
	/*
	 * Id主键，格式：
		MOIDYYYYMMDDHHMMSSnnnnnn。
	 */
	private String mouldId;
	//模板名称
	private String mouldName;
	//参数内容
	private String paramentContent;
	// 对照参数内容
	private String compareContent;
	// 模板类型。默认0-普通检索，1-对比检索
	private Integer mouldType;
	//用户的userid
	private Long userId;
	//记录生成时间 
	private Date createTime;
	
	public Integer getMouldType() {
		return mouldType;
	}
	public void setMouldType(Integer mouldType) {
		this.mouldType = mouldType;
	}
	public String getCompareContent() {
		return compareContent;
	}
	public void setCompareContent(String compareContent) {
		this.compareContent = compareContent;
	}
	public String getMouldId() {
		return mouldId;
	}
	public void setMouldId(String mouldId) {
		this.mouldId = mouldId;
	}
	public String getMouldName() {
		return mouldName;
	}
	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}
	public String getParamentContent() {
		return paramentContent;
	}
	public void setParamentContent(String paramentContent) {
		this.paramentContent = paramentContent;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
