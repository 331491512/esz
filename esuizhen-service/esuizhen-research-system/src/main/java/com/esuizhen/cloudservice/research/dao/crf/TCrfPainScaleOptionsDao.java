package com.esuizhen.cloudservice.research.dao.crf;

import com.esuizhen.cloudservice.research.model.crf.TCrfPainScaleOptions;

/**
 * <p>Title:TCrfPainScaleOptionsDao</p>
 * <p>Description:CRF-疼痛指数模板设置信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年10月19日 下午3:45:06
 */
public interface TCrfPainScaleOptionsDao {

	/**
	 * <p>Title:findCrfPainScaleInfoByCrfObserveId</p>
	 * <p>Description:根据CRF模板设置ID查找疼痛设置信息</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午3:47:12
	 * @param crfObserveId
	 * @return
	 */
	TCrfPainScaleOptions findCrfPainScaleInfoByCrfObserveId(String crfObserveId);

	/**
	 * <p>Title:update</p>
	 * <p>Description:修改CRF疼痛指数模板设置</p>
	 * @author YYCHEN
	 * @date 2016年10月19日 下午4:07:15
	 * @param crfPainScaleOptions
	 * @return
	 */
	int update(TCrfPainScaleOptions crfPainScaleOptions);

	int insert(TCrfPainScaleOptions crfPainScaleOptions);
	
}
