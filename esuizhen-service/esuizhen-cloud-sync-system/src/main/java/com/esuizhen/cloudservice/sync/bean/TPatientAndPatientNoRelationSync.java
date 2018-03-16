/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.bean;<br/>  
 * <b>文件名：</b>TPatientAndPatientNoRelationSync.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年12月20日下午2:34:24<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.bean;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.westangel.common.bean.TPatientAndPatientNoRelation;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: TPatientAndPatientNoRelationSync
* @Description: 
* @author lichenghao
* @date 2016年12月20日 下午2:34:24  
*/
public class TPatientAndPatientNoRelationSync {
	private String uuid;
	private Long patientId;
	private String patientNo;
	private String newPatientNo;
	private Integer type;
	private Integer flag;
	private Integer hospitalId;
	private Date createTime;
	private Date updateTime;
	private Integer syncFlag;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public TPatientAndPatientNoRelation createPatientPatientNo() {
		// TODO Auto-generated method stub
		TPatientAndPatientNoRelation patientPatientNoRelation = new TPatientAndPatientNoRelation();
		BeanUtils.copyProperties(this, patientPatientNoRelation);
		patientPatientNoRelation.setSyncFlag(Constant.SYNC_OK);
		return patientPatientNoRelation;
	}
}
