 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>FollowupPatientStatisticsResult.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:23:58<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: FollowupPatientStatisticsResult
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:23:58 
*/
public class FollowupPatientStatisticsResult {
	/**
	 * 肿瘤患者数统计
	 */
	private TumorPatientSpread tumorPatient;
	/**
	 * 任务中患者数统计
	 */
	private TaskPatientSpread taskPatient;
	
	public TumorPatientSpread getTumorPatient() {
		return tumorPatient;
	}
	public void setTumorPatient(TumorPatientSpread tumorPatient) {
		this.tumorPatient = tumorPatient;
	}
	public TaskPatientSpread getTaskPatient() {
		return taskPatient;
	}
	public void setTaskPatient(TaskPatientSpread taskPatient) {
		this.taskPatient = taskPatient;
	}

}
