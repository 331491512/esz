/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.controller;<br/>
 * <b>文件名：</b>BatchController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:02:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.client.sync.bean.BatchDataPushReq;
import com.esuizhen.client.sync.bean.BatchDataResultGetReq;
import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.service.BatchService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

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
	 * @title :pushBatchData
	 * @Description:2.1.2	批次数据推送-BatchDataPush
	 * @return TMsgResponse<Object>
	 * @date 2017年3月18日 下午2:32:57
	 */
	@ResponseBody
	@RequestMapping(value="/batch/data/push",method=RequestMethod.GET)
	public TMsgResponse<Object> pushBatchData(BatchDataPushReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.runBatchPush();
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
	@RequestMapping(value="/batch/data/result/get",method=RequestMethod.GET)
	public TMsgResponse<List<TBatchDataResultInfo>> getBatChDataResult(BatchDataResultGetReq req,Locale locale){
		TMsgResponse<List<TBatchDataResultInfo>> msg = new TMsgResponse<List<TBatchDataResultInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.runBatchGetResult();
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

	@RequestMapping(value="/patient/merge/push",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> pushPatientMerge(Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			batchService.initSyncCtl();
			batchService.runPatientMerger();
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
	
	/**
	 * 
	 * @author lichenghao
	 * @title :initSyncCtl
	 * @Description:初始化同步开关
	 * @return TMsgResponse<Object>
	 * @date 2017年7月10日 下午4:44:26
	 */
	@RequestMapping(value="/init/sync/ctl",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> initSyncCtl(Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
			batchService.initSyncCtl();
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :pushMonitorToServer
	 * @Description:数据监控临时调用
	 * @return TMsgResponse<Object>
	 * @date 2017年7月19日 下午6:47:11
	 */
	@RequestMapping(value="/push/monitor/to/server",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> pushMonitorToServer(String date,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		batchService.pushMonitorToServer(date);
		return msg;
	}
}
