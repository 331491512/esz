/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business;<br/>  
 * <b>文件名：</b>ColumnController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月13日下午7:06:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.thirdparty.controller;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.thirdparty.bean.yiyao.LoginReq;
import com.esuizhen.cloudservice.thirdparty.util.AppSiganatureUtils;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ColumnController
* @Description: 
* @author lichenghao
* @date 2016年7月13日 下午7:06:29  
*/
@Controller
public class YiyaoController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@ResponseBody
	@RequestMapping(value = "/yiyao/login/prepare", method = RequestMethod.POST)
	public TMsgResponse<Object>  loginPrepare (@RequestBody LoginReq req,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			if(req==null||StringUtils.isEmpty(req.getTargetUrl())||StringUtils.isEmpty(req.getMobile())||StringUtils.isEmpty(req.getName()))
				throw new EmptyParamExcption("param error");
			msg.result = AppSiganatureUtils.initLoginResp(req);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
