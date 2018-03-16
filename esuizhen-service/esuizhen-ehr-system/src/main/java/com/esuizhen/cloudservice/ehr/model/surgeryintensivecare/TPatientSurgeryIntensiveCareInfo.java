package com.esuizhen.cloudservice.ehr.model.surgeryintensivecare;

import java.util.Date;

public class TPatientSurgeryIntensiveCareInfo {

	private String intensiveId;
	
	private String inhospitalId;
	
	private String intensiveCareName;
	
	private Date inIntensiveCareTime;
	
	private Date outIntensiveCareTime;
	
	// add by zhuguo
	private Integer actionFlag;

	public Integer getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(Integer actionFlag) {
		this.actionFlag = actionFlag;
	}

	public String getIntensiveId() {
		return intensiveId;
	}

	public void setIntensiveId(String intensiveId) {
		this.intensiveId = intensiveId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getIntensiveCareName() {
		return intensiveCareName;
	}

	public void setIntensiveCareName(String intensiveCareName) {
		this.intensiveCareName = intensiveCareName;
	}

	public Date getInIntensiveCareTime() {
		return inIntensiveCareTime;
	}

	public void setInIntensiveCareTime(Date inIntensiveCareTime) {
		this.inIntensiveCareTime = inIntensiveCareTime;
	}

	public Date getOutIntensiveCareTime() {
		return outIntensiveCareTime;
	}

	public void setOutIntensiveCareTime(Date outIntensiveCareTime) {
		this.outIntensiveCareTime = outIntensiveCareTime;
	}
	
}
