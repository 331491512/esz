package com.esuizhen.cloudservice.ehr.controller.inhospital;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.common.Common;
import com.esuizhen.cloudservice.ehr.util.FileReaderWriterUtils;
import com.esuizhen.cloudservice.ehr.util.TemplateUtil;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class DataImportController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 数据导入日志查询
	 */
	@RequestMapping(value = "/data/import/log/query", method = RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Map<String, Object>> queryDataImportLog(HttpServletRequest request,Integer dataType, String templateFileName, Locale locale) {
		TMsgResponse<Map<String, Object>> tMsgResponse = new TMsgResponse<Map<String, Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		BufferedReader in = null;
		String currentNum = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession(true);
			ServletContext context = session.getServletContext();
			session = (HttpSession)context.getAttribute("session");
			if(session != null) {
				currentNum = String.valueOf(session.getAttribute(templateFileName));
			}
			LogUtil.log.info("缓存currentNum="+currentNum);
			in = new BufferedReader(new InputStreamReader(new FileInputStream(Common.IMPORT_LOG + templateFileName+".txt"),"UTF-8"));
			String line = null;
			StringBuffer resMsg = new StringBuffer();
			int i = 0;
			int successed = 0;
			while ((line = in.readLine()) != null) {
				i++;
				if(line.indexOf("导入完成") > -1) {
					successed = 1;
				}
				if(i == 1) {
					resMsg.append(line.replaceFirst("\\d+",currentNum));
				}else {
					resMsg.append(line);
				}
				resMsg.append(System.lineSeparator());
			}
			in.close();
			if(successed == 1) {
				FileReaderWriterUtils frw = new FileReaderWriterUtils(Common.IMPORT_LOG + templateFileName+".txt",false);
				frw.writeLine(resMsg.toString());
				frw.close();
//				session.invalidate();
			}
			resultMap.put("textData", resMsg.toString());
			resultMap.put("successed", successed);
			tMsgResponse.result = resultMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/template/download/query",method = RequestMethod.GET)
	public void queryTemplateDownload(HttpServletRequest request,HttpServletResponse response, String templateType,String templateFileName) {
		InputStream input = null;
		// 清空response
		response.reset();
		if (StringUtils.isEmpty(templateFileName)) {
			templateFileName = "患者导入模板";
		}
		try {
			if ("inhospital.import.template.file".equals(templateType)) {
				String patientTemplateFile = TemplateUtil.getExcelExportInfo(templateType);
				templateFileName = URLDecoder.decode(templateFileName, "UTF-8")+ ".xls";
				LogUtil.log.info("模板文件名称:" + templateFileName + "模板文件路径:"+ patientTemplateFile);
				response.setContentType("application/vnd.ms-excel");// 下载excel
				input = DataImportController.class.getResourceAsStream(patientTemplateFile);
			} else if ("inhospital.import.log.file".equals(templateType)) {
				templateFileName = URLDecoder.decode(templateFileName, "UTF-8")+ ".txt";
				input = new FileInputStream(Common.IMPORT_LOG + templateFileName);
			}
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(templateFileName.getBytes("UTF-8"),"ISO8859-1"));
			// response.setHeader("Content-Length",String.valueOf(outFile.length()));
			commonFileDowload(response, input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void commonFileDowload(HttpServletResponse response,InputStream input) {
		BufferedInputStream in = null;
		OutputStream out = null;
		try {
			// 以流的形式下载文件。
			in = new BufferedInputStream(input);
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] data = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(data, 0, data.length))) {
				out.write(data, 0, len);
			}
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			LogUtil.logError.info("下载文件失败", e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
