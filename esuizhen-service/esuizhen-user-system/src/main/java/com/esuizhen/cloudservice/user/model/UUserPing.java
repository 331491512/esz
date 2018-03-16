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
 * <p>Title: UUserPing</p>
 * <p>Description: 临时用户bean</p>
 * @author YYCHEN
 * @date 2016年4月19日 下午6:34:03
 */
public class UUserPing implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Long id;
	//设备标识码
	private String luid;
	//用户角色
	private Integer role;
	//用户ID
	private Long userId;
	//产品线Id.
	private Integer businessId;
	//产品Id
	private Integer productId;
	//
	private String deviceId;
	//
	private Integer deviceType;
	//手机系统+版本号
	private String platform;
	//App版本号
	private String appVersion;
	//IP地址
	private String ipAddress;
	//地理位置
	private String location;
	//使用时长
	private Long usageDuration;
	//本周期使用开始时间
	private Date beginTime;
	//本周期使用结束时间
	private Date endTime;
	//上传日期
	private Date uploadTime;
	//创建时间
	private Date createTime;
	
	//页面地址
	private String pageUrl;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLuid() {
		return luid;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getUsageDuration() {
		return usageDuration;
	}
	public void setUsageDuration(Long usageDuration) {
		this.usageDuration = usageDuration;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
}
