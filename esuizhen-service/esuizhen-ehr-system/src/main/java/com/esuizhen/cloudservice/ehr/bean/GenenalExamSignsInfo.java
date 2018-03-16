package com.esuizhen.cloudservice.ehr.bean;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;

public class GenenalExamSignsInfo {

	GenenalExaminationInfo genenalExamination;
	
	List<PhysicalSigns> physicalSigns;

	public GenenalExaminationInfo getGenenalExamination() {
		return genenalExamination;
	}

	public void setGenenalExamination(GenenalExaminationInfo genenalExamination) {
		this.genenalExamination = genenalExamination;
	}

	public List<PhysicalSigns> getPhysicalSigns() {
		return physicalSigns;
	}

	public void setPhysicalSigns(List<PhysicalSigns> physicalSigns) {
		this.physicalSigns = physicalSigns;
	}

}
