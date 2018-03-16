package com.esuizhen.cloudservice.sync.dao.incre;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;

/**
 * 
 * @author YYCHEN
 *
 */
public interface IncreFlowupDao {

	/**
	 * 
	* @Title: addResultRecord2Incr 
	* @Description: 增量到增量库 
	* @param @param result    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addResultRecord2Incr(TPatientFollowupResultDetailInfo result);
}
