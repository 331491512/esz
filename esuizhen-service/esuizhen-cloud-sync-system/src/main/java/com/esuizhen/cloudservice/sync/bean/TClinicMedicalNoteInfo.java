package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.constant.Constant;

/**
 * <p>Title:TDetectionReportSync</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月6日 下午4:17:44
 */
public class TClinicMedicalNoteInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//门诊病历记录ID。主键。ECLIYYYYMMDDHHMMSSnnnnnn
	private String clinicMedicalId;
	//ToB端生成的uuid值，唯一标识一个患者
	//患者ID
	private Long patientId;
	private String patientUuid;
	//电子病历ID
	private String emrId;
	//TOB生成的电子病历住院登记编号
	private String emrNo;
	//固定值，标识来源
	private Integer sourceFlag;
	//门诊流水号
	private String clinicNo;
	//病案号。医院对患者的标识
	private String patientNo;
	//医院ID
	private Integer hospitalId;
	//
	private String hospitalUuid;
	//症状描述
	private String symptomSummary;
	//门诊诊断
	private String diagnosis;
	//ICD-10编码
	private String diseaseCode;
	//门诊描述
	private String remark;
	//
	private Long clinicDoctor;
	//门诊医师uuid值，ToB端生成的uuid值，唯一标识一个医生。
	private String clinicDoctorUuid;
	private Long attendingDoctorId;
	private String attendingDoctoruuId;
	//本次门诊次数
	private Integer visitTimes;
	//就诊时间（实际发生时间）
	private Date visitTime;
	/*同步标识
	0：未同步（需要同步）；
	1：已同步
	*/
	private Integer syncFlag;
	//同步时的当前时间
	private Date syncTime;
	//记录创建时间（如第一次上传时间）
	private Date createTime;
	//
	private Date updateTime;
	//add by fanpanwei
	private Date rawCreateTime;
	private String healthCardNo;
	private String patientName;
	private String patientIdno;
	private String patientAddress;
	private String patientMobile;
	private Integer patientSex;
	private Date patientBirth;
	private Integer patientAge;
	private Integer deptId;
	private String deptUuid;
	private String deptName;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public Long getClinicDoctor() {
		return clinicDoctor;
	}
	public void setClinicDoctor(Long clinicDoctor) {
		this.clinicDoctor = clinicDoctor;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getEmrNo() {
		return emrNo;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
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
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
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
	public String getSymptomSummary() {
		return symptomSummary;
	}
	public void setSymptomSummary(String symptomSummary) {
		this.symptomSummary = symptomSummary;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getClinicDoctorUuid() {
		return clinicDoctorUuid;
	}
	public void setClinicDoctorUuid(String clinicDoctorUuid) {
		this.clinicDoctorUuid = clinicDoctorUuid;
	}
	public Long getAttendingDoctorId() {
		return attendingDoctorId;
	}
	public void setAttendingDoctorId(Long attendingDoctorId) {
		this.attendingDoctorId = attendingDoctorId;
	}
	public String getAttendingDoctoruuId() {
		return attendingDoctoruuId;
	}
	public void setAttendingDoctoruuId(String attendingDoctoruuId) {
		this.attendingDoctoruuId = attendingDoctoruuId;
	}
	public Integer getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(Integer visitTimes) {
		this.visitTimes = visitTimes;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
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
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public MedicalRecord createMedicalRecord(){
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanUtils.copyProperties(this, medicalRecord);
		medicalRecord.setEmrType(Constant.Ehr.EMRTYPE_EMERGENCY);
		medicalRecord.setEmrSubType(Constant.Ehr.EMRSUBTYPE_EMERGENCY);
		medicalRecord.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		medicalRecord.setStructFlag(Constant.Ehr.STRUCTFLAG_NO);
		medicalRecord.setVisibleFlag(Constant.Ehr.VISIBLEFLAG_NO_ONE);
		medicalRecord.setHandleFlag(Constant.Ehr.HANDLEFLAG_PENDING);
		medicalRecord.setSyncFlag(Constant.User.SYNCFLAG_YES);
		if(medicalRecord.getVisitTime()==null)medicalRecord.setVisitTime(new Date());
		return medicalRecord;
	}
}
