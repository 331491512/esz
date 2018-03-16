package com.westangel.commonservice.push.model;
/**
* @author 作者 :LIPENG
* @Description: TODO
* @version 创建时间：2015年12月5日 下午11:25:59
* 类说明
*/
public class PushChannelInfo {
	//业务线编号
	private Integer businessId;
	
	//产品编号
	private Integer productId;
	
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	
	public Integer getBusinessId() {
		return businessId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public String key() {
		return ""+businessId+"-"+productId+"";
	}
}
