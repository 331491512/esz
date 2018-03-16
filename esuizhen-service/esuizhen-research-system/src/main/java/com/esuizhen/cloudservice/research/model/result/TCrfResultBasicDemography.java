package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:CrfResultBasicDemography</p>
 * <p>Description:患者人口学信息bean</p>
 * @author YYCHEN
 * @date 2016年5月26日 下午3:16:44
 */
public class TCrfResultBasicDemography implements Serializable {
	private static final long serialVersionUID = 1L;

	//结果项Id.
	private String crfDemographyResultId;
	//观察项结果Id
	private String crfResultId;
	//患者UserId
	private Long userId;
	//患者ID
	private Long patientId;
	//患者标识号
	private String patientNo;
	//手机号
	private String mobile;
	//姓名
	private String trueName;
	//性别。1：男；2：女
	private Integer sex;
	//出生日期
	private Date birthDate;
	//出生地
	private String birthPlace;
	//
	private String cityCode;
	//国籍
	private String country;
	//名族
	private String nation;
	//职业
	private String profession;
	//血型
	private String bloodType;
	/**
	 * 证件类型。
		1：身份证（缺省）
		2：军官证
		3：护照
	 */
	private Integer idType;
	//身份证号/护照/军官证号
	private String identification;
	//婚姻状况
	private Integer marriageStatus;
	//居住类型
	private Integer residenceType;
	//通信地址
	private String address;
	//文化程度
	private Integer degree;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	
	//患者疾病确诊日期
	private Date confirmedDate;
	//是否开通了微信
	private Integer weixinFlag;
	
	public String getPatientNo() {
		return patientNo;
	}
	public Integer getWeixinFlag() {
		return weixinFlag;
	}
	public void setWeixinFlag(Integer weixinFlag) {
		this.weixinFlag = weixinFlag;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	public Date getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public String getCrfDemographyResultId() {
		return crfDemographyResultId;
	}
	public void setCrfDemographyResultId(String crfDemographyResultId) {
		this.crfDemographyResultId = crfDemographyResultId;
	}
	public String getCrfResultId() {
		return crfResultId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setCrfResultId(String crfResultId) {
		this.crfResultId = crfResultId;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Long getPatientId() {
		return patientId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Integer getMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public Integer getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(Integer residenceType) {
		this.residenceType = residenceType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
}
