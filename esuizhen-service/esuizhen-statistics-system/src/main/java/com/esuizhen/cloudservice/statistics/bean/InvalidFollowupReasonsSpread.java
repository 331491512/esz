 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>InvalidFollowupReasonsSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:35:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: InvalidFollowupReasonsSpread
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:35:02 
*/
public class InvalidFollowupReasonsSpread {
	/**
	 * 无人接听
	 */
	private Integer noOneHeardCount;
	/**
	 * 拒绝随访
	 */
	private Integer refusedFollowupCount;
	/**
	 * 主动拒接
	 */
	private Integer rejectPhoneCount;
	/**
	 * 关机
	 */
	private Integer shutdownCount;
	/**
	 * 空号
	 */
	private Integer spaceNumCount;
	/**
	 * 停机
	 */
	private Integer suspendedCount;
	/**
	 * 无法接通
	 */
	private Integer notAvailableCount;
	/**
	 * 错号
	 */
	private Integer wrongNumCount;
	/**
	 * 未知
	 */
	private Integer unKnowCount;
	
	public Integer getNoOneHeardCount() {
		return noOneHeardCount;
	}
	public void setNoOneHeardCount(Integer noOneHeardCount) {
		this.noOneHeardCount = noOneHeardCount;
	}
	public Integer getRefusedFollowupCount() {
		return refusedFollowupCount;
	}
	public void setRefusedFollowupCount(Integer refusedFollowupCount) {
		this.refusedFollowupCount = refusedFollowupCount;
	}
	public Integer getRejectPhoneCount() {
		return rejectPhoneCount;
	}
	public void setRejectPhoneCount(Integer rejectPhoneCount) {
		this.rejectPhoneCount = rejectPhoneCount;
	}
	public Integer getShutdownCount() {
		return shutdownCount;
	}
	public void setShutdownCount(Integer shutdownCount) {
		this.shutdownCount = shutdownCount;
	}
	public Integer getSpaceNumCount() {
		return spaceNumCount;
	}
	public void setSpaceNumCount(Integer spaceNumCount) {
		this.spaceNumCount = spaceNumCount;
	}
	public Integer getSuspendedCount() {
		return suspendedCount;
	}
	public void setSuspendedCount(Integer suspendedCount) {
		this.suspendedCount = suspendedCount;
	}
	public Integer getNotAvailableCount() {
		return notAvailableCount;
	}
	public void setNotAvailableCount(Integer notAvailableCount) {
		this.notAvailableCount = notAvailableCount;
	}
	public Integer getWrongNumCount() {
		return wrongNumCount;
	}
	public void setWrongNumCount(Integer wrongNumCount) {
		this.wrongNumCount = wrongNumCount;
	}
	public Integer getUnKnowCount() {
		return unKnowCount;
	}
	public void setUnKnowCount(Integer unKnowCount) {
		this.unKnowCount = unKnowCount;
	}

}
