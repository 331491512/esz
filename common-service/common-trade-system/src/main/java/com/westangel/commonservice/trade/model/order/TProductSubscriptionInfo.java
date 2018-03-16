/**
 * 
 */
package com.westangel.commonservice.trade.model.order;

/**
 * 产品订购信息
 * @author DaLoong
 * @date  2016年2月3日 下午11:29:03
 */
public class TProductSubscriptionInfo {
	
	private String productId;
	
	private int    subscriptionFlag; //订购关系标识。-1：无订购关系或已结束；0：有订购关系但尚未进行；1：有订购关系且服务进行或同意
	
	private Long   buyer;
	
	private int    repurchaseFlag; //允许重复购买标识
	
	
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}



	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}



	/**
	 * @return the subscriptionFlag
	 */
	public int getSubscriptionFlag() {
		return subscriptionFlag;
	}



	/**
	 * @param subscriptionFlag the subscriptionFlag to set
	 */
	public void setSubscriptionFlag(int subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}



	/**
	 * @return the buyer
	 */
	public Long getBuyer() {
		return buyer;
	}



	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}



	/**
	 * @return the repurchaseFlag
	 */
	public int getRepurchaseFlag() {
		return repurchaseFlag;
	}



	/**
	 * @param repurchaseFlag the repurchaseFlag to set
	 */
	public void setRepurchaseFlag(int repurchaseFlag) {
		this.repurchaseFlag = repurchaseFlag;
	}



	public TProductSubscriptionInfo()
	{
		subscriptionFlag = -1;
		
		repurchaseFlag = 0;
		
	}
	
}
