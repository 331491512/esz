package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfScheme;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeChemotherapyMedication;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOther;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOtherInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeRadiotherapy;

public interface TCrfSchemeService
{
	/**
	 * @author wang_hw
	 * @title :queryCrfSchemeChemotherapyMedicationDetail
	 * @Description:观察项-化疗/靶向用药方案明细查看
	 * @return List<TCrfScheme>
	 * @date 2016年4月14日 下午6:25:33
	 */
	public List<TCrfScheme> queryCrfSchemeChemotherapyMedicationDetail(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfSchemeChemotherapyMedicationDetail
	 * @Description:观察项-化疗/靶向用药方案明细设置
	 * @return void
	 * @date 2016年4月14日 下午6:25:38
	 */
	public void saveCrfSchemeChemotherapyMedicationDetail(TCrfSchemeChemotherapyMedication crfSchemeChemotherapyMedication);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfSchemeRadiotherapyDetail
	 * @Description:观察项-放疗方案明细查看
	 * @return List<TCrfScheme>
	 * @date 2016年4月14日 下午6:25:42
	 */
	public List<TCrfScheme> queryCrfSchemeRadiotherapyDetail(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfSchemeRadiotherapyDetail
	 * @Description:观察项-放疗方案明细设置
	 * @return void
	 * @date 2016年4月14日 下午6:25:46
	 */
	public void saveCrfSchemeRadiotherapyDetail(TCrfSchemeRadiotherapy crfSchemeRadiotherapy);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfScheamOtherDetail
	 * @Description 观察项-放疗方案明细查看（其他）
	 * @return List<TCrfSchemeOtherInfo>
	 * @date 2016年4月20日 上午11:51:12
	 */
	public List<TCrfSchemeOtherInfo> queryCrfTreatmentSchemeOtherDetail (String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfScheamOtherDetail
	 * @Description:观察项-放疗方案明细设置（其他）
	 * @return void
	 * @date 2016年4月20日 上午11:51:21
	 */
	public void saveCrfTreatmentSchemeOtherDetail(TCrfSchemeOther crfSchemeOther);
}
