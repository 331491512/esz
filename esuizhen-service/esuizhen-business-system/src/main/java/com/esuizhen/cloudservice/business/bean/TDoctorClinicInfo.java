/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TDoctorClinicInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月14日下午3:52:07<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.List;


/** 
* @ClassName: TDoctorClinicInfo.java
* @Description: 
* @author lichenghao
* @date 2015年12月14日 下午3:52:07  
*/
public class TDoctorClinicInfo {
	
	//门诊说明
	private String introduction;
	//更新时间
	private String updateTime;
	//出诊时间集合
	private List<TDoctorClinicScheduleInfo> dataList;
	
	public List<TDoctorClinicScheduleInfo> getDataList() {
		return dataList;
	}
	public void setDataList(List<TDoctorClinicScheduleInfo> dataList) {
		this.dataList = dataList;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
