/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.controller;<br/>  
 * <b>文件名：</b>MonitorController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年7月19日下午3:59:37<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.server.sync.bean.TBatchInfo;
import com.esuizhen.server.sync.service.MonitorDataService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sync.MonitorDataPushReq;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: MonitorController
* @Description: 
* @author lichenghao
* @date 2017年7月19日 下午3:59:37  
*/
@Controller
public class MonitorController {
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private MonitorDataService monitorDataService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :monitorDataPush
	 * @Description:数据监控同步
	 * @return TMsgResponse<TBatchInfo>
	 * @date 2017年7月19日 下午4:07:14
	 */
	@ResponseBody
	@RequestMapping(value="/monitor/data/push",method=RequestMethod.POST)
	public TMsgResponse<TBatchInfo> pushMonitorData (@RequestBody MonitorDataPushReq  req,Locale locale){
		TMsgResponse<TBatchInfo> msg = new TMsgResponse<TBatchInfo>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			monitorDataService.pushMonitorData(req);
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
}
