package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 手术信息bean
 * @author YYCHEN
 *
 */
public class SurgeryNote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String surgeryId;
	private String emrId;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer hospitalId;
	private String hospitalUuid;
	private String inhospitalId;
	private Integer deptId;
	private String deptUuid;
	private String bedNo;
	private String surgeryName;
	private Long surgeryDoctor;
	private String surgeryDoctorUuid;
	private Long surgeryAssistant1;
	private String surgeryAssistant1Uuid;
	private Long surgeryAssistant2;
	private String surgeryAssistant2Uuid;
	private Date surgeryDate;
	private Date surgeryBeginTime;
	private Date surgeryEndTime;
	private Long anesthesiaDoctor;
	private String anesthesiaDoctorUuid;
	private String anesthesiaWay;
	private String preOperativeDiagnosis;
	private String inOperativeDiagnosis;
	private String bodyPosture;
	private Integer transfusion;
	private Long surgeryNurses;
	private String surgeryNursesUuid;
	private String operativeApproach;
	private String operativeProbe;
	private String operativeMeasures;
	private String operativeSituation;
	private String woundClosureWay;
	private String incisionBandagedWay;
	private String remark;
	private Date createTime;
	private Date updateTime;
	private String opCode;
	//start by fanpanwei
	private String mainID;
	private Integer inhospitalTimes;
	private Integer opLevel;
	private String surgeryDoctorName;
	private String surgeryAssistant1Name;
	private String surgeryAssistant2Name;
	private String anesthesiaDoctorName;
	private Integer incisionLevel;
	private Integer incisionHeal;
	private Integer curePlan;
	private String treatmentSchemeName;
	private Date rawCreateTime;
	private Integer incisionGroup;
	private Integer incisionHealLevel;
	private Integer rawAnesthesiaWayId;
	private Integer anesthesiaWayId;

	private Integer syncFlag;

	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	//private Integer treatmentSchemeId;//?????????目前与接口文档不一致
	//end by fanpanwei
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	/**
	 * @return the surgeryId
	 */
	public String getSurgeryId() {
		return surgeryId;
	}
	/**
	 * @param surgeryId the surgeryId to set
	 */
	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
	}
	/**
	 * @return the emrId
	 */
	public String getEmrId() {
		return emrId;
	}
	/**
	 * @param emrId the emrId to set
	 */
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the patientUuid
	 */
	public String getPatientUuid() {
		return patientUuid;
	}
	/**
	 * @param patientUuid the patientUuid to set
	 */
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	/**
	 * @return the patientNo
	 */
	public String getPatientNo() {
		return patientNo;
	}
	/**
	 * @param patientNo the patientNo to set
	 */
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	/**
	 * @return the hospitalId
	 */
	public Integer getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}
	
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return the deptUuid
	 */
	public String getDeptUuid() {
		return deptUuid;
	}
	/**
	 * @param deptUuid the deptUuid to set
	 */
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	/**
	 * @return the bedNo
	 */
	public String getBedNo() {
		return bedNo;
	}
	/**
	 * @param bedNo the bedNo to set
	 */
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	/**
	 * @return the surgeryName
	 */
	public String getSurgeryName() {
		return surgeryName;
	}
	/**
	 * @param surgeryName the surgeryName to set
	 */
	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}
	/**
	 * @return the surgeryDoctor
	 */
	public Long getSurgeryDoctor() {
		return surgeryDoctor;
	}
	/**
	 * @param surgeryDoctor the surgeryDoctor to set
	 */
	public void setSurgeryDoctor(Long surgeryDoctor) {
		this.surgeryDoctor = surgeryDoctor;
	}
	/**
	 * @return the surgeryDoctorUuid
	 */
	public String getSurgeryDoctorUuid() {
		return surgeryDoctorUuid;
	}
	/**
	 * @param surgeryDoctorUuid the surgeryDoctorUuid to set
	 */
	public void setSurgeryDoctorUuid(String surgeryDoctorUuid) {
		this.surgeryDoctorUuid = surgeryDoctorUuid;
	}
	/**
	 * @return the surgeryAssistant1
	 */
	public Long getSurgeryAssistant1() {
		return surgeryAssistant1;
	}
	/**
	 * @param surgeryAssistant1 the surgeryAssistant1 to set
	 */
	public void setSurgeryAssistant1(Long surgeryAssistant1) {
		this.surgeryAssistant1 = surgeryAssistant1;
	}
	/**
	 * @return the surgeryAssistant1Uuid
	 */
	public String getSurgeryAssistant1Uuid() {
		return surgeryAssistant1Uuid;
	}
	/**
	 * @param surgeryAssistant1Uuid the surgeryAssistant1Uuid to set
	 */
	public void setSurgeryAssistant1Uuid(String surgeryAssistant1Uuid) {
		this.surgeryAssistant1Uuid = surgeryAssistant1Uuid;
	}
	/**
	 * @return the surgeryAssistant2
	 */
	public Long getSurgeryAssistant2() {
		return surgeryAssistant2;
	}
	/**
	 * @param surgeryAssistant2 the surgeryAssistant2 to set
	 */
	public void setSurgeryAssistant2(Long surgeryAssistant2) {
		this.surgeryAssistant2 = surgeryAssistant2;
	}
	/**
	 * @return the surgeryAssistant2Uuid
	 */
	public String getSurgeryAssistant2Uuid() {
		return surgeryAssistant2Uuid;
	}
	/**
	 * @param surgeryAssistant2Uuid the surgeryAssistant2Uuid to set
	 */
	public void setSurgeryAssistant2Uuid(String surgeryAssistant2Uuid) {
		this.surgeryAssistant2Uuid = surgeryAssistant2Uuid;
	}
	/**
	 * @return the surgeryDate
	 */
	public Date getSurgeryDate() {
		return surgeryDate;
	}
	/**
	 * @param surgeryDate the surgeryDate to set
	 */
	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}
	/**
	 * @return the surgeryBeginTime
	 */
	public Date getSurgeryBeginTime() {
		return surgeryBeginTime;
	}
	/**
	 * @param surgeryBeginTime the surgeryBeginTime to set
	 */
	public void setSurgeryBeginTime(Date surgeryBeginTime) {
		this.surgeryBeginTime = surgeryBeginTime;
	}
	/**
	 * @return the surgeryEndTime
	 */
	public Date getSurgeryEndTime() {
		return surgeryEndTime;
	}
	/**
	 * @param surgeryEndTime the surgeryEndTime to set
	 */
	public void setSurgeryEndTime(Date surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}
	/**
	 * @return the anesthesiaDoctor
	 */
	public Long getAnesthesiaDoctor() {
		return anesthesiaDoctor;
	}
	/**
	 * @param anesthesiaDoctor the anesthesiaDoctor to set
	 */
	public void setAnesthesiaDoctor(Long anesthesiaDoctor) {
		this.anesthesiaDoctor = anesthesiaDoctor;
	}
	/**
	 * @return the anesthesiaDoctorUuid
	 */
	public String getAnesthesiaDoctorUuid() {
		return anesthesiaDoctorUuid;
	}
	/**
	 * @param anesthesiaDoctorUuid the anesthesiaDoctorUuid to set
	 */
	public void setAnesthesiaDoctorUuid(String anesthesiaDoctorUuid) {
		this.anesthesiaDoctorUuid = anesthesiaDoctorUuid;
	}
	/**
	 * @return the anesthesiaWay
	 */
	public String getAnesthesiaWay() {
		return anesthesiaWay;
	}
	/**
	 * @param anesthesiaWay the anesthesiaWay to set
	 */
	public void setAnesthesiaWay(String anesthesiaWay) {
		this.anesthesiaWay = anesthesiaWay;
	}
	/**
	 * @return the preOperativeDiagnosis
	 */
	public String getPreOperativeDiagnosis() {
		return preOperativeDiagnosis;
	}
	/**
	 * @param preOperativeDiagnosis the preOperativeDiagnosis to set
	 */
	public void setPreOperativeDiagnosis(String preOperativeDiagnosis) {
		this.preOperativeDiagnosis = preOperativeDiagnosis;
	}
	/**
	 * @return the inOperativeDiagnosis
	 */
	public String getInOperativeDiagnosis() {
		return inOperativeDiagnosis;
	}
	/**
	 * @param inOperativeDiagnosis the inOperativeDiagnosis to set
	 */
	public void setInOperativeDiagnosis(String inOperativeDiagnosis) {
		this.inOperativeDiagnosis = inOperativeDiagnosis;
	}
	/**
	 * @return the bodyPosture
	 */
	public String getBodyPosture() {
		return bodyPosture;
	}
	/**
	 * @param bodyPosture the bodyPosture to set
	 */
	public void setBodyPosture(String bodyPosture) {
		this.bodyPosture = bodyPosture;
	}
	/**
	 * @return the transfusion
	 */
	public Integer getTransfusion() {
		return transfusion;
	}
	/**
	 * @param transfusion the transfusion to set
	 */
	public void setTransfusion(Integer transfusion) {
		this.transfusion = transfusion;
	}
	/**
	 * @return the surgeryNurses
	 */
	public Long getSurgeryNurses() {
		return surgeryNurses;
	}
	/**
	 * @param surgeryNurses the surgeryNurses to set
	 */
	public void setSurgeryNurses(Long surgeryNurses) {
		this.surgeryNurses = surgeryNurses;
	}
	/**
	 * @return the surgeryNursesUuid
	 */
	public String getSurgeryNursesUuid() {
		return surgeryNursesUuid;
	}
	/**
	 * @param surgeryNursesUuid the surgeryNursesUuid to set
	 */
	public void setSurgeryNursesUuid(String surgeryNursesUuid) {
		this.surgeryNursesUuid = surgeryNursesUuid;
	}
	/**
	 * @return the operativeApproach
	 */
	public String getOperativeApproach() {
		return operativeApproach;
	}
	/**
	 * @param operativeApproach the operativeApproach to set
	 */
	public void setOperativeApproach(String operativeApproach) {
		this.operativeApproach = operativeApproach;
	}
	/**
	 * @return the operativeProbe
	 */
	public String getOperativeProbe() {
		return operativeProbe;
	}
	/**
	 * @param operativeProbe the operativeProbe to set
	 */
	public void setOperativeProbe(String operativeProbe) {
		this.operativeProbe = operativeProbe;
	}
	/**
	 * @return the operativeMeasures
	 */
	public String getOperativeMeasures() {
		return operativeMeasures;
	}
	/**
	 * @param operativeMeasures the operativeMeasures to set
	 */
	public void setOperativeMeasures(String operativeMeasures) {
		this.operativeMeasures = operativeMeasures;
	}
	/**
	 * @return the operativeSituation
	 */
	public String getOperativeSituation() {
		return operativeSituation;
	}
	/**
	 * @param operativeSituation the operativeSituation to set
	 */
	public void setOperativeSituation(String operativeSituation) {
		this.operativeSituation = operativeSituation;
	}
	/**
	 * @return the woundClosureWay
	 */
	public String getWoundClosureWay() {
		return woundClosureWay;
	}
	/**
	 * @param woundClosureWay the woundClosureWay to set
	 */
	public void setWoundClosureWay(String woundClosureWay) {
		this.woundClosureWay = woundClosureWay;
	}
	/**
	 * @return the incisionBandagedWay
	 */
	public String getIncisionBandagedWay() {
		return incisionBandagedWay;
	}
	/**
	 * @param incisionBandagedWay the incisionBandagedWay to set
	 */
	public void setIncisionBandagedWay(String incisionBandagedWay) {
		this.incisionBandagedWay = incisionBandagedWay;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getMainID() {
		return mainID;
	}
	public void setMainID(String mainID) {
		this.mainID = mainID;
	}
	public Integer getInhospitalTimes() {
		return inhospitalTimes;
	}
	public void setInhospitalTimes(Integer inhospitalTimes) {
		this.inhospitalTimes = inhospitalTimes;
	}
	public Integer getOpLevel() {
		return opLevel;
	}
	public void setOpLevel(Integer opLevel) {
		this.opLevel = opLevel;
	}
	public String getSurgeryDoctorName() {
		return surgeryDoctorName;
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
	public String getAnesthesiaDoctorName() {
		return anesthesiaDoctorName;
	}
	public void setAnesthesiaDoctorName(String anesthesiaDoctorName) {
		this.anesthesiaDoctorName = anesthesiaDoctorName;
	}
	public Integer getIncisionLevel() {
		return incisionLevel;
	}
	public void setIncisionLevel(Integer incisionLevel) {
		this.incisionLevel = incisionLevel;
	}
	public Integer getIncisionHeal() {
		return incisionHeal;
	}
	public void setIncisionHeal(Integer incisionHeal) {
		this.incisionHeal = incisionHeal;
	}
	public Integer getCurePlan() {
		return curePlan;
	}
	public void setCurePlan(Integer curePlan) {
		this.curePlan = curePlan;
	}
	public String getTreatmentSchemeName() {
		return treatmentSchemeName;
	}
	public void setTreatmentSchemeName(String treatmentSchemeName) {
		this.treatmentSchemeName = treatmentSchemeName;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getIncisionGroup() {
		return incisionGroup;
	}
	public void setIncisionGroup(Integer incisionGroup) {
		this.incisionGroup = incisionGroup;
	}
	public Integer getIncisionHealLevel() {
		return incisionHealLevel;
	}
	public void setIncisionHealLevel(Integer incisionHealLevel) {
		this.incisionHealLevel = incisionHealLevel;
	}
	public Integer getRawAnesthesiaWayId() {
		return rawAnesthesiaWayId;
	}
	public void setRawAnesthesiaWayId(Integer rawAnesthesiaWayId) {
		this.rawAnesthesiaWayId = rawAnesthesiaWayId;
	}
	public Integer getAnesthesiaWayId() {
		return anesthesiaWayId;
	}
	public void setAnesthesiaWayId(Integer anesthesiaWayId) {
		this.anesthesiaWayId = anesthesiaWayId;
	}
	
/*	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}
	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}*/
	
	
}
