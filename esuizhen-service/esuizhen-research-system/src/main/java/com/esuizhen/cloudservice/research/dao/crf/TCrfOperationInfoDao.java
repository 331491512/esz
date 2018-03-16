package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfOperationInfo;

/**
* @ClassName: TCrfOperationInfoDao 
* @Description: CRF观察项-手术数据操作接口 
* @author wang_hw
* @date 2016年4月20日 下午3:48:43
 */
public interface TCrfOperationInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationtreatmentOperationOptions
	 * @Description:CRF观察项-手术录入
	 * @return void
	 * @date 2016年4月20日 下午4:15:28
	 */
	public void insertCrfObservationtreatmentOperationOptions(TCrfOperationInfo crfOperationInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationtreatmentOperationOptionsList
	 * @Description:CRF观察项-手术批量录入
	 * @return void
	 * @date 2016年4月20日 下午4:15:59
	 */
	public void insertCrfObservationtreatmentOperationOptionsList(List<TCrfOperationInfo> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationtreatmentOperationOptions
	 * @Description:CRF观察项-手术修改
	 * @return void
	 * @date 2016年4月20日 下午4:16:13
	 */
	public void updateCrfObservationtreatmentOperationOptions(TCrfOperationInfo crfOperationInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationtreatmentOperationOptions
	 * @Description:CRF观察项-手术删除
	 * @return void
	 * @date 2016年4月20日 下午4:16:33
	 */
	public void deleteCrfObservationtreatmentOperationOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationtreatmentOperationOptionsByCrfObserveId
	 * @Description:CRF观察项-手术删除（观察项ID）
	 * @return void
	 * @date 2016年4月20日 下午4:16:50
	 */
	public void deleteCrfObservationtreatmentOperationOptionsByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationtreatmentOperationOptions
	 * @Description:CRF观察项-手术查看
	 * @return TCrfOperationInfo
	 * @date 2016年4月20日 下午4:17:13
	 */
	public TCrfOperationInfo queryCrfObservationtreatmentOperationOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationtreatmentOperationOptionsByCrfObserveId
	 * @Description:CRF观察项-手术查看（观察项ID）
	 * @return List<TCrfOperationInfo>
	 * @date 2016年4月20日 下午4:17:27
	 */
	public List<TCrfOperationInfo> queryCrfObservationtreatmentOperationOptionsByCrfObserveId(String crfObserveId);
}
