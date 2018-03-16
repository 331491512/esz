package com.esuizhen.cloudservice.user.controller.followuppatient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.PatientExportReq;
import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.followuppatient.util.FileSuffixEnum;
import com.esuizhen.cloudservice.user.followuppatient.util.FileUtil;
import com.esuizhen.cloudservice.user.service.followuppatient.ExportBigData;
import com.esuizhen.cloudservice.user.service.followuppatient.FollowupPatientService;
import com.esuizhen.cloudservice.user.service.followuppatient.TPatientExportTemplateInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Controller
public class ExportFollowupPatientController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FollowupPatientService patientFollowupService;
	
	@Autowired
	private ExportBigData exportBigData;
	
	@Autowired
	private TPatientExportTemplateInfoService patientExportTemplateInfoService;
	
	/**
	 * 患者列表导出
	 * @param request
	 * @param searchId
	 * @param title
	 * @param exportTemplateId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/export/patient",method=RequestMethod.GET)
	public TMsgResponse<String> exportPatient(PatientExportReq req,HttpServletRequest request,Locale locale) {
		LogUtil.log.info("开始导出患者信息，param:"+JsonUtil.toJson(req));
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			req.outFilePath=request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);
			long starttime = System.currentTimeMillis();
			msg.result = patientFollowupService.exportPatient(req);
			LogUtil.logError.error("--------all--------"+(System.currentTimeMillis()-starttime));
		}catch(EmptyParamExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1410.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(EmptyObjectExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(Exception e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 获取当前查询可导出的随访表数目
	 * @param request
	 * @param searchId
	 * @param title
	 * @param exportTemplateId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/export/table/total",method=RequestMethod.GET)
	public TMsgResponse<HashMap<String, Integer>> queryFollowupTableTotal(PatientExportReq req,HttpServletRequest request,Locale locale) {
		LogUtil.log.info("计算可导出的随访表条数，param:"+JsonUtil.toJson(req));
		TMsgResponse<HashMap<String, Integer>> msg = new TMsgResponse<HashMap<String, Integer>>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			Integer total= patientFollowupService.getFollowupTableTotal(req);
			hm.put("total", total);
			 msg.setResult(hm);
		}catch(EmptyParamExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1410.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(EmptyObjectExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(Exception e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * 随访表列表导出
	 * @param request
	 * @param searchId
	 * @param title
	 * @param exportTemplateId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/export/followup/table",method=RequestMethod.GET)
	public TMsgResponse<String> exportFollowupTable(PatientExportReq req,HttpServletRequest request,Locale locale) {
		LogUtil.log.info("开始导出随访表信息，param:"+JsonUtil.toJson(req));
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			req.outFilePath=request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);
			long starttime = System.currentTimeMillis();
			msg.result = patientFollowupService.exportFollowupTable(req);
			LogUtil.logError.error("--------all--------"+(System.currentTimeMillis()-starttime));
		}catch(EmptyParamExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1410.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1410.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(EmptyObjectExcption e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1404.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}catch(Exception e){
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}
	/**
     * 下载文件
     * @param request
     * @param fileName
     * @param response
     */
    @RequestMapping(value="/patient/download/{filePath}/{fileName}/{bigData}",method=RequestMethod.GET)
	 public void downloadFile(HttpServletRequest request,HttpServletResponse response,@PathVariable("filePath") String filePath,@PathVariable("fileName") String fileName,@PathVariable("bigData") String bigData,String title) {
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
	         if(bigData != null && bigData.equals("C")){
	        	 suffix = FileSuffixEnum.CSV.getValue();
	         }
	         String outFilePath = request.getSession().getServletContext().getRealPath("/");//真实路径
	         if(!FileUtil.isExistsFile(outFilePath+filePath+File.separator+fileName+suffix)) {
	        	 return;
	         }
	    	 outFile = new File(outFilePath+filePath+File.separator+fileName+suffix);
	    	 if(bigData != null && bigData.equals("T")) {
	    		 response.setContentType("application/octet-stream");//下载压缩zip文件
	         }else if(bigData!=null&&bigData.equals("C")){
	        	 response.setContentType("application/ms-txt");//下载csv文件
	         }else {
	        	 response.setContentType("application/vnd.ms-excel");//下载excel
	         }
	    	 String exportFileName = URLDecoder.decode(title, "UTF-8") + suffix;
	    	 LogUtil.log.info("导出文件名称:" + exportFileName);
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
}
