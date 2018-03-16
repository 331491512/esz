/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-下午2:11:17<br/>  
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.service.PositionTitleService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.PositionTitleSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: PositionTitleController 
* @Description: 职务业务控制类
* @author YYCHEN
* @date 2016年1月4日 下午18:46:17  
*/
@Controller
public class PositionTitleController {

	@Autowired
	private PositionTitleService positionTitleService;
	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param locale
	 * @return
	 */
	@RequestMapping("/metainfo/doctor/position/title/list")
	@ResponseBody
	public TMsgResponse<List<PositionTitleSimpleInfo>> listProfessionalRank(Locale locale) {
		LogUtil.log.info("获取职责列表(listProfessionalRank)==========>>");
		TMsgResponse<List<PositionTitleSimpleInfo>> tMsgResponse = new TMsgResponse<List<PositionTitleSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<PositionTitleSimpleInfo> doctorTagList = this.positionTitleService.getPositionTitleSimpleInfos();
			tMsgResponse.setResult(doctorTagList);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
}
