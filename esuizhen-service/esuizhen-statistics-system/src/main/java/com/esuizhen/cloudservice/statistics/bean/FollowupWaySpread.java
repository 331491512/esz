 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>FollowupWaySpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:32:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;
 
/** 
* @ClassName: FollowupWaySpread
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:32:33 
*/
public class FollowupWaySpread {
	/**
	 * 电话随访数
	 */
	private Integer phoneFollowupCount;
	/**
	 * 微信随访数
	 */
	private Integer wexinFollowupCount;
	/**
	 * 短信随访数
	 */
	private Integer smsFollowupCount;
	/**
	 * 门诊/住院随访（采集）数
	 */
	private Integer outpatientFollowupCount;
	/**
	 * 其他随访数
	 */
	private Integer otherFollowupCount;
	
	public Integer getPhoneFollowupCount() {
		return phoneFollowupCount;
	}
	public void setPhoneFollowupCount(Integer phoneFollowupCount) {
		this.phoneFollowupCount = phoneFollowupCount;
	}
	public Integer getWexinFollowupCount() {
		return wexinFollowupCount;
	}
	public void setWexinFollowupCount(Integer wexinFollowupCount) {
		this.wexinFollowupCount = wexinFollowupCount;
	}
	public Integer getSmsFollowupCount() {
		return smsFollowupCount;
	}
	public void setSmsFollowupCount(Integer smsFollowupCount) {
		this.smsFollowupCount = smsFollowupCount;
	}
	public Integer getOutpatientFollowupCount() {
		return outpatientFollowupCount;
	}
	public void setOutpatientFollowupCount(Integer outpatientFollowupCount) {
		this.outpatientFollowupCount = outpatientFollowupCount;
	}
	public Integer getOtherFollowupCount() {
		return otherFollowupCount;
	}
	public void setOtherFollowupCount(Integer otherFollowupCount) {
		this.otherFollowupCount = otherFollowupCount;
	}

}
