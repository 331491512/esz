package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSigns;
import com.esuizhen.cloudservice.research.model.crf.TCrfPhysicalSignsInfo;

public interface TCrfPhysicalSignsService{
	
	/**
	 * @author wang_hw
	 * @title :saveCrfPhysicalSigns
	 * @Description:观察项-体征信息设置
	 * @return void
	 * @date 2016年4月6日 上午11:25:33
	 */
	public void saveCrfPhysicalSigns(TCrfPhysicalSigns crfPhysicalSigns);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfPhysicalSigns
	 * @Description:观察项-体征信息查看
	 * @return List<TCrfPhysicalSignsInfo>
	 * @date 2016年4月6日 上午11:25:37
	 */
	public List<TCrfPhysicalSignsInfo> queryCrfPhysicalSigns(String crfObserveId);

}
