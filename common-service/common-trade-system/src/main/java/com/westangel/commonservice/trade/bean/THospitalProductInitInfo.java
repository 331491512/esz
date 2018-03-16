/**
 * 
 * @author Da Loong
 * @date  2016年6月2日 下午4:24:08
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author Da Loong
 * @date  2016年6月2日 下午4:24:08
 */
public class THospitalProductInitInfo {
	
	private String productTemplateId;
	
	private Integer state;

	private String productSubTypes;

	public String getProductSubTypes() {
		return productSubTypes;
	}

	public void setProductSubTypes(String productSubTypes) {
		this.productSubTypes = productSubTypes;
	}

	/**
	 * @return the productTemplateId
	 */
	public String getProductTemplateId() {
		return productTemplateId;
	}

	/**
	 * @param productTemplateId the productTemplateId to set
	 */
	public void setProductTemplateId(String productTemplateId) {
		this.productTemplateId = productTemplateId;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	

}
