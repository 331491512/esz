package com.esuizhen.cloudservice.ehr.model.inhospital;

import java.util.Date;

public class PatientClinicInfo {
	/**
	 * 病案号
	 */
	private String patientNo;
	
	/**
	 * 门诊流水号
	 */
	private String clinicNo;
	
	/**
	 * 就诊时间
	 */
	private String visitTime;
	
	/**
	 * 科室
	 */
	private String deptName;
	
	/**
	 * 门诊医师
	 */
	private Long clinicDoctor;
	
	/**
	 * 门诊医师名称
	 */
	private String clinicDoctorName;
	
	/**
	 * 主要诊断
	 */
	private String mainDiagnosis;
	private String diagnose;
	
	/**
	 * 主要诊断编码
	 */
	private String mainDiseaseCode;
	private String diseaseCode;
	
	/**
	 * 其他诊断
	 */
	private String otherDiagnosis;
	
	/**
	 * 其他诊断编码
	 */
	private String otherDiseaseCode;
	
	/**
	 * 治疗方式
	 */
	private String treatmentTypeName;
	/**
	 * 治疗名称（方案）
	 */
	private String treatmentName;
	/**
	 * 门诊病历记录ID
	 */
	private String clinicMedicalId;
	/**
	 * 电子病历ID
	 */
	private String emrId;
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 医院ID
	 */
	private Integer hospitalId;
	
	/**
	 * 医院名称
	 */
	private String hospitalName;
	
	/**
	 * 健康卡号
	 */
	private String healthCardNo;
	/**
	 * 患者姓名
	 */
	private String patientName;
	/**
	 * 患者身份证号
	 */
	private String patientIdno;
	/**
	 * 患者地址
	 */
	private String patientAddress;
	/**
	 * 患者手机号
	 */
	private String patientMobile;
	/**
	 * 患者性别。0 未知的性别,1 男,2 女,9 未说明的性别
	 */
	private Integer patientSex;
	/**
	 * 出生日期
	 */
	private Date patientBirth;
	
	/**
	 * 出生地县级城市代码
	 */
	private String birthPlaceCountyCode;
	
	/**
	 * 出生地市级城市代码
	 */
	private String birthPlaceCityCode;
	
	/**
	 * 出生省级城市代码
	 */
	private String birthPlaceProvinceCode;
	
	/**
	 * 出生地地址
	 */
	private String birthPlaceAddress;
	/**
	 * 出生地
	 */
	private String birthPlace;
	
	/**
	 * 患者年龄
	 */
	private Integer patientAge;
	/**
	 * 科室ID.
	 */
	private Integer deptId;
	/**
	 * 主诊医生ID
	 */
	private Long attendingDoctorId;
	private String attendingDoctorNo;
	/**
	 * 主诊医生姓名
	 */
	private String attendingDoctorName;
	/**
	 * 症状描述
	 */
	private String symptomSummary;
	/**
	 * 门诊描述
	 */
	private String remark;
	/**
	 * 门诊次数
	 */
	private Integer visitTimes;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	
	/**
	 * 医疗付费方式
	 */
	private Integer medicalPayType;
	/**
	 * 国籍id
	 */
	private Integer nationalityId;
	/**
	 * 国籍名称
	 */
	private String nationalityName;
	/**
	 * 不足一周岁年龄
	 */
	private Integer babyAge;
	/**
	 * 新生儿出生体重
	 */
	private Integer babyBornWeight;
	/**
	 * 新生儿入院体重
	 */
	private Integer babyWeightInHospital;
	/**
	 * 籍贯省份代码
	 */
	private String nativePlaceProvinceCode;
	/**
	 * 籍贯城市代码
	 */
	private String nativePlaceCityCode;
	/**
	 * 籍贯地详细地址
	 */
	private String nativePlaceAddress;
	/**
	 * 籍贯
	 */
	private String nativePlace;
	/**
	 * 职业名称
	 */
	private String occupationName;
	/**
	 * 职业id
	 */
	private Integer occupationId;
	/**
	 * 婚姻状况
	 */
	private Integer marriageStatus;
	/**
	 * 居住所在地邮编
	 */
	private String liveZipCode;
	/**
	 * 居住地详细地址
	 */
	private String liveAddress;
	/**
	 * 居住地电话号码
	 */
	private String liveTel;
	/**
	 * 居住地省份
	 */
	private String liveProvinceCode;
	/**居住地城市
	 * 
	 */
	private String liveCityCode;
	/**
	 * 居住地县
	 */
	private String liveCountyCode;
	/**
	 * 户口所在地省份
	 */
	private String householdProvinceCode;
	/**
	 * 户口所在地城市
	 */
	private String householdCityCode;
	/**
	 * 户口所在地县
	 */
	private String householdCountyCode;
	/**
	 * 户口所在地邮编
	 */
	private String householdZipCode;
	/**
	 * 户口地详细地址
	 */
	private String householdAddress;
	/**
	 * 单位所在地邮编
	 */
	private String companyZipCode;
	/**
	 * 工作单位详细地址
	 */
	private String companyAddress;
	/**
	 * 工作单位省份
	 */
	private String companyProvinceCode;
	/**
	 * 工作单位城市
	 */
	private String companyCityCode;
	/**
	 * 工作单位县
	 */
	private String companyCountyCode;
	
	private String companyTel;
	/**
	 * 家庭联系人电话
	 */
	private String familyTel;
	/**
	 *  家庭联系人省份
	 */
	private String familyProvinceCode;
	/**
	 *  家庭联系人城市
	 */
	private String familyCityCode;
	/**
	 *  家庭联系人县
	 */
	private String familyCountyCode;
	/**
	 * 家庭地址（联系人地址）
	 */
	private String familyAddress;
	/**
	 * 家属姓名（联系人）
	 */
	private String familyName;
	/**
	 * 与患者关系
	 */
	private Integer patientRelation;
	/**
	 * 病理诊断内容
	 */
	private String pathologyDiagnosis;
	/**
	 * 病理诊断编码
	 */
	private String pathologyDiagnosisCode;
	/**
	 * 病理编号
	 */
	private String pathologyNo;
	/**
	 * 肿瘤分期
	 */
	private String tumourPeriodization;
	/**
	 * 肿瘤分期T
	 */
	private String tumourPeriodizationT;
	private Integer tumourPeriodizationTId; 
	/**
	 * 肿瘤分期N
	 */
	private String tumourPeriodizationN;
	private Integer tumourPeriodizationNId;
	/**
	 * 肿瘤分期M
	 */
	private String tumourPeriodizationM1;
	public Integer getTumourPeriodizationTId() {
		return tumourPeriodizationTId;
	}

	public void setTumourPeriodizationTId(Integer tumourPeriodizationTId) {
		this.tumourPeriodizationTId = tumourPeriodizationTId;
	}

	public Integer getTumourPeriodizationNId() {
		return tumourPeriodizationNId;
	}

	public void setTumourPeriodizationNId(Integer tumourPeriodizationNId) {
		this.tumourPeriodizationNId = tumourPeriodizationNId;
	}

	public Integer getTumourPeriodizationM1Id() {
		return tumourPeriodizationM1Id;
	}

	public void setTumourPeriodizationM1Id(Integer tumourPeriodizationM1Id) {
		this.tumourPeriodizationM1Id = tumourPeriodizationM1Id;
	}

	private Integer tumourPeriodizationM1Id;
	/**
	 * 肿瘤临床分期
	 */
	private String tumourPeriodizationClinic;
	private Integer tumourPeriodizationClinicId;
	/**
	 * 是否药物过敏0：否 1：是
	 */
	private Integer isAllergy;
	
	/**
	 * 药物过敏描述
	 */
	private String allergyDesc;
	/**
	 * ABO血型
	 */
	private Integer aboBlood;
	/**
	 * RH血型
	 */
	private Integer rhBlood;
	/**
	 * 红细胞
	 */
	private Integer redBloodCell;
	/**
	 * 血小板
	 */
	private Integer platelet;
	/**
	 * 血浆
	 */
	private Integer plasma;
	/**
	 * 全血
	 */
	private Integer wholeBlood;
	/**
	 * 其他
	 */
	private Integer other;
	
	/**
	 * 操作员（doctorId）
	 */
	private Long operatorId;
	
	private Date adverseReactionWriteTime;
	
	/**
	 * 证件类型
	 */
	private Integer idType;
	
	/**
	 * 门诊病室
	 */
	private String clinicWard;
	
	/**
	 * 入院途径 1:急诊; 2:门诊; 3:其他医疗机构转入; 9:其他
	 */
	private Integer clinicWay;
	
	private Integer catalogState;
	
	private Integer nationId;
	
	private String nation;
	
	/**
	 * 科室医生
	 */
	private Long deptDoctor;
	/**
	 * 科主任姓名
	 */
	private String deptDoctorName;
	
	/**
	 * 主任医师
	 */
	private Long directorDoctor;
	/**
	 * 主任医师姓名
	 */
	private String directorDoctorName;

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getClinicDoctor() {
		return clinicDoctor;
	}

	public void setClinicDoctor(Long clinicDoctor) {
		this.clinicDoctor = clinicDoctor;
	}

	public String getClinicDoctorName() {
		return clinicDoctorName;
	}

	public void setClinicDoctorName(String clinicDoctorName) {
		this.clinicDoctorName = clinicDoctorName;
	}

	public String getMainDiagnosis() {
		return mainDiagnosis;
	}

	public void setMainDiagnosis(String mainDiagnosis) {
		this.mainDiagnosis = mainDiagnosis;
	}

	public String getMainDiseaseCode() {
		return mainDiseaseCode;
	}

	public void setMainDiseaseCode(String mainDiseaseCode) {
		this.mainDiseaseCode = mainDiseaseCode;
	}

	public String getOtherDiagnosis() {
		return otherDiagnosis;
	}

	public void setOtherDiagnosis(String otherDiagnosis) {
		this.otherDiagnosis = otherDiagnosis;
	}

	public String getOtherDiseaseCode() {
		return otherDiseaseCode;
	}

	public void setOtherDiseaseCode(String otherDiseaseCode) {
		this.otherDiseaseCode = otherDiseaseCode;
	}

	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}

	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHealthCardNo() {
		return healthCardNo;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientIdno() {
		return patientIdno;
	}

	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	public Integer getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(Integer patientSex) {
		this.patientSex = patientSex;
	}

	public Date getPatientBirth() {
		return patientBirth;
	}

	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}

	public String getBirthPlaceCountyCode() {
		return birthPlaceCountyCode;
	}

	public void setBirthPlaceCountyCode(String birthPlaceCountyCode) {
		this.birthPlaceCountyCode = birthPlaceCountyCode;
	}

	public String getBirthPlaceCityCode() {
		return birthPlaceCityCode;
	}

	public void setBirthPlaceCityCode(String birthPlaceCityCode) {
		this.birthPlaceCityCode = birthPlaceCityCode;
	}

	public String getBirthPlaceProvinceCode() {
		return birthPlaceProvinceCode;
	}

	public void setBirthPlaceProvinceCode(String birthPlaceProvinceCode) {
		this.birthPlaceProvinceCode = birthPlaceProvinceCode;
	}

	public String getBirthPlaceAddress() {
		return birthPlaceAddress;
	}

	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Long getAttendingDoctorId() {
		return attendingDoctorId;
	}

	public void setAttendingDoctorId(Long attendingDoctorId) {
		this.attendingDoctorId = attendingDoctorId;
	}

	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}

	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}

	public String getSymptomSummary() {
		return symptomSummary;
	}

	public void setSymptomSummary(String symptomSummary) {
		this.symptomSummary = symptomSummary;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getVisitTimes() {
		return visitTimes;
	}

	public void setVisitTimes(Integer visitTimes) {
		this.visitTimes = visitTimes;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getMedicalPayType() {
		return medicalPayType;
	}

	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}

	public Integer getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Integer nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public Integer getBabyAge() {
		return babyAge;
	}

	public void setBabyAge(Integer babyAge) {
		this.babyAge = babyAge;
	}

	public Integer getBabyBornWeight() {
		return babyBornWeight;
	}

	public void setBabyBornWeight(Integer babyBornWeight) {
		this.babyBornWeight = babyBornWeight;
	}

	public Integer getBabyWeightInHospital() {
		return babyWeightInHospital;
	}

	public void setBabyWeightInHospital(Integer babyWeightInHospital) {
		this.babyWeightInHospital = babyWeightInHospital;
	}

	public String getNativePlaceProvinceCode() {
		return nativePlaceProvinceCode;
	}

	public void setNativePlaceProvinceCode(String nativePlaceProvinceCode) {
		this.nativePlaceProvinceCode = nativePlaceProvinceCode;
	}

	public String getNativePlaceCityCode() {
		return nativePlaceCityCode;
	}

	public void setNativePlaceCityCode(String nativePlaceCityCode) {
		this.nativePlaceCityCode = nativePlaceCityCode;
	}

	public String getNativePlaceAddress() {
		return nativePlaceAddress;
	}

	public void setNativePlaceAddress(String nativePlaceAddress) {
		this.nativePlaceAddress = nativePlaceAddress;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getLiveZipCode() {
		return liveZipCode;
	}

	public void setLiveZipCode(String liveZipCode) {
		this.liveZipCode = liveZipCode;
	}

	public String getLiveAddress() {
		return liveAddress;
	}

	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}

	public String getLiveTel() {
		return liveTel;
	}

	public void setLiveTel(String liveTel) {
		this.liveTel = liveTel;
	}

	public String getLiveProvinceCode() {
		return liveProvinceCode;
	}

	public void setLiveProvinceCode(String liveProvinceCode) {
		this.liveProvinceCode = liveProvinceCode;
	}

	public String getLiveCityCode() {
		return liveCityCode;
	}

	public void setLiveCityCode(String liveCityCode) {
		this.liveCityCode = liveCityCode;
	}

	public String getLiveCountyCode() {
		return liveCountyCode;
	}

	public void setLiveCountyCode(String liveCountyCode) {
		this.liveCountyCode = liveCountyCode;
	}

	public String getHouseholdProvinceCode() {
		return householdProvinceCode;
	}

	public void setHouseholdProvinceCode(String householdProvinceCode) {
		this.householdProvinceCode = householdProvinceCode;
	}

	public String getHouseholdCityCode() {
		return householdCityCode;
	}

	public void setHouseholdCityCode(String householdCityCode) {
		this.householdCityCode = householdCityCode;
	}

	public String getHouseholdCountyCode() {
		return householdCountyCode;
	}

	public void setHouseholdCountyCode(String householdCountyCode) {
		this.householdCountyCode = householdCountyCode;
	}

	public String getHouseholdZipCode() {
		return householdZipCode;
	}

	public void setHouseholdZipCode(String householdZipCode) {
		this.householdZipCode = householdZipCode;
	}

	public String getHouseholdAddress() {
		return householdAddress;
	}

	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
	}

	public String getCompanyZipCode() {
		return companyZipCode;
	}

	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyProvinceCode() {
		return companyProvinceCode;
	}

	public void setCompanyProvinceCode(String companyProvinceCode) {
		this.companyProvinceCode = companyProvinceCode;
	}

	public String getCompanyCityCode() {
		return companyCityCode;
	}

	public void setCompanyCityCode(String companyCityCode) {
		this.companyCityCode = companyCityCode;
	}

	public String getCompanyCountyCode() {
		return companyCountyCode;
	}

	public void setCompanyCountyCode(String companyCountyCode) {
		this.companyCountyCode = companyCountyCode;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getFamilyTel() {
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	public String getFamilyProvinceCode() {
		return familyProvinceCode;
	}

	public void setFamilyProvinceCode(String familyProvinceCode) {
		this.familyProvinceCode = familyProvinceCode;
	}

	public String getFamilyCityCode() {
		return familyCityCode;
	}

	public void setFamilyCityCode(String familyCityCode) {
		this.familyCityCode = familyCityCode;
	}

	public String getFamilyCountyCode() {
		return familyCountyCode;
	}

	public void setFamilyCountyCode(String familyCountyCode) {
		this.familyCountyCode = familyCountyCode;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Integer getPatientRelation() {
		return patientRelation;
	}

	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}

	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}

	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}

	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}

	public String getPathologyNo() {
		return pathologyNo;
	}

	public void setPathologyNo(String pathologyNo) {
		this.pathologyNo = pathologyNo;
	}

	public String getTumourPeriodization() {
		return tumourPeriodization;
	}

	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
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

	public Integer getIsAllergy() {
		return isAllergy;
	}

	public void setIsAllergy(Integer isAllergy) {
		this.isAllergy = isAllergy;
	}

	public String getAllergyDesc() {
		return allergyDesc;
	}

	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}

	public Integer getAboBlood() {
		return aboBlood;
	}

	public void setAboBlood(Integer aboBlood) {
		this.aboBlood = aboBlood;
	}

	public Integer getRhBlood() {
		return rhBlood;
	}

	public void setRhBlood(Integer rhBlood) {
		this.rhBlood = rhBlood;
	}

	public Integer getRedBloodCell() {
		return redBloodCell;
	}

	public void setRedBloodCell(Integer redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	public Integer getPlatelet() {
		return platelet;
	}

	public void setPlatelet(Integer platelet) {
		this.platelet = platelet;
	}

	public Integer getPlasma() {
		return plasma;
	}

	public void setPlasma(Integer plasma) {
		this.plasma = plasma;
	}

	public Integer getWholeBlood() {
		return wholeBlood;
	}

	public void setWholeBlood(Integer wholeBlood) {
		this.wholeBlood = wholeBlood;
	}

	public Integer getOther() {
		return other;
	}

	public void setOther(Integer other) {
		this.other = other;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Date getAdverseReactionWriteTime() {
		return adverseReactionWriteTime;
	}

	public void setAdverseReactionWriteTime(Date adverseReactionWriteTime) {
		this.adverseReactionWriteTime = adverseReactionWriteTime;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getClinicWard() {
		return clinicWard;
	}

	public void setClinicWard(String clinicWard) {
		this.clinicWard = clinicWard;
	}

	public Integer getClinicWay() {
		return clinicWay;
	}

	public void setClinicWay(Integer clinicWay) {
		this.clinicWay = clinicWay;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Long getDeptDoctor() {
		return deptDoctor;
	}

	public void setDeptDoctor(Long deptDoctor) {
		this.deptDoctor = deptDoctor;
	}

	public String getDeptDoctorName() {
		return deptDoctorName;
	}

	public void setDeptDoctorName(String deptDoctorName) {
		this.deptDoctorName = deptDoctorName;
	}

	public Long getDirectorDoctor() {
		return directorDoctor;
	}

	public void setDirectorDoctor(Long directorDoctor) {
		this.directorDoctor = directorDoctor;
	}

	public String getDirectorDoctorName() {
		return directorDoctorName;
	}

	public void setDirectorDoctorName(String directorDoctorName) {
		this.directorDoctorName = directorDoctorName;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getAttendingDoctorNo() {
		return attendingDoctorNo;
	}

	public void setAttendingDoctorNo(String attendingDoctorNo) {
		this.attendingDoctorNo = attendingDoctorNo;
	}

	public Integer getTumourPeriodizationClinicId() {
		return tumourPeriodizationClinicId;
	}

	public void setTumourPeriodizationClinicId(Integer tumourPeriodizationClinicId) {
		this.tumourPeriodizationClinicId = tumourPeriodizationClinicId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
}
