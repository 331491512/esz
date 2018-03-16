package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_hospital", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_hospital_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UHospital {
    private int hospitalId;
    private String uuid;
    private int syncFlag;
    private String hospitalName;
    private String nickName;
    private String tagIds;
    private String tags;
    private Integer gradeId;
    private String specialClinics;
    private String address;
    private String busLines;
    private int cityId;
    private String cityCode;
    private String tel;
    private String fax;
    private String introduction;
    private Double latitude;
    private Double longitude;
    private Long userId;
    private String contactName;
    private String contactMobile;
    private String pictureUrl;
    private Integer state;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private Collection<ConfHospitalWx> confHospitalWxesByHospitalId;
//    private Collection<RHospitalSpecialty> rHospitalSpecialtiesByHospitalId;

    @Id
    @Column(name = "hospitalId", nullable = false)
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
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
    @Column(name = "syncFlag", nullable = false)
    public int getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(int syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "hospitalName", nullable = false, length = 255)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "nickName", nullable = true, length = 100)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "tagIds", nullable = true, length = 255)
    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    @Basic
    @Column(name = "tags", nullable = true, length = 255)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "gradeId", nullable = true)
    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "specialClinics", nullable = true, length = 255)
    public String getSpecialClinics() {
        return specialClinics;
    }

    public void setSpecialClinics(String specialClinics) {
        this.specialClinics = specialClinics;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "busLines", nullable = true, length = 255)
    public String getBusLines() {
        return busLines;
    }

    public void setBusLines(String busLines) {
        this.busLines = busLines;
    }

    @Basic
    @Column(name = "cityId", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "cityCode", nullable = true, length = 50)
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 100)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "fax", nullable = true, length = 30)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "introduction", nullable = true, length = 500)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "contactName", nullable = true, length = 100)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contactMobile", nullable = true, length = 20)
    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    @Basic
    @Column(name = "pictureUrl", nullable = true, length = 255)
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UHospital uHospital = (UHospital) o;

        if (hospitalId != uHospital.hospitalId) return false;
        if (syncFlag != uHospital.syncFlag) return false;
        if (cityId != uHospital.cityId) return false;
        if (uuid != null ? !uuid.equals(uHospital.uuid) : uHospital.uuid != null) return false;
        if (hospitalName != null ? !hospitalName.equals(uHospital.hospitalName) : uHospital.hospitalName != null)
            return false;
        if (nickName != null ? !nickName.equals(uHospital.nickName) : uHospital.nickName != null) return false;
        if (tagIds != null ? !tagIds.equals(uHospital.tagIds) : uHospital.tagIds != null) return false;
        if (tags != null ? !tags.equals(uHospital.tags) : uHospital.tags != null) return false;
        if (gradeId != null ? !gradeId.equals(uHospital.gradeId) : uHospital.gradeId != null) return false;
        if (specialClinics != null ? !specialClinics.equals(uHospital.specialClinics) : uHospital.specialClinics != null)
            return false;
        if (address != null ? !address.equals(uHospital.address) : uHospital.address != null) return false;
        if (busLines != null ? !busLines.equals(uHospital.busLines) : uHospital.busLines != null) return false;
        if (cityCode != null ? !cityCode.equals(uHospital.cityCode) : uHospital.cityCode != null) return false;
        if (tel != null ? !tel.equals(uHospital.tel) : uHospital.tel != null) return false;
        if (fax != null ? !fax.equals(uHospital.fax) : uHospital.fax != null) return false;
        if (introduction != null ? !introduction.equals(uHospital.introduction) : uHospital.introduction != null)
            return false;
        if (latitude != null ? !latitude.equals(uHospital.latitude) : uHospital.latitude != null) return false;
        if (longitude != null ? !longitude.equals(uHospital.longitude) : uHospital.longitude != null) return false;
        if (userId != null ? !userId.equals(uHospital.userId) : uHospital.userId != null) return false;
        if (contactName != null ? !contactName.equals(uHospital.contactName) : uHospital.contactName != null)
            return false;
        if (contactMobile != null ? !contactMobile.equals(uHospital.contactMobile) : uHospital.contactMobile != null)
            return false;
        if (pictureUrl != null ? !pictureUrl.equals(uHospital.pictureUrl) : uHospital.pictureUrl != null) return false;
        if (state != null ? !state.equals(uHospital.state) : uHospital.state != null) return false;
        if (createTime != null ? !createTime.equals(uHospital.createTime) : uHospital.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(uHospital.updateTime) : uHospital.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hospitalId;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + syncFlag;
        result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (tagIds != null ? tagIds.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (gradeId != null ? gradeId.hashCode() : 0);
        result = 31 * result + (specialClinics != null ? specialClinics.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (busLines != null ? busLines.hashCode() : 0);
        result = 31 * result + cityId;
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactMobile != null ? contactMobile.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "uHospitalByHospitalId")
//    public Collection<ConfHospitalWx> getConfHospitalWxesByHospitalId() {
//        return confHospitalWxesByHospitalId;
//    }
//
//    public void setConfHospitalWxesByHospitalId(Collection<ConfHospitalWx> confHospitalWxesByHospitalId) {
//        this.confHospitalWxesByHospitalId = confHospitalWxesByHospitalId;
//    }
//
//    @OneToMany(mappedBy = "uHospitalByHospitalId")
//    public Collection<RHospitalSpecialty> getrHospitalSpecialtiesByHospitalId() {
//        return rHospitalSpecialtiesByHospitalId;
//    }
//
//    public void setrHospitalSpecialtiesByHospitalId(Collection<RHospitalSpecialty> rHospitalSpecialtiesByHospitalId) {
//        this.rHospitalSpecialtiesByHospitalId = rHospitalSpecialtiesByHospitalId;
//    }
}
