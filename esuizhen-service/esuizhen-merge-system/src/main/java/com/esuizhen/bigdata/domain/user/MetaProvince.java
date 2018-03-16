package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_province", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_province_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaProvince {
    private int provinceId;
    private String provinceName;
    private int areaId;
    private String regionCode;
//    private Collection<MetaCity> metaCitiesByProvinceId;
//    private MetaArea metaAreaByAreaId;

    @Id
    @Column(name = "provinceId", nullable = false)
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "provinceName", nullable = false, length = 50)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Basic
    @Column(name = "areaId", nullable = false)
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "regionCode", nullable = false, length = 20)
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaProvince that = (MetaProvince) o;

        if (provinceId != that.provinceId) return false;
        if (areaId != that.areaId) return false;
        if (provinceName != null ? !provinceName.equals(that.provinceName) : that.provinceName != null) return false;
        if (regionCode != null ? !regionCode.equals(that.regionCode) : that.regionCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = provinceId;
        result = 31 * result + (provinceName != null ? provinceName.hashCode() : 0);
        result = 31 * result + areaId;
        result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaProvinceByProvinceId")
//    public Collection<MetaCity> getMetaCitiesByProvinceId() {
//        return metaCitiesByProvinceId;
//    }
//
//    public void setMetaCitiesByProvinceId(Collection<MetaCity> metaCitiesByProvinceId) {
//        this.metaCitiesByProvinceId = metaCitiesByProvinceId;
//    }

//    @ManyToOne
//    @JoinColumn(name = "areaId", referencedColumnName = "areaId", nullable = false, insertable = false, updatable = false)
//    public MetaArea getMetaAreaByAreaId() {
//        return metaAreaByAreaId;
//    }
//
//    public void setMetaAreaByAreaId(MetaArea metaAreaByAreaId) {
//        this.metaAreaByAreaId = metaAreaByAreaId;
//    }
}
