package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "meta_phone_home", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "meta_phone_home_audit",schema = "user_db_audit",catalog = "user_db_audit")
public class MetaPhoneHome {
    private int id;
    private String prefix;
    private String phone;
    private String province;
    private String city;
    private String isp;
    private String code;
    private String zip;
    private String types;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prefix", nullable = true, length = 5)
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 10)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 20)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "isp", nullable = true, length = 20)
    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "zip", nullable = true, length = 20)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "types", nullable = true, length = 32)
    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaPhoneHome that = (MetaPhoneHome) o;

        if (id != that.id) return false;
        if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (isp != null ? !isp.equals(that.isp) : that.isp != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (types != null ? !types.equals(that.types) : that.types != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (isp != null ? isp.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (types != null ? types.hashCode() : 0);
        return result;
    }
}
