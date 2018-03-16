package com.esuizhen.cloudservice.ehr.model.inhospital;

import java.util.Date;

public class TInhospitalDetailInfo {

	/**
	 * 住院病案ID
	 */
	private String inhospitalId;
	/**
	 * 住院登记号 流水号
	 */
	private String inhospitalNo;
	/**
	 * 电子病历ID。外键:e_medical_record.emrId。
	 */
	private String emrId;
	/**
	 * 患者ID。外键: patient.patientId。
	 */
	private Long patientId;
	/**
	 * 病案号。医院对患者的标识。
	 */
	private String patientNo;

	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 就诊来源
	 */
	private Integer inhospitalSource;

	/**
	 * 民族Id
	 */
	private Integer nationId;

	/**
	 * 民族
	 */
	private String nation;

	/**
	 * 职业
	 */
	private String occupationName;

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
	 * 国籍ID
	 */
	private Integer nationalityId;

	/**
	 * 国籍名称
	 */
	private String nationalityName;

	/**
	 * 籍贯市级城市代码
	 */
	private String nativePlaceCityCode;

	/**
	 * 籍贯省级城市代码
	 */
	private String nativePlaceProvinceCode;

	/**
	 * 籍贯地址
	 */
	private String nativePlaceAddress;
	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 单位电话
	 */
	private String companyTel;

	/**
	 * 现居住地电话
	 */
	private String liveTel;
	/**
	 * 医院ID。
	 */
	private Integer hospitalId;
	/**
	 * 1、城镇职工基本医疗保险；2、城镇居民基本医疗保险；3、
	 * 新型农村合作医疗；4、贫困救助；
	 * 5、商业医疗保险；6、全公费；7、
	 * 全自费；8、其他社会保险；9、其他
	 */
	private Integer medicalPayType;
	/**
	 * 健康卡号
	 */
	private String healthCardNo;
	/**
	 * 入院途径 1:急诊; 2:门诊; 3:其他医疗机构转入; 9:其他
	 */
	private Integer inhospitalWay;
	/**
	 * 入院时间
	 */
	private Date inhospitalDate;
	/**
	 * 入院科别
	 */
	private Integer inhospitalDeptId;
	/**
	 * 入院病室
	 */
	private String inhospitalWard;
	/**
	 * 第几次住院
	 */
	private Integer inhospitalTimes;
	/**
	 * 转科科别
	 */
	private Integer turnDeptId;

	/**
	 * 转科情况
	 */
	private String turnDept;
	/**
	 * 转科时间
	 */
	private Date turnDeptDate;
	/**
	 * 出院时间
	 */
	private Date outhospitalDate;
	/**
	 * 出院科别
	 */
	private Integer outhospitalDeptId;
	/**
	 * 出院病室
	 */
	private String outhospitalWard;
	/**
	 * 离院方式。 1: 医嘱离院（默认） 2: 医嘱转院
	 * 3：医嘱转社区卫生服务机构 4：非医嘱离院 5：死亡 9：其他。
	 */
	private Integer outhoispitalWay;
	/**
	 * 实际住院天数
	 */
	private Integer inhospitalDays;
	/**
	 * 门（急）诊诊断
	 */
	private String diagnose;
	/**
	 * 疾病编码
	 */
	private String diseaseCode;
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
	/**
	 * 住院医师
	 */
	private Long inchargeDoctor;
	/**
	 * inchargeDoctorName
	 */
	private String inchargeDoctorName;
	/**
	 * 住院医师
	 */
	private Long inhospitalDoctor;
	/**
	 * 住院医师姓名
	 */
	private String inhospitalDoctorName;
	/**
	 * 主诊医师
	 */
	private Long attendingDoctor;
	/**
	 * 主诊医师名称
	 */
	private String attendingDoctorName;
	/**
	 * 责任护士
	 */
	private Long dutyNurse;
	/**
	 * 责任护士名称
	 */
	private String dutyNurseName;
	/**
	 * 进修医师
	 */
	private Long postgraduateDoctor;
	/**
	 * 进修医师名称
	 */
	private String postgraduateDoctorName;
	/**
	 * 实习医师
	 */
	private Long internshipDoctor;
	/**
	 * 实习医师名称
	 */
	private String internshipDoctorName;
	/**
	 * 编码员
	 */
	private Integer codePerson;

	/**
	 * 编码员姓名
	 */
	private String codePersonName;
	/**
	 * 病案质量。 1：甲；2：乙；3：丙
	 */
	private Integer medicalRecordsQuality;
	/**
	 * 质控医师
	 */
	private Long qualityControlDoctor;
	/**
	 * 质控医师名称
	 */
	private String qualityControlDoctorName;
	/**
	 * 质控护士
	 */
	private Long qualityControlNurse;
	/**
	 * 质控护士名称
	 */
	private String qualityControlNurseName;
	/**
	 * 质控日期
	 */
	private Date qualityControlDate;
	/**
	 * 主要诊断内容
	 */
	private String mainDiagnosis;
	/**
	 * 主要诊断疾病编码
	 */
	private String mainDiagnosisCode;
	/**
	 * 入院病情. 1、有;2、临床未确定;3、情况不明;4、无
	 */
	private Integer inhospitalCondition;
	/**
	 * 同步标识。
	 */
	private Integer syncflag = 0;
	/**
	 * 数据来源标示。 1：患者上传 2：医生上传 3：医院同步（默认）
	 */
	private Integer sourceflag;
	/**
	 * 过往治疗
	 */
	private Integer historyCuration;
	/**
	 * 原发癌数
	 */
	private Integer sourceCancerNum;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 职业
	 */
	private Integer occupationId;
	/**
	 * 证件类型
	 */
	private Integer idType;
	/**
	 * 身份证号/护照/军官证号
	 */
	private String identification;
	/**
	 * 婚姻状况
	 */
	private Integer marriageStatus;
	/**
	 * 出院情况
	 */
	private Integer outhospitalCondition;
	/**
	 * 31天再住院记录
	 */
	private Integer reInhospitalPlan31Days;
	/**
	 * 31天再住院目的
	 */
	private String reInhospitalTarget31Days;
	/**
	 * 入院前昏迷小时
	 */
	private Integer preComaHour;
	/**
	 * 入院前昏迷分钟
	 */
	private Integer preComaMinute;
	/**
	 * 在医院昏迷小时
	 */
	private Integer inComaHour;
	/**
	 * 在医院昏迷分钟
	 */
	private Integer inComaMinute;
	/**
	 * 入院生活能力评分
	 */
	private Integer inviabilityScore;
	/**
	 * 出院生活能力评分
	 */
	private Integer outviabilityScore;
	/**
	 * 婴儿年龄单位为月（小于一岁）
	 */
	private String babyAge;
	/**
	 * 出生体重
	 */
	private String babyBornWeight;
	/**
	 * 入院体重
	 */
	private String babyWeightInHospital;
	/**
	 * 输血量
	 */
	private Integer transfusion;
	/**
	 * 呼吸机使用时间
	 */
	private String respiratorUseTime;
	/**
	 * 是否药物过敏0：否 1：是
	 */
	private Integer isAllergy;
	/**
	 * 药物过敏描述
	 */
	private String allergyDesc;
	/**
	 * 是否死亡患者尸检
	 */
	private Integer isAut;
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
	private String other;
	/**
	 * 病理编号
	 */
	private String pathologyNo;
	/**
	 * 损伤中毒的外部原因
	 */
	private String poisoningReason;
	/**
	 * 损伤中毒的外部原因疾病编码
	 */
	private String poisoningDiseaseCode;
	/**
	 * 接收医院名称
	 */
	private String recHospitalName;
	/**
	 * 临床分期
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
	 * 肿瘤分期M1
	 */
	private String tumourPeriodizationM1;
	private Integer tumourPeriodizationM1Id;

	// private String inhospitalFlow; //
	// 住院流水
	private String treatmentRecord; // 治疗方案记录

	public String getTreatmentRecord() {
		return treatmentRecord;
	}

	public void setTreatmentRecord(String treatmentRecord) {
		this.treatmentRecord = treatmentRecord;
	}

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

	/**
	 * 肿瘤分期M2
	 */
	private String tumourPeriodizationClinic;
	private Integer tumourPeriodizationClinicId;
	/**
	 * 病理诊断内容
	 */
	private String pathologyDiagnosis;
	/**
	 * 病理诊断编码
	 */
	private String pathologyDiagnosisCode;
	/**
	 * 户口所在地邮编
	 */
	private String householdZipCode;
	/**
	 * 户口县级城市代码
	 */
	private String householdCountyCode;

	/**
	 * 户口市级城市代码
	 */
	private String householdCityCode;

	/**
	 * 户口省级城市代码
	 */
	private String householdProvinceCode;
	/**
	 * 户口地详细地址
	 */
	private String householdAddress;
	/**
	 * 单位所在地邮编
	 */
	private String companyZipCode;
	/**
	 * 工作单位县级城市代码
	 */
	private String companyCountyCode;

	/**
	 * 工作单位市级城市代码
	 */
	private String companyCityCode;

	/**
	 * 工作单位省级城市代码
	 */
	private String companyProvinceCode;
	/**
	 * 工作单位详细地址
	 */
	private String companyAddress;
	/**
	 * 居住所在地邮编
	 */
	private String liveZipCode;

	/**
	 * 患者名字
	 */
	private String trueName;
	/**
	 * 居住县级城市代码
	 */
	private String liveCountyCode;

	/**
	 * 居住市级城市代码
	 */
	private String liveCityCode;

	/**
	 * 居住省级城市代码
	 */
	private String liveProvinceCode;

	/**
	 * 居住地详细地址
	 */
	private String liveAddress;
	/**
	 * 家属姓名（联系人）
	 */
	private String familyName;
	/**
	 * 与患者关系
	 */
	private Integer patientRelation;
	/**
	 * 家庭住址（联系人）县级代码
	 */
	private String familyCountyCode;

	/**
	 * 家庭住址（联系人）城市代码
	 */
	private String familyCityCode;

	/**
	 * 家庭住址（联系人）省级代码
	 */
	private String familyProvinceCode;
	/**
	 * 家庭地址（联系人地址）
	 */
	private String familyAddress;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * ToB同步时间
	 */
	private Date syncTime;

	/**
	 * 联系电话
	 */
	private String familyTel;

	/**
	 * 出生日期
	 */
	private Date birthDate;

	/**
	 * 死亡时间
	 */
	private Date deathTime;

	/**
	 * 死亡原因
	 */
	private String deathCause;

	/**
	 * 操作员ID
	 */
	private Long operatorId;

	/**
	 * 操作员姓名
	 */
	private String operatorName;
	/**
	 * 编目内容
	 */
	private String cateContent;
	/**
	 * ############医生空间1.0新增字段##########
	 * ##
	 */
	/**
	 * 医院名称。医生空间1.0新增
	 */
	private String hospitalName;

	/**
	 * 入院科别名称
	 */
	private String inhospitalDeptName;

	/**
	 * 出院科别名称
	 */
	private String outhospitalDeptName;

	private Date adverseReactionWriteTime;

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getInhospitalId() {
		return this.inhospitalId;
	}

	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}

	public String getInhospitalNo() {
		return this.inhospitalNo;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public String getEmrId() {
		return this.emrId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getPatientId() {
		return this.patientId;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientNo() {
		return this.patientNo;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}

	public Integer getMedicalPayType() {
		return this.medicalPayType;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}

	public String getHealthCardNo() {
		return this.healthCardNo;
	}

	public void setInhospitalWay(Integer inhospitalWay) {
		this.inhospitalWay = inhospitalWay;
	}

	public Integer getInhospitalWay() {
		return this.inhospitalWay;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public Date getInhospitalDate() {
		return this.inhospitalDate;
	}

	public void setInhospitalDeptId(Integer inhospitalDeptId) {
		this.inhospitalDeptId = inhospitalDeptId;
	}

	public Integer getInhospitalDeptId() {
		return this.inhospitalDeptId;
	}

	public void setInhospitalWard(String inhospitalWard) {
		this.inhospitalWard = inhospitalWard;
	}

	public String getInhospitalWard() {
		return this.inhospitalWard;
	}

	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}

	public Integer getInhospitalTimes() {
		return this.inhospitalTimes;
	}

	public void setTurnDeptId(Integer turnDeptId) {
		this.turnDeptId = turnDeptId;
	}

	public Integer getTurnDeptId() {
		return this.turnDeptId;
	}

	public void setTurnDeptDate(Date turnDeptDate) {
		this.turnDeptDate = turnDeptDate;
	}

	public Date getTurnDeptDate() {
		return this.turnDeptDate;
	}

	public void setOuthospitalDate(Date outhospitalDate) {
		this.outhospitalDate = outhospitalDate;
	}

	public Date getOuthospitalDate() {
		return this.outhospitalDate;
	}

	public void setOuthospitalDeptId(Integer outhospitalDeptId) {
		this.outhospitalDeptId = outhospitalDeptId;
	}

	public Integer getOuthospitalDeptId() {
		return this.outhospitalDeptId;
	}

	public void setOuthospitalWard(String outhospitalWard) {
		this.outhospitalWard = outhospitalWard;
	}

	public String getOuthospitalWard() {
		return this.outhospitalWard;
	}

	public void setOuthoispitalWay(Integer outhoispitalWay) {
		this.outhoispitalWay = outhoispitalWay;
	}

	public Integer getOuthoispitalWay() {
		return this.outhoispitalWay;
	}

	public void setInhospitalDays(Integer inhospitalDays) {
		this.inhospitalDays = inhospitalDays;
	}

	public Integer getInhospitalDays() {
		return this.inhospitalDays;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getDiagnose() {
		return this.diagnose;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public String getDiseaseCode() {
		return this.diseaseCode;
	}

	public void setDeptDoctor(Long deptDoctor) {
		this.deptDoctor = deptDoctor;
	}

	public Long getDeptDoctor() {
		return this.deptDoctor;
	}

	public void setDeptDoctorName(String deptDoctorName) {
		this.deptDoctorName = deptDoctorName;
	}

	public String getDeptDoctorName() {
		return this.deptDoctorName;
	}

	public void setDirectorDoctor(Long directorDoctor) {
		this.directorDoctor = directorDoctor;
	}

	public Long getDirectorDoctor() {
		return this.directorDoctor;
	}

	public void setDirectorDoctorName(String directorDoctorName) {
		this.directorDoctorName = directorDoctorName;
	}

	public String getDirectorDoctorName() {
		return this.directorDoctorName;
	}

	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}

	public Long getInchargeDoctor() {
		return this.inchargeDoctor;
	}

	public void setInchargeDoctorName(String inchargeDoctorName) {
		this.inchargeDoctorName = inchargeDoctorName;
	}

	public String getInchargeDoctorName() {
		return this.inchargeDoctorName;
	}

	public void setInhospitalDoctor(Long inhospitalDoctor) {
		this.inhospitalDoctor = inhospitalDoctor;
	}

	public Long getInhospitalDoctor() {
		return this.inhospitalDoctor;
	}

	public void setInhospitalDoctorName(String inhospitalDoctorName) {
		this.inhospitalDoctorName = inhospitalDoctorName;
	}

	public String getInhospitalDoctorName() {
		return this.inhospitalDoctorName;
	}

	public void setAttendingDoctor(Long attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}

	public Long getAttendingDoctor() {
		return this.attendingDoctor;
	}

	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}

	public String getAttendingDoctorName() {
		return this.attendingDoctorName;
	}

	public void setDutyNurse(Long dutyNurse) {
		this.dutyNurse = dutyNurse;
	}

	public Long getDutyNurse() {
		return this.dutyNurse;
	}

	public void setDutyNurseName(String dutyNurseName) {
		this.dutyNurseName = dutyNurseName;
	}

	public String getDutyNurseName() {
		return this.dutyNurseName;
	}

	public void setPostgraduateDoctor(Long postgraduateDoctor) {
		this.postgraduateDoctor = postgraduateDoctor;
	}

	public Long getPostgraduateDoctor() {
		return this.postgraduateDoctor;
	}

	public void setPostgraduateDoctorName(String postgraduateDoctorName) {
		this.postgraduateDoctorName = postgraduateDoctorName;
	}

	public String getPostgraduateDoctorName() {
		return this.postgraduateDoctorName;
	}

	public void setInternshipDoctor(Long internshipDoctor) {
		this.internshipDoctor = internshipDoctor;
	}

	public Long getInternshipDoctor() {
		return this.internshipDoctor;
	}

	public void setInternshipDoctorName(String internshipDoctorName) {
		this.internshipDoctorName = internshipDoctorName;
	}

	public String getInternshipDoctorName() {
		return this.internshipDoctorName;
	}

	public void setCodePerson(Integer codePerson) {
		this.codePerson = codePerson;
	}

	public Integer getCodePerson() {
		return this.codePerson;
	}

	public void setMedicalRecordsQuality(Integer medicalRecordsQuality) {
		this.medicalRecordsQuality = medicalRecordsQuality;
	}

	public Integer getMedicalRecordsQuality() {
		return this.medicalRecordsQuality;
	}

	public void setQualityControlDoctor(Long qualityControlDoctor) {
		this.qualityControlDoctor = qualityControlDoctor;
	}

	public Long getQualityControlDoctor() {
		return this.qualityControlDoctor;
	}

	public void setQualityControlDoctorName(String qualityControlDoctorName) {
		this.qualityControlDoctorName = qualityControlDoctorName;
	}

	public String getQualityControlDoctorName() {
		return this.qualityControlDoctorName;
	}

	public void setQualityControlNurse(Long qualityControlNurse) {
		this.qualityControlNurse = qualityControlNurse;
	}

	public Long getQualityControlNurse() {
		return this.qualityControlNurse;
	}

	public void setQualityControlNurseName(String qualityControlNurseName) {
		this.qualityControlNurseName = qualityControlNurseName;
	}

	public String getQualityControlNurseName() {
		return this.qualityControlNurseName;
	}

	public void setQualityControlDate(Date qualityControlDate) {
		this.qualityControlDate = qualityControlDate;
	}

	public Date getQualityControlDate() {
		return this.qualityControlDate;
	}

	public void setMainDiagnosis(String mainDiagnosis) {
		this.mainDiagnosis = mainDiagnosis;
	}

	public String getMainDiagnosis() {
		return this.mainDiagnosis;
	}

	public void setMainDiagnosisCode(String mainDiagnosisCode) {
		this.mainDiagnosisCode = mainDiagnosisCode;
	}

	public String getMainDiagnosisCode() {
		return this.mainDiagnosisCode;
	}

	public void setInhospitalCondition(Integer inhospitalCondition) {
		this.inhospitalCondition = inhospitalCondition;
	}

	public Integer getInhospitalCondition() {
		return this.inhospitalCondition;
	}

	public void setSyncflag(Integer syncflag) {
		this.syncflag = syncflag;
	}

	public Integer getSyncflag() {
		return this.syncflag;
	}

	public void setSourceflag(Integer sourceflag) {
		this.sourceflag = sourceflag;
	}

	public Integer getSourceflag() {
		return this.sourceflag;
	}

	public void setHistoryCuration(Integer historyCuration) {
		this.historyCuration = historyCuration;
	}

	public Integer getHistoryCuration() {
		return this.historyCuration;
	}

	public void setSourceCancerNum(Integer sourceCancerNum) {
		this.sourceCancerNum = sourceCancerNum;
	}

	public Integer getSourceCancerNum() {
		return this.sourceCancerNum;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getOccupationId() {
		return this.occupationId;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public Integer getIdType() {
		return this.idType;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public Integer getMarriageStatus() {
		return this.marriageStatus;
	}

	public void setOuthospitalCondition(Integer outhospitalCondition) {
		this.outhospitalCondition = outhospitalCondition;
	}

	public Integer getOuthospitalCondition() {
		return this.outhospitalCondition;
	}

	public void setReInhospitalPlan31Days(Integer reInhospitalPlan31Days) {
		this.reInhospitalPlan31Days = reInhospitalPlan31Days;
	}

	public Integer getReInhospitalPlan31Days() {
		return this.reInhospitalPlan31Days;
	}

	public void setReInhospitalTarget31Days(String reInhospitalTarget31Days) {
		this.reInhospitalTarget31Days = reInhospitalTarget31Days;
	}

	public String getReInhospitalTarget31Days() {
		return this.reInhospitalTarget31Days;
	}

	public void setPreComaHour(Integer preComaHour) {
		this.preComaHour = preComaHour;
	}

	public Integer getPreComaHour() {
		return this.preComaHour;
	}

	public void setPreComaMinute(Integer preComaMinute) {
		this.preComaMinute = preComaMinute;
	}

	public Integer getPreComaMinute() {
		return this.preComaMinute;
	}

	public void setInComaHour(Integer inComaHour) {
		this.inComaHour = inComaHour;
	}

	public Integer getInComaHour() {
		return this.inComaHour;
	}

	public void setInComaMinute(Integer inComaMinute) {
		this.inComaMinute = inComaMinute;
	}

	public Integer getInComaMinute() {
		return this.inComaMinute;
	}

	public void setInviabilityScore(Integer inviabilityScore) {
		this.inviabilityScore = inviabilityScore;
	}

	public Integer getInviabilityScore() {
		return this.inviabilityScore;
	}

	public void setOutviabilityScore(Integer outviabilityScore) {
		this.outviabilityScore = outviabilityScore;
	}

	public Integer getOutviabilityScore() {
		return this.outviabilityScore;
	}

	public String getBabyAge() {
		return babyAge;
	}

	public void setBabyAge(String babyAge) {
		this.babyAge = babyAge;
	}

	public String getBabyBornWeight() {
		return babyBornWeight;
	}

	public void setBabyBornWeight(String babyBornWeight) {
		this.babyBornWeight = babyBornWeight;
	}

	public String getBabyWeightInHospital() {
		return babyWeightInHospital;
	}

	public void setBabyWeightInHospital(String babyWeightInHospital) {
		this.babyWeightInHospital = babyWeightInHospital;
	}

	public String getRespiratorUseTime() {
		return respiratorUseTime;
	}

	public void setRespiratorUseTime(String respiratorUseTime) {
		this.respiratorUseTime = respiratorUseTime;
	}

	public void setTransfusion(Integer transfusion) {
		this.transfusion = transfusion;
	}

	public Integer getTransfusion() {
		return this.transfusion;
	}

	public void setIsAllergy(Integer isAllergy) {
		this.isAllergy = isAllergy;
	}

	public Integer getIsAllergy() {
		return this.isAllergy;
	}

	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}

	public String getAllergyDesc() {
		return this.allergyDesc;
	}

	public void setIsAut(Integer isAut) {
		this.isAut = isAut;
	}

	public Integer getIsAut() {
		return this.isAut;
	}

	public void setAboBlood(Integer aboBlood) {
		this.aboBlood = aboBlood;
	}

	public Integer getAboBlood() {
		return this.aboBlood;
	}

	public void setRhBlood(Integer rhBlood) {
		this.rhBlood = rhBlood;
	}

	public Integer getRhBlood() {
		return this.rhBlood;
	}

	public void setRedBloodCell(Integer redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	public Integer getRedBloodCell() {
		return this.redBloodCell;
	}

	public void setPlatelet(Integer platelet) {
		this.platelet = platelet;
	}

	public Integer getPlatelet() {
		return this.platelet;
	}

	public void setPlasma(Integer plasma) {
		this.plasma = plasma;
	}

	public Integer getPlasma() {
		return this.plasma;
	}

	public void setWholeBlood(Integer wholeBlood) {
		this.wholeBlood = wholeBlood;
	}

	public Integer getWholeBlood() {
		return this.wholeBlood;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOther() {
		return this.other;
	}

	public void setPathologyNo(String pathologyNo) {
		this.pathologyNo = pathologyNo;
	}

	public String getPathologyNo() {
		return this.pathologyNo;
	}

	public void setPoisoningReason(String poisoningReason) {
		this.poisoningReason = poisoningReason;
	}

	public String getPoisoningReason() {
		return this.poisoningReason;
	}

	public void setPoisoningDiseaseCode(String poisoningDiseaseCode) {
		this.poisoningDiseaseCode = poisoningDiseaseCode;
	}

	public String getPoisoningDiseaseCode() {
		return this.poisoningDiseaseCode;
	}

	public void setRecHospitalName(String recHospitalName) {
		this.recHospitalName = recHospitalName;
	}

	public String getRecHospitalName() {
		return this.recHospitalName;
	}

	public String getTumourPeriodization() {
		return tumourPeriodization;
	}

	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
	}

	public void setTumourPeriodizationT(String tumourPeriodizationT) {
		this.tumourPeriodizationT = tumourPeriodizationT;
	}

	public String getTumourPeriodizationT() {
		return this.tumourPeriodizationT;
	}

	public void setTumourPeriodizationN(String tumourPeriodizationN) {
		this.tumourPeriodizationN = tumourPeriodizationN;
	}

	public String getTumourPeriodizationN() {
		return this.tumourPeriodizationN;
	}

	public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
		this.tumourPeriodizationM1 = tumourPeriodizationM1;
	}

	public String getTumourPeriodizationM1() {
		return this.tumourPeriodizationM1;
	}

	public String getTumourPeriodizationClinic() {
		return tumourPeriodizationClinic;
	}

	public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
		this.tumourPeriodizationClinic = tumourPeriodizationClinic;
	}

	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}

	public String getPathologyDiagnosis() {
		return this.pathologyDiagnosis;
	}

	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}

	public String getPathologyDiagnosisCode() {
		return this.pathologyDiagnosisCode;
	}

	public void setHouseholdZipCode(String householdZipCode) {
		this.householdZipCode = householdZipCode;
	}

	public String getHouseholdZipCode() {
		return this.householdZipCode;
	}

	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
	}

	public String getHouseholdAddress() {
		return this.householdAddress;
	}

	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}

	public String getCompanyZipCode() {
		return this.companyZipCode;
	}

	public void setCompanyCityCode(String companyCityCode) {
		this.companyCityCode = companyCityCode;
	}

	public String getCompanyCityCode() {
		return this.companyCityCode;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setLiveZipCode(String liveZipCode) {
		this.liveZipCode = liveZipCode;
	}

	public String getLiveZipCode() {
		return this.liveZipCode;
	}

	public void setLiveCityCode(String liveCityCode) {
		this.liveCityCode = liveCityCode;
	}

	public String getLiveCityCode() {
		return this.liveCityCode;
	}

	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}

	public String getLiveAddress() {
		return this.liveAddress;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public Integer getPatientRelation() {
		return this.patientRelation;
	}

	public void setFamilyCityCode(String familyCityCode) {
		this.familyCityCode = familyCityCode;
	}

	public String getFamilyCityCode() {
		return this.familyCityCode;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getFamilyAddress() {
		return this.familyAddress;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public Date getSyncTime() {
		return this.syncTime;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public String getBirthPlaceAddress() {
		return birthPlaceAddress;
	}

	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
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

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getLiveTel() {
		return liveTel;
	}

	public void setLiveTel(String liveTel) {
		this.liveTel = liveTel;
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

	public String getHouseholdCountyCode() {
		return householdCountyCode;
	}

	public void setHouseholdCountyCode(String householdCountyCode) {
		this.householdCountyCode = householdCountyCode;
	}

	public String getHouseholdCityCode() {
		return householdCityCode;
	}

	public void setHouseholdCityCode(String householdCityCode) {
		this.householdCityCode = householdCityCode;
	}

	public String getHouseholdProvinceCode() {
		return householdProvinceCode;
	}

	public void setHouseholdProvinceCode(String householdProvinceCode) {
		this.householdProvinceCode = householdProvinceCode;
	}

	public String getCompanyCountyCode() {
		return companyCountyCode;
	}

	public void setCompanyCountyCode(String companyCountyCode) {
		this.companyCountyCode = companyCountyCode;
	}

	public String getCompanyProvinceCode() {
		return companyProvinceCode;
	}

	public void setCompanyProvinceCode(String companyProvinceCode) {
		this.companyProvinceCode = companyProvinceCode;
	}

	public String getLiveCountyCode() {
		return liveCountyCode;
	}

	public void setLiveCountyCode(String liveCountyCode) {
		this.liveCountyCode = liveCountyCode;
	}

	public String getLiveProvinceCode() {
		return liveProvinceCode;
	}

	public void setLiveProvinceCode(String liveProvinceCode) {
		this.liveProvinceCode = liveProvinceCode;
	}

	public String getFamilyCountyCode() {
		return familyCountyCode;
	}

	public void setFamilyCountyCode(String familyCountyCode) {
		this.familyCountyCode = familyCountyCode;
	}

	public String getFamilyProvinceCode() {
		return familyProvinceCode;
	}

	public void setFamilyProvinceCode(String familyProvinceCode) {
		this.familyProvinceCode = familyProvinceCode;
	}

	public String getFamilyTel() {
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	public String getTurnDept() {
		return turnDept;
	}

	public void setTurnDept(String turnDept) {
		this.turnDept = turnDept;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNativePlaceProvinceCode() {
		return nativePlaceProvinceCode;
	}

	public void setNativePlaceProvinceCode(String nativePlaceProvinceCode) {
		this.nativePlaceProvinceCode = nativePlaceProvinceCode;
	}

	public Integer getInhospitalSource() {
		return inhospitalSource;
	}

	public void setInhospitalSource(Integer inhospitalSource) {
		this.inhospitalSource = inhospitalSource;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public Date getDeathTime() {
		return deathTime;
	}

	public void setDeathTime(Date deathTime) {
		this.deathTime = deathTime;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public String getCodePersonName() {
		return codePersonName;
	}

	public void setCodePersonName(String codePersonName) {
		this.codePersonName = codePersonName;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCateContent() {
		return cateContent;
	}

	public void setCateContent(String cateContent) {
		this.cateContent = cateContent;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getInhospitalDeptName() {
		return inhospitalDeptName;
	}

	public void setInhospitalDeptName(String inhospitalDeptName) {
		this.inhospitalDeptName = inhospitalDeptName;
	}

	public String getOuthospitalDeptName() {
		return outhospitalDeptName;
	}

	public void setOuthospitalDeptName(String outhospitalDeptName) {
		this.outhospitalDeptName = outhospitalDeptName;
	}

	public Date getAdverseReactionWriteTime() {
		return adverseReactionWriteTime;
	}

	public void setAdverseReactionWriteTime(Date adverseReactionWriteTime) {
		this.adverseReactionWriteTime = adverseReactionWriteTime;
	}

	public Integer getTumourPeriodizationClinicId() {
		return tumourPeriodizationClinicId;
	}

	public void setTumourPeriodizationClinicId(Integer tumourPeriodizationClinicId) {
		this.tumourPeriodizationClinicId = tumourPeriodizationClinicId;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
}

