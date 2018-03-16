package com.esuizhen.cloudservice.followup.controller.review;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.ReBasiserReviewOrderReq;
import com.esuizhen.cloudservice.followup.bean.ReviewRecordReq;
import com.esuizhen.cloudservice.followup.common.Constant;
import com.esuizhen.cloudservice.followup.model.review.FollowupReviewAppoint;
import com.esuizhen.cloudservice.followup.service.review.ReviewService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Controller
public class ReviewController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ReviewService reviewService;
	
	/**
	 * 预约复查
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/review/order/reBasiser" , method=RequestMethod.POST)
	public TMsgResponse<Integer> reBasiserReviewOrder(@RequestBody ReBasiserReviewOrderReq reBasiserReviewOrderReq, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = reviewService.reBasiserReviewOrder(reBasiserReviewOrderReq);
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查询预约复查记录
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/review/record/query" , method=RequestMethod.POST)
	public TMsgResponse<Page<FollowupReviewAppoint>> queryReviewRecord(@RequestBody ReviewRecordReq reviewRecordReq, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<FollowupReviewAppoint>> msg = new TMsgResponse<Page<FollowupReviewAppoint>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = reviewService.queryReviewRecord(reviewRecordReq);
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查询预约复查记录 HttpServletRequest request,
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/review/record/export" , method=RequestMethod.POST)
	public TMsgResponse<String> exportReviewRecord(@RequestBody ReviewRecordReq reviewRecordReq,  HttpServletRequest request,Locale locale)
	{
		LogUtil.log.info("开始导出患者信息，param:"+JsonUtil.toJson(reviewRecordReq));
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.getCode());
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
//			reviewRecordReq.setExportTemplateId("EXPTPAPPLY");
			String outFilePath = request.getSession().getServletContext().getRealPath(Constant.EXCEL_EXPORT);
//			String outFilePath = "excelExport";
			reviewRecordReq.setOutFilePath(outFilePath);
			long starttime = System.currentTimeMillis();
			msg.result = reviewService.exportReviewRecord(reviewRecordReq);
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
	 * 查询预约复查概况
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/review/summary/query" , method=RequestMethod.GET)
	public TMsgResponse<Map<String,Integer>> queryReviewOrderSummary(Integer userRole,Long userId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String,Integer>> msg = new TMsgResponse<Map<String,Integer>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = reviewService.queryReviewOrderSummary(userRole, userId);
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
     * 下载文件
     * @param request
     * @param fileName
     * @param response
     */
    /*@RequestMapping(value="/download/{filePath}/{fileName}/{bigData}",method=RequestMethod.GET)
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
	 }*/
    
    
    /**
	 * 复查预约答复
	 * @param req
	 * @param locale
	 * @return
	 * @author fanpanwei
	 */
	@ResponseBody
	@RequestMapping(value="/review/answer/save" , method=RequestMethod.POST)
	public TMsgResponse<Integer> saveReviewOrderAnswer(@RequestBody FollowupReviewAppoint record, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = reviewService.saveReviewOrderAnswer(record);
			
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
