/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.service;<br/>  
 * <b>文件名：</b>SurvivalService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午4:21:30<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.service;

import java.io.File;
import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRateFinalReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRatePreReq;

/**
 * @ClassName: SurvivalService
 * @Description:
 * @author lichenghao
 * @date 2016年8月12日 下午4:21:30
 */
public interface SurvivalService {

	// 初始统计患者 防止事物影响
	public void initSurvivalRate(FollowupSurvivalRatePreReq req);

	// 统计第一部分
	public Object preFollowupSurvivalRate(FollowupSurvivalRatePreReq req);

	public Object finalFollowupSurvival(FollowupSurvivalRateFinalReq req);

	// 生存率数据导出
	public List<Object> initExportData(Object obj, Object obj2, Object compareData, Object compareSubData, Integer staticType);

	// 生存率报表文件
	public File buildSurvivalRateReportFile(Object countData, Object subData, Object compareData, Object compareSubData, String searchId, Integer staticType);

	// 生存率患者数据
	public List<Object> initExportPatientData(Object obj, Integer searchId, Integer staticType, Integer reqFlag, Integer staticResultType, Integer doctorId);

}
