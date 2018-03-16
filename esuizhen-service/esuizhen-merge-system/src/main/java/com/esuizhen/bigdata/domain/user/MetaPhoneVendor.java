package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_phone_vendor", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_phone_vendor_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaPhoneVendor {
    private int phoneVendorId;
    private String phoneVendorName;

    @Id
    @Column(name = "phoneVendorId", nullable = false)
    public int getPhoneVendorId() {
        return phoneVendorId;
    }

    public void setPhoneVendorId(int phoneVendorId) {
        this.phoneVendorId = phoneVendorId;
    }

    @Basic
    @Column(name = "phoneVendorName", nullable = false, length = 100)
    public String getPhoneVendorName() {
        return phoneVendorName;
    }

    public void setPhoneVendorName(String phoneVendorName) {
        this.phoneVendorName = phoneVendorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaPhoneVendor that = (MetaPhoneVendor) o;

        if (phoneVendorId != that.phoneVendorId) return false;
        if (phoneVendorName != null ? !phoneVendorName.equals(that.phoneVendorName) : that.phoneVendorName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phoneVendorId;
        result = 31 * result + (phoneVendorName != null ? phoneVendorName.hashCode() : 0);
        return result;
    }
}
