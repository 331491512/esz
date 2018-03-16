package com.esuizhen.cloudservice.statistics.bean;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 11:18:10
 */
public class DataQualityTbFieldStatisticsRes {

	// 随内系统和中间库通用字段////////////////////////////////////////////////
	// 字段名称
	private String fieldDisplayName;

	// 随内系统字段
	// 总数量
	private String totalNum = "0";

	// 空值数量
	private String emptyValueNum = "0";

	// 非空值数量
	private String notEmptyValueNum = "0";

	// 错误数据数量
	private String invalidDataNum = "0";

	// 中间库字段
	// 总数量
	private String totalNum1 = "0";

	// 空值数量
	private String emptyValueNum1 = "0";

	// 非空值数量
	private String notEmptyValueNum1 = "0";

	// 错误数据数量
	private String invalidDataNum1 = "0";

	public String getFieldDisplayName() {
		return fieldDisplayName;
	}

	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getEmptyValueNum() {
		return emptyValueNum;
	}

	public void setEmptyValueNum(String emptyValueNum) {
		this.emptyValueNum = emptyValueNum;
	}

	public String getNotEmptyValueNum() {
		return notEmptyValueNum;
	}

	public void setNotEmptyValueNum(String notEmptyValueNum) {
		this.notEmptyValueNum = notEmptyValueNum;
	}

	public String getInvalidDataNum() {
		return invalidDataNum;
	}

	public void setInvalidDataNum(String invalidDataNum) {
		this.invalidDataNum = invalidDataNum;
	}

	public String getTotalNum1() {
		return totalNum1;
	}

	public void setTotalNum1(String totalNum1) {
		this.totalNum1 = totalNum1;
	}

	public String getEmptyValueNum1() {
		return emptyValueNum1;
	}

	public void setEmptyValueNum1(String emptyValueNum1) {
		this.emptyValueNum1 = emptyValueNum1;
	}

	public String getNotEmptyValueNum1() {
		return notEmptyValueNum1;
	}

	public void setNotEmptyValueNum1(String notEmptyValueNum1) {
		this.notEmptyValueNum1 = notEmptyValueNum1;
	}

	public String getInvalidDataNum1() {
		return invalidDataNum1;
	}

	public void setInvalidDataNum1(String invalidDataNum1) {
		this.invalidDataNum1 = invalidDataNum1;
	}

}
