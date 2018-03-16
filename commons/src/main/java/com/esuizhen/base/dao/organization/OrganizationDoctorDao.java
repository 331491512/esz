package com.esuizhen.base.dao.organization;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.base.model.OrganizationDoctorInfo;

public interface OrganizationDoctorDao {
	OrganizationDoctorInfo queryOrganzationDoctorInfo(@Param("doctorId")Long doctorId, @Param("userId")Long userId);
	List<Integer> queryCountDeptIdByParentId(@Param("parentIds")List<Integer> parentIds);
	
	// add by zhuguo
	OrganizationDoctorInfo queryDoctorRoleById(@Param("doctorId")Long doctorId, @Param("userId")Long userId);
	
	OrganizationDoctorInfo queryDeployLocation();
	// end
}
