package com.esuizhen.cloudservice.ehr.model.meta;

public class TMetaInfoPathologicDiagnosis {

	/**
	 * 病理诊断编码
	 */
	private String pathologyDiagnosisCode;

	/**
	 * 病理诊断名称
	 */
	private String pathologyDiagnosisName;

	/**
	 * 助记词
	 */
	private String helpRememberCode;
	
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public String getPathologyDiagnosisName() {
		return pathologyDiagnosisName;
	}
	public String getHelpRememberCode() {
		return helpRememberCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisName(String pathologyDiagnosisName) {
		this.pathologyDiagnosisName = pathologyDiagnosisName;
	}
	public void setHelpRememberCode(String helpRememberCode) {
		this.helpRememberCode = helpRememberCode;
	}
	
}
