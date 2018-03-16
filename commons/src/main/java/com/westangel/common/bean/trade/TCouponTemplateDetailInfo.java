/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>TCouponTemplateDetailInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月30日下午6:22:23<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/** 
* @ClassName: TCouponTemplateDetailInfo
* @Description: 
* @author lichenghao
* @date 2016年6月30日 下午6:22:23  
*/
public class TCouponTemplateDetailInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String couponTemplateId;
	private String couponTemplateName;
	private Integer couponType;
	private Float couponNumber;
	private Integer isPayment;
	private Integer validity;
	private String cycle;
	private Float maxPrice;
	private String backimage;
	private String typeName;
	private Float minOrderPrice;
	private Integer isCouponRed;
	private Integer shareNum;
	private Integer superpositionNum;
	private Integer requirementType;
	private String cityCodes;
	private String hospitalIds;
	private String diseaseCodes;
	private String productTypes;
	private Integer state;
	private String remark;
	public String getCouponTemplateId() {
		return couponTemplateId;
	}
	public void setCouponTemplateId(String couponTemplateId) {
		this.couponTemplateId = couponTemplateId;
	}
	public String getCouponTemplateName() {
		return couponTemplateName;
	}
	public void setCouponTemplateName(String couponTemplateName) {
		this.couponTemplateName = couponTemplateName;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Float getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Float couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public Float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getBackimage() {
		return backimage;
	}
	public void setBackimage(String backimage) {
		this.backimage = backimage;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Float getMinOrderPrice() {
		return minOrderPrice;
	}
	public void setMinOrderPrice(Float minOrderPrice) {
		this.minOrderPrice = minOrderPrice;
	}
	public Integer getIsCouponRed() {
		return isCouponRed;
	}
	public void setIsCouponRed(Integer isCouponRed) {
		this.isCouponRed = isCouponRed;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public Integer getSuperpositionNum() {
		return superpositionNum;
	}
	public void setSuperpositionNum(Integer superpositionNum) {
		this.superpositionNum = superpositionNum;
	}
	public Integer getRequirementType() {
		return requirementType;
	}
	public void setRequirementType(Integer requirementType) {
		this.requirementType = requirementType;
	}
	public String getCityCodes() {
		return cityCodes;
	}
	public void setCityCodes(String cityCodes) {
		this.cityCodes = cityCodes;
	}
	public String getHospitalIds() {
		return hospitalIds;
	}
	public void setHospitalIds(String hospitalIds) {
		this.hospitalIds = hospitalIds;
	}
	public String getDiseaseCodes() {
		return diseaseCodes;
	}
	public void setDiseaseCodes(String diseaseCodes) {
		this.diseaseCodes = diseaseCodes;
	}
	public String getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(String productTypes) {
		this.productTypes = productTypes;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
