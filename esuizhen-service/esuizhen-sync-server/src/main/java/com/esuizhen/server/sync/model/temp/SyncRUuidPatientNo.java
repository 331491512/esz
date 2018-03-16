package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/**
 * RUUIDPATIENTNO bean
 * @author LHY
 */
public class SyncRUuidPatientNo implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Long id;  
	private String uuid;   
	private Long patientId;   
	private String patientUuid;  
	private String patientNo;
	private String newPatientNo;
	private Integer type;   
	private Integer flag;   
	private Date createTime; 
	private Date updateTime;
	private String batchId;
	private String hospitalId;
	
	
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
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public String getNewPatientNo() {
		return newPatientNo;
	}
	public void setNewPatientNo(String newPatientNo) {
		this.newPatientNo = newPatientNo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
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
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public TBatchDataResultInfo createResultInfo() {
		TBatchDataResultInfo result = new TBatchDataResultInfo();
		result.setResultId(this.hospitalId+"-"+this.id);
		result.setId(this.id+"");
		result.setSyncTime(new Date());
		return result;
	} 
	
}