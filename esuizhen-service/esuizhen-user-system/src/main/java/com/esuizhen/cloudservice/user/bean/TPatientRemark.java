/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>TPatientRemark.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月19日上午10:09:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

/** 
* @ClassName: TPatientRemark
* @Description: 
* @author lichenghao
* @date 2016年5月19日 上午10:09:10  
*/
public class TPatientRemark {
	//备注编号
	private Integer remarkId;
	//医生编号
	private Long doctorId;
	//患者编号
	private Long patientId;
	//备注信息
	private String remark;
	//创建时间
	private Date createTime;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
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
	public Integer getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}
}
