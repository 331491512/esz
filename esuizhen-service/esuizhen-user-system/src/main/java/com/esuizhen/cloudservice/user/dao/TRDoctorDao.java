package com.esuizhen.cloudservice.user.dao;

import com.westangel.common.bean.user.TRDoctor;

/**
* @ClassName: TRDoctorDao 
* @Description: 医生关系操作接口
* @author wang_hw
* @date 2016年7月26日 下午2:38:46
 */
public interface TRDoctorDao
{
	/**
	 * @author wang_hw
	 * @title :insertRDoctor
	 * @Description:添加患者关系
	 * @return void
	 * @date 2016年7月26日 下午2:41:10
	 */
	public void insertRDoctor(TRDoctor rdoctor);
	
	/**
	 * @author wang_hw
	 * @title :updateRDoctor
	 * @Description:修改患者关系
	 * @return void
	 * @date 2016年7月26日 下午2:55:11
	 */
	public void updateRDoctor(TRDoctor rdoctor);
	
	/**
	 * @author wang_hw
	 * @title :deleteRDoctor
	 * @Description:删除患者关系
	 * @return void
	 * @date 2016年7月26日 下午2:55:33
	 */
	public void deleteRDoctor(Integer id);
	
	/**
	 * @author wang_hw
	 * @title :queryRDoctor
	 * @Description:查询患者关系
	 * @return TRDoctor
	 * @date 2016年7月26日 下午2:55:48
	 */
	public TRDoctor queryRdoctorById(Integer id);
	
	/**
	 * @author wang_hw
	 * @title :queryRDoctor
	 * @Description:查询患者关系(根据医生ID)
	 * @return TRDoctor
	 * @date 2016年7月26日 下午2:55:48
	 */
	public TRDoctor queryRDoctorByDoctorId(Long doctorId);
	
}
