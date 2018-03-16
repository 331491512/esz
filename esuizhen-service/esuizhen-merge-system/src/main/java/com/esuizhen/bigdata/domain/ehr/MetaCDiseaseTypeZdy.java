package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_c_disease_type_zdy", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_c_disease_type_zdy_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaCDiseaseTypeZdy {
    private Integer id;
    private Integer hospitalId;
    private String zdyCode;
    private String diseaseCodePrefix;
    private Timestamp createTime;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hospitalId", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "zdyCode", nullable = false, length = 30)
    public String getZdyCode() {
        return zdyCode;
    }

    public void setZdyCode(String zdyCode) {
        this.zdyCode = zdyCode;
    }

    @Basic
    @Column(name = "diseaseCodePrefix", nullable = false, length = 30)
    public String getDiseaseCodePrefix() {
        return diseaseCodePrefix;
    }

    public void setDiseaseCodePrefix(String diseaseCodePrefix) {
        this.diseaseCodePrefix = diseaseCodePrefix;
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

        MetaCDiseaseTypeZdy that = (MetaCDiseaseTypeZdy) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (zdyCode != null ? !zdyCode.equals(that.zdyCode) : that.zdyCode != null) return false;
        if (diseaseCodePrefix != null ? !diseaseCodePrefix.equals(that.diseaseCodePrefix) : that.diseaseCodePrefix != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (zdyCode != null ? zdyCode.hashCode() : 0);
        result = 31 * result + (diseaseCodePrefix != null ? diseaseCodePrefix.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
