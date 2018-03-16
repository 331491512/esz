package com.esuizhen.cloudservice.business.bean;
/**
 * 
* @ClassName: MdtEmrSubmitReq 
* @Description: 提交MDT申请 
* @author LIPENG
* @date 2016年1月27日 下午5:12:17 
*
 */
public class MdtEmrSubmitReq {
	private String productApplyId;
	private Integer reqFlag;
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
	* @return reqFlag 
	*/
	public Integer getReqFlag() {
		return reqFlag;
	}
	/** 
	* @param reqFlag 要设置的 reqFlag 
	*/
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	
}
