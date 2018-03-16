 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>TaskPatientSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:44:41<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: TaskPatientSpread
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:44:41 
*/
public class TaskPatientSpread {
	/**
	 * 任务中患者总数
	 */
	private Integer taskPatient;
	/**
	 * 有效随访数
	 */
	private Integer effectiveFollowup;
	/**
	 * 无效随访数
	 */
	private Integer invalidFollowup;
	/**
	 * 无随访结果患者
	 */
	private Integer notFollowup;
	
	public Integer getTaskPatient() {
		return taskPatient;
	}
	public void setTaskPatient(Integer taskPatient) {
		this.taskPatient = taskPatient;
	}
	public Integer getEffectiveFollowup() {
		return effectiveFollowup;
	}
	public void setEffectiveFollowup(Integer effectiveFollowup) {
		this.effectiveFollowup = effectiveFollowup;
	}
	public Integer getInvalidFollowup() {
		return invalidFollowup;
	}
	public void setInvalidFollowup(Integer invalidFollowup) {
		this.invalidFollowup = invalidFollowup;
	}
	public Integer getNotFollowup() {
		return notFollowup;
	}
	public void setNotFollowup(Integer notFollowup) {
		this.notFollowup = notFollowup;
	}

}
