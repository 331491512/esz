package com.esuizhen.cloudservice.ehr.model.patientinfo;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalPigeonholeReq;

public class PatientInfoReq extends CommonReq {

	/**
	 * 归档信息
	 */
	private List<InhospitalPigeonholeReq> pigeonholeReq;
	/**
	 * 就诊开始日期
	 */
	private String visitDateStart;
	/**
	 * 就诊结束日期
	 */
	private String visitDateEnd;
	/**
	 * 就诊科室
	 */
	private Integer visitDeptId;

	/**
	 * display=1不展示门诊记录
	 */
	private String display;

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public List<InhospitalPigeonholeReq> getPigeonholeReq() {
		return pigeonholeReq;
	}
	public void setPigeonholeReq(List<InhospitalPigeonholeReq> pigeonholeReq) {
		this.pigeonholeReq = pigeonholeReq;
	}
	public String getVisitDateStart() {
		return visitDateStart;
	}
	public void setVisitDateStart(String visitDateStart) {
		this.visitDateStart = visitDateStart;
	}
	public String getVisitDateEnd() {
		return visitDateEnd;
	}
	public void setVisitDateEnd(String visitDateEnd) {
		this.visitDateEnd = visitDateEnd;
	}
	public Integer getVisitDeptId() {
		return visitDeptId;
	}
	public void setVisitDeptId(Integer visitDeptId) {
		this.visitDeptId = visitDeptId;
	}
}
