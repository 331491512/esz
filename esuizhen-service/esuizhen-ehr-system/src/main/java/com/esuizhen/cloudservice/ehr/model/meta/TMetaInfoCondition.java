package com.esuizhen.cloudservice.ehr.model.meta;

import java.util.Date;
import java.util.List;


public class TMetaInfoCondition
{
	/**
	 * 条件ID
	 */
	private Integer conditionId;
	/**
	 * 业务类型如
	 */
	private String bussinessType;
	/**
	 * 显示名字
	 */
	private String showName;
	/**
	 * 列名
	 */
	private String cloumnName;
	/**
	 * 开始符号
	 */
	private String startSymbol;
	/**
	 * 结束符号
	 */
	private String endSymbol;
	/**
	 * 父条件ID
	 */
	private Integer parentId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 是否连接
	 */
	private Integer isConnection;
	
	/**
	 * 条件特殊描述
	 */
	private String specialDesc;

	/**
	 * 数据类型
	 */
	private String conditionType;
	/**
	 * 条件列表
	 */
	private List<TMetaInfoCondition> conditionList;

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	
	public Integer getConditionId() {
		return this.conditionId;
	}
	public void setBussinessType(String bussinessType) {
		this.bussinessType = bussinessType;
	}
	
	public String getBussinessType() {
		return this.bussinessType;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	public String getShowName() {
		return this.showName;
	}
	public void setCloumnName(String cloumnName) {
		this.cloumnName = cloumnName;
	}
	
	public String getCloumnName() {
		return this.cloumnName;
	}
	public void setStartSymbol(String startSymbol) {
		this.startSymbol = startSymbol;
	}
	
	public String getStartSymbol() {
		return this.startSymbol;
	}
	public void setEndSymbol(String endSymbol) {
		this.endSymbol = endSymbol;
	}
	
	public String getEndSymbol() {
		return this.endSymbol;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getParentId() {
		return this.parentId;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}

	public List<TMetaInfoCondition> getConditionList()
	{
		return conditionList;
	}

	public void setConditionList(List<TMetaInfoCondition> conditionList)
	{
		this.conditionList = conditionList;
	}

	public Integer getIsConnection()
	{
		return isConnection;
	}

	public void setIsConnection(Integer isConnection)
	{
		this.isConnection = isConnection;
	}

	public String getSpecialDesc()
	{
		return specialDesc;
	}

	public void setSpecialDesc(String specialDesc)
	{
		this.specialDesc = specialDesc;
	}

	public String getConditionType()
	{
		return conditionType;
	}

	public void setConditionType(String conditionType)
	{
		this.conditionType = conditionType;
	}
	
	
}

