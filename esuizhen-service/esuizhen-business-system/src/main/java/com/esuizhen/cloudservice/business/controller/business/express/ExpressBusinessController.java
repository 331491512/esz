/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.business.express;<br/>  
 * <b>文件名：</b>ExpressServiceController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年1月6日下午2:23:49<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.business.express;

import com.esuizhen.cloudservice.business.bean.MedicaRecordCopyServiceStateUpdateReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnReq;
import com.esuizhen.cloudservice.business.bean.ServiceColumnResult;
import com.esuizhen.cloudservice.business.service.business.express.ExpressService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
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
* @ClassName: ExpressServiceController
* @Description: 病案复印邮寄
* @author lichenghao
* @date 2017年1月6日 下午2:23:49  
*/
@Controller
public class ExpressBusinessController {
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ExpressService expressService;
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateExpressServiceState
	 * @Description:病案邮寄服务进展状态
	 * @return TMsgResponse<Void>
	 * @date 2017年1月6日 下午3:14:58
	 */
	/*@ResponseBody
	@RequestMapping(value = "/service/express/state/update", method = RequestMethod.POST)
	public TMsgResponse<Void> updateExpressServiceState(@RequestBody ExpressServiceStateUpdateReq req,Locale locale){
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			expressService.updateExpressServiceState(req);
		}catch(EmptyParamExcption ex){
			msg.respCode = ErrorMessage.E1410.code;
			msg.respMsg = ex.getMessage();
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = ex.getMessage();
		}
		return msg;
	}*/

	@ResponseBody
	@RequestMapping(value = "/service/medicalrecord/state/update", method = RequestMethod.POST)
	public TMsgResponse<Void> updateExpressServiceState(@RequestBody MedicaRecordCopyServiceStateUpdateReq req, Locale locale){
		TMsgResponse<Void> msg = new TMsgResponse<Void>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			expressService.updateMedicalrecordServiceState(req);
		}catch(EmptyParamExcption ex){
			msg.respCode = ErrorMessage.E1410.code;
			msg.respMsg = ex.getMessage();
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = ex.getMessage();
		}
		return msg;
	}

	@RequestMapping(value="/service/column/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<ServiceColumnResult>> getServiceColumnList(ServiceColumnReq req,Locale locale){
		TMsgResponse<List<ServiceColumnResult>> msg=new TMsgResponse<List<ServiceColumnResult>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info,null,locale);
		try {
			msg.result = expressService.selectServiceColumnList(req);
		}catch(EmptyParamExcption ex){
            msg.respCode = ErrorMessage.E1410.code;
            msg.respMsg = ex.getMessage();
            LogUtil.logError.error(ex.getMessage(),ex);
        }catch (Exception e){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=e.getMessage();
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
}
