package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultClinicalSymptomsInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
* @ClassName: TCrfResultClinicalSymptomsInfoService 
* @Description: 症状结果查询服务
* @author wang_hw
* @date 2016年5月31日 下午4:29:00
 */
public interface TCrfResultClinicalSymptomsInfoService
{

	/**
	 * @author wang_hw
	 * @title :queryResultClinicalSymptoms
	 * @Description:症状查询
	 * @return TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>
	 * @date 2016年5月31日 下午4:29:50
	 */
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryResultClinicalSymptoms(String crfObserveId , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfResultClinicalSymptoms
	 * @Description:症状录入
	 * @return void
	 * @throws ParameterCannotBeNullException 
	 * @date 2016年5月31日 下午4:29:55
	 */
	public void saveCrfResultClinicalSymptoms(TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> crfResultMainInfo) throws ParameterCannotBeNullException;
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultClinicalSymptomsRecord
	 * @Description:症状记录查询
	 * @return List<TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>>
	 * @date 2016年5月31日 下午4:29:59
	 */
	public Page<TCrfResultClinicalSymptomsInfo> queryCrfResultClinicalSymptomsRecord(String projectId, Long patientId, Integer page, Integer num);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTcmSymptoms
	 * @Description:症状中医查询
	 * @return TCrfResultMainInfo<TCrfResultClinicalSymptomsInfo>
	 * @date 2016年5月31日 下午9:19:15
	 */
	public TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> queryCrfResultTcmSymptoms(String crfObserveId , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfResultTcmSymptoms
	 * @Description:症状中医录入
	 * @return void
	 * @throws ParameterCannotBeNullException 
	 * @date 2016年5月31日 下午9:19:20
	 */
	public void saveCrfResultTcmSymptoms(TCrfResultMainInfo<List<TCrfResultClinicalSymptomsInfo>> crfResultMainInfo) throws ParameterCannotBeNullException;
}
