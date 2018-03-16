package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户bean
 * @author LHY
 */
public class SyncUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String uuid;
	private String userName;
	private Integer role;
	private Integer accountType;
	private Integer infoState;
	private String trueName;
	private Date createTime;
	private Date firstLoginTime;
	private Date updateTime;
	private String cryptPasswd;
	private String nickName;
	private String mobile;
	private Integer sex;
	private Date birthDate;
	private String userPictureUrl;
	private String email;
	private Integer nationId;
	private String nation;
	private Integer nationalityId;
	private String country;
	private String cityCode;
	private String city;
	private Integer cityId;
	private String address;
	private String nativePlace;
	private String birthPlaceCode;
	private String birthPlaceAddress;
	private Integer occupationId;
	private String profession;
	private String company;
	private Integer idType;
	private String identification;
	private Integer marriageStatus;
	private String signature;
	private Integer education;
	private String school;
	private String interest;
	private String idFileUrl;
	private Integer state;
	private String subroles;
	private Integer points;
	private Date lastLoginTime;
	private Integer sourceFlag;
	private Integer userFlag;
	private Integer migrateFlag;
	private Integer relatedUserId;
	private Date lastLogoutTime;
	private Integer appFlag;
	private Integer weixinFlag;
	private Integer pcFlag;
	private String patientNo;
	private String clinicNo;
	private Integer handleFlag;
	private String staffNo;
	private String companyTel;
	private String comZipCode;
	private Date rawCreateTime;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private String mergeTime;
	private Integer tobFlag;
	private String batchId;
	private String rawOccupationId;
	private String rawProfession;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCryptPasswd() {
		return cryptPasswd;
	}
	public void setCryptPasswd(String cryptPasswd) {
		this.cryptPasswd = cryptPasswd;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNationId() {
		return nationId;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
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
	public Integer getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
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
	public Integer getRelatedUserId() {
		return relatedUserId;
	}
	public void setRelatedUserId(Integer relatedUserId) {
		this.relatedUserId = relatedUserId;
	}
	public Date getLastLogoutTime() {
		return lastLogoutTime;
	}
	public void setLastLogoutTime(Date lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
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
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
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
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
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
	public String getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(String mergeTime) {
		this.mergeTime = mergeTime;
	}
	public Integer getTobFlag() {
		return tobFlag;
	}
	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}