package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

public class TMDTEmrInfo {
	/**
	 * 病历类型
	 */
	private Integer emrType;
	/**
	 * 子类型
	 * 1.检查单 2.化验单 9.诊断报告 11.门诊病历 12.处方笺 
	 */
	private Integer emrSubType;
	/**
	 * 子类型
	 * 0：一般检查报告（默认）1：细胞学检查 2：病理学检查 3：医学影像学检查 9：其他检查
	 */
	private Integer subdivision=0;
	/**
	 * 病历照片url，多张照片之间用逗号分割
	 */
	private String picFileUrl;
	/**
	 * 审核状态
	 * 0.待审核 1.审核成功 2.审核失败
	 */
	private Integer auditState;
	//产品类型
	private Integer productType;
	/**
	 * 审核原因
	 */
	private String cause;
	//备注
	private String remark;
	
	/**
	 * MDT报告类型  
	 * 0：mdt病历1：mdt病理报告
	 */
	private Integer mdtReportType;
	
	private Date visitTime;
	
	public Integer getMdtReportType() {
		return mdtReportType;
	}
	public void setMdtReportType(Integer mdtReportType) {
		this.mdtReportType = mdtReportType;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	/** 
	* @return emrSubType 
	*/
	public Integer getEmrSubType() {
		return emrSubType;
	}
	/** 
	* @param emrSubType 要设置的 emrSubType 
	*/
	public void setEmrSubType(Integer emrSubType) {
		this.emrSubType = emrSubType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** 
	* @return picFileUrl 
	*/
	public String getPicFileUrl() {
		return picFileUrl;
	}
	/** 
	* @param picFileUrl 要设置的 picFileUrl 
	*/
	public void setPicFileUrl(String picFileUrl) {
		this.picFileUrl = picFileUrl;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
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
	* @return emrType 
	*/
	public Integer getEmrType() {
		return emrType;
	}
	/** 
	* @param emrType 要设置的 emrType 
	*/
	public void setEmrType(Integer emrType) {
		this.emrType = emrType;
	}
	/** 
	* @return subdivision 
	*/
	public Integer getSubdivision() {
		return subdivision;
	}
	/** 
	* @param subdivision 要设置的 subdivision 
	*/
	public void setSubdivision(Integer subdivision) {
		this.subdivision = subdivision;
	}
}
