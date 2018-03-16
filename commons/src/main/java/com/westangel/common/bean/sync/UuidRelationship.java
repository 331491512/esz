package com.westangel.common.bean.sync;

import java.io.Serializable;
import java.util.Date;

/**
 * uuid对应关系bean
 * @author YYCHEN
 *
 */
public class UuidRelationship implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private String uuidFinal;
	private String uuid;
	private Integer hospitalId;
	private Integer syncFlag;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUuidFinal() {
		return uuidFinal;
	}
	public void setUuidFinal(String uuidFinal) {
		this.uuidFinal = uuidFinal;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
