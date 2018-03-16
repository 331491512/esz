package com.esuizhen.cloudservice.ehr.bean;

public class CommonReq {
	/**
	 * 患者id
	 */
	private Long patientId;

	/**
	 * 住院id
	 */
	private String inhospitalId;

	/**
	 * 门诊id
	 */
	private String clinicMedicalId;

	/**
	 * 患者类型。1：普通（默认）；2：特病; -1: 被合并掉的疑似重复患者(类软删除)
	 */
	private Integer patientType;

	/**
	 * 门诊住院标识；1：门诊；2：住院
	 */
	private Integer outPatientFlag;
	/**
	 * 第几页
	 */
	private Integer page;
	/**
	 * 每页条数
	 */
	private Integer num;
	/**
	 * 治疗类型
	 */
	private Integer treatmentTypeId;
	/**
	 * 患者基本信息登记Id
	 */
	private Long specialDiseaseRegisterId;
	/**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	/**
	 * 医院id
	 */
	private Integer hospitalId;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 病案号
	 */
	private String patientNo;
	/**
	 * 治疗方案id
	 */
	private Integer treatmentSchemeId;
	/**
	 * 操作员
	 */
	private Long operatorId;

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

	public Integer getPatientType() {
		return patientType;
	}

	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
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

	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}

	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
}
