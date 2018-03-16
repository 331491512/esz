package com.esuizhen.bigdata.domain.followup;


import javax.persistence.*;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "meta_followup_result_value", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "meta_followup_result_value_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class MetaFollowupResultValue {
    //`followupResultValueId` int(11) NOT NULL COMMENT '随访结果类型ID。主键。',
    //       `followupResultValueName` varchar(100) NOT NULL COMMENT '随访结果类型名称',
    //       `type` int(11) NOT NULL DEFAULT '1' COMMENT '结果类型。1: 有效结果；2：无效结果',

    private Integer followupResultValueId;
    private String followupResultValueName;
    private int type;
//    private Collection<FollowupResult> followupResultsByFollowupResultValueId;
//    private Collection<FollowupResultBuff> followupResultBuffsByFollowupResultValueId;

    @Id
    @Column(name = "followupResultValueId", nullable = false)
    public Integer getFollowupResultValueId() {
        return followupResultValueId;
    }

    public void setFollowupResultValueId(Integer followupResultValueId) {
        this.followupResultValueId = followupResultValueId;
    }

    @Basic
    @Column(name = "followupResultValueName", nullable = false, length = 100)
    public String getFollowupResultValueName() {
        return followupResultValueName;
    }

    public void setFollowupResultValueName(String followupResultValueName) {
        this.followupResultValueName = followupResultValueName;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaFollowupResultValue that = (MetaFollowupResultValue) o;

        if (followupResultValueId != that.followupResultValueId) return false;
        if (type != that.type) return false;
        if (followupResultValueName != null ? !followupResultValueName.equals(that.followupResultValueName) : that.followupResultValueName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupResultValueId;
        result = 31 * result + (followupResultValueName != null ? followupResultValueName.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }

//    @OneToMany(mappedBy = "metaFollowupResultValueByFollowupResultValue")
//    public Collection<FollowupResult> getFollowupResultsByFollowupResultValueId() {
//        return followupResultsByFollowupResultValueId;
//    }
//
//    public void setFollowupResultsByFollowupResultValueId(Collection<FollowupResult> followupResultsByFollowupResultValueId) {
//        this.followupResultsByFollowupResultValueId = followupResultsByFollowupResultValueId;
//    }
//
//    @OneToMany(mappedBy = "metaFollowupResultValueByFollowupResultValue")
//    public Collection<FollowupResultBuff> getFollowupResultBuffsByFollowupResultValueId() {
//        return followupResultBuffsByFollowupResultValueId;
//    }
//
//    public void setFollowupResultBuffsByFollowupResultValueId(Collection<FollowupResultBuff> followupResultBuffsByFollowupResultValueId) {
//        this.followupResultBuffsByFollowupResultValueId = followupResultBuffsByFollowupResultValueId;
//    }
}
