package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_relation", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_relation_audit", schema = "user_db_audit", catalog = "user_db_audit")
public class MetaRelation {
    private int relationId;
    private String relationName;
//    private Collection<UPatientFamilyGeneticHistory> uPatientFamilyGeneticHistoriesByRelationId;

    @Id
    @Column(name = "relationId", nullable = false)
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "relationName", nullable = false, length = 64)
    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaRelation that = (MetaRelation) o;

        if (relationId != that.relationId) return false;
        if (relationName != null ? !relationName.equals(that.relationName) : that.relationName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = relationId;
        result = 31 * result + (relationName != null ? relationName.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaRelationByRelationId")
//    public Collection<UPatientFamilyGeneticHistory> getuPatientFamilyGeneticHistoriesByRelationId() {
//        return uPatientFamilyGeneticHistoriesByRelationId;
//    }
//
//    public void setuPatientFamilyGeneticHistoriesByRelationId(Collection<UPatientFamilyGeneticHistory> uPatientFamilyGeneticHistoriesByRelationId) {
//        this.uPatientFamilyGeneticHistoriesByRelationId = uPatientFamilyGeneticHistoriesByRelationId;
//    }
}
