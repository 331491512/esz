package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultQualityoflifeInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.ParameterCannotBeNullException;

/**
* @ClassName: TCrfResultQualityoflifeInfoService 
* @Description: 生存质量结果服务接口 
* @author wang_hw
* @date 2016年6月1日 下午7:19:23
 */
public interface TCrfResultQualityoflifeInfoService{

	/**
	 * @author wang_hw
	 * @title :queryCrfResultQualityoflife
	 * @Description:生存质量信息查询
	 * @return TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>
	 * @date 2016年6月1日 下午7:20:29
	 */
	public TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> queryCrfResultQualityoflife(String crfObserveId , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :saveCrfResultQualityoflife
	 * @Description:生成质量信息保存
	 * @return void
	 * @throws ParameterCannotBeNullException 
	 * @date 2016年6月1日 下午7:20:33
	 */
	public void saveCrfResultQualityoflife(TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>> crfResultMainInfo) throws ParameterCannotBeNullException;
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultQualityoflifeRecord
	 * @Description:生成质量记录查询
	 * @return List<TCrfResultMainInfo<List<TCrfResultQualityoflifeInfo>>>
	 * @date 2016年6月1日 下午7:20:36
	 */
	public Page<TCrfResultQualityoflifeInfo> queryCrfResultQualityoflifeRecord(String projectId, Long patientId, Integer page, Integer num);
}
