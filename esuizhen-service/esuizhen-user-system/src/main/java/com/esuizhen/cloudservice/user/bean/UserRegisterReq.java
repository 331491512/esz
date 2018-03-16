/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>UserRegisterReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:47:35<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

import com.esuizhen.cloudservice.user.model.UUserDevice;

/**
 * @ClassName: UserRegisterReq
 * @Description: 用户注册请求bean
 * @author huangdongxing
 * @date 2015年12月3日 上午11:47:35
 */
public class UserRegisterReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 验证码
	 */
	private String authcode;
	/**
	 * 密码
	 */
	private String cryptPasswd;

	private Integer loginType;
	private Integer role;
	private String invitationCode;
	private UUserDevice deviceInfo;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public UUserDevice getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(UUserDevice deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getCryptPasswd() {
		return cryptPasswd;
	}

	public void setCryptPasswd(String cryptPasswd) {
		this.cryptPasswd = cryptPasswd;
	}

}
