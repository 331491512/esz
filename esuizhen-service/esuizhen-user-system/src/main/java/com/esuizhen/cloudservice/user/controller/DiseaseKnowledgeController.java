package com.esuizhen.cloudservice.user.controller;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.DiseaseKnowledge;
import com.esuizhen.cloudservice.user.service.DiseaseKnowledgeService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
@RequestMapping(value = "/guide/article/")
public class DiseaseKnowledgeController {
	@Autowired
	private DiseaseKnowledgeService diseaseKnowledgeService;

	@Autowired
	private MessageSource messageSource;

	/**
	 * @Title: findDiseaseKnowledge
	 * @Description: 列表
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<DiseaseKnowledge>> findDiseaseKnowledge(@RequestBody DiseaseKnowledge diseaseKnowledge,Locale locale) {
		// 设置返回成功代码及提示消息
				TMsgResponse<Page<DiseaseKnowledge>> msg = new TMsgResponse<Page<DiseaseKnowledge>>();
				msg.respCode = ErrorMessage.SUCCESS.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
				try {
					Page<DiseaseKnowledge> pageInfo = this.diseaseKnowledgeService.findDiseaseKnowledge(diseaseKnowledge);
					msg.setResult(pageInfo);  
				} catch (Exception ex) {
					// 设置错误代码及提示消息
					ex.printStackTrace();
					msg.respCode = ErrorMessage.E1417.code;
					msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
					LogUtil.logError.error(ex.getMessage());
				}
				return msg;
	}

	/**
	 * @Title: updateDiseaseKnowledge
	 * @Description: 更新
	 * @param @param cmsContent
	 * @param @param redirectAttributes
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public TMsgResponse<String> updateDiseaseKnowledge(Locale locale, @RequestBody DiseaseKnowledge diseaseKnowledge) {
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Long articleId = diseaseKnowledge.getArticleId();
			if(articleId!=null){
				if(diseaseKnowledge.getIsDelete()!=null&&diseaseKnowledge.getIsDelete()==1){
					this.diseaseKnowledgeService.deleteArticleDoc(articleId);
				}else{
					Integer count = this.diseaseKnowledgeService.judgeArticleByTitle(diseaseKnowledge.getArticleTitle(),articleId);
					if(count!=null&&count==1){
						tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
						tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
						tMsgResponse.setErrorDesc("文章标题已经存在！");
						return tMsgResponse;
					}
					this.diseaseKnowledgeService.updateDiseaseKnowledge(diseaseKnowledge);
				}
			}else{
				Integer count = this.diseaseKnowledgeService.judgeArticleByTitle(diseaseKnowledge.getArticleTitle(),null);
				if(count!=null&&count==1){
					tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
					tMsgResponse.setErrorDesc("文章标题已经存在！");
					return tMsgResponse;
				}
				this.diseaseKnowledgeService.createDiseaseKnowledge(diseaseKnowledge);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * @Title: getDiseaseKnowledge
	 * @Description: 获取疾病知识
	 */
	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public TMsgResponse<DiseaseKnowledge> getDiseaseKnowledge(Long articleId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<DiseaseKnowledge> msg = new TMsgResponse<DiseaseKnowledge>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = this.diseaseKnowledgeService.getDiseaseKnowledge(articleId);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
