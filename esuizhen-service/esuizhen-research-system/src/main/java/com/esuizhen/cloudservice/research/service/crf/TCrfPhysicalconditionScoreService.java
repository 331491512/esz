package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.bean.TCrfPhysicalConditionScoreInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamItemDetailOptions;

/**
 * <p>Title:TCrfPhysicalExamItemDetailOptionsService</p>
 * <p>Description:CRF身体状况评分</p>
 * @author YYCHEN
 * @date 2016年10月25日 下午3:52:28
 */
public interface TCrfPhysicalconditionScoreService {

	/**
	 * <p>Title:queryCrfPhysicalConditionScoreInfo</p>
	 * <p>Description:获取CRF身体状况评分设置项</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 下午3:54:43
	 * @param crfObserveId
	 * @return
	 */
	List<TCrfExamItemDetailOptions> queryCrfPhysicalConditionScoreInfo(String crfObserveId);

	/**
	 * <p>Title:saveCrfPhysicalConditionScore</p>
	 * <p>Description:保存身体状况评分CRF设置项</p>
	 * @author YYCHEN
	 * @date 2016年10月25日 下午4:04:46
	 * @param crfPhysicalConditionScoreInfo
	 * @return
	 */
	boolean saveCrfPhysicalConditionScore(TCrfPhysicalConditionScoreInfo crfPhysicalConditionScoreInfo);

}
