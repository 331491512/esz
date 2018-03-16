package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOtherInfo;
import com.westangel.common.bean.Page;

/**
* @ClassName: TCrfResultTreatmentOtherInfoService 
* @Description: 其他治疗结果服务接口
* @author wang_hw
* @date 2016年6月6日 下午3:43:31
 */
public interface TCrfResultTreatmentOtherInfoService
{

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOther
	 * @Description:其他治疗结果查询
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>
	 * @date 2016年6月6日 下午3:43:50
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>> queryCrfResultTreatmentOther(String crfObserveId , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfResultTreatmentOther
	 * @Description:其他治疗结果保存
	 * @return void
	 * @date 2016年6月6日 下午3:44:09
	 */
	public void saveCrfResultTreatmentOther(TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>  crfResultMainInfo);

	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentMedication
	 * @Description:治疗结果记录查询
	 * @return List<TCrfResultMainInfo<String>>
	 * @date 2016年6月6日 下午3:44:25
	 */
	public Page<TCrfResultMainInfo<List<TCrfResultTreatmentOtherInfo>>> queryCrfResultTreatmentMedication(String projectId, Long patientId, Integer page, Integer num);
}
