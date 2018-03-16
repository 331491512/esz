package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/**
 * 医患bean
 * @author LHY
 */
public class SyncRDoctorPatient implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Long id;   
	private Long patientId;   
	private String patientUuid;   
	private Long doctorId;   
	private String doctorUuid;   
	private Integer outDeptId;
	private String outDeptUuid;
	private String outDeptName;
	private Integer inDeptId;
	private String inDeptUuid;
	private String inDeptName;
	private Integer hasMedicalRecord;   
	private Integer vipFlag;   
	private Integer firstVisitFlag;   
	private Date attentionTime;  
	private Date createTime;
	private Date updateTime;
	private Integer sourceFlag;   
	private String sourceDiagnosisFlag;   
	private String mergeFlag;   
	private Long mergeFrom;  
	private String mergeFromUuid;  
	private Long mergeTarget;   
	private String mergeTargetUuid;
	private Date mergeTime;
	private String batchId;
	private Integer professionalRank;   
	
	public Integer getProfessionalRank() {
		return professionalRank;
	}
	public void setProfessionalRank(Integer professionalRank) {
		this.professionalRank = professionalRank;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorUuid() {
		return doctorUuid;
	}
	public void setDoctorUuid(String doctorUuid) {
		this.doctorUuid = doctorUuid;
	}
	public Integer getHasMedicalRecord() {
		return hasMedicalRecord;
	}
	public void setHasMedicalRecord(Integer hasMedicalRecord) {
		this.hasMedicalRecord = hasMedicalRecord;
	}
	public Integer getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}
	public Integer getFirstVisitFlag() {
		return firstVisitFlag;
	}
	public void setFirstVisitFlag(Integer firstVisitFlag) {
		this.firstVisitFlag = firstVisitFlag;
	}
	public Date getAttentionTime() {
		return attentionTime;
	}
	public void setAttentionTime(Date attentionTime) {
		this.attentionTime = attentionTime;
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
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getSourceDiagnosisFlag() {
		return sourceDiagnosisFlag;
	}
	public void setSourceDiagnosisFlag(String sourceDiagnosisFlag) {
		this.sourceDiagnosisFlag = sourceDiagnosisFlag;
	}
	public String getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(String mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public Date getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(Date mergeTime) {
		this.mergeTime = mergeTime;
	}
	
	public Integer getOutDeptId() {
		return outDeptId;
	}
	public void setOutDeptId(Integer outDeptId) {
		this.outDeptId = outDeptId;
	}
	public String getOutDeptUuid() {
		return outDeptUuid;
	}
	public void setOutDeptUuid(String outDeptUuid) {
		this.outDeptUuid = outDeptUuid;
	}
	public String getOutDeptName() {
		return outDeptName;
	}
	public void setOutDeptName(String outDeptName) {
		this.outDeptName = outDeptName;
	}
	public Integer getInDeptId() {
		return inDeptId;
	}
	public void setInDeptId(Integer inDeptId) {
		this.inDeptId = inDeptId;
	}
	public String getInDeptUuid() {
		return inDeptUuid;
	}
	public void setInDeptUuid(String inDeptUuid) {
		this.inDeptUuid = inDeptUuid;
	}
	public String getInDeptName() {
		return inDeptName;
	}
	public void setInDeptName(String inDeptName) {
		this.inDeptName = inDeptName;
	}
	public TBatchDataResultInfo createResultInfo() {
		TBatchDataResultInfo result = new TBatchDataResultInfo();
		result.setResultId(this.doctorUuid+"-"+this.patientUuid);
		result.setId(this.id+"");
		result.setSyncTime(new Date());
		return result;
	} 
	
}