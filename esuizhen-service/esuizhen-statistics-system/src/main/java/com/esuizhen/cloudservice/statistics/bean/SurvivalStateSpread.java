 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>SurvivalStateSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:29:13<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: SurvivalStateSpread
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:29:13 
*/
public class SurvivalStateSpread {
	/**
	 * 死亡数
	 */
	private Integer deathFollowupCount;
	/**
	 * 生存数
	 */
	private Integer surviveFollowupCount;
	/**
	 * 无效随访数
	 */
	private Integer invalidFollowupCount;
	/**
	 * 失访数
	 */
	private Integer lostFollowupCount;
	
	
	//add by fanpanwei
	private Integer everLostFollowupCount;
	private Integer everDeathCount;
	private Integer alreadyAllotTask;
	private Integer notAllotTask;
	
	public Integer getDeathFollowupCount() {
		return deathFollowupCount;
	}
	public void setDeathFollowupCount(Integer deathFollowupCount) {
		this.deathFollowupCount = deathFollowupCount;
	}
	public Integer getSurviveFollowupCount() {
		return surviveFollowupCount;
	}
	public void setSurviveFollowupCount(Integer surviveFollowupCount) {
		this.surviveFollowupCount = surviveFollowupCount;
	}
	public Integer getInvalidFollowupCount() {
		return invalidFollowupCount;
	}
	public void setInvalidFollowupCount(Integer invalidFollowupCount) {
		this.invalidFollowupCount = invalidFollowupCount;
	}
	public Integer getLostFollowupCount() {
		return lostFollowupCount;
	}
	public void setLostFollowupCount(Integer lostFollowupCount) {
		this.lostFollowupCount = lostFollowupCount;
	}
	public Integer getEverLostFollowupCount() {
		return everLostFollowupCount;
	}
	public void setEverLostFollowupCount(Integer everLostFollowupCount) {
		this.everLostFollowupCount = everLostFollowupCount;
	}
	public Integer getAlreadyAllotTask() {
		return alreadyAllotTask;
	}
	public void setAlreadyAllotTask(Integer alreadyAllotTask) {
		this.alreadyAllotTask = alreadyAllotTask;
	}
	public Integer getNotAllotTask() {
		return notAllotTask;
	}
	public void setNotAllotTask(Integer notAllotTask) {
		this.notAllotTask = notAllotTask;
	}
}
