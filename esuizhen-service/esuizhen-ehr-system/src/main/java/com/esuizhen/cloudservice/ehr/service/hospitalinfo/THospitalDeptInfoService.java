package com.esuizhen.cloudservice.ehr.service.hospitalinfo;

import java.util.List; 

import com.esuizhen.cloudservice.ehr.model.hospitalinfo.THospitalDeptInfo;


/**
* @ClassName: THospitalDeptInfoService 
* @Description: 医院科室服务接口
* @author wang_hw
* @date 2016年6月29日 下午9:31:21
 */
public interface THospitalDeptInfoService{
	
	/**
	 * @author wang_hw
	 * @title :getHospitalDeptList
	 * @Description:获取医院科室列表
	 * @return List<THospitalDeptInfo>
	 * @date 2016年6月29日 下午9:29:37
	 */
	public List<THospitalDeptInfo> getHospitalDeptList(Long hospitalId);

}
