package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_r_lis_detection_type", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_r_lis_detection_type_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaRLisDetectionType {
    private Integer id;
    private Integer rawDetectionTypeId;
    private String rawDetectionTypeName;
    private Integer detectionTypeId;
    private String detectionTypeName;
    private Integer hospitalId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rawDetectionTypeId", nullable = false)
    public Integer getRawDetectionTypeId() {
        return rawDetectionTypeId;
    }

    public void setRawDetectionTypeId(Integer rawDetectionTypeId) {
        this.rawDetectionTypeId = rawDetectionTypeId;
    }

    @Basic
    @Column(name = "rawDetectionTypeName", nullable = true, length = 255)
    public String getRawDetectionTypeName() {
        return rawDetectionTypeName;
    }

    public void setRawDetectionTypeName(String rawDetectionTypeName) {
        this.rawDetectionTypeName = rawDetectionTypeName;
    }

    @Basic
    @Column(name = "detectionTypeId", nullable = false)
    public Integer getDetectionTypeId() {
        return detectionTypeId;
    }

    public void setDetectionTypeId(Integer detectionTypeId) {
        this.detectionTypeId = detectionTypeId;
    }

    @Basic
    @Column(name = "detectionTypeName", nullable = true, length = 255)
    public String getDetectionTypeName() {
        return detectionTypeName;
    }

    public void setDetectionTypeName(String detectionTypeName) {
        this.detectionTypeName = detectionTypeName;
    }

    @Basic
    @Column(name = "hospitalId", nullable = true)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaRLisDetectionType that = (MetaRLisDetectionType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rawDetectionTypeId != null ? !rawDetectionTypeId.equals(that.rawDetectionTypeId) : that.rawDetectionTypeId != null)
            return false;
        if (rawDetectionTypeName != null ? !rawDetectionTypeName.equals(that.rawDetectionTypeName) : that.rawDetectionTypeName != null)
            return false;
        if (detectionTypeId != null ? !detectionTypeId.equals(that.detectionTypeId) : that.detectionTypeId != null)
            return false;
        if (detectionTypeName != null ? !detectionTypeName.equals(that.detectionTypeName) : that.detectionTypeName != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rawDetectionTypeId != null ? rawDetectionTypeId.hashCode() : 0);
        result = 31 * result + (rawDetectionTypeName != null ? rawDetectionTypeName.hashCode() : 0);
        result = 31 * result + (detectionTypeId != null ? detectionTypeId.hashCode() : 0);
        result = 31 * result + (detectionTypeName != null ? detectionTypeName.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        return result;
    }
}
