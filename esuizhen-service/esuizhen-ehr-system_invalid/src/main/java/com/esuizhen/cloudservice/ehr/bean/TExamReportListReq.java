package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class TExamReportListReq {

	private Long patientId;
	
	private Long examChildTypeId;
	
	private Date excuteTimeStart;
	
	private Date excuteTimeEnd;
	
	private Integer page;
	
	private Integer num;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getExamChildTypeId() {
		return examChildTypeId;
	}

	public void setExamChildTypeId(Long examChildTypeId) {
		this.examChildTypeId = examChildTypeId;
	}

	public Date getExcuteTimeStart() {
		return excuteTimeStart;
	}

	public void setExcuteTimeStart(Date excuteTimeStart) {
		this.excuteTimeStart = excuteTimeStart;
	}

	public Date getExcuteTimeEnd() {
		return excuteTimeEnd;
	}

	public void setExcuteTimeEnd(Date excuteTimeEnd) {
		this.excuteTimeEnd = excuteTimeEnd;
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
}
