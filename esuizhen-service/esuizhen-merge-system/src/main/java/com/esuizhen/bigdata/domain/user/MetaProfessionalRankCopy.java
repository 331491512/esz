package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_professional_rank_copy", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_professional_rank_copy_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaProfessionalRankCopy {
    private int professionalRankId;
    private String professionalRankName;

    @Id
    @Column(name = "professionalRankId", nullable = false)
    public int getProfessionalRankId() {
        return professionalRankId;
    }

    public void setProfessionalRankId(int professionalRankId) {
        this.professionalRankId = professionalRankId;
    }

    @Basic
    @Column(name = "professionalRankName", nullable = false, length = 50)
    public String getProfessionalRankName() {
        return professionalRankName;
    }

    public void setProfessionalRankName(String professionalRankName) {
        this.professionalRankName = professionalRankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaProfessionalRankCopy that = (MetaProfessionalRankCopy) o;

        if (professionalRankId != that.professionalRankId) return false;
        if (professionalRankName != null ? !professionalRankName.equals(that.professionalRankName) : that.professionalRankName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = professionalRankId;
        result = 31 * result + (professionalRankName != null ? professionalRankName.hashCode() : 0);
        return result;
    }
}
