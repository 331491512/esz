/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.client.sync.dao.sc;<br/>  
 * <b>文件名：</b>MonitorClientDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午5:41:25<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.dao.sc;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
* @ClassName: MonitorClientDao
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午5:41:25  
*/
public interface MonitorClientDao {
	List<LinkedHashMap<String,Object>> queryTempDataMonitor(@Param("monitorDate")String date);
	List<LinkedHashMap<String,Object>> queryFormalDataMonitor(@Param("monitorDate")String date);
	List<LinkedHashMap<String,Object>> querySyncDataMonitor(@Param("monitorDate")String date);
	int updateMonitorSyncFlag(@Param("tableName")String tableName,@Param("sourceFlag")int sourceFlag,@Param("targetFlag")int targetFlag);
}
