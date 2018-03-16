package com.westangel.commonservice.authorization.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.bean.TUserDoctorInfo;
import com.westangel.commonservice.authorization.service.DoctorService;
import com.westangel.commonservice.authorization.service.UserService;

@Controller
public class UserController {
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${sms.captcha.check}")
	private String smsCaptchaCheck;
	
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserService userService;
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * <p>Title:getManagerInfo</p>
	 * <p>Description:管理员信息获取</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午3:05:26
	 * @param locale
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manager/user/obtain", method = RequestMethod.GET)
	public TMsgResponse<UserProfile> getManagerInfo(Locale locale, Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<UserProfile> tMsgResponse = new TMsgResponse<UserProfile>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			UserProfile userProfile = this.userService.getManagerInfo(userId);
			if (userProfile == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(userProfile);
			}
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:updateManagerInfo</p>
	 * <p>Description:管理员个人信息修改</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午4:04:22
	 * @param locale
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/manager/info/update", method = RequestMethod.POST)
	public TMsgResponse<Void> updateManagerInfo(Locale locale, @RequestBody User user) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.userService.updateManagerInfo(user);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public TMsgResponse<UserProfileDetailResp> login(Locale locale, @RequestBody User user) {
		// 设置返回成功代码及提示消息
		TMsgResponse<UserProfileDetailResp> tMsgResponse = new TMsgResponse<UserProfileDetailResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.userService.login(user));
		} catch(RemoteCallExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1405.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1405.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1402.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1402.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1420.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1420.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title:addUserDoctor</p>
	 * <p>Description:医生用户信息添加</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:22:23
	 * @param locale
	 * @param userDoctorInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public TMsgResponse<Void> addUser(Locale locale, @RequestBody TUserDoctorInfo userDoctorInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.userService.addUser(userDoctorInfo);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectAlreadyExistExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1409.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1409.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public TMsgResponse<Void> updateUser(Locale locale, @RequestBody TUserDoctorInfo userDoctorInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.userService.updateUser(userDoctorInfo);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title:updateUserState</p>
	 * <p>Description:更新用户状态</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午4:58:07
	 * @param locale
	 * @param userId
	 * @param state
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/state/update", method = RequestMethod.GET)
	public TMsgResponse<Void> updateUserState (Locale locale, Long userId, Integer state) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.userService.updateUserState(userId, state);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1404.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:getDoctorUserList</p>
	 * <p>Description:获取账号列表</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午7:43:40
	 * @param locale
	 * @param userDoctorInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/list", method = RequestMethod.POST)
	public TMsgResponse<Page<UserProfile>> getUserList(Locale locale, @RequestBody TUserDoctorInfo userDoctorInfo) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<UserProfile>> tMsgResponse = new TMsgResponse<Page<UserProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<UserProfile> page = this.userService.getUserList(userDoctorInfo);
			if (page == null || page.getDataList() == null || page.getDataList().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(page);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/passwd/modify", method = RequestMethod.POST)
	public TMsgResponse<Page<UserProfile>> modifyPasswd(Locale locale, @RequestBody UserProfile userProfile) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<UserProfile>> tMsgResponse = new TMsgResponse<Page<UserProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if(userProfile!=null&&userProfile.getConfirmFlag()!=null&&userProfile.getConfirmFlag()==0){
				if(userProfile.getBySmsCodeFlag()!=null&&userProfile.getBySmsCodeFlag()==1){
					String smsSendJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=1&mobile=" + userProfile.getUserName() + "&captcha=" + userProfile.getSmsCode());
					tMsgResponse = JsonUtil.toObject(smsSendJson, TMsgResponse.class);
					if(0!=tMsgResponse.getRespCode())return tMsgResponse;//当短信验证失败时
				}
			}
			this.userService.modifyPasswd(userProfile);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(ObjectNotAvailableExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch(RejectRequestExcption ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1400.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:getOrganizationStructure</p>
	 * <p>Description:获取组织架构</p>
	 * @author YYCHEN
	 * @date 2016年8月5日 上午11:14:02
	 * @param locale
	 * @param level
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/organizational/structure/search", method = RequestMethod.GET)
	public TMsgResponse<List<Doctor>> getOrganizationStructure(Locale locale, Integer hospitalId, Long userId) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<Doctor>> tMsgResponse = new TMsgResponse<List<Doctor>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<Doctor> doctors = this.doctorService.getOrganizationStructure(hospitalId, userId);
			if (doctors == null || doctors.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(doctors);
			}
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/activation/cancellation", method = RequestMethod.POST)
	public TMsgResponse<Page<UserProfile>> activationOrCancellation(Locale locale, @RequestBody UserProfile userProfile) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<UserProfile>> tMsgResponse = new TMsgResponse<Page<UserProfile>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.userService.activationOrCancellation(userProfile);
		} catch(InsufficientParameterExcption ex){
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1403.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			// 设置错误代码及提示消息
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
