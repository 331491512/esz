package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: UserProfile 
* @Description: 患者诊断信息
* @author YYCHEN
* @date 2015年12月17日 下午2:51:10  
*/
public class SourceDiagnosisInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer index;
	private String sourceDiagnosis;
	private String sourceDiseaseCode;
	private Integer sourceDiseaseTypeId;
	private String sourceDiseaseTypeName;
	private Long diseaseBodyPartId;
	private String diseaseBodyPartName;
	//肿瘤分期
	private Integer disagnosisPeriodizationId;
	private Date confirmedDate;
	
	public Integer getIndex() {
		return index;
	}
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}
	public void setIndex(Integer index) {
		this.index = index;
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

	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}
	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}
	/**
	 * @return the diseaseBodyPartId
	 */
	public Long getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}

	/**
	 * @param diseaseBodyPartId the diseaseBodyPartId to set
	 */
	public void setDiseaseBodyPartId(Long diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}

	public String getDiseaseBodyPartName() {
		return diseaseBodyPartName;
	}
	public void setDiseaseBodyPartName(String diseaseBodyPartName) {
		this.diseaseBodyPartName = diseaseBodyPartName;
	}
	public Date getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public Integer getDisagnosisPeriodizationId() {
		return disagnosisPeriodizationId;
	}
	public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
		this.disagnosisPeriodizationId = disagnosisPeriodizationId;
	}
}
