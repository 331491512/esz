/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.bean;<br/>  
 * <b>文件名：</b>TAppVersion.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日上午11:58:00<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.bean;
/** 
* @ClassName: TAppVersion
* @Description: 
* @author lichenghao
* @date 2015年12月17日 上午11:58:00  
*/
public class TAppVersion {
	
	//更改状态 0 无需更新  1新版本可以升级  2新版本必须升级
	private Integer update;
	//版本号
	private String version;
	//公共版本号
	private Integer versionCode;
	//app地址
	private String url;
	//更新说明
	private String desc;
	//业务编号
	private String businessId;
	//产品编号
	private String productId;
	//设备类型  3 android 4 ios
	private Integer deviceType;
	public Integer getUpdate() {
		return update;
	}
	public void setUpdate(Integer update) {
		this.update = update;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}
}
