package com.esuizhen.cloudservice.business.controller.business.mdt;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.service.business.mdt.MetaMDTDataUnitService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.util.LogUtil;

/** 
 * @ClassName: MDTProductStateController.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Controller
public class MetaMDTProductStateController {

	@Autowired
	private MetaMDTDataUnitService metaMDTService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@ResponseBody
	@RequestMapping(value = "/meta/mdt/product/state/list", method = RequestMethod.GET)
	public TMsgResponse<List<MetaMDTProductStateListReq>> getMetaMDTProductStateList (Integer mdtRole, Long userId,Integer ruleState,Long mdtFlowStateId,Locale locale){

		// 设置返回成功代码及提示消息
		TMsgResponse<List<MetaMDTProductStateListReq>> msg = new TMsgResponse<List<MetaMDTProductStateListReq>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale));
		try {
			
			List<MetaMDTProductStateListReq> list = metaMDTService.getMetaMDTProductStateList(mdtRole, userId,ruleState,mdtFlowStateId);
			msg.setResult(list);
		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info,null, locale));
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
}
