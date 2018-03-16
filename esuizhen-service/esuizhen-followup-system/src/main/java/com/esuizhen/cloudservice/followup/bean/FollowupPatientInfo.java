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
public class FollowupPatientInfo {
	private Long patientId;
	private String mobile;
	private String trueName;
	private String openId;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
