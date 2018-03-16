package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:41
 */
public class TDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long doctorId;
	private Long userId;
	private Long oldUserId;
	private Long parentId;    
	private String parentUuid;	
	private String uuid;
	private String mobile;
	private String trueName;
	private Integer auditState;
	private String nickName;
	private Integer sex;
	private Date birthDate;
	private String userPictureUrl;
	private String professionCredence;
	private String registerCredence;
	private String workCredence;
	private String professionCredencePicUrl;
	private String registerCredencePicUrl;
	private String workCredencePicUrl;
	private Integer isExpert;
	private String skills;
	private String tagIds;
	private String tags;
	private Integer positionTitle;
	private Integer professionalRank;
	private String qrcodeUrl;
	private String tel;
	private String introduction;
	private String auditRemark;
	private Integer recommendFlag;
	private Date createTime;
	private Date updateTime;
	private String staffNo;
	private Date rawCreateTime;
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
	public Long getOldUserId() {
		return oldUserId;
	}
	public void setOldUserId(Long oldUserId) {
		this.oldUserId = oldUserId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentUuid() {
		return parentUuid;
	}
	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
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
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public Integer getRecommendFlag() {
		return recommendFlag;
	}
	public void setRecommendFlag(Integer recommendFlag) {
		this.recommendFlag = recommendFlag;
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
}