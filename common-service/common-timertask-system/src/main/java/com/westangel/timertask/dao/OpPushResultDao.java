package com.westangel.timertask.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.timertask.model.OpPushResult;

/**
* @ClassName: OpPushResultDao 
* @Description: 推送结果数据处理类
* @author wang_hw
* @date 2016年10月7日 上午11:18:56
 */
public interface OpPushResultDao{
	
	/**
	 * @author wang_hw
	 * @title :insertOpPushResult
	 * @Description:录入推送结果（单条）
	 * @return void
	 * @date 2016年10月7日 上午11:19:15
	 */
	public void insertOpPushResult(OpPushResult opPushResult);
	
	/**
	 * @author wang_hw
	 * @title :insertOpPushResultList
	 * @Description:录入推送结果（批量）
	 * @return void
	 * @date 2016年10月7日 上午11:19:19
	 */
	public void insertOpPushResultList(List<OpPushResult> list);
	
	/**
	 * @author wang_hw
	 * @title :updateOpPushResult
	 * @Description:修改推送结果
	 * @return void
	 * @date 2016年10月7日 上午11:19:23
	 */
	public void updateOpPushResult(OpPushResult opPushResult);
	
	/**
	 * @author wang_hw
	 * @title :deleteOpPushResult
	 * @Description:根据ID删除推送结果
	 * @return void
	 * @date 2016年10月7日 上午11:19:27
	 */
	public void deleteOpPushResult(Long opPushResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryOpPushResult
	 * @Description:根据ID查询推送结果
	 * @return OpPushResult
	 * @date 2016年10月7日 上午11:19:31
	 */
	public OpPushResult queryOpPushResult(Long opPushResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryOpPushResult
	 * @Description:根据患者ID，规则ID，文章ID查询推送结果
	 * @return List<OpPushResult>
	 * @date 2016年10月10日 下午4:15:52
	 */
	public OpPushResult queryOpPushResult(@Param("pushRuleId")Integer pushRuleId , @Param("patientId")Long patientId , @Param("articleId")Integer articleId);
	
}
