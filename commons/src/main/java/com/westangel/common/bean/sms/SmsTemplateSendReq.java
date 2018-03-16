package com.westangel.common.bean.sms;

import java.util.List;

/**
 * 
* @ClassName: SmsTemplateSendReq 
* @Description: 发送模版短信 
* @author LIPENG
* @date 2015年12月22日 下午8:17:49 
*
 */
public class SmsTemplateSendReq implements java.io.Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 4362398322451490565L;
	/**
	 * 业务线编号
	 */
	private Integer businessId;
	/**
	 * 产品编号
	 */
	private Integer productId;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 模版名称
	 */
	private String templateName;
	/**
	 * 模版参数列表
	 */
	private List<String> values;
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
	* @return templateName 
	*/
	public String getTemplateName() {
		return templateName;
	}
	/** 
	* @param templateName 要设置的 templateName 
	*/
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	/** 
	* @return mobile 
	*/
	public String getMobile() {
		return mobile;
	}
	/** 
	* @param mobile 要设置的 mobile 
	*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
