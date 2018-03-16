package com.westangel.commonservice.push.model.weixin;

import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: WeixinTemplateInfo 
* @Description: 微信模版 
* @author LIPENG
* @date 2015年12月18日 下午1:21:39 
*
 */
public class WeixinTemplateInfo {
	/**
	 * 模版编号
	 */
	private Integer id;
	/**
	 * 模版名称
	 */
	private String name;
	/**
	 * 微信模版编号
	 */
	private String weixinId;
	/**
	 * 微信模版表达式
	 */
	private String weixinExpression="";
	/**
	 * 说明描述
	 */
	private String remark;
	/**
	 * 业务线ID
	 */
	private Integer businessId;
	/**
	 * 产品ID
	 */	
	private Integer productId;
	/**
	 * 开启状态 0:未启用 1:已启用
	 */
	private Integer state;
	/** 
	* @return name 
	*/
	public String getName() {
		return name;
	}
	/** 
	* @param name 要设置的 name 
	*/
	public void setName(String name) {
		this.name = name;
	}
	/** 
	* @return weixinId 
	*/
	public String getWeixinId() {
		return weixinId;
	}
	/** 
	* @param weixinId 要设置的 weixinId 
	*/
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
	/** 
	* @return remark 
	*/
	public String getRemark() {
		return remark;
	}
	/** 
	* @param remark 要设置的 remark 
	*/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 
	* @Title: keywordList 
	* @Description: 关键词列表 
	* @param @return    设定文件 
	* @return List<String>    返回类型 
	* @throws
	 */
	public String[] keywordList() {
		return StringUtils.split(weixinExpression, ",");
	}
	/** 
	* @return weixinExpression 
	*/
	public String getWeixinExpression() {
		return weixinExpression;
	}
	/** 
	* @param weixinExpression 要设置的 weixinExpression 
	*/
	public void setWeixinExpression(String weixinExpression) {
		this.weixinExpression = weixinExpression;
	}
	/** 
	* @return id 
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Integer id) {
		this.id = id;
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
	* @return state 
	*/
	public Integer getState() {
		return state;
	}
	/** 
	* @param state 要设置的 state 
	*/
	public void setState(Integer state) {
		this.state = state;
	}
	
	/**
	 * 主键配置
	 * @return
	 */
	public String key(){
		return this.getName()+"-"+this.getBusinessId()+"-"+this.getProductId();
	}
}
