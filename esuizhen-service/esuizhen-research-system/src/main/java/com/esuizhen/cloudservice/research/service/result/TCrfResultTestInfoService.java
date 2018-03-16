package com.esuizhen.cloudservice.research.service.result;

import java.util.List;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TCrfResultTestInfo;
import com.westangel.common.bean.Page;

public interface TCrfResultTestInfoService{
	
	/**
	 * @author wang_hw
	 * @title :saveCrfResultTest
	 * @Description:检验结果保存
	 * @return void
	 * @date 2016年5月30日 下午7:37:44
	 */
	public void saveCrfResultTest(TCrfResultMainInfo<List<TCrfResultTestInfo>> crfResultMainInfo);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTest
	 * @Description:查询检验结果（根据观察项ID及患者ID）
	 * @return TCrfResultMainInfo<TCrfResultTestInfo>
	 * @date 2016年5月30日 下午8:16:15
	 */
	public TCrfResultMainInfo<List<TCrfResultTestInfo>> queryCrfResultTest(String crfObserveId  , Long patientId);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfResultTestRecord
	 * @Description:检验结果记录查询
	 * @return void
	 * @date 2016年5月30日 下午8:16:49
	 */
	public Page<TCrfResultMainInfo<List<TCrfResultTestInfo>>> queryCrfResultTestRecord(String projectId, Long patientId, Integer page, Integer num);
}
