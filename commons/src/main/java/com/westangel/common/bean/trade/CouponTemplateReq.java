/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>CouponTemplateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月28日下午4:08:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: CouponTemplateReq
* @Description: 
* @author lichenghao
* @date 2016年6月28日 下午4:08:32  
*/
public class CouponTemplateReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//优惠券模版ID
	private String couponTemplateId;
	//优惠券名称
	private String couponTemplateName;
	//抵扣券类型 1.现金券 2.折扣券
	private Integer couponType;
	//抵扣金额
	private	Integer couponNumber;
	//是否默认领取 0：否（默认）1：是
	private Integer isPayment;
	//有效期  
	private Integer validity;
	//周期 day week month year
	private String cycle;
	//最大抵扣金额
	private Float maxPrice;
	//背景图片
	private String backimage;
	//类型
	private String typeName;
	//订单最小金额
	private Float minOrderPrice;
	//是否可抵用红包
	private Integer isCouponRed;
	//可分享次数
	private Integer shareNum;
	//可叠加使用数量
	private Integer superpositionNum;
	//模版状态 1：上架  2：下架
	private Integer state;
	//前置条件，根据业务来判断生成抵扣券
	private Integer requirementType;
	//城市code集合
	private String cityCodes;
	//医院code集合
	private String hospitalIds;
	//病种code集合
	private String diseaseCodes;
	//服务类型集合
	private String productTypes;
	//备注
	private String remark;
	
	
	
	private List<Long> userIds;
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
	public List<Long> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}
	public Integer getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Integer couponNumber) {
		this.couponNumber = couponNumber;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
