package com.esuizhen.cloudservice.user.model.followuppatient;

import java.util.List;

import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.user.PatientFamily;

public class FollowupPatientProfile extends PatientProfile{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -2200301602693490124L;
		/**
	     * 出生城市代码
	     */
	    private String birthPlaceCode;
	    /**
	     * 出生城市名称
	     */
	    private String birthPlaceName;
	    /**
	     * 出生地详细地址
	     */
	    private String birthPlaceAddress;
	    /**
	     * 民族
	     */
	    private Integer nationId;
	    
	    /**
	     * 民族
	     */
	    private String nation;
	    /**
	     * 国籍
	     */
	    private Integer nationalityId;
	    
	    /**
	     * 国籍名称
	     */
	    private String country;
	    /**
	     * 籍贯
	     */
	    private String nativePlace;
	    
	    private String identification;
	    
	    private String profession;
	    
	    private Integer occupationId;
	    
	    private Integer marriageStatus;
	    
	    private String marriageStatusName;
	    
	    /**
	     * 患者家属列表
	     */
	    private List<PatientFamily> patientFamilyList;
	    
	    private String followupResultValueName;
	    /**
	     * 工作单位
	     */
	    private String company;
	    
	    
	    private String confirmedDateSource;

		public String getBirthPlaceCode() {
			return birthPlaceCode;
		}

		public void setBirthPlaceCode(String birthPlaceCode) {
			this.birthPlaceCode = birthPlaceCode;
		}

		public String getBirthPlaceName() {
			return birthPlaceName;
		}

		public void setBirthPlaceName(String birthPlaceName) {
			this.birthPlaceName = birthPlaceName;
		}

		public String getBirthPlaceAddress() {
			return birthPlaceAddress;
		}

		public void setBirthPlaceAddress(String birthPlaceAddress) {
			this.birthPlaceAddress = birthPlaceAddress;
		}

		public Integer getNationId() {
			return nationId;
		}

		public void setNationId(Integer nationId) {
			this.nationId = nationId;
		}

		public String getNation() {
			return nation;
		}

		public void setNation(String nation) {
			this.nation = nation;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getNativePlace() {
			return nativePlace;
		}

		public void setNativePlace(String nativePlace) {
			this.nativePlace = nativePlace;
		}

		public String getIdentification() {
			return identification;
		}

		public void setIdentification(String identification) {
			this.identification = identification;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}

		public Integer getMarriageStatus() {
			return marriageStatus;
		}

		public void setMarriageStatus(Integer marriageStatus) {
			this.marriageStatus = marriageStatus;
		}

		public String getMarriageStatusName() {
			return marriageStatusName;
		}

		public void setMarriageStatusName(String marriageStatusName) {
			this.marriageStatusName = marriageStatusName;
		}

		public List<PatientFamily> getPatientFamilyList() {
			return patientFamilyList;
		}

		public void setPatientFamilyList(List<PatientFamily> patientFamilyList) {
			this.patientFamilyList = patientFamilyList;
		}

		public String getFollowupResultValueName() {
			return followupResultValueName;
		}

		public void setFollowupResultValueName(String followupResultValueName) {
			this.followupResultValueName = followupResultValueName;
		}

		public Integer getNationalityId() {
			return nationalityId;
		}

		public void setNationalityId(Integer nationalityId) {
			this.nationalityId = nationalityId;
		}

		public Integer getOccupationId() {
			return occupationId;
		}

		public void setOccupationId(Integer occupationId) {
			this.occupationId = occupationId;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getConfirmedDateSource() {
			return confirmedDateSource;
		}

		public void setConfirmedDateSource(String confirmedDateSource) {
			this.confirmedDateSource = confirmedDateSource;
		}
	    
}
