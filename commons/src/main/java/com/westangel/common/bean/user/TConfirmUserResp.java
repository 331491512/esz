package com.westangel.common.bean.user;

import java.io.Serializable;

public class TConfirmUserResp implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 患者编号
	 */
	private Long patientId;
	/**
	 * 医生编号
	 */
	private Long doctorId;
	/**
	 * 注册标志
	 */
	private Integer registerFlag;
	/**
	 * 账号类型
	 */
	private Integer accountType;
	/**
	 * 信息完善状态
	 */
	private Integer infoState;
	
	private Integer affirm;
	
	/** 
	* @return userId 
	*/
	public Long getUserId() {
		return userId;
	}
	/** 
	* @param userId 要设置的 userId 
	*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getAffirm() {
		return affirm;
	}
	public void setAffirm(Integer affirm) {
		this.affirm = affirm;
	}
	/** 
	* @return patientId 
	*/
	public Long getPatientId() {
		return patientId;
	}
	/** 
	* @param patientId 要设置的 patientId 
	*/
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	/** 
	* @return doctorId 
	*/
	public Long getDoctorId() {
		return doctorId;
	}
	/** 
	* @param doctorId 要设置的 doctorId 
	*/
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/** 
	* @return registerFlag 
	*/
	public Integer getRegisterFlag() {
		return registerFlag;
	}
	/** 
	* @param registerFlag 要设置的 registerFlag 
	*/
	public void setRegisterFlag(Integer registerFlag) {
		this.registerFlag = registerFlag;
	}
	/** 
	* @return accountType 
	*/
	public Integer getAccountType() {
		return accountType;
	}
	/** 
	* @param accountType 要设置的 accountType 
	*/
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/** 
	* @return infoState 
	*/
	public Integer getInfoState() {
		return infoState;
	}
	/** 
	* @param infoState 要设置的 infoState 
	*/
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
}
