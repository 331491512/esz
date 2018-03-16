package com.esuizhen.cloudservice.sync.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 医生、患者关系bean
 * @author YYCHEN
 *
 */
public class DoctorPatient implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long doctorId;
	private String doctorUuid;
	private Long patientId;
	private String patientUuid;
	private Integer sourceFlag;
	private Date attentionTime;
	private Long hospitalId;
	private String hospitalUuid;
	private Long deptId;
	private String deptUuid;
	private Long subDeptId;
	private String subDeptUuid;
	private Integer hasMedicalRecord;
	private Integer vipFlag;
	private Integer positionTitle;
	private Date createTime;
	private Integer sourceDiagnosisFlag;
	private Integer firstVisitFlag;
	private Date syncTime;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	public Long getDeptId() {
		return deptId;
	}
	public Integer getPositionTitle() {
		return positionTitle;
	}
	public void setPositionTitle(Integer positionTitle) {
		this.positionTitle = positionTitle;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(Long subDeptId) {
		this.subDeptId = subDeptId;
	}
	public String getSubDeptUuid() {
		return subDeptUuid;
	}
	public void setSubDeptUuid(String subDeptUuid) {
		this.subDeptUuid = subDeptUuid;
	}
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}
	/**
	 * @return the doctorUuid
	 */
	public String getDoctorUuid() {
		return doctorUuid;
	}
	/**
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}
	public Integer getHasMedicalRecord() {
		return hasMedicalRecord;
	}
	public void setHasMedicalRecord(Integer hasMedicalRecord) {
		this.hasMedicalRecord = hasMedicalRecord;
	}
	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}
	/**
	 * @param doctorUuid the doctorUuid to set
	 */
	public void setDoctorUuid(String doctorUuid) {
		this.doctorUuid = doctorUuid;
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
	 * @return the sourceFlag
	 */
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	/**
	 * @param sourceFlag the sourceFlag to set
	 */
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	/**
	 * @return the attentionTime
	 */
	public Date getAttentionTime() {
		return attentionTime;
	}
	/**
	 * @param attentionTime the attentionTime to set
	 */
	public void setAttentionTime(Date attentionTime) {
		this.attentionTime = attentionTime;
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
	 * @return the doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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
	 * @return the hospitalId
	 */
	public Long getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getSourceDiagnosisFlag() {
		return sourceDiagnosisFlag;
	}
	public void setSourceDiagnosisFlag(Integer sourceDiagnosisFlag) {
		this.sourceDiagnosisFlag = sourceDiagnosisFlag;
	}
	public Integer getFirstVisitFlag() {
		return firstVisitFlag;
	}
	public void setFirstVisitFlag(Integer firstVisitFlag) {
		this.firstVisitFlag = firstVisitFlag;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	public DoctorPatient createDoctorPatient(){
		DoctorPatient doctorPatient = new DoctorPatient();
		doctorPatient.setDoctorUuid(doctorUuid);
		doctorPatient.setPatientUuid(patientUuid);
		doctorPatient.setSourceFlag(sourceFlag);
		doctorPatient.setFirstVisitFlag(firstVisitFlag);
		doctorPatient.setSourceDiagnosisFlag(sourceDiagnosisFlag);
		doctorPatient.setAttentionTime(attentionTime);
		doctorPatient.setCreateTime(createTime);
		doctorPatient.setSyncTime(syncTime);
		doctorPatient.setHasMedicalRecord(hasMedicalRecord);
		doctorPatient.setVipFlag(vipFlag);
		if(doctorPatient.getCreateTime()==null)
			doctorPatient.setCreateTime(new Date());
		if(doctorPatient.getAttentionTime()==null)
			doctorPatient.setAttentionTime(doctorPatient.getCreateTime());
		return doctorPatient;
	}
	public DoctorPatient createMatchDoctorPatient(){
		DoctorPatient doctorPatient = createDoctorPatient();
		doctorPatient.setDoctorUuid(doctorUuid);
		doctorPatient.setPatientUuid(patientUuid);
		return doctorPatient;
	}
}
