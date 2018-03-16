/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>LoginByThirdPartyReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月11日-下午5:25:48<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

/** 
* @ClassName: LoginByThirdPartyReq 
* @Description: 第三方登录
* @author huangdongxing
* @date 2015年12月11日 下午5:25:48  
*/
public class LoginByThirdPartyReq implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 第三方登录平台返回的ID
	 */
	private String openId;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 第三方平台类型
	 */
	private Integer thirdPartyType;
	/**
	 * 验证码
	 */
	private String authcode;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 患与患者关系
	 */
	private Integer patientRelation;
	
	/**
	 * 来源
	 */
	private Integer sourceFlag;
	/**
	 * 医生doctorUserId
	 */
	private Long doctorUserId;
	
	/**
	 * 微信公众号产品Id。
	 * 2：易随诊官方公众号
	 */
	private Integer wxProductId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the sourceFlag
	 */
	public Integer getSourceFlag() {
		return sourceFlag;
	}

	/**
	 * @param sourceFlag the sourceFlag to set
	 */
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the thirdPartyType
	 */
	public Integer getThirdPartyType() {
		return thirdPartyType;
	}

	/**
	 * @param thirdPartyType the thirdPartyType to set
	 */
	public void setThirdPartyType(Integer thirdPartyType) {
		this.thirdPartyType = thirdPartyType;
	}

	/**
	 * @return the authcode
	 */
	public String getAuthcode() {
		return authcode;
	}

	/**
	 * @param authcode the authcode to set
	 */
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @return the patientRelation
	 */
	public Integer getPatientRelation() {
		return patientRelation;
	}

	/**
	 * @return the doctorUserId
	 */
	public Long getDoctorUserId() {
		return doctorUserId;
	}

	/**
	 * @param doctorUserId the doctorUserId to set
	 */
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}

	/**
	 * @param patientRelation the patientRelation to set
	 */
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public Integer getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}
}
