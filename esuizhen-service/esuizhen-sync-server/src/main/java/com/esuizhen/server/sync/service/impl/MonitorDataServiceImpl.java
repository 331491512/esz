/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.impl;<br/>  
 * <b>文件名：</b>MonitorDataServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午4:11:24<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.server.sync.dao.sc.MonitorDao;
import com.esuizhen.server.sync.service.MonitorDataService;
import com.westangel.common.bean.sync.MonitorDataPushReq;
import com.westangel.common.excption.EmptyParamExcption;

/** 
* @ClassName: MonitorDataServiceImpl
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午4:11:24  
*/
@Service
public class MonitorDataServiceImpl implements MonitorDataService {
	
	@Autowired
	private MonitorDao monitorDao;
	@Override
	public void pushMonitorData(MonitorDataPushReq req) {
		// TODO Auto-generated method stub
		if(req==null)
			throw new EmptyParamExcption("req is null");
		if(req.getClientTempDataMonitor()!=null&&!req.getClientTempDataMonitor().isEmpty()){
			for(Object obj :req.getClientTempDataMonitor())
				monitorDao.insertTemp(obj);
		}
		if(req.getClientFormalDataMonitor()!=null&&!req.getClientFormalDataMonitor().isEmpty()){
			for(Object obj : req.getClientFormalDataMonitor())
				monitorDao.insertFormal(obj);
		}
		if(req.getClientSyncDataMonitor()!=null&&!req.getClientSyncDataMonitor().isEmpty()){
			for(Object obj : req.getClientSyncDataMonitor())
				monitorDao.insertSync(obj);
		}
	}
}
