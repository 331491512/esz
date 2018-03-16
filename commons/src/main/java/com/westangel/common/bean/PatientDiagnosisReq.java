/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientDiagnosisReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午2:55:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: PatientDiagnosisReq
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午2:55:02  
*/
public class PatientDiagnosisReq implements Serializable{
	private static final long serialVersionUID = 1L;
	//诊断编号
	private String diagnosisId;
	//患者编号
	private Long patientId;
	//诊断类型 1.主要诊断 2.其他诊断 9.病理诊断
	private Integer diagnosisTypeId;
	//病种类型
	private Integer diseaseTypeId;
	//诊断内容
	private String diagnosis;
	//疾病编码(ICD-10)
	private String diseaseCode;
	//疾病部位
	private Integer diseaseBodyPartId;
	//病理诊断内容
	private String pathologyDiagnosis;
	//病理诊断编码
	private String pathologyDiagnosisCode;
	//数据来源标识 1.患者添加 2.医生添加
	private Integer sourceFlag;
	//创建者编号
	private Long creatorId;
	//诊断时间
	private Date visitTime;
	//肿瘤分期
	private Integer disagnosisPeriodizationId;
	//emrId
	private String emrId;
	//是否是原发诊断
	private int isSourceDiagnosis;
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
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
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public int getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	public void setIsSourceDiagnosis(int isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
	
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public PatientDiagnosisReq(){};
	public PatientDiagnosisReq(Long patientId,Integer diagnosisTypeId,Integer sourceFlag,Long creatorId){
		this.patientId=patientId;
		this.diagnosisTypeId=diagnosisTypeId;
		this.sourceFlag=sourceFlag;
		this.creatorId = creatorId;
	};
}
