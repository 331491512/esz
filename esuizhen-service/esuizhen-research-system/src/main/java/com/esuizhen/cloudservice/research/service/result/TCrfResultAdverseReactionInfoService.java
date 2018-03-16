package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultAdverseReactionInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.westangel.common.bean.Page;

/**
* @ClassName: TCrfResultAdverseReactionInfoService 
* @Description: 不良反应服务接口
* @author wang_hw
* @date 2016年6月6日 下午7:56:22
 */
public interface TCrfResultAdverseReactionInfoService
{
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultAdverseReaction
	 * @Description:不良反应查询
	 * @return TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>
	 * @date 2016年6月6日 下午7:56:55
	 */
	public TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> queryCrfResultAdverseReaction(String crfObserveId , Long patientId);

	/**
	 * @author wang_hw
	 * @title :saveCrfResultAdverseReaction
	 * @Description:不良反应保存
	 * @return void
	 * @date 2016年6月6日 下午7:57:10
	 */
	public void saveCrfResultAdverseReaction(TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>> crfResultMainInfo);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultAdverseReactionRecord
	 * @Description:不良反应记录查询
	 * @return List<TCrfResultMainInfo<List<TCrfResultAdverseReactionInfo>>>
	 * @date 2016年6月6日 下午7:57:29
	 */
	public Page<TCrfResultAdverseReactionInfo> queryCrfResultAdverseReactionRecord(String projectId, Long patientId, Integer page, Integer num);
}
