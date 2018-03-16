package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:FollowupRecordInfo</p>
 * <p>Description:专题患者组信息</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午5:30:07
 */
public class TProjectGroupInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//科研专题患者分组ID
	private String groupId;
	//专题ID。
	private String projectId;
	//组别名称
	private String groupName;
	//患者入组例数。
	private Integer groupNum;
	//已邀请数
	private Integer groupSum;
	//已入组数
	private Integer confirmedNumber;
	//该分组是否启用： 1：启用（默认）；0：不启用。
	private Integer enableFlag;
	//排序索引
	private Integer index;
	//专题描述
	private String description;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Integer getGroupSum() {
		return groupSum;
	}
	public void setGroupSum(Integer groupSum) {
		this.groupSum = groupSum;
	}
	public Integer getConfirmedNumber() {
		return confirmedNumber;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public void setConfirmedNumber(Integer confirmedNumber) {
		this.confirmedNumber = confirmedNumber;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
	public Integer getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(Integer enableFlag) {
		this.enableFlag = enableFlag;
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
}
