package com.esuizhen.cloudservice.research.controller.result;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.MRDataService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:MRDataController</p>
 * <p>Description:数据源及数据业务控制器</p>
 * @author YYCHEN
 * @date 2016年7月25日 上午10:42:01
 */
@Controller
public class MRDataController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MRDataService mRDataService;

	/**
	 * <p>Title:queryCrfDataSources</p>
	 * <p>Description:根据专题当前录入数据的需要，在患者病历数据里查询近七天是否有相应的数据</p>
	 * @author YYCHEN
	 * @date 2016年7月24日 下午8:54:47
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/datasource/list/query", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>> queryCrfDataSources(Locale locale, @RequestBody TCrfResultMainInfo<Void> crfResultMainInfo) {
		LogUtil.log.info("CRF数据源查询(queryCrfDataSources)==========>>");
		TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>> tMsgResponse = new TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TCrfResultMainInfo<List<TCrfResultMainInfo<Void>>>> crfResultMainInfos = this.mRDataService.queryCrfDataSources(crfResultMainInfo);
			if (crfResultMainInfos == null || crfResultMainInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(crfResultMainInfos);
			}
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * <p>Title:queryCrfDataSourceData</p>
	 * <p>Description:获取数据源中的数据</p>
	 * @author YYCHEN
	 * @date 2016年7月24日 下午8:56:15
	 * @param locale
	 * @param medicalRecordType
	 * @param emrId
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/crf/datasource/data/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<?>> queryCrfDataSourceData(Locale locale, Integer medicalRecordType, String emrId, Long patientId) {
		LogUtil.log.info("获取数据源中的数据(queryCrfDataSourceData)==========>>");
		TMsgResponse<TCrfResultMainInfo<?>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<?>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.setResult(this.mRDataService.queryCrfDataSourceData(medicalRecordType, emrId, patientId));
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
