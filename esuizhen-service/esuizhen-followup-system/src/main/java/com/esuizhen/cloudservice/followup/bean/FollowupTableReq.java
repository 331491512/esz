package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class FollowupTableReq {
	private Integer patientId;
	private String serialNo;       //"2015000001",
	private String ICD10;       //"45454",
	private String ICDO;       //"4554556",
	private String diseaseTypes;       //””,
	private Integer isKnown;       //"0",
	private String clinicNo;       //"1111",
	private String inpatientNo;       //"11111",
	private String trueName;       //"杨璧铭"，
	private Integer sex;       //0,
	private String birthDate;       //"1999-01-01"，
	private String nation;       //1,
	private Integer age;       //22,
	private String identification;       //"110822199901019631",
	private String education;       //"0",
	private String profession; //-----------occupation;       //"111",
	private String householdAddress;      //---------registedAddress;       //"户口地址",
	private String liveAddress;        //----------presentAddress;       //"现住址"，
	private String mobile;          //--------familyPhone;       //"0556-2256498",
	private String companyAddress;        //-------company;       //"工作单位",
	private String companyTel;       //"010-225654",
	private String organName;       //"原发部位",
	private String sourcePathologyDiagnosis;   //-----pathologyDiagnosisCode;       //"11",//病理类型
	private Date confirmedDate;         //-------diseaseStartTime;       //"发病日期",
	private String diagnosisBasisId;
	private String diagnosisBasis;       //"诊断依据",
	private String tumourPeriodizationTId;
	private String tumourPeriodizationNId;
	private String tumourPeriodizationM1Id;
	private String tumourPeriodizationT;       //"分期T",
	private String tumourPeriodizationN;       //"分期N",
	private String tumourPeriodizationM1;       //"分期M",
	private String tumourPeriodizationClinicId;
	private String tumourPeriodizationClinic;       //"临床分期",
	private String tumourPeriodization;
	//private String diagnosisOrganization;       //"诊断单位",
	private String outhospitalWard;      //----reportOrganization;       //"报告单位",
	private Date reportDate;       //"2019-02-05",
	private String reportDoctor;       //"111",
	private String isHaveTherapy;       //"0",
	private String operationFlag;
	private String radiotherapyFlag;
	private String chemotherapyFlag;
	private String endocrineTherapyFlag;
	private String targetedTherapyFlag;
	private String unknownFlag;
	private String otherHospital;       //["1","1","1"],
	private String lastCondition;   //-------lastCondition;       //"最后接触状态",
	private String latestFollowupTime;       //"2019-01-01 00;       //00;       //00",
	private String causeOfDeath;           //------deathRootCause;       //"根本死亡原因",
	private Integer isTumourDeath;       //0,  //是否癌症死亡；0;       //否；1;       //是
	private Integer isInHospitalDeath;       //0,     //是否在院死亡。0;       //不详；1;       //是
	private String cancleFollowupDate;       //"2013-02-10 00;       //00;       //00",//取消随访日期
	private String lostFollowupReason;
	private String remark;
	private String followuopDoctor;       //"",//随访医生名字",
	private String checkDoctorSign="癌症中心";       //"癌症中心"//检查医生签名
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getICD10() {
		return ICD10;
	}
	public void setICD10(String iCD10) {
		ICD10 = iCD10;
	}
	public String getICDO() {
		return ICDO;
	}
	public void setICDO(String iCDO) {
		ICDO = iCDO;
	}
	public String getDiseaseTypes() {
		return diseaseTypes;
	}
	public void setDiseaseTypes(String diseaseTypes) {
		this.diseaseTypes = diseaseTypes;
	}
	public Integer getIsKnown() {
		return isKnown;
	}
	public void setIsKnown(Integer isKnown) {
		this.isKnown = isKnown;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public String getInpatientNo() {
		return inpatientNo;
	}
	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getbirthDate() {
		return birthDate;
	}
	public void setbirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getHouseholdAddress() {
		return householdAddress;
	}
	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public String getSourcePathologyDiagnosis() {
		return sourcePathologyDiagnosis;
	}
	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}
	public Date getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public String getDiagnosisBasis() {
		return diagnosisBasis;
	}
	public void setDiagnosisBasis(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}
	public String getTumourPeriodizationT() {
		return tumourPeriodizationT;
	}
	public void setTumourPeriodizationT(String tumourPeriodizationT) {
		this.tumourPeriodizationT = tumourPeriodizationT;
	}
	public String getTumourPeriodizationN() {
		return tumourPeriodizationN;
	}
	public void setTumourPeriodizationN(String tumourPeriodizationN) {
		this.tumourPeriodizationN = tumourPeriodizationN;
	}
	public String getTumourPeriodizationM1() {
		return tumourPeriodizationM1;
	}
	public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
		this.tumourPeriodizationM1 = tumourPeriodizationM1;
	}
	public String getTumourPeriodizationClinic() {
		return tumourPeriodizationClinic;
	}
	public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
		this.tumourPeriodizationClinic = tumourPeriodizationClinic;
	}
	public String getOuthospitalWard() {
		return outhospitalWard;
	}
	public void setOuthospitalWard(String outhospitalWard) {
		this.outhospitalWard = outhospitalWard;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportDoctor() {
		return reportDoctor;
	}
	public void setReportDoctor(String reportDoctor) {
		this.reportDoctor = reportDoctor;
	}
	public String getIsHaveTherapy() {
		return isHaveTherapy;
	}
	public void setIsHaveTherapy(String isHaveTherapy) {
		this.isHaveTherapy = isHaveTherapy;
	}
	public String getOperationFlag() {
		return operationFlag;
	}
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}
	public String getRadiotherapyFlag() {
		return radiotherapyFlag;
	}
	public void setRadiotherapyFlag(String radiotherapyFlag) {
		this.radiotherapyFlag = radiotherapyFlag;
	}
	public String getChemotherapyFlag() {
		return chemotherapyFlag;
	}
	public void setChemotherapyFlag(String chemotherapyFlag) {
		this.chemotherapyFlag = chemotherapyFlag;
	}
	public String getEndocrineTherapyFlag() {
		return endocrineTherapyFlag;
	}
	public void setEndocrineTherapyFlag(String endocrineTherapyFlag) {
		this.endocrineTherapyFlag = endocrineTherapyFlag;
	}
	public String getTargetedTherapyFlag() {
		return targetedTherapyFlag;
	}
	public void setTargetedTherapyFlag(String targetedTherapyFlag) {
		this.targetedTherapyFlag = targetedTherapyFlag;
	}
	public String getUnknownFlag() {
		return unknownFlag;
	}
	public void setUnknownFlag(String unknownFlag) {
		this.unknownFlag = unknownFlag;
	}
	public String getOtherHospital() {
		return otherHospital;
	}
	public void setOtherHospital(String otherHospital) {
		this.otherHospital = otherHospital;
	}
	public String getLastCondition() {
		return lastCondition;
	}
	public void setLastCondition(String lastCondition) {
		this.lastCondition = lastCondition;
	}
	public String getLatestFollowupTime() {
		return latestFollowupTime;
	}
	public void setLatestFollowupTime(String latestFollowupTime) {
		this.latestFollowupTime = latestFollowupTime;
	}
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}
	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}
	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}
	public Integer getIsInHospitalDeath() {
		return isInHospitalDeath;
	}
	public void setIsInHospitalDeath(Integer isInHospitalDeath) {
		this.isInHospitalDeath = isInHospitalDeath;
	}
	public String getCancleFollowupDate() {
		return cancleFollowupDate;
	}
	public void setCancleFollowupDate(String cancleFollowupDate) {
		this.cancleFollowupDate = cancleFollowupDate;
	}
	public String getFollowuopDoctor() {
		return followuopDoctor;
	}
	public void setFollowuopDoctor(String followuopDoctor) {
		this.followuopDoctor = followuopDoctor;
	}
	public String getCheckDoctorSign() {
		return checkDoctorSign;
	}
	public void setCheckDoctorSign(String checkDoctorSign) {
		this.checkDoctorSign = checkDoctorSign;
	}
	public String getTumourPeriodizationTId() {
		return tumourPeriodizationTId;
	}
	public void setTumourPeriodizationTId(String tumourPeriodizationTId) {
		this.tumourPeriodizationTId = tumourPeriodizationTId;
	}
	public String getTumourPeriodizationNId() {
		return tumourPeriodizationNId;
	}
	public void setTumourPeriodizationNId(String tumourPeriodizationNId) {
		this.tumourPeriodizationNId = tumourPeriodizationNId;
	}
	public String getTumourPeriodizationM1Id() {
		return tumourPeriodizationM1Id;
	}
	public void setTumourPeriodizationM1Id(String tumourPeriodizationM1Id) {
		this.tumourPeriodizationM1Id = tumourPeriodizationM1Id;
	}
	public String getDiagnosisBasisId() {
		return diagnosisBasisId;
	}
	public void setDiagnosisBasisId(String diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}
	public String getTumourPeriodizationClinicId() {
		return tumourPeriodizationClinicId;
	}
	public void setTumourPeriodizationClinicId(
			String tumourPeriodizationClinicId) {
		this.tumourPeriodizationClinicId = tumourPeriodizationClinicId;
	}
	public String getTumourPeriodization() {
		return tumourPeriodization;
	}
	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
	}
}
