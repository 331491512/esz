/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>TCouponTemplateInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月8日上午8:29:54<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/** 
* @ClassName: TCouponTemplateInfo
* @Description: 
* @author lichenghao
* @date 2016年7月8日 上午8:29:54  
*/
public class TCouponTemplateInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String couponTemplateId;
	private String couponTemplateName;
	private Integer couponType;
	private Float couponNumber;
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
	public Float getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Float couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
}
