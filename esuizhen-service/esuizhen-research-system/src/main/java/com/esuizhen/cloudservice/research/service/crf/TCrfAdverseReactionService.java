package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReaction;
import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReactionInfo;

/**
* @ClassName: TCrfAdverseReactionService 
* @Description: CRF-观察项-不良反映服务接口
* @author wang_hw
* @date 2016年4月15日 下午6:20:52
 */
public interface TCrfAdverseReactionService{

	/**
	 * @author wang_hw
	 * @title :queryCrfAdverseReaction
	 * @Description:CRF-观察项-不良反映查看
	 * @return List<TCrfAdverseReactionInfo>
	 * @date 2016年4月15日 下午6:29:05
	 */
	public List<TCrfAdverseReactionInfo> queryCrfAdverseReaction(String crfObserveId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfAdverseReaction
	 * @Description:CRF-观察项-不良反映设置
	 * @return void
	 * @date 2016年4月15日 下午6:29:10
	 */
	public void saveCrfAdverseReaction(TCrfAdverseReaction crfAdverseReaction);
}
