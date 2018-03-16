/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean.yiyao;<br/>  
 * <b>文件名：</b>LoginResp.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月14日下午4:44:56<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.thirdparty.bean.yiyao;
/** 
* @ClassName: LoginResp
* @Description: 
* @author lichenghao
* @date 2016年7月14日 下午4:44:56  
*/
public class LoginResp {
	//益药分配给合作方的用户名
	private String appId;
	//签名
	private String siganature;
	//时间戳
	private String timestamp;
	//请求数据
	private String data;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getSiganature() {
		return siganature;
	}
	public void setSiganature(String siganature) {
		this.siganature = siganature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
