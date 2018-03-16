/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.daily;<br/>  
 * <b>文件名：</b>FollowupDailyStatisResultQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年2月4日下午3:03:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.daily;
/** 
* @ClassName: FollowupDailyStatisResultQueryReq
* @Description: 
* @author lichenghao
* @date 2016年2月4日 下午3:03:19  
*/
public class FollowupDailyStatisResultQueryReq {
	//医生编号
	private Long doctorId;
	//日报日期
	private String dailyDate;
	//日报类型
	private String dataType;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDailyDate() {
		return dailyDate;
	}
	public void setDailyDate(String dailyDate) {
		this.dailyDate = dailyDate;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
