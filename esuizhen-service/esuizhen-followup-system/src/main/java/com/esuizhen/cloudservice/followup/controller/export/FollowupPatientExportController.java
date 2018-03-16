package com.esuizhen.cloudservice.followup.controller.export;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esuizhen.cloudservice.followup.util.FileSuffixEnum;
import com.esuizhen.cloudservice.followup.util.FileUtil;
import com.westangel.common.util.LogUtil;

@Controller
public class FollowupPatientExportController {
		
	/**
     * 下载文件
     * @param request
     * @param fileName
     * @param response
     */
    @RequestMapping(value="/download/{filePath}/{fileName}/{bigData}",method=RequestMethod.GET)
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
