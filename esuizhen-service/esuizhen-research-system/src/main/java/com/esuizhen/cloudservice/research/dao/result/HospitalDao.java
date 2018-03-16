package com.esuizhen.cloudservice.research.dao.result;

import com.westangel.common.bean.HospitalProfile;

public interface HospitalDao {
	/**
	 * <p>Title:findByDoctorId</p>
	 * <p>Description:根据医生ID获取医院基本信息</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午4:32:47
	 * @param doctorId
	 * @return
	 */
	HospitalProfile findByDoctorId(Long doctorId);
}
