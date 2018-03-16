/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.service.conf.impl<br/>  
 * <b>文件名：</b>FollowupLocalProfileServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月11日上午11:53:17<br/>  
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
import com.esuizhen.cloudservice.followup.dao.conf.FollowupLocalProfileDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupLocalProfile;
import com.esuizhen.cloudservice.followup.service.conf.FollowupLocalProfileService;

/** 
* @ClassName: FollowupLocalProfileServiceImpl
* @Description: 
* @author NiDan
* @date 2016年8月11日上午11:53:17 
*/
@Service("followupLocalProfileService")
@Transactional
public class FollowupLocalProfileServiceImpl implements FollowupLocalProfileService {
	
	@Autowired
	private FollowupLocalProfileDao followupLocalProfileDao;
	
	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveFollowupLocalProfile(TFollowupLocalProfile followupLocalProfile) {	
		TFollowupLocalProfile LocalProfile=followupLocalProfileDao.queryFollowupLocalProfile(followupLocalProfile.getUserId());
		if(LocalProfile!=null){
			followupLocalProfile.setUpdateTime(new Date());
			followupLocalProfileDao.updateFollowupLocalProfile(followupLocalProfile);
		}else{
			followupLocalProfile.setCreateTime(new Date());
			followupLocalProfileDao.insertFollowupLocalProfile(followupLocalProfile);
		}
	}

	@Override
	public TFollowupLocalProfile queryFollowupLocalProfileByUserId(Long userId) {
		TFollowupLocalProfile LocalProfile=followupLocalProfileDao.queryFollowupLocalProfile(userId);
		/*if(LocalProfile != null) {
			TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
			LocalProfile.setOutsideCallNum(globalConfig.getOutsideCallNum());
			LocalProfile.setIpCallNum(globalConfig.getIpCallNum());
		}*/
		return LocalProfile;
	}

}
