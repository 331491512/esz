package com.westangel.common.bean.weixin;
/**
 * 
* @ClassName: WeixinOpenIdGetReq 
* @Description: 获取 
* @author LIPENG
* @date 2016年1月4日 上午11:14:13 
*
 */
public class WeixinOpenIdGetReq implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4682478185386463034L;
	private Integer businessId;
	private Integer productId;
	private String code;
	/** 
	* @return businessId 
	*/
	public Integer getBusinessId() {
		return businessId;
	}
	/** 
	* @param businessId 要设置的 businessId 
	*/
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/** 
	* @return productId 
	*/
	public Integer getProductId() {
		return productId;
	}
	/** 
	* @param productId 要设置的 productId 
	*/
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/** 
	* @return code 
	*/
	public String getCode() {
		return code;
	}
	/** 
	* @param code 要设置的 code 
	*/
	public void setCode(String code) {
		this.code = code;
	}
	
}
