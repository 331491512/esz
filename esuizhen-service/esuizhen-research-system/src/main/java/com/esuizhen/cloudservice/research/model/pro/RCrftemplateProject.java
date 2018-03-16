package com.esuizhen.cloudservice.research.model.pro;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: RCrftemplateProject</p>
 * <p>Description: 科研专题模板与科研专题关系bean</p>
 * @author YYCHEN
 * @date 2016年4月12日 下午5:08:18
 */
public class RCrftemplateProject implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Integer id;
	//科研模板ID
	private String crfTemplateId;
	//专题ID
	private String projectId;
	//记录创建时间
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCrfTemplateId() {
		return crfTemplateId;
	}
	public void setCrfTemplateId(String crfTemplateId) {
		this.crfTemplateId = crfTemplateId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
