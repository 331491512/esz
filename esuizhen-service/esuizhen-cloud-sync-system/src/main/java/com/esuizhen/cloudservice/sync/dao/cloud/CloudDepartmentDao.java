package com.esuizhen.cloudservice.sync.dao.cloud;

import com.esuizhen.cloudservice.sync.model.Department;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudDepartmentDao {
	/**
	 * 
	 * @param uuid
	 * @return
	 */
	public Department findByUuid(String uuid);

	public int existDepartment(Integer deptId);
}
