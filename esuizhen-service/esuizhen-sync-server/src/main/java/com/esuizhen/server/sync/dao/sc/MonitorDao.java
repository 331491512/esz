/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.dao.sc;<br/>  
 * <b>文件名：</b>MonitorDao.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午4:13:20<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.dao.sc;
/** 
* @ClassName: MonitorDao
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午4:13:20  
*/
public interface MonitorDao {

	int insertTemp(Object clientTempDataMonitor);

	int insertFormal(Object clientTempDataMonitor);

	int insertSync(Object clientTempDataMonitor);

}
