/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.westangel.common.bean<br/>  
 * <b>文件名：</b>UserProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日-下午2:51:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import com.westangel.common.bean.authorization.RUserRole;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: UserProfile 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月17日 下午2:51:10  
*/
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String uuid;
	private String userName;
	private String trueName;
	private String nickName;
	private String cryptPasswd;//密码
	private Integer sex;
	private Date birthDate;
	private String mobile;
	private String city;
	private String cityCode;
	private String country;
	private String address;
	private String email;
	private String nativePlace;
	private String signature;
	private String userPictureUrl;
	private String idFileUrl;
	private Integer marriageStatus;
	private Integer idType;
	private String identification;
	private String profession;
	private String nation;
	private Integer role;
	private String company;
	private String subroles;
	private Integer infoState;
	private Integer points;
	private Integer accountType;
	private Date createTime;
	private Date updateTime;
	private Integer sourceFlag;
	//用户状态
	private Integer state;
	//同步标识
	private Integer syncFlag;
	//APP注册用户标识
	private Integer appFlag;
	//微信用户标识
	private Integer weixinFlag;
	//B端同步标识
	private Integer tobFlag;
	//PC注册用户标识
	private Integer pcFlag;
	//用户类型标识
	private Integer userFlag;
	//老系统迁移过来的用户，会打上此标志。用于统计和识别
	private Integer migrateFlag;
	
	//原密码
	private String obsoletePassword;
	//是否需要确认
	private Integer confirmFlag;
	
	private Date firstLoginTime;
	private Date lastLoginTime;
	
	//医生ID
	private Long doctorId;
	//医院ID
	private Integer hospitalId;
	//职务ID
	private Integer positionTitleId;
	//职务名称
	private String positionTitleName;
	//
	private Integer professionalRankId;
	//
	private String professionalRankName;
	//
	private Integer deptId;
	//
	private String deptName;
	//员工号
	private String staffNo;
	//上级医生ID
	private Long parentId;
	//
	private String qrcodeUrl;
	//直接上级医生姓名
	private Doctor parent;
	//直接下级医生列表
	private List<Doctor> subordinateUserList;
	//账号角色列表
	private List<RUserRole> userRoleList;

	private String birthPlaceAddress;

	//角色ID
	private Integer userRole;
	//角色名称
	private String roleName;
	//角色类型
	private Integer roleType;
	
	private String preIdentification;

	public String getBirthPlaceAddress() {
		return birthPlaceAddress;
	}

	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}

	//add by fanpanwei
	private String smsCode;
	private Integer bySmsCodeFlag=0;//1：需要短信验证；0：默认不需要短信验证
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
	public String getCryptPasswd() {
		return cryptPasswd;
	}
	public void setCryptPasswd(String cryptPasswd) {
		this.cryptPasswd = cryptPasswd;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getUserPictureUrl() {
		return userPictureUrl;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	public String getIdFileUrl() {
		return idFileUrl;
	}
	public void setIdFileUrl(String idFileUrl) {
		this.idFileUrl = idFileUrl;
	}
	public Integer getMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
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
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSubroles() {
		return subroles;
	}
	public void setSubroles(String subroles) {
		this.subroles = subroles;
	}
	public Integer getInfoState() {
		return infoState;
	}
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
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
	public String getObsoletePassword() {
		return obsoletePassword;
	}
	public void setObsoletePassword(String obsoletePassword) {
		this.obsoletePassword = obsoletePassword;
	}
	public Integer getConfirmFlag() {
		return confirmFlag;
	}
	public void setConfirmFlag(Integer confirmFlag) {
		this.confirmFlag = confirmFlag;
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
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getPositionTitleId() {
		return positionTitleId;
	}
	public void setPositionTitleId(Integer positionTitleId) {
		this.positionTitleId = positionTitleId;
	}
	public String getPositionTitleName() {
		return positionTitleName;
	}
	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}
	public Integer getProfessionalRankId() {
		return professionalRankId;
	}
	public void setProfessionalRankId(Integer professionalRankId) {
		this.professionalRankId = professionalRankId;
	}
	public String getProfessionalRankName() {
		return professionalRankName;
	}
	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	public Doctor getParent() {
		return parent;
	}
	public void setParent(Doctor parent) {
		this.parent = parent;
	}
	public List<Doctor> getSubordinateUserList() {
		return subordinateUserList;
	}
	public void setSubordinateUserList(List<Doctor> subordinateUserList) {
		this.subordinateUserList = subordinateUserList;
	}
	public List<RUserRole> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<RUserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	public Integer getBySmsCodeFlag() {
		return bySmsCodeFlag;
	}
	public void setBySmsCodeFlag(Integer bySmsCodeFlag) {
		this.bySmsCodeFlag = bySmsCodeFlag;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getPreIdentification() {
		return preIdentification;
	}

	public void setPreIdentification(String preIdentification) {
		this.preIdentification = preIdentification;
	}

	public Integer getTobFlag() {
		return tobFlag;
	}

	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}
	
}
