package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:FollowupRecordInfo</p>
 * <p>Description:专题内患者筛选使用的参数</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午5:30:07
 */
public class PatientsInProjectSearchReq implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public PatientsInProjectSearchReq(){
		this.page = 0;
		this.num = 10;
	}

	//
	private Integer page;
	//
	private Integer num;
	//
	private String projectId;
	//
	private String trueName;
	//
	private Integer sex;
	//
	private String mobile;
	//
	private String mainDiagnosisName;
	//
	private Long attendingDoctorId;
	//
	private Integer followupResultId;
	//
	private Date conditionStartDate;
	//
	private Date conditionEndDate;
	//
	private Long subcenterId;
	//
	private Long doctorId;
	//
	private String groupId;
	//是否进入了专题
	private Integer inside;
	//排序字段
	private String orderBy;
	//排序类型
	private String orderType;
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderType() {
		return orderType;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getInside() {
		return inside;
	}
	public void setInside(Integer inside) {
		this.inside = inside;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMainDiagnosisName() {
		return mainDiagnosisName;
	}
	public void setMainDiagnosisName(String mainDiagnosisName) {
		this.mainDiagnosisName = mainDiagnosisName;
	}
	public Long getAttendingDoctorId() {
		return attendingDoctorId;
	}
	public void setAttendingDoctorId(Long attendingDoctorId) {
		this.attendingDoctorId = attendingDoctorId;
	}
	public Integer getFollowupResultId() {
		return followupResultId;
	}
	public void setFollowupResultId(Integer followupResultId) {
		this.followupResultId = followupResultId;
	}
	public Date getConditionStartDate() {
		return conditionStartDate;
	}
	public void setConditionStartDate(Date conditionStartDate) {
		this.conditionStartDate = conditionStartDate;
	}
	public Date getConditionEndDate() {
		return conditionEndDate;
	}
	public void setConditionEndDate(Date conditionEndDate) {
		this.conditionEndDate = conditionEndDate;
	}
}
