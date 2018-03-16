package com.esuizhen.bigdata.domain.ods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nidan on 2016年12月22 上午 10:08
 */
@Entity
@Table(name = "patient_survival", schema = "ods_db", catalog="")
public class TPatientSurvival {
    private long id;
    private long patientId;
    private Timestamp confirmedDate;
    private int diseaseTypeId;
    private Integer diseaseTypeId2;
    private Integer diseaseTypeId3;
    private Integer treatmentTypeSurgery;
    private Integer treatmentTypeChemo;
    private Integer treatmentTypeRadiation;
    private Integer treatmentTypeIntervention;
    private Integer treatmentTypeBiological;
    private Integer treatmentTypeEndocrine;
    private Integer treatmentTypeLaser;
    private Integer treatmentTypeTcm;
    private Integer treatmentTypeIsoTope;
    private Integer treatmentTypeAblation;
    private Integer treatmentTypeOther;
    private Integer treatmentTypeTargeted;
    private Integer survival3;
    private Integer survival6;
    private Integer survival9;
    private Integer survival12;
    private Integer survival15;
    private Integer survival18;
    private Integer survival21;
    private Integer survival24;
    private Integer survival27;
    private Integer survival30;
    private Integer survival33;
    private Integer survival36;
    private Integer survival39;
    private Integer survival42;
    private Integer survival45;
    private Integer survival48;
    private Integer survival51;
    private Integer survival54;
    private Integer survival57;
    private Integer survival60;
    private Integer survival72;
    private Integer survival84;
    private Integer survival96;
    private Integer survival108;
    private Integer survival120;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientId")
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "confirmedDate")
    public Timestamp getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Timestamp confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    @Basic
    @Column(name = "diseaseTypeId")
    public int getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(int diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    @Basic
    @Column(name = "diseaseTypeId2")
    public Integer getDiseaseTypeId2() {
        return diseaseTypeId2;
    }

    public void setDiseaseTypeId2(Integer diseaseTypeId2) {
        this.diseaseTypeId2 = diseaseTypeId2;
    }

    @Basic
    @Column(name = "diseaseTypeId3")
    public Integer getDiseaseTypeId3() {
        return diseaseTypeId3;
    }

    public void setDiseaseTypeId3(Integer diseaseTypeId3) {
        this.diseaseTypeId3 = diseaseTypeId3;
    }

    @Basic
    @Column(name = "treatmentTypeSurgery")
    public Integer getTreatmentTypeSurgery() {
        return treatmentTypeSurgery;
    }

    public void setTreatmentTypeSurgery(Integer treatmentTypeSurgery) {
        this.treatmentTypeSurgery = treatmentTypeSurgery;
    }

    @Basic
    @Column(name = "treatmentTypeChemo")
    public Integer getTreatmentTypeChemo() {
        return treatmentTypeChemo;
    }

    public void setTreatmentTypeChemo(Integer treatmentTypeChemo) {
        this.treatmentTypeChemo = treatmentTypeChemo;
    }

    @Basic
    @Column(name = "treatmentTypeRadiation")
    public Integer getTreatmentTypeRadiation() {
        return treatmentTypeRadiation;
    }

    public void setTreatmentTypeRadiation(Integer treatmentTypeRadiation) {
        this.treatmentTypeRadiation = treatmentTypeRadiation;
    }

    @Basic
    @Column(name = "treatmentTypeIntervention")
    public Integer getTreatmentTypeIntervention() {
        return treatmentTypeIntervention;
    }

    public void setTreatmentTypeIntervention(Integer treatmentTypeIntervention) {
        this.treatmentTypeIntervention = treatmentTypeIntervention;
    }

    @Basic
    @Column(name = "treatmentTypeBiological")
    public Integer getTreatmentTypeBiological() {
        return treatmentTypeBiological;
    }

    public void setTreatmentTypeBiological(Integer treatmentTypeBiological) {
        this.treatmentTypeBiological = treatmentTypeBiological;
    }

    @Basic
    @Column(name = "treatmentTypeEndocrine")
    public Integer getTreatmentTypeEndocrine() {
        return treatmentTypeEndocrine;
    }

    public void setTreatmentTypeEndocrine(Integer treatmentTypeEndocrine) {
        this.treatmentTypeEndocrine = treatmentTypeEndocrine;
    }

    @Basic
    @Column(name = "treatmentTypeLaser")
    public Integer getTreatmentTypeLaser() {
        return treatmentTypeLaser;
    }

    public void setTreatmentTypeLaser(Integer treatmentTypeLaser) {
        this.treatmentTypeLaser = treatmentTypeLaser;
    }

    @Basic
    @Column(name = "treatmentTypeTCM")
    public Integer getTreatmentTypeTcm() {
        return treatmentTypeTcm;
    }

    public void setTreatmentTypeTcm(Integer treatmentTypeTcm) {
        this.treatmentTypeTcm = treatmentTypeTcm;
    }

    @Basic
    @Column(name = "treatmentTypeIsoTope")
    public Integer getTreatmentTypeIsoTope() {
        return treatmentTypeIsoTope;
    }

    public void setTreatmentTypeIsoTope(Integer treatmentTypeIsoTope) {
        this.treatmentTypeIsoTope = treatmentTypeIsoTope;
    }

    @Basic
    @Column(name = "treatmentTypeAblation")
    public Integer getTreatmentTypeAblation() {
        return treatmentTypeAblation;
    }

    public void setTreatmentTypeAblation(Integer treatmentTypeAblation) {
        this.treatmentTypeAblation = treatmentTypeAblation;
    }

    @Basic
    @Column(name = "treatmentTypeOther")
    public Integer getTreatmentTypeOther() {
        return treatmentTypeOther;
    }

    public void setTreatmentTypeOther(Integer treatmentTypeOther) {
        this.treatmentTypeOther = treatmentTypeOther;
    }

    @Basic
    @Column(name = "treatmentTypeTargeted")
    public Integer getTreatmentTypeTargeted() {
        return treatmentTypeTargeted;
    }

    public void setTreatmentTypeTargeted(Integer treatmentTypeTargeted) {
        this.treatmentTypeTargeted = treatmentTypeTargeted;
    }

    @Basic
    @Column(name = "survival3")
    public Integer getSurvival3() {
        return survival3;
    }

    public void setSurvival3(Integer survival3) {
        this.survival3 = survival3;
    }

    @Basic
    @Column(name = "survival6")
    public Integer getSurvival6() {
        return survival6;
    }

    public void setSurvival6(Integer survival6) {
        this.survival6 = survival6;
    }

    @Basic
    @Column(name = "survival9")
    public Integer getSurvival9() {
        return survival9;
    }

    public void setSurvival9(Integer survival9) {
        this.survival9 = survival9;
    }

    @Basic
    @Column(name = "survival12")
    public Integer getSurvival12() {
        return survival12;
    }

    public void setSurvival12(Integer survival12) {
        this.survival12 = survival12;
    }

    @Basic
    @Column(name = "survival15")
    public Integer getSurvival15() {
        return survival15;
    }

    public void setSurvival15(Integer survival15) {
        this.survival15 = survival15;
    }

    @Basic
    @Column(name = "survival18")
    public Integer getSurvival18() {
        return survival18;
    }

    public void setSurvival18(Integer survival18) {
        this.survival18 = survival18;
    }

    @Basic
    @Column(name = "survival21")
    public Integer getSurvival21() {
        return survival21;
    }

    public void setSurvival21(Integer survival21) {
        this.survival21 = survival21;
    }

    @Basic
    @Column(name = "survival24")
    public Integer getSurvival24() {
        return survival24;
    }

    public void setSurvival24(Integer survival24) {
        this.survival24 = survival24;
    }

    @Basic
    @Column(name = "survival27")
    public Integer getSurvival27() {
        return survival27;
    }

    public void setSurvival27(Integer survival27) {
        this.survival27 = survival27;
    }

    @Basic
    @Column(name = "survival30")
    public Integer getSurvival30() {
        return survival30;
    }

    public void setSurvival30(Integer survival30) {
        this.survival30 = survival30;
    }

    @Basic
    @Column(name = "survival33")
    public Integer getSurvival33() {
        return survival33;
    }

    public void setSurvival33(Integer survival33) {
        this.survival33 = survival33;
    }

    @Basic
    @Column(name = "survival36")
    public Integer getSurvival36() {
        return survival36;
    }

    public void setSurvival36(Integer survival36) {
        this.survival36 = survival36;
    }

    @Basic
    @Column(name = "survival39")
    public Integer getSurvival39() {
        return survival39;
    }

    public void setSurvival39(Integer survival39) {
        this.survival39 = survival39;
    }

    @Basic
    @Column(name = "survival42")
    public Integer getSurvival42() {
        return survival42;
    }

    public void setSurvival42(Integer survival42) {
        this.survival42 = survival42;
    }

    @Basic
    @Column(name = "survival45")
    public Integer getSurvival45() {
        return survival45;
    }

    public void setSurvival45(Integer survival45) {
        this.survival45 = survival45;
    }

    @Basic
    @Column(name = "survival48")
    public Integer getSurvival48() {
        return survival48;
    }

    public void setSurvival48(Integer survival48) {
        this.survival48 = survival48;
    }

    @Basic
    @Column(name = "survival51")
    public Integer getSurvival51() {
        return survival51;
    }

    public void setSurvival51(Integer survival51) {
        this.survival51 = survival51;
    }

    @Basic
    @Column(name = "survival54")
    public Integer getSurvival54() {
        return survival54;
    }

    public void setSurvival54(Integer survival54) {
        this.survival54 = survival54;
    }

    @Basic
    @Column(name = "survival57")
    public Integer getSurvival57() {
        return survival57;
    }

    public void setSurvival57(Integer survival57) {
        this.survival57 = survival57;
    }

    @Basic
    @Column(name = "survival60")
    public Integer getSurvival60() {
        return survival60;
    }

    public void setSurvival60(Integer survival60) {
        this.survival60 = survival60;
    }

    @Basic
    @Column(name = "survival72")
    public Integer getSurvival72() {
        return survival72;
    }

    public void setSurvival72(Integer survival72) {
        this.survival72 = survival72;
    }

    @Basic
    @Column(name = "survival84")
    public Integer getSurvival84() {
        return survival84;
    }

    public void setSurvival84(Integer survival84) {
        this.survival84 = survival84;
    }

    @Basic
    @Column(name = "survival96")
    public Integer getSurvival96() {
        return survival96;
    }

    public void setSurvival96(Integer survival96) {
        this.survival96 = survival96;
    }

    @Basic
    @Column(name = "survival108")
    public Integer getSurvival108() {
        return survival108;
    }

    public void setSurvival108(Integer survival108) {
        this.survival108 = survival108;
    }

    @Basic
    @Column(name = "survival120")
    public Integer getSurvival120() {
        return survival120;
    }

    public void setSurvival120(Integer survival120) {
        this.survival120 = survival120;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPatientSurvival that = (TPatientSurvival) o;

        if (id != that.id) return false;
        if (patientId != that.patientId) return false;
        if (diseaseTypeId != that.diseaseTypeId) return false;
        if (confirmedDate != null ? !confirmedDate.equals(that.confirmedDate) : that.confirmedDate != null)
            return false;
        if (diseaseTypeId2 != null ? !diseaseTypeId2.equals(that.diseaseTypeId2) : that.diseaseTypeId2 != null)
            return false;
        if (diseaseTypeId3 != null ? !diseaseTypeId3.equals(that.diseaseTypeId3) : that.diseaseTypeId3 != null)
            return false;
        if (treatmentTypeSurgery != null ? !treatmentTypeSurgery.equals(that.treatmentTypeSurgery) : that.treatmentTypeSurgery != null)
            return false;
        if (treatmentTypeChemo != null ? !treatmentTypeChemo.equals(that.treatmentTypeChemo) : that.treatmentTypeChemo != null)
            return false;
        if (treatmentTypeRadiation != null ? !treatmentTypeRadiation.equals(that.treatmentTypeRadiation) : that.treatmentTypeRadiation != null)
            return false;
        if (treatmentTypeIntervention != null ? !treatmentTypeIntervention.equals(that.treatmentTypeIntervention) : that.treatmentTypeIntervention != null)
            return false;
        if (treatmentTypeBiological != null ? !treatmentTypeBiological.equals(that.treatmentTypeBiological) : that.treatmentTypeBiological != null)
            return false;
        if (treatmentTypeEndocrine != null ? !treatmentTypeEndocrine.equals(that.treatmentTypeEndocrine) : that.treatmentTypeEndocrine != null)
            return false;
        if (treatmentTypeLaser != null ? !treatmentTypeLaser.equals(that.treatmentTypeLaser) : that.treatmentTypeLaser != null)
            return false;
        if (treatmentTypeTcm != null ? !treatmentTypeTcm.equals(that.treatmentTypeTcm) : that.treatmentTypeTcm != null)
            return false;
        if (treatmentTypeIsoTope != null ? !treatmentTypeIsoTope.equals(that.treatmentTypeIsoTope) : that.treatmentTypeIsoTope != null)
            return false;
        if (treatmentTypeAblation != null ? !treatmentTypeAblation.equals(that.treatmentTypeAblation) : that.treatmentTypeAblation != null)
            return false;
        if (treatmentTypeOther != null ? !treatmentTypeOther.equals(that.treatmentTypeOther) : that.treatmentTypeOther != null)
            return false;
        if (treatmentTypeTargeted != null ? !treatmentTypeTargeted.equals(that.treatmentTypeTargeted) : that.treatmentTypeTargeted != null)
            return false;
        if (survival3 != null ? !survival3.equals(that.survival3) : that.survival3 != null) return false;
        if (survival6 != null ? !survival6.equals(that.survival6) : that.survival6 != null) return false;
        if (survival9 != null ? !survival9.equals(that.survival9) : that.survival9 != null) return false;
        if (survival12 != null ? !survival12.equals(that.survival12) : that.survival12 != null) return false;
        if (survival15 != null ? !survival15.equals(that.survival15) : that.survival15 != null) return false;
        if (survival18 != null ? !survival18.equals(that.survival18) : that.survival18 != null) return false;
        if (survival21 != null ? !survival21.equals(that.survival21) : that.survival21 != null) return false;
        if (survival24 != null ? !survival24.equals(that.survival24) : that.survival24 != null) return false;
        if (survival27 != null ? !survival27.equals(that.survival27) : that.survival27 != null) return false;
        if (survival30 != null ? !survival30.equals(that.survival30) : that.survival30 != null) return false;
        if (survival33 != null ? !survival33.equals(that.survival33) : that.survival33 != null) return false;
        if (survival36 != null ? !survival36.equals(that.survival36) : that.survival36 != null) return false;
        if (survival39 != null ? !survival39.equals(that.survival39) : that.survival39 != null) return false;
        if (survival42 != null ? !survival42.equals(that.survival42) : that.survival42 != null) return false;
        if (survival45 != null ? !survival45.equals(that.survival45) : that.survival45 != null) return false;
        if (survival48 != null ? !survival48.equals(that.survival48) : that.survival48 != null) return false;
        if (survival51 != null ? !survival51.equals(that.survival51) : that.survival51 != null) return false;
        if (survival54 != null ? !survival54.equals(that.survival54) : that.survival54 != null) return false;
        if (survival57 != null ? !survival57.equals(that.survival57) : that.survival57 != null) return false;
        if (survival60 != null ? !survival60.equals(that.survival60) : that.survival60 != null) return false;
        if (survival72 != null ? !survival72.equals(that.survival72) : that.survival72 != null) return false;
        if (survival84 != null ? !survival84.equals(that.survival84) : that.survival84 != null) return false;
        if (survival96 != null ? !survival96.equals(that.survival96) : that.survival96 != null) return false;
        if (survival108 != null ? !survival108.equals(that.survival108) : that.survival108 != null) return false;
        if (survival120 != null ? !survival120.equals(that.survival120) : that.survival120 != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (confirmedDate != null ? confirmedDate.hashCode() : 0);
        result = 31 * result + diseaseTypeId;
        result = 31 * result + (diseaseTypeId2 != null ? diseaseTypeId2.hashCode() : 0);
        result = 31 * result + (diseaseTypeId3 != null ? diseaseTypeId3.hashCode() : 0);
        result = 31 * result + (treatmentTypeSurgery != null ? treatmentTypeSurgery.hashCode() : 0);
        result = 31 * result + (treatmentTypeChemo != null ? treatmentTypeChemo.hashCode() : 0);
        result = 31 * result + (treatmentTypeRadiation != null ? treatmentTypeRadiation.hashCode() : 0);
        result = 31 * result + (treatmentTypeIntervention != null ? treatmentTypeIntervention.hashCode() : 0);
        result = 31 * result + (treatmentTypeBiological != null ? treatmentTypeBiological.hashCode() : 0);
        result = 31 * result + (treatmentTypeEndocrine != null ? treatmentTypeEndocrine.hashCode() : 0);
        result = 31 * result + (treatmentTypeLaser != null ? treatmentTypeLaser.hashCode() : 0);
        result = 31 * result + (treatmentTypeTcm != null ? treatmentTypeTcm.hashCode() : 0);
        result = 31 * result + (treatmentTypeIsoTope != null ? treatmentTypeIsoTope.hashCode() : 0);
        result = 31 * result + (treatmentTypeAblation != null ? treatmentTypeAblation.hashCode() : 0);
        result = 31 * result + (treatmentTypeOther != null ? treatmentTypeOther.hashCode() : 0);
        result = 31 * result + (treatmentTypeTargeted != null ? treatmentTypeTargeted.hashCode() : 0);
        result = 31 * result + (survival3 != null ? survival3.hashCode() : 0);
        result = 31 * result + (survival6 != null ? survival6.hashCode() : 0);
        result = 31 * result + (survival9 != null ? survival9.hashCode() : 0);
        result = 31 * result + (survival12 != null ? survival12.hashCode() : 0);
        result = 31 * result + (survival15 != null ? survival15.hashCode() : 0);
        result = 31 * result + (survival18 != null ? survival18.hashCode() : 0);
        result = 31 * result + (survival21 != null ? survival21.hashCode() : 0);
        result = 31 * result + (survival24 != null ? survival24.hashCode() : 0);
        result = 31 * result + (survival27 != null ? survival27.hashCode() : 0);
        result = 31 * result + (survival30 != null ? survival30.hashCode() : 0);
        result = 31 * result + (survival33 != null ? survival33.hashCode() : 0);
        result = 31 * result + (survival36 != null ? survival36.hashCode() : 0);
        result = 31 * result + (survival39 != null ? survival39.hashCode() : 0);
        result = 31 * result + (survival42 != null ? survival42.hashCode() : 0);
        result = 31 * result + (survival45 != null ? survival45.hashCode() : 0);
        result = 31 * result + (survival48 != null ? survival48.hashCode() : 0);
        result = 31 * result + (survival51 != null ? survival51.hashCode() : 0);
        result = 31 * result + (survival54 != null ? survival54.hashCode() : 0);
        result = 31 * result + (survival57 != null ? survival57.hashCode() : 0);
        result = 31 * result + (survival60 != null ? survival60.hashCode() : 0);
        result = 31 * result + (survival72 != null ? survival72.hashCode() : 0);
        result = 31 * result + (survival84 != null ? survival84.hashCode() : 0);
        result = 31 * result + (survival96 != null ? survival96.hashCode() : 0);
        result = 31 * result + (survival108 != null ? survival108.hashCode() : 0);
        result = 31 * result + (survival120 != null ? survival120.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
