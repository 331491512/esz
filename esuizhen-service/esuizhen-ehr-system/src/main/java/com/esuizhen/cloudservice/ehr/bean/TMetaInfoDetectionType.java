/**
 * @author: Da Loong
 * @date:   2016年4月9日 上午12:38:12
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-检验类型
 * @author Da Loong
 * @date   2016年4月9日 上午12:38:12
 */
public class TMetaInfoDetectionType {

	private int parentId;
	
	/**
	 * 检验类型ID
	 */
	private int detectionTypeId;
	
	/**
	 * 检查类型名称
	 */
	private String detectionTypeName;

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
	 * @return the detectionTypeId
	 */
	public int getDetectionTypeId() {
		return detectionTypeId;
	}

	/**
	 * @param detectionTypeId the detectionTypeId to set
	 */
	public void setDetectionTypeId(int detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}

	/**
	 * @return the detectionTypeName
	 */
	public String getDetectionTypeName() {
		return detectionTypeName;
	}

	/**
	 * @param detectionTypeName the detectionTypeName to set
	 */
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	
	
	
}
