/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DeviceInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:54:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: DeviceInfo 
* @Description: 用户使用的设备信息
* @author YYCHEN
* @date 2015年12月3日 上午11:54:01  
*/
public class UUserDevice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//设备标识码
	private String luid;
	//用户角色
	private Integer role;
	//设备ID
	private String deviceId;
	//设备类型
	private Integer deviceType;
	//产品线Id
	private Integer bussinessId;
	//产品Id
	private Integer productId;
	//用户ID
	private Long userId;
	//手机厂商
	private Integer phoneVendorId;
	//手机品牌
	private String phoneBrand;
	//手机系统+版本号
	private String platform;
	//App版本号
	private String appVersion;
	//内部版本号
	private Integer versionCode;
	//地理位置
	private String location;
	//运营商网络SIM卡集成电路识别码
	private String iccid;
	//IMEI
	private String imei;
	//IMSI
	private String imsi;
	//IP地址
	private String ipAddress;
	//MAC地址
	private String macAddress;
	//邀请码
	private String invitationCode;
	//创建日期
	private Date createTime;
	//更新日期
	private Date updateTime;
	//操作标识
	private Integer opFlag;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLuid() {
		return luid;
	}
	public void setLuid(String luid) {
		this.luid = luid;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(Integer bussinessId) {
		this.bussinessId = bussinessId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getPhoneVendorId() {
		return phoneVendorId;
	}
	public void setPhoneVendorId(Integer phoneVendorId) {
		this.phoneVendorId = phoneVendorId;
	}
	public String getPhoneBrand() {
		return phoneBrand;
	}
	public void setPhoneBrand(String phoneBrand) {
		this.phoneBrand = phoneBrand;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public Integer getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getOpFlag() {
		return opFlag;
	}
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}
}
