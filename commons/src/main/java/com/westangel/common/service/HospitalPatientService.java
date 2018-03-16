package com.westangel.common.service;

import com.westangel.common.bean.user.HospitalPatientBriefInfo;

/**
 * <p>Title: HospitalPatientService</p>
 * <p>Description: 医院、患者关系业务层接口</p>
 * @author YYCHEN
 * @date 2016年4月28日 下午5:00:28
 */
public interface HospitalPatientService {
	/**
	 * <p>Title: exist</p>
	 * <p>Description: </p>
	 * @date 2016年4月28日 下午5:04:23
	 * @param hospitalId
	 * @param patientId
	 * @return
	 */
	public HospitalPatientBriefInfo existRelation(Integer hospitalId, Long patientId);
}
