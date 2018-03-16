package com.westangel.common.bean.push;

public class PushUserAlias {
	private Integer businessId;
	private Integer productId;
	private Long userId;
	private Integer userRole;
	private String alias;
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
	public void setProduct(Integer productId) {
		this.productId = productId;
	}
	/** 
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/** 
	* @return userRole 
	*/
	public Integer getUserRole() {
		return userRole;
	}
	/** 
	* @param userRole 要设置的 userRole 
	*/
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	/** 
	* @return alias 
	*/
	public String getAlias() {
		return alias;
	}
	/** 
	* @param alias 要设置的 alias 
	*/
	public void setAlias(String alias) {
		this.alias = alias;
	}
}
