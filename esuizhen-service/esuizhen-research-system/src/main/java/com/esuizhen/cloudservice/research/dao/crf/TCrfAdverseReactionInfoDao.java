package com.esuizhen.cloudservice.research.dao.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfAdverseReactionInfo;

/**
* @ClassName: TCrfAdverseReactionInfoDao 
* @Description: CRF-观察项-不良反映数据操作接口
* @author wang_hw
* @date 2016年4月15日 下午6:21:31
 */
public interface TCrfAdverseReactionInfoDao{
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationAdverseReactionOptions
	 * @Description:不良反映录入
	 * @return void
	 * @date 2016年4月15日 下午6:32:35
	 */
	public void insertCrfObservationAdverseReactionOptions(TCrfAdverseReactionInfo crfAdverseReactionInfo);
	
	/**
	 * @author wang_hw
	 * @title :insertCrfObservationAdverseReactionOptionsList
	 * @Description:不良反映批量录入
	 * @return void
	 * @date 2016年4月15日 下午6:39:29
	 */
	public void insertCrfObservationAdverseReactionOptionsList(List<TCrfAdverseReactionInfo> list);
	
	/**
	 * @author wang_hw
	 * @title :updateCrfObservationAdverseReactionOptions
	 * @Description:不良反映修改
	 * @return void
	 * @date 2016年4月15日 下午6:32:55
	 */
	public void updateCrfObservationAdverseReactionOptions(TCrfAdverseReactionInfo crfAdverseReactionInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationAdverseReactionOptions
	 * @Description:不良反映删除
	 * @return void
	 * @date 2016年4月15日 下午6:33:07
	 */
	public void deleteCrfObservationAdverseReactionOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :deleteCrfObservationAdverseReactionOptionsByCrfObserveId
	 * @Description:不良反映删除（观察项ID）
	 * @return void
	 * @date 2016年4月15日 下午6:40:06
	 */
	public void deleteCrfObservationAdverseReactionOptionsByCrfObserveId(String crfObserveId);
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationAdverseReactionOptions
	 * @Description:不良反映查看
	 * @return TCrfAdverseReactionInfo
	 * @date 2016年4月15日 下午6:33:21
	 */
	public TCrfAdverseReactionInfo queryCrfObservationAdverseReactionOptions(String crfObserveItemId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfObservationAdverseReactionOptionsByCrfObserveId
	 * @Description:不良反映查看（观察项ID）
	 * @return TCrfAdverseReactionInfo
	 * @date 2016年4月15日 下午6:40:46
	 */
	public List<TCrfAdverseReactionInfo> queryCrfObservationAdverseReactionOptionsByCrfObserveId(String crfObserveId);
}
