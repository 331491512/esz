package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_county", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_county_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaCounty {
    private int countyId;
    private String countyCode;
    private String countyName;
    private String cityCode;
    private String cityName;
    private String provinceCode;
    private String provinceName;
    private Integer areaId;
    private String areaName;

    @Id
    @Column(name = "countyId", nullable = false)
    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    @Basic
    @Column(name = "countyCode", nullable = false, length = 20)
    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    @Basic
    @Column(name = "countyName", nullable = false, length = 100)
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Basic
    @Column(name = "cityCode", nullable = true, length = 20)
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "cityName", nullable = true, length = 100)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "provinceCode", nullable = true, length = 20)
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Basic
    @Column(name = "provinceName", nullable = true, length = 100)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Basic
    @Column(name = "areaId", nullable = true)
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "areaName", nullable = true, length = 50)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaCounty that = (MetaCounty) o;

        if (countyId != that.countyId) return false;
        if (countyCode != null ? !countyCode.equals(that.countyCode) : that.countyCode != null) return false;
        if (countyName != null ? !countyName.equals(that.countyName) : that.countyName != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (provinceCode != null ? !provinceCode.equals(that.provinceCode) : that.provinceCode != null) return false;
        if (provinceName != null ? !provinceName.equals(that.provinceName) : that.provinceName != null) return false;
        if (areaId != null ? !areaId.equals(that.areaId) : that.areaId != null) return false;
        if (areaName != null ? !areaName.equals(that.areaName) : that.areaName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countyId;
        result = 31 * result + (countyCode != null ? countyCode.hashCode() : 0);
        result = 31 * result + (countyName != null ? countyName.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (provinceCode != null ? provinceCode.hashCode() : 0);
        result = 31 * result + (provinceName != null ? provinceName.hashCode() : 0);
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        return result;
    }
}
