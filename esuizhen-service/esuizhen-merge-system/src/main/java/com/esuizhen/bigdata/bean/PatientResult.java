package com.esuizhen.bigdata.bean;

import java.sql.Date;
import java.util.List;

/**
 * Created by Nidan on 2017年01月05 下午 21:10
 */
public class PatientResult {

    private Long patientId;
    private String patientNo;
    private String trueName;
    private Integer sex;
    private Date birthDate;
    private String identification;
    private List<OtherPatients> otherPatients;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<OtherPatients> getOtherPatients() {
        return otherPatients;
    }

    public void setOtherPatients(List<OtherPatients> otherPatients) {
        this.otherPatients = otherPatients;
    }
}
