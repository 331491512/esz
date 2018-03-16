/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>ProductServiceApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午4:12:54<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import com.westangel.common.util.TradeUtil;

import java.util.Date;

/**
 * @ClassName: ProductServiceApply.java
 * @Description:产品服务申请
 * @author lichenghao
 * @date 2015年12月12日 下午4:12:54
 */
public class ProductServiceApply {

	/**
	 * 产品服务申请ID
	 */
	private String productApplyId;
	
	/**
	 * 关联服务项 被关联的服务为主服务
	 */
	private String rProductApplyId;

	/**
	 * 患者用户ID
	 */
	private Long buyer;

	/**
	 * 医生用户ID
	 */
	private Long vendor;
	
	/**
	 * 产品服务编号
	 */
	private String productId;
	/**
	 * 产品服务类型。 1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	 */
	private Integer productType;

	/**
	 * 订单ID
	 */
	private String orderId;
	
	/**
	 * 订单标题
	 */
	private String orderTitle;
	
	/**
	 * 价格
	 */
	private Float realPrice;
	
	/**
	 * 联系电话
	 */
	private String contactMobile;

	/**
	 * 状态 0：申请中；1：已同意；2：已拒绝；3：用户取消；4：系统取消
	 */
	private Integer state;

	/**
	 * 服务进展状态。0：未开始；1：进行中；2：进行但失败（如电话呼叫失败）；3：已结束（如关闭咨询通道，或呼叫结束）
	 */
	private Integer progressState;
	
	/**
	 * 进行状态
	 */
	private Integer auditState;
	
	/**
	 * 预约咨询时间
	 */
	private Date consultOrderTime;
	
	/**
	 * 实际咨询发生时间
	 */
	private Date consultHappenTime;
	
	/**
	 * 过期时间
	 */
	private Date expireTime;
	
	/**
	 * 未处理取消时间 
	 */
	private Date idleCancelTime;
	
	/**
	 * 门诊预约时间
	 */
	private String clinicOrderTime;

	/**
	 * 医生概述
	 */
	private String summarization;

	/**
	 * 患者对医生评价等级。3: 非常满意； 2:满意；1:不满意
	 */
	private Integer evaluationServiceLevel;

	/**
	 * 评价说明
	 */
	private String evaluationRemark;

	/**
	 * 添加时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 备注
	 */
	private String remark; 
	
	//以下是中间计算数据. 但会存储到业务申请表数据库中。
		
	private String tips ; //吸顶提示
	
	private int inPackage; //套餐内子产品
	
	private Integer quota; //配额。inPackage=1时有效
	
	private Integer usage; //使用次数。inPackage=1时有效。
	
	private String  parentProductName; //父类产品名。inPackage=1时有效。
	
	private int packageFlag;
	
	private int periodFeeType; 
	
	private Integer subscriptionFlag; //订购关系标识。 更新state时，此值必须同步更新。
	
	private String description;
	
	private String treatmentCourse;	//治疗经过
	
	private String explain;			//其他描述
	
	private String recommendedDoctor;
	
	private Integer isAutoAccept;
	
	private Long agentApplicant; //代申请医生userId
	
	private Integer wxProductId;//服务申请微信
	
	private Integer applySource;
	
	private Long id;//s_mdt_apply.id
	
	private String cause;//原因

	private Integer productSubType;//子产品类型

	private String serviceCode;//服务领取码
	//消息来源；0或无：图文咨询；1：开单医生咨询[]
	private Integer messageSource;

	private Integer syncFlag;
	
	private Integer isRefund;

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
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
	
	public ProductServiceApply(){
		realPrice = 0f;
		//state = 0; //更新数据库时需要依赖!=null进行判断，故这里不初始化
		progressState=0;
		//subscriptionFlag = 0;
	}

	public String getProductApplyId() {
		return productApplyId;
	}

	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}

	public Long getBuyer() {
		return buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public Long getVendor() {
		return vendor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}

	public Integer getApplySource() {
		return applySource;
	}

	public void setApplySource(Integer applySource) {
		this.applySource = applySource;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public String getTreatmentCourse() {
		return treatmentCourse;
	}

	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
		setSubscriptionFlag(TradeUtil.getSubscriptionFlag(state));
	}

	public Integer getProgressState() {
		return progressState;
	}

	public void setProgressState(Integer progessState) {
		this.progressState = progessState;
	}

	public String getSummarization() {
		return summarization;
	}

	public void setSummarization(String summarization) {
		this.summarization = summarization;
	}

	public Integer getEvaluationServiceLevel() {
		return evaluationServiceLevel;
	}

	public void setEvaluationServiceLevel(Integer evaluationServiceLevel) {
		this.evaluationServiceLevel = evaluationServiceLevel;
	}

	public String getEvaluationRemark() {
		return evaluationRemark;
	}

	public void setEvaluationRemark(String evaluationRemark) {
		this.evaluationRemark = evaluationRemark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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
	 * @return the contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * @param contactMobile the contactMobile to set
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	/**
	 * @return the realPrice
	 */
	public Float getRealPrice() {
		return realPrice;
	}

	/**
	 * @param realPrice the realPrice to set
	 */
	public void setRealPrice(Float realPrice) {
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
	 * @return the consultHappenTime
	 */
	public Date getConsultHappenTime() {
		return consultHappenTime;
	}

	/**
	 * @param consultHappenTime the consultHappenTime to set
	 */
	public void setConsultHappenTime(Date consultHappenTime) {
		this.consultHappenTime = consultHappenTime;
	}

	/**
	 * @return the expireTime
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return the clinicOrderTime
	 */
	public String getClinicOrderTime() {
		return clinicOrderTime;
	}

	/**
	 * @param clinicOrderTime the clinicOrderTime to set
	 */
	public void setClinicOrderTime(String clinicOrderTime) {
		this.clinicOrderTime = clinicOrderTime;
	}

	/**
	 * @return the intervalTime, 单位：分钟
	 */
	public int getIntervalTime() {
		if(consultOrderTime!=null){
			long diff = consultOrderTime.getTime()-(new Date()).getTime(); //毫秒
			long  result =  diff / (60 * 1000);
			return (int)result;
		}
		return 0;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @return the idleCancelTime
	 */
	public Date getIdleCancelTime() {
		return idleCancelTime;
	}

	/**
	 * @param idleCancelTime the idleCancelTime to set
	 */
	public void setIdleCancelTime(Date idleCancelTime) {
		this.idleCancelTime = idleCancelTime;
	}

	/**
	 * @return the packageFlag
	 */
	public int getPackageFlag() {
		return packageFlag;
	}

	/**
	 * @param packageFlag the packageFlag to set
	 */
	public void setPackageFlag(int packageFlag) {
		this.packageFlag = packageFlag;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quota
	 */
	public Integer getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	/**
	 * @return the usage
	 */
	public Integer getUsage() {
		return usage;
	}

	/**
	 * @param usage the usage to set
	 */
	public void setUsage(Integer usage) {
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

	public String getRecommendedDoctor() {
		return recommendedDoctor;
	}

	public void setRecommendedDoctor(String recommendedDoctor) {
		this.recommendedDoctor = recommendedDoctor;
	}

	public Integer getIsAutoAccept() {
		return isAutoAccept;
	}

	public void setIsAutoAccept(Integer isAutoAccept) {
		this.isAutoAccept = isAutoAccept;
	}

	public Long getAgentApplicant() {
		return agentApplicant;
	}

	public void setAgentApplicant(Long agentApplicant) {
		this.agentApplicant = agentApplicant;
	}

	public Integer getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}

	public void setSubscriptionFlag(Integer subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Integer getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(Integer messageSource) {
		this.messageSource = messageSource;
	}

	public String getrProductApplyId() {
		return rProductApplyId;
	}

	public void setrProductApplyId(String rProductApplyId) {
		this.rProductApplyId = rProductApplyId;
	}

	public Integer getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
}
