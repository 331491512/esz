package com.esuizhen.cloudservice.business.bean;

public class MdtReq {
	private Long userId;
	private Integer mdtFlowStateId;
	private String doctorName;
	private String recommendedDoctorMobile;
	private String startDate;
	private String endDate;
	/**
	 * 0-待处理，1-已处理
	 */
	private Integer flag;
	private Integer mdtRole;
	private String trueName;
	private String mobile;
	private String sampleNo;
	private String mdtApplyNo;
	private Integer userRole;
	private Integer page;
	private Integer num;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getRecommendedDoctorMobile() {
		return recommendedDoctorMobile;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public void setRecommendedDoctorMobile(String recommendedDoctorMobile) {
		this.recommendedDoctorMobile = recommendedDoctorMobile;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getMdtRole() {
		return mdtRole;
	}
	public void setMdtRole(Integer mdtRole) {
		this.mdtRole = mdtRole;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getMdtApplyNo() {
		return mdtApplyNo;
	}
	public void setMdtApplyNo(String mdtApplyNo) {
		this.mdtApplyNo = mdtApplyNo;
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
