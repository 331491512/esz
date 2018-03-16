package com.esuizhen.cloudservice.user.bean.followuppatient;

public class TwiceSearchReq {
	public TwiceSearchReq(){
		this.page = 0;
		this.num = 10;
	}
	
	/**
	 * 查询编号
	 */
	private Integer searchId;
	/**
	 * 条件编号
	 */
	private Integer conditionId;
	/**
	 * 分页索引，从0开始
	 */
	private Integer page;
	/**
	 * 每页个数
	 */
	private Integer num;
	
	/**
	 * 点击类型
	 */
	private Integer clickType;
	
	private Integer userRole;
	
	private Integer operator;
	
	private Integer actionType;
	
	private Integer dataId;
	
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
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
	public Integer getClickType() {
		return clickType;
	}
	public void setClickType(Integer clickType) {
		this.clickType = clickType;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public Integer getActionType() {
		return actionType;
	}
	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}
	public Integer getDataId() {
		return dataId;
	}
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	
}
