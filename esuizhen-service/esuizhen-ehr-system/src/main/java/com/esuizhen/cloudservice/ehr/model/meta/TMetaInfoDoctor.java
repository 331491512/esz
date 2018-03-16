package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoDoctor {

	private Long doctorId;
	
	private String trueName;
	
	// add by zhugo 职称
	private String professionalRankName;
	
	// add by zhuguo 科室
	private String deptName;

	public String getProfessionalRankName() {
		return professionalRankName;
	}

	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	
}
