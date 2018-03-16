package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultBasicAllergies</p>
 * <p>Description:专题患者邀请bean</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:23:44
 */
public class TProjectInvitationPatient implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键。自增。
	private Long id;
	//分中心ID。
	private Long subcenterId;
	//专题ID。外键。
	private String projectId;
	//邀请者ID。
	private Long inviter;
	//被邀患者ID
	private Long invitee;
	//描述
	private String description;
	//状态
	private Integer state;
	//专题科研患者分组ID。
	private String groupId;
	//医生发送给患者的邀请入组内容。
	private String invitationContent;
	//记录创建时间。
	private Date createTime;
	//记录更新时间
	private Date updateTime;
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
	public String getInvitationContent() {
		return invitationContent;
	}
	public void setInvitationContent(String invitationContent) {
		this.invitationContent = invitationContent;
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
	public Long getInviter() {
		return inviter;
	}
	public void setInviter(Long inviter) {
		this.inviter = inviter;
	}
	public Long getInvitee() {
		return invitee;
	}
	public void setInvitee(Long invitee) {
		this.invitee = invitee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
