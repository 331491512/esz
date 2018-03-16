package com.esuizhen.cloudservice.statistics.bean;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 11:18:10
 */
public class DataQualityTbFieldStatisticsReq {

	// 查询的条件////////////////////////////////////////////////////////////

	// 开始时间
	private String beginDate;

	// 结束时间
	private String endDate;

	// 数据库名
	private String databaseName;

	// 表名
	private String tableName;

	// 院内系统动态表名
	private String tobDynamicTabName;

	// 中间库动态表名
	private String middleDynamicTabName;

	// 检索条件。比如：1-患者信息
	private String condition;

	// data_quality_tbfield_statistics_search的MD5列
	private String searchMd5;

	// 数量-用来判断表是否存在
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSearchMd5() {
		return searchMd5;
	}

	public void setSearchMd5(String searchMd5) {
		this.searchMd5 = searchMd5;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTobDynamicTabName() {
		return tobDynamicTabName;
	}

	public void setTobDynamicTabName(String tobDynamicTabName) {
		this.tobDynamicTabName = tobDynamicTabName;
	}

	public String getMiddleDynamicTabName() {
		return middleDynamicTabName;
	}

	public void setMiddleDynamicTabName(String middleDynamicTabName) {
		this.middleDynamicTabName = middleDynamicTabName;
	}

}
