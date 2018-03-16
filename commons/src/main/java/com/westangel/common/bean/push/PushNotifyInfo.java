package com.westangel.common.bean.push;

import java.io.Serializable;

/**
* @author 作者 :LIPENG
* @Description: 推送消息类
* @version 创建时间：2015年12月5日 下午10:11:45
* 类说明
*/
public class PushNotifyInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1117026277717848931L;

	//业务线编号
	private Integer businessId;
	//产品编号
	private Integer productId;
	//用户编号
	private Long userId;
	//用户角色
	private Integer userRole;
	//用户分组，如果该字段不为空，则按分组推送
	private String userAlais;
	//推送类型
	private Integer pushType;
	//推送内容
	private String content;
	//提示语
	private String tipText;
	

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
	* @return pushType 
	*/
	public Integer getPushType() {
		return pushType;
	}
	/** 
	* @param pushType 要设置的 pushType 
	*/
	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}
	/** 
	* @return content 
	*/
	public String getContent() {
		return content;
	}
	/** 
	* @param content 要设置的 content 
	*/
	public void setContent(String content) {
		this.content = content;
	}
	/** 
	* @return tipText 
	*/
	public String getTipText() {
		return tipText;
	}
	/** 
	* @param tipText 要设置的 tipText 
	*/
	public void setTipText(String tipText) {
		this.tipText = tipText;
	}
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
	* @return userAlais 
	*/
	public String getUserAlais() {
		return userAlais;
	}
	/** 
	* @param userAlais 要设置的 userAlais 
	*/
	public void setUserAlais(String userAlais) {
		this.userAlais = userAlais;
	}
}
