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

/** 
* @ClassName: UserRegisterReq 
* @Description: 用户注册请求bean
* @author huangdongxing
* @date 2015年12月3日 上午11:47:35  
*/
public class UserLoginReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 登录名
	 */
	private String userName;
	/**
	* 密码
	*/
	private String cryptPassword;
	/**
	* 设备编号
	*/
	private String deviceId;
	/**
	* 设备类型
	*/
	private String deviceType;
	/**
	* 登录角色
	*/
	private Integer role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCryptPassword() {
		return cryptPassword;
	}

	public void setCryptPassword(String cryptPassword) {
		this.cryptPassword = cryptPassword;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

}
