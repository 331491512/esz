package com.esuizhen.cloudservice.ehr.bean.medical;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.westangel.common.bean.Patient;

public class PatientMedicalRecordReq {
	
	private Long patientId;

	private String patientNo;
	
	private Integer hospitalId;
	
	private Long operatorId;
	// 住院ID
	private String inhospitalId;
	/**
	 * 就诊类型 1：住院 2：门诊
	 */
	private Integer visitType;
	
	/**
	 * 患者信息
	 */
	private Patient patient;

	/**
	 * 住院记录信息
	 */
	private TInhospitalDetailInfo inhospitalDetailInfo;
	
	/**
	 * 门诊记录信息
	 */
	private PatientClinicInfo patientClinicInfo;
	
	/**
	 * 诊断列表
	 */
	private List<TDiagnosisInfo> diagnosisList;
	
	/**
	 * 手术列表
	 */
	private List<TPatientSurgeryInfo> surgeryList;
	
	/**
	 * 重症监护列表
	 */
	private List<TPatientSurgeryIntensiveCareInfo> surgeryIntensiveCareList;
	
	/**
	 * 治疗列表
	 */
	private List<TPatientTreatmentInfo> treatmentList;
	/**
	 * 表现与发病
	 */
	private PresentationMorbidityInfo presentationMorbidityInfo;
	/**
	 * 体格检查情况
	 */
	private GenenalExamSignsInfo genenalExamSignsInfo;
	
	/**
	 * 身体状况评分
	 */
	private QualityoflifeInfo qualityoflifeInfo;
	
	/**
	 * 不良反应情况
	 */
	private List<AdverseReactionResultInfo> adverseReactionResultList;
	
	/**
	 * 病案是否修改标识
	 */
	private PatientMedicalRecordModifyFlag modifyFlag;

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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getVisitType() {
		return visitType;
	}

	public void setVisitType(Integer visitType) {
		this.visitType = visitType;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public TInhospitalDetailInfo getInhospitalDetailInfo() {
		return inhospitalDetailInfo;
	}

	public void setInhospitalDetailInfo(TInhospitalDetailInfo inhospitalDetailInfo) {
		this.inhospitalDetailInfo = inhospitalDetailInfo;
	}

	public PatientClinicInfo getPatientClinicInfo() {
		return patientClinicInfo;
	}

	public void setPatientClinicInfo(PatientClinicInfo patientClinicInfo) {
		this.patientClinicInfo = patientClinicInfo;
	}

	public List<TDiagnosisInfo> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<TDiagnosisInfo> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}

	public List<TPatientSurgeryInfo> getSurgeryList() {
		return surgeryList;
	}

	public void setSurgeryList(List<TPatientSurgeryInfo> surgeryList) {
		this.surgeryList = surgeryList;
	}

	public List<TPatientSurgeryIntensiveCareInfo> getSurgeryIntensiveCareList() {
		return surgeryIntensiveCareList;
	}

	public void setSurgeryIntensiveCareList(
			List<TPatientSurgeryIntensiveCareInfo> surgeryIntensiveCareList) {
		this.surgeryIntensiveCareList = surgeryIntensiveCareList;
	}

	public List<TPatientTreatmentInfo> getTreatmentList() {
		return treatmentList;
	}

	public void setTreatmentList(List<TPatientTreatmentInfo> treatmentList) {
		this.treatmentList = treatmentList;
	}

	public QualityoflifeInfo getQualityoflifeInfo() {
		return qualityoflifeInfo;
	}

	public void setQualityoflifeInfo(QualityoflifeInfo qualityoflifeInfo) {
		this.qualityoflifeInfo = qualityoflifeInfo;
	}

	public List<AdverseReactionResultInfo> getAdverseReactionResultList() {
		return adverseReactionResultList;
	}

	public void setAdverseReactionResultList(
			List<AdverseReactionResultInfo> adverseReactionResultList) {
		this.adverseReactionResultList = adverseReactionResultList;
	}

	public PatientMedicalRecordModifyFlag getModifyFlag() {
		return modifyFlag;
	}

	public void setModifyFlag(PatientMedicalRecordModifyFlag modifyFlag) {
		this.modifyFlag = modifyFlag;
	}

	public PresentationMorbidityInfo getPresentationMorbidityInfo() {
		return presentationMorbidityInfo;
	}

	public void setPresentationMorbidityInfo(
			PresentationMorbidityInfo presentationMorbidityInfo) {
		this.presentationMorbidityInfo = presentationMorbidityInfo;
	}

	public GenenalExamSignsInfo getGenenalExamSignsInfo() {
		return genenalExamSignsInfo;
	}

	public void setGenenalExamSignsInfo(GenenalExamSignsInfo genenalExamSignsInfo) {
		this.genenalExamSignsInfo = genenalExamSignsInfo;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
}
