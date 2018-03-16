package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;

/**
* @ClassName: CrfObservationClinicSymptomOptionsDao 
* @Description: 临床症状配置信息数据操作接口
* @author wang_hw
* @date 2016年4月5日 下午8:12:41
 */
public interface TCrfSymptomInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationClinicSymptomOptions
	 * @Description:录入临床症状配置信息
	 * @return void
	 * @date 2016年4月5日 下午8:14:13
	 */
	public void insertCrfObservationClinicSymptomOptions(TCrfSymptomInfo crfSymptomInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationClinicSymptomOptionsList
	 * @Description:录入症状配置列表
	 * @return void
	 * @date 2016年4月5日 下午8:44:58
	 */
	public void insertCrfObservationClinicSymptomOptionsList(List<TCrfSymptomInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationClinicSymptomOptions
	 * @Description:修改临床症状配置信息
	 * @return void
	 * @date 2016年4月5日 下午8:14:30
	 */
	public void updateCrfObservationClinicSymptomOptions(TCrfSymptomInfo crfSymptomInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationClinicSymptomOptions
	 * @Description:删除临床症状配置信息
	 * @return void
	 * @date 2016年4月5日 下午8:14:44
	 */
	public void deleteCrfObservationClinicSymptomOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteByCrfObserveId
	 * @Description:删除临床症状（根据观察项ID）
	 * @return void
	 * @date 2016年4月5日 下午8:37:48
	 */
	public void deleteCrfObservationClinicSymptomOptionsByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationClinicSymptomOptions
	 * @Description:查询临床症状配置信息
	 * @return CrfObservationClinicSymptomOptions
	 * @date 2016年4月5日 下午8:15:02
	 */
	public TCrfSymptomInfo queryCrfObservationClinicSymptomOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryByCrfObserveId
	 * @Description:根据观察项ID查询
	 * @return List<TCrfSymptomInfo>
	 * @date 2016年4月5日 下午8:48:21
	 */
	public List<TCrfSymptomInfo> queryByCrfObserveId(String crfObserveId);
	
}
