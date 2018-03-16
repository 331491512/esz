package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "conf_reply_parse_rules", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "conf_reply_parse_rules_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class ConfReplyParseRules {
    private int ruleId;
    private String replyContent;
    private int followupResultValueId;
    private String followupResultValueName;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "ruleId", nullable = false)
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    @Basic
    @Column(name = "replyContent", nullable = false, length = 255)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "followupResultValueId", nullable = false)
    public int getFollowupResultValueId() {
        return followupResultValueId;
    }

    public void setFollowupResultValueId(int followupResultValueId) {
        this.followupResultValueId = followupResultValueId;
    }

    @Basic
    @Column(name = "followupResultValueName", nullable = false, length = 255)
    public String getFollowupResultValueName() {
        return followupResultValueName;
    }

    public void setFollowupResultValueName(String followupResultValueName) {
        this.followupResultValueName = followupResultValueName;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfReplyParseRules that = (ConfReplyParseRules) o;

        if (ruleId != that.ruleId) return false;
        if (followupResultValueId != that.followupResultValueId) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
        if (followupResultValueName != null ? !followupResultValueName.equals(that.followupResultValueName) : that.followupResultValueName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ruleId;
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + followupResultValueId;
        result = 31 * result + (followupResultValueName != null ? followupResultValueName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
