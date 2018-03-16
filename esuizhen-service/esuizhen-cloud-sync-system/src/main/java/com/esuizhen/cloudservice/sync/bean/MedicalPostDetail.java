package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:ProductServiceApply</p>
 * <p>Description:病案邮寄bean类</p>
 * @author fanpanwei
 * @date 2016年10月19日 上午11:36:36
 */
public class MedicalPostDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String productApplyId;
	private String patientNo;
	private String inhospitalNo;
	private Date inhospitalDate;
	private Integer amount;
	
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
