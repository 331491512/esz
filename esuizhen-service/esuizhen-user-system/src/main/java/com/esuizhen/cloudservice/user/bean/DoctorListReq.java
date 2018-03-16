/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>DoctorSearchByCombinedConditionReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月7日上午10:02:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

public class DoctorListReq {
	
	private Integer hospitalId=null;
	
	private Long doctorId;
	
	private String trueName;
	
	private Integer reqFlag;

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getReqFlag() {
		return reqFlag;
	}

	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	
}
