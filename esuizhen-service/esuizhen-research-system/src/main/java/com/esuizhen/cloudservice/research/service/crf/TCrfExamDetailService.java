package com.esuizhen.cloudservice.research.service.crf;

import java.util.List;

import com.esuizhen.cloudservice.research.model.crf.TCrfExams;
import com.esuizhen.cloudservice.research.model.crf.TCrfExamsDetail;

public interface TCrfExamDetailService{
	
	/**
	 * @author wang_hw
	 * @title :saveCrfExamItemDetail
	 * @Description:观察项-检查信息(影像检查-病灶)明细设置
	 * @return void
	 * @date 2016年4月6日 下午4:28:08
	 */
	public void saveCrfExamItemDetail(TCrfExams crfExams);
	
	/**
	 * @author wang_hw
	 * @title :queryCrfExamItemDetail
	 * @Description:观察项-检查信息(影像检查-病灶)明细查看
	 * @return List<TCrfExamsDetail>
	 * @date 2016年4月6日 下午4:28:12
	 */
	public List<TCrfExamsDetail> queryCrfExamItemDetail(String crfObserveId);
}
