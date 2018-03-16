/**
 * 
 * @author Da Loong
 * @date  2016年6月3日 上午12:57:20
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author Da Loong
 * @date  2016年6月3日 上午12:57:20
 */
public class THospitalProductInfo {

	private Long userId;
	
	private String  productId;
	
	private  Integer hospitalCertificateFlag;
	
	private  Integer certificateFlag;
	
	private  Float unitPrice;
	
	private  String expressPrice;//快递费用，一段json文本。前端进行解析
	
	private int   expressCompanyId;//快递公司Id

	
	
	/**
	 * @return the unitPrice
	 */
	public Float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the expressPrice
	 */
	public String getExpressPrice() {
		return expressPrice;
	}

	/**
	 * @param expressPrice the expressPrice to set
	 */
	public void setExpressPrice(String expressPrice) {
		this.expressPrice = expressPrice;
	}

	/**
	 * @return the expressCompanyId
	 */
	public int getExpressCompanyId() {
		return expressCompanyId;
	}

	/**
	 * @param expressCompanyId the expressCompanyId to set
	 */
	public void setExpressCompanyId(int expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the hospitalCertificateFlag
	 */
	public Integer getHospitalCertificateFlag() {
		return hospitalCertificateFlag;
	}

	/**
	 * @param hospitalCertificateFlag the hospitalCertificateFlag to set
	 */
	public void setHospitalCertificateFlag(Integer hospitalCertificateFlag) {
		this.hospitalCertificateFlag = hospitalCertificateFlag;
	}

	/**
	 * @return the certificateFlag
	 */
	public Integer getCertificateFlag() {
		return certificateFlag;
	}

	/**
	 * @param certificateFlag the certificateFlag to set
	 */
	public void setCertificateFlag(Integer certificateFlag) {
		this.certificateFlag = certificateFlag;
	}

	
	
}
