package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoTumourPeriodization {

	/**
	 * 分期ID
	 */
	private Integer tumourId;
	
	/**
	 * 肿瘤分期编码
	 */
	private String tumourCode;
	
	/**
	 * 肿瘤分期编码T部分
	 */
	private String tumourCodeT;
	
	/**
	 * 肿瘤分期编码N部分
	 */
	private String tumourCodeN;
	
	/**
	 * 肿瘤分期编码M部分
	 */
	private String tumourCodeM1;
	
	/**
	 * 肿瘤分期编码M部分
	 */
	private String tumourCodeM2;

	public Integer getTumourId() {
		return tumourId;
	}

	public void setTumourId(Integer tumourId) {
		this.tumourId = tumourId;
	}

	public String getTumourCode() {
		return tumourCode;
	}

	public void setTumourCode(String tumourCode) {
		this.tumourCode = tumourCode;
	}

	public String getTumourCodeT() {
		return tumourCodeT;
	}

	public void setTumourCodeT(String tumourCodeT) {
		this.tumourCodeT = tumourCodeT;
	}

	public String getTumourCodeN() {
		return tumourCodeN;
	}

	public void setTumourCodeN(String tumourCodeN) {
		this.tumourCodeN = tumourCodeN;
	}

	public String getTumourCodeM1() {
		return tumourCodeM1;
	}

	public void setTumourCodeM1(String tumourCodeM1) {
		this.tumourCodeM1 = tumourCodeM1;
	}

	public String getTumourCodeM2() {
		return tumourCodeM2;
	}

	public void setTumourCodeM2(String tumourCodeM2) {
		this.tumourCodeM2 = tumourCodeM2;
	}
}
