package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_kps", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_kps_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEKps {
    private Integer kpsId;
    private Integer score;
    private String description;
    private Timestamp createTime;
//    private Collection<MetaEEcog> metaEEcogsByKpsId;

    @Id
    @Column(name = "kpsId", nullable = false)
    public Integer getKpsId() {
        return kpsId;
    }

    public void setKpsId(Integer kpsId) {
        this.kpsId = kpsId;
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

        MetaEKps metaEKps = (MetaEKps) o;

        if (kpsId != null ? !kpsId.equals(metaEKps.kpsId) : metaEKps.kpsId != null) return false;
        if (score != null ? !score.equals(metaEKps.score) : metaEKps.score != null) return false;
        if (description != null ? !description.equals(metaEKps.description) : metaEKps.description != null)
            return false;
        if (createTime != null ? !createTime.equals(metaEKps.createTime) : metaEKps.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kpsId != null ? kpsId.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEKpsByKpsId")
//    public Collection<MetaEEcog> getMetaEEcogsByKpsId() {
//        return metaEEcogsByKpsId;
//    }
//
//    public void setMetaEEcogsByKpsId(Collection<MetaEEcog> metaEEcogsByKpsId) {
//        this.metaEEcogsByKpsId = metaEEcogsByKpsId;
//    }
}
