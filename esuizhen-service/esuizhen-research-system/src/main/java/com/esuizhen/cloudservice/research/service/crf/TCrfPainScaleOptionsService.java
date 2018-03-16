package com.esuizhen.cloudservice.research.service.crf;

import com.esuizhen.cloudservice.research.model.crf.TCrfPainScaleOptions;

/**
 * <p>Title:TCrfPainScaleOptionsService</p>
 * <p>Description:疼痛指数CRF模板信息</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午3:41:15
 */
public interface TCrfPainScaleOptionsService {

	/**
	 * <p>Title:getCrfPainScaleInfoByCrfObserveId</p>
	 * <p>Description:根据CRF模板设置ID获取疼痛指数CRF模板设置信息</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午3:43:45
	 * @param crfObserveId
	 * @return
	 */
	TCrfPainScaleOptions getCrfPainScaleInfoByCrfObserveId(String crfObserveId);

	/**
	 * <p>Title:saveCrfPainScaleInfo</p>
	 * <p>Description:保存CRF模板疼痛指数设置项</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午3:55:36
	 * @param crfPainScaleOptions
	 * @return
	 */
	boolean saveCrfPainScaleInfo(TCrfPainScaleOptions crfPainScaleOptions);
	
}
