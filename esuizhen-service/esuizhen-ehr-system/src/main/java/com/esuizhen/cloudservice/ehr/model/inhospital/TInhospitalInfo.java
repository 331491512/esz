package com.esuizhen.cloudservice.ehr.model.inhospital;

import java.util.Date;


public class TInhospitalInfo{
	
	/**
	 * 住院病案ID
	 */
	private String inhospitalId;
	/**
	 * 入院时间
	 */
	private Date inhospitalDate;
	/**
	 * 第几次住院
	 */
	private Integer inhospitalTimes;

	/**
	 * 出院时间
	 */
	private Date outhospitalDate;
	/**
	 * 住院流水号
	 */
	private String inhospitalNo;

	/**
	 * 就诊来源
	 */
	private Integer inhospitalSource;
	
	/**
	 * 离院方式。 1: 医嘱离院（默认） 2: 医嘱转院 3：医嘱转社区卫生服务机构 4：非医嘱离院 5：死亡 9：其他。
	 */
	private Integer outhoispitalWay;

	/**
	 * 离院方式名称
	 */
	private String outhoispitalWayName;
	/**
	 * 门（急）诊诊断
	 */
	private String diagnose;

	/**
	 * 主要诊断内容
	 */
	private String mainDiagnosis;
	
	/**
	 * 出院科别
	 */
	private Integer outhospitalDeptId;
	
	/**
	 * 主要诊断疾病编码
	 */
	private String mainDiagnosisCode;
	
	/**
	 * 住院方式
	 */
	private Integer inhospitalWay;
	
	/**
	 * 入院方式名称
	 */
	private String inhospitalWayName;
	/**
	 * 是否归档
	 */
	private Integer flag;

	/**
	 * 手术名称
	 */
	private String surgeryName;
	
	/**
	 * 出院科别
	 */
	private String outhospitalDeptName;
	
	/**
	 * 操作员ID
	 */
	private Integer operatorId;
	
	/**
	 * 操作员姓名
	 */
	private String operatorName;
	//add by yuan_wm 随访260增加如下属性
	/**
	 * 治疗方式
	 */
	private String treatmentName;
	/**
	 * 多个其他诊断
	 */
	private String otherDiagnosises;
	
	private String patientNo;
	
	private String inchargeDoctorName;
	/*
	 * 1-第一原发，0-非第一原发
	 */
	private Integer firstSourceDiagnosisFlag;
	/**
	 * 编目状态，新定义
	 */
	private Integer catalogState;

	private Integer patientId;
	
	/**
	 * 出院小结标识
	 */
	private Integer summaryFlag;
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getInhospitalId()
	{
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId)
	{
		this.inhospitalId = inhospitalId;
	}

	public Date getInhospitalDate()
	{
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate)
	{
		this.inhospitalDate = inhospitalDate;
	}

	public Integer getInhospitalTimes()
	{
		return inhospitalTimes;
	}

	public void setInhospitalTimes(Integer inhospitalTimes)
	{
		this.inhospitalTimes = inhospitalTimes;
	}

	public Date getOuthospitalDate()
	{
		return outhospitalDate;
	}

	public void setOuthospitalDate(Date outhospitalDate)
	{
		this.outhospitalDate = outhospitalDate;
	}

	public Integer getOuthoispitalWay()
	{
		return outhoispitalWay;
	}

	public void setOuthoispitalWay(Integer outhoispitalWay)
	{
		this.outhoispitalWay = outhoispitalWay;
	}

	public String getDiagnose()
	{
		return diagnose;
	}

	public void setDiagnose(String diagnose)
	{
		this.diagnose = diagnose;
	}

	public String getMainDiagnosis()
	{
		return mainDiagnosis;
	}

	public void setMainDiagnosis(String mainDiagnosis)
	{
		this.mainDiagnosis = mainDiagnosis;
	}

	public Integer getOuthospitalDeptId()
	{
		return outhospitalDeptId;
	}

	public void setOuthospitalDeptId(Integer outhospitalDeptId)
	{
		this.outhospitalDeptId = outhospitalDeptId;
	}

	public String getMainDiagnosisCode()
	{
		return mainDiagnosisCode;
	}

	public void setMainDiagnosisCode(String mainDiagnosisCode)
	{
		this.mainDiagnosisCode = mainDiagnosisCode;
	}

	public Integer getInhospitalWay()
	{
		return inhospitalWay;
	}

	public void setInhospitalWay(Integer inhospitalWay)
	{
		this.inhospitalWay = inhospitalWay;
	}

	public Integer getFlag()
	{
		return flag;
	}

	public void setFlag(Integer flag)
	{
		this.flag = flag;
	}

	public String getOuthoispitalWayName()
	{
		return outhoispitalWayName;
	}

	public void setOuthoispitalWayName(String outhoispitalWayName)
	{
		this.outhoispitalWayName = outhoispitalWayName;
	}

	public String getInhospitalWayName()
	{
		return inhospitalWayName;
	}

	public void setInhospitalWayName(String inhospitalWayName)
	{
		this.inhospitalWayName = inhospitalWayName;
	}

	public String getSurgeryName()
	{
		return surgeryName;
	}

	public void setSurgeryName(String surgeryName)
	{
		this.surgeryName = surgeryName;
	}

	public String getOuthospitalDeptName()
	{
		return outhospitalDeptName;
	}

	public void setOuthospitalDeptName(String outhospitalDeptName)
	{
		this.outhospitalDeptName = outhospitalDeptName;
	}

	public Integer getInhospitalSource()
	{
		return inhospitalSource;
	}

	public void setInhospitalSource(Integer inhospitalSource)
	{
		this.inhospitalSource = inhospitalSource;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getOtherDiagnosises() {
		return otherDiagnosises;
	}

	public void setOtherDiagnosises(String otherDiagnosises) {
		this.otherDiagnosises = otherDiagnosises;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getInchargeDoctorName() {
		return inchargeDoctorName;
	}

	public void setInchargeDoctorName(String inchargeDoctorName) {
		this.inchargeDoctorName = inchargeDoctorName;
	}

	public Integer getFirstSourceDiagnosisFlag() {
		return firstSourceDiagnosisFlag;
	}

	public void setFirstSourceDiagnosisFlag(Integer firstSourceDiagnosisFlag) {
		this.firstSourceDiagnosisFlag = firstSourceDiagnosisFlag;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Integer getSummaryFlag() {
		return summaryFlag;
	}

	public void setSummaryFlag(Integer summaryFlag) {
		this.summaryFlag = summaryFlag;
	}

	public String getInhospitalNo() {
		return inhospitalNo;
	}

	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}

}
