package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * @ClassName: AntiCancerPatientInfoResp.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月23日
 */
public class AutiCancerPatientInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private long userId;
	private Long patientId;
	private String patientNo;
	private String patientName;
	private int sex;
	private Date birthDate;
	private String birthPlaceAddress;
	private int nationalityId;
	private String country;
	private int nationId;
	private String nation;
	private int medicalCareAreaId;
	private String medicalCarePlace;
	private String idNo;
	private String mobile;
	private String medicalCareCardNo;
	private int occupationId;
	private int marriageStatus;
	private int medicalCareType;
	private String address;
	private String familyTel;
	private String famZipcode;
	private String companyAddress;
	private String birthPlaceCode;
	private String nativePlace;
	private String companyTel;
	private String comZipCode;
	private List<AutiCancerLinkManContact> contactsList;
	//private List<AutiCancerLinkManContact> delContactsList;
	private List<GeneticDiseaseContact> geneticDiseaseList;
	//private List<GeneticDiseaseContact> delGeneDiseaseList;
	/**
     * 患者基本信息登记Id
     */
    private Long specialDiseaseRegisterId;
    /**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	/**
	 * 人员类别 1-在职，2-退休
	 */
	private Integer stafferType;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthPlaceAddress() {
		return birthPlaceAddress;
	}
	public void setBirthPlaceAddress(String birthPlaceAddress) {
		this.birthPlaceAddress = birthPlaceAddress;
	}
	public int getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getNationId() {
		return nationId;
	}
	public void setNationId(int nationId) {
		this.nationId = nationId;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getMedicalCareAreaId() {
		return medicalCareAreaId;
	}
	public void setMedicalCareAreaId(int medicalCareAreaId) {
		this.medicalCareAreaId = medicalCareAreaId;
	}
	public String getMedicalCarePlace() {
		return medicalCarePlace;
	}
	public void setMedicalCarePlace(String medicalCarePlace) {
		this.medicalCarePlace = medicalCarePlace;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMedicalCareCardNo() {
		return medicalCareCardNo;
	}
	public void setMedicalCareCardNo(String medicalCareCardNo) {
		this.medicalCareCardNo = medicalCareCardNo;
	}
	public int getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}
	public int getMarriageStatus() {
		return marriageStatus;
	}
	public void setMarriageStatus(int marriageStatus) {
		this.marriageStatus = marriageStatus;
	}
	public int getMedicalCareType() {
		return medicalCareType;
	}
	public void setMedicalCareType(int medicalCareType) {
		this.medicalCareType = medicalCareType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFamilyTel() {
		return familyTel;
	}
	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}
	public String getFamZipcode() {
		return famZipcode;
	}
	public void setFamZipcode(String famZipcode) {
		this.famZipcode = famZipcode;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getComZipCode() {
		return comZipCode;
	}
	public void setComZipCode(String comZipCode) {
		this.comZipCode = comZipCode;
	}
	public List<AutiCancerLinkManContact> getContactsList() {
		return contactsList;
	}
	public void setContactsList(List<AutiCancerLinkManContact> contactsList) {
		this.contactsList = contactsList;
	}
	public List<GeneticDiseaseContact> getGeneticDiseaseList() {
		return geneticDiseaseList;
	}
	public void setGeneticDiseaseList(List<GeneticDiseaseContact> geneticDiseaseList) {
		this.geneticDiseaseList = geneticDiseaseList;
	}
/*	public List<AutiCancerLinkManContact> getDelContactsList() {
		return delContactsList;
	}
	public void setDelContactsList(List<AutiCancerLinkManContact> delContactsList) {
		this.delContactsList = delContactsList;
	}
	public List<GeneticDiseaseContact> getDelGeneDiseaseList() {
		return delGeneDiseaseList;
	}
	public void setDelGeneDiseaseList(List<GeneticDiseaseContact> delGeneDiseaseList) {
		this.delGeneDiseaseList = delGeneDiseaseList;
	}*/
	public String getBirthPlaceCode() {
		return birthPlaceCode;
	}
	public void setBirthPlaceCode(String birthPlaceCode) {
		this.birthPlaceCode = birthPlaceCode;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public Integer getOperateFlag() {
		return operateFlag;
	}
	public void setOperateFlag(Integer operateFlag) {
		this.operateFlag = operateFlag;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Integer getStafferType() {
		return stafferType;
	}
	public void setStafferType(Integer stafferType) {
		this.stafferType = stafferType;
	}
 
}
