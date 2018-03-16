/**
 * 
 * @author Da Loong
 * @date  2016年6月2日 下午12:33:35
 */
package com.westangel.commonservice.trade.bean;

import java.util.Date;

/**
 * @author Da Loong
 * @date  2016年6月2日 下午12:33:35
 */
public class TProductTemplateInfo {

	private String productTemplateId;
	
	private String productTemplateName;
	
	private Integer productType;
	
	private Float refPrice;
	
	private String introduction;
	
	private String remark;
	
	private Integer hospitalCertificateFlag;
	
	private Integer  certificateFlag;
	
	private Date createTime;

	/**
	 * @return the productTemplateId
	 */
	public String getProductTemplateId() {
		return productTemplateId;
	}

	/**
	 * @param productTemplateId the productTemplateId to set
	 */
	public void setProductTemplateId(String productTemplateId) {
		this.productTemplateId = productTemplateId;
	}

	/**
	 * @return the productTemplateName
	 */
	public String getProductTemplateName() {
		return productTemplateName;
	}

	/**
	 * @param productTemplateName the productTemplateName to set
	 */
	public void setProductTemplateName(String productTemplateName) {
		this.productTemplateName = productTemplateName;
	}

	/**
	 * @return the productType
	 */
	public Integer getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	/**
	 * @return the refPrice
	 */
	public Float getRefPrice() {
		return refPrice;
	}

	/**
	 * @param refPrice the refPrice to set
	 */
	public void setRefPrice(Float refPrice) {
		this.refPrice = refPrice;
	}

	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
