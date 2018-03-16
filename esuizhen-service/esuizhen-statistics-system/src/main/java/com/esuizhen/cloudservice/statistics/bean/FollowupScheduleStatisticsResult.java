 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>FollowupScheduleStatisticsResult.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:20:40<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: FollowupScheduleStatisticsResult
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:20:40 
*/
public class FollowupScheduleStatisticsResult {
	/**
	 * 应随访总数
	 */
	private Integer shouldFollowupCount;
	/**
	 * 已随访数
	 */
	private Integer alreadyFollowupCount;
	/**
	 * 暂存
	 */
	private Integer tempSaveCount;
	/**
	 * 未随访数
	 */
	private Integer notFollowupCount;
	/**
	 * 生存状态统计
	 */
	private SurvivalStateSpread survivalState;
	/**
	 * 随访方式分布
	 */
	private FollowupWaySpread followupWay;
	/**
	 * 无效随访原因统计
	 */
	private InvalidFollowupReasonsSpread invalidFollowupReasons;
	
	
	public Integer getShouldFollowupCount() {
		return shouldFollowupCount;
	}
	public void setShouldFollowupCount(Integer shouldFollowupCount) {
		this.shouldFollowupCount = shouldFollowupCount;
	}
	public Integer getAlreadyFollowupCount() {
		return alreadyFollowupCount;
	}
	public void setAlreadyFollowupCount(Integer alreadyFollowupCount) {
		this.alreadyFollowupCount = alreadyFollowupCount;
	}
	public Integer getNotFollowupCount() {
		return notFollowupCount;
	}
	public void setNotFollowupCount(Integer notFollowupCount) {
		this.notFollowupCount = notFollowupCount;
	}
	public SurvivalStateSpread getSurvivalState() {
		return survivalState;
	}
	public void setSurvivalState(SurvivalStateSpread survivalState) {
		this.survivalState = survivalState;
	}
	public FollowupWaySpread getFollowupWay() {
		return followupWay;
	}
	public void setFollowupWay(FollowupWaySpread followupWay) {
		this.followupWay = followupWay;
	}
	public InvalidFollowupReasonsSpread getInvalidFollowupReasons() {
		return invalidFollowupReasons;
	}
	public void setInvalidFollowupReasons(InvalidFollowupReasonsSpread invalidFollowupReasons) {
		this.invalidFollowupReasons = invalidFollowupReasons;
	}
	
}
