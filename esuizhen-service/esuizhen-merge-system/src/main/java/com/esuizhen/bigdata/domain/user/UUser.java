package com.esuizhen.bigdata.domain.user;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */

@Entity
@Table(name = "u_user", schema = "user_db", catalog = "")
//@Audited
//@AuditTable(value = "u_user_audit", schema = "user_db_audit", catalog = "user_db_audit")
public class UUser {
    private long userId;
    private String uuid;
    private String userName;
    private int role;
    private int accountType;
    private int infoState;
    private int syncFlag;
    private String trueName;
    private Timestamp createTime;
    private Timestamp firstLoginTime;
    private Timestamp updateTime;
    private String cryptPasswd;
    private String nickName;
    private String mobile;
    private Integer sex;
    private Date birthDate;
    private String userPictureUrl;
    private String email;
    private Integer nationId;
    private String nation;
    private Integer nationalityId;
    private String country;
    private Integer cityId;
    private String cityCode;
    private String city;
    private String address;
    private String nativePlace;
    private String birthPlaceCode;
    private String birthPlaceAddress;
    private Integer occupationId;
    private String profession;
    private String company;
    private Integer idType;
    private String identification;
    private Integer marriageStatus;
    private String signature;
    private Integer education;
    private String school;
    private String interest;
    private String idFileUrl;
    private int state;
    private String subroles;
    private int points;
    private Timestamp lastLoginTime;
    private int sourceFlag;
    private int userFlag;
    private int migrateFlag;
    private Long relatedUserId;
    private Timestamp lastLogoutTime;
    private int appFlag;
    private int weixinFlag;
    private Integer pcFlag;
    private String patientNo;
    private String clinicNo;
    private Integer handleFlag;
    private String staffNo;
    private String companyTel;
    private String comZipCode;
    private Timestamp rawCreateTime;

    private Long mergeFrom;
    private Long mergeTarget;
    private Integer mergeFlag;
    // private Integer patientType;
    private Timestamp mergeTime;

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    /* @Basic
     @Column(name = "patientType", nullable = true)
     public Integer getPatientType() {
         return patientType;
     }

     public void setPatientType(Integer patientType) {
         this.patientType = patientType;
     }
 */
    @Basic
    @Column(name = "mergeFlag", nullable = true)
    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    @Basic
    @Column(name = "mergeFrom", nullable = true)
    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    @Basic
    @Column(name = "mergeTarget", nullable = true)
    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }


    @Id
    @Column(name = "userId", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 32)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Basic
    @Column(name = "accountType", nullable = false)
    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "infoState", nullable = false)
    public int getInfoState() {
        return infoState;
    }

    public void setInfoState(int infoState) {
        this.infoState = infoState;
    }

    @Basic
    @Column(name = "syncFlag", nullable = false)
    public int getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(int syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "trueName", nullable = true, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "firstLoginTime", nullable = true)
    public Timestamp getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Timestamp firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "cryptPasswd", nullable = false, length = 32)
    public String getCryptPasswd() {
        return cryptPasswd;
    }

    public void setCryptPasswd(String cryptPasswd) {
        this.cryptPasswd = cryptPasswd;
    }

    @Basic
    @Column(name = "nickName", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthDate", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "userPictureUrl", nullable = true, length = 255)
    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nationId", nullable = true)
    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    @Basic
    @Column(name = "nation", nullable = true, length = 20)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "nationalityId", nullable = true)
    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 30)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "cityId", nullable = true)
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "cityCode", nullable = true, length = 20)
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "nativePlace", nullable = true, length = 30)
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Basic
    @Column(name = "birthPlaceCode", nullable = true, length = 32)
    public String getBirthPlaceCode() {
        return birthPlaceCode;
    }

    public void setBirthPlaceCode(String birthPlaceCode) {
        this.birthPlaceCode = birthPlaceCode;
    }

    @Basic
    @Column(name = "birthPlaceAddress", nullable = true, length = 108)
    public String getBirthPlaceAddress() {
        return birthPlaceAddress;
    }

    public void setBirthPlaceAddress(String birthPlaceAddress) {
        this.birthPlaceAddress = birthPlaceAddress;
    }

    @Basic
    @Column(name = "occupationId", nullable = true)
    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    @Basic
    @Column(name = "profession", nullable = true, length = 30)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "company", nullable = true, length = 80)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "idType", nullable = true)
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "identification", nullable = true, length = 100)
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * `marriageStatus` int(2) DEFAULT NULL
     * COMMENT '婚姻状况:1：未婚；2：已婚；3：丧偶；4：离婚9：其他',
     *
     * @return
     */
    @Basic
    @Column(name = "marriageStatus", nullable = true)
    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    @Basic
    @Column(name = "signature", nullable = true, length = 128)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "education", nullable = true)
    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    @Basic
    @Column(name = "school", nullable = true, length = 64)
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "interest", nullable = true, length = 128)
    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Basic
    @Column(name = "idFileUrl", nullable = true, length = 128)
    public String getIdFileUrl() {
        return idFileUrl;
    }

    public void setIdFileUrl(String idFileUrl) {
        this.idFileUrl = idFileUrl;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "subroles", nullable = true, length = 500)
    public String getSubroles() {
        return subroles;
    }

    public void setSubroles(String subroles) {
        this.subroles = subroles;
    }

    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Basic
    @Column(name = "lastLoginTime", nullable = true)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "sourceFlag", nullable = false)
    public int getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(int sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    @Basic
    @Column(name = "userFlag", nullable = false)
    public int getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(int userFlag) {
        this.userFlag = userFlag;
    }

    @Basic
    @Column(name = "migrateFlag", nullable = false)
    public int getMigrateFlag() {
        return migrateFlag;
    }

    public void setMigrateFlag(int migrateFlag) {
        this.migrateFlag = migrateFlag;
    }

    @Basic
    @Column(name = "relatedUserId", nullable = true)
    public Long getRelatedUserId() {
        return relatedUserId;
    }

    public void setRelatedUserId(Long relatedUserId) {
        this.relatedUserId = relatedUserId;
    }

    @Basic
    @Column(name = "lastLogoutTime", nullable = true)
    public Timestamp getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(Timestamp lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    @Basic
    @Column(name = "appFlag", nullable = false)
    public int getAppFlag() {
        return appFlag;
    }

    public void setAppFlag(int appFlag) {
        this.appFlag = appFlag;
    }

    @Basic
    @Column(name = "weixinFlag", nullable = false)
    public int getWeixinFlag() {
        return weixinFlag;
    }

    public void setWeixinFlag(int weixinFlag) {
        this.weixinFlag = weixinFlag;
    }

    @Basic
    @Column(name = "pcFlag", nullable = true)
    public Integer getPcFlag() {
        return pcFlag;
    }

    public void setPcFlag(Integer pcFlag) {
        this.pcFlag = pcFlag;
    }

    @Basic
    @Column(name = "patientNo", nullable = true, length = 32)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "clinicNo", nullable = true, length = 32)
    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo;
    }

    @Basic
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    @Basic
    @Column(name = "staffNo", nullable = true, length = 30)
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    @Basic
    @Column(name = "companyTel", nullable = true, length = 20)
    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    @Basic
    @Column(name = "comZipCode", nullable = true, length = 10)
    public String getComZipCode() {
        return comZipCode;
    }

    public void setComZipCode(String comZipCode) {
        this.comZipCode = comZipCode;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UUser uUser = (UUser) o;

        if (userId != uUser.userId) return false;
        if (role != uUser.role) return false;
        if (accountType != uUser.accountType) return false;
        if (infoState != uUser.infoState) return false;
        if (syncFlag != uUser.syncFlag) return false;
        if (state != uUser.state) return false;
        if (points != uUser.points) return false;
        if (sourceFlag != uUser.sourceFlag) return false;
        if (userFlag != uUser.userFlag) return false;
        if (migrateFlag != uUser.migrateFlag) return false;
        if (appFlag != uUser.appFlag) return false;
        if (weixinFlag != uUser.weixinFlag) return false;
        if (uuid != null ? !uuid.equals(uUser.uuid) : uUser.uuid != null) return false;
        if (userName != null ? !userName.equals(uUser.userName) : uUser.userName != null) return false;
        if (trueName != null ? !trueName.equals(uUser.trueName) : uUser.trueName != null) return false;
        if (createTime != null ? !createTime.equals(uUser.createTime) : uUser.createTime != null) return false;
        if (firstLoginTime != null ? !firstLoginTime.equals(uUser.firstLoginTime) : uUser.firstLoginTime != null)
            return false;
        if (updateTime != null ? !updateTime.equals(uUser.updateTime) : uUser.updateTime != null) return false;
        if (cryptPasswd != null ? !cryptPasswd.equals(uUser.cryptPasswd) : uUser.cryptPasswd != null) return false;
        if (nickName != null ? !nickName.equals(uUser.nickName) : uUser.nickName != null) return false;
        if (mobile != null ? !mobile.equals(uUser.mobile) : uUser.mobile != null) return false;
        if (sex != null ? !sex.equals(uUser.sex) : uUser.sex != null) return false;
        if (birthDate != null ? !birthDate.equals(uUser.birthDate) : uUser.birthDate != null) return false;
        if (userPictureUrl != null ? !userPictureUrl.equals(uUser.userPictureUrl) : uUser.userPictureUrl != null)
            return false;
        if (email != null ? !email.equals(uUser.email) : uUser.email != null) return false;
        if (nationId != null ? !nationId.equals(uUser.nationId) : uUser.nationId != null) return false;
        if (nation != null ? !nation.equals(uUser.nation) : uUser.nation != null) return false;
        if (nationalityId != null ? !nationalityId.equals(uUser.nationalityId) : uUser.nationalityId != null)
            return false;
        if (country != null ? !country.equals(uUser.country) : uUser.country != null) return false;
        if (cityId != null ? !cityId.equals(uUser.cityId) : uUser.cityId != null) return false;
        if (cityCode != null ? !cityCode.equals(uUser.cityCode) : uUser.cityCode != null) return false;
        if (city != null ? !city.equals(uUser.city) : uUser.city != null) return false;
        if (address != null ? !address.equals(uUser.address) : uUser.address != null) return false;
        if (nativePlace != null ? !nativePlace.equals(uUser.nativePlace) : uUser.nativePlace != null) return false;
        if (birthPlaceCode != null ? !birthPlaceCode.equals(uUser.birthPlaceCode) : uUser.birthPlaceCode != null)
            return false;
        if (birthPlaceAddress != null ? !birthPlaceAddress.equals(uUser.birthPlaceAddress) : uUser.birthPlaceAddress != null)
            return false;
        if (occupationId != null ? !occupationId.equals(uUser.occupationId) : uUser.occupationId != null) return false;
        if (profession != null ? !profession.equals(uUser.profession) : uUser.profession != null) return false;
        if (company != null ? !company.equals(uUser.company) : uUser.company != null) return false;
        if (idType != null ? !idType.equals(uUser.idType) : uUser.idType != null) return false;
        if (identification != null ? !identification.equals(uUser.identification) : uUser.identification != null)
            return false;
        if (marriageStatus != null ? !marriageStatus.equals(uUser.marriageStatus) : uUser.marriageStatus != null)
            return false;
        if (signature != null ? !signature.equals(uUser.signature) : uUser.signature != null) return false;
        if (education != null ? !education.equals(uUser.education) : uUser.education != null) return false;
        if (school != null ? !school.equals(uUser.school) : uUser.school != null) return false;
        if (interest != null ? !interest.equals(uUser.interest) : uUser.interest != null) return false;
        if (idFileUrl != null ? !idFileUrl.equals(uUser.idFileUrl) : uUser.idFileUrl != null) return false;
        if (subroles != null ? !subroles.equals(uUser.subroles) : uUser.subroles != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(uUser.lastLoginTime) : uUser.lastLoginTime != null)
            return false;
        if (relatedUserId != null ? !relatedUserId.equals(uUser.relatedUserId) : uUser.relatedUserId != null)
            return false;
        if (lastLogoutTime != null ? !lastLogoutTime.equals(uUser.lastLogoutTime) : uUser.lastLogoutTime != null)
            return false;
        if (pcFlag != null ? !pcFlag.equals(uUser.pcFlag) : uUser.pcFlag != null) return false;
        if (patientNo != null ? !patientNo.equals(uUser.patientNo) : uUser.patientNo != null) return false;
        if (clinicNo != null ? !clinicNo.equals(uUser.clinicNo) : uUser.clinicNo != null) return false;
        if (handleFlag != null ? !handleFlag.equals(uUser.handleFlag) : uUser.handleFlag != null) return false;
        if (staffNo != null ? !staffNo.equals(uUser.staffNo) : uUser.staffNo != null) return false;
        if (companyTel != null ? !companyTel.equals(uUser.companyTel) : uUser.companyTel != null) return false;
        if (comZipCode != null ? !comZipCode.equals(uUser.comZipCode) : uUser.comZipCode != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(uUser.rawCreateTime) : uUser.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + accountType;
        result = 31 * result + infoState;
        result = 31 * result + syncFlag;
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (firstLoginTime != null ? firstLoginTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (cryptPasswd != null ? cryptPasswd.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (userPictureUrl != null ? userPictureUrl.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nationId != null ? nationId.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (nationalityId != null ? nationalityId.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (birthPlaceCode != null ? birthPlaceCode.hashCode() : 0);
        result = 31 * result + (birthPlaceAddress != null ? birthPlaceAddress.hashCode() : 0);
        result = 31 * result + (occupationId != null ? occupationId.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (marriageStatus != null ? marriageStatus.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        result = 31 * result + (idFileUrl != null ? idFileUrl.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (subroles != null ? subroles.hashCode() : 0);
        result = 31 * result + points;
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + sourceFlag;
        result = 31 * result + userFlag;
        result = 31 * result + migrateFlag;
        result = 31 * result + (relatedUserId != null ? relatedUserId.hashCode() : 0);
        result = 31 * result + (lastLogoutTime != null ? lastLogoutTime.hashCode() : 0);
        result = 31 * result + appFlag;
        result = 31 * result + weixinFlag;
        result = 31 * result + (pcFlag != null ? pcFlag.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (clinicNo != null ? clinicNo.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (companyTel != null ? companyTel.hashCode() : 0);
        result = 31 * result + (comZipCode != null ? comZipCode.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
}
