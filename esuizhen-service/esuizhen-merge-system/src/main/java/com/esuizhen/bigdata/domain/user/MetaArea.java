package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_area", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_area_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaArea {
    private int areaId;
    private String areaName;
//    private Collection<MetaProvince> metaProvincesByAreaId;

    @Id
    @Column(name = "areaId", nullable = false)
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "areaName", nullable = false, length = 50)
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

        MetaArea metaArea = (MetaArea) o;

        if (areaId != metaArea.areaId) return false;
        if (areaName != null ? !areaName.equals(metaArea.areaName) : metaArea.areaName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = areaId;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "metaAreaByAreaId")
//    public Collection<MetaProvince> getMetaProvincesByAreaId() {
//        return metaProvincesByAreaId;
//    }
//
//    public void setMetaProvincesByAreaId(Collection<MetaProvince> metaProvincesByAreaId) {
//        this.metaProvincesByAreaId = metaProvincesByAreaId;
//    }
}
