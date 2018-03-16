/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>FollowupSurvivalReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午3:26:01<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.Date;

/** 
* @ClassName: FollowupSurvivalReq
* @Description: 
* @author lichenghao
* @date 2016年8月12日 下午3:26:01  
*/
public class FollowupSurvivalRatePreSubReq {
	
	//起始随访日期
	private Date followupDateStart;
	//截止随访日期
	private Date followupDateEnd;
	public Date getFollowupDateStart() {
		return followupDateStart;
	}
	public void setFollowupDateStart(Date followupDateStart) {
		this.followupDateStart = followupDateStart;
	}
	public Date getFollowupDateEnd() {
		return followupDateEnd;
	}
	public void setFollowupDateEnd(Date followupDateEnd) {
		this.followupDateEnd = followupDateEnd;
	}
}
