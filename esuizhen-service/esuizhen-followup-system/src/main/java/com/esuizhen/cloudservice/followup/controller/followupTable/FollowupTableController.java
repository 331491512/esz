package com.esuizhen.cloudservice.followup.controller.followupTable;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.FollowupTableReq;
import com.esuizhen.cloudservice.followup.service.followupTable.FollowupTableService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;


/**
 * @description：随访表相关接口类
 * @author fanpanwei
 *
 */
@Controller
@RequestMapping(value = "/table/")
public class FollowupTableController {
	@Autowired
	private FollowupTableService followupTableService;

	

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	
	
	/**
	* @author fanpanwei
	* @date 2017年3月7日
	* @param 
	* @description：是否显示随访表随访表
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "isopen", method = RequestMethod.GET)
	public TMsgResponse<HashMap<String, Integer>> isOpenFollowupTable(@RequestParam("patientId") Integer patientId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<HashMap<String, Integer>> msg = new TMsgResponse<HashMap<String, Integer>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			Integer isOpenFlag = followupTableService.isOpenedFollowupTable(patientId);
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			if(isOpenFlag!=null&&isOpenFlag>0){
				hm.put("isOpenedTab", 1);
			}else{
				hm.put("isOpenedTab", 0);
			}
			msg.setResult(hm);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年3月7日
	* @param 
	* @description：查询随访表
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "query", method = RequestMethod.GET)
	public TMsgResponse<FollowupTableReq> queryFollowupTable(@RequestParam("patientId") Integer patientId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupTableReq> msg = new TMsgResponse<FollowupTableReq>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			FollowupTableReq ftList = followupTableService.getFollowupTable(patientId);
			if(ftList!=null){
				msg.setResult(ftList);
			}else{
				// 设置错误代码及提示消息
				msg.respCode = ErrorMessage.E1400.code;
				msg.respMsg = messageSource.getMessage("未查到该患者对应的随访表信息", null, locale);
				LogUtil.logError.error(msg.respCode+"未查到该患者对应的随访表信息");
			}
			
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	* @author fanpanwei
	* @date 2017年3月7日
	* @param 
	* @description：更新随访表
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public TMsgResponse<FollowupTableReq> modifyFollowupTable(@RequestBody FollowupTableReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupTableReq> msg = new TMsgResponse<FollowupTableReq>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			followupTableService.updateFollowupTable(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
