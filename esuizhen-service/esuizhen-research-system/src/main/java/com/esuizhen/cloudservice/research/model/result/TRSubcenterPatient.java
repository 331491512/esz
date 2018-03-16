package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:RSubcenterPatient</p>
 * <p>Description:专题分中心-患者关系bean</p>
 * @author YYCHEN
 * @date 2016年5月31日 上午11:53:19
 */
public class TRSubcenterPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键。自增
	private Long id;
	//分中心ID。外键。
	private Long subcenterId;
	//专题ID。外键。（此处数据冗余，在医生-专题查询时，减少一次关联查询）
	private String projectId;
	//专题科研患者分组ID。
	private String groupId;
	//患者ID。外键
	private Long patientId;
	//记录创建时间
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
