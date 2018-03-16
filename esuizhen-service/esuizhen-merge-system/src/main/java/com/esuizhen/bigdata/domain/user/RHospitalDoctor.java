package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "r_hospital_doctor", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "r_hospital_doctor_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class RHospitalDoctor {
    private int id;
    private long doctorId;
    private int hospitalId;
    private String hospitalName;
    private int deptId;
    private Integer positionTitle;
    private String staffNo;
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
    @Column(name = "hospitalId", nullable = false)
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "hospitalName", nullable = true, length = 255)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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
    @Column(name = "positionTitle", nullable = true)
    public Integer getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(Integer positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Basic
    @Column(name = "staffNo", nullable = true, length = 45)
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
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

        RHospitalDoctor that = (RHospitalDoctor) o;

        if (id != that.id) return false;
        if (doctorId != that.doctorId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (deptId != that.deptId) return false;
        if (hospitalName != null ? !hospitalName.equals(that.hospitalName) : that.hospitalName != null) return false;
        if (positionTitle != null ? !positionTitle.equals(that.positionTitle) : that.positionTitle != null)
            return false;
        if (staffNo != null ? !staffNo.equals(that.staffNo) : that.staffNo != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (doctorId ^ (doctorId >>> 32));
        result = 31 * result + hospitalId;
        result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
        result = 31 * result + deptId;
        result = 31 * result + (positionTitle != null ? positionTitle.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
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
