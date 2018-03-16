package com.esuizhen.cloudservice.user.controller.followuppatient;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.model.followuppatient.TMetaInfoSimilarType;
import com.esuizhen.cloudservice.user.service.followuppatient.TMetaInfoSimilarTypeService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TMetaInfoSimilarTypeController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TMetaInfoSimilarTypeService similarTypeService;
	
	@ResponseBody
	@RequestMapping(value="/metainfo/similar/type/list",method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoSimilarType>> getMetaInfoSimilarTypeList(Locale locale) {
		TMsgResponse<List<TMetaInfoSimilarType>> tMsgResponse = new TMsgResponse<List<TMetaInfoSimilarType>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = similarTypeService.selectAllList();
			if(tMsgResponse.result == null || tMsgResponse.result.size() == 0)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
