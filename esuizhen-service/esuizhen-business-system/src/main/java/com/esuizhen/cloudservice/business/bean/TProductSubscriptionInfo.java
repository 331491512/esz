package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/**
 * 产品订购信息
 * @author bigdragon
 * @date 2016/1/8
 */
public class TProductSubscriptionInfo {

	private int state; //0: 未订购或已失效 1：存在有效订购关系【直接从dao中查询出来是数据库中的state，接口返回时须转成subscriptionFlag取值
	
	private String productApplyId ;//产品服务申请号
	
	private String tips;//吸顶提示
	
	private float  realPrice;
	
	private int    inPackage; //是否在套餐中
	
	private int    availableNum;//	剩余可用次数。inPackage=1时有效。>0: 可用次数；0：套餐余额用完；<0：可以无限次使用。
	
	private int    quota;       //	套餐配额。inPackage=1时有效。<0: 可不限次数使用。>0: 具体配额值。
	
	private String parentProductName;//	购买的父级套餐的产品名，如私人医生。inPackage=1时有效。

	private Date   consultOrderTime; //对于电话咨询有效。咨询安排时间。
	
	private int    subscriptionFlag; //订购状态。
	
	private int auditState;//审核状态
	
	private Integer wxProductId; //微信公众号标识
	
	private Date expireTime;  //服务结束时间
	
	private Integer usage;

	public TProductSubscriptionInfo(){
		state = -1;
		inPackage = 0;
		availableNum = 0;
		quota = 0;
		setSubscriptionFlag(-1);
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
	 * @return the availableNum
	 */
	public int getAvailableNum() {
		return availableNum;
	}

	/**
	 * @param availableNum the availableNum to set
	 */
	public void setAvailableNum(int availableNum) {
		this.availableNum = availableNum;
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
	 * @return the productApplyId
	 */
	public String getProductApplyId() {
		return productApplyId;
	}

	/**
	 * @param productApplyId the productApplyId to set
	 */
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}

	/**
	 * @return the tips
	 */
	public String getTips() {
		return tips;
	}

	/**
	 * @param tips the tips to set
	 */
	public void setTips(String tips) {
		this.tips = tips;
	}

	/**
	 * @return the realPrice
	 */
	public float getRealPrice() {
		return realPrice;
	}

	/**
	 * @param realPrice the realPrice to set
	 */
	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}


	/**
	 * @return the consultOrderTime
	 */
	public Date getConsultOrderTime() {
		return consultOrderTime;
	}


	/**
	 * @param consultOrderTime the consultOrderTime to set
	 */
	public void setConsultOrderTime(Date consultOrderTime) {
		this.consultOrderTime = consultOrderTime;
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

	public int getAuditState() {
		return auditState;
	}


	public void setAuditState(int auditState) {
		this.auditState = auditState;
	}


	public Integer getWxProductId() {
		return wxProductId;
	}


	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}


	public Date getExpireTime() {
		return expireTime;
	}


	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}


	public Integer getUsage() {
		return usage;
	}


	public void setUsage(Integer usage) {
		this.usage = usage;
	}
	
}
