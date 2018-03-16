package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: TProjectSimpleInfo 
* @Description: 科研专题简要信息
* @author YYCHEN
* @date 2016年04月01日 下午15:59:01  
*/
public class TProjectSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//专题ID
	private String projectId;
	//专题名称
	private String projectName;
	//自定义专题名称
	private String customName;
	//专题描述
	private String description;
	//专题负责人ID
	private Long projectDirector;
	//专题开始时间
	private Date projectBeginTime;
	//专题结束时间
	private Date projectEndTime;
	//主要病种ID
	private Integer mainDiseaseTypeId;
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
	//图标url
	private String iconUrl;
	//专题分组类型： 0：单臂模式（默认）；1：分组模式。
	private Integer groupType;
	//是否启用多中心模式： 0：不启用（默认）；1：启用。
	private Integer groupTypeEnableFlag;
	//计划入组总例数，参与研究患者总数
	private Integer planInGroupSum;
	//入组截止日期
	private Date inGroupEndDate;
	//专题是否发布。0：未发布；1：已发布。
	private Integer issue;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
	//分中心ID
	private Long subcenterId;
	
	//专题患者组列表
	private List<TProjectGroupInfo> projectGroupList;
	
	private Integer isBaselineCopied;
	
	public Integer getIcfConfirmWay() {
		return icfConfirmWay;
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
	public List<TProjectGroupInfo> getProjectGroupList() {
		return projectGroupList;
	}
	public void setProjectGroupList(List<TProjectGroupInfo> projectGroupList) {
		this.projectGroupList = projectGroupList;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
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
	public Integer getIssue() {
		return issue;
	}
	public void setIssue(Integer issue) {
		this.issue = issue;
	}
	public Long getProjectDirector() {
		return projectDirector;
	}
	public void setProjectDirector(Long projectDirector) {
		this.projectDirector = projectDirector;
	}
	public Date getProjectBeginTime() {
		return projectBeginTime;
	}
	public Integer getIsBaselineCopied() {
		return isBaselineCopied;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
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
	public void setIsBaselineCopied(Integer isBaselineCopied) {
		this.isBaselineCopied = isBaselineCopied;
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
}
