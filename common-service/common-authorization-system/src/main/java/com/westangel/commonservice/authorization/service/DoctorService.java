package com.westangel.commonservice.authorization.service;

import java.util.List;

import com.westangel.common.bean.Doctor;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface DoctorService {
	/**
	 * <p>Title:addDoctor</p>
	 * <p>Description:添加医生基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:25:22
	 * @param doctor
	 * @return
	 */
	public boolean addDoctor(Doctor doctor);

	/**
	 * <p>Title:getOrganizationStructure</p>
	 * <p>Description:获取组织架构</p>
	 * @author YYCHEN
	 * @date 2016年8月5日 上午11:15:21
	 * @param hospitalId
	 * @param userId
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	public List<Doctor> getOrganizationStructure(Integer hospitalId, Long userId) throws InsufficientParameterExcption;
}
