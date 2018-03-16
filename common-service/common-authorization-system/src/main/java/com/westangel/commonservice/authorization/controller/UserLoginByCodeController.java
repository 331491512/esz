package com.westangel.commonservice.authorization.controller;
import java.io.IOException;    
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.service.UserService;
import com.westangel.commonservice.authorization.util.VerifyCodeUtils;
/** 
 * @ClassName: AuthImageController.java
 * @Description: 
 * @author fanpanwei	
 * @date   2017年2月17日
 */
@Controller
public class UserLoginByCodeController{ 
    static final long serialVersionUID = 1L; 
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private UserService userService;
	
	
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${sms.captcha.check}")
	private String smsCaptchaCheck;
	@Value("${sms.captcha.get}")
	private String smsCaptchaGet;
   
	@RequestMapping(value="/picture/code/query", method=RequestMethod.GET)
	@ResponseBody
    public TMsgResponse<String> getPictureCode(String picCode,HttpServletRequest request, HttpServletResponse response,Locale locale) throws ServletException, IOException { 
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
        	response.setHeader("Pragma", "No-cache"); 
            response.setHeader("Cache-Control", "no-cache"); 
            response.setDateHeader("Expires", 0); 
            response.setContentType("image/jpeg"); 
               
            //生成随机字串 
            /* String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
            //存入会话session 
            HttpSession session = request.getSession(true); 
            //删除以前的
            session.removeAttribute("picCode");
            session.setAttribute("picCode", verifyCode.toLowerCase()); */
            String verifyCode = picCode;
            //生成图片 
            int w = 100, h = 30; 
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
		} catch (Exception e) {
			// TODO: handle exception
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(e.getMessage());
		}
		return tMsgResponse;
    } 
	/**
	* @author fanpanwei
	* @date 2017年2月20日
	* @param 
	* @description :图形码校验
	* @return
	 */
	@RequestMapping(value="/picture/code/check", method=RequestMethod.POST)
	@ResponseBody
	 public TMsgResponse<String> checkPictureCode(@RequestBody User userLoginReq,HttpServletRequest request,Locale locale){ 
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		try {
			String picCode = userLoginReq.getPicCode();
			tMsgResponse = this.isMatchPicCode(picCode, request, null);
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(e.getMessage());
		}
		return tMsgResponse;
    } 
	/**
	* @author fanpanwei
	* @date 2017年2月17日
	* @param 
	* @description 图形码校验通过后获取短信码接口
	* @return
	 */
	@RequestMapping(value="/smscode/query", method=RequestMethod.POST)
	@ResponseBody
    public TMsgResponse<String> getSmsCodeByPicCode(@RequestBody User userLoginReq,HttpServletRequest request,Locale locale){ 
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		try {
			//String picCode = userLoginReq.getPicCode();
			if(StringUtils.isBlank(userLoginReq.getUserName())){
				tMsgResponse.setRespCode(ErrorMessage.E1505.getCode());
				tMsgResponse.setRespMsg("未获取到医生手机号");
				return tMsgResponse;
			}else{
				String smsSendJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaGet + "?businessId=1&productId=1&mobile=" + userLoginReq.getUserName());
				tMsgResponse = JsonUtil.toObject(smsSendJson, TMsgResponse.class);
			}
			//tMsgResponse = this.isMatchPicCode(picCode, request, userLoginReq.getUserName());
			
		} catch (Exception e) {
			// TODO: handle exception
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(e.getMessage());
		}
		return tMsgResponse;
    }
	
	/**
	* @author fanpanwei
	* @date 2017年2月17日
	* @param 
	* @description : 使用短信码登录
	* @return
	 */
	@RequestMapping(value="/smscode/login", method=RequestMethod.POST)
	@ResponseBody
    public TMsgResponse<UserProfileDetailResp> getSmsCodeByPicCode(@RequestBody User userLoginReq,Locale locale){
		LogUtil.log.info("使用短信码登录==========>>");
		TMsgResponse<UserProfileDetailResp> tMsgResponse = new TMsgResponse<UserProfileDetailResp>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (StringUtils.isBlank(userLoginReq.getSmsCode())) {
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			return tMsgResponse;
		}else{
			// 判断验证码是否有效
			try {
				LogUtil.logError.debug("smsInnerService.checkCaptcha()开始验证，手机号：" + userLoginReq.getUserName() + ",验证码：" + userLoginReq.getSmsCode());
				Map<String, String> headerMap = new HashMap<String, String>();
				headerMap.put("Content-type", "application/json");
				String smsCodeJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaCheck + "?businessId=1&productId=1&mobile=" + userLoginReq.getUserName() + "&captcha=" + userLoginReq.getSmsCode());
				TMsgResponse<Void> smsTMsgResponse = JsonUtil.toObject(smsCodeJson, TMsgResponse.class);
				if (smsTMsgResponse.getRespCode() != 0) {
					LogUtil.logError.error("smsInnerService.checkCaptcha(),验证验证码,code=" + smsTMsgResponse.getRespCode() + "," + smsTMsgResponse.getRespMsg());
					tMsgResponse.setRespCode(smsTMsgResponse.getRespCode());
					tMsgResponse.setRespMsg(smsTMsgResponse.getRespMsg());
					return tMsgResponse;
				}
				LogUtil.logError.debug("smsInnerService.checkCaptcha()返回true，验证成功，手机号：" + userLoginReq.getUserName() + ",验证码：" + userLoginReq.getSmsCode());
				//开始登录
				userLoginReq.setNeedPwFlag(false);
				tMsgResponse.setResult(this.userService.login(userLoginReq));
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
		}
		return tMsgResponse;
	}
	
	private TMsgResponse<String> isMatchPicCode(String picCode,HttpServletRequest request,String mobile){
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		if(StringUtils.isBlank(picCode)){
			tMsgResponse.setRespCode(ErrorMessage.E1600.getCode());
			tMsgResponse.setRespMsg("输入的图形验证码不可为空！");
			return tMsgResponse;
		}
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("picCode");
		if(obj==null){
			tMsgResponse.setRespCode(ErrorMessage.E1601.getCode());
			tMsgResponse.setRespMsg("图形验证码失效，请重新获取");
			return tMsgResponse;
		}
		if(picCode.toLowerCase().equals(obj.toString())){
			if(!StringUtils.isBlank(mobile)){
				String smsSendJson = HttpUtil.get(this.serverUrlRoot + this.smsCaptchaGet + "?businessId=1&productId=1&mobile=" + mobile);
				tMsgResponse = JsonUtil.toObject(smsSendJson, TMsgResponse.class);
			}
		}else{
			tMsgResponse.setRespCode(ErrorMessage.E1602.getCode());
			tMsgResponse.setRespMsg("图形验证码校验不通过");
		}
		return tMsgResponse;
	};
}
