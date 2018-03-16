/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.push.model;<br/>  
 * <b>文件名：</b>PushHistory.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月9日下午12:33:22<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.push.model;

import java.util.Date;

import com.westangel.common.bean.push.PushNotifyInfo;

/** 
* @ClassName: PushHistory
* @Description: 
* @author lichenghao
* @date 2017年2月9日 下午12:33:22  
*/
public class PushHistory {
	private Integer businessId;
	private Integer productId;
	private Long userId;
	private Integer userRole;
	private String deviceToken;
	private Integer pushType;
	private String content;
	private Integer resultCode;
	private String resultMessage;
	private Date sendTime;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public Integer getPushType() {
		return pushType;
	}
	public void setPushType(Integer pushType) {
		this.pushType = pushType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	public static PushHistory createPushHistory(PushNotifyInfo notify,PushBindInfo bind){
		PushHistory history = new PushHistory();
		//notify
		history.setBusinessId(notify.getBusinessId());
		history.setProductId(notify.getProductId());
		history.setContent(notify.getContent());
		history.setPushType(notify.getPushType());
		history.setUserId(notify.getUserId());
		history.setUserRole(notify.getUserRole());
		//bind
		history.setDeviceToken(bind.getDeviceToken());
		history.setResultCode(0);
		return history;
	}
}
