package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_position_title", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_position_title_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaPositionTitle {
    private int positionTitleId;
    private String positionTitleName;

    @Id
    @Column(name = "positionTitleId", nullable = false)
    public int getPositionTitleId() {
        return positionTitleId;
    }

    public void setPositionTitleId(int positionTitleId) {
        this.positionTitleId = positionTitleId;
    }

    @Basic
    @Column(name = "positionTitleName", nullable = false, length = 50)
    public String getPositionTitleName() {
        return positionTitleName;
    }

    public void setPositionTitleName(String positionTitleName) {
        this.positionTitleName = positionTitleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaPositionTitle that = (MetaPositionTitle) o;

        if (positionTitleId != that.positionTitleId) return false;
        if (positionTitleName != null ? !positionTitleName.equals(that.positionTitleName) : that.positionTitleName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionTitleId;
        result = 31 * result + (positionTitleName != null ? positionTitleName.hashCode() : 0);
        return result;
    }
}
