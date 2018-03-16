package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfSymptom;
import com.esuizhen.cloudservice.research.model.crf.TCrfSymptomInfo;

/**
* @ClassName: CrfObservationClinicSymptomOptionsService 
* @Description: 症状配置信息服务接口
* @author wang_hw
* @date 2016年4月5日 下午8:26:00
 */
public interface TCrfSymptomInfoService
{
	/**
	 * @author wang_hw
	 * @title :saveCrfSymptoms
	 * @Description:保存症状配置信息
	 * @return void
	 * @date 2016年4月5日 下午8:27:49
	 */
	public void saveCrfSymptoms(TCrfSymptom crfSymptom);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfSymptoms
	 * @Description:查询临床症状设置列表
	 * @return List<TCrfSymptomInfo>
	 * @date 2016年4月5日 下午8:35:07
	 */
	public List<TCrfSymptomInfo> queryCrfSymptoms(String crfObserveId);
	

}
