/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TDoctorInvitation.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月16日下午4:22:24<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

/**
 * @ClassName: TDoctorInvitation
 * @Description: 医生邀请患者上传病历\开启随访计划\关注微信等
 * @author fanpanwei
 * @date 2017年03月16日 下午4:22:24
 */
public class TDoctorInvitation {
	
	//医生编号
	private Long doctorId;
	
	//医生姓名
	private String doctorName;
	
	//医院名称
	private String hospitalName;
	
	//邀请类型
	private int inviteType;
	
	//患者数组
	private Integer[] patients;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getInviteType() {
		return inviteType;
	}

	public void setInviteType(int inviteType) {
		this.inviteType = inviteType;
	}

	public Integer[] getPatients() {
		return patients;
	}

	public void setPatients(Integer[] patients) {
		this.patients = patients;
	}

}
