package com.esuizhen.cloudservice.statistics.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.statistics.bean.TRetrievalParamentInfo;
import com.esuizhen.cloudservice.statistics.model.TRetrievalParamentMould;
import com.esuizhen.cloudservice.statistics.service.RetrievalService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class RetrievalController {
	
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private RetrievalService retrievalService;
	
	@ResponseBody
	@RequestMapping(value="/retrieval/parament/get")
	public TMsgResponse<List<TRetrievalParamentInfo>> getRetrievalParament(Locale locale){
		TMsgResponse<List<TRetrievalParamentInfo>> msg = new TMsgResponse<List<TRetrievalParamentInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = retrievalService.getRetrievalParament();
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 保存用户设置的高级查询模板。
	 * @param locale
	 * @param retrievalParamentMould
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/retrieval/parament/mould/save",method=RequestMethod.POST)
	public TMsgResponse<Object> saveRetrievalParamentMould(Locale locale, @RequestBody TRetrievalParamentMould retrievalParamentMould) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.retrievalService.saveRetrievalParamentMould(retrievalParamentMould);
		}catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}
	/**
	 * 删除用户设置的高级查询模板数据
	 * @param locale
	 * @param retrievalParamentMould
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/retrieval/parament/mould/delete",method=RequestMethod.POST)
	public TMsgResponse<Object> removeRetrievalParamentMould(Locale locale, @RequestBody TRetrievalParamentMould retrievalParamentMould) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.retrievalService.removeRetrievalParamentMould(retrievalParamentMould);
		}catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 用户设置的高级查询模板列表数据
	 * @param locale
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/retrieval/parament/mould/list",method=RequestMethod.POST)
	public TMsgResponse<List<TRetrievalParamentMould>> searchRetrievalParamentMouldList(Locale locale, @RequestBody TRetrievalParamentMould retrievalParamentMould) {
		TMsgResponse<List<TRetrievalParamentMould>> msgResponse = new TMsgResponse<List<TRetrievalParamentMould>>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TRetrievalParamentMould> moulds = this.retrievalService.searchRetrievalParamentMouldList(retrievalParamentMould);
			if (moulds == null || moulds.isEmpty()) {
				msgResponse.setRespCode(ErrorMessage.E1404.code);
				msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}
			msgResponse.setResult(moulds);
		}catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}
	
	/**
	 * 用户设置的高级查询模板详细数据
	 * @param locale
	 * @param moulId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/retrieval/parament/mould/detail",method=RequestMethod.GET)
	public TMsgResponse<TRetrievalParamentMould> getRetrievalParamentMouldDetail(Locale locale, String mouldId) {
		TMsgResponse<TRetrievalParamentMould> msgResponse = new TMsgResponse<TRetrievalParamentMould>();
		msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msgResponse.setResult(this.retrievalService.getRetrievalParamentMouldDetail(mouldId));
		}catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}
}
