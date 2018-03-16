package com.esuizhen.bigdata.domain.user;



import javax.persistence.*;

/**
 * Created by fqc on 16/11/22.
 */
@Entity
@Table(name = "uuid_patient_merge", schema = "user_db" , catalog="")
//@Audited
//@AuditTable(value = "uuid_patient_merge_audit",schema = "user_db_audit",catalog = "user_db_audit")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "patientMerge", procedureName = "user_db.patientMerge",
            parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "patientIds", type = String.class),
                    @StoredProcedureParameter(mode=ParameterMode.IN,name = "i_operator",type = Long.class),
                    @StoredProcedureParameter(mode = ParameterMode.IN,name = "i_mergeReason",type = String.class),
                    @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class)}),
        @NamedStoredProcedureQuery(name = "flushTaskPatientStateAndNumber",
                procedureName = "user_db.flushTaskPatientStateAndNumber"),
        @NamedStoredProcedureQuery(name="flushVarPatientFollowUp",
                procedureName = "user_db.flushVarPatientFollowUp",
                parameters = {@StoredProcedureParameter(mode = ParameterMode.OUT,name = "r_error",type = Integer.class)})
})
public class UuidPatientMerge {
    private long id;
    private long patientid;
    private String newmedicalrecordno;
    private String newuuid;
    private String oldmedicalrecordno;
    private String olduuid;
    private Long goalpatientid;
    private Integer increflag;
    private Integer repeatflag;
    private Integer mergeflag;
    private Integer resultflag;
    private String remark;
    private Integer cancelflag;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "patientid", nullable = false)
    public long getPatientid() {
        return patientid;
    }

    public void setPatientid(long patientid) {
        this.patientid = patientid;
    }

    @Basic
    @Column(name = "newmedicalrecordno", nullable = true, length = 20)
    public String getNewmedicalrecordno() {
        return newmedicalrecordno;
    }

    public void setNewmedicalrecordno(String newmedicalrecordno) {
        this.newmedicalrecordno = newmedicalrecordno;
    }

    @Basic
    @Column(name = "newuuid", nullable = true, length = 32)
    public String getNewuuid() {
        return newuuid;
    }

    public void setNewuuid(String newuuid) {
        this.newuuid = newuuid;
    }

    @Basic
    @Column(name = "oldmedicalrecordno", nullable = true, length = 20)
    public String getOldmedicalrecordno() {
        return oldmedicalrecordno;
    }

    public void setOldmedicalrecordno(String oldmedicalrecordno) {
        this.oldmedicalrecordno = oldmedicalrecordno;
    }

    @Basic
    @Column(name = "olduuid", nullable = false, length = 32)
    public String getOlduuid() {
        return olduuid;
    }

    public void setOlduuid(String olduuid) {
        this.olduuid = olduuid;
    }

    @Basic
    @Column(name = "goalpatientid", nullable = true)
    public Long getGoalpatientid() {
        return goalpatientid;
    }

    public void setGoalpatientid(Long goalpatientid) {
        this.goalpatientid = goalpatientid;
    }

    @Basic
    @Column(name = "increflag", nullable = true)
    public Integer getIncreflag() {
        return increflag;
    }

    public void setIncreflag(Integer increflag) {
        this.increflag = increflag;
    }

    @Basic
    @Column(name = "repeatflag", nullable = true)
    public Integer getRepeatflag() {
        return repeatflag;
    }

    public void setRepeatflag(Integer repeatflag) {
        this.repeatflag = repeatflag;
    }

    @Basic
    @Column(name = "mergeflag", nullable = true)
    public Integer getMergeflag() {
        return mergeflag;
    }

    public void setMergeflag(Integer mergeflag) {
        this.mergeflag = mergeflag;
    }

    @Basic
    @Column(name = "resultflag", nullable = true)
    public Integer getResultflag() {
        return resultflag;
    }

    public void setResultflag(Integer resultflag) {
        this.resultflag = resultflag;
    }
    
    @Basic
    @Column(name = "cancelflag", nullable = true)
    public Integer getCancelflag() {
		return cancelflag;
	}

	public void setCancelflag(Integer cancelflag) {
		this.cancelflag = cancelflag;
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

        UuidPatientMerge that = (UuidPatientMerge) o;

        if (id != that.id) return false;
        if (patientid != that.patientid) return false;
        if (newmedicalrecordno != null ? !newmedicalrecordno.equals(that.newmedicalrecordno) : that.newmedicalrecordno != null)
            return false;
        if (newuuid != null ? !newuuid.equals(that.newuuid) : that.newuuid != null) return false;
        if (oldmedicalrecordno != null ? !oldmedicalrecordno.equals(that.oldmedicalrecordno) : that.oldmedicalrecordno != null)
            return false;
        if (olduuid != null ? !olduuid.equals(that.olduuid) : that.olduuid != null) return false;
        if (goalpatientid != null ? !goalpatientid.equals(that.goalpatientid) : that.goalpatientid != null)
            return false;
        if (increflag != null ? !increflag.equals(that.increflag) : that.increflag != null) return false;
        if (repeatflag != null ? !repeatflag.equals(that.repeatflag) : that.repeatflag != null) return false;
        if (mergeflag != null ? !mergeflag.equals(that.mergeflag) : that.mergeflag != null) return false;
        if (resultflag != null ? !resultflag.equals(that.resultflag) : that.resultflag != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (patientid ^ (patientid >>> 32));
        result = 31 * result + (newmedicalrecordno != null ? newmedicalrecordno.hashCode() : 0);
        result = 31 * result + (newuuid != null ? newuuid.hashCode() : 0);
        result = 31 * result + (oldmedicalrecordno != null ? oldmedicalrecordno.hashCode() : 0);
        result = 31 * result + (olduuid != null ? olduuid.hashCode() : 0);
        result = 31 * result + (goalpatientid != null ? goalpatientid.hashCode() : 0);
        result = 31 * result + (increflag != null ? increflag.hashCode() : 0);
        result = 31 * result + (repeatflag != null ? repeatflag.hashCode() : 0);
        result = 31 * result + (mergeflag != null ? mergeflag.hashCode() : 0);
        result = 31 * result + (resultflag != null ? resultflag.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UuidPatientMerge{" +
                "patientid=" + patientid +
                ", newmedicalrecordno='" + newmedicalrecordno + '\'' +
                ", newuuid='" + newuuid + '\'' +
                ", oldmedicalrecordno='" + oldmedicalrecordno + '\'' +
                ", olduuid='" + olduuid + '\'' +
                ", goalpatientid=" + goalpatientid +
                ", increflag=" + increflag +
                ", repeatflag=" + repeatflag +
                ", mergeflag=" + mergeflag +
                ", resultflag=" + resultflag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
