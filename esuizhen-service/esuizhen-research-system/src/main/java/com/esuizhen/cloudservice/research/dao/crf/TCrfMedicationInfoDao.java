package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfMedicationInfo;
/**
* @ClassName: TCrfMedicationInfoDao 
* @Description: 化疗用药数据操作接口
* @author wang_hw
* @date 2016年4月14日 下午6:46:01
 */
public interface TCrfMedicationInfoDao
{

	/**
	 * @author wang_hw
	 * @title :insertCrfObservationChemotherapyMedicationDetailOptions
	 * @Description:化疗用药录入
	 * @return void
	 * @date 2016年4月15日 上午10:58:06
	 */
	public void insertCrfObservationChemotherapyMedicationDetailOptions(TCrfMedicationInfo crfMedicationInfo);

	/**
	 * @author wang_hw
	 * @title :insertCrfObservationChemotherapyMedicationDetailOptionsList
	 * @Description:化疗用药批量录入
	 * @return void
	 * @date 2016年4月15日 上午10:59:45
	 */
	public void insertCrfObservationChemotherapyMedicationDetailOptionsList(List<TCrfMedicationInfo> list);
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationChemotherapyMedicationDetailOptions
	 * @Description:化疗用药修改
	 * @return void
	 * @date 2016年4月15日 上午10:58:22
	 */
	public void updateCrfObservationChemotherapyMedicationDetailOptions(TCrfMedicationInfo crfMedicationInfo);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationChemotherapyMedicationDetailOptions
	 * @Description:化疗用药删除
	 * @return void
	 * @date 2016年4月15日 上午10:58:41
	 */
	public void deleteCrfObservationChemotherapyMedicationDetailOptions(String crfObserveItemId);

	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTreatmentSchemeMedicationByCrfObserveId
	 * @Description:化疗用药删除(观察项ID)
	 * @return void
	 * @date 2016年4月15日 上午11:00:56
	 */
	public void deleteCrfObservationTreatmentSchemeMedicationByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationChemotherapyMedicationDetailOptions
	 * @Description:化疗用药查询
	 * @return TCrfMedicationInfo
	 * @date 2016年4月15日 上午10:58:57
	 */
	public TCrfMedicationInfo queryCrfObservationChemotherapyMedicationDetailOptions(String crfObserveItemId);

}
