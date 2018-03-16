package com.esuizhen.cloudservice.business.bean;

import com.westangel.common.bean.trade.TOrderMinInfo;

import java.util.Date;
import java.util.List;

/**
 * 产品订购简要信息
 * @author DaLoong
 * @date  2016/2/4
 */
public class TProductSubscriptionSimpleInfo {

	private Long id; 
	
	private String productApplyId;
	
	private String productId;
	
	private String orderId;
	
	private String orderTitle;
	
	private int    productType;
	
	private int    progressState;
	
	private int    state;
	
	private int    auditState;
	
	private String auditStateName;
	
	private Date   createTime;
	
	private Date   updateTime;

	private Integer mdtFlowStateId;
	
	private Date expireTime;
	
	private String contactMobile;
	
	private String productName;
	
	private String buyerName;
	
	private Long buyer;
	
	private String vendorName;
	
	private String vendor;
	
	private String userPictureUrl;
	
	private Integer subscriptionFlag;
	
	private String description;
	
	private String remark;
	
	private Integer productSource;

	private String professionalRankName;

	private Integer productSubType;

	private String serviceCode;

	private String hospitalName;

	private String expressCompanyName;

	private float realPrice;
	
	private String cause;
	

	private List<ServiceProgressResp> serverProgressList;

	private TOrderMinInfo orderDetail;

	private Date systemTime;
	
	private Integer paymentState;
	
	public float getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}

	public String getExpressCompanyName() {
		return expressCompanyName;
	}

	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public TOrderMinInfo getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(TOrderMinInfo orderDetail) {
		this.orderDetail = orderDetail;
	}

	public List<ServiceProgressResp> getServerProgressList() {
		return serverProgressList;
	}

	public void setServerProgressList(List<ServiceProgressResp> serverProgressList) {
		this.serverProgressList = serverProgressList;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
	}

	public String getProfessionalRankName() {
		return professionalRankName;
	}

	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Long getBuyer() {
		return buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
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
	 * @return the progressState
	 */
	public int getProgressState() {
		return progressState;
	}

	/**
	 * @param progressState the progressState to set
	 */
	public void setProgressState(int progressState) {
		this.progressState = progressState;
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
	 * @return the auditState
	 */
	public int getAuditState() {
		return auditState;
	}

	/**
	 * @param auditState the auditState to set
	 */
	public void setAuditState(int auditState) {
		this.auditState = auditState;
	}

	/**
	 * @return the auditStateName
	 */
	public String getAuditStateName() {
		return auditStateName;
	}

	/**
	 * @param auditStateName the auditStateName to set
	 */
	public void setAuditStateName(String auditStateName) {
		this.auditStateName = auditStateName;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}


	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public Integer getSubscriptionFlag() {
		return subscriptionFlag;
	}

	public void setSubscriptionFlag(Integer subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getProductSource()
	{
		return productSource;
	}

	public void setProductSource(Integer productSource)
	{
		this.productSource = productSource;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getMdtFlowStateId()
	{
		return mdtFlowStateId;
	}

	public void setMdtFlowStateId(Integer mdtFlowStateId)
	{
		this.mdtFlowStateId = mdtFlowStateId;
	}

	public Date getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(Date systemTime) {
		this.systemTime = systemTime;
	}

	public Integer getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(Integer paymentState) {
		this.paymentState = paymentState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
}
