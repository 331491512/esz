package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 医生bean
 * @author YYCHEN
 * @date 2015.12.12 11:32
 */
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long doctorId;
	
	private String uuid;

	private Long userId;

	private String trueName;

	private String nickName;

	private String mobile;

	private Integer sex;
	
	private Integer syncFlag;

	private Date birthDate;

	private String userPictureUrl;

	private String professionCredence;

	private String registerCredence;

	private String professionCredencePicUrl;

	private String registerCredencePicUrl;

	private Integer isExpert;

	private String skills;

	private String tagIds;

	private String tags;

	private Integer positionTitle;

	private String positionTitleName;
	
	private Integer professionalRank;

	private String tel;

	private String introduction;

	private Integer auditState;

	private Date createTime;

	private Date updateTime;
	
	private Integer recommendFlag;//推荐标志
	
	private String workCredence;//工作证号
	
	private String workCredencePicUrl;//工作证图片地址

	private List<DoctorTag> tagList;
	
	private Integer hospitalId;
	private String hospitalName;
	private Integer deptId;
	private Date syncTime;
	

	//邮箱
	private String email;
	//角色ID
	private Integer userRole;
	//角色名称
	private String roleName;
	
	private String staffNo;//员工号
	//直接上级的doctorId
	private Long parentId;
	//直接下级的doctor列表
	private List<Doctor> subordinateUserList;

	public String getPositionTitleName() {
		return positionTitleName;
	}

	public void setPositionTitleName(String positionTitleName) {
		this.positionTitleName = positionTitleName;
	}

	public Long getParentId() {
		return parentId;
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

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<Doctor> getSubordinateUserList() {
		return subordinateUserList;
	}

	public void setSubordinateUserList(List<Doctor> subordinateUserList) {
		this.subordinateUserList = subordinateUserList;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getRecommendFlag() {
		return recommendFlag;
	}

	public void setRecommendFlag(Integer recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getWorkCredencePicUrl() {
		return workCredencePicUrl;
	}

	public void setWorkCredencePicUrl(String workCredencePicUrl) {
		this.workCredencePicUrl = workCredencePicUrl;
	}

	public String getWorkCredence() {
		return workCredence;
	}

	public void setWorkCredence(String workCredence) {
		this.workCredence = workCredence;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

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

	public String getProfessionCredence() {
		return professionCredence;
	}

	public void setProfessionCredence(String professionCredence) {
		this.professionCredence = professionCredence;
	}

	public String getRegisterCredence() {
		return registerCredence;
	}

	public void setRegisterCredence(String registerCredence) {
		this.registerCredence = registerCredence;
	}

	public String getProfessionCredencePicUrl() {
		return professionCredencePicUrl;
	}

	public void setProfessionCredencePicUrl(String professionCredencePicUrl) {
		this.professionCredencePicUrl = professionCredencePicUrl;
	}

	public String getRegisterCredencePicUrl() {
		return registerCredencePicUrl;
	}

	public void setRegisterCredencePicUrl(String registerCredencePicUrl) {
		this.registerCredencePicUrl = registerCredencePicUrl;
	}

	public Integer getIsExpert() {
		return isExpert;
	}

	public void setIsExpert(Integer isExpert) {
		this.isExpert = isExpert;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(Integer positionTitle) {
		this.positionTitle = positionTitle;
	}

	public Integer getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(Integer professionalRank) {
		this.professionalRank = professionalRank;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
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

	public List<DoctorTag> getTagList() {
		return tagList;
	}

	public void setTagList(List<DoctorTag> tagList) {
		this.tagList = tagList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** 
	* @return syncFlag 
	*/
	public Integer getSyncFlag() {
		return syncFlag;
	}

	/** 
	* @param syncFlag 要设置的 syncFlag 
	*/
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
}