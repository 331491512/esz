/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.dao;<br/>  
 * <b>文件名：</b>SurvivalDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午4:36:46<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRatePreReq;
import com.esuizhen.cloudservice.statistics.bean.TSurvivalRateInfo;

/** 
* @ClassName: SurvivalDao
* @Description: 
* @author lichenghao
* @date 2016年8月12日 下午4:36:46  
*/
public interface SurvivalDao {
	//插入随访患者信息
	public int insertSearchPatientStaticPatient(Object param);
	//修改查询患者信息
	public int updateSearchPatientStaticPatient(Object param);
	
	//获取有效随访信息
	public List<TSurvivalRateInfo> queryFollowupSurvival(Object param);
	//获取有效随访信息统计
	public TSurvivalRateInfo queryFollowupSurvivalCount(Object param);
	
	//获取生存率信息
	public LinkedHashMap<String, Object> querySurvivalRate(Object param);
	
	//获取导出模版
	public LinkedHashMap<String, Object> queryExportTemplate(@Param("exportTemplateId")String exportTemplateId);
	
	//获取导出模版信息
	public List<HashMap<String, Object>> queryPatientInfo(Object param);

}
