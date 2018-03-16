package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_doctor_tag", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_doctor_tag_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaDoctorTag {
    @Id
    private int tagId;
    private String tagName;

    @Basic
    @Column(name = "tagId", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "tagName", nullable = false, length = 100)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaDoctorTag that = (MetaDoctorTag) o;

        if (tagId != that.tagId) return false;
        if (tagName != null ? !tagName.equals(that.tagName) : that.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }
}
