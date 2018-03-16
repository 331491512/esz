package com.esuizhen.cloudservice.user.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.dao.UUserPingDao;
import com.esuizhen.cloudservice.user.model.UUserPing;
import com.esuizhen.cloudservice.user.service.UUserPingService;
import com.esuizhen.cloudservice.user.service.UserDeviceService;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.InsufficientParameterExcption;

@Service
public class UUserPingServiceImpl implements UUserPingService {
	@Autowired
	private UUserPingDao uUserPingDao;
	@Autowired
	private UserDeviceService userDeviceService;

	@Transactional
	@Override
	public boolean userStatisPing(List<UUserPing> pingInfoes, String ip) throws InsufficientParameterExcption {
		for (int i = 0, size = pingInfoes.size(); i < size; i++) {
			UUserPing userPing = pingInfoes.get(i);
			//验证临时用户ID
			if (StringUtils.isEmpty(userPing.getLuid())) {
				throw new InsufficientParameterExcption("luid is empty!");
			}
			//验证role
			if (userPing.getRole() == null) {
				throw new InsufficientParameterExcption("role is empty!");
			}
			//验证userId
			if (userPing.getUserId() == null) {
				throw new InsufficientParameterExcption("userId is empty!");
			}
			if (userPing.getBusinessId() == null) {
				userPing.setBusinessId(1);
			}
			if (userPing.getProductId() == null) {
				userPing.setProductId(1);
			}
			if (StringUtils.isEmpty(userPing.getIpAddress())) {
				userPing.setIpAddress(ip);
			}
			if (userPing.getUploadTime() == null) {
				userPing.setUploadTime(new Date());
			}
			//保存
			this.uUserPingDao.insert(userPing);
			
			//更新新使用设备APP的版本
			this.userDeviceService.renovateDeviceInfo(userPing);
		}
		return true;
	}

	@Override
	public void userStatisPingWX(List<UUserPing> userPings, String ip) {
		// TODO Auto-generated method stub
		for(UUserPing userPing:userPings){
			//验证临时用户ID
			if (StringUtils.isEmpty(userPing.getLuid())) {
				throw new EmptyParamExcption("luid is empty!");
			}
			//验证role
			if (userPing.getRole() == null) {
				throw new EmptyParamExcption("role is empty!");
			}
			//验证userId
			if (userPing.getUserId() == null) {
				throw new EmptyParamExcption("userId is empty!");
			}
			if (userPing.getBusinessId() == null) {
				userPing.setBusinessId(1);
			}
			if (userPing.getProductId() == null) {
				userPing.setProductId(1);
			}
			if (StringUtils.isEmpty(userPing.getIpAddress())) {
				userPing.setIpAddress(ip);
			}
			if (userPing.getUploadTime() == null) {
				userPing.setUploadTime(new Date());
			}
			//保存
			this.uUserPingDao.insertWX(userPing);
		}
	}
}
