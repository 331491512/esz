/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.user;<br/>  
 * <b>文件名：</b>ReviewAlertController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:03:23<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.user;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertDetailSetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertPatientListGetReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertToPatientSendReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertDetailInfo;
import com.esuizhen.cloudservice.business.service.user.ReviewAlertService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName:ReviewAlertController
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:03:23  
*/
@Controller
public class FollowupPlanController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ReviewAlertService reviewAlertService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :scanningFollowupPlanSend
	 * @Description:扫描随访计划 并发送
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月30日 上午11:46:38
	 */
	@ResponseBody
	@RequestMapping(value = "/follow/plan/scanning/send", method = RequestMethod.GET)
	public TMsgResponse<Map<String, Object>> scanningFollowupPlanSend(Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			reviewAlertService.scanningFollowupPlanSend();
		} catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
