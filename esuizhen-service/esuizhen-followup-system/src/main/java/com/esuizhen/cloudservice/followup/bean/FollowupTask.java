/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupTask.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月14日上午10:38:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: FollowupTask
* @Description: 
* @author lichenghao
* @date 2016年9月14日 上午10:38:29  
*/
public class FollowupTask {
	//随访任务ID
	private String followupTaskId;
	//随访任务名称
	private String followupTaskName;
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
	public String getFollowupTaskName() {
		return followupTaskName;
	}
	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}
}
