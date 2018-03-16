package com.esuizhen.cloudservice.ehr.dao.hospitalinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.hospitalinfo.THospitalDeptInfo;

/**
* @ClassName: THospitalDeptInfoDao 
* @Description: 医院科室数据服务接口
* @author wang_hw
* @date 2016年6月29日 下午9:29:20
 */
public interface THospitalDeptInfoDao
{
	/**
	 * @author wang_hw
	 * @title :getHospitalDeptList
	 * @Description:获取医院科室列表
	 * @return List<THospitalDeptInfo>
	 * @date 2016年6月29日 下午9:29:37
	 */
	public List<THospitalDeptInfo> getHospitalDeptList(@Param("hospitalId") Long hospitalId);
}
