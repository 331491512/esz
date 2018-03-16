package com.esuizhen.bigdata.domain.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_sub_dept", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_sub_dept_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class USubDept {
    private int subDeptId;
    private int deptId;
    private String uuid;
    private String subDeptName;
    private int level;
    private String tel;
    private String introduction;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private UDepartment uDepartmentByDeptId;

    @Id
    @Column(name = "subDeptId", nullable = false)
    public int getSubDeptId() {
        return subDeptId;
    }

    public void setSubDeptId(int subDeptId) {
        this.subDeptId = subDeptId;
    }

    @Basic
    @Column(name = "deptId", nullable = false)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
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
    @Column(name = "subDeptName", nullable = false, length = 100)
    public String getSubDeptName() {
        return subDeptName;
    }

    public void setSubDeptName(String subDeptName) {
        this.subDeptName = subDeptName;
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

        USubDept uSubDept = (USubDept) o;

        if (subDeptId != uSubDept.subDeptId) return false;
        if (deptId != uSubDept.deptId) return false;
        if (level != uSubDept.level) return false;
        if (uuid != null ? !uuid.equals(uSubDept.uuid) : uSubDept.uuid != null) return false;
        if (subDeptName != null ? !subDeptName.equals(uSubDept.subDeptName) : uSubDept.subDeptName != null)
            return false;
        if (tel != null ? !tel.equals(uSubDept.tel) : uSubDept.tel != null) return false;
        if (introduction != null ? !introduction.equals(uSubDept.introduction) : uSubDept.introduction != null)
            return false;
        if (createTime != null ? !createTime.equals(uSubDept.createTime) : uSubDept.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(uSubDept.updateTime) : uSubDept.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subDeptId;
        result = 31 * result + deptId;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (subDeptName != null ? subDeptName.hashCode() : 0);
        result = 31 * result + level;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "deptId", referencedColumnName = "deptId", nullable = false, insertable = false, updatable = false)
//    public UDepartment getuDepartmentByDeptId() {
//        return uDepartmentByDeptId;
//    }
//
//    public void setuDepartmentByDeptId(UDepartment uDepartmentByDeptId) {
//        this.uDepartmentByDeptId = uDepartmentByDeptId;
//    }
}
