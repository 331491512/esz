package com.esuizhen.cloudservice.user.bean;

public class TWeixinPatientProfile {
	/*
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 头像url
	 */
	private String headUrl;
	/**
	 * 0:未知，1:男，2:女
	 */
	private Integer sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 证件类型。1：身份证（缺省）2：护照3：军官证
	 */
	private Integer idType;
	/**
	 * 证件号
	 */
	private String identification;
	/**
	 * 患者审核状态。0：未审核（默认）；2：初级审核通过（只要填写了诊断信息即可）；3：实名认证待审核；4：实名认证审核通过。
	 */
	private Integer auditState;
	/**
	 * 信息填写状态。0：未填写个人信息1：填写完个人信息待审核(或医生提交资质信息待审核）2：审核成功3：审核失败
	 */
	private Integer infoState;
	/** 
	* @return name 
	*/
	public String getName() {
		return name;
	}
	/** 
	* @param name 要设置的 name 
	*/
	public void setName(String name) {
		this.name = name;
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
	* @return headUrl 
	*/
	public String getHeadUrl() {
		return headUrl;
	}
	/** 
	* @param headUrl 要设置的 headUrl 
	*/
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	/** 
	* @return sex 
	*/
	public Integer getSex() {
		return sex;
	}
	/** 
	* @param sex 要设置的 sex 
	*/
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/** 
	* @return age 
	*/
	public Integer getAge() {
		return age;
	}
	/** 
	* @param age 要设置的 age 
	*/
	public void setAge(Integer age) {
		this.age = age;
	}
	/** 
	* @return idType 
	*/
	public Integer getIdType() {
		return idType;
	}
	/** 
	* @param idType 要设置的 idType 
	*/
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	/** 
	* @return identification 
	*/
	public String getIdentification() {
		return identification;
	}
	/** 
	* @param identification 要设置的 identification 
	*/
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	/** 
	* @return auditState 
	*/
	public Integer getAuditState() {
		return auditState;
	}
	/** 
	* @param auditState 要设置的 auditState 
	*/
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
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
