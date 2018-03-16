/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TInhospitalInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:43:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TInhospitalInfo
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午11:43:02  
*/
public class TInhospitalInfo {
	
	//住院编号
	private String inhospitalId;
	//住院登记号
	private String inhospitalNo;
	//电子病历编号
	private String emrId;
	//患者编号
	private Long patientId;
	//入院途径
	private Integer inhospitalWay;
	//入院科别
	private Integer inhospitalDeptId;
	//入院病室
	private String inhospitalWard;
	//第几次入院
	private Integer inhospitalTimes;
	//主要诊断内容
	private String mainDiagnosis;
	//主要诊断编码
	private String mainDiagnosisCode;
	//主治医师
	private String inchargeDoctor;
	//出院时间
	private Date outhospitalDate;
	//住院日期
	private Date inhospitalDate;
	//住院科室
	private String inhospitalDeptName;
	//医院名称
	private String hospitalName;
	//住院病案号
	private String patientNo;

	

	public String getInhospitalDeptName() {
		return inhospitalDeptName;
	}

	public void setInhospitalDeptName(String inhospitalDeptName) {
		this.inhospitalDeptName = inhospitalDeptName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getInhospitalNo() {
		return inhospitalNo;
	}

	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
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

	public Integer getInhospitalWay() {
		return inhospitalWay;
	}

	public void setInhospitalWay(Integer inhospitalWay) {
		this.inhospitalWay = inhospitalWay;
	}

	public Integer getInhospitalDeptId() {
		return inhospitalDeptId;
	}

	public void setInhospitalDeptId(Integer inhospitalDeptId) {
		this.inhospitalDeptId = inhospitalDeptId;
	}

	public String getInhospitalWard() {
		return inhospitalWard;
	}

	public void setInhospitalWard(String inhospitalWard) {
		this.inhospitalWard = inhospitalWard;
	}

	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}

	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}

	public String getMainDiagnosis() {
		return mainDiagnosis;
	}

	public void setMainDiagnosis(String mainDiagnosis) {
		this.mainDiagnosis = mainDiagnosis;
	}

	public String getMainDiagnosisCode() {
		return mainDiagnosisCode;
	}

	public void setMainDiagnosisCode(String mainDiagnosisCode) {
		this.mainDiagnosisCode = mainDiagnosisCode;
	}

	public String getInchargeDoctor() {
		return inchargeDoctor;
	}

	public void setInchargeDoctor(String inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}

	public Date getOuthospitalDate() {
		return outhospitalDate;
	}

	public void setOuthospitalDate(Date outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}

	public Date getInhospitalDate() {
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
}
