/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.model.server;<br/>  
 * <b>文件名：</b>RHospitalPatient.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月23日下午7:00:58<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.model.server;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.esuizhen.server.sync.model.temp.SyncPatient;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: RHospitalPatient
* @Description: 
* @author lichenghao
* @date 2017年3月23日 下午7:00:58  
*/
public class RHospitalPatient {
	private Long patientId;
	private Integer hospitalId;
	private String patientNo;
	private int sourceFlag= Constant.User.USERSOURCEFLAG_HOSPITAIL;
	private Date lastestFollowupResultSyncTime;
	private int hospitalCertificateState=0;
	private Date createTime;
	private String patientUuid;
	private Date inhospitalDate;
	private Date certificateTime;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public int getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(int sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Date getLastestFollowupResultSyncTime() {
		return lastestFollowupResultSyncTime;
	}
	public void setLastestFollowupResultSyncTime(Date lastestFollowupResultSyncTime) {
		this.lastestFollowupResultSyncTime = lastestFollowupResultSyncTime;
	}
	public int getHospitalCertificateState() {
		return hospitalCertificateState;
	}
	public void setHospitalCertificateState(int hospitalCertificateState) {
		this.hospitalCertificateState = hospitalCertificateState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public Date getInhospitalDate() {
		return inhospitalDate;
	}
	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}
	public Date getCertificateTime() {
		return certificateTime;
	}
	public void setCertificateTime(Date certificateTime) {
		this.certificateTime = certificateTime;
	}
	//创建实体
	public static RHospitalPatient create(SyncPatient tempPatient){
		RHospitalPatient rHospitalPatient = new RHospitalPatient();
		BeanUtils.copyProperties(tempPatient, rHospitalPatient);
		return rHospitalPatient;
	}
}
