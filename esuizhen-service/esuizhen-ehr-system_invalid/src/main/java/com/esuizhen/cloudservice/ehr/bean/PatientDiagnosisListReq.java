/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientDiagnosisListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午3:13:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: PatientDiagnosisListReq
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午3:13:53  
*/
public class PatientDiagnosisListReq {
	//患者编号
	private Long patientId;
	private String inhospitalId;
	//诊断类型
	private Integer diagnosisTypeId;
	/**
	 * 诊断名称
	 */
	private String diagnosis;
	//页面索引
	private int page;
	//每页数量
	private int num;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
