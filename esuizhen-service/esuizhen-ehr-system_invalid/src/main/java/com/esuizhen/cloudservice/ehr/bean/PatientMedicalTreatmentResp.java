package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PatientMedicalTreatmentResp
 * @Description: 历次就诊
 * @author zhuguo
 * @date 2017-5-27 18:02:05
 */
public class PatientMedicalTreatmentResp {

	// 患者id
	private Long patientId;

	// 排序
	private Integer sortNum;

	// 当前页
	private Integer page;

	// 每页数量
	private Integer num;

	// 统计数量
	private Integer total;

	// 医院id
	private String inhospitalId;

	// 门诊id
	private String clinicMedicalId;

	// 报告时间
	private Date reportDate;

	// 医院名称
	private String hospitalName;

	// 诊断信息
	private String diagnosis;

	// 介入治疗
	private String treatmentTypeName;

	// 出院情况
	private String outhospitalConditionName;

	// 治疗信息
	private List<TreatmentResp> treatmentList;

	// 住院日期
	private Date inhospitalDate;

	// 出院日期
	private Date outhospitalDate;

	// 主要诊断信息
	private String mainDiagnosis;

	// 其他诊断信息
	private List<String> otherDiagnosis;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}

	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}

	public String getOuthospitalConditionName() {
		return outhospitalConditionName;
	}

	public void setOuthospitalConditionName(String outhospitalConditionName) {
		this.outhospitalConditionName = outhospitalConditionName;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
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

	public List<TreatmentResp> getTreatmentList() {
		return treatmentList;
	}

	public void setTreatmentList(List<TreatmentResp> treatmentList) {
		this.treatmentList = treatmentList;
	}

	public Date getInhospitalDate() {
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public Date getOuthospitalDate() {
		return outhospitalDate;
	}

	public void setOuthospitalDate(Date outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}

	public String getMainDiagnosis() {
		return mainDiagnosis;
	}

	public void setMainDiagnosis(String mainDiagnosis) {
		this.mainDiagnosis = mainDiagnosis;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<String> getOtherDiagnosis() {
		return otherDiagnosis;
	}

	public void setOtherDiagnosis(List<String> otherDiagnosis) {
		this.otherDiagnosis = otherDiagnosis;
	}

}
