/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.service.impl;<br/>  
 * <b>文件名：</b>HospitalIncreSyncServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年2月10日上午9:59:04<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.dao.cloud.HospitalIncreLogDao;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.HospitalIncreSyncStatisService;
import com.westangel.common.bean.sync.THospitalIncreLog;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;

/** 
* @ClassName: HospitalIncreSyncServiceImpl
* @Description: 
* @author lichenghao
* @date 2017年2月10日 上午9:59:04  
*/
@Service
public class HospitalIncreSyncServiceImpl implements HospitalIncreSyncStatisService {
	
	
	@Autowired
	private HospitalIncreLogDao dao;
	
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	/**
	 * 同步增量统计数据
	 */
	@Override
	public void syncHospitalIncreLog(THospitalIncreLog hospitalIncreLog) {
		// TODO Auto-generated method stub
		if(hospitalIncreLog.getHospitalId()==null)
			throw new EmptyParamExcption(" hospitalId is null");
		if(!checkBeforeSyncService.checkHospitalId(hospitalIncreLog.getHospitalId()))
			throw new EmptyObjectExcption(" hospitalId not in cloud or not allow sync");
		dao.insert(hospitalIncreLog);
	}

}
