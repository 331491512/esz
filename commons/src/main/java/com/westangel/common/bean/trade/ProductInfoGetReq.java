/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>ProductInfoGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午11:26:18<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;
/** 
* @ClassName: ProductInfoGetReq
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午11:26:18  
*/
public class ProductInfoGetReq {
	//商品提供商
	private String vendor;
	//商品编号
	private String productId;
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
