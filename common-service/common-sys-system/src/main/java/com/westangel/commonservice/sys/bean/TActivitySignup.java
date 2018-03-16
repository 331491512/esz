/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.bean;<br/>  
 * <b>文件名：</b>TActivitySingup.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日下午4:58:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.bean;

import java.util.Date;

/** 
* @ClassName: TActivitySingup
* @Description:活动详情信息 
* @author lichenghao
* @date 2015年12月17日 下午4:58:10  
*/
public class TActivitySignup {
	
	//活动ID
	private String activityId;
	
	//报名手机号
	private String mobile;
	
	//姓名
	private String personName;
	
	//身份证号
	private String personIdentity;
	
	//报名用户
	private Long userId;
	
	//add2017-04-05
	//报名日期默认就是createTime
	
	//这个申请的ID
	private Integer id;
	
	//用户填写的年龄
	private Integer personAge;
	
	//用户填写的性别 1男2女
	private Integer personSex;

	//用户填写的医院名称
	private String personHospitalName;
	
	//用户填写的医院ID
	private Long personHospitalId;
	
	//用户填写的病案号
	private String personPatientNo;
	
	//用户填写的病种名称
	private String personDiseaseType;
	
	//用户填写的病种对应的ID
	private Integer personDiseaseTypeId;
	
	//用户填写的用药信息
	private String medicalInfo;
	
	//用户填写的地址
	private String address;
	
	//用户填写的地址
	private String addressCode;
	
	//用户填写的其他联系方式
	private String otherContact;
	
	//用户填写的其他信息
	private String others;
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonIdentity() {
		return personIdentity;
	}

	public void setPersonIdentity(String personIdentity) {
		this.personIdentity = personIdentity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

	public Integer getPersonSex() {
		return personSex;
	}

	public void setPersonSex(Integer personSex) {
		this.personSex = personSex;
	}

	

	public String getPersonHospitalName() {
		return personHospitalName;
	}

	public void setPersonHospitalName(String personHospitalName) {
		this.personHospitalName = personHospitalName;
	}

	public Long getPersonHospitalId() {
		return personHospitalId;
	}

	public void setPersonHospitalId(Long personHospitalId) {
		this.personHospitalId = personHospitalId;
	}

	public String getPersonPatientNo() {
		return personPatientNo;
	}

	public void setPersonPatientNo(String personPatientNo) {
		this.personPatientNo = personPatientNo;
	}

	public String getPersonDiseaseType() {
		return personDiseaseType;
	}

	public void setPersonDiseaseType(String personDiseaseType) {
		this.personDiseaseType = personDiseaseType;
	}

	public Integer getPersonDiseaseTypeId() {
		return personDiseaseTypeId;
	}

	public void setPersonDiseaseTypeId(Integer personDiseaseTypeId) {
		this.personDiseaseTypeId = personDiseaseTypeId;
	}

	public String getMedicalInfo() {
		return medicalInfo;
	}

	public void setMedicalInfo(String medicalInfo) {
		this.medicalInfo = medicalInfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getOtherContact() {
		return otherContact;
	}

	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	
	
}
