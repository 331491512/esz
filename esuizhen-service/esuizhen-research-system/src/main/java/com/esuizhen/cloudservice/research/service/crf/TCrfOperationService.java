package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfOperation;
import com.esuizhen.cloudservice.research.model.crf.TCrfOperationInfo;


/**
* @ClassName: TCrfOperationService 
* @Description: CRF观察项-手术服务
* @author wang_hw
* @date 2016年4月20日 下午3:44:40
 */
public interface TCrfOperationService
{
	/**
	 * @author wang_hw
	 * @title :saveCrfTreatmentOperation
	 * @Description:CRF观察项-手术设置
	 * @return void
	 * @date 2016年4月20日 下午3:48:14
	 */
	public void saveCrfTreatmentOperation(TCrfOperation crfOperation);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfTreatmentOperation
	 * @Description:CRF观察项-手术查看
	 * @return List<TCrfOperationInfo>
	 * @date 2016年4月20日 下午3:48:26
	 */
	public List<TCrfOperationInfo> queryCrfTreatmentOperation(String crfObserveId);

}
