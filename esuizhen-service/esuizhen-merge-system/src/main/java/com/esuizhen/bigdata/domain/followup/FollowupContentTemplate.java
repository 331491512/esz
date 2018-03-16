package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_content_template", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_content_template_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupContentTemplate {
    private String contentTemplateId;
    private String contentTemplateName;
    private int contentTemplateType;
    private String content;
    private Integer needReply;
    private Integer author;
    private int isPublish;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String signature;
    private String siganature;
    private String autoReplyContent;
//    private Collection<RFollowupTaskContentTemplate> rFollowupTaskContentTemplatesByContentTemplateId;

    @Id
    @Column(name = "contentTemplateId", nullable = false, length = 24)
    public String getContentTemplateId() {
        return contentTemplateId;
    }

    public void setContentTemplateId(String contentTemplateId) {
        this.contentTemplateId = contentTemplateId;
    }

    @Basic
    @Column(name = "contentTemplateName", nullable = false, length = 100)
    public String getContentTemplateName() {
        return contentTemplateName;
    }

    public void setContentTemplateName(String contentTemplateName) {
        this.contentTemplateName = contentTemplateName;
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
    @Column(name = "content", nullable = false, length = 500)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "needReply", nullable = true)
    public Integer getNeedReply() {
        return needReply;
    }

    public void setNeedReply(Integer needReply) {
        this.needReply = needReply;
    }

    @Basic
    @Column(name = "author", nullable = true)
    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    @Basic
    @Column(name = "isPublish", nullable = false)
    public int getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(int isPublish) {
        this.isPublish = isPublish;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "signature", nullable = true, length = 100)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "siganature", nullable = true, length = 100)
    public String getSiganature() {
        return siganature;
    }

    public void setSiganature(String siganature) {
        this.siganature = siganature;
    }

    @Basic
    @Column(name = "autoReplyContent", nullable = true, length = 255)
    public String getAutoReplyContent() {
        return autoReplyContent;
    }

    public void setAutoReplyContent(String autoReplyContent) {
        this.autoReplyContent = autoReplyContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowupContentTemplate that = (FollowupContentTemplate) o;

        if (contentTemplateType != that.contentTemplateType) return false;
        if (isPublish != that.isPublish) return false;
        if (contentTemplateId != null ? !contentTemplateId.equals(that.contentTemplateId) : that.contentTemplateId != null)
            return false;
        if (contentTemplateName != null ? !contentTemplateName.equals(that.contentTemplateName) : that.contentTemplateName != null)
            return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (needReply != null ? !needReply.equals(that.needReply) : that.needReply != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
        if (siganature != null ? !siganature.equals(that.siganature) : that.siganature != null) return false;
        if (autoReplyContent != null ? !autoReplyContent.equals(that.autoReplyContent) : that.autoReplyContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentTemplateId != null ? contentTemplateId.hashCode() : 0;
        result = 31 * result + (contentTemplateName != null ? contentTemplateName.hashCode() : 0);
        result = 31 * result + contentTemplateType;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (needReply != null ? needReply.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + isPublish;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (siganature != null ? siganature.hashCode() : 0);
        result = 31 * result + (autoReplyContent != null ? autoReplyContent.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "followupContentTemplateByContentTemplateId")
//    public Collection<RFollowupTaskContentTemplate> getrFollowupTaskContentTemplatesByContentTemplateId() {
//        return rFollowupTaskContentTemplatesByContentTemplateId;
//    }
//
//    public void setrFollowupTaskContentTemplatesByContentTemplateId(Collection<RFollowupTaskContentTemplate> rFollowupTaskContentTemplatesByContentTemplateId) {
//        this.rFollowupTaskContentTemplatesByContentTemplateId = rFollowupTaskContentTemplatesByContentTemplateId;
//    }
}
