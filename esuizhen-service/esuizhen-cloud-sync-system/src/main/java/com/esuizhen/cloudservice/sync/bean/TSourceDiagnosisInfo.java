package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者原发诊断信息
 * @author YYCHEN
 *
 */
public class TSourceDiagnosisInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer index;
	private String sourceDiagnosis;
	private String sourceDiseaseCode;
	private Integer sourceDiseaseTypeId;
	private String sourceDiseaseTypeName;
	private Integer diseaseBodyPartId;
	private String diseaseBodyPartName;
	private Date confirmedDate;
	
	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * @return the sourceDiagnosis
	 */
	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	/**
	 * @param sourceDiagnosis the sourceDiagnosis to set
	 */
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	/**
	 * @return the sourceDiseaseCode
	 */
	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}

	/**
	 * @param sourceDiseaseCode the sourceDiseaseCode to set
	 */
	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	/**
	 * @return the sourceDiseaseTypeId
	 */
	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	/**
	 * @param sourceDiseaseTypeId the sourceDiseaseTypeId to set
	 */
	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}

	/**
	 * @return the sourceDiseaseTypeName
	 */
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}

	/**
	 * @param sourceDiseaseTypeName the sourceDiseaseTypeName to set
	 */
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}

	/**
	 * @return the diseaseBodyPartId
	 */
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}

	/**
	 * @param diseaseBodyPartId the diseaseBodyPartId to set
	 */
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}

	/**
	 * @return the diseaseBodyPartName
	 */
	public String getDiseaseBodyPartName() {
		return diseaseBodyPartName;
	}

	/**
	 * @param diseaseBodyPartName the diseaseBodyPartName to set
	 */
	public void setDiseaseBodyPartName(String diseaseBodyPartName) {
		this.diseaseBodyPartName = diseaseBodyPartName;
	}

	/**
	 * @return the confirmedDate
	 */
	public Date getConfirmedDate() {
		return confirmedDate;
	}

	/**
	 * @param confirmedDate the confirmedDate to set
	 */
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
}
