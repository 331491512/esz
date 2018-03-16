package com.esuizhen.cloudservice.business.bean;

import java.sql.Timestamp;

/** 
 * @ClassName: MdtDoctorOptionInfo.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public class MdtDoctorOptionInfo {
	private Long id;//建议的id，为空时新增，当不为空是更新
	private String productApplyId;//必传
	private Long doctorUserId;//必传
	private String doctorName;
	private String opinion;
	private Integer flag; //  
	private Integer needRadiateFlag; //是否需要放射科专家协同会诊0：否;1：是(默认) 必传
	private Long radiateUserId;  //  放射专家组ID
	private Integer mdtFlowStateId;//流程id 必传
	private Timestamp createTime;
	private String signatureUrl;
	private Integer specimenIntactFlag;//标本是否完好标识， 0：否，1：是  必传
	private String specimenDestroyReson;//损坏原因 
	private Integer acceptanceTimeFlag;//是否更新标本验收时间, null:不更新，1：更新
	private Integer temporaryFlag;//是否是暂存表示；0：暂存； 1：提交
	/**
	 * 医生类型
	 */
	private Integer groupType;
	
	private Integer hospitalId;//所在的医院
	/**
	 * 医院名称
	 */
	private String hospitalName;
	
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getNeedRadiateFlag() {
		return needRadiateFlag;
	}
	public void setNeedRadiateFlag(Integer needRadiateFlag) {
		this.needRadiateFlag = needRadiateFlag;
	}
	public Long getRadiateUserId() {
		return radiateUserId;
	}
	public void setRadiateUserId(Long radiateUserId) {
		this.radiateUserId = radiateUserId;
	}
	public Integer getMdtFlowStateId() {
		return mdtFlowStateId;
	}
	public void setMdtFlowStateId(Integer mdtFlowStateId) {
		this.mdtFlowStateId = mdtFlowStateId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getSignatureUrl() {
		return signatureUrl;
	}
	public void setSignatureUrl(String signatureUrl) {
		this.signatureUrl = signatureUrl;
	}
	public Integer getGroupType() {
		return groupType;
	}
	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getSpecimenIntactFlag() {
		return specimenIntactFlag;
	}
	public void setSpecimenIntactFlag(Integer specimenIntactFlag) {
		this.specimenIntactFlag = specimenIntactFlag;
	}
	public String getSpecimenDestroyReson() {
		return specimenDestroyReson;
	}
	public void setSpecimenDestroyReson(String specimenDestroyReson) {
		this.specimenDestroyReson = specimenDestroyReson;
	}
	public Integer getAcceptanceTimeFlag() {
		return acceptanceTimeFlag;
	}
	public void setAcceptanceTimeFlag(Integer acceptanceTimeFlag) {
		this.acceptanceTimeFlag = acceptanceTimeFlag;
	}
	public Integer getTemporaryFlag() {
		return temporaryFlag;
	}
	public void setTemporaryFlag(Integer temporaryFlag) {
		this.temporaryFlag = temporaryFlag;
	}
	
	
}
