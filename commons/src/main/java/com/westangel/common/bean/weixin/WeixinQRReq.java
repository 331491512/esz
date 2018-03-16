package com.westangel.common.bean.weixin;
/**
 * 
* @ClassName: WeixinQRReq 
* @Description: 获取微信二维码 
* @author LIPENG
* @date 2016年1月3日 上午11:08:47 
*
 */
public class WeixinQRReq implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 6981386858634229326L;

	/**
	 * 业务线编号
	 */
	private Integer businessId;
	/**
	 * 产品编号
	 */
	private Integer productId;

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 用户角色
	 */
	private Integer userRole;
	
	/**
	 * 专题号
	 */
	private String targetId="";

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
	* @return targetId 
	*/
	public String getTargetId() {
		return targetId;
	}

	/** 
	* @param targetId 要设置的 targetId 
	*/
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
}
