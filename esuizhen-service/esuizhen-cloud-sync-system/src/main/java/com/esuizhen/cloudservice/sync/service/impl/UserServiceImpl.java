package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.service.UserService;
import com.esuizhen.cloudservice.sync.timerTask.ScanningTimerTask;
import com.westangel.common.bean.User;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;

/**
 * 
 * @author YYCHEN
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	
	
	@Autowired
	private ScanningTimerTask timerTask;
	
	
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;
	
	@Override
	public void scanning(boolean flag){
		if (flag) {
			new Thread(){
				public void run() {
					timerTask.scanning();
				}
			}.start();
		}
		ScanningTimerTask.run_flag = flag;
		if (!flag) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ScanningTimerTask.run_flag = true;
		}
	}

	@Override
	public TConfirmUserResp affirm(TConfirmUserReq confirmUserReq) throws EmptyParamExcption {
		if (StringUtils.isEmpty(confirmUserReq.getUuid()) ||
				confirmUserReq.getUserId() == null ||
				confirmUserReq.getUserRole() == null) {
			throw new EmptyParamExcption("Params:" + JsonUtil.toJson(confirmUserReq) + ", Key parameter is empty!");
		}
		Integer affirm = 1;
		User user = this.cloudUserDao.findByUuid(confirmUserReq.getUuid());
		if (user != null) {
			if(user.getRole()==Constant.User.ROLE_PATIENT){
				affirm = matchPatientDao.findAffirmByMatchUuid(confirmUserReq.getUuid());
			}else if(user.getRole()==Constant.User.ROLE_DOCTOR){
				affirm = matchDoctorDao.findAffirmByMatchUuid(confirmUserReq.getUuid());
			}
			if(affirm == null){
				affirm = 1;
			}
		}
		if (affirm == 0) {
			User cloudUser = this.cloudUserDao.findByUserId(confirmUserReq.getUserId(), confirmUserReq.getUserRole());
			if (cloudUser == null) {
				affirm = 1;
			}
		}
		TConfirmUserResp confirmUserResp = new TConfirmUserResp();
		confirmUserResp.setAffirm(affirm);
		return confirmUserResp;
	}
}
