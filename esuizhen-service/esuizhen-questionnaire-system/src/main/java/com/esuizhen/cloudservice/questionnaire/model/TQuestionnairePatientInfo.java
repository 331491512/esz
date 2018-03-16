package com.esuizhen.cloudservice.questionnaire.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TQuestionnairePatientInfo {
	private Long patientId;
	private String trueName;
	private Integer sex;
	private String sexTxt;
	private String patientNo;
	private Integer age;
	private Integer sourceDiseaseTypeId;
	private String sourceDiseaseTypeName;
	private String sourceDiagnosis;
	private String sourceDiseaseCode;
	private List<HashMap<String,Object>> questionnaireAnswerList;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}
	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}
	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}
	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}
	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}
	public List<HashMap<String, Object>> getQuestionnaireAnswerList() {
		return questionnaireAnswerList;
	}
	public void setQuestionnaireAnswerList(
			List<HashMap<String, Object>> questionnaireAnswerList) {
		this.questionnaireAnswerList = questionnaireAnswerList;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSexTxt() {
		return sexTxt;
	}
	public void setSexTxt(String sexTxt) {
		this.sexTxt = sexTxt;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
