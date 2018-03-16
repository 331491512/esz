/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.model;<br/>  
 * <b>文件名：</b>HospitalPatientCertificatedHistory.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月10日上午8:59:51<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;
/** 
* @ClassName: HospitalPatientCertificatedHistory
* @Description: 
* @author lichenghao
* @date 2017年1月10日 上午8:59:51  
*/
public class HospitalPatientCertificatedHistory {
	private Long historyId;//记录号
	private Long userId;//用户编号
	private Long patientId;//患者编号
	private String patientNo;//患者病案号
	private String trueName;//姓名
	private String mobile;
	private Integer hospitalId;//医院编号
	private Integer certificatedState;//认证状态  -1失败 0待认证 1成功
	private Integer failState;//失败状态 -1姓名不匹配 -2数据待合并 -3 无有效患者
	private String cause;//失败原因
	private String remark;//备注
	private Integer auditWay;//认证方式  1:系统 2:人工
	private Long matchPatientId;//匹配患者
	private String certificatedParam;//首次认证信息
	private String matchPatientUuid; //匹配库患者uuid
	private Integer matchFlag; //匹配数据 1：正式库 2：匹配库
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Integer getCertificatedState() {
		return certificatedState;
	}
	public void setCertificatedState(Integer certificatedState) {
		this.certificatedState = certificatedState;
	}
	public Integer getFailState() {
		return failState;
	}
	public void setFailState(Integer failState) {
		this.failState = failState;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getMatchPatientId() {
		return matchPatientId;
	}
	public void setMatchPatientId(Long matchPatientId) {
		this.matchPatientId = matchPatientId;
	}
	public Long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
	public String getCertificatedParam() {
		return certificatedParam;
	}
	public void setCertificatedParam(String certificatedParam) {
		this.certificatedParam = certificatedParam;
	}
	public Integer getAuditWay() {
		return auditWay;
	}
	public void setAuditWay(Integer auditWay) {
		this.auditWay = auditWay;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMatchPatientUuid() {
		return matchPatientUuid;
	}
	public void setMatchPatientUuid(String matchPatientUuid) {
		this.matchPatientUuid = matchPatientUuid;
	}
	public Integer getMatchFlag() {
		return matchFlag;
	}
	public void setMatchFlag(Integer matchFlag) {
		this.matchFlag = matchFlag;
	}
}
