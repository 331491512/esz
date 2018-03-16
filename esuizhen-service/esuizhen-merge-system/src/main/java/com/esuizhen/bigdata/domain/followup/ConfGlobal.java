package com.esuizhen.bigdata.domain.followup;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "conf_global", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "conf_global_audit", schema = "followup_db_audit", catalog = "followup_db_audit")
public class ConfGlobal {

    //private int id;

    //@Id
    //@Column(name = "id", nullable = false)
    //public int getId() {
    //    return id;
    //}
    //
    //public void setId(int id) {
    //    this.id = id;
    //}

    private int followupCycle;
    private int phoneResultMustConnectFlag;
    private Integer otherAsValidResultFlag;
    private Integer autoPatientNoPaddingFlag;
    private Integer autoPatientNoPaddingDigits;
    private Integer cancerFilterFlag;
    private String notMalignantTumorFlag;
    private Integer followupResultFlag;
    private Integer validResultControlFlag;
    private Integer diseaseTypeSelfDefineFlag;
    private Integer deathDateRequiredFlag;
    private Integer isOutsideCallAuth;
    private String outsideCallNum;
    private Integer isIpCall;
    private String ipCallNum;
    private Integer hospitalId;
    private String hospitalName;
    private Timestamp rolloutTime;
    private Timestamp deployTime;
    private Integer deployLocation;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Basic
    @Column(name = "followupCycle", nullable = false)
    public int getFollowupCycle() {
        return followupCycle;
    }

    public void setFollowupCycle(int followupCycle) {
        this.followupCycle = followupCycle;
    }

    @Basic
    @Column(name = "phoneResultMustConnectFlag", nullable = false)
    public int getPhoneResultMustConnectFlag() {
        return phoneResultMustConnectFlag;
    }

    public void setPhoneResultMustConnectFlag(int phoneResultMustConnectFlag) {
        this.phoneResultMustConnectFlag = phoneResultMustConnectFlag;
    }

    @Basic
    @Column(name = "otherAsValidResultFlag", nullable = true)
    public Integer getOtherAsValidResultFlag() {
        return otherAsValidResultFlag;
    }

    public void setOtherAsValidResultFlag(Integer otherAsValidResultFlag) {
        this.otherAsValidResultFlag = otherAsValidResultFlag;
    }

    @Basic
    @Column(name = "autoPatientNoPaddingFlag", nullable = true)
    public Integer getAutoPatientNoPaddingFlag() {
        return autoPatientNoPaddingFlag;
    }

    public void setAutoPatientNoPaddingFlag(Integer autoPatientNoPaddingFlag) {
        this.autoPatientNoPaddingFlag = autoPatientNoPaddingFlag;
    }

    @Basic
    @Column(name = "autoPatientNoPaddingDigits", nullable = true)
    public Integer getAutoPatientNoPaddingDigits() {
        return autoPatientNoPaddingDigits;
    }

    public void setAutoPatientNoPaddingDigits(Integer autoPatientNoPaddingDigits) {
        this.autoPatientNoPaddingDigits = autoPatientNoPaddingDigits;
    }

    @Basic
    @Column(name = "cancerFilterFlag", nullable = true)
    public Integer getCancerFilterFlag() {
        return cancerFilterFlag;
    }

    public void setCancerFilterFlag(Integer cancerFilterFlag) {
        this.cancerFilterFlag = cancerFilterFlag;
    }

    @Basic
    @Column(name = "notMalignantTumorFlag", nullable = true, length = 20)
    public String getNotMalignantTumorFlag() {
        return notMalignantTumorFlag;
    }

    public void setNotMalignantTumorFlag(String notMalignantTumorFlag) {
        this.notMalignantTumorFlag = notMalignantTumorFlag;
    }

    @Basic
    @Column(name = "followupResultFlag", nullable = true)
    public Integer getFollowupResultFlag() {
        return followupResultFlag;
    }

    public void setFollowupResultFlag(Integer followupResultFlag) {
        this.followupResultFlag = followupResultFlag;
    }

    @Basic
    @Column(name = "validResultControlFlag", nullable = true)
    public Integer getValidResultControlFlag() {
        return validResultControlFlag;
    }

    public void setValidResultControlFlag(Integer validResultControlFlag) {
        this.validResultControlFlag = validResultControlFlag;
    }

    @Basic
    @Column(name = "diseaseTypeSelfDefineFlag", nullable = true)
    public Integer getDiseaseTypeSelfDefineFlag() {
        return diseaseTypeSelfDefineFlag;
    }

    public void setDiseaseTypeSelfDefineFlag(Integer diseaseTypeSelfDefineFlag) {
        this.diseaseTypeSelfDefineFlag = diseaseTypeSelfDefineFlag;
    }

    @Basic
    @Column(name = "deathDateRequiredFlag", nullable = true)
    public Integer getDeathDateRequiredFlag() {
        return deathDateRequiredFlag;
    }

    public void setDeathDateRequiredFlag(Integer deathDateRequiredFlag) {
        this.deathDateRequiredFlag = deathDateRequiredFlag;
    }

    @Basic
    @Column(name = "isOutsideCallAuth", nullable = true)
    public Integer getIsOutsideCallAuth() {
        return isOutsideCallAuth;
    }

    public void setIsOutsideCallAuth(Integer isOutsideCallAuth) {
        this.isOutsideCallAuth = isOutsideCallAuth;
    }

    @Basic
    @Column(name = "outsideCallNum", nullable = true, length = 10)
    public String getOutsideCallNum() {
        return outsideCallNum;
    }

    public void setOutsideCallNum(String outsideCallNum) {
        this.outsideCallNum = outsideCallNum;
    }

    @Basic
    @Column(name = "isIpCall", nullable = true)
    public Integer getIsIpCall() {
        return isIpCall;
    }

    public void setIsIpCall(Integer isIpCall) {
        this.isIpCall = isIpCall;
    }

    @Basic
    @Column(name = "ipCallNum", nullable = true, length = 20)
    public String getIpCallNum() {
        return ipCallNum;
    }

    public void setIpCallNum(String ipCallNum) {
        this.ipCallNum = ipCallNum;
    }

    @Basic
    @Column(name = "hospitalId", nullable = true)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "hospitalName", nullable = true, length = 255)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "rolloutTime", nullable = true)
    public Timestamp getRolloutTime() {
        return rolloutTime;
    }

    public void setRolloutTime(Timestamp rolloutTime) {
        this.rolloutTime = rolloutTime;
    }

    @Basic
    @Column(name = "deployTime", nullable = true)
    public Timestamp getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Timestamp deployTime) {
        this.deployTime = deployTime;
    }

    @Basic
    @Column(name = "deployLocation", nullable = true)
    public Integer getDeployLocation() {
        return deployLocation;
    }

    public void setDeployLocation(Integer deployLocation) {
        this.deployLocation = deployLocation;
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
    @Column(name = "updateTime", nullable = true)
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

        ConfGlobal that = (ConfGlobal) o;

        if (followupCycle != that.followupCycle) return false;
        if (phoneResultMustConnectFlag != that.phoneResultMustConnectFlag) return false;
        if (otherAsValidResultFlag != null ? !otherAsValidResultFlag.equals(that.otherAsValidResultFlag) : that.otherAsValidResultFlag != null)
            return false;
        if (autoPatientNoPaddingFlag != null ? !autoPatientNoPaddingFlag.equals(that.autoPatientNoPaddingFlag) : that.autoPatientNoPaddingFlag != null)
            return false;
        if (autoPatientNoPaddingDigits != null ? !autoPatientNoPaddingDigits.equals(that.autoPatientNoPaddingDigits) : that.autoPatientNoPaddingDigits != null)
            return false;
        if (cancerFilterFlag != null ? !cancerFilterFlag.equals(that.cancerFilterFlag) : that.cancerFilterFlag != null)
            return false;
        if (notMalignantTumorFlag != null ? !notMalignantTumorFlag.equals(that.notMalignantTumorFlag) : that.notMalignantTumorFlag != null)
            return false;
        if (followupResultFlag != null ? !followupResultFlag.equals(that.followupResultFlag) : that.followupResultFlag != null)
            return false;
        if (validResultControlFlag != null ? !validResultControlFlag.equals(that.validResultControlFlag) : that.validResultControlFlag != null)
            return false;
        if (diseaseTypeSelfDefineFlag != null ? !diseaseTypeSelfDefineFlag.equals(that.diseaseTypeSelfDefineFlag) : that.diseaseTypeSelfDefineFlag != null)
            return false;
        if (deathDateRequiredFlag != null ? !deathDateRequiredFlag.equals(that.deathDateRequiredFlag) : that.deathDateRequiredFlag != null)
            return false;
        if (isOutsideCallAuth != null ? !isOutsideCallAuth.equals(that.isOutsideCallAuth) : that.isOutsideCallAuth != null)
            return false;
        if (outsideCallNum != null ? !outsideCallNum.equals(that.outsideCallNum) : that.outsideCallNum != null)
            return false;
        if (isIpCall != null ? !isIpCall.equals(that.isIpCall) : that.isIpCall != null) return false;
        if (ipCallNum != null ? !ipCallNum.equals(that.ipCallNum) : that.ipCallNum != null) return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (hospitalName != null ? !hospitalName.equals(that.hospitalName) : that.hospitalName != null) return false;
        if (rolloutTime != null ? !rolloutTime.equals(that.rolloutTime) : that.rolloutTime != null) return false;
        if (deployTime != null ? !deployTime.equals(that.deployTime) : that.deployTime != null) return false;
        if (deployLocation != null ? !deployLocation.equals(that.deployLocation) : that.deployLocation != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followupCycle;
        result = 31 * result + phoneResultMustConnectFlag;
        result = 31 * result + (otherAsValidResultFlag != null ? otherAsValidResultFlag.hashCode() : 0);
        result = 31 * result + (autoPatientNoPaddingFlag != null ? autoPatientNoPaddingFlag.hashCode() : 0);
        result = 31 * result + (autoPatientNoPaddingDigits != null ? autoPatientNoPaddingDigits.hashCode() : 0);
        result = 31 * result + (cancerFilterFlag != null ? cancerFilterFlag.hashCode() : 0);
        result = 31 * result + (notMalignantTumorFlag != null ? notMalignantTumorFlag.hashCode() : 0);
        result = 31 * result + (followupResultFlag != null ? followupResultFlag.hashCode() : 0);
        result = 31 * result + (validResultControlFlag != null ? validResultControlFlag.hashCode() : 0);
        result = 31 * result + (diseaseTypeSelfDefineFlag != null ? diseaseTypeSelfDefineFlag.hashCode() : 0);
        result = 31 * result + (deathDateRequiredFlag != null ? deathDateRequiredFlag.hashCode() : 0);
        result = 31 * result + (isOutsideCallAuth != null ? isOutsideCallAuth.hashCode() : 0);
        result = 31 * result + (outsideCallNum != null ? outsideCallNum.hashCode() : 0);
        result = 31 * result + (isIpCall != null ? isIpCall.hashCode() : 0);
        result = 31 * result + (ipCallNum != null ? ipCallNum.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (hospitalName != null ? hospitalName.hashCode() : 0);
        result = 31 * result + (rolloutTime != null ? rolloutTime.hashCode() : 0);
        result = 31 * result + (deployTime != null ? deployTime.hashCode() : 0);
        result = 31 * result + (deployLocation != null ? deployLocation.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }


}
