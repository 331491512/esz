package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:ProjectThresholdPatient</p>
 * <p>Description:专题患者阈值bean</p>
 * @author YYCHEN
 * @date 2016年6月1日 下午4:42:30
 */
public class TProjectThresholdPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键。自增。
	private Long id;
	//专题ID
	private String projectId;
	//患者ID。外键。
	private Long patientId;
	//阈值分类代码
	private String thresholdCode;
	//阈值最大值
	private Float thresholdMax;
	//阈值最小值
	private Float thresholdMin;
	//创建人ID
	private Long creatorId;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getThresholdCode() {
		return thresholdCode;
	}
	public void setThresholdCode(String thresholdCode) {
		this.thresholdCode = thresholdCode;
	}
	public Float getThresholdMax() {
		return thresholdMax;
	}
	public void setThresholdMax(Float thresholdMax) {
		this.thresholdMax = thresholdMax;
	}
	public Float getThresholdMin() {
		return thresholdMin;
	}
	public void setThresholdMin(Float thresholdMin) {
		this.thresholdMin = thresholdMin;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
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
