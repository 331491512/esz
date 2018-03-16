/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.conf<br/>  
 * <b>文件名：</b>TFollowupGlobalConfigInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午2:57:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.model;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TFollowupGlobalConfigInfo
* @Description: 全局配置类
* @author NiDan
* @date 2016年8月10日下午2:57:02 
*/
public class TFollowupGlobalConfigInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5454820454149280059L;
	
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
	 * 系统部署位置。1：B端；2：云端。
	 */
	private Integer deployLocation;
	
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
	 * 非恶性肿瘤筛选设置值 
	 * 以逗号分隔的字符串。0：良性肿瘤；-1：动态未定肿瘤；-2：未知病种；-3：非肿瘤。
	 */
	private String notMalignantTumorFlag;
	
	/**
	 * 随访结果控制设置 (1：开启；0：关闭（默认）
	 */
	private Integer followupResultFlag=0;
	
	/**
	 * 有效结果控制开关 （1：开启；0：关闭（默认））
	 */
	private Integer validResultControlFlag=0;
	
	
	private Integer autoGuessDiedFlag;
	
	private Integer smsTemplateShowPatientNameFlag;
	
	//add by fanpanwei 随访表开关 1:显示；0：不显示
	private Integer displayFollowupTable;
	
	/**
	 * 随访范围  0:只恶性 1：参照notMalignantTumorFlag 2：大病种 3：编码配置表查询
	 */
	private Integer followupRangeFlag; 
	
	/**
	 * 随访短信激活开关
	 *	0：关闭（默认）
	 *	1：开启
	 */
	private Integer followupActivateSmsFlag;
	
	/**
	 * 导出敏感数据，默认0-关，1为开
	 */
	private Integer exportSensitiveDataFlag;
	
	public TFollowupGlobalConfigInfo() {
		
	}

	public TFollowupGlobalConfigInfo(Integer followupCycle,
			Integer phoneResultMustConnectFlag, Integer otherAsValidResultFlag,
			Integer autoPatientNoPaddingFlag,
			Integer autoPatientNoPaddingDigits, Integer cancerFilterFlag,
			Integer deathDateRequiredFlag, Integer diseaseTypeSelfDefineFlag,
			Integer hospitalId, String hospitalName, Date rolloutTime,
			Date deployTime, Date createTime, Date updateTime,
			Integer isOutsideCallAuth, String outsideCallNum, Integer isIpCall,
			String ipCallNum,String notMalignantTumorFlag,Integer followupResultFlag,Integer deployLocation,Integer followupActivateSmsFlag) {
		super();
		this.followupCycle = followupCycle;
		this.phoneResultMustConnectFlag = phoneResultMustConnectFlag;
		this.otherAsValidResultFlag = otherAsValidResultFlag;
		this.autoPatientNoPaddingFlag = autoPatientNoPaddingFlag;
		this.autoPatientNoPaddingDigits = autoPatientNoPaddingDigits;
		this.cancerFilterFlag = cancerFilterFlag;
		this.deathDateRequiredFlag = deathDateRequiredFlag;
		this.diseaseTypeSelfDefineFlag = diseaseTypeSelfDefineFlag;
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.rolloutTime = rolloutTime;
		this.deployTime = deployTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isOutsideCallAuth = isOutsideCallAuth;
		this.outsideCallNum = outsideCallNum;
		this.isIpCall = isIpCall;
		this.ipCallNum = ipCallNum;
		this.notMalignantTumorFlag=notMalignantTumorFlag;
		this.followupResultFlag=followupResultFlag;
		this.deployLocation=deployLocation;
		this.followupActivateSmsFlag=followupActivateSmsFlag;
	}

	public Integer getValidResultControlFlag() {
		return validResultControlFlag;
	}

	public void setValidResultControlFlag(Integer validResultControlFlag) {
		this.validResultControlFlag = validResultControlFlag;
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
		if(isOutsideCallAuth == null) {
			isOutsideCallAuth = 0;
		}
		this.isOutsideCallAuth = isOutsideCallAuth;
	}

	public String getOutsideCallNum() {
		return outsideCallNum;
	}

	public void setOutsideCallNum(String outsideCallNum) {
		if(outsideCallNum == null || outsideCallNum.trim().equals("")) {
			outsideCallNum = "9";
		}
		this.outsideCallNum = outsideCallNum;
	}

	public Integer getIsIpCall() {
		return isIpCall;
	}

	public void setIsIpCall(Integer isIpCall) {
		if(isIpCall == null) {
			isIpCall = 0;
		}
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

	public Integer getAutoGuessDiedFlag() {
		return autoGuessDiedFlag;
	}

	public void setAutoGuessDiedFlag(Integer autoGuessDiedFlag) {
		this.autoGuessDiedFlag = autoGuessDiedFlag;
	}

	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}

	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}

	public Integer getSmsTemplateShowPatientNameFlag() {
		return smsTemplateShowPatientNameFlag;
	}

	public void setSmsTemplateShowPatientNameFlag(
			Integer smsTemplateShowPatientNameFlag) {
		this.smsTemplateShowPatientNameFlag = smsTemplateShowPatientNameFlag;
	}

	public Integer getDeployLocation() {
		return deployLocation;
	}

	public void setDeployLocation(Integer deployLocation) {
		this.deployLocation = deployLocation;
	}

	public Integer getDisplayFollowupTable() {
		return displayFollowupTable;
	}

	public void setDisplayFollowupTable(Integer displayFollowupTable) {
		this.displayFollowupTable = displayFollowupTable;
	}

	public Integer getFollowupActivateSmsFlag() {
		return followupActivateSmsFlag;
	}

	public void setFollowupActivateSmsFlag(Integer followupActivateSmsFlag) {
		this.followupActivateSmsFlag = followupActivateSmsFlag;
	}

	public Integer getExportSensitiveDataFlag() {
		return exportSensitiveDataFlag;
	}

	public void setExportSensitiveDataFlag(Integer exportSensitiveDataFlag) {
		this.exportSensitiveDataFlag = exportSensitiveDataFlag;
	}
}
