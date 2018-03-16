package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Long userId;
	//32位UUID。唯一标识一个用户
	private String uuid;
	//云端和ToB数据同步标志
	private Integer syncFlag;
	//用户名
	private String userName;
	//
	private String cryptPasswd;
	//真实姓名全名
	private String trueName;
	//用户昵称
	private String nickName;
	//用户手机号
	private String mobile;
	//性别
	private Integer sex;
	//生日
	private Date birthDate;
	//头像URL
	private String userPictureUrl;
	//用户邮箱号
	private String email;
	//民族
	private String nation;
	//国家
	private String country;
	//城市代码
	private String cityCode;
	//所在地
	private String city;
	//所在地id
	private Integer cityId;
	//住址
	private String address;
	//籍贯
	private String nativePlace;
	//职业
	private String profession;
	private String rawOccupationId;
	private String rawProfession;
	//工作单位
	private String company;
	//证件类型
	private Integer idType;
	//身份证号/护照/军官证号
	private String identification;
	private String preIdentification;
	//婚姻状况
	private Integer marriageStatus;
	//个性签名
	private String signature;
	//文化程度
	private Integer education;
	//毕业学校
	private String school;
	//兴趣爱好
	private String interest;
	//证件照片URL
	private String idFileUrl;
	//账号类型
	private Integer accountType;
	//APP注册用户标识
	private Integer appFlag;
	//微信用户标识
	private Integer weixinFlag;
	//PC注册用户标识
	private Integer pcFlag;
	//信息填写状态
	private Integer infoState;
	//用户状态
	private Integer state;
	//角色
	private Integer role;
	//子角色Ids
	private String subroles;
	//积分（爱心）。
	private Integer points;
	//记录创建时间
	private Date createTime;
	//个人资料更新时间
	private Date updateTime;
	//首次登录时间
	private Date firstLoginTime;
	//最近登录时间（用于计算用户活跃度）
	private Date lastLoginTime;
	//用户来源标志
	private Integer sourceFlag;
	//用户类型标识
	private Integer userFlag;
	//老系统迁移过来的用户，会打上此标志。用于统计和识别
	private Integer migrateFlag;

	//
	private Long affirmUserId;
	//
	private Integer affirm;
	//
	private Date affirmDateTime;
	//用户角色
	private Integer userRole;
	
	//随访系统----随访患者详情增加以下属性 add by yuan_wm start 20160810
	private String birthPlaceCode;
	
	private String birthPlaceAddress;
	
	private Integer nationId;
	
	private Integer nationalityId;
	
	private Integer occupationId;
	
	private String staffNo; //工号
	private Date rawCreateTime;//原始记录创建时间
	private Date syncTime; // 创建时间
	
	/**
	 * 图形码
	 */
	private String picCode;
	/**
	 * 短信验证码
	 */
	private String smsCode;
	
	/**
	 * 需要密码标识，默认为true：需要
	 */
	private boolean needPwFlag=true;
	
	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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

	public Long getAffirmUserId() {
		return affirmUserId;
	}

	public void setAffirmUserId(Long affirmUserId) {
		this.affirmUserId = affirmUserId;
	}

	public Date getAffirmDateTime() {
		return affirmDateTime;
	}

	public void setAffirmDateTime(Date affirmDateTime) {
		this.affirmDateTime = affirmDateTime;
	}

	public Integer getAffirm() {
		return affirm;
	}

	public void setAffirm(Integer affirm) {
		this.affirm = affirm;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public String getCryptPasswd() {
		return cryptPasswd;
	}

	public void setCryptPasswd(String cryptPasswd) {
		this.cryptPasswd = cryptPasswd;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNativeplace() {
		return nativePlace;
	}

	public void setNativeplace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Integer getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getIdFileUrl() {
		return idFileUrl;
	}

	public void setIdFileUrl(String idFileUrl) {
		this.idFileUrl = idFileUrl;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getSubroles() {
		return subroles;
	}

	public void setSubroles(String subroles) {
		this.subroles = subroles;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getFirstLoginTime() {
		return firstLoginTime;
	}

	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAppFlag() {
		return appFlag;
	}

	public void setAppFlag(Integer appFlag) {
		this.appFlag = appFlag;
	}

	public Integer getWeixinFlag() {
		return weixinFlag;
	}

	public void setWeixinFlag(Integer weixinFlag) {
		this.weixinFlag = weixinFlag;
	}

	public Integer getPcFlag() {
		return pcFlag;
	}

	public void setPcFlag(Integer pcFlag) {
		this.pcFlag = pcFlag;
	}

	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}

	public Integer getMigrateFlag() {
		return migrateFlag;
	}

	public void setMigrateFlag(Integer migrateFlag) {
		this.migrateFlag = migrateFlag;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getBirthPlaceCode() {
		return birthPlaceCode;
	}

	public void setBirthPlaceCode(String birthPlaceCode) {
		this.birthPlaceCode = birthPlaceCode;
	}

	public String getBirthPlaceAddress() {
		return birthPlaceAddress;
	}

	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}

	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public Date getRawCreateTime() {
		return rawCreateTime;
	}

	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getPicCode() {
		return picCode;
	}

	public void setPicCode(String picCode) {
		this.picCode = picCode;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public boolean isNeedPwFlag() {
		return needPwFlag;
	}

	public void setNeedPwFlag(boolean needPwFlag) {
		this.needPwFlag = needPwFlag;
	}

	public String getPreIdentification() {
		return preIdentification;
	}

	public void setPreIdentification(String preIdentification) {
		this.preIdentification = preIdentification;
	}

	public String getRawOccupationId() {
		return rawOccupationId;
	}

	public void setRawOccupationId(String rawOccupationId) {
		this.rawOccupationId = rawOccupationId;
	}

	public String getRawProfession() {
		return rawProfession;
	}

	public void setRawProfession(String rawProfession) {
		this.rawProfession = rawProfession;
	}
	
}