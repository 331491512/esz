package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_anesthesia_way", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_anesthesia_way_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEAnesthesiaWay {
    private Integer anesthesiaId;
    private String anesthesiaCode;
    private String anesthesiaName;

    @Id
    @Column(name = "anesthesiaId", nullable = false)
    public Integer getAnesthesiaId() {
        return anesthesiaId;
    }

    public void setAnesthesiaId(Integer anesthesiaId) {
        this.anesthesiaId = anesthesiaId;
    }

    @Basic
    @Column(name = "anesthesiaCode", nullable = true, length = 32)
    public String getAnesthesiaCode() {
        return anesthesiaCode;
    }

    public void setAnesthesiaCode(String anesthesiaCode) {
        this.anesthesiaCode = anesthesiaCode;
    }

    @Basic
    @Column(name = "anesthesiaName", nullable = true, length = 64)
    public String getAnesthesiaName() {
        return anesthesiaName;
    }

    public void setAnesthesiaName(String anesthesiaName) {
        this.anesthesiaName = anesthesiaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEAnesthesiaWay that = (MetaEAnesthesiaWay) o;

        if (anesthesiaId != null ? !anesthesiaId.equals(that.anesthesiaId) : that.anesthesiaId != null) return false;
        if (anesthesiaCode != null ? !anesthesiaCode.equals(that.anesthesiaCode) : that.anesthesiaCode != null)
            return false;
        if (anesthesiaName != null ? !anesthesiaName.equals(that.anesthesiaName) : that.anesthesiaName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = anesthesiaId != null ? anesthesiaId.hashCode() : 0;
        result = 31 * result + (anesthesiaCode != null ? anesthesiaCode.hashCode() : 0);
        result = 31 * result + (anesthesiaName != null ? anesthesiaName.hashCode() : 0);
        return result;
    }
}
