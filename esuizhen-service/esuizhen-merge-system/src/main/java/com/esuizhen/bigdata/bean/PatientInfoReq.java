package com.esuizhen.bigdata.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class PatientInfoReq {

    private String trueName;
    private String mobile;
    private Long userId;
    private String patientNo;
    private List<Long> patientIds;

    public List<Long> getPatientIds() {
        return patientIds;
    }

    public void setPatientIds(List<Long> patientIds) {
        this.patientIds = patientIds;
    }

    public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
