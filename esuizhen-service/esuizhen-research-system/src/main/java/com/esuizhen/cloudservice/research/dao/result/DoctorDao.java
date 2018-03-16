package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.westangel.common.bean.Doctor;

public interface DoctorDao {
	/**
	 * <p>Title:findByMobile</p>
	 * <p>Description:使用手机号查询医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 上午11:19:50
	 * @param mobile
	 * @return
	 */
	List<Doctor> findByMobile(String mobile);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增加医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年10月20日 下午3:42:52
	 * @param obj
	 * @return
	 */
	int insert(Object obj);

	Doctor findByDoctorId(Long doctorId);

	int update(Doctor doctor);
}
