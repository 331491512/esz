/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ProductAgentApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月19日下午7:04:46<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import com.westangel.common.bean.trade.TOrderPublishInfo;

/** 
* @ClassName: ProductAgentApply
* @Description: 代理申请
* @author lichenghao
* @date 2016年10月19日 下午7:04:46  
*/
public class ProductAgentApply {
	//产品订购信息
	private TOrderPublishInfo orderInfo;

	public TOrderPublishInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(TOrderPublishInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
}
