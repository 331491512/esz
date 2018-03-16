/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.conf<br/>  
 * <b>文件名：</b>TFollowupLocalProfile.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日上午11:38:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.conf;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TFollowupLocalProfile
* @Description: (随访人员)本机配置类
* @author NiDan
* @date 2016年8月10日上午11:38:44 
*/
public class TFollowupLocalProfile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7755004706955190077L;

	/**
	 * 本机配置id
	 */
	private Integer id;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 设备码
	 */
	private String deviceCode;
	
	/**
	 * 本机号码
	 */
	private String localPhoneNumber;
	
	/**
	 * 是否外呼鉴权 1：是；0：否（默认）
	 */
	private Integer isOutsideCallAuth;
	
	/**
	 * 是否IP拨号 1：是；0：否（默认）
	 */
	private Integer isIpCall;
	
	/**
	 * 电话录音路径
	 */
	private String voiceRecordPath;
	
	/**
	 * 语音盒标识。1：语音盒（需要麦克风）；2：电话（通过电话+语音盒）
	 */
	private Integer voiceBoxFlag;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 外呼鉴权号码。如0或9'
	 */
	private String outsideCallNum;
	
	/**
	 * IP号码
	 */
	private String ipCallNum;

	public TFollowupLocalProfile() {
		
	}

	public TFollowupLocalProfile(Integer id, Long userId, String deviceCode,
			String localPhoneNumber, Integer isOutsideCallAuth,
			Integer isIpCall, String voiceRecordPath, Integer voiceBoxFlag,
			Date createTime, Date updateTime, String outsideCallNum,
			String ipCallNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.deviceCode = deviceCode;
		this.localPhoneNumber = localPhoneNumber;
		this.isOutsideCallAuth = isOutsideCallAuth;
		this.isIpCall = isIpCall;
		this.voiceRecordPath = voiceRecordPath;
		this.voiceBoxFlag = voiceBoxFlag;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.outsideCallNum = outsideCallNum;
		this.ipCallNum = ipCallNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getLocalPhoneNumber() {
		return localPhoneNumber;
	}

	public void setLocalPhoneNumber(String localPhoneNumber) {
		this.localPhoneNumber = localPhoneNumber;
	}

	public Integer getIsOutsideCallAuth() {
		return isOutsideCallAuth;
	}

	public void setIsOutsideCallAuth(Integer isOutsideCallAuth) {
		this.isOutsideCallAuth = isOutsideCallAuth;
	}

	public Integer getIsIpCall() {
		return isIpCall;
	}

	public void setIsIpCall(Integer isIpCall) {
		this.isIpCall = isIpCall;
	}

	public String getVoiceRecordPath() {
		return voiceRecordPath;
	}

	public void setVoiceRecordPath(String voiceRecordPath) {
		this.voiceRecordPath = voiceRecordPath;
	}

	public Integer getVoiceBoxFlag() {
		return voiceBoxFlag;
	}

	public void setVoiceBoxFlag(Integer voiceBoxFlag) {
		this.voiceBoxFlag = voiceBoxFlag;
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

	public String getOutsideCallNum() {
		return outsideCallNum;
	}

	public void setOutsideCallNum(String outsideCallNum) {
		this.outsideCallNum = outsideCallNum;
	}

	public String getIpCallNum() {
		return ipCallNum;
	}

	public void setIpCallNum(String ipCallNum) {
		this.ipCallNum = ipCallNum;
	}
	
	

}
