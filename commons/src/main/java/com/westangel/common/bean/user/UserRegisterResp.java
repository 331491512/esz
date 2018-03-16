/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>UserRegisterResp.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:44:50<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.user;

import java.io.Serializable;

/** 
* @ClassName: UserRegisterResp 
* @Description: 注册响应bean
* @author YYCHEN
* @date 2015年12月3日 上午11:44:50  
*/
public class UserRegisterResp implements Serializable {
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
	
	//待确认信息
	private TUserSyncConfirmInfo confirmInfo;
	
	//临时用户ID
	private String luid;
	//统计Ping时间间隔。单位：小时
	private Integer pingInterval;

	public Long getUserId() {
		return userId;
	}

	public Integer getRegisterFlag() {
		return registerFlag;
	}

	public void setRegisterFlag(Integer registerFlag) {
		this.registerFlag = registerFlag;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	/** 
	* @return confirmInfo 
	*/
	public TUserSyncConfirmInfo getConfirmInfo() {
		return confirmInfo;
	}

	/** 
	* @param confirmInfo 要设置的 confirmInfo 
	*/
	public void setConfirmInfo(TUserSyncConfirmInfo confirmInfo) {
		this.confirmInfo = confirmInfo;
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

	public String getLuid() {
		return luid;
	}

	public void setLuid(String luid) {
		this.luid = luid;
	}

	public Integer getPingInterval() {
		return pingInterval;
	}

	public void setPingInterval(Integer pingInterval) {
		this.pingInterval = pingInterval;
	}

}
