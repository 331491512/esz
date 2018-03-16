package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoAnesthesiaWay {

	/**
	 * 麻醉方式ID
	 */
	private Integer anesthesiaId;
	
	/**
	 * 麻醉方式编码
	 */
	private String anesthesiaCode;
	
	/**
	 * 麻醉方式名称
	 */
	private String anesthesiaName;

	public Integer getAnesthesiaId() {
		return anesthesiaId;
	}

	public void setAnesthesiaId(Integer anesthesiaId) {
		this.anesthesiaId = anesthesiaId;
	}

	public String getAnesthesiaCode() {
		return anesthesiaCode;
	}

	public void setAnesthesiaCode(String anesthesiaCode) {
		this.anesthesiaCode = anesthesiaCode;
	}

	public String getAnesthesiaName() {
		return anesthesiaName;
	}

	public void setAnesthesiaName(String anesthesiaName) {
		this.anesthesiaName = anesthesiaName;
	}
	
	
}
