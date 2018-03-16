/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TProductApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日上午11:15:34<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.util.Date;

import com.westangel.common.util.GeneralUtil;

/** 
* @ClassName: TProductApplySync
* @Description: 服务申请同步
* @author bigdragon
* @date 2016年1月13日 上午0:15:34  
*/
public class TProductApplySync {
	
	//产品订购信息
	private TOrderPublishInfo orderInfo;
	
	
	public TOrderPublishInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(TOrderPublishInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	
	
	
}
