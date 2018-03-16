package com.westangel.common.bean.ehr;

import java.io.Serializable;
import java.util.Date;

/**
 * 疾病病种
 * @author YYCHEN
 *
 */
public class MetaCDiseaseType implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	private Integer diseaseTypeId;
	private String diseaseTypeName;
	private Integer diseaseBodyPartId;
	private Integer hospitalId;
	private Integer sortIndex;
	private Date createTime;
	
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
	public Integer getDiseaseBodyPartId() {
		return diseaseBodyPartId;
	}
	public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
		this.diseaseBodyPartId = diseaseBodyPartId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
