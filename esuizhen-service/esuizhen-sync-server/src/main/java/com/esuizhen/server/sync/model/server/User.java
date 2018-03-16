package com.esuizhen.server.sync.model.server;

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
	//密码
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
	//工作单位
	private String company;
	//公司电话
	private String companyTel;
	//公司邮政编码
	private String comZipCode;
	//证件类型
	private Integer idType;
	//身份证号/护照/军官证号
	private String identification;
	//婚姻状况
	private Integer marriageStatus;
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
	//信息填写状态
	private Integer infoState;
	//记录创建时间
	private Date createTime;
	//个人资料更新时间
	private Date updateTime;
	//用户来源标志
	private Integer sourceFlag;
	private Integer birthPlaceCode;
	private String birthPlaceAddress;
	private String rawOccupationId;
	private String rawProfession;
	private Integer nationId;
	private Integer nationalityId;
	private Integer occupationId;
	private String staffNo; //工号
	private Date rawCreateTime;//原始记录创建时间
	private String patientNo;//病案号
	private String clinicNo;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private Integer state;
	private Integer appFlag;
	private Integer weixinFlag;
	private Integer pcFlag;
	private Integer tobFlag;
	private Date firstLoginTime;

	private String userPictureUrl;
	private String signature;
	private String subroles;
	private Integer points;
	private Date lastLoginTime;
	private Integer userFlag;
	private Integer migrateFlag;
	private Date lastLogoutTime;
	private Date mergeTime;

	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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

	public Date getLastLogoutTime() {
		return lastLogoutTime;
	}

	public void setLastLogoutTime(Date lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}

	public Date getMergeTime() {
		return mergeTime;
	}

	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}

	public Date getFirstLoginTime() {
		return firstLoginTime;
	}

	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
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
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getComZipCode() {
		return comZipCode;
	}
	public void setComZipCode(String comZipCode) {
		this.comZipCode = comZipCode;
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
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Integer getBirthPlaceCode() {
		return birthPlaceCode;
	}
	public void setBirthPlaceCode(Integer birthPlaceCode) {
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
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public Integer getTobFlag() {
		return tobFlag;
	}
	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}
}