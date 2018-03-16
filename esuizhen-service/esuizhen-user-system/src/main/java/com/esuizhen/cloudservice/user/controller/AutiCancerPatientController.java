/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.controller<br/>  
 * <b>文件名：</b>PatientService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月8日-下午2:11:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
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

import com.esuizhen.cloudservice.user.bean.AutiCancerPatientInfo;
import com.esuizhen.cloudservice.user.bean.AutiCancerTreatmentsInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientApproveInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientListResp;
import com.esuizhen.cloudservice.user.bean.AutiPatientReq;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseResp;
import com.esuizhen.cloudservice.user.common.followuppatient.Constants;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.esuizhen.cloudservice.user.service.RemarkService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: AutiCancerPatientController
 * @Description: 防癌患者相关接口
 * @author YYCHEN
 * @date 2016年09月22日 下午2:11:17
 */
@Controller
public class AutiCancerPatientController {


	@Autowired
	private PatientService patientService;
	@Autowired
	private RemarkService remarkService;
	@Autowired
	private MessageSource messageSource;

	/**
	 * 
	 * @Title: 
     * @Description:查询防癌患者信息列表
	 * @param
	 * @throws
	 */
	@RequestMapping(value="/auticancer/patient/query", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<AutiPatientListResp>> queryAutiCancerPatientList(@RequestBody(required=false) AutiPatientReq  autiPatientReq , Locale locale) {
		
		LogUtil.log.info("获取防癌患者列表(getAntiPatientList)==========>>");
		
		TMsgResponse<Page<AutiPatientListResp>> tMsgResponse = new TMsgResponse<Page<AutiPatientListResp>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<AutiPatientListResp> pages = patientService.searchAutiPatientList(autiPatientReq);
			tMsgResponse.setResult(pages);
			/*Page<PatientSimpleInfo> list = patientService.searchPatientSimpleInfoList(doctorId, reqFlag, page, num);
			tMsgResponse.setResult(list);*/
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @Title: 
     * @Description:导出防癌患者信息列表
	 * @param
	 * @throws
	 */
	@RequestMapping(value="/auticancer/patient/export", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> exportAutiCancerPatientList(@RequestBody(required=false) AutiPatientReq  autiPatientReq,HttpServletRequest request,HttpServletResponse response, Locale locale) {
		
		LogUtil.log.info("获取防癌患者列表(getAntiPatientList)==========>>");
		
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			String outFilePath = request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);
			
			String url = patientService.exportAutiPatientList(autiPatientReq,outFilePath);
			tMsgResponse.setResult(url);
			//this.downloadFile(request, response, outFile, "C");
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: 
     * @Description:查询防癌患者总数
	 * @param
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/auticancer/patienttotal/query", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Map> queryAutiPatientTotal(Locale locale) {
		
		LogUtil.log.info("获取防癌患者总数==========>>");
		
		TMsgResponse<Map> tMsgResponse = new TMsgResponse<Map>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			int total = patientService.getAutiPatientTotal();
			map.put("total", total);
			tMsgResponse.setResult(map);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @Title: 
     * @Description:查询防癌患者基本信息查询
	 * @param 
	 * @throws
	 */
	@RequestMapping(value="/auticancer/patientinfo/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<AutiCancerPatientInfo> queryAntiCancerPatientInfo(SpecialDiseaseReq req,Locale locale) {
		
		LogUtil.log.info("查询防癌患者基本信息==========>>");
		
		TMsgResponse<AutiCancerPatientInfo> tMsgResponse = new TMsgResponse<AutiCancerPatientInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			AutiCancerPatientInfo autiPatientInfo = patientService.getAutiPatientInfoById(req);
			tMsgResponse.setResult(autiPatientInfo);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@RequestMapping(value="/auticancer/patient/identification/exists", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Integer> isExistsIdentification(@RequestBody SpecialDiseaseReq req,Locale locale) {
		
		LogUtil.log.info("查询防癌患者基本信息==========>>");
		
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			int res = patientService.isExistsIdentification(req);
			tMsgResponse.setResult(res);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @Title: 
     * @Description:保存防癌患者基本信息
	 * @param 
	 * @throws
	 */
	@RequestMapping(value="/auticancer/patientinfo/save", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Map<String,Object>> saveAntiCancerPatientInfo(@RequestBody AutiCancerPatientInfo autiCancerPatientInfo,Locale locale) {
		
		LogUtil.log.info("保存防癌患者基本信息==========>>");
		
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if(autiCancerPatientInfo!=null){
				int mobileFlag = patientService.searchPatientByMobile(autiCancerPatientInfo);
				if(mobileFlag==1){
					tMsgResponse.setRespCode(-1);
					tMsgResponse.setRespMsg("mobile is used!");
					return tMsgResponse;
				}
			}
			Map<String,Object> reslut = patientService.saveAntiCancerPatientInfo(autiCancerPatientInfo);
			tMsgResponse.setResult(reslut);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 查询防癌患者审批信息
	* @return
	 */
	@RequestMapping(value="/auticancer/approveinfo/query", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<AutiPatientApproveInfo> queryAutiPatientApproveInfo(SpecialDiseaseReq req,Locale locale) {
		
		LogUtil.log.info("查询防癌患者审批信息==========>>");
		
		TMsgResponse<AutiPatientApproveInfo> tMsgResponse = new TMsgResponse<AutiPatientApproveInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			AutiPatientApproveInfo approveInfo = patientService.getAutiPatientApproveInfoById(req);
			tMsgResponse.setResult(approveInfo);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 
	 * @Title: 
     * @Description:保存防癌患者审批信息
	 * @param @return int 
	 * @throws
	 */
	@RequestMapping(value="/auticancer/approveinfo/save", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<AutiPatientApproveInfo> saveAntiCancerPatientApproveInfo(@RequestBody AutiPatientApproveInfo autiPatientApproveInfo,Locale locale) {
		
		LogUtil.log.info("保存防癌患者审批信息==========>>");
		
		TMsgResponse<AutiPatientApproveInfo> tMsgResponse = new TMsgResponse<AutiPatientApproveInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			patientService.saveAntiPatientApproveInfo(autiPatientApproveInfo);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 查询特殊病记录
	* @return
	 */
	@RequestMapping(value="/auticancer/specialdisease/query", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<SpecialDiseaseResp>> querySpecialDiseaseRecord(@RequestBody(required=false) SpecialDiseaseReq specialDiseaseReq,Locale locale) {
		
		LogUtil.log.info("查询特殊病记录==========>>");
		
		TMsgResponse<Page<SpecialDiseaseResp>> tMsgResponse = new TMsgResponse<Page<SpecialDiseaseResp>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<SpecialDiseaseResp> pages = patientService.getSpecialDiseaseRecord(specialDiseaseReq);
			tMsgResponse.setResult(pages);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 导出特殊病记录
	* @return
	 */
	@RequestMapping(value="/auticancer/specialdisease/export", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<String> exportSpecialDiseaseRecord(@RequestBody(required=false) SpecialDiseaseReq specialDiseaseReq,HttpServletRequest request,HttpServletResponse response, Locale locale) {
		
		LogUtil.log.info("导出特殊病记录==========>>");
		
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			String outFilePath = request.getSession().getServletContext().getRealPath(Constants.EXCEL_EXPORT);
			String url = patientService.exportSpecialDiseaseRecord(specialDiseaseReq,outFilePath);
			tMsgResponse.setResult(url);
			//this.downloadFile(request, response, outFile, "C");
			
			/*Page<PatientSimpleInfo> list = patientService.searchPatientSimpleInfoList(doctorId, reqFlag, page, num);
			tMsgResponse.setResult(list);*/
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月24日
	* @param 
	* @description 特病诊治及建议元数据元 查询 meta_special_disease_treatment
	* @return
	 */
	@RequestMapping(value="/auticancer/treatment/query", method=RequestMethod.POST)
	@ResponseBody
public TMsgResponse<List<AutiCancerTreatmentsInfo>> queryTreatmentMethods(@RequestBody(required=false) AutiCancerTreatmentsInfo treatmentsInfo, Locale locale) {
		
		LogUtil.log.info("获取特病诊治及建议元数据元 ==========>>");
		
		TMsgResponse<List<AutiCancerTreatmentsInfo>> tMsgResponse = new TMsgResponse<List<AutiCancerTreatmentsInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<AutiCancerTreatmentsInfo> list = patientService.queryTreatmentMethods(treatmentsInfo);
			
			tMsgResponse.setResult(list);
		} catch (EmptyParamExcption ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1400.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	 @RequestMapping(value="/download/{filePath}/{fileName}/{bigData}",method=RequestMethod.GET)
	 public void downloadFile(HttpServletRequest request,HttpServletResponse response,@PathVariable("filePath") String filePath,@PathVariable("fileName") String fileName,@PathVariable("bigData") String bigData,String title) {
    	BufferedInputStream in = null;
    	OutputStream out = null;
    	File outFile = null;
    	try {
	         // 清空response
	         response.reset();
	         String suffix = ".xls";
	         if(bigData != null && bigData.equals("T")) {
	        	 suffix = ".zip";
	         }
	         if(bigData != null && bigData.equals("C")){
	        	 suffix = ".csv";
	         }
	         String outFilePath = request.getSession().getServletContext().getRealPath("/");//真实路径
	         File f = new File(outFilePath+filePath+File.separator+fileName+suffix);
	         if(!f.exists()) {
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
