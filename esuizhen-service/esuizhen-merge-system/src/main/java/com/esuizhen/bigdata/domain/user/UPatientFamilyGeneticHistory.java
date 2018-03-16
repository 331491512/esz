package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "u_patient_family_genetic_history", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "u_patient_family_genetic_history_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class UPatientFamilyGeneticHistory {
    private int geneticHistoryId;
    private String name;
    private int relationId;
    private String relationName;
    private int patientId;
    private Integer diseaseTypeId;
    private String diseaseTypeName;
    private String notTumorDiseaseHistory;
    private Integer liveState;
    private Timestamp deathTime;
    private Timestamp createTime;
    private Timestamp updateTime;
//    private MetaRelation metaRelationByRelationId;

    @Id
    @Column(name = "geneticHistoryId", nullable = false)
    public int getGeneticHistoryId() {
        return geneticHistoryId;
    }

    public void setGeneticHistoryId(int geneticHistoryId) {
        this.geneticHistoryId = geneticHistoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    //@Column(name = "relationId", nullable = false)
    @Column(name = "relationId", nullable = false)
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "relationName", nullable = true, length = 32)
    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
    @Column(name = "diseaseTypeName", nullable = true, length = 64)
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    @Basic
    @Column(name = "notTumorDiseaseHistory", nullable = true, length = 64)
    public String getNotTumorDiseaseHistory() {
        return notTumorDiseaseHistory;
    }

    public void setNotTumorDiseaseHistory(String notTumorDiseaseHistory) {
        this.notTumorDiseaseHistory = notTumorDiseaseHistory;
    }

    @Basic
    @Column(name = "liveState", nullable = true)
    public Integer getLiveState() {
        return liveState;
    }

    public void setLiveState(Integer liveState) {
        this.liveState = liveState;
    }

    @Basic
    @Column(name = "deathTime", nullable = true)
    public Timestamp getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Timestamp deathTime) {
        this.deathTime = deathTime;
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

        UPatientFamilyGeneticHistory that = (UPatientFamilyGeneticHistory) o;

        if (geneticHistoryId != that.geneticHistoryId) return false;
        if (relationId != that.relationId) return false;
        if (patientId != that.patientId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (relationName != null ? !relationName.equals(that.relationName) : that.relationName != null) return false;
        if (diseaseTypeId != null ? !diseaseTypeId.equals(that.diseaseTypeId) : that.diseaseTypeId != null)
            return false;
        if (diseaseTypeName != null ? !diseaseTypeName.equals(that.diseaseTypeName) : that.diseaseTypeName != null)
            return false;
        if (notTumorDiseaseHistory != null ? !notTumorDiseaseHistory.equals(that.notTumorDiseaseHistory) : that.notTumorDiseaseHistory != null)
            return false;
        if (liveState != null ? !liveState.equals(that.liveState) : that.liveState != null) return false;
        if (deathTime != null ? !deathTime.equals(that.deathTime) : that.deathTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geneticHistoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + relationId;
        result = 31 * result + (relationName != null ? relationName.hashCode() : 0);
        result = 31 * result + patientId;
        result = 31 * result + (diseaseTypeId != null ? diseaseTypeId.hashCode() : 0);
        result = 31 * result + (diseaseTypeName != null ? diseaseTypeName.hashCode() : 0);
        result = 31 * result + (notTumorDiseaseHistory != null ? notTumorDiseaseHistory.hashCode() : 0);
        result = 31 * result + (liveState != null ? liveState.hashCode() : 0);
        result = 31 * result + (deathTime != null ? deathTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "relationId", referencedColumnName = "relationId", nullable = false, insertable = false, updatable = false)
//    public MetaRelation getMetaRelationByRelationId() {
//        return metaRelationByRelationId;
//    }
//
//    public void setMetaRelationByRelationId(MetaRelation metaRelationByRelationId) {
//        this.metaRelationByRelationId = metaRelationByRelationId;
//    }
}
