package com.esuizhen.cloudservice.followup.dao.user;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.user.RConfDataPrivilege;

public interface DoctorDao {

	public Doctor getDoctorById(@Param("doctorId")Long doctorId);
	
	public RConfDataPrivilege getDataPrivilegeByDoctorId(@Param("doctorId")Long doctorId);

}
