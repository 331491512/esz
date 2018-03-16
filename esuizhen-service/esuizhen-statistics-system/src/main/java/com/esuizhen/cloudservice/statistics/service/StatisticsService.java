/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service;<br/>  
 * <b>文件名：</b>FollowupService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月6日下午6:00:50<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service;

import com.esuizhen.cloudservice.statistics.bean.PatientSpreadReq;
import com.esuizhen.cloudservice.statistics.bean.SurvivalRateReq;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultSpread;
import com.esuizhen.cloudservice.statistics.bean.TFollowupSpread;

/** 
* @ClassName: FollowupService
* @Description: 
* @author lichenghao
* @date 2016年4月6日 下午6:00:50  
*/
public interface StatisticsService {
	
	
	//生存率统计
	Object calculateSurvivalRate(SurvivalRateReq req);
	
	
	//患者概要统计
	Object calculatePatientSpread(PatientSpreadReq req);

	//更新随访数据
	void update_data();

	//检查未发送的报告
	void checkFollowReportApply();

	//检查是否是B项目
	boolean isToB();
	
	/**
	 * 随访进度统计-医生空间
	 * @param req
	 * @return
	 */
	TFollowupSpread statisticsFollowupProgressively(PatientSpreadReq req);
	/**
	 * 统计患者末次有效随访结果
	 * @param req
	 * @return
	 */
	TFollowupResultSpread statisticsLastEffectiveFollowupResult(PatientSpreadReq req);

}
