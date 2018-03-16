package com.esuizhen.cloudservice.ehr.controller.inhospital;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.esuizhen.cloudservice.ehr.service.inhospital.PatientDataImportService;
import com.esuizhen.cloudservice.ehr.service.inhospital.TInhospitalDetailInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TInhospitalDetailInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TInhospitalDetailInfoService inhospitalDetailInfoService;
	@Autowired
	private PatientDataImportService patientDataImportService;
	
	@ResponseBody
	@RequestMapping(value="/inhospital/info/query" , method=RequestMethod.GET)
	public TMsgResponse<Page<TInhospitalInfo>> queryInhospitalInfo(Long patientId ,String outhospitalDateStart,String outhospitalDateEnd,Integer outhospitalDeptId,Integer page,Integer num,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TInhospitalInfo>> msg = new TMsgResponse<Page<TInhospitalInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = inhospitalDetailInfoService.queryInhospitalInfo(patientId,outhospitalDateStart,outhospitalDateEnd,outhospitalDeptId,page,num);
			
			/*if(msg.result.getDataList()==null||msg.result.getDataList().size()<1)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}*/
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/detail/query" , method=RequestMethod.GET)
	public TMsgResponse<TInhospitalDetailInfo> queryInhospitalDetail(String inhospitalId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TInhospitalDetailInfo> msg = new TMsgResponse<TInhospitalDetailInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = inhospitalDetailInfoService.queryInhospitalDetail(inhospitalId);
			
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/detal/delete" , method=RequestMethod.GET)
	public TMsgResponse<String> deleteInhospitalDetail(String inhospitalId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//删除
			inhospitalDetailInfoService.deleteInhospitalDetail(inhospitalId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/detail/update" , method=RequestMethod.POST)
	public TMsgResponse<String> updateInhospitalDetail(@RequestBody TInhospitalDetailInfo inhospitalDetailInfo , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改
			inhospitalDetailInfoService.updateInhospitalDetail(inhospitalDetailInfo);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/detail/create" , method=RequestMethod.POST)
	public TMsgResponse<TInhospitalDetailInfo> createInhospitalDetail(@RequestBody TInhospitalDetailInfo inhospitalDetailInfo , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TInhospitalDetailInfo> msg = new TMsgResponse<TInhospitalDetailInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//新增
			msg.result = inhospitalDetailInfoService.createInhospitalDetail(inhospitalDetailInfo);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			ex.printStackTrace();
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/filing/update" , method=RequestMethod.POST)
	public TMsgResponse<String> updateInhospitalFiling (@RequestBody PatientInfoReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//修改
			inhospitalDetailInfoService.updateInhospitalFiling(req);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 患者住院信息excel导入
	 */
//	@RequestMapping(value="/inhospital/info/import",method=RequestMethod.POST)
//	@ResponseBody
//	public TMsgResponse<Integer> importInhospitalInfo(HttpSession session, HttpServletRequest request, @RequestBody InhospitalInfoImportReq req,Locale locale) {
//		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
//		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
//		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
//		InputStream in = null;
//		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//		// 取得request中的所有文件名
//		Iterator<String> iter = multiRequest.getFileNames();
//		int type = 0;
//		// 记录上传过程起始时的时间，用来计算上传时间
//		long start = System.currentTimeMillis();
//		while (iter.hasNext()) {
//			// 取得上传文件
//			MultipartFile file = multiRequest.getFile(iter.next());
//			if (file != null) {
//				// 取得当前上传文件的文件名称
//				try {
//					in = file.getInputStream();
//					String extension = file.getOriginalFilename().lastIndexOf(".") == -1 ? ""
//							: file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//					if ("xls".equals(extension)) {
//						type = 0;
//					} else if("xlsx".equals(extension)){
//						type = 1;
//					}
//					tMsgResponse.result = patientDataImportService.importInhospitalInfo(in, type);
//				} catch (Exception e) {
//					LogUtil.logError.error("#########[导入病案信息失败]#########", e);
//				}
//			}
//		}
//		// 记录上传该文件后的时间
//		long end = System.currentTimeMillis();
//		long diff = (end-start)/1000l;
//		LogUtil.log.info("导入住院信息共花了==>"+ diff+"秒");
//		if (null != in) {
//			try {
//				in.close();
//			}
//			catch (IOException e) {
//				LogUtil.logError.error("#########[关闭文件失败]#########", e);
//			}
//		}
//		return tMsgResponse;
//	}
	
	@ResponseBody
	@RequestMapping(value="/inhospital/info/import",method=RequestMethod.POST)
	public TMsgResponse<Integer> importInhospitalInfo(@RequestParam("file") MultipartFile uploadFile,
			String templateFileName, Locale locale, HttpServletRequest request) {
		
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		int type = 0;
		InputStream in = null;
		// 记录上传过程起始时的时间，用来计算上传时间
		long start = System.currentTimeMillis();
		try {
			if (uploadFile != null) {
				// 取得当前上传文件的文件名称
				try {
					in = uploadFile.getInputStream();
					String extension = uploadFile.getOriginalFilename().lastIndexOf(".") == -1 ? ""
							: uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1);
					if ("xls".equals(extension)) {
						type = 0;
					} else if("xlsx".equals(extension)){
						type = 1;
					}
					HttpSession session = request.getSession(true);
					msg.result = patientDataImportService.importInhospitalInfo(in, type, templateFileName, session);
				} catch (Exception e) {
					LogUtil.logError.error("#########[导入病案信息失败]#########", e);
				}
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		// 记录上传该文件后的时间
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.info("导入住院信息共花了==>"+ diff+"秒");
		if (null != in) {
			try {
				in.close();
			}
			catch (IOException e) {
				LogUtil.logError.error("#########[关闭文件失败]#########", e);
			}
		}
		return msg;
		
		
		
	}

	
	@RequestMapping(value="/inhospital/info/import/test",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Integer> importIntenetInhospitalInfo(Locale locale, HttpSession session) {
		long start = System.currentTimeMillis();
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		InputStream in = null;
		int type = 0;
		try {
			in = new FileInputStream("D:\\temp\\testdaoruhaunzhe1.xls");
//			in = new FileInputStream("D:\\temp\\inhospitalImportTemplateFile.xls");
			tMsgResponse.result = patientDataImportService.importInhospitalInfo(in, type, "", session);
		} catch (Exception e) {
			LogUtil.logError.error("#########[导入病案信息失败]#########", e);
		}
		
		// 记录上传过程起始时的时间，用来计算上传时间
		// 记录上传该文件后的时间
		if (null != in) {
			try {
				in.close();
			}
			catch (IOException e) {
				LogUtil.logError.error("#########[关闭文件失败]#########", e);
			}
		}
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.info("导入住院信息共花了==>"+ diff+"秒");
		return tMsgResponse;
	}
}

