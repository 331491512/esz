package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_doctor", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_doctor_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UDoctor {
    private long doctorId;
    private long userId;
    private Long parentId;
    private String uuid;
    private String mobile;
    private String trueName;
    private int syncFlag;
    private int auditState;
    private String nickName;
    private Integer sex;
    private Date birthDate;
    private String userPictureUrl;
    private String professionCredence;
    private String registerCredence;
    private String workCredence;
    private String professionCredencePicUrl;
    private String registerCredencePicUrl;
    private String workCredencePicUrl;
    private int isExpert;
    private String skills;
    private String tagIds;
    private String tags;
    private Integer positionTitle;
    private Integer professionalRank;
    private String qrcodeUrl;
    private String tel;
    private String introduction;
    private String auditRemark;
    private int recommendFlag;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String staffNo;
    private Timestamp rawCreateTime;
//    private Collection<RDoctorPatient> rDoctorPatientsByDoctorId;
//    private Collection<RHospitalDoctor> rHospitalDoctorsByDoctorId;
//    private Collection<RSubdeptDoctor> rSubdeptDoctorsByDoctorId;
//    private UUser uUserByUserId;

    @Id
    @Column(name = "doctorId", nullable = false)
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "parentId", nullable = true)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 45)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 100)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    @Column(name = "syncFlag", nullable = false)
    public int getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(int syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "auditState", nullable = false)
    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
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
    @Column(name = "userPictureUrl", nullable = true, length = 128)
    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    @Basic
    @Column(name = "professionCredence", nullable = true, length = 50)
    public String getProfessionCredence() {
        return professionCredence;
    }

    public void setProfessionCredence(String professionCredence) {
        this.professionCredence = professionCredence;
    }

    @Basic
    @Column(name = "registerCredence", nullable = true, length = 50)
    public String getRegisterCredence() {
        return registerCredence;
    }

    public void setRegisterCredence(String registerCredence) {
        this.registerCredence = registerCredence;
    }

    @Basic
    @Column(name = "workCredence", nullable = true, length = 50)
    public String getWorkCredence() {
        return workCredence;
    }

    public void setWorkCredence(String workCredence) {
        this.workCredence = workCredence;
    }

    @Basic
    @Column(name = "professionCredencePicUrl", nullable = true, length = 255)
    public String getProfessionCredencePicUrl() {
        return professionCredencePicUrl;
    }

    public void setProfessionCredencePicUrl(String professionCredencePicUrl) {
        this.professionCredencePicUrl = professionCredencePicUrl;
    }

    @Basic
    @Column(name = "registerCredencePicUrl", nullable = true, length = 255)
    public String getRegisterCredencePicUrl() {
        return registerCredencePicUrl;
    }

    public void setRegisterCredencePicUrl(String registerCredencePicUrl) {
        this.registerCredencePicUrl = registerCredencePicUrl;
    }

    @Basic
    @Column(name = "workCredencePicUrl", nullable = true, length = 255)
    public String getWorkCredencePicUrl() {
        return workCredencePicUrl;
    }

    public void setWorkCredencePicUrl(String workCredencePicUrl) {
        this.workCredencePicUrl = workCredencePicUrl;
    }

    @Basic
    @Column(name = "isExpert", nullable = false)
    public int getIsExpert() {
        return isExpert;
    }

    public void setIsExpert(int isExpert) {
        this.isExpert = isExpert;
    }

    @Basic
    @Column(name = "skills", nullable = true, length = 1000)
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Basic
    @Column(name = "tagIds", nullable = true, length = 128)
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
    @Column(name = "positionTitle", nullable = true)
    public Integer getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(Integer positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Basic
    @Column(name = "professionalRank", nullable = true)
    public Integer getProfessionalRank() {
        return professionalRank;
    }

    public void setProfessionalRank(Integer professionalRank) {
        this.professionalRank = professionalRank;
    }

    @Basic
    @Column(name = "qrcodeUrl", nullable = true, length = 255)
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
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
    @Column(name = "introduction", nullable = true, length = 8000)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "auditRemark", nullable = true, length = 255)
    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Basic
    @Column(name = "recommendFlag", nullable = false)
    public int getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(int recommendFlag) {
        this.recommendFlag = recommendFlag;
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
    @Column(name = "staffNo", nullable = true, length = 30)
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
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

        UDoctor uDoctor = (UDoctor) o;

        if (doctorId != uDoctor.doctorId) return false;
        if (userId != uDoctor.userId) return false;
        if (syncFlag != uDoctor.syncFlag) return false;
        if (auditState != uDoctor.auditState) return false;
        if (isExpert != uDoctor.isExpert) return false;
        if (recommendFlag != uDoctor.recommendFlag) return false;
        if (parentId != null ? !parentId.equals(uDoctor.parentId) : uDoctor.parentId != null) return false;
        if (uuid != null ? !uuid.equals(uDoctor.uuid) : uDoctor.uuid != null) return false;
        if (mobile != null ? !mobile.equals(uDoctor.mobile) : uDoctor.mobile != null) return false;
        if (trueName != null ? !trueName.equals(uDoctor.trueName) : uDoctor.trueName != null) return false;
        if (nickName != null ? !nickName.equals(uDoctor.nickName) : uDoctor.nickName != null) return false;
        if (sex != null ? !sex.equals(uDoctor.sex) : uDoctor.sex != null) return false;
        if (birthDate != null ? !birthDate.equals(uDoctor.birthDate) : uDoctor.birthDate != null) return false;
        if (userPictureUrl != null ? !userPictureUrl.equals(uDoctor.userPictureUrl) : uDoctor.userPictureUrl != null)
            return false;
        if (professionCredence != null ? !professionCredence.equals(uDoctor.professionCredence) : uDoctor.professionCredence != null)
            return false;
        if (registerCredence != null ? !registerCredence.equals(uDoctor.registerCredence) : uDoctor.registerCredence != null)
            return false;
        if (workCredence != null ? !workCredence.equals(uDoctor.workCredence) : uDoctor.workCredence != null)
            return false;
        if (professionCredencePicUrl != null ? !professionCredencePicUrl.equals(uDoctor.professionCredencePicUrl) : uDoctor.professionCredencePicUrl != null)
            return false;
        if (registerCredencePicUrl != null ? !registerCredencePicUrl.equals(uDoctor.registerCredencePicUrl) : uDoctor.registerCredencePicUrl != null)
            return false;
        if (workCredencePicUrl != null ? !workCredencePicUrl.equals(uDoctor.workCredencePicUrl) : uDoctor.workCredencePicUrl != null)
            return false;
        if (skills != null ? !skills.equals(uDoctor.skills) : uDoctor.skills != null) return false;
        if (tagIds != null ? !tagIds.equals(uDoctor.tagIds) : uDoctor.tagIds != null) return false;
        if (tags != null ? !tags.equals(uDoctor.tags) : uDoctor.tags != null) return false;
        if (positionTitle != null ? !positionTitle.equals(uDoctor.positionTitle) : uDoctor.positionTitle != null)
            return false;
        if (professionalRank != null ? !professionalRank.equals(uDoctor.professionalRank) : uDoctor.professionalRank != null)
            return false;
        if (qrcodeUrl != null ? !qrcodeUrl.equals(uDoctor.qrcodeUrl) : uDoctor.qrcodeUrl != null) return false;
        if (tel != null ? !tel.equals(uDoctor.tel) : uDoctor.tel != null) return false;
        if (introduction != null ? !introduction.equals(uDoctor.introduction) : uDoctor.introduction != null)
            return false;
        if (auditRemark != null ? !auditRemark.equals(uDoctor.auditRemark) : uDoctor.auditRemark != null) return false;
        if (createTime != null ? !createTime.equals(uDoctor.createTime) : uDoctor.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(uDoctor.updateTime) : uDoctor.updateTime != null) return false;
        if (staffNo != null ? !staffNo.equals(uDoctor.staffNo) : uDoctor.staffNo != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(uDoctor.rawCreateTime) : uDoctor.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (doctorId ^ (doctorId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + syncFlag;
        result = 31 * result + auditState;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (userPictureUrl != null ? userPictureUrl.hashCode() : 0);
        result = 31 * result + (professionCredence != null ? professionCredence.hashCode() : 0);
        result = 31 * result + (registerCredence != null ? registerCredence.hashCode() : 0);
        result = 31 * result + (workCredence != null ? workCredence.hashCode() : 0);
        result = 31 * result + (professionCredencePicUrl != null ? professionCredencePicUrl.hashCode() : 0);
        result = 31 * result + (registerCredencePicUrl != null ? registerCredencePicUrl.hashCode() : 0);
        result = 31 * result + (workCredencePicUrl != null ? workCredencePicUrl.hashCode() : 0);
        result = 31 * result + isExpert;
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (tagIds != null ? tagIds.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (positionTitle != null ? positionTitle.hashCode() : 0);
        result = 31 * result + (professionalRank != null ? professionalRank.hashCode() : 0);
        result = 31 * result + (qrcodeUrl != null ? qrcodeUrl.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (auditRemark != null ? auditRemark.hashCode() : 0);
        result = 31 * result + recommendFlag;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
//
//    @OneToMany(mappedBy = "uDoctorByDoctorId")
//    public Collection<RDoctorPatient> getrDoctorPatientsByDoctorId() {
//        return rDoctorPatientsByDoctorId;
//    }
//
//    public void setrDoctorPatientsByDoctorId(Collection<RDoctorPatient> rDoctorPatientsByDoctorId) {
//        this.rDoctorPatientsByDoctorId = rDoctorPatientsByDoctorId;
//    }
//
//    @OneToMany(mappedBy = "uDoctorByDoctorId")
//    public Collection<RHospitalDoctor> getrHospitalDoctorsByDoctorId() {
//        return rHospitalDoctorsByDoctorId;
//    }
//
//    public void setrHospitalDoctorsByDoctorId(Collection<RHospitalDoctor> rHospitalDoctorsByDoctorId) {
//        this.rHospitalDoctorsByDoctorId = rHospitalDoctorsByDoctorId;
//    }
//
//    @OneToMany(mappedBy = "uDoctorByDoctorId")
//    public Collection<RSubdeptDoctor> getrSubdeptDoctorsByDoctorId() {
//        return rSubdeptDoctorsByDoctorId;
//    }
//
//    public void setrSubdeptDoctorsByDoctorId(Collection<RSubdeptDoctor> rSubdeptDoctorsByDoctorId) {
//        this.rSubdeptDoctorsByDoctorId = rSubdeptDoctorsByDoctorId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable = false, updatable = false)
//    public UUser getuUserByUserId() {
//        return uUserByUserId;
//    }
//
//    public void setuUserByUserId(UUser uUserByUserId) {
//        this.uUserByUserId = uUserByUserId;
//    }
}
