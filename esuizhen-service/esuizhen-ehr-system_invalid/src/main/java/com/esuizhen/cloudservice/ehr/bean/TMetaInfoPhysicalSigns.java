/**
 * @author: Da Loong
 * @date:   2016年4月7日 下午4:41:13
 */
package com.esuizhen.cloudservice.ehr.bean;

/** 元数据-体征
 * @author Da Loong
 * @date   2016年4月7日 下午4:41:13
 */
public class TMetaInfoPhysicalSigns {

	/** 
	 * 体征ID
	 */
	private int physicalSignsId;
	
	/**
	 * 体征名
	 */
	private String physicalSignsName;

	/**
	 * @return the physicalSignsId
	 */
	public int getPhysicalSignsId() {
		return physicalSignsId;
	}

	/**
	 * @param physicalSignsId the physicalSignsId to set
	 */
	public void setPhysicalSignsId(int physicalSignsId) {
		this.physicalSignsId = physicalSignsId;
	}

	/**
	 * @return the physicalSignsName
	 */
	public String getPhysicalSignsName() {
		return physicalSignsName;
	}

	/**
	 * @param physicalSignsName the physicalSignsName to set
	 */
	public void setPhysicalSignsName(String physicalSignsName) {
		this.physicalSignsName = physicalSignsName;
	}
	
	
}
