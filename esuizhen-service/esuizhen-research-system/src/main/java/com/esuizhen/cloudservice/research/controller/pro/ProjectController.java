package com.esuizhen.cloudservice.research.controller.pro;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.bean.TProjectCountInfo;
import com.esuizhen.cloudservice.research.bean.TProjectDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.service.pro.ProjectService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: ProjectController 
* @Description: 科研专题业务控制器
* @author YYCHEN
* @date 2016年04月01日 下午15:58:01  
*/
@Controller
public class ProjectController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<TProjectSimpleInfo> createProject(Locale locale, @RequestBody TProjectSimpleInfo projectSimpleInfo) {
		LogUtil.log.info("创建科研专题(createProject)==========>>");
		TMsgResponse<TProjectSimpleInfo> tMsgResponse = new TMsgResponse<TProjectSimpleInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectService.createProject(projectSimpleInfo));
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
	
	@RequestMapping(value = "/modfy", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> projectModify(Locale locale, @RequestBody TProjectSimpleInfo projectSimpleInfo) {
		LogUtil.log.info("创建科研专题(createProject)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.projectService.projectModify(projectSimpleInfo);
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
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public TMsgResponse<Page<TProjectSimpleInfo>> listProject(Locale locale, Long doctorId, Integer attributeFlag, Integer state, Integer stateFlag, Integer page, Integer num){
		LogUtil.log.info("专题列表(listProject)==========>>");
		TMsgResponse<Page<TProjectSimpleInfo>> tMsgResponse = new TMsgResponse<Page<TProjectSimpleInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectService.listProject(doctorId, stateFlag, state, attributeFlag, page, num));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public TMsgResponse<Void> removeProject(Locale locale, String projectId, Long doctorId){
		LogUtil.log.info("删除专题(removeProject)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.projectService.removeProject(projectId, doctorId);
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:releaseProject</p>
	 * <p>Description:专题发布</p>
	 * @author YYCHEN
	 * @date 2016年10月21日 上午11:49:20
	 * @param locale
	 * @param projectId
	 * @param doctorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/release", method=RequestMethod.GET)
	public TMsgResponse<Void> releaseProject(Locale locale, String projectId, Long doctorId){
		LogUtil.log.info("发布专题(removeProject)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.projectService.releaseProject(projectId, doctorId);
		} catch (Exception ex) {
			ex.printStackTrace();
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/count/query", method=RequestMethod.GET)
	public TMsgResponse<TProjectCountInfo> queryProjectStatistics(Locale locale, String projectId, Long doctorId){
		LogUtil.log.info("专题统计(queryProjectStatistics)==========>>");
		TMsgResponse<TProjectCountInfo> tMsgResponse = new TMsgResponse<TProjectCountInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectService.queryProjectStatistics(projectId, doctorId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/detail/query", method=RequestMethod.GET)
	public TMsgResponse<TProjectDetailInfo> queryProjectDetail(Locale locale, String projectId, Long subcenterId, Long doctorId){
		LogUtil.log.info("专题明细查看(queryProjectDetail)==========>>");
		TMsgResponse<TProjectDetailInfo> tMsgResponse = new TMsgResponse<TProjectDetailInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.projectService.queryProjectDetail(projectId, subcenterId, doctorId));
		} catch(EmptyParamExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return tMsgResponse;
	}
}
