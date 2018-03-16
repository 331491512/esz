package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTreatmentOperationInfo;

/**
* @ClassName: TCrfResultTreatmentOperationInfoService 
* @Description: 手术结果服务
* @author wang_hw
* @date 2016年6月3日 下午6:10:32
 */
public interface TCrfResultTreatmentOperationInfoService
{
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTreatmentOperation
	 * @Description:手术结果录入
	 * @return TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>>
	 * @date 2016年6月3日 下午6:10:56
	 */
	public TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>> queryCrfResultTreatmentOperation(String crfObserveId , Long patientId);

	/**
	 * @author wang_hw
	 * @title :saveCrfResultTreatmentOperation
	 * @Description:手术结果查询
	 * @return void
	 * @date 2016年6月3日 下午6:11:19
	 */
	public void saveCrfResultTreatmentOperation(TCrfResultMainInfo<List<TCrfResultTreatmentOperationInfo>> crfResultMainInfo);
}
