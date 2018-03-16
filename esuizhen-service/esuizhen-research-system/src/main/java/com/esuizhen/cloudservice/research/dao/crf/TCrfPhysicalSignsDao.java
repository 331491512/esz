package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSignsInfo;

/**
* @ClassName: TCrfPhysicalSignsDao 
* @Description:观察项-体征信息数据操作接口
* @author wang_hw
* @date 2016年4月6日 上午11:29:29
 */
public interface TCrfPhysicalSignsDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationPhysicalSignsOptions
	 * @Description:体征信息录入
	 * @return void
	 * @date 2016年4月6日 上午11:29:55
	 */
	public void insertCrfObservationPhysicalSignsOptions(TCrfPhysicalSignsInfo crfPhysicalSignsInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationPhysicalSignsOptionsList
	 * @Description:体征信息批量录入
	 * @return void
	 * @date 2016年4月6日 上午11:31:31
	 */
	public void insertCrfObservationPhysicalSignsOptionsList(List<TCrfPhysicalSignsInfo> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationPhysicalSignsOptions
	 * @Description:体征信息修改
	 * @return void
	 * @date 2016年4月6日 上午11:31:49
	 */
	public void updateCrfObservationPhysicalSignsOptions(TCrfPhysicalSignsInfo crfPhysicalSignsInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationPhysicalSignsOptions
	 * @Description:删除体征信息（根据ID）
	 * @return void
	 * @date 2016年4月6日 上午11:32:02
	 */
	public void deleteCrfObservationPhysicalSignsOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationPhysicalSignsOptions
	 * @Description:删除体征信息（根据观察项ID）
	 * @return void
	 * @date 2016年4月6日 上午11:32:02
	 */
	public void deleteCrfObservationPhysicalSignsOptionsByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationPhysicalSignsOptions
	 * @Description:查询体征信息（根据ID）
	 * @return TCrfPhysicalSignsInfo
	 * @date 2016年4月6日 上午11:32:55
	 */
	public TCrfPhysicalSignsInfo queryCrfObservationPhysicalSignsOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationPhysicalSignsOptionsByCrfObserveId
	 * @Description:查询体征信息（根据观察项ID）
	 * @return List<TCrfPhysicalSignsInfo>
	 * @date 2016年4月6日 上午11:35:08
	 */
	public List<TCrfPhysicalSignsInfo> queryCrfObservationPhysicalSignsOptionsByCrfObserveId(String crfObserveId);
	
}
