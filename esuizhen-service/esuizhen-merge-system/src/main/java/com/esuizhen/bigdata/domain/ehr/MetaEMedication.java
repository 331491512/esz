package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "meta_e_medication", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "meta_e_medication_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class MetaEMedication {
    private Long medicationId;
    private String medicationCode;
    private Integer tumourFlag;
    private Integer medicationType;
    private Integer medicationClassId;
    private String medicationName;
    private String medicationEnglishName;
    private String commodityName;
    private String targetSpot;
    private String indication;
    private String computingMethod;
    private Integer computingMethodId;
    private Integer computingMethodId2;
    private Double theoreticalDose;
    private String measurementUnit;
    private String drugUsage;
    private String vendor;
    private Timestamp createTime;
    private Long creator;

    @Id
    @Column(name = "medicationId", nullable = false)
    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    @Basic
    @Column(name = "medicationCode", nullable = true, length = 30)
    public String getMedicationCode() {
        return medicationCode;
    }

    public void setMedicationCode(String medicationCode) {
        this.medicationCode = medicationCode;
    }

    @Basic
    @Column(name = "tumourFlag", nullable = false)
    public Integer getTumourFlag() {
        return tumourFlag;
    }

    public void setTumourFlag(Integer tumourFlag) {
        this.tumourFlag = tumourFlag;
    }

    @Basic
    @Column(name = "medicationType", nullable = false)
    public Integer getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(Integer medicationType) {
        this.medicationType = medicationType;
    }

    @Basic
    @Column(name = "medicationClassId", nullable = true)
    public Integer getMedicationClassId() {
        return medicationClassId;
    }

    public void setMedicationClassId(Integer medicationClassId) {
        this.medicationClassId = medicationClassId;
    }

    @Basic
    @Column(name = "medicationName", nullable = false, length = 255)
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    @Basic
    @Column(name = "medicationEnglishName", nullable = true, length = 255)
    public String getMedicationEnglishName() {
        return medicationEnglishName;
    }

    public void setMedicationEnglishName(String medicationEnglishName) {
        this.medicationEnglishName = medicationEnglishName;
    }

    @Basic
    @Column(name = "commodityName", nullable = true, length = 255)
    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    @Basic
    @Column(name = "targetSpot", nullable = true, length = 50)
    public String getTargetSpot() {
        return targetSpot;
    }

    public void setTargetSpot(String targetSpot) {
        this.targetSpot = targetSpot;
    }

    @Basic
    @Column(name = "indication", nullable = true, length = 50)
    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    @Basic
    @Column(name = "computingMethod", nullable = true, length = 30)
    public String getComputingMethod() {
        return computingMethod;
    }

    public void setComputingMethod(String computingMethod) {
        this.computingMethod = computingMethod;
    }

    @Basic
    @Column(name = "computingMethodId", nullable = true)
    public Integer getComputingMethodId() {
        return computingMethodId;
    }

    public void setComputingMethodId(Integer computingMethodId) {
        this.computingMethodId = computingMethodId;
    }

    @Basic
    @Column(name = "computingMethodId2", nullable = true)
    public Integer getComputingMethodId2() {
        return computingMethodId2;
    }

    public void setComputingMethodId2(Integer computingMethodId2) {
        this.computingMethodId2 = computingMethodId2;
    }

    @Basic
    @Column(name = "theoreticalDose", nullable = true, precision = 0)
    public Double getTheoreticalDose() {
        return theoreticalDose;
    }

    public void setTheoreticalDose(Double theoreticalDose) {
        this.theoreticalDose = theoreticalDose;
    }

    @Basic
    @Column(name = "measurementUnit", nullable = true, length = 30)
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Basic
    @Column(name = "drugUsage", nullable = true, length = 255)
    public String getDrugUsage() {
        return drugUsage;
    }

    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }

    @Basic
    @Column(name = "vendor", nullable = true, length = 100)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "creator", nullable = false)
    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaEMedication that = (MetaEMedication) o;

        if (medicationId != null ? !medicationId.equals(that.medicationId) : that.medicationId != null) return false;
        if (medicationCode != null ? !medicationCode.equals(that.medicationCode) : that.medicationCode != null)
            return false;
        if (tumourFlag != null ? !tumourFlag.equals(that.tumourFlag) : that.tumourFlag != null) return false;
        if (medicationType != null ? !medicationType.equals(that.medicationType) : that.medicationType != null)
            return false;
        if (medicationClassId != null ? !medicationClassId.equals(that.medicationClassId) : that.medicationClassId != null)
            return false;
        if (medicationName != null ? !medicationName.equals(that.medicationName) : that.medicationName != null)
            return false;
        if (medicationEnglishName != null ? !medicationEnglishName.equals(that.medicationEnglishName) : that.medicationEnglishName != null)
            return false;
        if (commodityName != null ? !commodityName.equals(that.commodityName) : that.commodityName != null)
            return false;
        if (targetSpot != null ? !targetSpot.equals(that.targetSpot) : that.targetSpot != null) return false;
        if (indication != null ? !indication.equals(that.indication) : that.indication != null) return false;
        if (computingMethod != null ? !computingMethod.equals(that.computingMethod) : that.computingMethod != null)
            return false;
        if (computingMethodId != null ? !computingMethodId.equals(that.computingMethodId) : that.computingMethodId != null)
            return false;
        if (computingMethodId2 != null ? !computingMethodId2.equals(that.computingMethodId2) : that.computingMethodId2 != null)
            return false;
        if (theoreticalDose != null ? !theoreticalDose.equals(that.theoreticalDose) : that.theoreticalDose != null)
            return false;
        if (measurementUnit != null ? !measurementUnit.equals(that.measurementUnit) : that.measurementUnit != null)
            return false;
        if (drugUsage != null ? !drugUsage.equals(that.drugUsage) : that.drugUsage != null) return false;
        if (vendor != null ? !vendor.equals(that.vendor) : that.vendor != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = medicationId != null ? medicationId.hashCode() : 0;
        result = 31 * result + (medicationCode != null ? medicationCode.hashCode() : 0);
        result = 31 * result + (tumourFlag != null ? tumourFlag.hashCode() : 0);
        result = 31 * result + (medicationType != null ? medicationType.hashCode() : 0);
        result = 31 * result + (medicationClassId != null ? medicationClassId.hashCode() : 0);
        result = 31 * result + (medicationName != null ? medicationName.hashCode() : 0);
        result = 31 * result + (medicationEnglishName != null ? medicationEnglishName.hashCode() : 0);
        result = 31 * result + (commodityName != null ? commodityName.hashCode() : 0);
        result = 31 * result + (targetSpot != null ? targetSpot.hashCode() : 0);
        result = 31 * result + (indication != null ? indication.hashCode() : 0);
        result = 31 * result + (computingMethod != null ? computingMethod.hashCode() : 0);
        result = 31 * result + (computingMethodId != null ? computingMethodId.hashCode() : 0);
        result = 31 * result + (computingMethodId2 != null ? computingMethodId2.hashCode() : 0);
        result = 31 * result + (theoreticalDose != null ? theoreticalDose.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        result = 31 * result + (drugUsage != null ? drugUsage.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }
}
