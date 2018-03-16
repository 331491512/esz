package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.Doctor;

/**
 * 云端数据库医生数据访问接口
 * @author YYCHEN
 *
 */
public interface CloudDoctorDao {

	public long insert(Doctor doctor);

	/**
	 * 通过userId查找医生信息
	 * @param userId
	 * @return
	 */
	public Doctor findByUserId(Long userId);

	/**
	 * 通过uuid查找医生数据
	 * @param uuid
	 * @return
	 */
	public Doctor findByUuid(String uuid);

	public Doctor findById(Long doctorId);

	public int update(Doctor doctor);
}
