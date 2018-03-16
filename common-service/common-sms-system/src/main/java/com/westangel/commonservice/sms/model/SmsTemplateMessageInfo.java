package com.westangel.commonservice.sms.model;

import java.util.List;

/**
 * 
* @ClassName: SmsTemplateInfo 
* @Description: 模版信息
* @author LIPENG
* @date 2015年12月22日 下午8:53:34 
*
 */
public class SmsTemplateMessageInfo {
	/**
	 * 模版名称
	 */
	private String name;
	/**
	 * 模版表达式
	 */
	private String expression;
	/**
	 * 填充值
	 */
	private List<String> values;
	
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
	* @return values 
	*/
	public List<String> getValues() {
		return values;
	}
	/** 
	* @param values 要设置的 values 
	*/
	public void setValues(List<String> values) {
		this.values = values;
	}
}
