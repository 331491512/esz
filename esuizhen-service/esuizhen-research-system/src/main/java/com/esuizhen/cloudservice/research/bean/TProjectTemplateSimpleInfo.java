package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TProjectTemplateSimpleInfo 
* @Description: 科研专题统计信息
* @author YYCHEN
* @date 2016年04月01日 下午17:45:01  
*/
public class TProjectTemplateSimpleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//科研模板ID
	private String crfTemplateId;
	//科研模板名
	private String crfTemplateName;
	//科研模板类型
	private Integer crfTemplateType;
	//描述
	private String description;
	//病种
	private Integer mainDiseaseTypeId;
	//创建医生ID
	private Long author;
	//医生姓名
	private String authorName;
	//是否公开
	private Integer isPublish;
	//随访周期起始标识
	private Integer followupStartMark;
	//引用次数
	private Integer citations;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
	public Integer getFollowupStartMark() {
		return followupStartMark;
	}
	public void setFollowupStartMark(Integer followupStartMark) {
		this.followupStartMark = followupStartMark;
	}
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
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	public Integer getMainDiseaseTypeId() {
		return mainDiseaseTypeId;
	}
	public void setMainDiseaseTypeId(Integer mainDiseaseTypeId) {
		this.mainDiseaseTypeId = mainDiseaseTypeId;
	}
	public Integer getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}
	public Integer getCitations() {
		return citations;
	}
	public void setCitations(Integer citations) {
		this.citations = citations;
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
