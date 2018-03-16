package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: HospitalSearchReq 
* @Description: 查询医院列表参数请求bean
* @author YYCHEN
* @date 2015年12月23日 上午11:23:33  
*/
public class HospitalSearchReq implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer hospitalId;
	private String cityCode;
	private String hospitalName;
	private Date timeFlag;
	private String defaultHospitalPictureUrl;
	private Integer prefixLength;
	private Integer specialtyId;
	private Integer state;
	//查询患者编号
	private Long patientId;
	//是否签约了医院
	private Integer reqFlag;

	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Date getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(Date timeFlag) {
		this.timeFlag = timeFlag;
	}
	/** 
	* @return cityCode 
	*/
	public String getCityCode() {
		return cityCode;
	}
	/** 
	* @param cityCode 要设置的 cityCode 
	*/
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getDefaultHospitalPictureUrl() {
		return defaultHospitalPictureUrl;
	}
	public void setDefaultHospitalPictureUrl(String defaultHospitalPictureUrl) {
		this.defaultHospitalPictureUrl = defaultHospitalPictureUrl;
	}
	public Integer getPrefixLength() {
		return prefixLength;
	}
	public void setPrefixLength(Integer prefixLength) {
		this.prefixLength = prefixLength;
	}
	public Integer getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
}
