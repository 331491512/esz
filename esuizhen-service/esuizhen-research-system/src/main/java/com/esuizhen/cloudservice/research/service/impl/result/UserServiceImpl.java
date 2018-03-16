package com.esuizhen.cloudservice.research.service.impl.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.dao.result.UserDao;
import com.esuizhen.cloudservice.research.service.result.UserService;
import com.westangel.common.bean.User;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		User user = new User();
		user.setUserName(projectSubcenterDetailInfo.getMobile());
		user.setTrueName(projectSubcenterDetailInfo.getTrueName());
		user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		user.setMobile(projectSubcenterDetailInfo.getMobile());
		user.setEmail(projectSubcenterDetailInfo.getEmail());
		this.userDao.insert(user);
		return user;
	}

}
