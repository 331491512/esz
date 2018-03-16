package com.esuizhen.cloudservice.business.bean;
/**
 * 
* @ClassName: MDTChangeStateReq 
* @Description: 修改MDT状态 
* @author LIPENG
* @date 2016年1月22日 上午10:38:15 
*
 */
public class MDTChangeStateReq {
	/**
	 * 申请ID
	 */
	private String productApplyId="";
	/**
	 * 订单ID
	 */
	private String orderId;
	/**
	 * 审核状态
	 */
	private Integer auditState;
	/**
	 * 阶段
	 */
	private Integer progressState;
	/**
	 * 原因
	 */
	private String cause="";
	/**
	 * 附件
	 */
	private String consultAttachement="";
	/** 
	* @return productApplyId 
	*/
	public String getProductApplyId() {
		return productApplyId;
	}
	/** 
	* @param productApplyId 要设置的 productApplyId 
	*/
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	/** 
	* @return orderId 
	*/
	public String getOrderId() {
		return orderId;
	}
	/** 
	* @param orderId 要设置的 orderId 
	*/
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/** 
	* @return auditState 
	*/
	public Integer getAuditState() {
		return auditState;
	}
	/** 
	* @param auditState 要设置的 auditState 
	*/
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	/** 
	* @return cause 
	*/
	public String getCause() {
		return cause;
	}
	/** 
	* @param cause 要设置的 cause 
	*/
	public void setCause(String cause) {
		this.cause = cause;
	}
	/** 
	* @return consultAttachement 
	*/
	public String getConsultAttachement() {
		return consultAttachement;
	}
	/** 
	* @param consultAttachement 要设置的 consultAttachement 
	*/
	public void setConsultAttachement(String consultAttachement) {
		this.consultAttachement = consultAttachement;
	}
	/** 
	* @return progressState 
	*/
	public Integer getProgressState() {
		return progressState;
	}
	/** 
	* @param progressState 要设置的 progressState 
	*/
	public void setProgressState(Integer progressState) {
		this.progressState = progressState;
	}
	
}
