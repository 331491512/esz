package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/**
 * 
* @ClassName: TEmrDiagnosisInfo 
* @Description: 诊断信息 
* @author LIPENG
* @date 2016年3月1日 下午2:41:44 
*
 */

public class TEmrDiagnosisInfo {
	private String diagnosisId;
	private String emrId;
	private Long patientId;
	private String patientNo;
	private Integer diagnosisTypeId=0;
	private String diagnosis="";
	private Integer diseaseTypeId;
	private Integer diseaseBodyPartId=0;
	private String diseaseCode="0";
	private String pathologyDiagnosis;
	private String pathologyDiagnosisCode;
	private Integer isSourceDiagnosis;
	private String remark;
	private Date visitTime;
	private Date createTime;
	private Date updateTime;
	/** 
	* @return diagnosisId 
	*/
	public String getDiagnosisId() {
		return diagnosisId;
	}
	/** 
	* @param diagnosisId 要设置的 diagnosisId 
	*/
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	/** 
	* @return emrId 
	*/
	public String getEmrId() {
		return emrId;
	}
	/** 
	* @param emrId 要设置的 emrId 
	*/
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	/** 
	* @return patientNo 
	*/
	public String getPatientNo() {
		return patientNo;
	}
	/** 
	* @param patientNo 要设置的 patientNo 
	*/
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	/** 
	* @return diagnosisTypeId 
	*/
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	/** 
	* @param diagnosisTypeId 要设置的 diagnosisTypeId 
	*/
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}
	/** 
	* @return diagnosis 
	*/
	public String getDiagnosis() {
		return diagnosis;
	}
	/** 
	* @param diagnosis 要设置的 diagnosis 
	*/
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	/** 
	* @return diseaseTypeId 
	*/
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	/** 
	* @param diseaseTypeId 要设置的 diseaseTypeId 
	*/
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	/** 
	* @return diseaseCode 
	*/
	public String getDiseaseCode() {
		return diseaseCode;
	}
	/** 
	* @param diseaseCode 要设置的 diseaseCode 
	*/
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	/** 
	* @return pathologyDiagnosis 
	*/
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	/** 
	* @param pathologyDiagnosis 要设置的 pathologyDiagnosis 
	*/
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	/** 
	* @return pathologyDiagnosisCode 
	*/
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	/** 
	* @param pathologyDiagnosisCode 要设置的 pathologyDiagnosisCode 
	*/
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	/** 
	* @return isSourceDiagnosis 
	*/
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	/** 
	* @param isSourceDiagnosis 要设置的 isSourceDiagnosis 
	*/
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
	/** 
	* @return remark 
	*/
	public String getRemark() {
		return remark;
	}
	/** 
	* @param remark 要设置的 remark 
	*/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** 
	* @return createTime 
	*/
	public Date getCreateTime() {
		return createTime;
	}
	/** 
	* @param createTime 要设置的 createTime 
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 
	* @return visitTime 
	*/
	public Date getVisitTime() {
		return visitTime;
	}
	/** 
	* @param visitTime 要设置的 visitTime 
	*/
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	/** 
	* @return updateTime 
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	/** 
	* @param updateTime 要设置的 updateTime 
	*/
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 
	* @return diseaseBodyPartId 
	*/
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	/** 
	* @param diseaseBodyPartId 要设置的 diseaseBodyPartId 
	*/
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	/** 
	* @return patientId 
	*/
	public Long getPatientId() {
		return patientId;
	}
	/** 
	* @param patientId 要设置的 patientId 
	*/
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
}
