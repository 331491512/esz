package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_clinic_symptom", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_clinic_symptom_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEClinicSymptom {
    private Integer symptomId;
    private String symptomName;
    private String slightDescription;
    private String mediumDescription;
    private String severeDescription;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "symptomId", nullable = false)
    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    @Basic
    @Column(name = "symptomName", nullable = false, length = 100)
    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    @Basic
    @Column(name = "slightDescription", nullable = true, length = 255)
    public String getSlightDescription() {
        return slightDescription;
    }

    public void setSlightDescription(String slightDescription) {
        this.slightDescription = slightDescription;
    }

    @Basic
    @Column(name = "mediumDescription", nullable = true, length = 255)
    public String getMediumDescription() {
        return mediumDescription;
    }

    public void setMediumDescription(String mediumDescription) {
        this.mediumDescription = mediumDescription;
    }

    @Basic
    @Column(name = "severeDescription", nullable = true, length = 255)
    public String getSevereDescription() {
        return severeDescription;
    }

    public void setSevereDescription(String severeDescription) {
        this.severeDescription = severeDescription;
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

        MetaEClinicSymptom that = (MetaEClinicSymptom) o;

        if (symptomId != null ? !symptomId.equals(that.symptomId) : that.symptomId != null) return false;
        if (symptomName != null ? !symptomName.equals(that.symptomName) : that.symptomName != null) return false;
        if (slightDescription != null ? !slightDescription.equals(that.slightDescription) : that.slightDescription != null)
            return false;
        if (mediumDescription != null ? !mediumDescription.equals(that.mediumDescription) : that.mediumDescription != null)
            return false;
        if (severeDescription != null ? !severeDescription.equals(that.severeDescription) : that.severeDescription != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = symptomId != null ? symptomId.hashCode() : 0;
        result = 31 * result + (symptomName != null ? symptomName.hashCode() : 0);
        result = 31 * result + (slightDescription != null ? slightDescription.hashCode() : 0);
        result = 31 * result + (mediumDescription != null ? mediumDescription.hashCode() : 0);
        result = 31 * result + (severeDescription != null ? severeDescription.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
