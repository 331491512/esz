/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TDiagnosisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午3:05:54<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TDiagnosisInfo
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午3:05:54  
*/
public class TDiagnosisInfo {
	
	//诊断编号
	private String diagnosisId;
	//诊断类型
	private Integer diagnosisTypeId;
	//诊断内容
	private String diagnosis;
	/**
	 * 诊断编码
	 */
	private String diseaseCode;
	//身体部位
	private String deseaseBodyPartName;
	//病种
	private String diseaseTypeName;
	//就诊时间
	private Date visitTime;
	//病理诊断
	private String pathologyDiagnosis;
	//病理诊断编码
	private String pathologyDiagnosisCode;
	//病理诊断名称
	private String pathologyDiagnosisName;
	//分期
	private String disagnosisPeriodizationName;
	private String organCode;
	private String organName;
	private String inHospitalCondition;
	private String outhospitalCondition;
	//数据来源  2医生上传 3医院同步
	private Integer sourceFlag;
	//创建人
	private Long creatorId;
	//创建人姓名
	private String creatorName;
	private String tumourPeriodization;
	private Integer catalogState;
	private String outhospitalDate;
	private String inhospitalId;
	private Integer isSourceDiagnosis;
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}
	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
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
	public String getDeseaseBodyPartName() {
		return deseaseBodyPartName;
	}
	public void setDeseaseBodyPartName(String deseaseBodyPartName) {
		this.deseaseBodyPartName = deseaseBodyPartName;
	}
	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}
	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getDisagnosisPeriodizationName() {
		return disagnosisPeriodizationName;
	}
	public void setDisagnosisPeriodizationName(String disagnosisPeriodizationName) {
		this.disagnosisPeriodizationName = disagnosisPeriodizationName;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getInHospitalCondition() {
		return inHospitalCondition;
	}
	public void setInHospitalCondition(String inHospitalCondition) {
		this.inHospitalCondition = inHospitalCondition;
	}
	public String getOuthospitalCondition() {
		return outhospitalCondition;
	}
	public void setOuthospitalCondition(String outhospitalCondition) {
		this.outhospitalCondition = outhospitalCondition;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public String getPathologyDiagnosisName() {
		return pathologyDiagnosisName;
	}
	public void setPathologyDiagnosisName(String pathologyDiagnosisName) {
		this.pathologyDiagnosisName = pathologyDiagnosisName;
	}
	public String getTumourPeriodization() {
		return tumourPeriodization;
	}
	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public String getOuthospitalDate() {
		return outhospitalDate;
	}
	public void setOuthospitalDate(String outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public Integer getIsSourceDiagnosis() {
		return isSourceDiagnosis;
	}
	public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
		this.isSourceDiagnosis = isSourceDiagnosis;
	}
}
