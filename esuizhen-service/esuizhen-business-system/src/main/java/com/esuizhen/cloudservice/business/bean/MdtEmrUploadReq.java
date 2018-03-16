package com.esuizhen.cloudservice.business.bean;
/**
 * 
* @ClassName: MdtEmrUploadReq 
* @Description: 上传emr资料请求 
* @author LIPENG
* @date 2016年1月21日 下午7:12:50 
*
 */
public class MdtEmrUploadReq {
	private String productApplyId;
	//病历主页ID
	private String emrId;
	private Integer emrType;
	private Integer emrSubType;
	private Integer subdivision;
	private String picFileUrl;
	private Integer productType;
	private Integer mdtReportType=0;//MDT报告类型   0：mdt病历1：mdt病理报告
	private String remark;
	
	public Integer getMdtReportType() {
		
		return mdtReportType;
	}
	public void setMdtReportType(Integer mdtReportType) {
		this.mdtReportType = mdtReportType;
	}
	public String getRemark() {
		return remark;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** 
	* @return productApplyId 
	*/
	public String getProductApplyId() {
		return productApplyId;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	/** 
	* @param productApplyId 要设置的 productApplyId 
	*/
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
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
