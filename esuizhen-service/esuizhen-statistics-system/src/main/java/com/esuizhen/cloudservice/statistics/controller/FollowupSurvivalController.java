package com.esuizhen.cloudservice.statistics.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRateFinalReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupSurvivalRatePreReq;
import com.esuizhen.cloudservice.statistics.constant.Constant;
import com.esuizhen.cloudservice.statistics.service.SurvivalService;
import com.esuizhen.cloudservice.statistics.util.ExcelFileWriteUtil;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.LogUtil;

@Controller
public class FollowupSurvivalController {
	/**
	 * 消息服务
	 */
	@Autowired
	private SurvivalService survivalService;

	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupSurvival
	 * @Description:随访生存情况统计预查询
	 * @return TMsgResponse<Object>
	 * @date 2016年8月13日 上午9:16:28
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/survival/pre", method = RequestMethod.POST)
	public TMsgResponse<Object> preFollowupSurvivalRate(@RequestBody FollowupSurvivalRatePreReq req, HttpSession session, Locale locale) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		req.setOutPatientFlag(2);
		try {
			// 初始统计数据
			survivalService.initSurvivalRate(req);
			req.session = session;
			// 数据统计
			msgResponse.setResult(survivalService.preFollowupSurvivalRate(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (EmptyParamExcption e) {
			msgResponse.setRespCode(ErrorMessage.E1409.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.log.debug(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msgResponse.setRespCode(ErrorMessage.E1404.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			LogUtil.log.debug(e.getMessage());
		} catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :getFollowupSurvival
	 * @Description:随访生存率统计最终结果
	 * @return TMsgResponse<Object>
	 * @date 2016年8月13日 上午9:17:14
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/survival/final", method = RequestMethod.POST)
	public TMsgResponse<Object> finalFollowupSurvival(@RequestBody FollowupSurvivalRateFinalReq req, Locale locale) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		msgResponse.setRespCode(0);
		msgResponse.setRespMsg("success");
		try {
			if (req.getSearchId() == null)
				throw new EmptyParamExcption(" searchId is null");
			HttpSession session = (HttpSession) Constant.survivalMap.get("" + req.getSearchId());
			// 如果存在于session 中 则返回 否则提示错误
			if (session != null && session.getAttribute(req.getSearchId() + "") != null)
				msgResponse.result = session.getAttribute(req.getSearchId() + "");
			else {
				throw new EmptyObjectExcption(" not find searchId survivalRates, searchId = " + req.getSearchId());
			}
		} catch (EmptyParamExcption e) {
			msgResponse.setRespCode(ErrorMessage.E1409.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.log.debug(e.getMessage());
		} catch (EmptyObjectExcption e) {
			msgResponse.setRespCode(ErrorMessage.E1404.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			LogUtil.log.debug(e.getMessage());
		} catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msgResponse;
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :exportSurvivalRateResult
	 * @Description:生存率统计结果导出
	 * @return void
	 * @date 2016年8月18日 下午6:08:08
	 */
	@RequestMapping(value = "/survival/rate/export", method = RequestMethod.GET)
	public void exportSurvivalRateResult(HttpServletResponse response, String searchId, String compareId, Integer staticType, Locale locale) {
		BufferedInputStream in = null;
		OutputStream out = null;
		File outFile = null;
		try {
			if (staticType == null)
				throw new EmptyParamExcption("staticType is null");
			HttpSession session = (HttpSession) Constant.survivalMap.get("" + searchId);
			HttpSession compareSess = (HttpSession) Constant.survivalMap.get("" + compareId);
			if (session == null && compareSess == null)
				return;
			Object compareData = null;
			Object compareSubData = null;
			if (compareSess != null) {
				compareData = compareSess.getAttribute("Export" + compareId);
				compareSubData = compareSess.getAttribute("" + compareId);
			}
			Object countData = null;
			Object subData = null;
			if (session != null) {
				countData = session.getAttribute("Export" + searchId);
				subData = session.getAttribute("" + searchId);
			}
			// 生成文件
			outFile = survivalService.buildSurvivalRateReportFile(countData, subData, compareData, compareSubData, searchId, staticType);
			if (outFile == null)
				return;
			// 文件导出名称生成
			String fileName = "export.survival.file.name." + staticType;
			fileName = messageSource.getMessage(fileName, new Object[] { DateUtil.convertToStr(new Date(), DateUtil.NO_SLASH) }, null);
			// 导出
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(outFile.length()));
			in = new BufferedInputStream(new FileInputStream(outFile));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(data, 0, data.length))) {
				out.write(data, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			outFile.delete();// 将生成的服务器端文件删除
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author lichenghao
	 * @title 
	 *        :exportSurvivalpatientResult
	 * @Description:随访生存率一键统计导出患者
	 * @return void
	 * @date 2016年9月2日 下午4:17:17
	 */
	@RequestMapping(value = "/survival/rate/patient/export", method = RequestMethod.GET)
	public void exportSurvivalpatientResult(HttpServletResponse response, String searchId, Integer staticType, Integer reqFlag, Integer staticResultType, Integer doctorId,
			Locale locale) {
		BufferedInputStream in = null;
		OutputStream out = null;
		File outFile = null;
		try {
			if (staticType == null)
				throw new EmptyParamExcption("staticType is null");
			HttpSession session = (HttpSession) Constant.survivalMap.get("" + searchId);
			if (session == null)
				return;
			List<Object> fdata = survivalService.initExportPatientData(session.getAttribute("Export" + searchId), Integer.parseInt(searchId), staticType, reqFlag,
					staticResultType, doctorId);
			String filePath = this.getClass().getClassLoader().getResource("").getPath();
			String fileName = "export.survival.patient.name." + staticType;
			// 拼接文件名
			fileName = messageSource.getMessage(fileName, new Object[] { DateUtil.convertToStr(new Date(), DateUtil.NO_SLASH) }, null);
			// 写入文件
			outFile = ExcelFileWriteUtil.initFollowReportFile(new File(filePath + "template/template" + (new Date()).getTime() + ".xlsx"), fdata);
			// 输出准备
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(outFile.length()));
			in = new BufferedInputStream(new FileInputStream(outFile));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(data, 0, data.length))) {
				out.write(data, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			outFile.delete();// 将生成的服务器端文件删除
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
