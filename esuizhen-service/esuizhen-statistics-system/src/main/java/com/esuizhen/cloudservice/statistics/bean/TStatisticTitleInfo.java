package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.List;

public class TStatisticTitleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//取值ID
	private String id;
	//列头展示的内容
	private String name;
	//该列所展示值得类型。1：数字，2:：文本，3：日期，4：链接
	private Integer type;
	//该列头所占行数
	private Integer rows;
	//该列头所占列数
	private Integer cols;
	//该列头的子列头列表
	private List<TStatisticTitleInfo> subTitles;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getCols() {
		return cols;
	}
	public void setCols(Integer cols) {
		this.cols = cols;
	}
	public List<TStatisticTitleInfo> getSubTitles() {
		return subTitles;
	}
	public void setSubTitles(List<TStatisticTitleInfo> subTitles) {
		this.subTitles = subTitles;
	}
}
