/**
 * 
 */
package com.westangel.commonservice.trade.model.coupon;

import java.util.Date;

import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;

/**
 * @author chenghao
 * @date  2016年6月30日 上午10:52:21
 */
public class CouponTemplateInfo {
	private String couponTemplateId;
	private Integer isPayment;
	private Integer validity;
	private String cycle;
	public String getCouponTemplateId() {
		return couponTemplateId;
	}
	public void setCouponTemplateId(String couponTemplateId) {
		this.couponTemplateId = couponTemplateId;
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
	
	public CouponInfo initCoupon(Long owner){
		CouponInfo info = new CouponInfo();
		info.setCouponId(GeneralUtil.generatorUUID("COUP"));
		info.setCouponTemplateId(couponTemplateId);
		info.setOwner(owner);
		updateCouponState(info,isPayment);
		return info;
	}
	
	public void updateCouponState(CouponInfo info ,Integer state){
		info.setCouponState(state);
		if(state==1){
			info.setStartDate(new Date());
			Date endDate = null;
			if("day".equals(cycle)){
				endDate = DateUtil.getOffsetDate(validity);
			}else if("week".equals(cycle)){
				endDate = DateUtil.getOffsetWeek(validity);
			}else if("month".equals(cycle)){
				endDate = DateUtil.getOffsetMonth(validity);
			}else if("year".equals(cycle)){
				endDate = DateUtil.getOffsetYear(validity);
			}
			if(endDate==null)//没有参考范围 默认为1天
				endDate = new Date();
			else//有日期周期 则结束日期当前日期-1天
				endDate = DateUtil.getOffsetDate(endDate,-1);
			info.setEndDate(endDate);
		}
	}
}
