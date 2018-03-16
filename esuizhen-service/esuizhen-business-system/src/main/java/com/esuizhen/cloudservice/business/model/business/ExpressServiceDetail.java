/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>ExpressServiceDetail.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月10日下午2:51:13<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/** 
* @ClassName: ExpressServiceDetail
* @Description: 
* @author lichenghao
* @date 2017年1月10日 下午2:51:13  
*/
public class ExpressServiceDetail {
	private Long detailId;
	private String productApplyId;
	private String inhospitalId;
	private String patientNo;
	private String inhospitalNo;
	private String inhospitalDate;
	private Integer amount;
	private Integer state;
	private Date createTime;
	private Date updateTime;
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public String getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(String inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
}
