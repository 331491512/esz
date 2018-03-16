/**
 * @author: Da Loong
 * @date:   2016年4月9日 上午12:43:33
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-检验明细
 * @author Da Loong
 * @date   2016年4月9日 上午12:43:33
 */
public class TMetaInfoDetectionItem {

	/**
	 * 检验类型ID
	 */
	private int detectionTypeId;
	
	/**
	 * 检验项目Id
	 */
	private int detectionItemId;
	
	/**
	 * 检验项目名称
	 */
	private String detectionItemName;
	
	/**
	 * 检验项目英文名称
	 */
	private String detectionItemEnglishName;	
	
	/**
	 * 单位
	 */
	private String	unit;
	
	/**
	 * 参考范围（左值）
	 */
	private float refrenceRangeMin;
	
	/**
	 * 参考范围（右值）
	 */
	private	float refrenceRangeMax;

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
	 * @return the detectionItemId
	 */
	public int getDetectionItemId() {
		return detectionItemId;
	}

	/**
	 * @param detectionItemId the detectionItemId to set
	 */
	public void setDetectionItemId(int detectionItemId) {
		this.detectionItemId = detectionItemId;
	}

	/**
	 * @return the detectionItemName
	 */
	public String getDetectionItemName() {
		return detectionItemName;
	}

	/**
	 * @param detectionItemName the detectionItemName to set
	 */
	public void setDetectionItemName(String detectionItemName) {
		this.detectionItemName = detectionItemName;
	}

	/**
	 * @return the detectionItemEnglishName
	 */
	public String getDetectionItemEnglishName() {
		return detectionItemEnglishName;
	}

	/**
	 * @param detectionItemEnglishName the detectionItemEnglishName to set
	 */
	public void setDetectionItemEnglishName(String detectionItemEnglishName) {
		this.detectionItemEnglishName = detectionItemEnglishName;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the refrenceRangeMin
	 */
	public float getRefrenceRangeMin() {
		return refrenceRangeMin;
	}

	/**
	 * @param refrenceRangeMin the refrenceRangeMin to set
	 */
	public void setRefrenceRangeMin(float refrenceRangeMin) {
		this.refrenceRangeMin = refrenceRangeMin;
	}

	/**
	 * @return the refrenceRangeMax
	 */
	public float getRefrenceRangeMax() {
		return refrenceRangeMax;
	}

	/**
	 * @param refrenceRangeMax the refrenceRangeMax to set
	 */
	public void setRefrenceRangeMax(float refrenceRangeMax) {
		this.refrenceRangeMax = refrenceRangeMax;
	}
	
	

}
