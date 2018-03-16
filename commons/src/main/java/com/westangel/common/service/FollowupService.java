package com.westangel.common.service;

import com.westangel.common.bean.TFollowupResultInfo;

/**
 * 
* @ClassName: FollowupService 
* @Description: 随访，随访模版接口
* @author wang_hw
* @date 2015年12月28日 下午3:05:27
 */
public interface FollowupService
{
	
	/**
	 * @author wang_hw
	 * @title :initNormalFollowupPlan
	 * @Description:给患者开启常规随访计划
	 * @return boolean
	 * @date 2015年12月28日 下午3:05:01
	 */
	public boolean initNormalFollowupPlan(Long patientId , String confirmedDate , Long diseaseTypeId);
	public boolean initNormalFollowupPlan(Long patientId , String confirmedDate , Long diseaseTypeId, String doctorName,Integer wxProductId);
	
	
	/**
	 * 判断患者是否开启随访计划
	 * @author lichenghao
	 * @title :checkPatientHasFollowup
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年3月24日 下午8:07:45
	 */
	public boolean checkPatientHasFollowup(Long patientId);
	
	/**
	 * 获取患者最后一次随访结果
	 * @author lichenghao
	 * @title :queryLastFollowupResultByUserId
	 * @Description:TODO
	 * @return TFollowupResultInfo
	 * @date 2016年6月7日 下午5:20:08
	 */
	public TFollowupResultInfo getLastFollowupResultByUserId(Long userId);

}
