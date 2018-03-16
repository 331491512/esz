package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_department", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_department_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UDepartment {
    private int deptId;
    private int hospitalId;
    private String uuid;
    private Integer parentId;
    private String deptName;
    private String deptCode;
    private Integer deptType;
    private int level;
    private String tel;
    private String introduction;
    private Long creator;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private Collection<USubDept> uSubDeptsByDeptId;

    @Id
    @Column(name = "deptId", nullable = false)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
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
    @Column(name = "parentId", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "deptName", nullable = false, length = 100)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "deptCode", nullable = true, length = 20)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Basic
    @Column(name = "deptType", nullable = true)
    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 13)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    @Column(name = "creator", nullable = true)
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
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

        UDepartment that = (UDepartment) o;

        if (deptId != that.deptId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (level != that.level) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptType != null ? !deptType.equals(that.deptType) : that.deptType != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptId;
        result = 31 * result + hospitalId;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (deptType != null ? deptType.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "uDepartmentByDeptId")
//    public Collection<USubDept> getuSubDeptsByDeptId() {
//        return uSubDeptsByDeptId;
//    }
//
//    public void setuSubDeptsByDeptId(Collection<USubDept> uSubDeptsByDeptId) {
//        this.uSubDeptsByDeptId = uSubDeptsByDeptId;
//    }
}
