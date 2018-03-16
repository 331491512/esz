package com.westangel.commonservice.authorization.service;

import com.westangel.common.bean.Doctor;

/**
 * <p>Title:RHospitalDoctorService</p>
 * <p>Description:医院、医生关系业务层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午4:08:58
 */
public interface RHospitalDoctorService {
	/**
	 * <p>Title:addHospitalDoctor</p>
	 * <p>Description:根据医生信息创建医院、医生关系</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午4:09:42
	 * @param hospitalDoctor
	 * @return
	 */
	public boolean addOrUpdateHospitalDoctor(Doctor doctor);
}
