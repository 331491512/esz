package com.esuizhen.cloudservice.statistics.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import com.esuizhen.cloudservice.statistics.bean.StatsExportReq;
import com.esuizhen.cloudservice.statistics.constant.Constants;
import com.esuizhen.cloudservice.statistics.model.TStatsExportTemplateInfo;
import com.esuizhen.cloudservice.statistics.service.ExportBigData;
import com.esuizhen.cloudservice.statistics.service.StatsExportInfoService;
import com.esuizhen.cloudservice.statistics.util.FileSuffixEnum;
import com.esuizhen.cloudservice.statistics.util.FileUtil;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class StatsExportController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ExportBigData exportBigData;
	
	@Autowired
	private StatsExportInfoService statsExportInfoService;
	
	/**
	 *  导出统计信息
	 * @param request
	 * @param searchId
	 * @param title
	 * @param exportTemplateId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/data/export",method=RequestMethod.GET)
	public TMsgResponse<String> exportStatsData(HttpServletRequest request,Integer searchId, String title,String exportTemplateId,Locale locale) {
		LogUtil.log.info("开始导出患者信息，searchId=" + searchId+",exportTemplateId=" + exportTemplateId);
		String msg = null;
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TStatsExportTemplateInfo statsExportInfo = statsExportInfoService.statsExportTemplate(exportTemplateId);
			List<String> statsExportValueList = statsExportInfoService.statsExportValue(exportTemplateId, searchId);
			if(statsExportInfo == null || statsExportValueList == null || statsExportValueList.size() == 0) {
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else {
				msg = getExportUrl(request,title,statsExportInfo,statsExportValueList);
				if(msg == null) {
					tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
					tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
					tMsgResponse.setErrorDesc("生成文件失败,返回地址null ");
				}else {
					tMsgResponse.setResult(msg);
				}
			}
			
			
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("导出患者信息结束.");
		return tMsgResponse;
	}
	
	private String getExportUrl(HttpServletRequest request,String title,TStatsExportTemplateInfo statsExportInfo,List<String> statsExportValueList) throws Exception {
		String msg = null;
		String outFilePath = request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);//真实路径
		msg = exportFile(outFilePath,statsExportInfo,statsExportValueList);
		return msg;
	}
	
	/**
	 * 在指定目录生成导出数据
	 * @param outFilePath 目标文件导出目录
	 * @param dataListList 数据列表
	 * @param headValueList 头字段对应的中文字段
	 * @param headKeyList 头字段
	 * @return
	 */
	private String exportFile(String outFilePath,TStatsExportTemplateInfo statsExportTemplate,List<String> statsExportValueList) {
		String msg = null;
		int len = statsExportValueList.size();
		String suffix = FileSuffixEnum.EXCEL.getValue();
    	String bigData = "F";
    	if(len > Constants.MAX_ROWS) {
    		suffix = FileSuffixEnum.ZIP.getValue();
    		bigData = "T";
    	}
    	String titles = statsExportTemplate.getTitles();//统计导出模板title
    	String fileName = statsExportTemplate.getFilename();
		File file = FileUtil.createFile(outFilePath,fileName,suffix);
		
		exportBigData.exportToZip(file, len,titles,statsExportValueList);
		msg = Constants.EXCEL_EXPORT+"/"+file.getName().substring(0, file.getName().indexOf("."))+"/"+bigData;
		return msg;
	}
	
	/**
     * 下载文件
     * @param request
     * @param fileName
     * @param response
     */
    @RequestMapping(value="/patient/download/{filePath}/{fileName}/{bigData}",method=RequestMethod.GET)
	 public void downloadFile(HttpServletRequest request,HttpServletResponse response,@PathVariable("filePath") String filePath,@PathVariable("fileName") String fileName,@PathVariable("bigData") String bigData) {
    	BufferedInputStream in = null;
    	OutputStream out = null;
    	File outFile = null;
    	try {
	         // 清空response
	         response.reset();
	         String suffix = FileSuffixEnum.EXCEL.getValue();
	         if(bigData != null && bigData.equals("T")) {
	        	 suffix = FileSuffixEnum.ZIP.getValue();
	         }
	         String exportFileName = URLDecoder.decode(fileName, "UTF-8") + suffix;
	    	 LogUtil.log.info("导出文件名称:" + exportFileName);
	         String outFilePath = request.getSession().getServletContext().getRealPath("/");//真实路径
	         if(!FileUtil.isExistsFile(outFilePath+filePath+File.separator+exportFileName)) {
	        	 return;
	         }
	    	 outFile = new File(outFilePath+filePath+File.separator+exportFileName);
	    	 if(bigData != null && bigData.equals("T")) {
	        	 response.setContentType("application/octet-stream");//下载压缩zip文件
	         }else {
	        	 response.setContentType("application/vnd.ms-excel");//下载excel
	         }
//	    	 String exportFileName = TemplateUtil.getExcelExportInfo("followPatientExportFile");
//	    	 LogUtil.log.info("导出文件名称:" + exportFileName);
	    	 
	         response.setHeader("Content-Disposition", "attachment;filename=" + new String(exportFileName.getBytes("UTF-8"),"ISO8859-1"));
	         response.setHeader("Content-Length",String.valueOf(outFile.length()));
	         // 以流的形式下载文件。
	         in = new BufferedInputStream(new FileInputStream(outFile));
	         out = new BufferedOutputStream(response.getOutputStream());
	         byte[] data = new byte[1024];
            int len = 0;
            while (-1 != (len=in.read(data, 0, data.length))) {
                out.write(data, 0, len);
            }
	         out.flush();
	         out.close();
	         in.close();
	         outFile.delete();//将生成的服务器端文件删除
	      }
	      catch (IOException e) {
	    	  if(outFile != null) {
	    		  outFile.delete();//将生成的服务器端文件删除
	    	  }
	    	  LogUtil.logError.info("下载文件失败", e);
	     }finally {
	    	 try {
	    		 if(out != null) {
	 	    		out.close(); 
	 	    	 }
	 	    	 if(in != null) {
	 	    		 in.close();
	 	    	 }
	    	 }catch(IOException e) {
	    		 e.printStackTrace();
	    	 }
	     }
	 }
    
    @ResponseBody
	@RequestMapping(value="/followupway/statistics/export",method=RequestMethod.POST)
	public TMsgResponse<String> exportStatsData(HttpServletRequest request,@RequestBody StatsExportReq req,Locale locale) {
		Integer searchId = req.getSearchId();
		String exportTemplateId = req.getExportTemplateId();
		String title = req.getTitle();
		Integer followupWaySearchId = req.getFollowupWaySearchId();
		Integer outPatientFlagSearchId = req.getOutPatientFlagSearchId();
		Integer followupWayTotalSearchId = req.getFollowupWayTotalSearchId();
    	LogUtil.log.info("开始导出患者信息，searchId=" + searchId+",exportTemplateId=" + exportTemplateId);
		String msg = null;
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TStatsExportTemplateInfo statsExportInfo = statsExportInfoService.statsExportTemplate(exportTemplateId);
			Map<String,List<String>> valuesMap = new LinkedHashMap<String,List<String>>();
			valuesMap.put("a", statsExportInfoService.statsExportValue(exportTemplateId, followupWaySearchId));
			valuesMap.put("b", statsExportInfoService.statsExportValue(exportTemplateId, outPatientFlagSearchId));
			valuesMap.put("c", statsExportInfoService.statsExportValue(exportTemplateId, followupWayTotalSearchId));
			msg = getExportUrl(request,title,statsExportInfo,valuesMap);
			tMsgResponse.setResult(msg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("导出患者信息结束.");
		return tMsgResponse;
	}
    
    private String getExportUrl(HttpServletRequest request,String title,TStatsExportTemplateInfo statsExportInfo,Map<String,List<String>> valuesMap) throws Exception {
		String msg = null;
		String outFilePath = request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);//真实路径
		String suffix = FileSuffixEnum.EXCEL.getValue();
    	String bigData = "F";
    	String titles = statsExportInfo.getTitles();//统计导出模板title
    	String fileName = statsExportInfo.getFilename();
		File file = FileUtil.createFile(outFilePath,fileName,suffix);
		
		exportBigData.exportToZip(file,titles,valuesMap);
		msg = Constants.EXCEL_EXPORT+"/"+file.getName().substring(0, file.getName().indexOf("."))+"/"+bigData;
		return msg;
	}
}
