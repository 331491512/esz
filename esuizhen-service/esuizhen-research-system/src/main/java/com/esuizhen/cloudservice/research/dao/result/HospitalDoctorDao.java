package com.esuizhen.cloudservice.research.dao.result;

import com.westangel.common.bean.HospitalDoctor;

public interface HospitalDoctorDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增医院医生关系</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 下午3:45:35
	 * @param obj
	 * @return
	 */
	int insert(Object obj);

	HospitalDoctor findByDoctorId(Long doctorId);
}
