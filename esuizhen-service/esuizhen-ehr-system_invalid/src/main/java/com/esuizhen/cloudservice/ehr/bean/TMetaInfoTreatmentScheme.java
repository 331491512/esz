/**
 * @author: Da Loong
 * @date:   2016年4月14日 下午2:18:53
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * @author Da Loong
 * @date   2016年4月14日 下午2:18:53
 */
public class TMetaInfoTreatmentScheme {

	/**
	 * 方案Id
	 */
	private int treatmentSchemeId;
	
	/**
	 * 方案名
	 */
	private String treatmentSchemeName;
	
	/**
	 * 治疗周期（周）
	 */
	private int treatmentPeriod;
	
	/**
	 * 治疗类型
	 */
	private int treatmentTypeId;
	
	private Integer metaDataType; // 方案是否是元数据
	

	public Integer getMetaDataType() {
		return metaDataType;
	}

	public void setMetaDataType(Integer metaDataType) {
		this.metaDataType = metaDataType;
	}

	/**
	 * @return the treatmentSchemaId
	 */
	public int getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	/**
	 * @param treatmentSchemaId the treatmentSchemaId to set
	 */
	public void setTreatmentSchemeId(int treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	/**
	 * @return the treatmentSchemeName
	 */
	public String getTreatmentSchemeName() {
		return treatmentSchemeName;
	}

	/**
	 * @param treatmentSchemeName the treatmentSchemeName to set
	 */
	public void setTreatmentSchemeName(String treatmentSchemeName) {
		this.treatmentSchemeName = treatmentSchemeName;
	}

	/**
	 * @return the treatmentPeriod
	 */
	public int getTreatmentPeriod() {
		return treatmentPeriod;
	}

	/**
	 * @param treatmentPeriod the treatmentPeriod to set
	 */
	public void setTreatmentPeriod(int treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}

	/**
	 * @return the treatmentTypeId
	 */
	public int getTreatmentTypeId() {
		return treatmentTypeId;
	}

	/**
	 * @param treatmentTypeId the treatmentTypeId to set
	 */
	public void setTreatmentTypeId(int treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}
	
	

}
