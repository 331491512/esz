/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business;<br/>  
 * <b>文件名：</b>ColumnController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月13日下午7:06:29<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.business;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.ReviewAppointInfoGetReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.service.business.DoctorSendService;
import com.esuizhen.cloudservice.business.service.business.HospitalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.column.HospitalColumnReq;
import com.westangel.common.bean.column.TColumnInfo;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ColumnController
* @Description: 
* @author lichenghao
* @date 2016年7月13日 下午7:06:29  
*/
@Controller
public class BusinessOtherController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private DoctorSendService doctorSendService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getHospitalColumnList
	 * @Description:获取医院栏目
	 * @return TMsgResponse<List<TColumnInfo>>
	 * @date 2016年10月9日 下午4:05:55
	 */
	@ResponseBody
	@RequestMapping(value = "/hospital/column/list/get", method = RequestMethod.POST)
	public TMsgResponse<List<TColumnInfo>>  getHospitalColumnList (@RequestBody HospitalColumnReq req,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TColumnInfo>> msg = new TMsgResponse<List<TColumnInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = hospitalService.getHospitalColumnList(req);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/review/appoint/info/get", method = RequestMethod.GET)
	public TMsgResponse<Object>  getReviewAppointInfo(ReviewAppointInfoGetReq req,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			msg.result = doctorSendService.getReviewAppointInfo(req);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
}
