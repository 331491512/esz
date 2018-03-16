package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_c_disease_keyword_match", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_c_disease_keyword_match_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaCDiseaseKeywordMatch {
    private Integer diseaseMatchId;
    private String keyword;
    private Integer parentid;
    private String eszCode;
    private Integer diseaseTypeId;
    private Long priorityLevel;
    private Integer retrievalLevel;
    private String remark;
    private Timestamp createTime;

    @Id
    @Column(name = "diseaseMatchId", nullable = false)
    public Integer getDiseaseMatchId() {
        return diseaseMatchId;
    }

    public void setDiseaseMatchId(Integer diseaseMatchId) {
        this.diseaseMatchId = diseaseMatchId;
    }

    @Basic
    @Column(name = "keyword", nullable = false, length = 64)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "parentid", nullable = false)
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Basic
    @Column(name = "eszCode", nullable = true, length = 32)
    public String getEszCode() {
        return eszCode;
    }

    public void setEszCode(String eszCode) {
        this.eszCode = eszCode;
    }

    @Basic
    @Column(name = "diseaseTypeId", nullable = true)
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "priorityLevel", nullable = false)
    public Long getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Long priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Basic
    @Column(name = "retrievalLevel", nullable = false)
    public Integer getRetrievalLevel() {
        return retrievalLevel;
    }

    public void setRetrievalLevel(Integer retrievalLevel) {
        this.retrievalLevel = retrievalLevel;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 128)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
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

        MetaCDiseaseKeywordMatch that = (MetaCDiseaseKeywordMatch) o;

        if (diseaseMatchId != null ? !diseaseMatchId.equals(that.diseaseMatchId) : that.diseaseMatchId != null)
            return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (parentid != null ? !parentid.equals(that.parentid) : that.parentid != null) return false;
        if (eszCode != null ? !eszCode.equals(that.eszCode) : that.eszCode != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (priorityLevel != null ? !priorityLevel.equals(that.priorityLevel) : that.priorityLevel != null)
            return false;
        if (retrievalLevel != null ? !retrievalLevel.equals(that.retrievalLevel) : that.retrievalLevel != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diseaseMatchId != null ? diseaseMatchId.hashCode() : 0;
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (parentid != null ? parentid.hashCode() : 0);
        result = 31 * result + (eszCode != null ? eszCode.hashCode() : 0);
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (priorityLevel != null ? priorityLevel.hashCode() : 0);
        result = 31 * result + (retrievalLevel != null ? retrievalLevel.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
