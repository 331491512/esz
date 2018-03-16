/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>FollowupSurvivalRateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月13日上午9:14:20<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: FollowupSurvivalRateReq
* @Description: 
* @author lichenghao
* @date 2016年8月13日 上午9:14:20  
*/
public class FollowupSurvivalRateFinalReq {
	private Integer searchId;
	private Integer conditionId;
	private String searchTableName;
	private String searchColumn;
	private Integer staticType;
	private Long doctorId;
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * 治疗方式统计结果。1-治疗方式单项统计，2-术放化组合统计
	 */
	private Integer treatmentTypeStatisticsResult;
	public Integer getSearchId() {
		return searchId;
	}
	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public String getSearchTableName() {
		return searchTableName;
	}
	public void setSearchTableName(String searchTableName) {
		this.searchTableName = searchTableName;
	}
	public String getSearchColumn() {
		return searchColumn;
	}
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}
	public Integer getStaticType() {
		return staticType;
	}
	public void setStaticType(Integer staticType) {
		this.staticType = staticType;
	}
	public Integer getTreatmentTypeStatisticsResult() {
		return treatmentTypeStatisticsResult;
	}
	public void setTreatmentTypeStatisticsResult(
			Integer treatmentTypeStatisticsResult) {
		this.treatmentTypeStatisticsResult = treatmentTypeStatisticsResult;
	}
}
