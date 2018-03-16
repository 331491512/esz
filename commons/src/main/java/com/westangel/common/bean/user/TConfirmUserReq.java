package com.westangel.common.bean.user;
/**
 * 
* @ClassName: TConfirmUserInfo 
* @Description: 确认信息 
* @author LIPENG
* @date 2016年2月22日 下午1:43:10 
*
 */
public class TConfirmUserReq {
	private String uuid;
	//微信端需要上传openId和trueName，关系
	private String openId;
	private String trueName;
	private Integer thirdPartyType;
	private Integer sourceFlag;
	private Integer patientRelation;
	
	private String mobile;	
	private Long userId;
	private Integer userRole;
	private Integer isConfirmed;
	
	//匹配类型
	private Integer matchType;
	/**
	 * 验证码
	 */
	private String captcha;
	public Integer getMatchType() {
		return matchType;
	}
	public void setMatchType(Integer matchType) {
		this.matchType = matchType;
	}
	/** 
	* @return uuid 
	*/
	public String getUuid() {
		return uuid;
	}
	/** 
	* @param uuid 要设置的 uuid 
	*/
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
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

	/** 
	* @return mobile 
	*/
	public String getMobile() {
		return mobile;
	}
	/** 
	* @param mobile 要设置的 mobile 
	*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/** 
	* @return userRole 
	*/
	public Integer getUserRole() {
		return userRole;
	}
	/** 
	* @param userRole 要设置的 userRole 
	*/
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getIsConfirmed() {
		return isConfirmed;
	}
	public void setIsConfirmed(Integer isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	/** 
	* @return openId 
	*/
	public String getOpenId() {
		return openId;
	}
	/** 
	* @param openId 要设置的 openId 
	*/
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/** 
	* @return trueName 
	*/
	public String getTrueName() {
		return trueName;
	}
	/** 
	* @param trueName 要设置的 trueName 
	*/
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	/** 
	* @return patientRelation 
	*/
	public Integer getPatientRelation() {
		return patientRelation;
	}
	/** 
	* @param patientRelation 要设置的 patientRelation 
	*/
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}
	/** 
	* @return thirdPartyType 
	*/
	public Integer getThirdPartyType() {
		return thirdPartyType;
	}
	/** 
	* @param thirdPartyType 要设置的 thirdPartyType 
	*/
	public void setThirdPartyType(Integer thirdPartyType) {
		this.thirdPartyType = thirdPartyType;
	}
	/** 
	* @return sourceFlag 
	*/
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	/** 
	* @param sourceFlag 要设置的 sourceFlag 
	*/
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
