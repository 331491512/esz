/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.sms;<br/>  
 * <b>文件名：</b>SmsReceiptReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月13日下午3:50:20<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.sms;
/** 
* @ClassName: SmsReceiptReq
* @Description: 
* @author lichenghao
* @date 2016年8月13日 下午3:50:20  
*/
public class SmsReceiptReq {
	/**
	 * 产品Id
	 */
	private Integer productId;
	/**
	 * 业务Id
	 */
	private Integer businessId;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
}
