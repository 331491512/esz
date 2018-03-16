package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsDetailInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsInfo;

/**
* @ClassName: TCrfResultClinicalSymptomsDetailDao 
* @Description: 症状明细结果数据操作接口
* @author wang_hw
* @date 2016年5月31日 下午3:19:12
 */
public interface TCrfResultClinicalSymptomsDetailDao
{
	/**
	 * @author wang_hw
	 * @title :insertCrfResultClinicalSymptomsDetail
	 * @Description:症状明细保存
	 * @return void
	 * @date 2016年5月31日 下午3:19:35
	 */
	public void insertCrfResultClinicalSymptomsDetail(TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultClinicalSymptomsDetailList
	 * @Description:症状明细保存列表
	 * @return void
	 * @date 2016年5月31日 下午3:22:19
	 */
	public void insertCrfResultClinicalSymptomsDetailList(List<TCrfResultClinicalSymptomsDetailInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfResultClinicalSymptomsDetail
	 * @Description:症状明细修改
	 * @return void
	 * @date 2016年5月31日 下午3:20:15
	 */
	public void updateCrfResultClinicalSymptomsDetail(TCrfResultClinicalSymptomsInfo crfResultClinicalSymptomsDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultClinicalSymptomsDetail
	 * @Description:症状明细删除
	 * @return void
	 * @date 2016年5月31日 下午3:20:30
	 */
	public void deleteCrfResultClinicalSymptomsDetail(String crfResultClinicalSymptomsDetailId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultClinicalSymptomsDetailByCrfResultId
	 * @Description:症状明细删除(根据结果ID)
	 * @return void
	 * @date 2016年6月7日 上午10:56:19
	 */
	public void deleteCrfResultClinicalSymptomsDetailByCrfResultId(String crfResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultClinicalSymptomsDetail
	 * @Description:症状明细查询
	 * @return TCrfResultClinicalSymptomsDetail
	 * @date 2016年5月31日 下午3:20:44
	 */
	public TCrfResultClinicalSymptomsInfo queryCrfResultClinicalSymptomsDetail(Long crfResultClinicalSymptomsDetailId);
	
	/**
	 * <p>Title:queryByCrfSymptomResultId</p>
	 * <p>Description:通过症状结果ID查询症状结果详情列表数据</p>
	 * @author YYCHEN
	 * @date 2016年6月30日 下午3:42:22
	 * @param crfSymptomResultId
	 * @return
	 */
	public List<TCrfResultClinicalSymptomsDetailInfo> queryByCrfSymptomResultId(String crfSymptomResultId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午4:08:08
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
