package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.model.SurgeryNote;
import com.westangel.common.constant.Constant;

/**
 * 患者手术信息
 * @author YYCHEN
 *
 */
public class TPatientSurgeryNoteDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String surgeryId;
	private String emrNo;
	private String emrId;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private Integer hospitalId;
	private String hospitalUuid;
	private Integer deptId;
	private String bedNo;
	private String surgeryName;
	private Long surgeryDoctor;
	private String surgeryDoctorUuid;
	private Long surgeryAssistant1;
	private String surgeryAssistant1Uuid;
	private Long surgeryAssistant2;
	private String surgeryAssistant2Uuid;
	//
	private Date visitTime;
	private String opCode;
	//手术日期
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
	private String surgeryNurses;
	private String operativeApproach;
	private String operativeProbe;
	private String operativeMeasures;
	private String operativeSituation;
	private String woundClosureWay;
	private String incisionBandagedWay;
	private String remark;
	private Date createTime;
	private Date updateTime;
	private String cm3Code;
	private Integer incisionHeal;
	private Integer incisionLevel;
	private Integer curePlan;
	private Date inhospitalDate;
	//start by fanpanwei
	private String inhospitalId;
	private String mainID;
	private Integer inhospitalTimes;
	private String deptUuid;
	private Integer opLevel;
	private String surgeryDoctorName;
	private String surgeryAssistant1Name;
	private String surgeryAssistant2Name;
	private String anesthesiaDoctorName;
	private String treatmentSchemeName;
	private Date rawCreateTime;
	private Integer treatmentSchemeId;//?????????目前与接口文档不一致
	private Integer incisionGroup;
	private Integer incisionHealLevel;
	private Integer rawAnesthesiaWayId;
	private Integer anesthesiaWayId;
	//end by fanpanwei
	
	public String getSurgeryId() {
		return surgeryId;
	}
	public void setSurgeryId(String surgeryId) {
		this.surgeryId = surgeryId;
	}
	public String getEmrNo() {
		return emrNo;
	}
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
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
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
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
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
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
	public String getSurgeryName() {
		return surgeryName;
	}
	public void setSurgeryName(String surgeryName) {
		this.surgeryName = surgeryName;
	}
	public Long getSurgeryDoctor() {
		return surgeryDoctor;
	}
	public void setSurgeryDoctor(Long surgeryDoctor) {
		this.surgeryDoctor = surgeryDoctor;
	}
	public String getSurgeryDoctorUuid() {
		return surgeryDoctorUuid;
	}
	public void setSurgeryDoctorUuid(String surgeryDoctorUuid) {
		this.surgeryDoctorUuid = surgeryDoctorUuid;
	}
	public Long getSurgeryAssistant1() {
		return surgeryAssistant1;
	}
	public void setSurgeryAssistant1(Long surgeryAssistant1) {
		this.surgeryAssistant1 = surgeryAssistant1;
	}
	public String getSurgeryAssistant1Uuid() {
		return surgeryAssistant1Uuid;
	}
	public void setSurgeryAssistant1Uuid(String surgeryAssistant1Uuid) {
		this.surgeryAssistant1Uuid = surgeryAssistant1Uuid;
	}
	public Long getSurgeryAssistant2() {
		return surgeryAssistant2;
	}
	public void setSurgeryAssistant2(Long surgeryAssistant2) {
		this.surgeryAssistant2 = surgeryAssistant2;
	}
	public String getSurgeryAssistant2Uuid() {
		return surgeryAssistant2Uuid;
	}
	public void setSurgeryAssistant2Uuid(String surgeryAssistant2Uuid) {
		this.surgeryAssistant2Uuid = surgeryAssistant2Uuid;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
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
	public Long getAnesthesiaDoctor() {
		return anesthesiaDoctor;
	}
	public void setAnesthesiaDoctor(Long anesthesiaDoctor) {
		this.anesthesiaDoctor = anesthesiaDoctor;
	}
	public String getAnesthesiaDoctorUuid() {
		return anesthesiaDoctorUuid;
	}
	public void setAnesthesiaDoctorUuid(String anesthesiaDoctorUuid) {
		this.anesthesiaDoctorUuid = anesthesiaDoctorUuid;
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
	public Integer getTransfusion() {
		return transfusion;
	}
	public void setTransfusion(Integer transfusion) {
		this.transfusion = transfusion;
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
	public String getCm3Code() {
		return cm3Code;
	}
	public void setCm3Code(String cm3Code) {
		this.cm3Code = cm3Code;
	}
	public Integer getIncisionHeal() {
		return incisionHeal;
	}
	public void setIncisionHeal(Integer incisionHeal) {
		this.incisionHeal = incisionHeal;
	}
	public Integer getIncisionLevel() {
		return incisionLevel;
	}
	public void setIncisionLevel(Integer incisionLevel) {
		this.incisionLevel = incisionLevel;
	}
	public Integer getCurePlan() {
		return curePlan;
	}
	public void setCurePlan(Integer curePlan) {
		this.curePlan = curePlan;
	}
	public Date getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
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
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
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
	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}
	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}
	
	public MedicalRecord createMedicalRecord(){
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanUtils.copyProperties(this, medicalRecord);
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_HOSPITALIZATION);
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_OPERATION);
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setVisibleFlag(Constant.User.VISIBLEFLAG_HOSPITAL);
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_YES);
		medicalRecord.setSyncFlag(Constant.SYNC_OK);
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(surgeryDate);
		}
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(inhospitalDate);
		}
		if (medicalRecord.getVisitTime() == null) {
			medicalRecord.setVisitTime(createTime==null?new Date():createTime);
		}
		if(medicalRecord.getCreateTime()==null)
			medicalRecord.setCreateTime(medicalRecord.getVisitTime());
		return medicalRecord;
	}
	
	public SurgeryNote createSurgeryNote(){
		SurgeryNote surgeryNote = new SurgeryNote();
		BeanUtils.copyProperties(this, surgeryNote);
		surgeryNote.setSyncFlag(Constant.SYNC_OK);
		return surgeryNote;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
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
	
}
