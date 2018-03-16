package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "r_followup_task_content_template", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "r_followup_task_content_template_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class RFollowupTaskContentTemplate {
    private int id;
    private String followupTaskId;
    private String contentTemplateId;
    private int contentTemplateType;
    private Timestamp createTime;
//    private FollowupTask followupTaskByFollowupTaskId;
//    private FollowupContentTemplate followupContentTemplateByContentTemplateId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = false, length = 128)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "contentTemplateId", nullable = false, length = 32)
    public String getContentTemplateId() {
        return contentTemplateId;
    }

    public void setContentTemplateId(String contentTemplateId) {
        this.contentTemplateId = contentTemplateId;
    }

    @Basic
    @Column(name = "contentTemplateType", nullable = false)
    public int getContentTemplateType() {
        return contentTemplateType;
    }

    public void setContentTemplateType(int contentTemplateType) {
        this.contentTemplateType = contentTemplateType;
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

        RFollowupTaskContentTemplate that = (RFollowupTaskContentTemplate) o;

        if (id != that.id) return false;
        if (contentTemplateType != that.contentTemplateType) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (contentTemplateId != null ? !contentTemplateId.equals(that.contentTemplateId) : that.contentTemplateId != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (contentTemplateId != null ? contentTemplateId.hashCode() : 0);
        result = 31 * result + contentTemplateType;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "followupTaskId", referencedColumnName = "followupTaskId", nullable = false, insertable = false,updatable = false)
//    public FollowupTask getFollowupTaskByFollowupTaskId() {
//        return followupTaskByFollowupTaskId;
//    }
//
//    public void setFollowupTaskByFollowupTaskId(FollowupTask followupTaskByFollowupTaskId) {
//        this.followupTaskByFollowupTaskId = followupTaskByFollowupTaskId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "contentTemplateId", referencedColumnName = "contentTemplateId", nullable = false, insertable = false,updatable = false)
//    public FollowupContentTemplate getFollowupContentTemplateByContentTemplateId() {
//        return followupContentTemplateByContentTemplateId;
//    }
//
//    public void setFollowupContentTemplateByContentTemplateId(FollowupContentTemplate followupContentTemplateByContentTemplateId) {
//        this.followupContentTemplateByContentTemplateId = followupContentTemplateByContentTemplateId;
//    }
}
