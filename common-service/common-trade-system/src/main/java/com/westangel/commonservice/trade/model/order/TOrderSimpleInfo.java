/**
 * 
 */
package com.westangel.commonservice.trade.model.order;

/**
 * @author bigdragon
 * @date  2015-12-23 上午12:20:04
 */
public class TOrderSimpleInfo {
	private String orderId;            //订单ID

	private int    productType;        //产品类型 
	
	private Long   oppositeUserId;   //另一方用户ID
	

	private String oppositeTrueName; //另一方用户姓名。

	private String oppositeUserPicUrl;//另一方用户头像URL
	
	private String orderTitle;        //订单标题
	
	private int    state;             //订单状态。
							/*0: 买方已提交（默认）、未支付
							1：（买方）已支付
							2:  （卖方）已确认
							3：（卖方）已拒绝
							4：（服务）进行中
							5：（服务）已完成
							6：订单过期
							7：订单取消*/
	
	private String stateName;	//状态名

	private String createTime;//创建时间。YYY-MM-DD HH:MM:SS

	private String updateTime;//更新时间。YYY-MM-DD HH:MM:SS
	
	private int    inPackage; //套餐子产品标识。
	
	private int    quota;     //套餐配额。inPackage=1时有效。
	
	private int    usage;     //当前套餐配额已用次数。inPackage=1时有效。
	
	private String parentProductName; 
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the productType
	 */
	public int getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(int productType) {
		this.productType = productType;
	}

	/**
	 * @return the oppositeUserId
	 */
	public Long getOppositeUserId() {
		return oppositeUserId;
	}

	/**
	 * @param oppositeUserId the oppositeUserId to set
	 */
	public void setOppositeUserId(Long oppositeUserId) {
		this.oppositeUserId = oppositeUserId;
	}

	/**
	 * @return the oppositeTrueName
	 */
	public String getOppositeTrueName() {
		return oppositeTrueName;
	}

	/**
	 * @param oppositeTrueName the oppositeTrueName to set
	 */
	public void setOppositeTrueName(String oppositeTrueName) {
		this.oppositeTrueName = oppositeTrueName;
	}

	/**
	 * @return the oppositeUserPicUrl
	 */
	public String getOppositeUserPicUrl() {
		return oppositeUserPicUrl;
	}

	/**
	 * @param oppositeUserPicUrl the oppositeUserPicUrl to set
	 */
	public void setOppositeUserPicUrl(String oppositeUserPicUrl) {
		this.oppositeUserPicUrl = oppositeUserPicUrl;
	}

	/**
	 * @return the orderTitle
	 */
	public String getOrderTitle() {
		return orderTitle;
	}

	/**
	 * @param orderTitle the orderTitle to set
	 */
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the inPackage
	 */
	public int getInPackage() {
		return inPackage;
	}

	/**
	 * @param inPackage the inPackage to set
	 */
	public void setInPackage(int inPackage) {
		this.inPackage = inPackage;
	}

	/**
	 * @return the quota
	 */
	public int getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}

	/**
	 * @return the usage
	 */
	public int getUsage() {
		return usage;
	}

	/**
	 * @param usage the usage to set
	 */
	public void setUsage(int usage) {
		this.usage = usage;
	}

	/**
	 * @return the parentProductName
	 */
	public String getParentProductName() {
		return parentProductName;
	}

	/**
	 * @param parentProductName the parentProductName to set
	 */
	public void setParentProductName(String parentProductName) {
		this.parentProductName = parentProductName;
	}



}
