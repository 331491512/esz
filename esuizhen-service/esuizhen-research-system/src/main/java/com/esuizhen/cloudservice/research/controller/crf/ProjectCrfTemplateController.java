package com.esuizhen.cloudservice.research.controller.crf;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.service.crf.ProjectCrfTemplateService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ProjectCrfTemplate 
* @Description: 科研专题模板业务控制器
* @author YYCHEN
* @date 2016年04月01日 下午17:57:01  
*/
@Controller
public class ProjectCrfTemplateController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ProjectCrfTemplateService projectCrfTemplateService;
	
	@RequestMapping(value = "/template/create", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<RCrftemplateProject> createProjectTemplate(Locale locale, @RequestBody TProjectTemplateDetailInfo projectTemplateDetailInfo) {
		LogUtil.log.info("创建科研专题模板(createProjectTemplate)==========>>");
		TMsgResponse<RCrftemplateProject> tMsgResponse = new TMsgResponse<RCrftemplateProject>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectCrfTemplateService.createProjectTemplate(projectTemplateDetailInfo));
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
	
	@RequestMapping(value = "/template/copy", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<RCrftemplateProject> projectTemplateCopy(Locale locale, String projectId, String crfTemplateId, Long doctorId) {
		LogUtil.log.info("引用专题模板(projectTemplateCopy)==========>>");
		TMsgResponse<RCrftemplateProject> tMsgResponse = new TMsgResponse<RCrftemplateProject>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectCrfTemplateService.projectTemplateCopy(projectId, crfTemplateId, doctorId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		} catch(RejectRequestExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1409.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1409.info, null, locale));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value = "/public/template/list", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Page<TProjectTemplateSimpleInfo>> listProjectPublicTempaltes(Locale locale, Long author, Integer mainDiseaseTypeId, Integer page, Integer num) {
		LogUtil.log.info("公开的专题模板列表(listProjectPublicTempaltes)==========>>");
		TMsgResponse<Page<TProjectTemplateSimpleInfo>> tMsgResponse = new TMsgResponse<Page<TProjectTemplateSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectCrfTemplateService.listProjectPublicTempaltes(author, mainDiseaseTypeId, page, num));
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
	
	@RequestMapping(value = "/template/publish", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Void> projectTemplatePublish(Locale locale, Long author, String crfTemplateId) {
		LogUtil.log.info("公开的专题模板列表(listProjectPublicTempaltes)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.projectCrfTemplateService.projectTemplatePublish(author, crfTemplateId);
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
	
	@RequestMapping(value = "/template/preview", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TProjectTemplateDetailInfo> projectTempalatePreview(Locale locale, Long doctorId, String crfTemplateId) {
		LogUtil.log.info("查看预览专题模板(projectTempalatePreview)==========>>");
		TMsgResponse<TProjectTemplateDetailInfo> tMsgResponse = new TMsgResponse<TProjectTemplateDetailInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectCrfTemplateService.projectTempalatePreview(doctorId, crfTemplateId));
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
