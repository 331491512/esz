package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionDetail;

/**
* @ClassName: TCrfDetectionDetailDao 
* @Description: CRF观察项-检验类型数据操作接口
* @author wang_hw
* @date 2016年4月12日 下午1:07:13
 */
public interface TCrfDetectionDetailDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationDetectionItemDetailOptions
	 * @Description:新增检验类型
	 * @return void
	 * @date 2016年4月12日 下午1:07:09
	 */
	public void insertCrfObservationDetectionItemDetailOptions(TCrfDetectionDetail crfDetectionDetail);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationDetectionItemDetailOptionsList
	 * @Description:新增检验类型（列表）
	 * @return void
	 * @date 2016年4月12日 下午1:13:20
	 */
	public void insertCrfObservationDetectionItemDetailOptionsList(List<TCrfDetectionDetail> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationDetectionItemDetailOptions
	 * @Description:修改检验类型
	 * @return void
	 * @date 2016年4月12日 下午1:08:34
	 */
	public void updateCrfObservationDetectionItemDetailOptions(TCrfDetectionDetail crfDetectionDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationDetectionItemDetailOptions
	 * @Description:删除检验类型
	 * @return void
	 * @date 2016年4月12日 下午1:08:45
	 */
	public void deleteCrfObservationDetectionItemDetailOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationDetectionItemDetailOptionsByCrfObserveId
	 * @Description:删除检验类型(观察项ID)
	 * @return void
	 * @date 2016年4月12日 下午1:13:37
	 */
	public void deleteCrfObservationDetectionItemDetailOptionsByCrfObserveId(String crfObserveId);
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationDetectionItemDetailOptions
	 * @Description:查询检验类型（ID）
	 * @return TCrfDetectionDetail
	 * @date 2016年4月12日 下午1:08:58
	 */
	public TCrfDetectionDetail queryCrfObservationDetectionItemDetailOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationDetectionItemDetailOptionsByCrfObserveId
	 * @Description:查询检验类型（观察项ID）
	 * @return List<TCrfDetectionDetail>
	 * @date 2016年4月12日 下午1:15:12
	 */
	public List<TCrfDetectionDetail> queryCrfObservationDetectionItemDetailOptionsByCrfObserveId(String crfObserveId);
	
}
