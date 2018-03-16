/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.model;<br/>  
 * <b>文件名：</b>PatientHospitalCertificateInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月9日下午2:37:42<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;
/** 
* @ClassName: PatientHospitalCertificateInfo
* @Description: 
* @author lichenghao
* @date 2017年1月9日 下午2:37:42  
*/
public class PatientHospitalCertificateInfo {
	//医院患者关系表对应Id
	private Integer id;
	//患者旧病案号关系表ID
	private Integer rid;
	//手机认证
	private Integer mobileFlag;
	//患者编号
	private Long patientId;
	//患者姓名
	private String trueName;
	//患者uuid
	private String patientUuid;
	//患者是否是微信患者
	private Integer weixinFlag;
	//自身weixinFlag
	private Integer tobFlag;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getMobileFlag() {
		return mobileFlag;
	}
	public void setMobileFlag(Integer mobileFlag) {
		this.mobileFlag = mobileFlag;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public Integer getWeixinFlag() {
		return weixinFlag;
	}
	public void setWeixinFlag(Integer weixinFlag) {
		this.weixinFlag = weixinFlag;
	}
	public Integer getTobFlag() {
		return tobFlag;
	}
	public void setTobFlag(Integer tobFlag) {
		this.tobFlag = tobFlag;
	}
}
