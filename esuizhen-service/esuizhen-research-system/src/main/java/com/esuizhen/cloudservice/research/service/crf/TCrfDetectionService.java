package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfDetection;
import com.esuizhen.cloudservice.research.model.crf.TCrfDetectionDetail;

/**
* @ClassName: TCrfDetectionService 
* @Description: 观察项-检验信息服务接口
* @author wang_hw
* @date 2016年4月12日 下午1:19:08
 */
public interface TCrfDetectionService{

	/**
	 * @author wang_hw
	 * @title :queryCrfDetectionItemDetail
	 * @Description:观察项-检验信息查看
	 * @return List<TCrfDetectionDetail>
	 * @date 2016年4月12日 下午1:19:37
	 */
	public List<TCrfDetectionDetail> queryCrfDetectionItemDetail(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfDetectionItemDetail
	 * @Description:观察项-检验信息设置
	 * @return void
	 * @date 2016年4月12日 下午1:19:56
	 */
	public void saveCrfDetectionItemDetail(TCrfDetection crfDetection);
}
