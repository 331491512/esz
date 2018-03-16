package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_icd_10", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_icd_10_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEIcd10 {
    private String diseaseCode;
    private String diseaseName;
    private Integer sexLimit;
    private String curativeEffect;
    private String helpRememberCode;
    private Timestamp createtime;

    @Id
    @Column(name = "diseaseCode", nullable = false, length = 30)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "diseaseName", nullable = false, length = 100)
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Basic
    @Column(name = "sexLimit", nullable = true)
    public Integer getSexLimit() {
        return sexLimit;
    }

    public void setSexLimit(Integer sexLimit) {
        this.sexLimit = sexLimit;
    }

    @Basic
    @Column(name = "curativeEffect", nullable = true, length = 100)
    public String getCurativeEffect() {
        return curativeEffect;
    }

    public void setCurativeEffect(String curativeEffect) {
        this.curativeEffect = curativeEffect;
    }

    @Basic
    @Column(name = "helpRememberCode", nullable = true, length = 20)
    public String getHelpRememberCode() {
        return helpRememberCode;
    }

    public void setHelpRememberCode(String helpRememberCode) {
        this.helpRememberCode = helpRememberCode;
    }

    @Basic
    @Column(name = "createtime", nullable = true)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEIcd10 that = (MetaEIcd10) o;

        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (diseaseName != null ? !diseaseName.equals(that.diseaseName) : that.diseaseName != null) return false;
        if (sexLimit != null ? !sexLimit.equals(that.sexLimit) : that.sexLimit != null) return false;
        if (curativeEffect != null ? !curativeEffect.equals(that.curativeEffect) : that.curativeEffect != null)
            return false;
        if (helpRememberCode != null ? !helpRememberCode.equals(that.helpRememberCode) : that.helpRememberCode != null)
            return false;
        if (createtime != null ? !createtime.equals(that.createtime) : that.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diseaseCode != null ? diseaseCode.hashCode() : 0;
        result = 31 * result + (diseaseName != null ? diseaseName.hashCode() : 0);
        result = 31 * result + (sexLimit != null ? sexLimit.hashCode() : 0);
        result = 31 * result + (curativeEffect != null ? curativeEffect.hashCode() : 0);
        result = 31 * result + (helpRememberCode != null ? helpRememberCode.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
