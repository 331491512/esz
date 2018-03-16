/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.controller;<br/>
 * <b>文件名：</b>BatchController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:02:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.controller;

import com.esuizhen.server.sync.bean.*;
import com.esuizhen.server.sync.service.BatchService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/** 
* @ClassName: BatchController
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午8:02:56  
*/
@Controller
public class BatchController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private BatchService batchService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getBatchInfo
	 * @Description:2.1.1	获取批次接口-BatchInfoGet
	 * @return TMsgResponse<TBatchInfo>
	 * @date 2017年3月18日 下午2:28:49
	 */
	@ResponseBody
	@RequestMapping(value="/batch/info/get",method=RequestMethod.POST)
	public TMsgResponse<TBatchInfo> getBatchInfo (@RequestBody BatchInfoGetReq  req,Locale locale){
		TMsgResponse<TBatchInfo> msg = new TMsgResponse<TBatchInfo>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result=batchService.getBatchInfo(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :pushBatchData
	 * @Description:2.1.2	批次数据推送-BatchDataPush
	 * @return TMsgResponse<Object>
	 * @date 2017年3月18日 下午2:32:57
	 */
	@ResponseBody
	@RequestMapping(value="/batch/data/push",method=RequestMethod.POST)
	public TMsgResponse<Object> pushBatchData(@RequestBody BatchDataPushReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.pushBatchData(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getBatChDataResult
	 * @Description:2.1.3	批次数据结果拉取-BatchDataResultGet
	 * @return TMsgResponse<List<TBatchDataResultInfo>>
	 * @date 2017年3月18日 下午2:36:44
	 */
	@ResponseBody
	@RequestMapping(value="/batch/data/result/get",method=RequestMethod.POST)
	public TMsgResponse<List<TBatchDataResultInfo>> getBatChDataResult(@RequestBody BatchDataResultGetReq req,Locale locale){
		TMsgResponse<List<TBatchDataResultInfo>> msg = new TMsgResponse<List<TBatchDataResultInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			msg.result=batchService.getBatchDataResult(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateBatchProcess
	 * @Description:2.1.4	批次状态控制-BatchProcessUpdate
	 * @return TMsgResponse<TBatchInfo>
	 * @date 2017年3月18日 下午2:28:56
	 */
	@ResponseBody
	@RequestMapping(value="/batch/process/update",method=RequestMethod.POST)
	public TMsgResponse<Object> updateBatchProcess(@RequestBody BatchProcessUpdateReq  req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.updateBatchProcess(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 */
	@ResponseBody
	@RequestMapping(value="/batch/process/do",method=RequestMethod.POST)
	public TMsgResponse<Object> doBatchProcess(@RequestBody BatchProcessDoReq  req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.doBatchProcess(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value="/batch/process/test",method=RequestMethod.POST)
	public TMsgResponse<Object> doBatchProcess1(@RequestBody BatchProcessDoReq  req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}

	/**
	 * 被合并的已同步患者推送
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/merge",method=RequestMethod.POST)
	public TMsgResponse<Object> syncPatientMergeInfo(@RequestBody PatientMergeInfoSyncReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.pushPatientMergeInfo(req);
		} catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (EmptyParamExcption e) {
			msg.setRespCode(ErrorMessage.E1410.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(e.getMessage());
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
}
