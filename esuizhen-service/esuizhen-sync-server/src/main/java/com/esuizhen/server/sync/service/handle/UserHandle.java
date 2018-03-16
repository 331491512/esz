/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.service.handle;<br/>  
 * <b>文件名：</b>UserHandle.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月30日下午8:43:52<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.service.handle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.server.sync.dao.server.UserDao;
import com.esuizhen.server.sync.model.server.User;
import com.esuizhen.server.sync.model.temp.SyncUser;

/** 
* @ClassName: UserHandle
* @Description: 
* @author lichenghao
* @date 2017年3月30日 下午8:43:52  
*/
@Component
public class UserHandle {
	@Autowired
	private UserDao userDao;
	
	public void checkUpdateUser(SyncUser tempUser){
		tempUser.setState(null);
		tempUser.setUserName(null);
		tempUser.setCryptPasswd(null);
		tempUser.setAccountType(null);
		tempUser.setSourceFlag(null);
		tempUser.setUserFlag(null);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", tempUser.getUserId());
		User user = userDao.queryUser(params);
		if(user==null)
			return;
		tempUser.setWeixinFlag(this.validateValue(tempUser.getWeixinFlag(), user.getWeixinFlag()));
		tempUser.setAppFlag(this.validateValue(tempUser.getAppFlag(), user.getAppFlag()));
		tempUser.setPcFlag(this.validateValue(tempUser.getPcFlag(), user.getPcFlag()));
		if(user.getInfoState()>tempUser.getInfoState())
			tempUser.setInfoState(user.getInfoState());
		if(user.getInfoState()>1){//身份证号不覆盖
			tempUser.setIdType(null);
			tempUser.setIdentification(null);
		}
	}
	
	public Integer validateValue(Integer clientFlag,Integer serverFlag){
		if(serverFlag==null)
			return clientFlag;
		else if(clientFlag==null)
			return clientFlag;
		else if(clientFlag>serverFlag)
			return clientFlag;
		else 
			return null;
	}
	
	//合并用户
	public User mergeUser(User matchUser, User targetUser) {
		matchUser.setUserId(targetUser.getUserId());
		matchUser.setState(null);
		matchUser.setWeixinFlag(null);
		matchUser.setPcFlag(null);
		matchUser.setAccountType(null);
		if(matchUser.getInfoState()!=null&&targetUser.getInfoState()!=null&&matchUser.getInfoState()<targetUser.getInfoState()){
			matchUser.setInfoState(null);
		}
		matchUser.setUserName(null);
		matchUser.setCryptPasswd(null);
		matchUser.setSourceFlag(null);//患者来源不覆盖
		//如果身份证号不为空  则不覆盖
		if(!StringUtils.isBlank(targetUser.getIdentification())){
			matchUser.setIdType(null);
			matchUser.setIdentification(null);
		}
		return matchUser;
	}
}
