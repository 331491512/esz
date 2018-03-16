package com.westangel.commonservice.authorization.bean;

import java.io.Serializable;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.User;

/**
 * <p>Title:TUserDoctorInfo</p>
 * <p>Description:医生用户bean</p>
 * @author YYCHEN
 * @date 2016年7月5日 上午9:47:28
 */
public class TUserDoctorInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//用户基本信息
	private User userProfile;
	//医生基本信息
	private Doctor doctorProfile;
	
	//页码
	private Integer page;
	//每页大小
	private Integer num;
	//是否使用模糊查询  0：不使用  1：使用
	private Integer patternFlag;
	//账号
	private String userName;
	//姓名
	private String trueName;
	//手机号
	private String mobile;
	//角色
	private Integer userRole;
	//账号状态
	private Integer state;
	//
	private Integer noneStateFlag;
	//科室ID
	private Integer deptId;
	//职务ID
	private Integer positionTitleId;
	//职称ID
	private Integer professionalRankId;
	//员工号
	private String staffNo;
	
	//标识查询用户列表还是员工列表 1:用户列表  0：员工列表
	private Integer accountTypeFlag;
	
	public String getTrueName() {
		return trueName;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getPatternFlag() {
		return patternFlag;
	}
	public void setPatternFlag(Integer patternFlag) {
		this.patternFlag = patternFlag;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getNoneStateFlag() {
		return noneStateFlag;
	}
	public void setNoneStateFlag(Integer noneStateFlag) {
		this.noneStateFlag = noneStateFlag;
	}
	public Integer getAccountTypeFlag() {
		return accountTypeFlag;
	}
	public void setAccountTypeFlag(Integer accountTypeFlag) {
		this.accountTypeFlag = accountTypeFlag;
	}
	public Integer getPositionTitleId() {
		return positionTitleId;
	}
	public void setPositionTitleId(Integer positionTitleId) {
		this.positionTitleId = positionTitleId;
	}
	public Integer getProfessionalRankId() {
		return professionalRankId;
	}
	public void setProfessionalRankId(Integer professionalRankId) {
		this.professionalRankId = professionalRankId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public User getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(User userProfile) {
		this.userProfile = userProfile;
	}
	public Doctor getDoctorProfile() {
		return doctorProfile;
	}
	public void setDoctorProfile(Doctor doctorProfile) {
		this.doctorProfile = doctorProfile;
	}
}
