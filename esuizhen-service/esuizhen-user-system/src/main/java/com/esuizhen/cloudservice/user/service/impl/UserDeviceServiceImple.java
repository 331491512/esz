package com.esuizhen.cloudservice.user.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.dao.UserDeviceDao;
import com.esuizhen.cloudservice.user.model.UUserDevice;
import com.esuizhen.cloudservice.user.model.UUserPing;
import com.esuizhen.cloudservice.user.service.UserDeviceService;
import com.westangel.common.bean.user.UserRegisterResp;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;

@Service
public class UserDeviceServiceImple implements UserDeviceService {
	@Autowired
	private UserDeviceDao userDeviceDao;

	@Transactional
	@Override
	public UserRegisterResp guestUserAccess(UserRegisterReq userRegisterReq) throws RejectRequestExcption {
		//验证role
		if (userRegisterReq.getRole() == null) {
			throw new EmptyParamExcption("role is empty!");
		}
		UUserDevice deviceInfo = userRegisterReq.getDeviceInfo();
		//处理role
		if (deviceInfo.getRole() == null) {
			deviceInfo.setRole(userRegisterReq.getRole());
		}
		//验证deviceId
		if (StringUtils.isEmpty(deviceInfo.getDeviceId())) {
			throw new EmptyParamExcption("deviceId is empty!");
		}
		//处理businessId
		if (deviceInfo.getBussinessId() == null) {
			deviceInfo.setBussinessId(1);
		}
		//处理productId
		if (deviceInfo.getProductId() == null) {
			deviceInfo.setProductId(1);
		}
		//处理userId
		deviceInfo.setUserId(Constant.User.TOURIST_ID);
		//处理luid
		StringBuilder luid = new StringBuilder();
		luid.append(deviceInfo.getBussinessId());
		luid.append("-");
		luid.append(deviceInfo.getProductId());
		luid.append("-");
		luid.append(deviceInfo.getDeviceType());
		luid.append("-");
		luid.append(deviceInfo.getDeviceId());
		luid.append("-");
		luid.append(deviceInfo.getRole());
		luid.append("-");
		luid.append(deviceInfo.getUserId());
		deviceInfo.setLuid(luid.toString());
		//验证同一台设备不能有超过十个游客
		if (this.userDeviceDao.queryCount(deviceInfo, null) >= 10) {
			throw new RejectRequestExcption("Too many users of this device are logged on.");
		}
		deviceInfo.setOpFlag(0);
		if (this.userDeviceDao.queryCount(deviceInfo, Constant.User.TOURIST_ID) > 0) {
			//修改设备信息
			this.userDeviceDao.update(deviceInfo, deviceInfo.getRole(), deviceInfo.getProductId());
		}else{
			//保存设备信息
			this.userDeviceDao.insert(deviceInfo);
		}
		
		UserRegisterResp userRegisterResp = new UserRegisterResp();
		userRegisterResp.setLuid(deviceInfo.getLuid());
		userRegisterResp.setUserId(deviceInfo.getUserId());
		userRegisterResp.setPingInterval(4);//统计Ping时间间隔。单位：小时
		return userRegisterResp;
	}

	@Transactional
	@Override
	public boolean renovateDeviceInfo(UUserPing userPing){
		if (StringUtils.isEmpty(userPing.getLuid())) {
			return false;
		}
		if (this.userDeviceDao.exsitDeviceInfo(userPing.getLuid()) < 1) {
			UUserDevice deviceInfo = new UUserDevice();
			deviceInfo.setLuid(userPing.getLuid());
			deviceInfo.setRole(userPing.getRole());
			deviceInfo.setDeviceId(userPing.getDeviceId());
			deviceInfo.setOpFlag(1);
			deviceInfo.setDeviceType(userPing.getDeviceType());
			if (deviceInfo.getDeviceType() == null) {
				deviceInfo.setDeviceType(3);
			}
			deviceInfo.setBussinessId(userPing.getBusinessId());
			deviceInfo.setProductId(userPing.getProductId());
			deviceInfo.setUserId(userPing.getUserId());
			deviceInfo.setPlatform(userPing.getPlatform());
			deviceInfo.setAppVersion(userPing.getAppVersion());
			deviceInfo.setLocation(userPing.getLocation());
			deviceInfo.setIpAddress(userPing.getIpAddress());
			
			this.userDeviceDao.insert(deviceInfo);
		}else if (StringUtils.isNotEmpty(userPing.getAppVersion())) {
			this.userDeviceDao.updateUserDevice(userPing.getLuid(), userPing.getAppVersion());
		}
		return true;
	}

}
