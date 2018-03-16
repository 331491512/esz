/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business;<br/>  
 * <b>文件名：</b>BusinessHospitalProductApplyController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月18日上午11:59:36<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.business;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.service.business.HospitalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: BusinessHospitalProductApplyController
* @Description: 
* @author lichenghao
* @date 2016年3月18日 上午11:59:36  
*/
@Controller
public class BusinessHospitalProductApplyController {
	
	@Autowired
	private HospitalService hospitalService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	
	/**
	 * 患者报告检查
	 * @author lichenghao
	 * @title :checkInspectionReportOut
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月25日 下午3:22:43
	 */
	@ResponseBody
	@RequestMapping(value = "/service/inspection/report/out/check", method = RequestMethod.GET)
	public TMsgResponse<Object>  checkInspectionReportOut(String productApplyId,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			hospitalService.checkInspectionReportOut(productApplyId);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
}
