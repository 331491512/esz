package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.westangel.common.bean.user.TDoctorMinInfo;

/** 
* @ClassName: TProjectDetailInfo 
* @Description: 科研专题详细信息
* @author YYCHEN
* @date 2016年04月01日 下午15:59:01  
*/
public class TProjectDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//专题ID
	private String projectId;
	//专题名称
	private String projectName;
	//专题描述
	private String description;
	//专题负责人ID
	private Long projectDirector;
	//专题负责人名称
	private String projectDirectorName;
	//专题开始时间
	private Date projectBeginTime;
	//专题结束时间
	private Date projectEndTime;
	//主要病种ID
	private Integer mainDiseaseTypeId;
	//主要病种名称
	private String mainDiseaseTypeName;
	//分中心负责人名称
	private String subcenterDirector;
	//是否设置了科研模板
	private Integer isProjectTemplateSet;
	//专题状态
	private Integer state;
	//知情同意书url
	private String informedConsentFormUrl;
	//知情同意书(ICF)确认方式
	private Integer icfConfirmWay;
	//专题方案url
	private String projectSchemeUrl;
	//专题二维码URL
	private String projectQRCodeUrl;
	//图标url
	private String iconUrl;
	//专题是否发布。0：未发布；1：已发布
	private Integer issue;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	//科研模版ID
	private String crfTemplateId;
	//专题自定义名称
	private String customName;
	//计划患者入组例数
	private Integer planInGroupSum;
	//已入组患者数
	private Integer confirmedNumber;
	//入组截止时间
	private Date inGroupEndDate;
	//专题分组类型： 0：单臂模式（默认）；1：分组模式。
	private Integer groupType;
	//是否启用多中心模式： 0：不启用（默认）；1：启用。
	private Integer groupTypeEnableFlag;
	
	//分中心ID
	private Long subcenterId;
	//分中心名称
	private String subcenterName;
	//专题创建人所在的分中心ID
	private Long projectCreaterSubcenterId;
	
	//专题模板简要信息
	private TProjectTemplateSimpleInfo projectTemplateSimpleInfo;
	//分中心列表
	private List<TProjectSubcenterSimpleInfo> subcenterList;
	//医生最简信息列表
	private List<TDoctorMinInfo> doctorList;
	//
	private List<TProjectGroupInfo> projectGroupList;
	//医生在专题中的角色列表
	private List<TProjectSubcenterRoleInfo> projectRoleList;
	
	//已入专题患者数
	private Integer patients;
	//待入组患者人数
	private Integer pendingNum;
	//服务器时间
	private Date currentDate;
	
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public List<TProjectSubcenterRoleInfo> getProjectRoleList() {
		return projectRoleList;
	}
	public void setProjectRoleList(List<TProjectSubcenterRoleInfo> projectRoleList) {
		this.projectRoleList = projectRoleList;
	}
	public Integer getConfirmedNumber() {
		return confirmedNumber;
	}
	public Integer getPatients() {
		return patients;
	}
	public void setPatients(Integer patients) {
		this.patients = patients;
	}
	public void setConfirmedNumber(Integer confirmedNumber) {
		this.confirmedNumber = confirmedNumber;
	}
	public Integer getPendingNum() {
		return pendingNum;
	}
	public void setPendingNum(Integer pendingNum) {
		this.pendingNum = pendingNum;
	}
	public Integer getIcfConfirmWay() {
		return icfConfirmWay;
	}
	public Long getProjectCreaterSubcenterId() {
		return projectCreaterSubcenterId;
	}
	public void setProjectCreaterSubcenterId(Long projectCreaterSubcenterId) {
		this.projectCreaterSubcenterId = projectCreaterSubcenterId;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public Integer getIssue() {
		return issue;
	}
	public void setIssue(Integer issue) {
		this.issue = issue;
	}
	public String getSubcenterName() {
		return subcenterName;
	}
	public void setSubcenterName(String subcenterName) {
		this.subcenterName = subcenterName;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public void setIcfConfirmWay(Integer icfConfirmWay) {
		this.icfConfirmWay = icfConfirmWay;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getProjectDirector() {
		return projectDirector;
	}
	public void setProjectDirector(Long projectDirector) {
		this.projectDirector = projectDirector;
	}
	public List<TProjectGroupInfo> getProjectGroupList() {
		return projectGroupList;
	}
	public void setProjectGroupList(List<TProjectGroupInfo> projectGroupList) {
		this.projectGroupList = projectGroupList;
	}
	public String getProjectDirectorName() {
		return projectDirectorName;
	}
	public void setProjectDirectorName(String projectDirectorName) {
		this.projectDirectorName = projectDirectorName;
	}
	public Date getProjectBeginTime() {
		return projectBeginTime;
	}
	public void setProjectBeginTime(Date projectBeginTime) {
		this.projectBeginTime = projectBeginTime;
	}
	public Date getProjectEndTime() {
		return projectEndTime;
	}
	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}
	public Integer getMainDiseaseTypeId() {
		return mainDiseaseTypeId;
	}
	public void setMainDiseaseTypeId(Integer mainDiseaseTypeId) {
		this.mainDiseaseTypeId = mainDiseaseTypeId;
	}
	public String getSubcenterDirector() {
		return subcenterDirector;
	}
	public void setSubcenterDirector(String subcenterDirector) {
		this.subcenterDirector = subcenterDirector;
	}
	public Integer getIsProjectTemplateSet() {
		return isProjectTemplateSet;
	}
	public void setIsProjectTemplateSet(Integer isProjectTemplateSet) {
		this.isProjectTemplateSet = isProjectTemplateSet;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getInformedConsentFormUrl() {
		return informedConsentFormUrl;
	}
	public void setInformedConsentFormUrl(String informedConsentFormUrl) {
		this.informedConsentFormUrl = informedConsentFormUrl;
	}
	public String getProjectSchemeUrl() {
		return projectSchemeUrl;
	}
	public void setProjectSchemeUrl(String projectSchemeUrl) {
		this.projectSchemeUrl = projectSchemeUrl;
	}
	public String getProjectQRCodeUrl() {
		return projectQRCodeUrl;
	}
	public void setProjectQRCodeUrl(String projectQRCodeUrl) {
		this.projectQRCodeUrl = projectQRCodeUrl;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
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
	public TProjectTemplateSimpleInfo getProjectTemplateSimpleInfo() {
		return projectTemplateSimpleInfo;
	}
	public void setProjectTemplateSimpleInfo(TProjectTemplateSimpleInfo projectTemplateSimpleInfo) {
		this.projectTemplateSimpleInfo = projectTemplateSimpleInfo;
	}
	public String getMainDiseaseTypeName() {
		return mainDiseaseTypeName;
	}
	public void setMainDiseaseTypeName(String mainDiseaseTypeName) {
		this.mainDiseaseTypeName = mainDiseaseTypeName;
	}
	public String getCrfTemplateId() {
		return crfTemplateId;
	}
	public void setCrfTemplateId(String crfTemplateId) {
		this.crfTemplateId = crfTemplateId;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public Integer getPlanInGroupSum() {
		return planInGroupSum;
	}
	public void setPlanInGroupSum(Integer planInGroupSum) {
		this.planInGroupSum = planInGroupSum;
	}
	public Date getInGroupEndDate() {
		return inGroupEndDate;
	}
	public void setInGroupEndDate(Date inGroupEndDate) {
		this.inGroupEndDate = inGroupEndDate;
	}
	public Integer getGroupType() {
		return groupType;
	}
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}
	public Integer getGroupTypeEnableFlag() {
		return groupTypeEnableFlag;
	}
	public void setGroupTypeEnableFlag(Integer groupTypeEnableFlag) {
		this.groupTypeEnableFlag = groupTypeEnableFlag;
	}
	public List<TProjectSubcenterSimpleInfo> getSubcenterList() {
		return subcenterList;
	}
	public void setSubcenterList(List<TProjectSubcenterSimpleInfo> subcenterList) {
		this.subcenterList = subcenterList;
	}
	public List<TDoctorMinInfo> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<TDoctorMinInfo> doctorList) {
		this.doctorList = doctorList;
	}
}
