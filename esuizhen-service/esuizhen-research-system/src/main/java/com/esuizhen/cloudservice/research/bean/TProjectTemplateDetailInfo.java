package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
* @ClassName: TProjectTemplateSimpleInfo 
* @Description: 科研专题详细信息
* @author YYCHEN
* @date 2016年04月01日 下午17:45:01  
*/
public class TProjectTemplateDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//科研模板ID
	private String crfTemplateId;
	//科研模板名
	private String crfTemplateName;
	//科研模板类型
	private Integer crfTemplateType;
	//描述
	private String description;
	//创建医生ID
	private Long author;
	//是否公开
	private Integer isPublish;
	//随访周期起始标识
	private Integer followupStartMark;
	//主要病种ID
	private Integer mainDiseaseTypeId;
	//模板被引用次数. 默认0
	private Integer citations;
	//基线手动拷贝标识。手动拷贝基线观察项设置到其他周期后，其他周期各观察项才点亮并允许设置
	private Integer isBaselineCopied;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
	//CRF随访周期概览
	private List<TCrfCourseOutline> crfCourseList;
	
	//专题ID
	private String projectId;
	
	public String getCrfTemplateId() {
		return crfTemplateId;
	}
	public void setCrfTemplateId(String crfTemplateId) {
		this.crfTemplateId = crfTemplateId;
	}
	public String getCrfTemplateName() {
		return crfTemplateName;
	}
	public void setCrfTemplateName(String crfTemplateName) {
		this.crfTemplateName = crfTemplateName;
	}
	public Integer getCrfTemplateType() {
		return crfTemplateType;
	}
	public void setCrfTemplateType(Integer crfTemplateType) {
		this.crfTemplateType = crfTemplateType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAuthor() {
		return author;
	}
	public void setAuthor(Long author) {
		this.author = author;
	}
	public Integer getFollowupStartMark() {
		return followupStartMark;
	}
	public void setFollowupStartMark(Integer followupStartMark) {
		this.followupStartMark = followupStartMark;
	}
	public Integer getMainDiseaseTypeId() {
		return mainDiseaseTypeId;
	}
	public void setMainDiseaseTypeId(Integer mainDiseaseTypeId) {
		this.mainDiseaseTypeId = mainDiseaseTypeId;
	}
	public Integer getCitations() {
		return citations;
	}
	public void setCitations(Integer citations) {
		this.citations = citations;
	}
	public Integer getIsBaselineCopied() {
		return isBaselineCopied;
	}
	public void setIsBaselineCopied(Integer isBaselineCopied) {
		this.isBaselineCopied = isBaselineCopied;
	}
	public Integer getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
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
	public List<TCrfCourseOutline> getCrfCourseList() {
		return crfCourseList;
	}
	public void setCrfCourseList(List<TCrfCourseOutline> crfCourseList) {
		this.crfCourseList = crfCourseList;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}
