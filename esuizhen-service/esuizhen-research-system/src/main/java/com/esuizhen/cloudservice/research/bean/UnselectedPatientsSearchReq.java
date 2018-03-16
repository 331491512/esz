package com.esuizhen.cloudservice.research.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:UnselectedPatientsSearchReq</p>
 * <p>Description:未入组患者筛选参数bean</p>
 * @author YYCHEN
 * @date 2016年5月30日 下午3:12:25
 */
public class UnselectedPatientsSearchReq implements Serializable {
	private static final long serialVersionUID = 1L;

	//页码，从0开始
	private Integer page;
	//每页大小
	private Integer num;
	//专题ID
	private String projectId;
	//性别
	private Integer sex;
	//最小年龄
	private Integer minAge;
	//最大年龄
	private Integer maxAge;
	//地区
	private Integer cityId;
	//婚姻状态
	private Integer marriageStatus;
	//职业
	private Integer professionId;
	//入院标识
	private Integer inhospitalIdentity;
	//最小起始入院时间
	private Date inhospitalStartDate;
	//最大起始入院时间
	private Date inhospitalEndDate;
	//入院科别
	private Integer inhospitalDeptId;
	//出院标识
	private Integer outHospitalIdentity;
	//最小出院时间
	private Date outHospitalStartDate;
	//最大出院时间
	private Date outHospitalEndDate;
	//出院科室
	private Integer outhospitalDeptId;
	//最小确诊年龄
	private Integer conditionMinAge;
	//最大确诊年龄
	private Integer conditionMaxAge;
	//病种
	private Integer diseaseTypeId;
	//确诊起始时间
	private Date conditionStartDate;
	//确诊终止时间
	private Date conditionEndDate;
	//病理诊断内容
	private String pathologyDiagnosis;
	//诊断类型
	private Integer diagnosisType;
	//诊断名称
	private String diagnosisName;
	//诊断分期
	private Integer diagnosisStages;
	//治疗方式
	private Integer treatmentWayId;
	//治疗内容
	private String treatmentContent;
	//随访结果
	private Integer followupResultId;
	//随访开始时间
	private Date followupStartDate;
	//随访结束时间
	private Date followupEndDate;
	
	//医生ID
	private Long doctorId;
	
	public UnselectedPatientsSearchReq(){
		this.page = 0;
		this.num = 10;
	}
	
	public Integer getInhospitalDeptId() {
		return inhospitalDeptId;
	}
	public void setInhospitalDeptId(Integer inhospitalDeptId) {
		this.inhospitalDeptId = inhospitalDeptId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getMinAge() {
		return minAge;
	}
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}
	public Integer getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public Integer getProfessionId() {
		return professionId;
	}
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	public Integer getInhospitalIdentity() {
		return inhospitalIdentity;
	}
	public void setInhospitalIdentity(Integer inhospitalIdentity) {
		this.inhospitalIdentity = inhospitalIdentity;
	}
	public Date getInhospitalStartDate() {
		return inhospitalStartDate;
	}
	public void setInhospitalStartDate(Date inhospitalStartDate) {
		this.inhospitalStartDate = inhospitalStartDate;
	}
	public Date getInhospitalEndDate() {
		return inhospitalEndDate;
	}
	public void setInhospitalEndDate(Date inhospitalEndDate) {
		this.inhospitalEndDate = inhospitalEndDate;
	}
	public Integer getOutHospitalIdentity() {
		return outHospitalIdentity;
	}
	public void setOutHospitalIdentity(Integer outHospitalIdentity) {
		this.outHospitalIdentity = outHospitalIdentity;
	}
	public Date getOutHospitalStartDate() {
		return outHospitalStartDate;
	}
	public void setOutHospitalStartDate(Date outHospitalStartDate) {
		this.outHospitalStartDate = outHospitalStartDate;
	}
	public Date getOutHospitalEndDate() {
		return outHospitalEndDate;
	}
	public void setOutHospitalEndDate(Date outHospitalEndDate) {
		this.outHospitalEndDate = outHospitalEndDate;
	}
	public Integer getOuthospitalDeptId() {
		return outhospitalDeptId;
	}
	public void setOuthospitalDeptId(Integer outhospitalDeptId) {
		this.outhospitalDeptId = outhospitalDeptId;
	}
	public Integer getConditionMinAge() {
		return conditionMinAge;
	}
	public void setConditionMinAge(Integer conditionMinAge) {
		this.conditionMinAge = conditionMinAge;
	}
	public Integer getConditionMaxAge() {
		return conditionMaxAge;
	}
	public void setConditionMaxAge(Integer conditionMaxAge) {
		this.conditionMaxAge = conditionMaxAge;
	}
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
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
	public Integer getDiagnosisType() {
		return diagnosisType;
	}
	public void setDiagnosisType(Integer diagnosisType) {
		this.diagnosisType = diagnosisType;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	public Integer getDiagnosisStages() {
		return diagnosisStages;
	}
	public void setDiagnosisStages(Integer diagnosisStages) {
		this.diagnosisStages = diagnosisStages;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public Integer getTreatmentWayId() {
		return treatmentWayId;
	}
	public void setTreatmentWayId(Integer treatmentWayId) {
		this.treatmentWayId = treatmentWayId;
	}
	public String getTreatmentContent() {
		return treatmentContent;
	}
	public void setTreatmentContent(String treatmentContent) {
		this.treatmentContent = treatmentContent;
	}
	public Integer getFollowupResultId() {
		return followupResultId;
	}
	public void setFollowupResultId(Integer followupResultId) {
		this.followupResultId = followupResultId;
	}
	public Date getFollowupStartDate() {
		return followupStartDate;
	}
	public void setFollowupStartDate(Date followupStartDate) {
		this.followupStartDate = followupStartDate;
	}
	public Date getFollowupEndDate() {
		return followupEndDate;
	}
	public void setFollowupEndDate(Date followupEndDate) {
		this.followupEndDate = followupEndDate;
	}
}
