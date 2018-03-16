package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_role", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_role_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaRole {
    private int userRole;
    private String roleName;
    private int roleType;
    private Integer deptId;
    private String remark;

    @Id
    @Column(name = "userRole", nullable = false)
    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "roleName", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "roleType", nullable = false)
    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    @Basic
    @Column(name = "deptId", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaRole metaRole = (MetaRole) o;

        if (userRole != metaRole.userRole) return false;
        if (roleType != metaRole.roleType) return false;
        if (roleName != null ? !roleName.equals(metaRole.roleName) : metaRole.roleName != null) return false;
        if (deptId != null ? !deptId.equals(metaRole.deptId) : metaRole.deptId != null) return false;
        if (remark != null ? !remark.equals(metaRole.remark) : metaRole.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRole;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + roleType;
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
