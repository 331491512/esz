/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>LoginByThirdPartyResp.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月11日-下午5:37:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;

import com.westangel.common.bean.user.TUserSyncConfirmInfo;

/** 
* @ClassName: LoginByThirdPartyResp 
* @Description: 第三方响应信息
* @author YYCHEN
* @date 2015年12月11日 下午5:37:01  
*/
public class LoginByThirdPartyResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String trueName;
	private String mobile;
	private Long patientId;
	private Integer accountType;
	private Integer infoState;
	private Integer isFollowup;
	private Integer auditState;
	private Integer wxProductId;
	//1：微信融合；2:三位一体信息同步
	private Integer matchType;
	/**
	 * 注册标志
	 */
	private Integer registerFlag;
	private TUserSyncConfirmInfo confirmInfo;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobile() {
		return mobile;
	}
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Integer getInfoState() {
		return infoState;
	}
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
	public Integer getIsFollowup() {
		return isFollowup;
	}
	public void setIsFollowup(Integer isFollowup) {
		this.isFollowup = isFollowup;
	}
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public Integer getRegisterFlag() {
		return registerFlag;
	}
	public void setRegisterFlag(Integer registerFlag) {
		this.registerFlag = registerFlag;
	}
	public TUserSyncConfirmInfo getConfirmInfo() {
		return confirmInfo;
	}
	public void setConfirmInfo(TUserSyncConfirmInfo confirmInfo) {
		this.confirmInfo = confirmInfo;
	}
	public Integer getWxProductId() {
		return wxProductId;
	}
	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}
}
