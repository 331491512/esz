package com.esuizhen.cloudservice.research.dao.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentRadiotherapyDetail;

/**
* @ClassName: TCrfResultTreatmentRadiotherapyDetailDao 
* @Description: 放疗明细结果数据操作接口
* @author wang_hw
* @date 2016年6月2日 下午5:06:08
 */
public interface TCrfResultTreatmentRadiotherapyDetailDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentRadiotherapyDetail
	 * @Description:放疗明细录入
	 * @return void
	 * @date 2016年6月2日 下午5:06:37
	 */
	public void insertCrfResultTreatmentRadiotherapyDetail(TCrfResultTreatmentRadiotherapyDetail crfResultTreatmentRadiotherapyDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfResultTreatmentRadiotherapyDetailList
	 * @Description:放疗明细录入（列表）
	 * @return void
	 * @date 2016年6月2日 下午5:06:50
	 */
	public void insertCrfResultTreatmentRadiotherapyDetailList(List<TCrfResultTreatmentRadiotherapyDetail> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfResultTreatmentRadiotherapyDetail
	 * @Description:放疗明细修改
	 * @return void
	 * @date 2016年6月2日 下午5:07:06
	 */
	public void updateCrfResultTreatmentRadiotherapyDetail(TCrfResultTreatmentRadiotherapyDetail crfResultTreatmentRadiotherapyDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentRadiotherapyDetail
	 * @Description:放疗明细删除
	 * @return void
	 * @date 2016年6月2日 下午5:07:17
	 */
	public void deleteCrfResultTreatmentRadiotherapyDetail(String crfResultTreatmentRadiotherapyDetailId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfResultTreatmentRadiotherapyDetailByCrfResultId
	 * @Description:放疗明细删除（根据结果ID）
	 * @return void
	 * @date 2016年6月7日 上午10:32:53
	 */
	public void deleteCrfResultTreatmentRadiotherapyDetailByCrfResultId(String crfResultId);
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentRadiotherapyDetail
	 * @Description:放疗明细查询
	 * @return TCrfResultTreatmentRadiotherapyDetail
	 * @date 2016年6月2日 下午5:07:33
	 */
	public TCrfResultTreatmentRadiotherapyDetail queryCrfResultTreatmentRadiotherapyDetail(String crfResultTreatmentRadiotherapyDetailId);

	/**
	 * <p>Title:deleteByProjectId</p>
	 * <p>Description:根据专题ID删除</p>
	 * @author YYCHEN
	 * @date 2016年10月28日 下午3:52:42
	 * @param projectId
	 * @return
	 */
	public int deleteByProjectId(String projectId);
	
}
