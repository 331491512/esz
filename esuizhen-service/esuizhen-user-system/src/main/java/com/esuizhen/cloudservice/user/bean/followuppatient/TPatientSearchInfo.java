package com.esuizhen.cloudservice.user.bean.followuppatient;

import java.util.Date;
import java.util.List;

public class TPatientSearchInfo {
	
	private Long patientId;
	
    private String patientNo;

    private String mobile;

    private String trueName;

    private String sourceDiagnosis;

    private String sourceDiseaseCode;

    private Integer sourceDiseaseTypeId;
    
    private List<Integer> sourceDiseaseTypeIds;	

    private Date confirmedDateStart;
    
    private Date confirmedDateEnd;

    private String sourcePathologyDiagnosis;

    private String sourcePathologyDiseaseCode;
    
    private Integer inhospitalTimes;
    
    private Date outhospitalDateStart;
    
    private Long doctorId;
    
    private Date outhospitalDateEnd;
    /**
     * 出院次数
     */
    private Integer outhospitalTimes;
    /**
     * 失访标示
     */
    private Integer followupFlag;
    /**
     * 缺失类型/错误类型
     */
    private Integer faultType;
    /**
     * 缺失类型
     */
    private Integer missingType;
    /**
     * 错误类型
     */
    private Integer invalidType;
    
    /**
     * 多个病案号
     */
    private String batchPatientNo;
    
    /**
     * 多个没有进行系统修改的病案号
     */
    private String originalBatchPatientNo;
    
    private List<Integer> followupResultValue;
    
    private List<Integer> lostFollowupCauseResultValue;
    
    private Long userId;
    
    private Integer userRole;
	
	private Long operator;
	/**
	 * 全部疾病类型
	 */
	private Integer sourceTumorFlag;
	
	/**
	 * 随访次数  -1 末次  null 任意次
	 */
	private Integer followupTimes;
	
	/**
	 * 随访起始时间
	 */
	private Date followupTimeStart;
    
	/**
	 * 随访结束时间
	 */
    private Date followupTimeEnd;
    
    /**
     * 随访人员
     */
    private List<Long> followupOperator;
    
    /**
     * 患者查询范围
     */
    private Integer patientRangeFlag;
    
    /**
     * 非肿瘤疾病病种
     */
    private String notMalignantTumorFlag;
    
    /**
     * 随访范围
     */
    private Integer followupRangeFlag;
    
    /** #################261需求#######################*/
    /**
     * 性别集合
     * @return
     */
    private List<Integer> sex;
    /**
     * 起始出生日期
     * @return
     */
    private Date birthDateStart;
    /**
     * 终止出生日期
     * @return
     */
    private Date birthDateEnd;
    
    /**
     * 城市id集合
     * @return
     */
    private List<Integer> cityId;
    /**
     * 城市code集合
     * @return
     */
    private List<String> cityCode;
    /**
     * 治疗方式集合
     * @return
     */
    private List<Integer> treatmentTypeIds;
    /**
     * 起始确诊年龄
     * @return
     */
    private Integer confirmedAgeStart;
    /**
     * 终止确诊年龄
     * @return
     */
    private Integer confirmedAgeEnd;
    /**
     * 住院开始日期
     * @return
     */
    private Date inhospitalDateStart;
    /**
     * 住院结束日期
     * @return
     */
    private Date inhospitalDateEnd;
    /**
     * 入院科室集合
     * @return
     */
    private List<Integer> inhospitalDeptId;
    /**
     * 出院科室集合
     * @return
     */
    private List<Integer> outhospitalDeptId;
    /**
	 * 入院科室次数：1-首次，-1-末次
	 */
	private Integer inhospitalDeptTimes;
    /**
     * 出院科室次数：1-首次，-1-末次
     */
  	private Integer outHospitalDeptTimes;
  	/**
  	 * 高级筛选条件拼接
  	 */
  	private String sql;
  	
  	/**
     * 失访患者信息改变：1-门诊/住院信息有更新，2-联系方式有更新，3-门诊/住院信息+联系方式有更新
     */
  	private Integer lostPatientChange;
  	
  	/** 263 新增字段 add by yuanwenming */
  	/**
  	 * 随访数据错误
  	 */
  	private Integer followupInvliadType;
  	
  	/** 院际医生工作站  add by yuan_wm 20170217 start **/
  	/**
  	 * 来源标识 0：未知（默认）；1：扫码（医生）关注；2：微信关注；3：院内同步; 4:医生创建；5：扫码医院
  	 */
  	private Integer sourceFlag;
  	/**
     * 疑似重复类型
     */
    private Integer similarType;
    /**
     * 数据权限id
     */
  	private Integer dataId;
  	/**
     * 部署位置
     */
  	private Integer deployLocation;
  	/**
  	 * 医生职称
  	 */
  	private Integer doctorLevel;
  	/**
  	 * 接口名称
  	 */
  	private String interfaceName;
  	/** 院际医生工作站  add by yuan_wm 20170217 end **/
  	private Integer hospitalId;
  	/**
  	 * 编目状态
  	 */
  	private Integer catalogState;
  	/**
  	 * 编目后更新
  	 */
  	private Integer catalogWithUpdate;
  	
  	/**
  	 * 科主任
  	 */
  	private Long deptDoctor;
  	/**
  	 * 主任医师
  	 */
  	private Long directorDoctor;
  	/**
  	 * 主任医师
  	 */
  	private Long inchargeDoctor;
  	/**
  	 * 住院医师
  	 */
  	private Long inhospitalDoctor;
  	
  	/**
  	 * 科室主任-住院次数。1-首次，2-末次
  	 */
  	private Integer deptDoctorTimes;
  	/**
  	 * 主任医师-住院次数。1-首次，2-末次
  	 */
  	private Integer directorDoctorTimes;
  	/**
  	 * 主治医师-住院次数。1-首次，2-末次
  	 */
  	private Integer inchargeDoctorTimes;
  	/**
  	 * 住院医师-住院次数。1-首次，2-末次
  	 */
  	private Integer inhospitalDoctorTimes;
  	
  	/**
  	 * 门诊住院标识：1-门诊、2-住院
  	 */
  	private List<Integer> outPatientFlag;
  	
  	private String treatmentPlaceState;
  	
	public Long getPatientId() {
		return patientId;
	}

	public String getOriginalBatchPatientNo() {
		return originalBatchPatientNo;
	}

	public void setOriginalBatchPatientNo(String originalBatchPatientNo) {
		this.originalBatchPatientNo = originalBatchPatientNo;
	}



	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}

	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}

	public Date getConfirmedDateStart() {
		return confirmedDateStart;
	}

	public void setConfirmedDateStart(Date confirmedDateStart) {
		this.confirmedDateStart = confirmedDateStart;
	}

	public Date getConfirmedDateEnd() {
		return confirmedDateEnd;
	}

	public void setConfirmedDateEnd(Date confirmedDateEnd) {
		this.confirmedDateEnd = confirmedDateEnd;
	}

	public String getSourcePathologyDiagnosis() {
		return sourcePathologyDiagnosis;
	}

	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}

	public String getSourcePathologyDiseaseCode() {
		return sourcePathologyDiseaseCode;
	}

	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
	}

	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}

	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}

	public Date getOuthospitalDateStart() {
		return outhospitalDateStart;
	}

	public void setOuthospitalDateStart(Date outhospitalDateStart) {
		this.outhospitalDateStart = outhospitalDateStart;
	}

	public Date getOuthospitalDateEnd() {
		return outhospitalDateEnd;
	}

	public void setOuthospitalDateEnd(Date outhospitalDateEnd) {
		this.outhospitalDateEnd = outhospitalDateEnd;
	}

	public Integer getMissingType() {
		return missingType;
	}

	public void setMissingType(Integer missingType) {
		this.missingType = missingType;
	}

	public Integer getInvalidType() {
		return invalidType;
	}

	public void setInvalidType(Integer invalidType) {
		this.invalidType = invalidType;
	}

	public Integer getOuthospitalTimes() {
		return outhospitalTimes;
	}

	public void setOuthospitalTimes(Integer outhospitalTimes) {
		this.outhospitalTimes = outhospitalTimes;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Integer getFaultType() {
		return faultType;
	}

	public void setFaultType(Integer faultType) {
		this.faultType = faultType;
	}

	public String getBatchPatientNo() {
		return batchPatientNo;
	}

	public void setBatchPatientNo(String batchPatientNo) {
		this.batchPatientNo = batchPatientNo;
	}

	public List<Integer> getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(List<Integer> followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public List<Integer> getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}

	public void setLostFollowupCauseResultValue(List<Integer> lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getSourceTumorFlag() {
		return sourceTumorFlag;
	}

	public void setSourceTumorFlag(Integer sourceTumorFlag) {
		this.sourceTumorFlag = sourceTumorFlag;
	}

	public List<Integer> getSourceDiseaseTypeIds() {
		return sourceDiseaseTypeIds;
	}

	public void setSourceDiseaseTypeIds(List<Integer> sourceDiseaseTypeIds) {
		this.sourceDiseaseTypeIds = sourceDiseaseTypeIds;
	}

	public List<Long> getFollowupOperator() {
		return followupOperator;
	}

	public void setFollowupOperator(List<Long> followupOperator) {
		this.followupOperator = followupOperator;
	}

	public Date getFollowupTimeStart() {
		return followupTimeStart;
	}

	public void setFollowupTimeStart(Date followupTimeStart) {
		this.followupTimeStart = followupTimeStart;
	}

	public Date getFollowupTimeEnd() {
		return followupTimeEnd;
	}

	public void setFollowupTimeEnd(Date followupTimeEnd) {
		this.followupTimeEnd = followupTimeEnd;
	}

	public Integer getFollowupTimes() {
		return followupTimes;
	}

	public void setFollowupTimes(Integer followupTimes) {
		this.followupTimes = followupTimes;
	}

	public Integer getPatientRangeFlag() {
		return patientRangeFlag;
	}

	public void setPatientRangeFlag(Integer patientRangeFlag) {
		this.patientRangeFlag = patientRangeFlag;
	}

	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}

	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}

	public String getNotMalignantTumorFlag() {
		return notMalignantTumorFlag;
	}

	public void setNotMalignantTumorFlag(String notMalignantTumorFlag) {
		this.notMalignantTumorFlag = notMalignantTumorFlag;
	}

	public List<Integer> getSex() {
		return sex;
	}

	public void setSex(List<Integer> sex) {
		this.sex = sex;
	}

	public Date getBirthDateStart() {
		return birthDateStart;
	}

	public void setBirthDateStart(Date birthDateStart) {
		this.birthDateStart = birthDateStart;
	}

	public Date getBirthDateEnd() {
		return birthDateEnd;
	}

	public void setBirthDateEnd(Date birthDateEnd) {
		this.birthDateEnd = birthDateEnd;
	}

	public List<Integer> getCityId() {
		return cityId;
	}

	public void setCityId(List<Integer> cityId) {
		this.cityId = cityId;
	}

	public List<String> getCityCode() {
		return cityCode;
	}

	public void setCityCode(List<String> cityCode) {
		this.cityCode = cityCode;
	}

	public List<Integer> getTreatmentTypeIds() {
		return treatmentTypeIds;
	}

	public void setTreatmentTypeIds(List<Integer> treatmentTypeIds) {
		this.treatmentTypeIds = treatmentTypeIds;
	}

	public Integer getConfirmedAgeStart() {
		return confirmedAgeStart;
	}

	public void setConfirmedAgeStart(Integer confirmedAgeStart) {
		this.confirmedAgeStart = confirmedAgeStart;
	}

	public Integer getConfirmedAgeEnd() {
		return confirmedAgeEnd;
	}

	public void setConfirmedAgeEnd(Integer confirmedAgeEnd) {
		this.confirmedAgeEnd = confirmedAgeEnd;
	}

	public Date getInhospitalDateStart() {
		return inhospitalDateStart;
	}

	public void setInhospitalDateStart(Date inhospitalDateStart) {
		this.inhospitalDateStart = inhospitalDateStart;
	}

	public Date getInhospitalDateEnd() {
		return inhospitalDateEnd;
	}

	public void setInhospitalDateEnd(Date inhospitalDateEnd) {
		this.inhospitalDateEnd = inhospitalDateEnd;
	}

	public List<Integer> getInhospitalDeptId() {
		return inhospitalDeptId;
	}

	public void setInhospitalDeptId(List<Integer> inhospitalDeptId) {
		this.inhospitalDeptId = inhospitalDeptId;
	}

	public List<Integer> getOuthospitalDeptId() {
		return outhospitalDeptId;
	}

	public void setOuthospitalDeptId(List<Integer> outhospitalDeptId) {
		this.outhospitalDeptId = outhospitalDeptId;
	}

	public Integer getInhospitalDeptTimes() {
		return inhospitalDeptTimes;
	}

	public void setInhospitalDeptTimes(Integer inhospitalDeptTimes) {
		this.inhospitalDeptTimes = inhospitalDeptTimes;
	}

	public Integer getOutHospitalDeptTimes() {
		return outHospitalDeptTimes;
	}

	public void setOutHospitalDeptTimes(Integer outHospitalDeptTimes) {
		this.outHospitalDeptTimes = outHospitalDeptTimes;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Integer getLostPatientChange() {
		return lostPatientChange;
	}

	public void setLostPatientChange(Integer lostPatientChange) {
		this.lostPatientChange = lostPatientChange;
	}

	public Integer getFollowupInvliadType() {
		return followupInvliadType;
	}

	public void setFollowupInvliadType(Integer followupInvliadType) {
		this.followupInvliadType = followupInvliadType;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getSimilarType() {
		return similarType;
	}

	public void setSimilarType(Integer similarType) {
		this.similarType = similarType;
	}

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public Integer getDeployLocation() {
		return deployLocation;
	}

	public void setDeployLocation(Integer deployLocation) {
		this.deployLocation = deployLocation;
	}

	public Integer getDoctorLevel() {
		return doctorLevel;
	}

	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}

	public Integer getCatalogWithUpdate() {
		return catalogWithUpdate;
	}

	public void setCatalogWithUpdate(Integer catalogWithUpdate) {
		this.catalogWithUpdate = catalogWithUpdate;
	}

	public Long getDeptDoctor() {
		return deptDoctor;
	}

	public void setDeptDoctor(Long deptDoctor) {
		this.deptDoctor = deptDoctor;
	}

	public Long getDirectorDoctor() {
		return directorDoctor;
	}

	public void setDirectorDoctor(Long directorDoctor) {
		this.directorDoctor = directorDoctor;
	}

	public Long getInchargeDoctor() {
		return inchargeDoctor;
	}

	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}

	public Long getInhospitalDoctor() {
		return inhospitalDoctor;
	}

	public void setInhospitalDoctor(Long inhospitalDoctor) {
		this.inhospitalDoctor = inhospitalDoctor;
	}

	public Integer getDeptDoctorTimes() {
		return deptDoctorTimes;
	}

	public void setDeptDoctorTimes(Integer deptDoctorTimes) {
		this.deptDoctorTimes = deptDoctorTimes;
	}

	public Integer getDirectorDoctorTimes() {
		return directorDoctorTimes;
	}

	public void setDirectorDoctorTimes(Integer directorDoctorTimes) {
		this.directorDoctorTimes = directorDoctorTimes;
	}

	public Integer getInchargeDoctorTimes() {
		return inchargeDoctorTimes;
	}

	public void setInchargeDoctorTimes(Integer inchargeDoctorTimes) {
		this.inchargeDoctorTimes = inchargeDoctorTimes;
	}

	public Integer getInhospitalDoctorTimes() {
		return inhospitalDoctorTimes;
	}

	public void setInhospitalDoctorTimes(Integer inhospitalDoctorTimes) {
		this.inhospitalDoctorTimes = inhospitalDoctorTimes;
	}

	public List<Integer> getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(List<Integer> outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getTreatmentPlaceState() {
		return treatmentPlaceState;
	}

	public void setTreatmentPlaceState(String treatmentPlaceState) {
		this.treatmentPlaceState = treatmentPlaceState;
	}
}
