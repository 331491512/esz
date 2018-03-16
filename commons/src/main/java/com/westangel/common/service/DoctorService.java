package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.excption.EmptyParamExcption;

/**
 * 医生业务公共服务
 * @author YYCHEN
 *
 */
public interface DoctorService {
	/**
	 * 获取指定患者ID关注（和能提供指导服务/产品）的医生列表
	 * @param patientId 患者ID
	 * @param productType 服务/产品ID
	 * @return
	 */
	public List<DoctorSimpleInfo> listDoctorsOfPatient(Long patientId, Long productTypeId) throws EmptyParamExcption;
	
	/**
	 * 获取指定患者userId正在进行中的医生列表
	 * @author lichenghao
	 * @title :listDoctorsOfPatient
	 * @Description:TODO
	 * @return List<DoctorSimpleInfo>
	 * @date 2016年6月15日 下午2:32:52
	 */
	public List<DoctorSimpleInfo> listDoctorsOfBuyer(Long buyer, Long productTypeId) throws EmptyParamExcption;
	/**
	 * 
	* @Title: doctorHospitalRelation 
	* @Description: 修改医生和医院/科室关系 
	* @param @param hospitalDoctor
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean doctorHospitalRelation(HospitalDoctor hospitalDoctor);
	
	// 获取医生组织架构关系，如果没有返回结构中只有doctorId
	public TRDoctor getTRDoctorByDoctorId(Long doctorId);
}
