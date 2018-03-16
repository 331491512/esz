package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "r_subdept_doctor", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "r_subdept_doctor_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class RSubdeptDoctor {
    private int id;
    private long doctorId;
    private int deptId;
    private int subDeptId;
    private Integer positionTitle;
    private Timestamp createTime;
//    private UDoctor uDoctorByDoctorId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "doctorId", nullable = false)
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
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
    @Column(name = "subDeptId", nullable = false)
    public int getSubDeptId() {
        return subDeptId;
    }

    public void setSubDeptId(int subDeptId) {
        this.subDeptId = subDeptId;
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
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RSubdeptDoctor that = (RSubdeptDoctor) o;

        if (id != that.id) return false;
        if (doctorId != that.doctorId) return false;
        if (deptId != that.deptId) return false;
        if (subDeptId != that.subDeptId) return false;
        if (positionTitle != null ? !positionTitle.equals(that.positionTitle) : that.positionTitle != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (doctorId ^ (doctorId >>> 32));
        result = 31 * result + deptId;
        result = 31 * result + subDeptId;
        result = 31 * result + (positionTitle != null ? positionTitle.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "doctorId", referencedColumnName = "doctorId", nullable = false, insertable = false, updatable = false)
//    public UDoctor getuDoctorByDoctorId() {
//        return uDoctorByDoctorId;
//    }
//
//    public void setuDoctorByDoctorId(UDoctor uDoctorByDoctorId) {
//        this.uDoctorByDoctorId = uDoctorByDoctorId;
//    }
}
