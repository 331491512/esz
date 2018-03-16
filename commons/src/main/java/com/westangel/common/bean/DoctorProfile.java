/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.westangel.common.bean<br/>  
 * <b>文件名：</b>DoctorProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日-下午3:03:06<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: DoctorProfile 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月17日 下午3:03:06  
*/
public class DoctorProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long doctorId;
	private String uuid;
	private String trueName;
	private String mobile;
	private Integer sex;
	private String skills;
	private Integer positionTitleId;
	private String positionTitle;
	private Integer professionalRankId;
	private String professionalRank;
	private Integer hospitalId;
	private String hospitalUuid;
	private String hospitalName;
	private Integer deptId;
	private String deptUuid;
	private String dept;
	private Integer childDeptId;
	private Long subDeptId;
	private String childDeptUuid;
	private String tagIds;
	private String tags;
	private String userPictureUrl;
	private String childDept;
	private String qrcodeUrl;
	private Integer isExpert;
	private String professionCredence;
	private String registerCredence;
	private String workCredence;
	private String professionCredencePicUrl;
	private String registerCredencePicUrl;
	private String workCredencePicUrl;
	private String tel;
	private Integer auditState;
	private String auditRemark;
	private String introduction;
	private Date createTime;
	private Date updateTime;
	//同步标识
	private Integer syncFlag;
	//推荐标志
	private Integer recommendFlag;
	
	//所在医院是否在合作名单中标识
	private Integer hospitalSignedFlag;
	
	//指定的患者是否关注了此医生
	private Integer attentionFlag;
	
	private List<DoctorTag> tagList;

	private String doctorName;
	//员工号
	private String staffNO;
	
	
	public String getStaffNO() {
		return staffNO;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setStaffNO(String staffNO) {
		this.staffNO = staffNO;
	}

	public Long getSubDeptId() {
		return subDeptId;
	}

	public void setSubDeptId(Long subDeptId) {
		this.subDeptId = subDeptId;
	}

	public List<DoctorTag> getTagList() {
		return tagList;
	}

	public Integer getRecommendFlag() {
		return recommendFlag;
	}

	public void setRecommendFlag(Integer recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the userPictureUrl
	 */
	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the auditRemark
	 */
	public String getAuditRemark() {
		return auditRemark;
	}

	/**
	 * @param auditRemark the auditRemark to set
	 */
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @param userPictureUrl the userPictureUrl to set
	 */
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(String professionalRank) {
		this.professionalRank = professionalRank;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getAttentionFlag() {
		return attentionFlag;
	}

	public void setAttentionFlag(Integer attentionFlag) {
		this.attentionFlag = attentionFlag;
	}

	public void setTagList(List<DoctorTag> tagList) {
		this.tagList = tagList;
	}

	public Long getDoctorId() {
		return doctorId;
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

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}

	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}

	/**
	 * @return the deptUuid
	 */
	public String getDeptUuid() {
		return deptUuid;
	}

	/**
	 * @param deptUuid the deptUuid to set
	 */
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}

	/**
	 * @return the childDeptUuid
	 */
	public String getChildDeptUuid() {
		return childDeptUuid;
	}

	/**
	 * @param childDeptUuid the childDeptUuid to set
	 */
	public void setChildDeptUuid(String childDeptUuid) {
		this.childDeptUuid = childDeptUuid;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Integer getChildDeptId() {
		return childDeptId;
	}

	public void setChildDeptId(Integer childDeptId) {
		this.childDeptId = childDeptId;
	}

	public String getChildDept() {
		return childDept;
	}

	public void setChildDept(String childDept) {
		this.childDept = childDept;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public Integer getIsExpert() {
		return isExpert;
	}

	public void setIsExpert(Integer isExpert) {
		this.isExpert = isExpert;
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

	public String getWorkCredence() {
		return workCredence;
	}

	public void setWorkCredence(String workCredence) {
		this.workCredence = workCredence;
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

	public String getWorkCredencePicUrl() {
		return workCredencePicUrl;
	}

	public void setWorkCredencePicUrl(String workCredencePicUrl) {
		this.workCredencePicUrl = workCredencePicUrl;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public Integer getHospitalSignedFlag() {
		return hospitalSignedFlag;
	}

	public void setHospitalSignedFlag(Integer hospitalSignedFlag) {
		this.hospitalSignedFlag = hospitalSignedFlag;
	}

}
