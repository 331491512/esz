package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.result.TCrfResultAdverseReactionInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;

/**
* @ClassName: TCrfResultAdverseReactionInfoDao 
* @Description: 不良反应数据操作接口
* @author wang_hw
* @date 2016年6月6日 下午5:39:08
 */
public interface TCrfResultAdverseReactionInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultAdverseReaction
	 * @Description:不良反应数据录入
	 * @return void
	 * @date 2016年6月6日 下午5:41:54
	 */
	public void insertCrfResultAdverseReaction(TCrfResultAdverseReactionInfo crfResultAdverseReaction);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultAdverseReaction
	 * @Description:不良反应数据录入（列表）
	 * @return void
	 * @date 2016年6月6日 下午5:41:54
	 */
	public void insertCrfResultAdverseReactionList(List<TCrfResultAdverseReactionInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfResultAdverseReaction
	 * @Description:不良反应数据修改
	 * @return void
	 * @date 2016年6月6日 下午5:41:58
	 */
	public void updateCrfResultAdverseReaction(TCrfResultAdverseReactionInfo crfResultAdverseReaction);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultAdverseReaction
	 * @Description:不良反应数据删除
	 * @return void
	 * @date 2016年6月6日 下午5:42:03
	 */
	public void deleteCrfResultAdverseReaction(String crfResultAdverseReactionId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultAdverseReactionByCrfResultId
	 * @Description:不良反应数据删除(根据结果ID)
	 * @return void
	 * @date 2016年6月7日 上午11:06:18
	 */
	public void deleteCrfResultAdverseReactionByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultAdverseReaction
	 * @Description:不良反应数据查询
	 * @return TCrfResultAdverseReactionInfo
	 * @date 2016年6月6日 下午5:54:25
	 */
	public TCrfResultAdverseReactionInfo queryCrfResultAdverseReaction(String crfResultAdverseReactionId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultAdverseReactionByCrfObserveIdAndPatientId
	 * @Description:查询不良反应（根据观察项ID及患者ID）
	 * @return TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>
	 * @date 2016年6月6日 下午8:00:15
	 */
	public TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> queryCrfResultAdverseReactionByCrfObserveIdAndPatientId(@Param("crfObserveId")String crfObserveId , @Param("patientId")Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultAdverseReactionByProjectIdAndPatientId
	 * @Description:查询不良反应记录
	 * @return List<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>
	 * @date 2016年6月6日 下午6:21:19
	 */
	public List<TCrfResultAdverseReactionInfo> queryCrfResultAdverseReactionRecords(@Param("projectId")String projectId , @Param("patientId")Long patientId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 上午11:16:16
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
