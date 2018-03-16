package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_city", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_city_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaCity {
    private int cityId;
    private String cityName;
    private Integer provinceId;
    private String cityCode;
//    private MetaProvince metaProvinceByProvinceId;

    @Id
    @Column(name = "cityId", nullable = false)
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "cityName", nullable = false, length = 100)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "provinceId", nullable = true )
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "cityCode", nullable = false, length = 20)
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaCity metaCity = (MetaCity) o;

        if (cityId != metaCity.cityId) return false;
        if (cityName != null ? !cityName.equals(metaCity.cityName) : metaCity.cityName != null) return false;
        if (provinceId != null ? !provinceId.equals(metaCity.provinceId) : metaCity.provinceId != null) return false;
        if (cityCode != null ? !cityCode.equals(metaCity.cityCode) : metaCity.cityCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "provinceId", referencedColumnName = "provinceId",insertable = false,updatable = false)
//    public MetaProvince getMetaProvinceByProvinceId() {
//        return metaProvinceByProvinceId;
//    }
//
//    public void setMetaProvinceByProvinceId(MetaProvince metaProvinceByProvinceId) {
//        this.metaProvinceByProvinceId = metaProvinceByProvinceId;
//    }
}
