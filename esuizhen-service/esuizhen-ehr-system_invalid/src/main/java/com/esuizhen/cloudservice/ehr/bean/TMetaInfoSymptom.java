/**
 * @author: Da Loong
 * @date:   2016年4月11日 下午11:38:30
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-临床症状
 * @author Da Loong
 * @date   2016年4月11日 下午11:38:30
 */
public class TMetaInfoSymptom {

	/**
	 * ID
	 */
	private int  symptomId;	
	
	/**
	 * 症状名称
	 */
	private String symptomName;
	
	/**
	 * 轻微症状描述
	 */
	private String slightDescription;
	
	/**
	 * 中度症状描述
	 */
	private String mediumDescription;
	
	/**
	 * 重度症状描述
	 */
	private String severeDescription;

	/**
	 * @return the symptomId
	 */
	public int getSymptomId() {
		return symptomId;
	}

	/**
	 * @param symptomId the symptomId to set
	 */
	public void setSymptomId(int symptomId) {
		this.symptomId = symptomId;
	}

	/**
	 * @return the symptomName
	 */
	public String getSymptomName() {
		return symptomName;
	}

	/**
	 * @param symptomName the symptomName to set
	 */
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	/**
	 * @return the slightDescription
	 */
	public String getSlightDescription() {
		return slightDescription;
	}

	/**
	 * @param slightDescription the slightDescription to set
	 */
	public void setSlightDescription(String slightDescription) {
		this.slightDescription = slightDescription;
	}

	/**
	 * @return the mediumDescription
	 */
	public String getMediumDescription() {
		return mediumDescription;
	}

	/**
	 * @param mediumDescription the mediumDescription to set
	 */
	public void setMediumDescription(String mediumDescription) {
		this.mediumDescription = mediumDescription;
	}

	/**
	 * @return the severeDescription
	 */
	public String getSevereDescription() {
		return severeDescription;
	}

	/**
	 * @param severeDescription the severeDescription to set
	 */
	public void setSevereDescription(String severeDescription) {
		this.severeDescription = severeDescription;
	}
	
	

}
