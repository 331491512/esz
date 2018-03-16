/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf.impl<br/>  
 * <b>文件名：</b>FollowupGlobalConfigInfoServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日上午10:51:47<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.service.conf.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.dao.meta.FollowupMetaInfoDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.service.conf.FollowupGlobalConfigInfoService;

/** 
* @ClassName: FollowupGlobalConfigInfoServiceImpl
* @Description: 
* @author NiDan
* @date 2016年8月11日上午10:51:47 
*/
@Service("followupGlobalConfigInfoService")
@Transactional
public class FollowupGlobalConfigInfoServiceImpl implements FollowupGlobalConfigInfoService{
	
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;
	@Autowired
	private FollowupMetaInfoDao followupMetaInfoDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveFollowupGlobalConfigInfo(TFollowupGlobalConfigInfo followupGlobalConfigInfo) {
		followupGlobalConfigInfo.setUpdateTime(new Date());
		followupGlobalConfigInfoDao.updateFollowupGlobalConfigInfo(followupGlobalConfigInfo);
		FollowupResultValue followupResultValue=new FollowupResultValue();
		followupResultValue.setFollowupResultValueId(5);
		if(followupGlobalConfigInfo.getOtherAsValidResultFlag()!=null&&followupGlobalConfigInfo.getOtherAsValidResultFlag().equals(1))
			followupResultValue.setType(1);
		else
			followupResultValue.setType(2);
		followupMetaInfoDao.updateFollowupResultValueType(followupResultValue);
	}

	@Override
	public TFollowupGlobalConfigInfo selectFollowupGlobalConfigInfo() {
		TFollowupGlobalConfigInfo followupGlobalConfigInfo=followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		return followupGlobalConfigInfo;
	}

}
