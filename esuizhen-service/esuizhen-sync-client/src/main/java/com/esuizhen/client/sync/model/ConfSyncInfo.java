/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.model;<br/>  
 * <b>文件名：</b>ConfSyncInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月18日下午6:15:32<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.model;

import com.esuizhen.client.sync.common.ConstantClient;

/** 
* @ClassName: ConfSyncInfo
* @Description: 
* @author lichenghao
* @date 2017年3月18日 下午6:15:32  
*/
public class ConfSyncInfo {
	private Integer hospitalId;
	private String serverApiUrl;
	private Integer ctlFlag;//控制总开关
	private Integer ctlPushFlag;//推送开关
	private Integer ctlGetFlag;//拉取开关
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getServerApiUrl() {
		return serverApiUrl;
	}
	public void setServerApiUrl(String serverApiUrl) {
		this.serverApiUrl = serverApiUrl;
	}
	public Integer getCtlFlag() {
		return ctlFlag;
	}
	public void setCtlFlag(Integer ctlFlag) {
		this.ctlFlag = ctlFlag;
	}
	
	public Integer getCtlPushFlag() {
		return ctlPushFlag;
	}
	public void setCtlPushFlag(Integer ctlPushFlag) {
		this.ctlPushFlag = ctlPushFlag;
	}
	public Integer getCtlGetFlag() {
		return ctlGetFlag;
	}
	public void setCtlGetFlag(Integer ctlGetFlag) {
		this.ctlGetFlag = ctlGetFlag;
	}
	public void initParams(){
		ConstantClient.serverApiUrl=this.serverApiUrl;
		ConstantClient.hospitalId = this.hospitalId;
		ConstantClient.ctlFlag=this.ctlFlag;
		ConstantClient.ctlPushFlag=this.ctlPushFlag;
		ConstantClient.ctlGetFlag=this.ctlGetFlag;
	}
}
