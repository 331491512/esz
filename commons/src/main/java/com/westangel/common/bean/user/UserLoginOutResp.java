package com.westangel.common.bean.user;

import java.io.Serializable;

/** 
* @ClassName: UserLoginOutResp 
* @Description: 
* @author YYCHEN
* @date 2016年1月8日 下午17:13:33  
*/
public class UserLoginOutResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer businessId;
	private Integer productId;
	private Long userId;
	private Long doctorId; 
	private String trueName;
	//医院ID
	private Long hospitalId;
	//医院名称
	private String hospitalName;
	private Integer role;
	private String targetId;
	
	
	public Long getDoctorId() {
		return doctorId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	/** 
	* @return hospitalId 
	*/
	public Long getHospitalId() {
		return hospitalId;
	}
	/** 
	* @param hospitalId 要设置的 hospitalId 
	*/
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	/** 
	* @return hospitalName 
	*/
	public String getHospitalName() {
		return hospitalName;
	}
	/** 
	* @param hospitalName 要设置的 hospitalName 
	*/
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
