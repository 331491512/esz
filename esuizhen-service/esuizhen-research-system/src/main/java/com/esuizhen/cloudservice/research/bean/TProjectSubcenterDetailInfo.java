package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:TProjectSubcenterDetailInfo</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午5:14:32
 */
public class TProjectSubcenterDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//专题ID
	private String projectId;
	//分中心ID
	private Long subcenterId;
	//分中心编号
	private String subcenterNo;
	//分中心名称
	private String subcenterName;
	//邀请人doctorId
	private Long doctorId;
	//被邀请者doctorId
	private Long subcenterDirector;
	//分中心所在的医院ID
	private Integer hospitalId;
	//分中心负责人医生所在的科室
	private Integer deptId;
	//科室名称
	private String deptName;
	//分中心负责人姓名
	private String trueName;
	//分中心负责人的邮箱
	private String email;
	//分中心负责人的电话。
	private String mobile;
	//分中心描述
	private String description;
	//医生职称ID
	private Integer professionalRankId;
	//医生职称名称
	private String professionalRankName;
	//该条记录是否能删除。1：可以删除；0：不可删除。
	private Integer deleteFlag;
	//中心负责人  1：是分中心负责人  0：不是负责人
	private Integer presideFlag;
	//当前医生拥有的角色
	private List<TProjectSubcenterRoleInfo> subcenterRoleList;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getSubcenterNo() {
		return subcenterNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setSubcenterNo(String subcenterNo) {
		this.subcenterNo = subcenterNo;
	}
	public Integer getPresideFlag() {
		return presideFlag;
	}
	public void setPresideFlag(Integer presideFlag) {
		this.presideFlag = presideFlag;
	}
	public String getSubcenterName() {
		return subcenterName;
	}
	public void setSubcenterName(String subcenterName) {
		this.subcenterName = subcenterName;
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
	public Long getSubcenterDirector() {
		return subcenterDirector;
	}
	public void setSubcenterDirector(Long subcenterDirector) {
		this.subcenterDirector = subcenterDirector;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public List<TProjectSubcenterRoleInfo> getSubcenterRoleList() {
		return subcenterRoleList;
	}
	public void setSubcenterRoleList(List<TProjectSubcenterRoleInfo> subcenterRoleList) {
		this.subcenterRoleList = subcenterRoleList;
	}
}
