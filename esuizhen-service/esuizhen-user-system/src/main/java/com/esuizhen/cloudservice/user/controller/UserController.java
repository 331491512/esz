/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>UserController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月2日-下午5:23:26<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller;

import com.esuizhen.cloudservice.user.bean.*;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.UUserDevice;
import com.esuizhen.cloudservice.user.service.ExpressAddressService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.westangel.common.bean.*;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.bean.user.UserLoginOutResp;
import com.westangel.common.bean.user.UserRegisterResp;
import com.westangel.common.excption.*;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** 
* @ClassName: UserController 
* @Description: 用户相关操作
* @author YYCHEN
* @date 2015年12月2日 下午5:23:26  
*/
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messageSource;
	//@Resource(name="smsInnerService")
	//private SmsInnerService smsInnerService;
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${sms.captcha.check}")
	private String smsCaptchaCheck;
	@Autowired
	private ExpressAddressService expressAddressService;

	/**
	 * @param @param  locale
	 * @param @param  confirmUserInfo
	 * @param @return 设定文件
	 * @return TMsgResponse<Void>    返回类型
	 * @throws
	 * @Title: confirm
	 * @Description: 用户确认是否本人
	 */
	@ResponseBody
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public TMsgResponse<TConfirmUserResp> confirmUser(Locale locale, @RequestBody TConfirmUserReq confirmUserInfo) {
		LogUtil.log.info("用户确认ToB导入的信息(confirmUser)==========>>");
		TMsgResponse<TConfirmUserResp> tMsgResponse = new TMsgResponse<TConfirmUserResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TConfirmUserResp resp = userService.confirmUserInfo(confirmUserInfo);
			tMsgResponse.setResult(resp);
		} catch (ObjectAlreadyExistExcption ex) {
			LogUtil.logError.error(ex.getCause() + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1401.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1401.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (RemoteCallExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1421.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1421.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @param
	 * @return TMsgResponse
	 * @throws
	 * @Title: modifyPassword
	 * @Description: 忘记密码重置密码
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/passwdmodify", method = RequestMethod.POST)
	public TMsgResponse<Void> modifyPassword(Locale locale, @RequestBody PasswordModifyReq passwordModifyReq) {
		LogUtil.log.info("忘记密码重置密码(modifyPassword)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		String authcode = passwordModifyReq.getAuthcode();
		if (StringUtils.isBlank(authcode) ||
				StringUtils.isBlank(passwordModifyReq.getMobile()) ||
				StringUtils.isBlank(passwordModifyReq.getNewPasswd())) {
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		} else {
			// 判断验证码是否有效
			try {
				LogUtil.logError.debug("smsInnerService.checkCaptcha()开始验证，手机号：" + passwordModifyReq.getMobile() + ",验证码：" + passwordModifyReq.getAuthcode());
				Map<String, String> headerMap = new HashMap<String, String>();
				headerMap.put("Content-type", "application/json");
				String weixinQRJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=1&mobile=" + passwordModifyReq.getMobile() + "&captcha=" + passwordModifyReq.getAuthcode());
				TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
				if (smsTMsgResponse.getRespCode() != 0) {
					LogUtil.logError.error("smsInnerService.checkCaptcha(),验证验证码,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
					tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
					tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
					return tMsgResponse;
				}
				LogUtil.logError.debug("smsInnerService.checkCaptcha()返回true，验证成功，手机号：" + passwordModifyReq.getMobile() + ",验证码：" + passwordModifyReq.getAuthcode());
			} catch (Exception ex) {
				LogUtil.logError.error("smsInnerService.checkCaptcha()" + ex.getCause() + "\t" + ex.getMessage());
				tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, new Object[]{ex.getMessage()}, locale));
				return tMsgResponse;
			}
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage("set.success", null, locale));
		try {
			userService.modifyPassword(passwordModifyReq);
		} catch (ObjectNotAvailableExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1300.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1300.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyObjectExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ParamFormatErrorExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (RejectRequestExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage("set.error", null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public TMsgResponse<UserRegisterResp> login(Locale locale, HttpServletRequest request, @RequestBody UserRegisterReq userRegisterReq) {
		LogUtil.log.info("登录进入(login)==========>>");
		UUserDevice deviceInfo = userRegisterReq.getDeviceInfo();
		if (deviceInfo != null && StringUtils.isEmpty(deviceInfo.getIpAddress())) {
			deviceInfo.setIpAddress(request.getRemoteAddr());
		}
		TMsgResponse<UserRegisterResp> tMsgResponse = new TMsgResponse<UserRegisterResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(userService.loginselectUser(userRegisterReq));
		} catch (EmptyObjectExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1402.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1402.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ParamMismatchExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1420.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1420.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ObjectNotAvailableExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1300.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1300.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>Title: getMACAddress</p>
	 * <p>Description: 获取指定IP的MAC地址</p>
	 *
	 * @param ip
	 * @return
	 * @date 2016年4月21日 下午6:13:17
	 */
	private String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			LogUtil.logError.error(e.getMessage());
		}
		return macAddress;
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public TMsgResponse<UserRegisterResp> register(Locale locale, HttpServletRequest request, @RequestBody UserRegisterReq userRegisterReq) {
		LogUtil.log.info("用户注册(register)==========>>");
		UUserDevice deviceInfo = userRegisterReq.getDeviceInfo();
		if (deviceInfo != null && StringUtils.isEmpty(deviceInfo.getIpAddress())) {
			deviceInfo.setIpAddress(request.getRemoteAddr());
		}
		TMsgResponse<UserRegisterResp> tMsgResponse = new TMsgResponse<UserRegisterResp>();
		if (userRegisterReq == null ||
				userRegisterReq.getLoginType() == null ||
				userRegisterReq.getUserName() == null ||
				userRegisterReq.getRole() == null) {
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		}
		switch (userRegisterReq.getLoginType()) {
			//验证码登录
			case 1:
				String authcode = userRegisterReq.getAuthcode();
				if (!StringUtils.isBlank(authcode)) {
					// 判断验证码是否有效
					LogUtil.logError.debug("smsInnerService.checkCaptcha()开始验证，手机号：" + userRegisterReq.getUserName() + ",验证码：" + userRegisterReq.getAuthcode());
					try {
						Map<String, String> headerMap = new HashMap<String, String>();
						headerMap.put("Content-type", "application/json");
						String weixinQRJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=1&mobile=" + userRegisterReq.getUserName() + "&captcha=" + userRegisterReq.getAuthcode());
						TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
						if (smsTMsgResponse.getRespCode() != 0) {
							LogUtil.logError.error("smsInnerService.checkCaptcha(),验证验证码,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
							tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
							tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
							return tMsgResponse;
						}
						LogUtil.log.debug("smsInnerService.checkCaptcha()返回true，验证成功，手机号：" + userRegisterReq.getUserName() + ",验证码：" + userRegisterReq.getAuthcode());
					} catch (Exception ex) {
						LogUtil.logError.error("smsInnerService.checkCaptcha()" + ex.getCause() + "\t" + ex.getMessage());
						tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
						tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, new Object[]{ex.getMessage()}, locale));
						tMsgResponse.setErrorDesc(ex.getMessage());
						return tMsgResponse;
					}
					break;
				} else {//未输入验证码
					tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
					return tMsgResponse;
				}
				//密码登录
			case 2:
				String cryptPasswd = userRegisterReq.getCryptPasswd();
				//未输入密码
				if (StringUtils.isBlank(cryptPasswd)) {
					tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
					return tMsgResponse;
				}
				break;
			default:
				tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
				return tMsgResponse;
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		// TODO 判断邀请码是否有效
		try {
			tMsgResponse.setResult(userService.register(userRegisterReq));
		} catch (ObjectNotAvailableExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1300.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1300.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1419.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (InsufficientParameterExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1422.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1422.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ParamFormatErrorExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (RejectRequestExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1501.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1501.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (ObjectAlreadyExistExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1502.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1502.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage("login.error", null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @param
	 * @return TMsgResponse<UserProfileDetailReq>
	 * @throws
	 * @Title: getDetailUserProfile
	 * @Description: 根据用户编号获取用户详细信息
	 */
	@ResponseBody
	@RequestMapping("/profile/detail")
	public TMsgResponse<UserProfileDetailResp> getDetailUserProfile(Locale locale, UserProfileDetailReq req) {
		LogUtil.log.info("根据用户编号获取用户详细信息(getDetailUserProfile)==========>>");
		TMsgResponse<UserProfileDetailResp> tMsgResponse = new TMsgResponse<UserProfileDetailResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			UserProfileDetailResp userProfileDetailResp = userService.getDetailUserProfile(req);
			tMsgResponse.setResult(userProfileDetailResp);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1402.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1402.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (EmptyObjectExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @param
	 * @return TMsgResponse<Long>
	 * @throws
	 * @Title: modifyUserProfile
	 * @Description: 设置用户详细资料
	 */
	@ResponseBody
	@RequestMapping(value = "/profile/modify", method = RequestMethod.POST)
	public TMsgResponse<LoginByThirdPartyResp> modifyUserProfile(@RequestBody UserProfileModifyReq userProfileModifyReq, Locale locale) {
		LogUtil.log.info("设置用户详细资料(modifyUserProfile)==========>>");
		TMsgResponse<LoginByThirdPartyResp> tMsgResponse = new TMsgResponse<LoginByThirdPartyResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage("submit.success", null, locale));
		try {
			tMsgResponse.setResult(this.userService.modifyUserProfile(userProfileModifyReq));
		} catch (ParamMismatchExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (EmptyObjectExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (RemoteCallExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1421.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1421.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (RejectRequestExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1425.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1425.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage("submit.error", null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	@RequestMapping(value = "/thirdparty/login", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<LoginByThirdPartyResp> loginByThirdParty(@RequestBody LoginByThirdPartyReq loginByThirdPartyReq, Locale locale) {
		LogUtil.log.info("第三方登录(loginByThirdParty)==========>>");
		TMsgResponse<LoginByThirdPartyResp> tMsgResponse = new TMsgResponse<LoginByThirdPartyResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			LoginByThirdPartyResp loginByThirdPartyResp = userService.loginByThirdParty(loginByThirdPartyReq);
			if (loginByThirdPartyResp == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1402.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1402.info, null, locale));
			}
			tMsgResponse.setResult(loginByThirdPartyResp);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @param loginByThirdPartyReq
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<LoginByThirdPartyResp> bindUser(@RequestBody LoginByThirdPartyReq loginByThirdPartyReq,
														Locale locale) {
		LogUtil.log.info("绑定(bindUser)==========>>");
		TMsgResponse<LoginByThirdPartyResp> tMsgResponse = new TMsgResponse<LoginByThirdPartyResp>();
		if (StringUtils.isBlank(loginByThirdPartyReq.getAuthcode()) ||
				StringUtils.isBlank(loginByThirdPartyReq.getOpenId()) ||
				loginByThirdPartyReq.getUserId() == null ||
				StringUtils.isBlank(loginByThirdPartyReq.getMobile()) ||
				loginByThirdPartyReq.getThirdPartyType() == null ||
				loginByThirdPartyReq.getPatientRelation() == null) {

			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		} else {
			// 判断验证码是否有效
			try {
				LogUtil.logError.debug("smsInnerService.checkCaptcha()开始验证，手机号：" + loginByThirdPartyReq.getMobile() + ",验证码：" + loginByThirdPartyReq.getAuthcode());
				/*
				SmsCaptchaCheckReq smsCaptchaCheckReq = new SmsCaptchaCheckReq();
				smsCaptchaCheckReq.setBusinessId(1);
				smsCaptchaCheckReq.setProductId(2);
				smsCaptchaCheckReq.setMobile(loginByThirdPartyReq.getMobile());
				smsCaptchaCheckReq.setCaptcha(loginByThirdPartyReq.getAuthcode());
				if(!smsInnerService.checkCaptcha(smsCaptchaCheckReq)){
					LogUtil.logError.debug("smsInnerService.checkCaptcha()返回false，验证失败，手机号：" + smsCaptchaCheckReq.getMobile() + ",验证码：" + smsCaptchaCheckReq.getCaptcha());
					tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, null, locale));
					return tMsgResponse;
				}
				*/

				Map<String, String> headerMap = new HashMap<String, String>();
				headerMap.put("Content-type", "application/json");
				String weixinQRJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=2&mobile=" + loginByThirdPartyReq.getMobile() + "&captcha=" + loginByThirdPartyReq.getAuthcode());
				TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
				if (smsTMsgResponse.getRespCode() != 0) {
					LogUtil.logError.error("smsInnerService.checkCaptcha(),验证验证码,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
					tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
					tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
					return tMsgResponse;
				}
				LogUtil.logError.debug("smsInnerService.checkCaptcha()返回true，验证成功，手机号：" + loginByThirdPartyReq.getMobile() + ",验证码：" + loginByThirdPartyReq.getAuthcode());
			} catch (Exception ex) {
				LogUtil.logError.error("smsInnerService.checkCaptcha()" + ex.getCause() + "\t" + ex.getMessage());
				tMsgResponse.setRespCode(ErrorMessage.E1418.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1418.info, new Object[]{ex.getMessage()}, locale));
				tMsgResponse.setErrorDesc(ex.getMessage());
				return tMsgResponse;
			}
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(userService.bindThirdPartyUser(loginByThirdPartyReq));
		} catch (BindingDataExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1401.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1401.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1402.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1402.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (EmptyObjectExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (ParamFormatErrorExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (ParamMismatchExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (ObjectAlreadyExistExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1401.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1401.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @param locale
	 * @param ticket
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/byticket", method = RequestMethod.GET)
	public TMsgResponse<UserLoginOutResp> queryUserInfoByTicket(Locale locale, String ticket) {
		LogUtil.log.info("通过ticket获取用户信息(queryUserInfoByTicket)==========>>");
		TMsgResponse<UserLoginOutResp> tMsgResponse = new TMsgResponse<UserLoginOutResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.userService.queryUserInfoByTicket(ticket));
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (EmptyObjectExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}


	/**
	 * 用户退出登录
	 *
	 * @return TMsgResponse<UserLoginOutResp>
	 * @author lichenghao
	 * @title :loginOutUser
	 * @Description:TODO
	 * @date 2016年5月18日 上午9:43:31
	 */
	@ResponseBody
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public TMsgResponse<UserLoginOutResp> loginOutUser(UserLoginOutReq req, Locale locale) {
		TMsgResponse<UserLoginOutResp> tMsgResponse = new TMsgResponse<UserLoginOutResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			userService.loginout(req);
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/init/user/city", method = RequestMethod.GET)
	public TMsgResponse<Object> initUserCity() {
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			userService.initUserCity();
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.code);
			tMsgResponse.setRespMsg(ErrorMessage.E1400.info);
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/add/operation/record", method = RequestMethod.POST)
	public TMsgResponse<Object> addOperationRecord(@RequestBody OperationHistory operationHistory, Locale locale) {
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			userService.addOperationHistory(operationHistory);
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(ErrorMessage.E1500.info);
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/query/operation/record", method = RequestMethod.POST)
	public TMsgResponse<List<HashMap<String, Object>>> getOperationRecord(@RequestBody OperationHistory operationHistory, Locale locale) {
		TMsgResponse<List<HashMap<String, Object>>> tMsgResponse = new TMsgResponse<List<HashMap<String, Object>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			tMsgResponse.result = userService.getOperationHistory(operationHistory);
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(ErrorMessage.E1500.info);
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@RequestMapping(value = "/express/address/list/get", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<ExpressAddressReq>> getExpressAddressList(Locale locale, Long userId) {
		TMsgResponse<List<ExpressAddressReq>> msg = new TMsgResponse<List<ExpressAddressReq>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			ExpressAddressReq req=new ExpressAddressReq();
			req.setUserId(userId);
			msg.result = expressAddressService.findExpressAddressList(req);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/express/address/get", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<ExpressAddressReq> getExpressAddress(Locale locale, Long userId,String addressId,Integer isDefault) {
		TMsgResponse<ExpressAddressReq> msg = new TMsgResponse<ExpressAddressReq>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			ExpressAddressReq req=new ExpressAddressReq();
			req.setIsDefault(isDefault);
			req.setAddressId(addressId);
			req.setUserId(userId);
			msg.result = expressAddressService.findExpressAddress(req);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/express/address/add", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<ExpressAddressReq> addExpressAddress(Locale locale, @RequestBody ExpressAddressReq req) {
		TMsgResponse<ExpressAddressReq> msg = new TMsgResponse<ExpressAddressReq>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			msg.result=expressAddressService.saveExpressAddress(req);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage(),e);
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/express/address/update", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<ExpressAddressReq> updateExpressAddress(Locale locale, @RequestBody ExpressAddressReq req) {
		TMsgResponse<ExpressAddressReq> msg = new TMsgResponse<ExpressAddressReq>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			expressAddressService.saveExpressAddress(req);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/express/address/delete", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<ExpressAddressReq> removeExpressAddress(Locale locale, @RequestBody ExpressAddressReq req) {
		TMsgResponse<ExpressAddressReq> msg = new TMsgResponse<ExpressAddressReq>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(ErrorMessage.SUCCESS.info);
		try {
			expressAddressService.deleteExpressAddress(req);
		} catch (EmptyParamExcption e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1400.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}

}
