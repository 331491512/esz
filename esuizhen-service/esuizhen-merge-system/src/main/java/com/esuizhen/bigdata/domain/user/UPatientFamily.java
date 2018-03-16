package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_patient_family", schema = "user_db", catalog = "")
//@Audited
//@AuditTable(value = "u_patient_family_audit", schema = "user_db_audit", catalog = "user_db_audit")
public class UPatientFamily {
    private Long id;
    private Long patientId;
    private int patientRelation;
    private String familyName;
    private String familyPhone;
    private String zipcode;
    private String oldContactAddress;
    private String address;
    private Integer isDefault;
    private Integer isValid;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String remark;
    private Timestamp rawCreateTime;
    private String flag;
    private UPatient uPatientByPatientId;

    private Long mergeFrom;
    private Long mergeTarget;
    private Integer mergeFlag;
    //private Integer patientType;
    private Timestamp mergeTime;
    private String contactId;

    @Basic
    @Column(name = "contactId", nullable = true)
    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

  /*  @Basic
    @Column(name = "patientType", nullable = true)
    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }*/

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
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    //@Column(name = "patientId", nullable = false)
    //Caused by: org.hibernate.MappingException: Repeated column in mapping for entity: com.esuizhen.bigdata.domain.UPatientFamily_AUD column: patientId (should be mapped with insert="false" update="false")
    @Column(name = "patientId", nullable = false)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patientRelation", nullable = false)
    public int getPatientRelation() {
        return patientRelation;
    }

    public void setPatientRelation(int patientRelation) {
        this.patientRelation = patientRelation;
    }

    @Basic
    @Column(name = "familyName", nullable = true, length = 100)
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "familyPhone", nullable = true, length = 100)
    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    @Basic
    @Column(name = "zipcode", nullable = true, length = 10)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "oldContactAddress", nullable = true, length = 255)
    public String getOldContactAddress() {
        return oldContactAddress;
    }

    public void setOldContactAddress(String oldContactAddress) {
        this.oldContactAddress = oldContactAddress;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "isDefault", nullable = true)
    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Basic
    @Column(name = "isValid", nullable = true)
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Basic
    @Column(name = "flag", nullable = true, length = 255)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UPatientFamily that = (UPatientFamily) o;
        //if (id != that.id) return false;

        if (patientId != that.patientId) return false;
        //if (patientRelation != that.patientRelation) return false;
        if (familyName != null ? !familyName.equals(that.familyName) : that.familyName != null) return false;
        if (familyPhone != null ? !familyPhone.equals(that.familyPhone) : that.familyPhone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        //if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        //if (oldContactAddress != null ? !oldContactAddress.equals(that.oldContactAddress) : that.oldContactAddress != null)
        //    return false;
        //if (isDefault != null ? !isDefault.equals(that.isDefault) : that.isDefault != null) return false;
        //if (isValid != null ? !isValid.equals(that.isValid) : that.isValid != null) return false;
        //if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        //if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        //if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        //if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
        //    return false;
        //if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        /*int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + patientRelation;
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (familyPhone != null ? familyPhone.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (oldContactAddress != null ? oldContactAddress.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (isDefault != null ? isDefault.hashCode() : 0);
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;*/
        int result = (int) (patientId ^ (patientId >>> 32));
        //result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (familyPhone != null ? familyPhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UPatientFamily{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", familyName='" + familyName + '\'' +
                ", familyPhone='" + familyPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "patientId", nullable = false, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "u_patient_family_ibfk_1"))
    public UPatient getuPatientByPatientId() {
        return uPatientByPatientId;
    }

    public void setuPatientByPatientId(UPatient uPatientByPatientId) {
        this.uPatientByPatientId = uPatientByPatientId;
    }
}
