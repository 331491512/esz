package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:RSubcenterDoctor</p>
 * <p>Description:专题分中心医生bean</p>
 * @author YYCHEN
 * @date 2016年6月22日 下午4:17:53
 */
public class TRSubcenterDoctor implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键。
	private Integer id;
	//分中心ID
	private Integer subcenterId;
	//专题ID
	private String projectId;
	//医生ID
	private Long doctorId;
	//记录创建时间
	private Date createTime;
	//医生姓名
	private String doctorName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Integer subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
