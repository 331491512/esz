package com.esuizhen.cloudservice.sync.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreDoctorDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreHospitalDoctorDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreUserDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUserDao;
import com.esuizhen.cloudservice.sync.handle.PushDoctorNotifyHandle;
import com.esuizhen.cloudservice.sync.model.HospitalDoctor;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.DoctorService;
import com.esuizhen.cloudservice.sync.txservice.TxDoctorService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.User;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * 患者数据同步业务层实现
 * @author YYCHEN
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private IncreUserDao increUserDao;
	@Autowired
	private IncreDoctorDao increDoctorDao;
	@Autowired
	private IncreHospitalDoctorDao increHospitalDoctorDao;
	
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	
	
	@Autowired
	private MatchUserDao matchUserDao;
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	
	@Autowired
	private TxDoctorService txDoctorService;
	@Autowired
	private PushDoctorNotifyHandle doctorPushHandle;
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${push.weixin.qr.get}")
	private String pushWeixinQrGetUrl;
	@Value("${sms.captcha.check}")
	private String smsCaptchaCheck;
	
	/**
	 *  "uuid":”350000es34n6i3n790djjde33s”，
	 *	"userNumber":”001256”,
	 *	"trueName”:”老王”,
	 *	"sex":1,
	 *	"mobile":"13566666666",
	 *	"email":"laowang@test.com"，
	 *	"deptUuid":"asfasdfasdf415454",
	 *	"childDeptUuid":1,
	 *	"professionalRankId":13,
	 *	"positionTitleId":101, 
	 *	"hospitalId ":15,
	 *	"idType":1,
	 *	"identification”:”10045614782215455555”,
	 *	"birthDate":"2015-09-08 09:06:06"
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	@Transactional
	@Override
	public boolean synchDoctor(TDoctorSyncProfile doctorSyncProfile) throws HospitalWithoutRightExcption{
		if(doctorSyncProfile==null||!checkBeforeSyncService.checkHospitalId(doctorSyncProfile.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		
		//先将数据保存到增量库
		this.saveIncreUserAndDoctor(doctorSyncProfile);
		//保存到生产库
		return this.txDoctorService.syncDoctor(doctorSyncProfile);
	}
	
	/**
	 * 将医生数据保存到同步数据库
	 * @param doctorInfoSyncProfile
	 * @return
	 */
	private boolean saveIncreUserAndDoctor(TDoctorSyncProfile doctorSyncProfile){
		LogUtil.log.debug("Synchronize physician data to incremental Libraries---------->>");
		Date nowTime = new Date();
		doctorSyncProfile.setSyncTime(nowTime);
		if(doctorSyncProfile.getCreateTime()==null)
			doctorSyncProfile.setCreateTime(nowTime);
		if(doctorSyncProfile.getUpdateTime()==null)
			doctorSyncProfile.setUpdateTime(nowTime);
		if(StringUtils.isNotEmpty(doctorSyncProfile.getUserNumber()))
			doctorSyncProfile.setStaffNo(doctorSyncProfile.getUserNumber());
		
		//用户数据
		User user = doctorSyncProfile.createUser();
		this.increUserDao.insert(user);
		//医生数据
		Doctor doctor = doctorSyncProfile.createDoctor();
		doctor.setUserId(user.getUserId());
		this.increDoctorDao.insert(doctor);
		//医院、科室、医生关系数据
		HospitalDoctor hospitalDoctor = doctorSyncProfile.createHospitalDoctor();
		this.increHospitalDoctorDao.insert(hospitalDoctor);
		LogUtil.log.debug("Synchronize physician data to the incremental Library----------<<");
		return true;
	}

	/**
	 * 确认医生是否本人
	 * @throws ParamMismatchExcption 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TConfirmUserResp confirmDoctor(TConfirmUserReq confirmReq) throws EmptyParamExcption, ParamMismatchExcption {
		if (confirmReq.getIsConfirmed() == null) {
			throw new EmptyParamExcption("\"isConfirmed\" is empty!");
		}
		User user = null;
		if (1 == confirmReq.getIsConfirmed()) {//如果确认是本人，需要把匹配库里的数据合并到云端库
			if (StringUtils.isEmpty(confirmReq.getCaptcha())) {//验证码校验
				throw new EmptyParamExcption("\"captcha\" is empty!");
			} else {// 判断验证码是否有效
				LogUtil.logError.debug("smsInnerService.checkCaptcha()开始验证，手机号：" + confirmReq.getMobile() + ",验证码：" + confirmReq.getCaptcha());
				try {
					Map<String, String> headerMap = new HashMap<String, String>();
					headerMap.put("Content-type", "application/json");
					String weixinQRJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=1&mobile=" + confirmReq.getMobile() + "&captcha=" + confirmReq.getCaptcha());
					TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
					if (smsTMsgResponse.getRespCode() != 0) {
						LogUtil.logError.error("smsInnerService.checkCaptcha(),验证验证码,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
						throw new ParamMismatchExcption("\"captcha\" is error!");
					}
					LogUtil.logError.debug("smsInnerService.checkCaptcha()返回true，验证成功，手机号：" + confirmReq.getMobile() + ",验证码：" + confirmReq.getCaptcha());
				} catch (Exception ex) {
					throw new ParamMismatchExcption(ex.getMessage());
				}
			}
			//合并医生数据
			user = this.txDoctorService.mergeDoctor(confirmReq.getUuid(), confirmReq.getUserId());
			//修改用户的审核状态
			Doctor doctor = this.cloudDoctorDao.findByUserId(user.getUserId());
			this.modifyUserAuditstate(user, doctor);
		} else {
			matchUserDao.updateAccountType(confirmReq.getUuid(), Constant.User.ACCOUNTTYPE_REFUSE);
			user = this.cloudUserDao.findByUserId(confirmReq.getUserId(), Constant.User.ROLE_DOCTOR);
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("targetUserId", confirmReq.getUserId());
			params.put("matchUuid", confirmReq.getUuid());
			params.put("affirm", -1);
			matchDoctorDao.setAffirm(params);
		}
		TTobeconfirmedDoctor doctor = this.matchDoctorDao.selectNopushDoctor(confirmReq.getUserId());
		if (doctor == null) {
			doctor = new TTobeconfirmedDoctor();
			doctor.setUserId(confirmReq.getUserId());
		}
		try {
			//推送确认结果
			doctorPushHandle.sendNotifyToDoctorConfirmationResult(doctor, confirmReq.getIsConfirmed());
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
		}
		if (user != null) {
			TConfirmUserResp resp = new TConfirmUserResp();
			resp.setAccountType(user.getAccountType());
			resp.setInfoState(user.getInfoState());
			resp.setUserId(user.getUserId());
			return resp;
		}
		return null;
	}

	/**
	 * 
	 * @param user
	 * @param doctor
	 * @return
	 */
	private boolean modifyUserAuditstate(User user, Doctor doctor){
		if (doctor.getAuditState() == null ||
				doctor.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
			
			user.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			user.setSyncFlag(Constant.SYNC_OK);
			doctor.setAuditState(Constant.User.AUDITSTATE_PRIMARYPENDING);
			doctor.setSyncFlag(Constant.SYNC_OK);
			this.cloudUserDao.update(user);
			this.cloudDoctorDao.update(doctor);
			//向医生推送消息
			//this.auditDoctorSmsContentSend(user.getMobile(), doctor.getAuditState());
			//生成医生的二维码
			//this.generateQRCode(user.getUserId());
		}
		return true;
	}
	
	
	

	/**
	 * 
	 * @param matchUserId
	 * @param cloudDoctor
	 * @return
	 */
	private boolean mergeDoctor(Long matchUserId, Doctor cloudDoctor) {
		LogUtil.log.debug("Start with physician data---------->>");
		Doctor matchDoctor = this.matchDoctorDao.findByUserId(matchUserId);
		if (matchDoctor == null || cloudDoctor == null) {
			return false;
		}
		//trueName
		if (StringUtils.isNotEmpty(matchDoctor.getTrueName())) {
			cloudDoctor.setTrueName(matchDoctor.getTrueName());
		}
		//sex
		if (matchDoctor.getSex() != null && matchDoctor.getSex() != 0) {
			cloudDoctor.setSex(matchDoctor.getSex());
		}
		//mobile
		if (StringUtils.isNotEmpty(matchDoctor.getMobile()) &&
				StringUtils.isEmpty(cloudDoctor.getMobile())) {
			cloudDoctor.setMobile(matchDoctor.getMobile());
		}
		//professionalRankId
		if (matchDoctor.getProfessionalRank() != null &&
				matchDoctor.getProfessionalRank() != 0) {
			cloudDoctor.setProfessionalRank(matchDoctor.getProfessionalRank());
		}
		//positionTitleId
		if (matchDoctor.getPositionTitle() != null &&
				matchDoctor.getPositionTitle() != 0) {
			cloudDoctor.setPositionTitle(matchDoctor.getPositionTitle());
		}
		//birthDate
		if (matchDoctor.getBirthDate() != null) {
			cloudDoctor.setBirthDate(matchDoctor.getBirthDate());
		}
		cloudDoctor.setSyncFlag(Constant.User.SYNCFLAG_YES);
		this.cloudDoctorDao.update(cloudDoctor);
		this.matchDoctorDao.delete(matchDoctor.getDoctorId());
		LogUtil.log.debug("Combined doctor data is completed----------<<");
		return true;
	}
}
