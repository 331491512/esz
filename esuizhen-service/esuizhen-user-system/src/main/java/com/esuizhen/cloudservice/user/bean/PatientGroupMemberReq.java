/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>PatientGroupMemberReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月23日上午11:00:05<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;

import java.util.List;

/** 
* @ClassName: PatientGroupMemberReq
* @Description: 
* @author lichenghao
* @date 2016年5月23日 上午11:00:05  
*/
public class PatientGroupMemberReq {
	//患者Id
	private Long patientId;
	
	//医生编号
	private Long doctorId;
	
	//分组集合
	private List<String> groupNos;
	
	//单个分组
	private String groupNo;
	
	//患者集合
	private List<Long> patients;
	
	//分组类型
	private Integer groupWay;
	
	//关注操作
	private Integer focusFlag;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public List<String> getGroupNos() {
		return groupNos;
	}

	public void setGroupNos(List<String> groupNos) {
		this.groupNos = groupNos;
	}

	public List<Long> getPatients() {
		return patients;
	}

	public void setPatients(List<Long> patients) {
		this.patients = patients;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Integer getGroupWay() {
		return groupWay;
	}

	public void setGroupWay(Integer groupWay) {
		this.groupWay = groupWay;
	}

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}
}
