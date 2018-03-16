package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_resource", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_resource_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaResource {
    private int resourceId;
    private String resourceName;
    private String resourcePath;
    private String resourceDisplayName;
    private int resourceType;
    private Integer parentId;
    private String remark;

    @Id
    @Column(name = "resourceId", nullable = false)
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "resourceName", nullable = false, length = 100)
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "resourcePath", nullable = true, length = 255)
    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Basic
    @Column(name = "resourceDisplayName", nullable = false, length = 255)
    public String getResourceDisplayName() {
        return resourceDisplayName;
    }

    public void setResourceDisplayName(String resourceDisplayName) {
        this.resourceDisplayName = resourceDisplayName;
    }

    @Basic
    @Column(name = "resourceType", nullable = false)
    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    @Basic
    @Column(name = "parentId", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaResource that = (MetaResource) o;

        if (resourceId != that.resourceId) return false;
        if (resourceType != that.resourceType) return false;
        if (resourceName != null ? !resourceName.equals(that.resourceName) : that.resourceName != null) return false;
        if (resourcePath != null ? !resourcePath.equals(that.resourcePath) : that.resourcePath != null) return false;
        if (resourceDisplayName != null ? !resourceDisplayName.equals(that.resourceDisplayName) : that.resourceDisplayName != null)
            return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId;
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourcePath != null ? resourcePath.hashCode() : 0);
        result = 31 * result + (resourceDisplayName != null ? resourceDisplayName.hashCode() : 0);
        result = 31 * result + resourceType;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
