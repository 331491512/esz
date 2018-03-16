/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.daily;<br/>  
 * <b>文件名：</b>DailyInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年2月4日下午5:49:28<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.daily;

import java.util.Date;

/** 
* @ClassName: DailyInfo
* @Description: 
* @author lichenghao
* @date 2016年2月4日 下午5:49:28  
*/
public class DailyInfo {
	
	//医生编号
	private Long doctorId;
	//医生userId
	private Long userId;
	//随访结果总数
	private Integer resultnum;
	//新增患者总数
	private Integer countnum;
	//激活患者总数
	private Integer activation;
	//未激活患者总数
	private Integer unactivation;
	//标题日期
	private String titleDate;
	//版本
	private String appVersion;
	
	//日报日期
	private Date dailyDate;
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getResultnum() {
		return resultnum;
	}
	public void setResultnum(Integer resultnum) {
		this.resultnum = resultnum;
	}
	public Integer getCountnum() {
		return countnum;
	}
	public void setCountnum(Integer countnum) {
		this.countnum = countnum;
	}
	public Integer getActivation() {
		return activation;
	}
	public void setActivation(Integer activation) {
		this.activation = activation;
	}
	public Integer getUnactivation() {
		return unactivation;
	}
	public void setUnactivation(Integer unactivation) {
		this.unactivation = unactivation;
	}
	public String getTitleDate() {
		return titleDate;
	}
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public Date getDailyDate() {
		return dailyDate;
	}
	public void setDailyDate(Date dailyDate) {
		this.dailyDate = dailyDate;
	}
}
