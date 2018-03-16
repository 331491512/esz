package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.esuizhen.cloudservice.sync.model.HospitalDoctor;
import com.esuizhen.cloudservice.sync.model.SubDeptDoctor;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.User;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;

/**
 * 医生基本信息
 * @author YYCHEN
 *
 */
public class TDoctorSyncProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer opFlag;
	private String uuid;
	private Long userId;
	private String userNumber;
	private String trueName;
	private Integer sex;
	private String mobile;
	private String email;
	private Long deptId;
	private Long childDeptId;
	private Integer positionTitleId;
	private String positionTitle;
	private Integer professionalRankId;
	private String professionalRank;
	private Integer hospitalId;
	private String hospitalNo;
	private String hospitalUuid;
	private Integer idType;
	private String identification;
	private Date birthDate;
	private String tags;
	private String skills;
	private String hospitalName;
	private String deptUuid;
	private String childDeptUuid;
	private Integer isExpert;
	private String professionCredence;
	private String registerCredence;
	private String workCredence;
	private String tel;
	private String introduction;
	private Integer sourceFlag;
	private List<SubDeptDoctor> tagList;
	
	private String staffNo; //工号
	private Date rawCreateTime;//原始记录创建时间
	private Date createTime; // 创建时间
	private Date updateTime;//修改时间
	private Date syncTime;//同步时间
	private Integer syncFlag; //同步标识
	public Integer getOpFlag() {
		return opFlag;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getChildDeptId() {
		return childDeptId;
	}

	public void setChildDeptId(Long childDeptId) {
		this.childDeptId = childDeptId;
	}

	public Integer getPositionTitleId() {
		return positionTitleId;
	}

	public void setPositionTitleId(Integer positionTitleId) {
		this.positionTitleId = positionTitleId;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public Integer getProfessionalRankId() {
		return professionalRankId;
	}

	public void setProfessionalRankId(Integer professionalRankId) {
		this.professionalRankId = professionalRankId;
	}

	public String getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(String professionalRank) {
		this.professionalRank = professionalRank;
	}

	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalUuid() {
		return hospitalUuid;
	}

	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDeptUuid() {
		return deptUuid;
	}

	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}

	public String getChildDeptUuid() {
		return childDeptUuid;
	}

	public void setChildDeptUuid(String childDeptUuid) {
		this.childDeptUuid = childDeptUuid;
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

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public List<SubDeptDoctor> getTagList() {
		return tagList;
	}

	public void setTagList(List<SubDeptDoctor> tagList) {
		this.tagList = tagList;
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

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public User createUser(){
		User user = new User();
		user.setUuid(uuid);
		user.setUserId(userId);
		user.setRole(Constant.User.ROLE_DOCTOR);
		user.setTrueName(trueName);
		user.setMobile(mobile);
		user.setUserName(mobile);
		user.setSex(sex);
		user.setEmail(email);
		user.setIdType(idType);
		user.setIdentification(identification);
		user.setBirthDate(birthDate);
		user.setCreateTime(createTime);
		user.setCreateTime(createTime);
		user.setUpdateTime(updateTime);
		return user;
	}
	public User createCloudUser(){
		User user = createUser();
		user.setSyncFlag(Constant.User.SYNCFLAG_YES);
		if (StringUtils.isEmpty(user.getUserName())) {
			user.setUserName("TEMP" + GeneralUtil.getCaptchaNum() + GeneralUtil.generatorRandom(10));
		}
		user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		user.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		user.setAccountType(Constant.User.ACCOUNTTYPE_NONACTIVATED);
		user.setRole(Constant.User.ROLE_DOCTOR);
		user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
		user.setState(Constant.User.USERSTATE_NORMAL);
		if (StringUtils.isEmpty(this.identification)) {
			user.setIdType(null);
		}
		user.setPoints(0);
		return user;
	}
	public Doctor createDoctor(){
		Doctor doctor = new Doctor();
		doctor.setUuid(uuid);
		doctor.setTrueName(trueName);
		doctor.setSex(sex);
		doctor.setMobile(mobile);
		doctor.setProfessionalRank(professionalRankId);
		doctor.setPositionTitle(positionTitleId);
		doctor.setBirthDate(birthDate);
		doctor.setCreateTime(createTime);
		doctor.setUpdateTime(updateTime);
		doctor.setSyncTime(syncTime);
		return doctor;
	}
	public Doctor createCloudDoctor(){
		Doctor doctor = createDoctor();
		doctor.setSyncFlag(Constant.User.SYNCFLAG_YES);
		doctor.setAuditState(Constant.User.AUDITSTATE_NOT);
		doctor.setIsExpert(Constant.User.ISEXPERT_NO);
		return doctor;
	}
	
	public HospitalDoctor createHospitalDoctor(){
		HospitalDoctor hospitalDoctor = new HospitalDoctor();
		hospitalDoctor.setHospitalId(hospitalId);
		if(StringUtils.isEmpty(childDeptUuid))
			hospitalDoctor.setDeptUuid(deptUuid);
		else
			hospitalDoctor.setDeptUuid(childDeptUuid);
		hospitalDoctor.setDoctorUuid(uuid);
		hospitalDoctor.setPositionTitle(positionTitleId);
		//员工号写入
		hospitalDoctor.setStaffNo(staffNo);
		hospitalDoctor.setCreateTime(createTime);
		hospitalDoctor.setSyncTime(syncTime);
		return hospitalDoctor;
	}
}
