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

import com.esuizhen.cloudservice.research.model.result.TCrfResultPhysicalSigns;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TCrfResultPhysicalSignsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:CrfResultGenenalPhysicalExaminationController</p>
 * <p>Description:患者体格检查-体征情况结果业务控制器</p>
 * @author YYCHEN
 * @date 2016年5月31日 下午3:45:23
 */
@Controller
public class TCrfResultPhysicalSignsController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private TCrfResultPhysicalSignsService crfResultPhysicalSignsService;
	
	/**
	 * <p>Title:queryCrfResultPhysicalSignsRecord</p>
	 * <p>Description:CRF患者体征记录查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:47:07
	 * @param locale
	 * @param projectId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/signs/record/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>>> queryCrfResultPhysicalSignsRecord(Locale locale, String projectId, Long patientId, Long doctorId, Integer page, Integer num) {
		LogUtil.log.info("CRF患者体征记录查询(queryCrfResultGenenaPhysicalExamRecord)==========>>");
		TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>>> tMsgResponse = new TMsgResponse<Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> crfResultMainInfos = this.crfResultPhysicalSignsService.queryCrfResultPhysicalSignsRecord(projectId, patientId, doctorId, page, num);
			if (crfResultMainInfos == null || crfResultMainInfos.getDataList() == null || crfResultMainInfos.getDataList().isEmpty()) {
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
	 * <p>Title:queryCrfResultPhysicalSigns</p>
	 * <p>Description:CRF患者体征情况信息查询</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午3:48:08
	 * @param locale
	 * @param crfObserveId
	 * @param patientId
	 * @param doctorId
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/signs/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> queryCrfResultPhysicalSigns(Locale locale, String crfObserveId, Long patientId, Long doctorId) {
		LogUtil.log.info("CRF患者体征情况信息查询(queryCrfResultGenenalPhysicalExam)==========>>");
		TMsgResponse<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>> tMsgResponse = new TMsgResponse<TCrfResultMainInfo<List<TCrfResultPhysicalSigns>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> crfResultMainInfo = this.crfResultPhysicalSignsService.queryCrfResultPhysicalSigns(crfObserveId, patientId, doctorId);
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
	 * <p>Title:saveCrfResultPhysicalSigns</p>
	 * <p>Description:CRF患者体征情况信息保存</p>
	 * @author YYCHEN
	 * @date 2016年5月31日 下午4:21:18
	 * @param locale
	 * @param crfResultMainInfo
	 * @return
	 */
	@RequestMapping(value = "/crf/result/physical/signs/save", method = RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Void> saveCrfResultPhysicalSigns(Locale locale, @RequestBody TCrfResultMainInfo<List<TCrfResultPhysicalSigns>> crfResultMainInfo) {
		LogUtil.log.info("CRF患者体征情况信息保存(queryCrfResultGenenalPhysicalExam)==========>>");
		TMsgResponse<Void> tMsgResponse = new TMsgResponse<Void>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			this.crfResultPhysicalSignsService.saveCrfResultPhysicalSigns(crfResultMainInfo);
		} catch (Exception ex) {
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
