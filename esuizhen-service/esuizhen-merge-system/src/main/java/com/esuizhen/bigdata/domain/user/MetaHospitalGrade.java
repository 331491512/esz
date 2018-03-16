package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_hospital_grade", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_hospital_grade_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaHospitalGrade {
    private int gradeId;
    private String gradeName;

    @Id
    @Column(name = "gradeId", nullable = false)
    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "gradeName", nullable = false, length = 50)
    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaHospitalGrade that = (MetaHospitalGrade) o;

        if (gradeId != that.gradeId) return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gradeId;
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        return result;
    }
}
