/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientInHospitalNoteListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日上午11:20:30<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: PatientInHospitalNoteListReq
* @Description: 
* @author lichenghao
* @date 2017年1月6日 上午11:20:30  
*/
public class PatientInHospitalNoteListReq {
	private Long patientId;
	private int page=0;
	private int num=0;
	private Integer hospitalId;
	private Integer reqFlag;

	public Integer getReqFlag() {
		return reqFlag;
	}

	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}
