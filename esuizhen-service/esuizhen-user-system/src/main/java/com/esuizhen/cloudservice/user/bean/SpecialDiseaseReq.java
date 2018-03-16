package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

/** 
 * @ClassName: SpecialDiseaseReq.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月24日
 */
public class SpecialDiseaseReq {

	private String patientName;
	private String specialDiseaseDiagnosis;
    private Date beginDate;
    private Date endDate;
    private Integer Page=0;
    private Integer num=10;
    private Integer startIndex;
    /**
     * 患者Id
     */
    private Long patientId;
    /**
     * 患者基本信息登记Id
     */
    private Long specialDiseaseRegisterId;
    /**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	
	private String identification;
    
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getSpecialDiseaseDiagnosis() {
		return specialDiseaseDiagnosis;
	}
	public void setSpecialDiseaseDiagnosis(String specialDiseaseDiagnosis) {
		this.specialDiseaseDiagnosis = specialDiseaseDiagnosis;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPage() {
		return Page;
	}
	public void setPage(Integer page) {
		Page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public Integer getOperateFlag() {
		return operateFlag;
	}
	public void setOperateFlag(Integer operateFlag) {
		this.operateFlag = operateFlag;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
}
