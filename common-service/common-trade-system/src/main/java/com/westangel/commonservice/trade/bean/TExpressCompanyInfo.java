/**
 * 
 * @author Da Loong
 * @date  2016年6月6日 下午5:09:31
 */
package com.westangel.commonservice.trade.bean;

/**
 * 快递公司信息
 * @author Da Loong
 * @date  2016年6月6日 下午5:09:31
 */
public class TExpressCompanyInfo {

	private Integer expressCompanyId;
	
	private String  expressCompanyName;

	/**
	 * @return the expressCompanyId
	 */
	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}

	/**
	 * @param expressCompanyId the expressCompanyId to set
	 */
	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	/**
	 * @return the expressCompanyName
	 */
	public String getExpressCompanyName() {
		return expressCompanyName;
	}

	/**
	 * @param expressCompanyName the expressCompanyName to set
	 */
	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}
	
	
}
