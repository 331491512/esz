package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "map_meta_relation", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "map_meta_relation_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MapMetaRelation {
    private int id;
    private int oRelationId;
    private String oRelationName;
    private Integer tRelationId;
    private String tRelationName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "oRelationId", nullable = false)
    public int getoRelationId() {
        return oRelationId;
    }

    public void setoRelationId(int oRelationId) {
        this.oRelationId = oRelationId;
    }

    @Basic
    @Column(name = "oRelationName", nullable = true, length = 64)
    public String getoRelationName() {
        return oRelationName;
    }

    public void setoRelationName(String oRelationName) {
        this.oRelationName = oRelationName;
    }

    @Basic
    @Column(name = "tRelationId", nullable = true)
    public Integer gettRelationId() {
        return tRelationId;
    }

    public void settRelationId(Integer tRelationId) {
        this.tRelationId = tRelationId;
    }

    @Basic
    @Column(name = "tRelationName", nullable = true, length = 64)
    public String gettRelationName() {
        return tRelationName;
    }

    public void settRelationName(String tRelationName) {
        this.tRelationName = tRelationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapMetaRelation that = (MapMetaRelation) o;

        if (id != that.id) return false;
        if (oRelationId != that.oRelationId) return false;
        if (oRelationName != null ? !oRelationName.equals(that.oRelationName) : that.oRelationName != null)
            return false;
        if (tRelationId != null ? !tRelationId.equals(that.tRelationId) : that.tRelationId != null) return false;
        if (tRelationName != null ? !tRelationName.equals(that.tRelationName) : that.tRelationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + oRelationId;
        result = 31 * result + (oRelationName != null ? oRelationName.hashCode() : 0);
        result = 31 * result + (tRelationId != null ? tRelationId.hashCode() : 0);
        result = 31 * result + (tRelationName != null ? tRelationName.hashCode() : 0);
        return result;
    }
}
