package com.esuizhen.base.service.organization;

import com.esuizhen.base.model.OrganizationDoctorInfo;

public interface OrganizationDoctorService {
	public OrganizationDoctorInfo getOrganzationDoctorInfo(Long doctorId,Long userId);
	public String getPatientSql(Long doctorId,Long userId);
	public String getDoctorIdSql(Long doctorId,Long userId);
	
	// add by zhuguo
	public boolean queryDoctorRoleById(Long doctorId,Long userId);
	public String getDoctorRoleById(Long doctorId, Long userId);
	// end
}
