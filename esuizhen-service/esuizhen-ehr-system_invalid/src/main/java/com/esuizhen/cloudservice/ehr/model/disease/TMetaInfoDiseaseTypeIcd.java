package com.esuizhen.cloudservice.ehr.model.disease;

import java.util.Date;
import java.util.List;
import com.esuizhen.cloudservice.ehr.model.icd10.IcdDiseaseType;

public class TMetaInfoDiseaseTypeIcd{
	
	/**
	 * 病种ID。
	 */
	private Integer diseaseTypeId;
	/**
	 * 病种名称
	 */
	private String diseaseTypeName;
	
	/**
	 * 创建人员
	 */
	private String creatorName;
	
	/**
	 * ICD列表
	 */
	private List<IcdDiseaseType> icdDiseaseTypeList;

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public List<IcdDiseaseType> getIcdDiseaseTypeList() {
		return icdDiseaseTypeList;
	}

	public void setIcdDiseaseTypeList(List<IcdDiseaseType> icdDiseaseTypeList) {
		this.icdDiseaseTypeList = icdDiseaseTypeList;
	}

	

}

