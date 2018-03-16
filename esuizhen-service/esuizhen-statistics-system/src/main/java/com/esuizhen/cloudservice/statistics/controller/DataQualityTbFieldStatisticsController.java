package com.esuizhen.cloudservice.statistics.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.DataQualityTbFieldStatisticsRes;
import com.esuizhen.cloudservice.statistics.constant.Constants;
import com.esuizhen.cloudservice.statistics.model.TStatsExportTemplateInfo;
import com.esuizhen.cloudservice.statistics.service.DataQualityTbFieldStatisticsService;
import com.esuizhen.cloudservice.statistics.service.ExportBigData;
import com.esuizhen.cloudservice.statistics.service.StatsExportInfoService;
import com.esuizhen.cloudservice.statistics.util.FileSuffixEnum;
import com.esuizhen.cloudservice.statistics.util.FileUtil;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 
 * @author zhuguo
 * @date 2017-7-5 10:34:55
 */
@Controller
public class DataQualityTbFieldStatisticsController {
	/**
	 * 消息服务
	 */
	@Autowired
	private DataQualityTbFieldStatisticsService dataQualityTbFieldStatisticsService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ExportBigData exportBigData;

	@Autowired
	private StatsExportInfoService statsExportInfoService;

	/**
	 * 
	 * @param req
	 * @param locale
	 * @return
	 * @author zhuguo
	 * @date 2017-7-5 10:37:21
	 */
	@ResponseBody
	@RequestMapping(value = "/data/quality/tbfield/statistics", method = RequestMethod.POST)
	public TMsgResponse<List<DataQualityTbFieldStatisticsRes>> statisticsDataQualityTbField(
			@RequestBody DataQualityTbFieldStatisticsReq req, Locale locale) {
		TMsgResponse<List<DataQualityTbFieldStatisticsRes>> msg = new TMsgResponse<List<DataQualityTbFieldStatisticsRes>>();

		try {
			List<DataQualityTbFieldStatisticsRes> result = dataQualityTbFieldStatisticsService
					.statisticsDataQualityTbField(req);

			msg.setResult(result);
			msg.setRespCode(0);
			msg.setRespMsg("success");

		} catch (Exception e) {
			msg.setRespCode(ErrorMessage.SUCCESS.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info,
					null, locale));
		}
		return msg;
	}

	/**
	 * 生产下载文件
	 * 
	 * @param request
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/data/export/quality", method = RequestMethod.POST)
	public TMsgResponse<String> exportStatsData(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody DataQualityTbFieldStatisticsReq req, Locale locale) {

		String msg = null;
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(
				ErrorMessage.SUCCESS.info, null, locale));

		try {

			// 查询模板配置
			TStatsExportTemplateInfo statsExportInfo = statsExportInfoService
					.statsExportTemplate("EXPT016");

			// 根据开始时间、结束时间、condition查询数据
			List<DataQualityTbFieldStatisticsRes> result = dataQualityTbFieldStatisticsService
					.statisticsDataQualityTbField(req);

			// 把数据转换下格式
			List<String> resultList = new ArrayList<String>();
			for (int i = 0; i < result.size(); i++) {
				resultList.add(JSON.toJSONString(result.get(i)));
			}

			if (statsExportInfo == null || resultList == null
					|| resultList.size() == 0) {
				tMsgResponse.respCode = ErrorMessage.E1404.code;
				tMsgResponse.respMsg = messageSource.getMessage(
						ErrorMessage.E1404.info, null, locale);
			} else {

				// 导出文件
				msg = exportFile(request, response, statsExportInfo,
						resultList, req.getCondition());

				if (msg == null) {
					tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(
							ErrorMessage.E1500.info, null, locale));
					tMsgResponse.setErrorDesc("生成文件失败,返回地址null。");
				} else {
					tMsgResponse.setResult(msg);
				}
			}

		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(
					ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("导出核心数据分析信息结束。");
		return tMsgResponse;
	}

	/**
	 * 在指定目录生成导出数据
	 * 
	 * @param outFilePath
	 *            目标文件导出目录
	 * @param dataListList
	 *            数据列表
	 * @param headValueList
	 *            头字段对应的中文字段
	 * @param headKeyList
	 *            头字段
	 * @return
	 */
	private String exportFile(HttpServletRequest request,
			HttpServletResponse response,
			TStatsExportTemplateInfo statsExportTemplate,
			List<String> resultList, String condition) {

		String msg = null;

		// 输出地址真实路径
		String outFilePath = request.getSession().getServletContext()
				.getRealPath(Constants.EXCEL_EXPORT);

		// 数据集合
		int len = resultList.size();

		// 文件名后缀
		String suffix = FileSuffixEnum.EXCEL.getValue();

		String bigData = "F";

		// 如果大于最大行数
		if (len > Constants.MAX_ROWS) {
			suffix = FileSuffixEnum.ZIP.getValue();
			bigData = "T";
		}

		// 导出模板标题
		String titles = statsExportTemplate.getTitles();

		// 模板第一列标题会变化
		if (condition.equals("1")) {
			titles = titles.replace("{0}", "患者信息");
		} else if (condition.equals("2")) {
			titles = titles.replace("{0}", "住院信息");
		} else if (condition.equals("3")) {
			titles = titles.replace("{0}", "病案诊断信息");
		} else if (condition.equals("4")) {
			titles = titles.replace("{0}", "病案手术与操作信息");
		} else if (condition.equals("5")) {
			titles = titles.replace("{0}", "治疗信息");
		} else if (condition.equals("6")) {
			titles = titles.replace("{0}", "放疗信息");
		} else if (condition.equals("7")) {
			titles = titles.replace("{0}", "化疗信息");
		} else if (condition.equals("8")) {
			titles = titles.replace("{0}", "病案费用信息");
		}
		// LogUtil.log.info("导出模板标题：" + titles);

		// 导出模板名字
		String fileName = statsExportTemplate.getFilename();
		// LogUtil.log.info("导出模板名字：" + fileName);

		// 文件路径设置
		File file = FileUtil.createFile(outFilePath, fileName, suffix);
		LogUtil.log.info("下载文件路径:" + outFilePath + File.separator + fileName
				+ suffix);

		// 导出文件操作
		exportBigData.exportToZip(file, len, titles, resultList);

		msg = Constants.EXCEL_EXPORT + "/"
				+ file.getName().substring(0, file.getName().indexOf("."))
				+ "/" + bigData;

		return msg;
	}

	/**
	 * 下载文件
	 * 
	 * @param request
	 * @param fileName
	 * @param response
	 */
	@RequestMapping(value = "/data/quality/download/{filePath}/{fileName}/{bigData}", method = RequestMethod.GET)
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("filePath") String filePath,
			@PathVariable("fileName") String fileName,
			@PathVariable("bigData") String bigData, String title) {

		BufferedInputStream in = null;
		OutputStream out = null;
		File outFile = null;

		try {
			// 清空response
			response.reset();
			String suffix = FileSuffixEnum.EXCEL.getValue();

			if (bigData != null && bigData.equals("T")) {
				suffix = FileSuffixEnum.ZIP.getValue();
			}

			// if (bigData != null && bigData.equals("C")) {
			// suffix = FileSuffixEnum.CSV.getValue();
			// }

			// 真实路径
			String outFilePath = request.getSession().getServletContext()
					.getRealPath("/");
			if (!FileUtil.isExistsFile(outFilePath + filePath + File.separator
					+ fileName + suffix)) {
				return;
			}

			outFile = new File(outFilePath + filePath + File.separator
					+ fileName + suffix);

			if (bigData != null && bigData.equals("T")) {
				// 下载压缩zip文件
				response.setContentType("application/octet-stream");
			} else if (bigData != null && bigData.equals("C")) {
				// 下载csv文件
				response.setContentType("application/ms-txt");
			} else {
				// 下载excel
				response.setContentType("application/vnd.ms-excel");
			}

			String exportFileName = URLDecoder.decode(title, "UTF-8") + suffix;
			LogUtil.log.info("导出文件名称:" + exportFileName);

			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(exportFileName.getBytes("UTF-8"), "ISO8859-1"));
			response.setHeader("Content-Length",
					String.valueOf(outFile.length()));

			// 以流的形式下载文件。
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

			// 将生成的服务器端文件删除
			outFile.delete();
		} catch (IOException e) {
			if (outFile != null) {

				// 将生成的服务器端文件删除
				outFile.delete();
			}
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

	public static void main(String[] args) {
		String a = "[     {         'id': 'fieldDisplayName',         'name': '{0}',         'type': 2,         'rows': 2,         'cols': 1     },     {         'name': '随访系统',         'rows': 1,         'cols': 4,         'subTitles': [             {                 'id': 'totalNum',                 'name': '总数(计数)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'emptyValueNum',                 'name': '为空(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'notEmptyValueNum',                 'name': '非空(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'invalidDataNum',                 'name': '错误(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             }         ]     },     {         'name': '中间库',         'rows': 1,         'cols': 4,         'subTitles': [             {                 'id': 'totalNum1',                 'name': '总数(计数)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'emptyValueNum1',                 'name': '为空(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'notEmptyValueNum1',                 'name': '非空(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             },             {                 'id': 'invalidDataNum1',                 'name': '错误(%)',                 'type': 2,                 'rows': 1,                 'cols': 1             }         ]     } ]";
		a = a.replace("{0}", "住院信息");
		System.out.println(a);

	}
}
