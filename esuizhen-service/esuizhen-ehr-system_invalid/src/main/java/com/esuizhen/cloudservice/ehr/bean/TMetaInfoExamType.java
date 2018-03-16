/**
 * @author: Da Loong
 * @date:   2016年4月8日 上午9:46:58
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-检查类型
 * @author Da Loong
 * @date   2016年4月8日 上午9:46:58
 */
public class TMetaInfoExamType {

	private int parentId;
	
	/**
	 * 检查类型ID
	 */
	private int examTypeId;
	
	/**
	 * 检查类型名称
	 */
	private String examTypeName;

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the examTypeId
	 */
	public int getExamTypeId() {
		return examTypeId;
	}

	/**
	 * @param examTypeId the examTypeId to set
	 */
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}

	/**
	 * @return the examTypeName
	 */
	public String getExamTypeName() {
		return examTypeName;
	}

	/**
	 * @param examTypeName the examTypeName to set
	 */
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	
	

}
