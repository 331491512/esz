/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.controller;<br/>  
 * <b>文件名：</b>UserMetaController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月2日上午10:13:49<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.model.TMetaInfoNation;
import com.esuizhen.cloudservice.user.model.TMetaInfoNationality;
import com.esuizhen.cloudservice.user.model.TMetaInfoOccupation;
import com.esuizhen.cloudservice.user.model.TMetaInfoRelatives;
import com.esuizhen.cloudservice.user.model.TMetaInfoFaultType;
import com.esuizhen.cloudservice.user.service.MetaService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;

/**
 * @ClassName: UserMetaController
 * @Description:
 * @author lichenghao
 * @date 2016年5月2日 上午10:13:49
 */
@Controller
public class UserMetaController {
	@Autowired
	MetaService meateService;

	@Autowired
	private MessageSource messageSource;
	
	
	@ResponseBody
	@RequestMapping(value = "/metainfo/occupation/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoOccupation>> getMetaInfoOccupationList(Locale local, String occupationName) {
		TMsgResponse<List<TMetaInfoOccupation>> tMsgResponse = new TMsgResponse<List<TMetaInfoOccupation>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoOccupationList(occupationName));
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:getMetaInfoNationList</p>
	 * <p>Description:获取民族元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午11:12:11
	 * @param local
	 * @param nationName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/nation/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoNation>> getMetaInfoNationList(Locale local, String nationName) {
		TMsgResponse<List<TMetaInfoNation>> tMsgResponse = new TMsgResponse<List<TMetaInfoNation>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoNationList(nationName));
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:getMetaInfoNationalityList</p>
	 * <p>Description:获取国籍元数据列表</p>
	 * @author YYCHEN
	 * @date 2016年6月23日 上午10:56:12
	 * @param local
	 * @param nationalityName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/metainfo/nationality/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoNationality>> getMetaInfoNationalityList(Locale local, String nationalityName) {
		TMsgResponse<List<TMetaInfoNationality>> tMsgResponse = new TMsgResponse<List<TMetaInfoNationality>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoNationalityList(nationalityName));
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/metainfo/city/list", method = RequestMethod.GET)
	public TMsgResponse<Object> getMetaInfoCityList(Integer level, String cityCode, Locale local) {
		TMsgResponse<Object> tMsgResponse = new TMsgResponse<Object>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.result = meateService.getCityInfo(level, cityCode);
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1400.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/metainfo/relatives/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoRelatives>> getMetaInfoRelativesList(Locale local){
		TMsgResponse<List<TMetaInfoRelatives>> tMsgResponse = new TMsgResponse<List<TMetaInfoRelatives>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoRelativesList());
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	@ResponseBody
	@RequestMapping(value = "/metainfo/missing/type/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoFaultType>> getMetaInfoMissingTypeList(Locale local){
		TMsgResponse<List<TMetaInfoFaultType>> tMsgResponse = new TMsgResponse<List<TMetaInfoFaultType>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoMissingTypeList());
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
	@ResponseBody
	@RequestMapping(value = "/metainfo/invalid/type/list", method = RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoFaultType>> getMetaInfoInvalidTypeList(Locale local){
		TMsgResponse<List<TMetaInfoFaultType>> tMsgResponse = new TMsgResponse<List<TMetaInfoFaultType>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, local));
		try {
			tMsgResponse.setResult(meateService.getMetaInfoInvalidTypeList());
		} catch (Exception e) {
			tMsgResponse.setRespCode(ErrorMessage.E1500.code);
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, local));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

}
