package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;

public class TPatientSurgeryInfo {

	/**
	 * 手术记录ID
	 */
	private String surgeryId;

	/**
	 * 病案首页ID
	 */
	private String inhospitalId;

	/**
	 * 电子病历ID
	 */
	private String emrId;

	/**
	 * 患者ID
	 */
	private Long patientId;

	/**
	 * 病案号。医院对患者的标识。
	 */
	private String patientNo;

	/**
	 * 医院ID
	 */
	private Integer hospitalId;

	/**
	 * 科别
	 */
	private Integer deptId;

	/**
	 * 床号
	 */
	private String bedNo;

	/**
	 * 手术代码
	 */
	private String opCode;

	/**
	 * 治疗方案Id
	 */
	private Integer treatmentSchemeId;

	/**
	 * 治疗方案
	 */
	private String treatmentSchemeName;

	/**
	 * 手术级别
	 */
	private Integer opLevel;
	private String opLevelName;

	/**
	 * 手术名称
	 */
	private String surgeryName;

	/**
	 * 主刀医师
	 */
	private Integer surgeryDoctor;

	/**
	 * 手术助手（一助）
	 */
	private Integer surgeryAssistant1;

	/**
	 * 手术助手（二助）
	 */
	private Integer surgeryAssistant2;

	/**
	 * 手术日期
	 */
	private Date surgeryDate;

	/**
	 * 手术开始时间
	 */
	private Date surgeryBeginTime;

	/**
	 * 手术结束时间
	 */
	private Date surgeryEndTime;

	/**
	 * 麻醉医师
	 */
	private Integer anesthesiaDoctor;

	/**
	 * 麻醉方式
	 */
	private String anesthesiaWay;

	/**
	 * 麻醉方式
	 */
	private Integer anesthesiaWayId;

	/**
	 * 术前诊断
	 */
	private String preOperativeDiagnosis;

	/**
	 * 术中诊断
	 */
	private String inOperativeDiagnosis;

	/**
	 * 手术体位
	 */
	private String bodyPosture;

	/**
	 * 手术护士
	 */
	private String surgeryNurses;

	/**
	 * 手术入路
	 */
	private String operativeApproach;

	/**
	 * 手术探查所见
	 */
	private String operativeProbe;

	/**
	 * 手术主要措施
	 */
	private String operativeMeasures;

	/**
	 * 手术出现情况及处理
	 */
	private String operativeSituation;

	/**
	 * 切口缝合方式
	 */
	private String woundClosureWay;

	/**
	 * 切口包扎方式
	 */
	private String incisionBandagedWay;

	/**
	 * 其他说明
	 */
	private String remark;

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
	 * 手术治疗Id
	 */
	private String treatmentId;

	private Integer incisionLevelId;
	private Integer healingId;
	private String incisionLevel; // 切口等级名称
	private String healing; // 愈合情况
	private Integer incisionHealingId;

	private Long operatorId;
	private String operatorName;

	private String surgeryDoctorName;

	private String surgeryAssistant1Name;

	private String surgeryAssistant2Name;

	private String anesthesiaDoctorName;

	private Integer serialNum;

	/**
	 * 手术性质
	 */
	private Integer opCharacter;
	private String opCharacterName;

	/**
	 * 门诊记录
	 */
	private String clinicMedicalId;

	private Integer incisionCleanliness; // 切口清洁度
	private Integer ASALevel; // 麻醉等级
	private Integer nOperationLevel; // 手术等级
	private Integer operationDuration; // 手术持续时间
	private Integer incisionInfected; // 切口感染
	private Integer isEmergency; // 是否急诊，1是急诊
	private String riskAssessment; // 风险评估
	private Integer actionFlag; // 操作标识
								// 1代表增加，2代表更新，3代表删除
	private String incisionHealing;

	public String getIncisionHealing() {
		return incisionHealing;
	}

	public void setIncisionHealing(String incisionHealing) {
		this.incisionHealing = incisionHealing;
	}

	public String getOpCharacterName() {
		return opCharacterName;
	}

	public Integer getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(Integer actionFlag) {
		this.actionFlag = actionFlag;
	}

	public void setOpCharacterName(String opCharacterName) {
		this.opCharacterName = opCharacterName;
	}

	public String getOpLevelName() {
		return opLevelName;
	}

	public void setOpLevelName(String opLevelName) {
		this.opLevelName = opLevelName;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public String getSurgeryId() {
		return surgeryId;
	}

	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
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

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	public String getTreatmentSchemeName() {
		return treatmentSchemeName;
	}

	public void setTreatmentSchemeName(String treatmentSchemeName) {
		this.treatmentSchemeName = treatmentSchemeName;
	}

	public Integer getOpLevel() {
		return opLevel;
	}

	public void setOpLevel(Integer opLevel) {
		this.opLevel = opLevel;
	}

	public String getSurgeryName() {
		return surgeryName;
	}

	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}

	public Integer getSurgeryDoctor() {
		return surgeryDoctor;
	}

	public void setSurgeryDoctor(Integer surgeryDoctor) {
		this.surgeryDoctor = surgeryDoctor;
	}

	public Integer getSurgeryAssistant1() {
		return surgeryAssistant1;
	}

	public void setSurgeryAssistant1(Integer surgeryAssistant1) {
		this.surgeryAssistant1 = surgeryAssistant1;
	}

	public Integer getSurgeryAssistant2() {
		return surgeryAssistant2;
	}

	public void setSurgeryAssistant2(Integer surgeryAssistant2) {
		this.surgeryAssistant2 = surgeryAssistant2;
	}

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}

	public Date getSurgeryBeginTime() {
		return surgeryBeginTime;
	}

	public void setSurgeryBeginTime(Date surgeryBeginTime) {
		this.surgeryBeginTime = surgeryBeginTime;
	}

	public Date getSurgeryEndTime() {
		return surgeryEndTime;
	}

	public void setSurgeryEndTime(Date surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}

	public Integer getAnesthesiaDoctor() {
		return anesthesiaDoctor;
	}

	public void setAnesthesiaDoctor(Integer anesthesiaDoctor) {
		this.anesthesiaDoctor = anesthesiaDoctor;
	}

	public String getAnesthesiaWay() {
		return anesthesiaWay;
	}

	public void setAnesthesiaWay(String anesthesiaWay) {
		this.anesthesiaWay = anesthesiaWay;
	}

	public String getPreOperativeDiagnosis() {
		return preOperativeDiagnosis;
	}

	public void setPreOperativeDiagnosis(String preOperativeDiagnosis) {
		this.preOperativeDiagnosis = preOperativeDiagnosis;
	}

	public String getInOperativeDiagnosis() {
		return inOperativeDiagnosis;
	}

	public void setInOperativeDiagnosis(String inOperativeDiagnosis) {
		this.inOperativeDiagnosis = inOperativeDiagnosis;
	}

	public String getBodyPosture() {
		return bodyPosture;
	}

	public void setBodyPosture(String bodyPosture) {
		this.bodyPosture = bodyPosture;
	}

	public String getSurgeryNurses() {
		return surgeryNurses;
	}

	public void setSurgeryNurses(String surgeryNurses) {
		this.surgeryNurses = surgeryNurses;
	}

	public String getOperativeApproach() {
		return operativeApproach;
	}

	public void setOperativeApproach(String operativeApproach) {
		this.operativeApproach = operativeApproach;
	}

	public String getOperativeProbe() {
		return operativeProbe;
	}

	public void setOperativeProbe(String operativeProbe) {
		this.operativeProbe = operativeProbe;
	}

	public String getOperativeMeasures() {
		return operativeMeasures;
	}

	public void setOperativeMeasures(String operativeMeasures) {
		this.operativeMeasures = operativeMeasures;
	}

	public String getOperativeSituation() {
		return operativeSituation;
	}

	public void setOperativeSituation(String operativeSituation) {
		this.operativeSituation = operativeSituation;
	}

	public String getWoundClosureWay() {
		return woundClosureWay;
	}

	public void setWoundClosureWay(String woundClosureWay) {
		this.woundClosureWay = woundClosureWay;
	}

	public String getIncisionBandagedWay() {
		return incisionBandagedWay;
	}

	public void setIncisionBandagedWay(String incisionBandagedWay) {
		this.incisionBandagedWay = incisionBandagedWay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	private String incisionHealingLevel;

	public String getIncisionHealingLevel() {
		return incisionHealingLevel;
	}

	public void setIncisionHealingLevel(String incisionHealingLevel) {
		this.incisionHealingLevel = incisionHealingLevel;
	}

	public String getSurgeryDoctorName() {
		return surgeryDoctorName;
	}

	public Integer getIncisionLevelId() {
		return incisionLevelId;
	}

	public void setIncisionLevelId(Integer incisionLevelId) {
		this.incisionLevelId = incisionLevelId;
	}

	public Integer getHealingId() {
		return healingId;
	}

	public void setHealingId(Integer healingId) {
		this.healingId = healingId;
	}

	public String getIncisionLevel() {
		return incisionLevel;
	}

	public void setIncisionLevel(String incisionLevel) {
		this.incisionLevel = incisionLevel;
	}

	public String getHealing() {
		return healing;
	}

	public void setHealing(String healing) {
		this.healing = healing;
	}

	public Integer getIncisionCleanliness() {
		return incisionCleanliness;
	}

	public void setIncisionCleanliness(Integer incisionCleanliness) {
		this.incisionCleanliness = incisionCleanliness;
	}

	public Integer getASALevel() {
		return ASALevel;
	}

	public void setASALevel(Integer aSALevel) {
		ASALevel = aSALevel;
	}

	public Integer getnOperationLevel() {
		return nOperationLevel;
	}

	public void setnOperationLevel(Integer nOperationLevel) {
		this.nOperationLevel = nOperationLevel;
	}

	public Integer getOperationDuration() {
		return operationDuration;
	}

	public void setOperationDuration(Integer operationDuration) {
		this.operationDuration = operationDuration;
	}

	public Integer getIncisionInfected() {
		return incisionInfected;
	}

	public void setIncisionInfected(Integer incisionInfected) {
		this.incisionInfected = incisionInfected;
	}

	public Integer getIsEmergency() {
		return isEmergency;
	}

	public void setIsEmergency(Integer isEmergency) {
		this.isEmergency = isEmergency;
	}

	public String getRiskAssessment() {
		return riskAssessment;
	}

	public void setRiskAssessment(String riskAssessment) {
		this.riskAssessment = riskAssessment;
	}

	public void setSurgeryDoctorName(String surgeryDoctorName) {
		this.surgeryDoctorName = surgeryDoctorName;
	}

	public String getSurgeryAssistant1Name() {
		return surgeryAssistant1Name;
	}

	public void setSurgeryAssistant1Name(String surgeryAssistant1Name) {
		this.surgeryAssistant1Name = surgeryAssistant1Name;
	}

	public String getSurgeryAssistant2Name() {
		return surgeryAssistant2Name;
	}

	public void setSurgeryAssistant2Name(String surgeryAssistant2Name) {
		this.surgeryAssistant2Name = surgeryAssistant2Name;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getAnesthesiaDoctorName() {
		return anesthesiaDoctorName;
	}

	public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
		this.anesthesiaDoctorName = anesthesiaDoctorName;
	}

	public Integer getIncisionHealingId() {
		return incisionHealingId;
	}

	public void setIncisionHealingId(Integer incisionHealingId) {
		this.incisionHealingId = incisionHealingId;
	}

	public Integer getOpCharacter() {
		return opCharacter;
	}

	public void setOpCharacter(Integer opCharacter) {
		this.opCharacter = opCharacter;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Integer getAnesthesiaWayId() {
		return anesthesiaWayId;
	}

	public void setAnesthesiaWayId(Integer anesthesiaWayId) {
		this.anesthesiaWayId = anesthesiaWayId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

}
