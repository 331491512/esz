/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service;<br/>  
 * <b>文件名：</b>MonitorDataService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午4:08:08<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service;

import com.westangel.common.bean.sync.MonitorDataPushReq;

/** 
* @ClassName: MonitorDataService
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午4:08:08  
*/
public interface MonitorDataService {
	void pushMonitorData(MonitorDataPushReq req);
}
