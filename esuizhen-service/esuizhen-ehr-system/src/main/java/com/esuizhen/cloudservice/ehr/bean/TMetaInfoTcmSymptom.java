/**
 * @author: Da Loong
 * @date:   2016年4月12日 下午6:20:31
 */
package com.esuizhen.cloudservice.ehr.bean;

/**
 * 元数据-中医症候
 * @author Da Loong
 * @date   2016年4月12日 下午6:20:31
 */
public class TMetaInfoTcmSymptom {

	/**
	 * ID
	 */
	private int  tcmSymptomId;	
	
	/**
	 * ICD-10 编码
	 */
	private String diseaseCode;
	
	/**
	 * 中医症候名称
	 */
	private String tcmSymptomName;

	/**
	 * @return the tcmSymptomId
	 */
	public int getTcmSymptomId() {
		return tcmSymptomId;
	}

	/**
	 * @param tcmSymptomId the tcmSymptomId to set
	 */
	public void setTcmSymptomId(int tcmSymptomId) {
		this.tcmSymptomId = tcmSymptomId;
	}

	/**
	 * @return the diseaseCode
	 */
	public String getDiseaseCode() {
		return diseaseCode;
	}

	/**
	 * @param diseaseCode the diseaseCode to set
	 */
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	/**
	 * @return the tcmSymptomName
	 */
	public String getTcmSymptomName() {
		return tcmSymptomName;
	}

	/**
	 * @param tcmSymptomName the tcmSymptomName to set
	 */
	public void setTcmSymptomName(String tcmSymptomName) {
		this.tcmSymptomName = tcmSymptomName;
	}
	
	

}
