/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>WXFollowupResultReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月18日下午7:16:55<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: WXFollowupResultReq
* @Description: 
* @author lichenghao
* @date 2016年7月18日 下午7:16:55  
*/
public class WXFollowupResultReq {
	//随访状态
	private Integer followupResultValue;
	//复发部位
	private String relapseParts;
	//复发时间
	private String relapseDate;
	//转移部位
	private String transferParts;
	//转移时间
	private String transferDate;
	//死亡时间
	private String deathDate;
	//死亡原因
	private String deathCause;

	//其他原因
	private String otherCause;
	//医院编号
	private Integer hospitalId;
	//消息编号
	private String messageId;
	//患者编号
	private Long patientId;
	public Integer getFollowupResultValue() {
		return followupResultValue;
	}
	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}
	public String getRelapseParts() {
		return relapseParts;
	}
	public void setRelapseParts(String relapseParts) {
		this.relapseParts = relapseParts;
	}
	public String getRelapseDate() {
		return relapseDate;
	}
	public void setRelapseDate(String relapseDate) {
		this.relapseDate = relapseDate;
	}
	public String getTransferParts() {
		return transferParts;
	}
	public void setTransferParts(String transferParts) {
		this.transferParts = transferParts;
	}
	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getOtherCause() {
		return otherCause;
	}
	public void setOtherCause(String otherCause) {
		this.otherCause = otherCause;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public String getDeathCause() {
		return deathCause;
	}
	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}
}
