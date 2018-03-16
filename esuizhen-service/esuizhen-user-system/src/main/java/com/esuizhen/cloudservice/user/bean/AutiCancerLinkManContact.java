package com.esuizhen.cloudservice.user.bean;

import java.io.Serializable;

/** 
 * @ClassName: AutiCancerContactsList.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月23日
 */
public class AutiCancerLinkManContact  implements Serializable {
	
	private Integer linkManId;
	private Long patientId;
	private String contactId;
	private Integer relationId;
	private String familyName;
	private String familyPhone;
	private String linkAddress;
	private String zipcode;
	private Integer isValid;
	private Integer isDefault;
	private Long specialDiseaseRegisterId;
	public Integer getId() {
		return linkManId;
	}
	public void setId(Integer id) {
		this.linkManId = id;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
}
