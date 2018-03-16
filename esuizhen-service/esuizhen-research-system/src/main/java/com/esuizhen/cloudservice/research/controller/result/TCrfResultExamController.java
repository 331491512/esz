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

import com.esuizhen.cloudservice.research.model.result.TCrfResultExam;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultExamService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:CrfResultGenenalPhysicalExaminationController</p>
 * <p>Description:患者体格结果业务控制器</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午3:45:23
 */
@Controller
public class TCrfResultExamController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultExamService crfResultExamService;
	
	/**
	 * <p>Title:queryCrfResultExamRecord</p>
	 * <p>Description:CRF检查项目记录查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:47:35
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/exam/record/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultExam>>>> queryCrfResultExamRecord(Locale locale, String projectId, Long patientId, Long doctorId, String examParentTypeId, String orderBy, String orderType) {
		LogUtil.log.info("CRF检查项目记录查询(queryCrfResultExamRecord)==========>>");
		TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultExam>>>> tMsgResponse = new TMsgResponse<List<TCrfResultMainInfo<List<TCrfResultExam>>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TCrfResultMainInfo<List<TCrfResultExam>>> crfResultMainInfos = this.crfResultExamService.queryCrfResultExamRecord(projectId, patientId, doctorId, examParentTypeId, orderBy, orderType);
			if (crfResultMainInfos == null || crfResultMainInfos == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}else{
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
	 * <p>Title:CrfResultExamQuery</p>
	 * <p>Description:CRF患者检查信息查询</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:48:38
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/exam/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultExam>>> crfResultExamQuery(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF患者检查信息查询(crfResultExamQuery)==========>>");
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultExam>>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultExam>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo = this.crfResultExamService.crfResultExamQuery(crfObserveId, patientId, doctorId);
			if (crfResultMainInfo == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}else{
				tMsgResponse.setResult(crfResultMainInfo);
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
	 * <p>Title:saveCrfResultExam</p>
	 * <p>Description:CRF患者检查信息保存</p>
	 * @author YYCHEN
	 * @date 2016年6月2日 上午9:49:15
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/exam/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultExam(Locale locale, @RequestBody TCrfResultMainInfo<List<TCrfResultExam>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者检查信息保存(saveCrfResultExam)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultExamService.saveCrfResultExam(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
