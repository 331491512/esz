package com.esuizhen.cloudservice.ehr.model.meta;


public class TMetaInfotreatmentHistory{
	
	/**
	 * 既往治疗ID
	 */
	private Integer treatmentHistoryId;
	/**
	 * 既往治疗代码
	 */
	private String treatmentHistoryCode;
	/**
	 * 既往治疗名称
	 */
	private String treatmentHistoryName;

	public void setTreatmentHistoryId(Integer treatmentHistoryId) {
		this.treatmentHistoryId = treatmentHistoryId;
	}
	
	public Integer getTreatmentHistoryId() {
		return this.treatmentHistoryId;
	}
	public void setTreatmentHistoryCode(String treatmentHistoryCode) {
		this.treatmentHistoryCode = treatmentHistoryCode;
	}
	
	public String getTreatmentHistoryCode() {
		return this.treatmentHistoryCode;
	}
	public void setTreatmentHistoryName(String treatmentHistoryName) {
		this.treatmentHistoryName = treatmentHistoryName;
	}
	
	public String getTreatmentHistoryName() {
		return this.treatmentHistoryName;
	}


}

