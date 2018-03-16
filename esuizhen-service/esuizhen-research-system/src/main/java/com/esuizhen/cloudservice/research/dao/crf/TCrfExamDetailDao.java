package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfExamsDetail;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsItemInfo;

/**
* @ClassName: TCrfExamDetailDao 
* @Description: CRF观察项检查信息
* @author wang_hw
* @date 2016年4月6日 下午4:31:59
 */
public interface TCrfExamDetailDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationExamItemDetailOptions
	 * @Description:录入检查信息
	 * @return void
	 * @date 2016年4月6日 下午4:32:31
	 */
	public void insertCrfObservationExamItemDetailOptions(TCrfExamsDetail crfExamDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationExamItemDetailOptionsList
	 * @Description:录入检查信息(批量)
	 * @return void
	 * @date 2016年4月6日 下午5:52:30
	 */
	public void insertCrfObservationExamItemDetailOptionsList(List<TCrfExamsDetail> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationExamItemDetailOptions
	 * @Description:修改检查信息
	 * @return void
	 * @date 2016年4月6日 下午4:32:49
	 */
	public void updateCrfObservationExamItemDetailOptions(TCrfExamsDetail crfExamDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationExamItemDetailOptions
	 * @Description:删除检查信息
	 * @return void
	 * @date 2016年4月6日 下午4:33:06
	 */
	public void deleteCrfObservationExamItemDetailOptions(String crfObserveItemId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationExamItemDetailOptionsByCrfObserveId
	 * @Description:删除检查信息(根据观察项ID)
	 * @return void
	 * @date 2016年4月6日 下午5:53:19
	 */
	public void deleteCrfObservationExamItemDetailOptionsByCrfObserveId(String crfObserveId);
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationExamItemDetailOptions
	 * @Description:查询检查信息
	 * @return TCrfExamsItemInfo
	 * @date 2016年4月6日 下午4:33:40
	 */
	public TCrfExamsItemInfo queryCrfObservationExamItemDetailOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationExamItemDetailOptionsByCrfObserveId
	 * @Description:查询检查信息(根据观察项ID)
	 * @return List<TCrfExamsItemInfo>
	 * @date 2016年4月6日 下午5:50:48
	 */
	public List<TCrfExamsDetail> queryCrfObservationExamItemDetailOptionsByCrfObserveId(String crfObserveId);
	
}
