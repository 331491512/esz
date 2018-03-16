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

import com.esuizhen.cloudservice.user.service.ProfessionalRankService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.ProfessionalRankSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ProfessionalController 
* @Description: 职称业务控制类
* @author YYCHEN
* @date 2015年12月14日 下午18:46:17  
*/
@Controller
public class ProfessionalRankController {

	@Autowired
	private ProfessionalRankService professionalRankService;
	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @param locale
	 * @return
	 */
	@RequestMapping("/metainfo/doctor/professional/rank/list")
	@ResponseBody
	public TMsgResponse<List<ProfessionalRankSimpleInfo>> listProfessionalRank(Locale locale) {
		LogUtil.log.info("获取职务列表(listProfessionalRank)==========>>");
		TMsgResponse<List<ProfessionalRankSimpleInfo>> tMsgResponse = new TMsgResponse<List<ProfessionalRankSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<ProfessionalRankSimpleInfo> doctorTagList = this.professionalRankService.getProfessionalranks();
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
