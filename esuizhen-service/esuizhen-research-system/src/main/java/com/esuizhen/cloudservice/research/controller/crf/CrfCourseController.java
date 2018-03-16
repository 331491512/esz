package com.esuizhen.cloudservice.research.controller.crf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.TCrfCourseConf;
import com.esuizhen.cloudservice.research.bean.TCrfCourseInfo;
import com.esuizhen.cloudservice.research.service.crf.CrfCourseService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: CrfCourseController 
* @Description: 科研专题CRF随访周期控制器
* @author YYCHEN
* @date 2016年04月01日 下午17:57:01  
*/
@Controller
public class CrfCourseController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private CrfCourseService courseService;

	@RequestMapping(value = "/template/followup/period/modify", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> pojectTemplateCrfCourseModify(Locale locale, @RequestBody TCrfCourseConf crfCourseConf) {
		LogUtil.log.info("修改科研模板随访周期(projectTemplateCrfCourseSet)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.courseService.pojectTemplateCrfCourseModify(crfCourseConf);
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/template/crfcourse/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfCourseConf> projectTemplateCrfCourseQuery(Locale locale, String crfTemplateId, Long doctorId) {
		LogUtil.log.info("查看模板随访周期(projectTemplateCrfCourseQuery)==========>>");
		TMsgResponse<TCrfCourseConf> tMsgResponse = new TMsgResponse<TCrfCourseConf>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.courseService.projectTemplateCrfCourseQuery(crfTemplateId, doctorId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/crf/observe/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TCrfCourseInfo>> queryCrfObserve(Locale locale, String crfTemplateId) {
		LogUtil.log.info("CRF模板观察项查看(queryCrfObserve)==========>>");
		TMsgResponse<List<TCrfCourseInfo>> tMsgResponse = new TMsgResponse<List<TCrfCourseInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.courseService.queryCrfObserve(crfTemplateId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/crf/baseitems/copy", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Void> projectTemplateCrfBaseItemsCopy(Locale locale, String crfTemplateId) {
		LogUtil.log.info("CRF基线拷贝(projectTemplateCrfBaseItemsCopy)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.courseService.projectTemplateCrfCopyBaseItems(crfTemplateId);
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryProjectCourseItems</p>
	 * <p>Description:随访周期查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 下午4:34:11
	 * @param locale
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/outline/first/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TCrfCourseInfo>> queryProjectCrfResultOutlineFirst(Locale locale, String projectId, Long patientId, Long doctorId) {
		LogUtil.log.info("随访周期查询(queryProjectCourseItems)==========>>");
		TMsgResponse<List<TCrfCourseInfo>> tMsgResponse = new TMsgResponse<List<TCrfCourseInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.courseService.queryProjectCrfResultOutlineFirst(projectId, patientId, doctorId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
}
