/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TProductApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月15日上午11:15:34<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.TradeUtil;

/** 
* @ClassName: TProductApply
* @Description: 购买人信息
* @author jiayanzhao
* @date 2016年5月15日 上午11:15:34  
*/
public class TProductBuyerInfo {
	private String productApplyId;
	private String description;
	private Long buyer;
	
	
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getBuyer() {
		return buyer;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}
	

}
