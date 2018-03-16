/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>CouponTemplateMinInfoReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月8日上午8:24:04<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;

/** 
* @ClassName: CouponTemplateMinInfoReq
* @Description: 
* @author lichenghao
* @date 2016年7月8日 上午8:24:04  
*/
public class CouponTemplateInfoGetReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//抵用券前置条件
	private Integer requirementType;
	//状态  reqFlag is null or reqFlag is 0  获取所有  reqFlag=1 获取上架的  reqFlag==2 获取下架的
	private Integer reqFlag;
	public Integer getRequirementType() {
		return requirementType;
	}
	public void setRequirementType(Integer requirementType) {
		this.requirementType = requirementType;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
}
