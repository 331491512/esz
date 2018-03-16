package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "meta_followup_way", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "meta_followup_way_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class MetaFollowupWay {
    private Integer followupWayId;
    private String followupWayName;
//    private Collection<FollowupResult> followupResultsByFollowupWayId;
//    private Collection<FollowupResultBuff> followupResultBuffsByFollowupWayId;

    @Id
    @Column(name = "followupWayId", nullable = false)
    public Integer getFollowupWayId() {
        return followupWayId;
    }

    public void setFollowupWayId(Integer followupWayId) {
        this.followupWayId = followupWayId;
    }

    @Basic
    @Column(name = "followupWayName", nullable = false, length = 100)
    public String getFollowupWayName() {
        return followupWayName;
    }

    public void setFollowupWayName(String followupWayName) {
        this.followupWayName = followupWayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaFollowupWay that = (MetaFollowupWay) o;

        if (followupWayId != that.followupWayId) return false;
        if (followupWayName != null ? !followupWayName.equals(that.followupWayName) : that.followupWayName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupWayId;
        result = 31 * result + (followupWayName != null ? followupWayName.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaFollowupWayByFollowupWay")
//    public Collection<FollowupResult> getFollowupResultsByFollowupWayId() {
//        return followupResultsByFollowupWayId;
//    }
//
//    public void setFollowupResultsByFollowupWayId(Collection<FollowupResult> followupResultsByFollowupWayId) {
//        this.followupResultsByFollowupWayId = followupResultsByFollowupWayId;
//    }
//
//    @OneToMany(mappedBy = "metaFollowupWayByFollowUpWay")
//    public Collection<FollowupResultBuff> getFollowupResultBuffsByFollowupWayId() {
//        return followupResultBuffsByFollowupWayId;
//    }
//
//    public void setFollowupResultBuffsByFollowupWayId(Collection<FollowupResultBuff> followupResultBuffsByFollowupWayId) {
//        this.followupResultBuffsByFollowupWayId = followupResultBuffsByFollowupWayId;
//    }
}
