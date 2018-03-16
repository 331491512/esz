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
public class PatientRemarkListReq {
	//医生编号
	private Long doctorId;
	//患者编号
	private Long patientId;
	
	//分页索引
	private int page;
	
	//每页数量
	private int num;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
