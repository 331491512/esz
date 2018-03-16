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
import com.esuizhen.cloudservice.business.bean.ReviewAlertStatisReq;
import com.esuizhen.cloudservice.business.bean.ReviewAlertToPatientSendReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertDetailInfo;
import com.esuizhen.cloudservice.business.model.business.TReviewAlertStatisInfo;
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
public class ReviewAlertController {
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
	 * @title :sendReviewAlertToDoctor
	 * @Description:2.1.2.15	复查提醒发送医生接口
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月23日 下午4:06:01
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/to/doctor/send", method = RequestMethod.GET)
	public TMsgResponse<Map<String, Object>> sendReviewAlertToDoctor(Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			reviewAlertService.sendReviewAlertToDoctor();
		} catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReviewAlertPatientList
	 * @Description:2.1.2.17	复查提醒患者列表获取接口
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月23日 下午4:12:42
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/patient/list/get", method = RequestMethod.GET)
	public TMsgResponse<Page<TReviewAlertDetailInfo>> getReviewAlertPatientList(ReviewAlertPatientListGetReq req,Locale locale) {
		TMsgResponse<Page<TReviewAlertDetailInfo>> msg = new TMsgResponse<Page<TReviewAlertDetailInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = reviewAlertService.getReviewAlertPatientList(req);
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setReviewAlertSet
	 * @Description:复查提醒详情设置接口
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月23日 下午4:19:37
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/to/detail/set", method = RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> setReviewAlertSet(@RequestBody ReviewAlertDetailSetReq req,Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			reviewAlertService.setReviewAlertSet(req);
		} catch (Exception e) {
			e.printStackTrace();
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendReviewAlertToPatient
	 * @Description:2.1.2.16	复查提醒发送患者接口
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月23日 下午4:09:24
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/to/patient/send", method = RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> sendReviewAlertToPatient(@RequestBody ReviewAlertToPatientSendReq req,Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			reviewAlertService.sendReviewAlertToPatient(req);
		} catch (EmptyParamExcption e) {
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReviewAlertGet
	 * @Description:获取复查提醒详情
	 * @return TMsgResponse<Page<TReviewAlertDetailInfo>>
	 * @date 2017年8月28日 下午2:00:04
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/detail/get", method = RequestMethod.GET)
	public TMsgResponse<TReviewAlertDetailInfo> getReviewAlertGet (ReviewAlertDetailGetReq req,Locale locale) {
		TMsgResponse<TReviewAlertDetailInfo> msg = new TMsgResponse<TReviewAlertDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = reviewAlertService.getReviewAlertGet (req);
		}catch (EmptyParamExcption e) {
			msg.respCode = ErrorMessage.E1410.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1410.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReviewAlertStatis
	 * @Description:TODO
	 * @return TMsgResponse<TReviewAlertDetailInfo>
	 * @date 2017年9月22日 下午2:24:42
	 */
	@ResponseBody
	@RequestMapping(value = "/review/alert/statis", method = RequestMethod.GET)
	public TMsgResponse<TReviewAlertStatisInfo> getReviewAlertStatis(ReviewAlertStatisReq req,Locale locale) {
		TMsgResponse<TReviewAlertStatisInfo> msg = new TMsgResponse<TReviewAlertStatisInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = reviewAlertService.getReviewAlertStatis(req);
		}catch (EmptyParamExcption e) {
			msg.respCode = ErrorMessage.E1410.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1410.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
