package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfRadiotherapyPartInfo;

/**
* @ClassName: TCrfRadiotherapyPartInfoDao 
* @Description: 放疗部位数据操作接口 
* @author wang_hw
* @date 2016年4月14日 下午6:45:23
 */
public interface TCrfRadiotherapyPartInfoDao
{
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationRadiotherapyDetailOptions
	 * @Description:放疗部位录入
	 * @return void
	 * @date 2016年4月15日 上午10:53:51
	 */
	public void insertCrfObservationRadiotherapyDetailOptions(TCrfRadiotherapyPartInfo crfRadiotherapyPartInfo);

	/**
	 * @author wang_hw
	 * @title :insertCrfObservationRadiotherapyDetailOptionsList
	 * @Description:放疗部位批量录入
	 * @return void
	 * @date 2016年4月15日 上午10:55:31
	 */
	public void insertCrfObservationRadiotherapyDetailOptionsList(List<TCrfRadiotherapyPartInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationRadiotherapyDetailOptions
	 * @Description:放疗部位修改
	 * @return void
	 * @date 2016年4月15日 上午10:54:11
	 */
	public void updateCrfObservationRadiotherapyDetailOptions(TCrfRadiotherapyPartInfo crfRadiotherapyPartInfo);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationRadiotherapyDetailOptions
	 * @Description:放疗部位删除
	 * @return void
	 * @date 2016年4月15日 上午10:54:26
	 */
	public void deleteCrfObservationRadiotherapyDetailOptions(String crfObserveItemId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId
	 * @Description:放疗部位删除(观察项ID)
	 * @return void
	 * @date 2016年4月15日 上午10:56:33
	 */
	public void deleteCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId(String crfObserveId);
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationRadiotherapyDetailOptions
	 * @Description:放疗部位查询
	 * @return TCrfRadiotherapyPartInfo
	 * @date 2016年4月15日 上午10:54:43
	 */
	public TCrfRadiotherapyPartInfo queryCrfObservationRadiotherapyDetailOptions(String crfObserveItemId);

}
