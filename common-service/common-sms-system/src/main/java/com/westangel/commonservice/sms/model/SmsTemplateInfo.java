package com.westangel.commonservice.sms.model;
/**
 * 
* @ClassName: SmsTemplateInfo 
* @Description: 短信模版 
* @author LIPENG
* @date 2015年12月23日 上午11:12:23 
*
 */
public class SmsTemplateInfo {
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 表达式
	 */
	private String expression;
	/**
	 * 使用的通道名称
	 */
	private String channelName;	
	/**
	 * 备注说明
	 */
	private String remark;
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
	* @return expression 
	*/
	public String getExpression() {
		return expression;
	}
	/** 
	* @param expression 要设置的 expression 
	*/
	public void setExpression(String expression) {
		this.expression = expression;
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
	* @return channelName 
	*/
	public String getChannelName() {
		return channelName;
	}
	/** 
	* @param channelName 要设置的 channelName 
	*/
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	
}
