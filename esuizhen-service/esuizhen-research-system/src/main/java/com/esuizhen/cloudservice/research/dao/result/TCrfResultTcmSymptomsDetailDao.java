package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultTcmSymptomsDetail;

/**
* @ClassName: TCrfResultTcmSymptomsDetailDao 
* @Description: 症状中医明细结果数据操作接口
* @author wang_hw
* @date 2016年5月31日 下午8:41:32
 */
public interface TCrfResultTcmSymptomsDetailDao
{
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTcmSymptoms
	 * @Description:症状中医结果保存
	 * @return void
	 * @date 2016年5月31日 下午8:42:19
	 */
	public void insertCrfResultTcmSymptoms(TCrfResultTcmSymptomsDetail crfResultTcmSymptomsDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTcmSymptomsList
	 * @Description:症状中医结果保存（列表）
	 * @return void
	 * @date 2016年5月31日 下午8:43:41
	 */
	public void insertCrfResultTcmSymptomsList(List<TCrfResultTcmSymptomsDetail> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTcmSymptoms
	 * @Description:症状中医结果修改
	 * @return void
	 * @date 2016年5月31日 下午8:43:47
	 */
	public void updateCrfResultTcmSymptoms(TCrfResultTcmSymptomsDetail crfResultTcmSymptomsDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTcmSymptoms
	 * @Description:症状中医结果删除
	 * @return void
	 * @date 2016年5月31日 下午8:43:53
	 */
	public void deleteCrfResultTcmSymptoms(String crfSymptomResultDetailId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTcmSymptomsByCrfResultId
	 * @Description:症状中医结果删除(根据结果ID)
	 * @return void
	 * @date 2016年6月7日 上午10:59:50
	 */
	public void deleteCrfResultTcmSymptomsByCrfResultId(String crfResultId);
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTcmSymptoms
	 * @Description:症状中医结果查询
	 * @return TCrfResultTcmSymptomsDetail
	 * @date 2016年5月31日 下午8:43:58
	 */
	public TCrfResultTcmSymptomsDetail queryCrfResultTcmSymptoms(String crfSymptomResultDetailId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:02:33
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
