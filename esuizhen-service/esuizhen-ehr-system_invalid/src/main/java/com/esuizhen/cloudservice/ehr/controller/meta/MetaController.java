/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.controller.meta<br/>  
 * <b>文件名：</b>MetaController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日下午2:58:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.controller.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.TMetaEIcdO;
import com.esuizhen.cloudservice.ehr.model.disease.TAnesthesiaWayInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisBasisInfo;
import com.esuizhen.cloudservice.ehr.model.disease.TDiagnosisTypeInfo;
import com.esuizhen.cloudservice.ehr.service.meta.MetaService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: MetaController
* @Description: 
* @author NiDan
* @date 2016年8月15日下午2:58:53 
*/
@Controller
public class MetaController {
	
	@Autowired
	private MetaService metaService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value="/metainfo/icdo/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TMetaEIcdO>> getMetaInfoIcdOList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaEIcdO>> msg=new TMsgResponse<List<TMetaEIcdO>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale);
		try{
			msg.result=metaService.queryMetaEIcdOList();
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info,null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/metainfo/diagnosis/type/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TDiagnosisTypeInfo>> getMetaInfoDiagnosisTypeList(Integer flag,Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDiagnosisTypeInfo>> msg=new TMsgResponse<List<TDiagnosisTypeInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info,null, locale);
		try{
			msg.result=metaService.queryDiagnosisTypeList(flag);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null,locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/metainfo/diagnosisBasis/query",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TDiagnosisBasisInfo>> queryDiagnosisBasis(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDiagnosisBasisInfo>> msg=new TMsgResponse<List<TDiagnosisBasisInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=metaService.queryDiagnosisBasisList();
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@RequestMapping(value="/metainfo/anesthesia/way/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TAnesthesiaWayInfo>> getMetaInfoAnesthesiaWayList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TAnesthesiaWayInfo>> msg=new TMsgResponse<List<TAnesthesiaWayInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=metaService.queryAnesthesiaWayList();
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}

	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:1.检查方式元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/exam/way/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoExamWayList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_exam_way";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:2.放疗目的元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/radiotherapy/type/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoRadiotherapyTypeList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_radiotherapy_type";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:3.放射源元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/radiation/source/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoRadionSourceList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_radiation_source";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:4.照射方式元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/irradiation/way/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoIrradiationWayList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_irradiation_way";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:5.单次剂量单位元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/dosage/unit/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoDosageUnitList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_info_dosage_unit";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:6.给药途径元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/route/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoRouteList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_info_route";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:7.给药频率元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/frequency/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoFrequencyList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_info_frequency";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:8.治疗效果元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/therapeutic/effect/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoTherapeuticEffectList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_therapeutic_effect";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:9.危险因素元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/hazards/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoHazardsList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_hazards";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:10.营养状态元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/nutrition/state/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoNutritionStateList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_nutrition_state";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:11.意识状态元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/consciou/state/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoConsciouStateList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_consciou_state";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:12.体型元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/bodily/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoBodilyList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_bodily";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:13.发育元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/development/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoDevelopmentList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_development";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:14.面容表情元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/face/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoFaceList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_face";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:15.语调元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/intonation/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoIntonationList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_intonation";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:16.体位元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/body/position/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoBodyPositionList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_body_position";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:17.步态元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/gait/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getMetaInfoGaitList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="meta_gait";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:18.化疗方案类别元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/chemo/plan/kind",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getChemoPlanKindList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="ehr_db.meta_chemo_regimen_category";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年4月8日
	* @param 
	* @description:19.化疗类型元数据
	* @return
	 */
	@RequestMapping(value="/metainfo/chemo/type",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<HashMap<String,Object>>> getChemoTypeList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,Object>>> msg=new TMsgResponse<List<HashMap<String,Object>>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			String tableName="ehr_db.meta_chemo_type";
			String condition=null;
			msg.result=metaService.getMetaListByTableName(tableName, condition);
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	
	
}
