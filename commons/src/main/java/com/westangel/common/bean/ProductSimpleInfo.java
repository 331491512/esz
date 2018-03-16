package com.westangel.common.bean;

import java.io.Serializable;

/**
 * 产品(服务）简要信息列表
 * @author YYCHEN
 *
 */
public class ProductSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private Integer productType;
	private String unitPrice;
	private Integer state;
	private Integer hospitalCertificateFlag;
	private Integer certificateFlag;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	/**
	 * @return the unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getHospitalCertificateFlag() {
		return hospitalCertificateFlag;
	}
	public void setHospitalCertificateFlag(Integer hospitalCertificateFlag) {
		this.hospitalCertificateFlag = hospitalCertificateFlag;
	}
	public Integer getCertificateFlag() {
		return certificateFlag;
	}
	public void setCertificateFlag(Integer certificateFlag) {
		this.certificateFlag = certificateFlag;
	}
}
