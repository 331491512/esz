/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TOutHospitalInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日下午4:05:12<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: TOutHospitalInfo
* @Description: 
* @author lichenghao
* @date 2016年5月2日 下午4:05:12  
*/
public class TOutHospitalInfo {
	//出院时间
	private String outHospitalDate;
	private String inhospitalId;

	public String getOutHospitalDate() {
		return outHospitalDate;
	}

	public void setOutHospitalDate(String outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
}
