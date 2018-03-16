package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:ProjectSubcenter</p>
 * <p>Description:专题分中心bean</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午11:14:44
 */
public class TProjectSubcenter implements Serializable {
	private static final long serialVersionUID = 1L;

	//分中心ID。主键。自增
	private Long subcenterId;
	//专题ID。外键
	private String projectId;
	//分中心编号。
	private String subcenterNo;
	//分中心名称
	private String subcenterName;
	//分中心负责人
	private Long subcenterDirector;
	//状态。
	private Integer state;
	//描述
	private String description;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getSubcenterNo() {
		return subcenterNo;
	}
	public void setSubcenterNo(String subcenterNo) {
		this.subcenterNo = subcenterNo;
	}
	public String getSubcenterName() {
		return subcenterName;
	}
	public void setSubcenterName(String subcenterName) {
		this.subcenterName = subcenterName;
	}
	public Long getSubcenterDirector() {
		return subcenterDirector;
	}
	public void setSubcenterDirector(Long subcenterDirector) {
		this.subcenterDirector = subcenterDirector;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
