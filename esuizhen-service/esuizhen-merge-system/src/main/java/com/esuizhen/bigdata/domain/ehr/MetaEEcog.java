package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_ecog", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_ecog_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEEcog {
    private Integer ecogId;
    private Integer score;
    private String description;
    private Integer kpsId;
    private Timestamp createTime;
//    private MetaEKps metaEKpsByKpsId;

    @Id
    @Column(name = "ecogId", nullable = false)
    public Integer getEcogId() {
        return ecogId;
    }

    public void setEcogId(Integer ecogId) {
        this.ecogId = ecogId;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "kpsId", nullable = false)
    public Integer getKpsId() {
        return kpsId;
    }

    public void setKpsId(Integer kpsId) {
        this.kpsId = kpsId;
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

        MetaEEcog metaEEcog = (MetaEEcog) o;

        if (ecogId != null ? !ecogId.equals(metaEEcog.ecogId) : metaEEcog.ecogId != null) return false;
        if (score != null ? !score.equals(metaEEcog.score) : metaEEcog.score != null) return false;
        if (description != null ? !description.equals(metaEEcog.description) : metaEEcog.description != null)
            return false;
        if (kpsId != null ? !kpsId.equals(metaEEcog.kpsId) : metaEEcog.kpsId != null) return false;
        if (createTime != null ? !createTime.equals(metaEEcog.createTime) : metaEEcog.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ecogId != null ? ecogId.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (kpsId != null ? kpsId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "kpsId", referencedColumnName = "kpsId", nullable = false)
//    public MetaEKps getMetaEKpsByKpsId() {
//        return metaEKpsByKpsId;
//    }
//
//    public void setMetaEKpsByKpsId(MetaEKps metaEKpsByKpsId) {
//        this.metaEKpsByKpsId = metaEKpsByKpsId;
//    }
}
