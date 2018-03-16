package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_emr_subtype", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_emr_subtype_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEEmrSubtype {
    private Integer emrSubType;
    private String emrSubTypeName;
    private Integer emrType;
    private Integer enableFlag;
    private String remark;
    private Timestamp createTime;
//    private Collection<EMedicalRecord> eMedicalRecordsByEmrSubType;
//    private MetaEEmrType metaEEmrTypeByEmrType;

    @Id
    @Column(name = "emrSubType", nullable = false)
    public Integer getEmrSubType() {
        return emrSubType;
    }

    public void setEmrSubType(Integer emrSubType) {
        this.emrSubType = emrSubType;
    }

    @Basic
    @Column(name = "emrSubTypeName", nullable = false, length = 100)
    public String getEmrSubTypeName() {
        return emrSubTypeName;
    }

    public void setEmrSubTypeName(String emrSubTypeName) {
        this.emrSubTypeName = emrSubTypeName;
    }

    @Basic
    @Column(name = "emrType", nullable = false)
    public Integer getEmrType() {
        return emrType;
    }

    public void setEmrType(Integer emrType) {
        this.emrType = emrType;
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
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

        MetaEEmrSubtype that = (MetaEEmrSubtype) o;

        if (emrSubType != null ? !emrSubType.equals(that.emrSubType) : that.emrSubType != null) return false;
        if (emrSubTypeName != null ? !emrSubTypeName.equals(that.emrSubTypeName) : that.emrSubTypeName != null)
            return false;
        if (emrType != null ? !emrType.equals(that.emrType) : that.emrType != null) return false;
        if (enableFlag != null ? !enableFlag.equals(that.enableFlag) : that.enableFlag != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emrSubType != null ? emrSubType.hashCode() : 0;
        result = 31 * result + (emrSubTypeName != null ? emrSubTypeName.hashCode() : 0);
        result = 31 * result + (emrType != null ? emrType.hashCode() : 0);
        result = 31 * result + (enableFlag != null ? enableFlag.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaEEmrSubtypeByEmrSubType")
//    public Collection<EMedicalRecord> geteMedicalRecordsByEmrSubType() {
//        return eMedicalRecordsByEmrSubType;
//    }
//
//    public void seteMedicalRecordsByEmrSubType(Collection<EMedicalRecord> eMedicalRecordsByEmrSubType) {
//        this.eMedicalRecordsByEmrSubType = eMedicalRecordsByEmrSubType;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "emrType", referencedColumnName = "emrType", nullable = false)
//    public MetaEEmrType getMetaEEmrTypeByEmrType() {
//        return metaEEmrTypeByEmrType;
//    }
//
//    public void setMetaEEmrTypeByEmrType(MetaEEmrType metaEEmrTypeByEmrType) {
//        this.metaEEmrTypeByEmrType = metaEEmrTypeByEmrType;
//    }
}
