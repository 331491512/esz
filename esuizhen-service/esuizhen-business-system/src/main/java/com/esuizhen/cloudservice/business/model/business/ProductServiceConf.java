package com.esuizhen.cloudservice.business.model.business;

/**
 * 产品服务配置。从数据库conf_product_service读取
 * @author bigdragon
 *
 */
public class ProductServiceConf {

	private int productType; 
	
	private String productName;
	
	private int isApplyPushNotifyToDoctor;
	
	private int isApplyPushNotifyToPatient;
	
	private int isApplyPushNotifyToAgent=0;
	
	private int isApplyAcceptNotify;

	
	/**
	 * 从申请时间开始，到达此expireTime时间后，服务自动终止。对包周期产品有效(specType=1时)。
		缺省 24(小时)*60=1440
		对于包月产品为：24*60*31=44640
		对于包年产品为：24*60*365=262800
		对于电话咨询、预约挂号、MDT等按次产品，此值为0(此时不生成expire类型的定时器)

	 */
	private int expireTime; //过期时间。单位：分钟。
	
	private int idleCancelTime;//未处理取消服务时间。单位：分钟. 缺省1440（24小时）

	private int specType; //规格类型。
	//0：按次（如MDT、电话咨询、预约加号等）（默认）；
	//1：包周期（如图文咨询、私人医生包月或包年）. 取值为1时，expireTime才有效。

	private int periodFeeType;
	
	private int repurchaseFlag;//允许重复购买标识。在交易系统的product_template表中。
	
	private int isAutoAccept; //是否自动确认。0 否 1 是 在交易系统的product_template表中
	
	private int isRefund; //完成退款
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the isApplyPushNotify
	 */
	public int getIsApplyPushNotifyToDoctor() {
		return isApplyPushNotifyToDoctor;
	}

	/**
	 * @param isApplyPushNotify the isApplyPushNotify to set
	 */
	public void setIsApplyPushNotifyToDoctor(int isApplyPushNotifyToDoctor) {
		this.isApplyPushNotifyToDoctor = isApplyPushNotifyToDoctor;
	}

	/**
	 * @return the isApplyAcceptNotify
	 */
	public int getIsApplyAcceptNotify() {
		return isApplyAcceptNotify;
	}

	/**
	 * @param isApplyAcceptNotify the isApplyAcceptNotify to set
	 */
	public void setIsApplyAcceptNotify(int isApplyAcceptNotify) {
		this.isApplyAcceptNotify = isApplyAcceptNotify;
	}

	/**
	 * @return the isApplyPushNotifyToPatient
	 */
	public int getIsApplyPushNotifyToPatient() {
		return isApplyPushNotifyToPatient;
	}

	/**
	 * @param isApplyPushNotifyToPatient the isApplyPushNotifyToPatient to set
	 */
	public void setIsApplyPushNotifyToPatient(int isApplyPushNotifyToPatient) {
		this.isApplyPushNotifyToPatient = isApplyPushNotifyToPatient;
	}

	/**
	 * @return the expireTime
	 */
	public int getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return the idleCancelTime
	 */
	public int getIdleCancelTime() {
		return idleCancelTime;
	}

	/**
	 * @param idleCancelTime the idleCancelTime to set
	 */
	public void setIdleCancelTime(int idleCancelTime) {
		this.idleCancelTime = idleCancelTime;
	}

	/**
	 * @return the specType
	 */
	public int getSpecType() {
		return specType;
	}

	/**
	 * @param specType the specType to set
	 */
	public void setSpecType(int specType) {
		this.specType = specType;
	}

	/**
	 * @return the periodFeeType
	 */
	public int getPeriodFeeType() {
		return periodFeeType;
	}

	/**
	 * @param periodFeeType the periodFeeType to set
	 */
	public void setPeriodFeeType(int periodFeeType) {
		this.periodFeeType = periodFeeType;
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

	public int getIsAutoAccept() {
		return isAutoAccept;
	}

	public void setIsAutoAccept(int isAutoAccept) {
		this.isAutoAccept = isAutoAccept;
	}

	public int getIsApplyPushNotifyToAgent() {
		return isApplyPushNotifyToAgent;
	}

	public void setIsApplyPushNotifyToAgent(int isApplyPushNotifyToAgent) {
		this.isApplyPushNotifyToAgent = isApplyPushNotifyToAgent;
	}

	public int getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;
	}
}
