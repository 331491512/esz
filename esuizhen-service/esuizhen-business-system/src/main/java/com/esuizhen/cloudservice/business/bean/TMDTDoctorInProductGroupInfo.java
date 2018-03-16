package com.esuizhen.cloudservice.business.bean;

import java.io.Serializable;

/**
 * <p>Title:TProductGroupInfo</p>
 * <p>Description:MDT组内医生信息</p>
 * @author YYCHEN
 * @date 2016年9月28日 下午2:49:21
 */
public class TMDTDoctorInProductGroupInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//产品ID
	private String productId;
	//医生ID
	private Long doctorId;
	//医生UserId
	private Long userId;
	//
	private String trueName;
	//MDT产品名称
	private String productName;
	//职务名称
	private String positionTitleName;
	//职称名称
	private String professionalRankName;
	//医院名称
	private String hospitalName;
	//科室名称
	private String deptName;
	/**
	 * 会诊专家（病理、内科、放疗）
	 */
	private String doctorName;
	/**
	 * 会诊专家签名
	 */
	private String signatureUrl;
	/**
	 * 会诊专家类型 
	 */
	private Integer groupType;
	private String mobile;
	public Long getDoctorId() {
		return doctorId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPositionTitleName() {
		return positionTitleName;
	}
	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}
	public String getProfessionalRankName() {
		return professionalRankName;
	}
	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSignatureUrl() {
		return signatureUrl;
	}
	public void setSignatureUrl(String signatureUrl) {
		this.signatureUrl = signatureUrl;
	}
	public Integer getGroupType() {
		return groupType;
	}
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
