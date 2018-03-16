package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomTcmInfo;

/**
* @ClassName: TCrfSymptomTcmInfoDao 
* @Description: 观察项-症状信息数据操作接口 
* @author wang_hw
* @date 2016年4月14日 上午11:58:09
 */
public interface TCrfSymptomTcmInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationTcmSymptomOptions
	 * @Description:症状信息录入
	 * @return void
	 * @date 2016年4月14日 上午11:59:35
	 */
	public void insertCrfObservationTcmSymptomOptions(TCrfSymptomTcmInfo crfSymptomTcmInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationTcmSymptomOptionsList
	 * @Description:症状信息录入列表
	 * @return void
	 * @date 2016年4月14日 下午12:07:59
	 */
	public void insertCrfObservationTcmSymptomOptionsList(List<TCrfSymptomTcmInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationTcmSymptomOptions
	 * @Description:症状信息修改
	 * @return void
	 * @date 2016年4月14日 上午11:59:54
	 */
	public void updateCrfObservationTcmSymptomOptions(TCrfSymptomTcmInfo crfSymptomTcmInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTcmSymptomOptions
	 * @Description:症状信息删除
	 * @return void
	 * @date 2016年4月14日 下午12:00:10
	 */
	public void deleteCrfObservationTcmSymptomOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTcmSymptomOptionsByCrfObserveId
	 * @Description:症状信息删除(观察项ID)
	 * @return void
	 * @date 2016年4月14日 下午2:47:50
	 */
	public void deleteCrfObservationTcmSymptomOptionsByCrfObserveId(String crfObserveId);
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationTcmSymptomOptions
	 * @Description:症状信息查询
	 * @return TCrfSymptomTcmInfo
	 * @date 2016年4月14日 下午12:00:21
	 */
	public TCrfSymptomTcmInfo queryCrfObservationTcmSymptomOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationTcmSymptomOptionsByCrfObserveId
	 * @Description:症状信息查询(观察项ID)
	 * @return List<TCrfSymptomTcmInfo>
	 * @date 2016年4月14日 下午2:46:27
	 */
	public List<TCrfSymptomTcmInfo> queryCrfObservationTcmSymptomOptionsByCrfObserveId(String crfObserveId);
	
}
