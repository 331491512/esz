package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "r_hospital_specialty", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "r_hospital_specialty_audit", schema = "user_db_audit", catalog = "user_db_audit")
public class RHospitalSpecialty {
    private int id;
    private int hospitalId;
    private int specialtyId;
    private Timestamp createTime;
//    private UHospital uHospitalByHospitalId;
//    private MetaHosiptalSpecialty metaHosiptalSpecialtyBySpecialtyId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "specialtyId", nullable = false)
    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
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

        RHospitalSpecialty that = (RHospitalSpecialty) o;

        if (id != that.id) return false;
        if (hospitalId != that.hospitalId) return false;
        if (specialtyId != that.specialtyId) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hospitalId;
        result = 31 * result + specialtyId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "hospitalId", referencedColumnName = "hospitalId", nullable = false, insertable = false, updatable = false)
//    public UHospital getuHospitalByHospitalId() {
//        return uHospitalByHospitalId;
//    }
//
//    public void setuHospitalByHospitalId(UHospital uHospitalByHospitalId) {
//        this.uHospitalByHospitalId = uHospitalByHospitalId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "specialtyId", referencedColumnName = "specialtyId", nullable = false, insertable = false, updatable = false)
//    public MetaHosiptalSpecialty getMetaHosiptalSpecialtyBySpecialtyId() {
//        return metaHosiptalSpecialtyBySpecialtyId;
//    }
//
//    public void setMetaHosiptalSpecialtyBySpecialtyId(MetaHosiptalSpecialty metaHosiptalSpecialtyBySpecialtyId) {
//        this.metaHosiptalSpecialtyBySpecialtyId = metaHosiptalSpecialtyBySpecialtyId;
//    }
}
