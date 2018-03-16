/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>DoctorClinicScheduleSetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月28日下午3:56:22<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.List;

/** 
* @ClassName: DoctorClinicScheduleSetReq
* @Description: 
* @author lichenghao
* @date 2015年12月28日 下午3:56:22  
*/
public class DoctorClinicScheduleSetReq {
	//医生编号
	private Long doctorId;
	//门诊信息
	private String introduction;
	//出诊安排列表
	private List<TDoctorClinicScheduleInfo> clinicScheduleList;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public List<TDoctorClinicScheduleInfo> getClinicScheduleList() {
		return clinicScheduleList;
	}
	public void setClinicScheduleList(List<TDoctorClinicScheduleInfo> clinicScheduleList) {
		this.clinicScheduleList = clinicScheduleList;
	}
}
