package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/**
 * 医患bean
 * @author LHY
 */
public class SyncRDeptPatient implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Long id;   
	private Long patientId;   
	private String patientUuid;   
	private Integer deptId;
	private String deptUuid;
	private Integer hospitalId;
	private Integer sourceFlag;
	private Date createTime;
	private Date updateTime;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private Date mergeTime;
	private Integer mergeFlag;
	private String batchId;
	private Integer isInDept;
	private Integer isOutDept;
	
	
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


	public Integer getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}


	public Integer getSourceFlag() {
		return sourceFlag;
	}


	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
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


	public Integer getMergeFlag() {
		return mergeFlag;
	}


	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
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

	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public Integer getIsInDept() {
		return isInDept;
	}


	public void setIsInDept(Integer isInDept) {
		this.isInDept = isInDept;
	}


	public Integer getIsOutDept() {
		return isOutDept;
	}


	public void setIsOutDept(Integer isOutDept) {
		this.isOutDept = isOutDept;
	}


	public TBatchDataResultInfo createResultInfo() {
		TBatchDataResultInfo result = new TBatchDataResultInfo();
		result.setResultId(this.deptUuid+"-"+this.patientUuid);
		result.setId(this.id+"");
		result.setSyncTime(new Date());
		return result;
	} 
	
}