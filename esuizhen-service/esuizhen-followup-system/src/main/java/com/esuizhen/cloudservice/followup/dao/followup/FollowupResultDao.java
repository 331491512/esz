package com.esuizhen.cloudservice.followup.dao.followup;

import com.esuizhen.cloudservice.followup.model.followup.FollowupResult;
import com.westangel.common.bean.TFollowupResultInfo;

/**
* @ClassName: FollowupResultDao 
* @Description: 随访结果数据统计
* @author wang_hw
* @date 2016年1月15日 下午6:46:31
 */
public interface FollowupResultDao{

	/**
	 * @author wang_hw
	 * @title :insertFollowupResult
	 * @Description:录入随访结果
	 * @return void
	 * @date 2016年1月15日 下午6:47:44
	 */
	public void insertFollowupResult(FollowupResult followupResult);
	
	/**
	 * @author wang_hw
	 * @title :updateFollowupResult
	 * @Description:修改随访结果
	 * @return void
	 * @date 2016年1月15日 下午6:47:58
	 */
	public void updateFollowupResult(FollowupResult followupResult);
	
	/**
	 * @author wang_hw
	 * @title :deleteFollowupResult
	 * @Description:删除随访结果
	 * @return void
	 * @date 2016年1月15日 下午6:48:12
	 */
	public void deleteFollowupResult(Long followupResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupResult
	 * @Description:查询随访结果
	 * @return FollowupResult
	 * @date 2016年1月15日 下午6:48:32
	 */
	public FollowupResult queryFollowupResult(Long followupResultId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryLastFollowupResultByUserId
	 * @Description:获取最后一次随访结果
	 * @return TFollowupResultInfo
	 * @date 2016年6月7日 下午5:25:19
	 */
	public TFollowupResultInfo queryLastFollowupResultByUserId(Long userId);
	
}
