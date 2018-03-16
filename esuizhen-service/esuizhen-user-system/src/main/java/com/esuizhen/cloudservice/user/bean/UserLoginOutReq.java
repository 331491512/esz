/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>UserLoginOutReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午9:31:18<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: UserLoginOutReq
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午9:31:18  
*/
public class UserLoginOutReq {
	//用户登录号
	private Long userId;
	//设备编号
	private String deviceId;
	//设备类型。3:安卓；4:iOS
	private int deviceType;
	//用户唯一标识码
	private String uuid;
	//用户设备标识码
	private String luid;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLuid() {
		return luid;
	}
	public void setLuid(String luid) {
		this.luid = luid;
	}
}
