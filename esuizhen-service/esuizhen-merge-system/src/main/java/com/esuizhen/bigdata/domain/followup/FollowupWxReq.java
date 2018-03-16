package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "followup_wx_req", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "followup_wx_req_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class FollowupWxReq {
    private long reqId;
    private String followupTaskId;
    private String followupAssignId;
    private Long patientId;
    private String templateId;
    private int hospitalId;
    private Timestamp sendTime;
    private String openId;
    private String messageId;
    private String trueName;
    private int state;
    private Integer replyState;
    private Integer resultProcessState;
    private String followupResultId;
    private String followupResultBuffId;
    private String signature;
    private String content;
    private String replyContent;
    private Timestamp replyTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    @Basic
    @Column(name = "mergeFlag", nullable = true)
    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    @Basic
    @Column(name = "mergeFrom", nullable = true)
    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    @Basic
    @Column(name = "mergeTarget", nullable = true)
    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Id
    @Column(name = "reqId", nullable = false)
    @GeneratedValue
    public long getReqId() {
        return reqId;
    }

    public void setReqId(long reqId) {
        this.reqId = reqId;
    }

    @Basic
    @Column(name = "followupTaskId", nullable = true, length = 128)
    public String getFollowupTaskId() {
        return followupTaskId;
    }

    public void setFollowupTaskId(String followupTaskId) {
        this.followupTaskId = followupTaskId;
    }

    @Basic
    @Column(name = "followupAssignId", nullable = true, length = 128)
    public String getFollowupAssignId() {
        return followupAssignId;
    }

    public void setFollowupAssignId(String followupAssignId) {
        this.followupAssignId = followupAssignId;
    }

    @Basic
    @Column(name = "patientId", nullable = true)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "templateId", nullable = true, length = 50)
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "hospitalId", nullable = false)
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "sendTime", nullable = true)
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "openId", nullable = false, length = 50)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "messageId", nullable = false, length = 50)
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "trueName", nullable = false, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "replyState", nullable = true)
    public Integer getReplyState() {
        return replyState;
    }

    public void setReplyState(Integer replyState) {
        this.replyState = replyState;
    }

    @Basic
    @Column(name = "resultProcessState", nullable = true)
    public Integer getResultProcessState() {
        return resultProcessState;
    }

    public void setResultProcessState(Integer resultProcessState) {
        this.resultProcessState = resultProcessState;
    }

    @Basic
    @Column(name = "followupResultId", nullable = true, length = 50)
    public String getFollowupResultId() {
        return followupResultId;
    }

    public void setFollowupResultId(String followupResultId) {
        this.followupResultId = followupResultId;
    }

    @Basic
    @Column(name = "followupResultBuffId", nullable = true, length = 60)
    public String getFollowupResultBuffId() {
        return followupResultBuffId;
    }

    public void setFollowupResultBuffId(String followupResultBuffId) {
        this.followupResultBuffId = followupResultBuffId;
    }

    @Basic
    @Column(name = "signature", nullable = true, length = 255)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 512)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "replyContent", nullable = true, length = 512)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "replyTime", nullable = true)
    public Timestamp getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Timestamp replyTime) {
        this.replyTime = replyTime;
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

        FollowupWxReq that = (FollowupWxReq) o;

        if (reqId != that.reqId) return false;
        if (hospitalId != that.hospitalId) return false;
        if (state != that.state) return false;
        if (followupTaskId != null ? !followupTaskId.equals(that.followupTaskId) : that.followupTaskId != null)
            return false;
        if (followupAssignId != null ? !followupAssignId.equals(that.followupAssignId) : that.followupAssignId != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (templateId != null ? !templateId.equals(that.templateId) : that.templateId != null) return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        if (replyState != null ? !replyState.equals(that.replyState) : that.replyState != null) return false;
        if (resultProcessState != null ? !resultProcessState.equals(that.resultProcessState) : that.resultProcessState != null)
            return false;
        if (followupResultId != null ? !followupResultId.equals(that.followupResultId) : that.followupResultId != null)
            return false;
        if (followupResultBuffId != null ? !followupResultBuffId.equals(that.followupResultBuffId) : that.followupResultBuffId != null)
            return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
        if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reqId ^ (reqId >>> 32));
        result = 31 * result + (followupTaskId != null ? followupTaskId.hashCode() : 0);
        result = 31 * result + (followupAssignId != null ? followupAssignId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        result = 31 * result + hospitalId;
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        result = 31 * result + (openId != null ? openId.hashCode() : 0);
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (replyState != null ? replyState.hashCode() : 0);
        result = 31 * result + (resultProcessState != null ? resultProcessState.hashCode() : 0);
        result = 31 * result + (followupResultId != null ? followupResultId.hashCode() : 0);
        result = 31 * result + (followupResultBuffId != null ? followupResultBuffId.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
