package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_hosiptal_specialty", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_hosiptal_specialty_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaHosiptalSpecialty {
    private int specialtyId;
    private String specialtyName;
//    private Collection<RHospitalSpecialty> rHospitalSpecialtiesBySpecialtyId;

    @Id
    @Column(name = "specialtyId", nullable = false)
    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Basic
    @Column(name = "specialtyName", nullable = false, length = 100)
    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaHosiptalSpecialty that = (MetaHosiptalSpecialty) o;

        if (specialtyId != that.specialtyId) return false;
        if (specialtyName != null ? !specialtyName.equals(that.specialtyName) : that.specialtyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specialtyId;
        result = 31 * result + (specialtyName != null ? specialtyName.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaHosiptalSpecialtyBySpecialtyId")
//    public Collection<RHospitalSpecialty> getrHospitalSpecialtiesBySpecialtyId() {
//        return rHospitalSpecialtiesBySpecialtyId;
//    }
//
//    public void setrHospitalSpecialtiesBySpecialtyId(Collection<RHospitalSpecialty> rHospitalSpecialtiesBySpecialtyId) {
//        this.rHospitalSpecialtiesBySpecialtyId = rHospitalSpecialtiesBySpecialtyId;
//    }
}
