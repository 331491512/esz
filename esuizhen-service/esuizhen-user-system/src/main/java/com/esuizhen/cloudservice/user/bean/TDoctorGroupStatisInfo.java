/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>TDoctorGroupStatisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月25日下午3:48:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: TDoctorGroupStatisInfo
* @Description: 
* @author lichenghao
* @date 2016年5月25日 下午3:48:45  
*/
public class TDoctorGroupStatisInfo {
	//患者病种总数
	private Integer disease;
	//自定义分组数
	private Integer custom;
	//mdt患者数
	private Integer mdt;
	//特殊关注患者总数
	private Integer doctorFocus;
	//患者状态分组
	private Integer inhospital;
	public Integer getDisease() {
		return disease;
	}
	public void setDisease(Integer disease) {
		this.disease = disease;
	}
	public Integer getCustom() {
		return custom;
	}
	public void setCustom(Integer custom) {
		this.custom = custom;
	}
	public Integer getMdt() {
		return mdt;
	}
	public void setMdt(Integer mdt) {
		this.mdt = mdt;
	}
	public Integer getDoctorFocus() {
		return doctorFocus;
	}
	public void setDoctorFocus(Integer doctorFocus) {
		this.doctorFocus = doctorFocus;
	}
	public Integer getInhospital() {
		return inhospital;
	}
	public void setInhospital(Integer inhospital) {
		this.inhospital = inhospital;
	}
}
