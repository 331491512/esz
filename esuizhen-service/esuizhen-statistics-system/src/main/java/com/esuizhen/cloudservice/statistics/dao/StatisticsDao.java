/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>StatisticsDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午6:06:38<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.PatientSpreadReq;
import com.esuizhen.cloudservice.statistics.bean.SurvivalRateReq;
import com.esuizhen.cloudservice.statistics.bean.TContactWaySpread;
import com.esuizhen.cloudservice.statistics.bean.TDiseaseSpreadItem;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultSpread;
import com.esuizhen.cloudservice.statistics.bean.TFollowupSpread;
import com.esuizhen.cloudservice.statistics.bean.TProvinceSpreadItem;
import com.esuizhen.cloudservice.statistics.bean.TSexAgeSpread;

/** 
* @ClassName: StatisticsDao
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午6:06:38  
*/
public interface StatisticsDao {
	
	/**
	 * 生存率统计
	 * @author lichenghao
	 * @title :querySurvivalResult
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年4月11日 下午6:09:04
	 */
	//public List<LinkedHashMap<String, Object>> querySurvivalResult(Object param);
	
	/**
	 * 随访报告统计
	 * @author lichenghao
	 * @title :queryFollowupReportResult
	 * @Description:TODO
	 * @return List<LinkedHashMap<String,Object>>
	 * @date 2016年5月31日 下午6:41:42
	 */
	//public List<LinkedHashMap<String, Object>> queryFollowupReportResult(Object param);
	
	
	/**
	 * 获取医生病种
	 * @author lichenghao
	 * @title :queryDoctorDiseaseList
	 * @Description:TODO
	 * @return List<Integer>
	 * @date 2016年5月27日 下午5:16:57
	 */
	public List<Integer> queryDoctorDiseaseList(Object param);
	/**
	 * 性别年龄统计
	 * @author lichenghao
	 * @title :querySexAgeResult
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年4月11日 下午6:13:15
	 */
	public TSexAgeSpread querySexAgeResult(Object param);
	
	/**
	 * 省份统计
	 * @author lichenghao
	 * @title :queryProvinceResult
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年4月11日 下午6:13:24
	 */
	public List<TProvinceSpreadItem> queryProvinceResult(Object param);
	
	/**
	 * 联系方式统计
	 * @author lichenghao
	 * @title :queryContactwaySpread
	 * @Description:TODO
	 * @return TContactWaySpread
	 * @date 2016年5月27日 下午4:27:25
	 */
	public TContactWaySpread queryContactwaySpread(Object param);
	/**
	 * 是否随访统计
	 * @author lichenghao
	 * @title :queryFollowupSpread
	 * @Description:TODO
	 * @return TFollowupSpread
	 * @date 2016年5月27日 下午4:27:38
	 */
	public TFollowupSpread queryFollowupSpread(Object param);
	/**
	 * 随访结果统计
	 * @author lichenghao
	 * @title :queryFollowupResultSpread
	 * @Description:TODO
	 * @return TFollowupResultSpread
	 * @date 2016年5月27日 下午4:27:56
	 */
	public TFollowupResultSpread queryFollowupResultSpread(Object param);
	/**
	 * 随访病种统计
	 * @author lichenghao
	 * @title :queryDiseaseSpreadItem
	 * @Description:TODO
	 * @return List<TDiseaseSpreadItem>
	 * @date 2016年5月27日 下午4:28:05
	 */
	public List<TDiseaseSpreadItem> queryDiseaseSpreadItem(Object param);
	
	
	/**
	 * 更新每日新增随访数据和患者数据
	 * @author lichenghao
	 * @title :initDayStatistics
	 * @Description:TODO
	 * @return Integer
	 * @date 2016年4月13日 上午11:16:47
	 */
	public Integer updateDayStatistics();
	
	/**
	 * 
	 * @author lichenghao
	 * @title :querySurvivalAvg
	 * @Description:查询平台均线
	 * @return List<LinkedHashMap<String,Object>>
	 * @date 2016年11月3日 上午11:27:33
	 */
	public List<LinkedHashMap<String, Object>> querySurvivalAvg(SurvivalRateReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :querySurvivalCount
	 * @Description:医生统计查询
	 * @return List<LinkedHashMap<String,Object>>
	 * @date 2016年11月3日 下午7:06:06
	 */
	public List<LinkedHashMap<String, Object>> queryDoctorSurvivalCount(SurvivalRateReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :statisSurvival
	 * @Description:生存率统计
	 * @return List<LinkedHashMap<String,Object>>
	 * @date 2016年11月3日 下午8:29:31
	 */
	public LinkedHashMap<String, Object> statisSurvivalRate(SurvivalRateReq req);
	
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
