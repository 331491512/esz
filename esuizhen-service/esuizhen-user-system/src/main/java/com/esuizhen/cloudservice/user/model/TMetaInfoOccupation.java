package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;

/**
 * <p>Title:TMetaInfoOccupation</p>
 * <p>Description:职业元数据bean</p>
 * @author YYCHEN
 * @date 2016年6月23日 上午11:15:53
 */
public class TMetaInfoOccupation implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer occupationId;
	//职业代码
	private String occupationCode;
	//职业上级代码
	private String parentCode;
	//职业名称
	private String occupationName;
	//职业描述
	private String description;
	public Integer getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
