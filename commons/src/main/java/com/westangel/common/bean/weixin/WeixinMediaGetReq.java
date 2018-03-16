package com.westangel.common.bean.weixin;

public class WeixinMediaGetReq  implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -718832843502486165L;
	private Integer businessId;
	private Integer productId;
	private String media_id;
	private String path;
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
	* @return media_id 
	*/
	public String getMedia_id() {
		return media_id;
	}
	/** 
	* @param media_id 要设置的 media_id 
	*/
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	/** 
	* @return path 
	*/
	public String getPath() {
		return path;
	}
	/** 
	* @param path 要设置的 path 
	*/
	public void setPath(String path) {
		this.path = path;
	}
}
