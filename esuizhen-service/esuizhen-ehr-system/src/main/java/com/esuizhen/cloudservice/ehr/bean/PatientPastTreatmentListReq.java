/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientPastTreatmentListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午3:22:36<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: PatientPastTreatmentListReq
* @Description: 
* @author lichenghao
* @date 2016年5月24日 下午3:22:36  
*/
public class PatientPastTreatmentListReq {
	//患者编号
	private Long patientId;
	//页面索引
	private int page;
	//每页数量
	private int num;
	/**
	 * 治疗用药
	 */
	private String medicine;
	/**
	 * 页面标示.1-主诊卡汇总,2-防癌办-治疗与用药
	 */
	private Integer pageFlag;
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
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public Integer getPageFlag() {
		return pageFlag;
	}
	public void setPageFlag(Integer pageFlag) {
		this.pageFlag = pageFlag;
	}
}
