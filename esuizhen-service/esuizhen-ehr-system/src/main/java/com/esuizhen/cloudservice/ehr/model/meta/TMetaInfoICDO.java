package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoICDO {

	/**
	 * 肿瘤部位id
	 */
	private Integer organId;

	/**
	 * 肿瘤部位编码
	 */
	private String organCode;

	/**
	 * 肿瘤部位名称
	 */
	private String organName;

	/**
	 * 助记词
	 */
	private String mnemonicCode;
	
	public Integer getOrganId() {
		return organId;
	}
	public void setOrganId(Integer organId) {
		this.organId = organId;
	}
	public String getOrganCode() {
		return organCode;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getMnemonicCode() {
		return mnemonicCode;
	}
	public void setMnemonicCode(String mnemonicCode) {
		this.mnemonicCode = mnemonicCode;
	}
	
}
