/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>PasswdModifyReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-上午11:00:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

/** 
* @ClassName: PasswdModifyReq 
* @Description: TODO
* @author huangdongxing
* @date 2015年12月8日 上午11:00:33  
*/
public class PasswordModifyReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 验证码
	 */
	private String authcode;
	/**
	 * 新密码
	 */
	private String newPasswd;
	
	private Integer role;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

}
