package com.esuizhen.bigdata.domain.followup;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/11/28.
 */
@Entity
@Table(name = "conf_local_profile", schema = "followup_db", catalog="")
//@Audited
//@AuditTable(value = "conf_local_profile_audit",schema = "followup_db_audit",catalog = "followup_db_audit")
public class ConfLocalProfile {
    private int id;
    private long userId;
    private String deviceCode;
    private String localPhoneNumber;
    private Integer isOutsideCallAuth;
    private Integer isIpCall;
    private String voiceRecordPath;
    private Integer voiceBoxFlag;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "deviceCode", nullable = true, length = 30)
    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    @Basic
    @Column(name = "localPhoneNumber", nullable = true, length = 30)
    public String getLocalPhoneNumber() {
        return localPhoneNumber;
    }

    public void setLocalPhoneNumber(String localPhoneNumber) {
        this.localPhoneNumber = localPhoneNumber;
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
    @Column(name = "isIpCall", nullable = true)
    public Integer getIsIpCall() {
        return isIpCall;
    }

    public void setIsIpCall(Integer isIpCall) {
        this.isIpCall = isIpCall;
    }

    @Basic
    @Column(name = "voiceRecordPath", nullable = true, length = 255)
    public String getVoiceRecordPath() {
        return voiceRecordPath;
    }

    public void setVoiceRecordPath(String voiceRecordPath) {
        this.voiceRecordPath = voiceRecordPath;
    }

    @Basic
    @Column(name = "voiceBoxFlag", nullable = true)
    public Integer getVoiceBoxFlag() {
        return voiceBoxFlag;
    }

    public void setVoiceBoxFlag(Integer voiceBoxFlag) {
        this.voiceBoxFlag = voiceBoxFlag;
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

        ConfLocalProfile that = (ConfLocalProfile) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (deviceCode != null ? !deviceCode.equals(that.deviceCode) : that.deviceCode != null) return false;
        if (localPhoneNumber != null ? !localPhoneNumber.equals(that.localPhoneNumber) : that.localPhoneNumber != null)
            return false;
        if (isOutsideCallAuth != null ? !isOutsideCallAuth.equals(that.isOutsideCallAuth) : that.isOutsideCallAuth != null)
            return false;
        if (isIpCall != null ? !isIpCall.equals(that.isIpCall) : that.isIpCall != null) return false;
        if (voiceRecordPath != null ? !voiceRecordPath.equals(that.voiceRecordPath) : that.voiceRecordPath != null)
            return false;
        if (voiceBoxFlag != null ? !voiceBoxFlag.equals(that.voiceBoxFlag) : that.voiceBoxFlag != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (deviceCode != null ? deviceCode.hashCode() : 0);
        result = 31 * result + (localPhoneNumber != null ? localPhoneNumber.hashCode() : 0);
        result = 31 * result + (isOutsideCallAuth != null ? isOutsideCallAuth.hashCode() : 0);
        result = 31 * result + (isIpCall != null ? isIpCall.hashCode() : 0);
        result = 31 * result + (voiceRecordPath != null ? voiceRecordPath.hashCode() : 0);
        result = 31 * result + (voiceBoxFlag != null ? voiceBoxFlag.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
