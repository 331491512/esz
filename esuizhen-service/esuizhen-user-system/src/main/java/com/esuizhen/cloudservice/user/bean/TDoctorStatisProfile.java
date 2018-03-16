/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>TDoctorStatisProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月25日下午3:48:04<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: TDoctorStatisProfile
* @Description: 
* @author lichenghao
* @date 2016年5月25日 下午3:48:04  
*/
public class TDoctorStatisProfile {
	//患者总数
	private Integer totalPatientNum;
	
	//院内患者总数
	private Integer hospitalPatientNum;
	
	//院外患者总数
	private Integer nonhospitalPatientNum;
	
	//患者分组信息统计
	private TDoctorGroupStatisInfo groupStaticInfo;

	public Integer getTotalPatientNum() {
		return totalPatientNum;
	}

	public void setTotalPatientNum(Integer totalPatientNum) {
		this.totalPatientNum = totalPatientNum;
	}

	public TDoctorGroupStatisInfo getGroupStaticInfo() {
		return groupStaticInfo;
	}

	public void setGroupStaticInfo(TDoctorGroupStatisInfo groupStaticInfo) {
		this.groupStaticInfo = groupStaticInfo;
	}

	public Integer getHospitalPatientNum() {
		return hospitalPatientNum;
	}

	public void setHospitalPatientNum(Integer hospitalPatientNum) {
		this.hospitalPatientNum = hospitalPatientNum;
	}

	public Integer getNonhospitalPatientNum() {
		return nonhospitalPatientNum;
	}

	public void setNonhospitalPatientNum(Integer nonhospitalPatientNum) {
		this.nonhospitalPatientNum = nonhospitalPatientNum;
	}
}
