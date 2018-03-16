package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.research.model.crf.TCrfScheme;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOtherInfo;

/**
* @ClassName: TCrfSchemeDao 
* @Description: 放化疗方案数据操作接口
* @author wang_hw
* @date 2016年4月14日 下午6:48:13
 */
public interface TCrfSchemeDao{
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationTreatmentSchemeOptions
	 * @Description:放化疗信息录入
	 * @return void
	 * @date 2016年4月14日 下午6:53:09
	 */
	public void insertCrfObservationTreatmentSchemeOptions(TCrfScheme crfScheme);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationTreatmentSchemeOptionsList
	 * @Description:放化疗信息录入(列表)
	 * @return void
	 * @date 2016年4月14日 下午7:26:10
	 */
	public void insertCrfObservationTreatmentSchemeOptionsList(@Param("list")List<TCrfSchemeOtherInfo> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationTreatmentSchemeOptions
	 * @Description:放化疗信息修改
	 * @return void
	 * @date 2016年4月14日 下午6:53:28
	 */
	public void updateCrfObservationTreatmentSchemeOptions(TCrfScheme crfScheme);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTreatmentSchemeOptions
	 * @Description:放化疗信息删除
	 * @return void
	 * @date 2016年4月14日 下午6:53:44
	 */
	public void deleteCrfObservationTreatmentSchemeOptions(String crfObserveSchemeId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationTreatmentSchemeOptionsByCrfObserveId
	 * @Description:放化疗信息删除(观察项ID)
	 * @return void
	 * @date 2016年4月14日 下午7:26:25
	 */
	public void deleteCrfObservationTreatmentSchemeOptionsByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationTreatmentSchemeOptions
	 * @Description:方案信息信息查看
	 * @return TCrfScheme
	 * @date 2016年4月14日 下午6:53:58
	 */
	public TCrfScheme queryCrfObservationTreatmentSchemeOptions(String crfObserveSchemeId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId
	 * @Description:放疗部位方案列表
	 * @return List<TCrfScheme>
	 * @date 2016年4月14日 下午7:26:44
	 */
	public List<TCrfScheme> queryCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId(String crfObserveId);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :queryCrfObservationChemotherapyMedicationDetailOptionsByCrfObserveId
	 * @Description:化疗用药方案列表
	 * @return List<TCrfScheme>
	 * @date 2016年4月14日 下午8:45:37
	 */
	public List<TCrfScheme> queryCrfObservationTreatmentSchemeMedicationByCrfObserveId(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationTreatmentSchemeByCrfObserveId
	 * @Description:其他方案列表
	 * @return List<TCrfSchemeOtherInfo>
	 * @date 2016年4月20日 下午2:00:55
	 */
	public List<TCrfSchemeOtherInfo> queryCrfObservationTreatmentSchemeByCrfObserveId(String crfObserveId);
}
