package com.westangel.common.bean.ehr;

import java.io.Serializable;
import java.util.Date;
/**
 * 
* @ClassName: DiagnosisInfo 
* @Description: 患者诊断信息 
* @author YYCHEN
* @date 2016年3月23日 下午3:47:53 
*
 */
public class DiagnosisInfo implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private String diagnosisId;
	private String emrId;
	private Long patientId;
	private String patientNo;
	private Integer diseaseTypeId;
	private String diagnosis;
	private Integer diagnosisTypeId;
	private Integer diseaseBodyPartId;
	private String diseaseCode;
	private String pathologyDiagnosis;
	private String pathologyDiagnosisCode;
	private Integer isSourceDiagnosis;
	private Long diagnosisDoctorUserId;
	private Long diagnosisDoctorId;
	private String diagnosisDoctorName;
	private String remark;
	private Date visitTime;
	private Date createTime;
	private Date updateTime;
	
	public Long getDiagnosisDoctorUserId() {
		return diagnosisDoctorUserId;
	}
	public void setDiagnosisDoctorUserId(Long diagnosisDoctorUserId) {
		this.diagnosisDoctorUserId = diagnosisDoctorUserId;
	}
	public Long getDiagnosisDoctorId() {
		return diagnosisDoctorId;
	}
	public void setDiagnosisDoctorId(Long diagnosisDoctorId) {
		this.diagnosisDoctorId = diagnosisDoctorId;
	}
	public String getDiagnosisDoctorName() {
		return diagnosisDoctorName;
	}
	public void setDiagnosisDoctorName(String diagnosisDoctorName) {
		this.diagnosisDoctorName = diagnosisDoctorName;
	}
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
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
	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}
	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
