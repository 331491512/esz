package com.esuizhen.cloudservice.research.model.pro;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: Project 
* @Description: 科研专题bean
* @author YYCHEN
* @date 2016年04月01日 下午15:58:01  
*/
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//专题ID
	private String projectId;
	//专题名称
	private String projectName;
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
	//专题方案url
	private String projectSchemeUrl;
	//图标url
	private String iconUrl;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
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
