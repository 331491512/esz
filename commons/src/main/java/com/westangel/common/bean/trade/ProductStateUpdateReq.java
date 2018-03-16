/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>ProductStateUpdateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月17日上午11:24:14<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;
/** 
* @ClassName: ProductStateUpdateReq
* @Description: 
* @author lichenghao
* @date 2017年2月17日 上午11:24:14  
*/
public class ProductStateUpdateReq {
	//商品编号
	private String productId;
	//提供商Id
	private Long vendor;
	//上架/下架状态
	private Integer state;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Long getVendor() {
		return vendor;
	}
	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
