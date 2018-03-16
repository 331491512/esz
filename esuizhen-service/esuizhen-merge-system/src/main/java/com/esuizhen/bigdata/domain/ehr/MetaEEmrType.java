package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_emr_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_emr_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEEmrType {
    private Integer emrType;
    private String emrTypeName;
    private Integer enableFlag;
    private Timestamp createTime;
//    private Collection<EMedicalRecord> eMedicalRecordsByEmrType;
//    private Collection<MetaEEmrSubtype> metaEEmrSubtypesByEmrType;

    @Id
    @Column(name = "emrType", nullable = false)
    public Integer getEmrType() {
        return emrType;
    }

    public void setEmrType(Integer emrType) {
        this.emrType = emrType;
    }

    @Basic
    @Column(name = "emrTypeName", nullable = false, length = 100)
    public String getEmrTypeName() {
        return emrTypeName;
    }

    public void setEmrTypeName(String emrTypeName) {
        this.emrTypeName = emrTypeName;
    }

    @Basic
    @Column(name = "enableFlag", nullable = false)
    public Integer getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Integer enableFlag) {
        this.enableFlag = enableFlag;
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

        MetaEEmrType that = (MetaEEmrType) o;

        if (emrType != null ? !emrType.equals(that.emrType) : that.emrType != null) return false;
        if (emrTypeName != null ? !emrTypeName.equals(that.emrTypeName) : that.emrTypeName != null) return false;
        if (enableFlag != null ? !enableFlag.equals(that.enableFlag) : that.enableFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emrType != null ? emrType.hashCode() : 0;
        result = 31 * result + (emrTypeName != null ? emrTypeName.hashCode() : 0);
        result = 31 * result + (enableFlag != null ? enableFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEEmrTypeByEmrType")
//    public Collection<EMedicalRecord> geteMedicalRecordsByEmrType() {
//        return eMedicalRecordsByEmrType;
//    }
//
//    public void seteMedicalRecordsByEmrType(Collection<EMedicalRecord> eMedicalRecordsByEmrType) {
//        this.eMedicalRecordsByEmrType = eMedicalRecordsByEmrType;
//    }
//
//    @OneToMany(mappedBy = "metaEEmrTypeByEmrType")
//    public Collection<MetaEEmrSubtype> getMetaEEmrSubtypesByEmrType() {
//        return metaEEmrSubtypesByEmrType;
//    }
//
//    public void setMetaEEmrSubtypesByEmrType(Collection<MetaEEmrSubtype> metaEEmrSubtypesByEmrType) {
//        this.metaEEmrSubtypesByEmrType = metaEEmrSubtypesByEmrType;
//    }
}
