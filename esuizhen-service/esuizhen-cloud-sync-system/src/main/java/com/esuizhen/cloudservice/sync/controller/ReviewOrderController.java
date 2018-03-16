package com.esuizhen.cloudservice.sync.controller;

import java.util.List; 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.bean.TSyncReviewRecord;
import com.esuizhen.cloudservice.sync.service.CloudReviewOrderService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;
/**
 * @author fanpanwei
 */
@Controller
public class ReviewOrderController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	CloudReviewOrderService reviewOrderService;
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年10月20日
	* @param 
	* @description 获取预约结果
	* @return
	 */
	@ResponseBody
	@RequestMapping(value="/fromcloud/order/review", method=RequestMethod.GET)
	public TMsgResponse<List<TSyncReviewRecord>> syncReviewOrderFromCloud(Locale locale, Integer hospitalId, Integer page, Integer num) {
		LogUtil.log.info("Synchronous reviewResult to ToB, syncReviewOrderFromCloud()==========>>>>>>>>>>hospitalId=" + hospitalId);
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1 || num > 100) {
			num = 30;
		}
		TMsgResponse<List<TSyncReviewRecord>> tMsgResponse = new TMsgResponse<List<TSyncReviewRecord>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TSyncReviewRecord> pageData = this.reviewOrderService.syncReviewOrderFromCloud(hospitalId, page, num);
			if (pageData.getCurrPage() == pageData.getTotalPage() ||
				pageData.getCurrPage() == pageData.getTotalPage() - 1) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg("Complete synchronization!");
			}
			tMsgResponse.setResult(pageData.getDataList());
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+hospitalId;
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("Synchronous reviewResultto the ToB side data return, syncReviewOrderFromCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
