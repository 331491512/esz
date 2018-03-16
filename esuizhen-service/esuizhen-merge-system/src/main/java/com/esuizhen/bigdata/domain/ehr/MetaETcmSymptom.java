package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_tcm_symptom", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_tcm_symptom_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaETcmSymptom {
    private Integer tcmSymptomId;
    private String diseaseCode;
    private String tcmSymptomName;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "tcmSymptomId", nullable = false)
    public Integer getTcmSymptomId() {
        return tcmSymptomId;
    }

    public void setTcmSymptomId(Integer tcmSymptomId) {
        this.tcmSymptomId = tcmSymptomId;
    }

    @Basic
    @Column(name = "diseaseCode", nullable = true, length = 30)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "tcmSymptomName", nullable = false, length = 100)
    public String getTcmSymptomName() {
        return tcmSymptomName;
    }

    public void setTcmSymptomName(String tcmSymptomName) {
        this.tcmSymptomName = tcmSymptomName;
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
    @Column(name = "creator", nullable = false)
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaETcmSymptom that = (MetaETcmSymptom) o;

        if (tcmSymptomId != null ? !tcmSymptomId.equals(that.tcmSymptomId) : that.tcmSymptomId != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (tcmSymptomName != null ? !tcmSymptomName.equals(that.tcmSymptomName) : that.tcmSymptomName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tcmSymptomId != null ? tcmSymptomId.hashCode() : 0;
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (tcmSymptomName != null ? tcmSymptomName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
