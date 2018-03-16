package com.westangel.common.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: HospitalPatientBriefInfo 
* @Description: 医院/患者关系 
* @author LIPENG
* @date 2016年3月2日 上午11:30:56 
*
 */
public class HospitalPatientBriefInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long patientId;
	private Integer hospitalId;
	private String patientNo;
	private Integer syncFlag=0;
	private Integer sourceFlag;
	private Date lastestFollowupResultSyncTime;
	private Date createTime;
	/** 
	* @return hospitalId 
	*/
	public Integer getHospitalId() {
		return hospitalId;
	}
	/** 
	* @param hospitalId 要设置的 hospitalId 
	*/
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	/** 
	* @return patientId 
	*/
	public Long getPatientId() {
		return patientId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Date getLastestFollowupResultSyncTime() {
		return lastestFollowupResultSyncTime;
	}
	public void setLastestFollowupResultSyncTime(Date lastestFollowupResultSyncTime) {
		this.lastestFollowupResultSyncTime = lastestFollowupResultSyncTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** 
	* @param patientId 要设置的 patientId 
	*/
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	/** 
	* @return patientNo 
	*/
	public String getPatientNo() {
		return patientNo;
	}
	/** 
	* @param patientNo 要设置的 patientNo 
	*/
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
}
