package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoDiagnosisBasis {
	
	/**
	 * 诊断依据id
	 */
	private Integer diagnosisBasisId;

	/**
	 * 诊断依据编码
	 */
	private String diagnosisBasisCode;

	/**
	 * 诊断依据名称
	 */
	private String diagnosisBasisName;
	
	public Integer getDiagnosisBasisId() {
		return diagnosisBasisId;
	}
	public String getDiagnosisBasisCode() {
		return diagnosisBasisCode;
	}
	public String getDiagnosisBasisName() {
		return diagnosisBasisName;
	}
	public void setDiagnosisBasisId(Integer diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}
	public void setDiagnosisBasisCode(String diagnosisBasisCode) {
		this.diagnosisBasisCode = diagnosisBasisCode;
	}
	public void setDiagnosisBasisName(String diagnosisBasisName) {
		this.diagnosisBasisName = diagnosisBasisName;
	}
	
}
