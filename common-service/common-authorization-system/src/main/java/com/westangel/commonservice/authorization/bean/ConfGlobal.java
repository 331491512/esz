/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.search;<br/>  
 * <b>文件名：</b>ConfGlobal.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年9月5日下午4:31:19<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.authorization.bean;

import java.util.Date;

/** 
* @ClassName: ConfGlobal
* @Description: 
* @author lichenghao
* @date 2016年9月5日 下午4:31:19  
*/
public class ConfGlobal {
	/**
	 * 随访周期。单位：天 默认90
	 */
	private Integer followupCycle;
	
	/**
	 * 电话随访全局设置： 必须接通电话才能保存随访结果。 1：开启；0:否（默认）
	 */
	private Integer phoneResultMustConnectFlag;
		
	/**
	 * 随访结果统计全局设置. 将其他情况作为有效随访统计. 1：开启；0：关闭（默认）
	 */
	private Integer otherAsValidResultFlag;
	
	/**
	 * 自动补充病案号设置。 1：开启；0：关闭（默认）
	 */
	private Integer autoPatientNoPaddingFlag;
	
	/**
	 * 病案号位数
	 */
	private Integer autoPatientNoPaddingDigits;
	
	/**
	 * 无须处理非恶性肿瘤设置。 1:开启（默认）；0：关闭。
	 */
	private Integer cancerFilterFlag;
	
	/**
	 * 随访范围设置标识。
		NULL:  不设置。cancerFilterFlag开启（1）时。
		1：按疾病类型，此时看notMalignantTumorFlag取值；
		2: 按大病种（diseaseType）
		3：按ICD病种，此时看conf_followup_range_icd
	 */
	private Integer followupRangeFlag;
	
	/**
	 * 死亡患者时间死亡时间是否必填
	 */
	private Integer deathDateRequiredFlag;
	
	/**
	 * 自定义病种开关设置。 1：开启；0：关闭（默认）
	 */
	private Integer diseaseTypeSelfDefineFlag;
	
	/**
	 * 本医院的hospitalId
	 */
	private Integer hospitalId;
	
	/**
	 * 本医院名称
	 */
	private String hospitalName;
	
	/**
	 * 系统上线时间（正式对接数据并开展随访工作时间）
	 */
	private Date rolloutTime;
	
	/**
	 * 系统部署时间
	 */
	private Date deployTime;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否外呼鉴权 1：是；0：否（默认）
	 */
	private Integer isOutsideCallAuth;
	/**
	 * 外呼鉴权号码。如0或9
	 */
	private String outsideCallNum;
	/**
	 * 是否IP拨号 1：是；0：否（默认）
	 */
	private Integer isIpCall;
	/**
	 * IP号码。
	 */
	private String ipCallNum;
	
	private Integer rolloutMonth;
	
	/**
	 * 部署位置
	 */
	private Integer deployLocation;
	
	/**
	 * 无须处理非恶性肿瘤设置状态开关为关闭时，此处才会有值。（以逗号分隔形式保存，例：0，-1，-3）
		0: 良性；
		-1：动态未定
		-2：未知
		-3：非肿瘤
	 */
	private String notMalignantTumorFlag;
	
	/**
	 * 开启设置后，随访任务获得有效结果以电话获取为最终结果（短信、微信、门诊/住院获取到有效结果后仍可电话随访）1：开启；0：关闭（默认）。
	 */
	private Integer followupResultFlag;

	public Integer getFollowupCycle() {
		return followupCycle;
	}

	public void setFollowupCycle(Integer followupCycle) {
		this.followupCycle = followupCycle;
	}

	public Integer getPhoneResultMustConnectFlag() {
		return phoneResultMustConnectFlag;
	}

	public void setPhoneResultMustConnectFlag(Integer phoneResultMustConnectFlag) {
		this.phoneResultMustConnectFlag = phoneResultMustConnectFlag;
	}

	public Integer getOtherAsValidResultFlag() {
		return otherAsValidResultFlag;
	}

	public void setOtherAsValidResultFlag(Integer otherAsValidResultFlag) {
		this.otherAsValidResultFlag = otherAsValidResultFlag;
	}

	public Integer getAutoPatientNoPaddingFlag() {
		return autoPatientNoPaddingFlag;
	}

	public void setAutoPatientNoPaddingFlag(Integer autoPatientNoPaddingFlag) {
		this.autoPatientNoPaddingFlag = autoPatientNoPaddingFlag;
	}

	public Integer getAutoPatientNoPaddingDigits() {
		return autoPatientNoPaddingDigits;
	}

	public void setAutoPatientNoPaddingDigits(Integer autoPatientNoPaddingDigits) {
		this.autoPatientNoPaddingDigits = autoPatientNoPaddingDigits;
	}

	public Integer getCancerFilterFlag() {
		return cancerFilterFlag;
	}

	public void setCancerFilterFlag(Integer cancerFilterFlag) {
		this.cancerFilterFlag = cancerFilterFlag;
	}

	public Integer getDeathDateRequiredFlag() {
		return deathDateRequiredFlag;
	}

	public void setDeathDateRequiredFlag(Integer deathDateRequiredFlag) {
		this.deathDateRequiredFlag = deathDateRequiredFlag;
	}

	public Integer getDiseaseTypeSelfDefineFlag() {
		return diseaseTypeSelfDefineFlag;
	}

	public void setDiseaseTypeSelfDefineFlag(Integer diseaseTypeSelfDefineFlag) {
		this.diseaseTypeSelfDefineFlag = diseaseTypeSelfDefineFlag;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Date getRolloutTime() {
		return rolloutTime;
	}

	public void setRolloutTime(Date rolloutTime) {
		this.rolloutTime = rolloutTime;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
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

	public Integer getIsOutsideCallAuth() {
		return isOutsideCallAuth;
	}

	public void setIsOutsideCallAuth(Integer isOutsideCallAuth) {
		this.isOutsideCallAuth = isOutsideCallAuth;
	}

	public String getOutsideCallNum() {
		return outsideCallNum;
	}

	public void setOutsideCallNum(String outsideCallNum) {
		this.outsideCallNum = outsideCallNum;
	}

	public Integer getIsIpCall() {
		return isIpCall;
	}

	public void setIsIpCall(Integer isIpCall) {
		this.isIpCall = isIpCall;
	}

	public String getIpCallNum() {
		return ipCallNum;
	}

	public void setIpCallNum(String ipCallNum) {
		this.ipCallNum = ipCallNum;
	}

	public Integer getRolloutMonth() {
		return rolloutMonth;
	}

	public void setRolloutMonth(Integer rolloutMonth) {
		this.rolloutMonth = rolloutMonth;
	}

	public Integer getDeployLocation() {
		return deployLocation;
	}

	public void setDeployLocation(Integer deployLocation) {
		this.deployLocation = deployLocation;
	}

	public String getNotMalignantTumorFlag() {
		return notMalignantTumorFlag;
	}

	public void setNotMalignantTumorFlag(String notMalignantTumorFlag) {
		this.notMalignantTumorFlag = notMalignantTumorFlag;
	}

	public Integer getFollowupResultFlag() {
		return followupResultFlag;
	}

	public void setFollowupResultFlag(Integer followupResultFlag) {
		this.followupResultFlag = followupResultFlag;
	}

	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}

	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}
}
