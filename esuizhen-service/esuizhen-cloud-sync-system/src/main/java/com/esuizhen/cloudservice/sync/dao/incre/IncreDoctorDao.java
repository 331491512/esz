package com.esuizhen.cloudservice.sync.dao.incre;

import com.westangel.common.bean.Doctor;

/**
 * 增量数据库医生数据访问接口
 * @author YYCHEN
 *
 */
public interface IncreDoctorDao {
	/**
	 * 新增医生数据
	 * @param doctor
	 * @return
	 */
	public long insert(Doctor doctor);
	
}
