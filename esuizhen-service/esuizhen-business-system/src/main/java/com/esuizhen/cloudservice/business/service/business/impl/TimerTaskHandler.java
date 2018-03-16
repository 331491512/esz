package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.ProductServiceConf;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.TimerTaskFactoryService;
import com.westangel.common.service.TimertaskService;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * 创建或删除定时监控任务。调用任务工厂的方法生成或删除。
 * 主要是：
 * 1. 图文、电话咨询、私人医生、预约挂号、MDT等各类通用的24小时超时取消业务处理
 *    在ProductApplyServiceImpl.doProductApply中统一调用任务工厂的方法创建此类定时任务。
 * 2. 电话咨询的预约时间前60分钟、前5分钟、延误15分钟、延误30分钟的定时提醒任务。
 * 3. 在ProductApplyServiceImpl.acceptApply方法中,当同意、拒绝、修改等动作被处理时，表示业务已被处理，
 *    需要删除超时定时任务。
 * 
 * @author DaLoong
 * @date   2016/1/22
 *
 */
@Component
public class TimerTaskHandler {
	@Value("${server.api.url.root}")
	private String serverUrlRoot;

	@Autowired
	TimertaskService   timerTaskService;
	
	@Autowired
	TimerTaskFactoryService timerTaskFactoryService;
	
	/** 
	 * 创建（24小时）监控任务定时器
	 * @param psa
	 */
	public void createMonTimerTask(String productApplyId,int productType,String taskTag) {
		// TODO Auto-generated method stub
		try{
			String url = serverUrlRoot+"/timerfactory/generalservice/timer/create?productApplyId="+productApplyId
			+"&productType="+productType+"&taskTag="+taskTag;
			String result = HttpUtil.get(url);
			if(result!=null){
				TMsgResponse resp = JSON.parseObject(result,TMsgResponse.class);
				LogUtil.log.info("Receive response. respCode="+resp.respCode+
			    		",respMsg="+resp.respMsg);
			    if(resp.respCode!=0){
			    	LogUtil.logError.error("################ createMonTimerTask() failed! Response error: respCode="+resp.respCode+",url="+url);
					//throw new RuntimeException("Call failed!");
	
			    }
			    else
			    {
			    	LogUtil.log.info("================= createMonTimerTask succeed. productApplyId="+productApplyId+",productType="+productType
						+",taskTag="+taskTag);
			    }
			}
		}
		catch(Exception e){
			//!!! 这里应该写故障日志！
			LogUtil.logError.error("################ createMonTimerTask() failed! productApplyId="+productApplyId+",error="+e.getMessage()+"productType="+productType);
		
		}
		
	
		
	}
	/**
	 * 改变服务状态
	 * @author lichenghao
	 * @title :createDoAcceptTimeTask
	 * @Description:TODO
	 * @return void
	 * @date 2016年3月22日 下午2:33:42
	 */
	public void createDoAcceptTimeTask(String productApplyId,Integer productType,int acceptFlag){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("productApplyId", productApplyId);
		param.put("acceptFlag",acceptFlag);
		timerTaskFactoryService.creatDoAcceptTimeTask(productApplyId,JsonUtil.toJson(param));
		if(productType==Constant.Business.PRODUCT_TYPE_INSPECTION_RESULT){
			//匹配检查报告查询服务创建定时器 不生成
			//timerTaskFactoryService.createInspectionReportCheckTimer(productApplyId);
		}
	}
	public void doAcceptTimerTask(ProductServiceApply psa,int acceptFlag, ProductServiceConf conf) {
		// TODO Auto-generated method stub
		// 如果是同意或拒绝了，则取消超时定时器任务（其他动作，不处理）
		if(acceptFlag==2 || acceptFlag==3){
			deleteMonTimerTask(psa.getProductApplyId(),psa.getProductType(),"cancel");
		}
		
		//电话咨询任务比较特殊，需要单独设置
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_TEL)
		{
			if(acceptFlag==2)
				createTelConsultTimerTask(psa.getProductApplyId()); //同意后，创建提醒定时器
			else if(acceptFlag==5){ //成功或失败拨打
				LogUtil.log.info("================= TelConsult service timer handler: acceptFlag=5 and we will delete all the 'cancel' timer. productApplyId="+psa.getProductApplyId()+",buyer="+psa.getBuyer()+",vendor="+psa.getVendor());
				deleteMonTimerTask(psa.getProductApplyId(),psa.getProductType(),null);////最后参数传入null,不能传入"": 删除所有推送提醒
			}
			
		}
		//病案复印邮寄自动确认收件
		else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_MEDICAL_RECORD_MAIL&&acceptFlag==4){
			if(psa.getAuditState()==4){
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("productApplyId", psa.getProductApplyId());
				param.put("acceptFlag",5);
				timerTaskFactoryService.creatDoAcceptTimeTask(psa.getProductApplyId(),JsonUtil.toJson(param),"expire",30*24*60*60*1000L);
			}
		}
		//复查预约到期退款
		else if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_REVIEW_APPOINTMENT&&acceptFlag==2){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("productApplyId", psa.getProductApplyId());
			param.put("acceptFlag",5);
			if(psa.getConsultOrderTime()!=null)
				timerTaskFactoryService.creatDoAcceptTimeTask(psa.getProductApplyId(),JsonUtil.toJson(param),"expire",psa.getConsultOrderTime());
		}
		else
		{	
			if(acceptFlag==2)
			{
				//对于其他类型的产品，如果是包周期计费类型的，则需要生成到期自然终止任务. 传入taskTag=expire
				if(conf.getExpireTime()>0 && conf.getSpecType()==1){
					createMonTimerTask(psa.getProductApplyId(),psa.getProductType(),"expire");
				}
			}
			else if(acceptFlag==8 || acceptFlag==9)
			{
				//对于其他类型的产品，如果是包周期计费类型的，则需要生成到期自然终止任务. 传入taskTag=expire
				if(conf.getExpireTime()>0 && conf.getSpecType()==1){
					LogUtil.log.info("================= The period service timer handler: acceptFlag="+acceptFlag+" and we will delete all the 'expire' timer. productApplyId="+psa.getProductApplyId()+",buyer="+psa.getBuyer()+",vendor="+psa.getVendor());
					deleteMonTimerTask(psa.getProductApplyId(),psa.getProductType(),"expire");//
				}
			}
		
			
		}
		
	}

	private void createTelConsultTimerTask(String productApplyId) {
		try{
			// TODO Auto-generated method stub
			String url = serverUrlRoot+"/timerfactory/telconsult/timer/create?productApplyId="+productApplyId;
			String result = HttpUtil.get(url);
			if(result!=null){
				TMsgResponse resp = JSON.parseObject(result,TMsgResponse.class);
				LogUtil.log.info("================= createTelConsultTimerTask: Receive response. respCode="+resp.respCode+
			    		",respMsg="+resp.respMsg);
			    if(resp.respCode!=0){
			    	LogUtil.logError.error("################ createMonTimerTask() failed! Response error: respCode="+resp.respCode+",url="+url);
					//throw new RuntimeException("Call failed!");
			    }
			    else
					LogUtil.log.info("================= createTelConsultTimerTask succeed. url="+url);
							
			} 
			else
		    	LogUtil.logError.error("################ createMonTimerTask() failed! Response error: result=null"+",url="+url);
		}
		catch(Exception e){
			//!!! 这里应该写故障日志！
			LogUtil.logError.error("################ createTelConsultTimerTask() failed! error="+e.getMessage());
		
		}
	}

	private void deleteMonTimerTask(String productApplyId,int productType,String taskTag) {
		// TODO Auto-generated method stub
		//正常处理之后，要将之前的超时定时器删除，避免误取消业务
		try{
			
			int result = timerTaskService.cancelTimetask(productType,productApplyId,taskTag);
			if(result!=0){
				LogUtil.log.info("################ ERROR!!! cancelTimetask failed. productApplyId="+productApplyId+",productType="+productType
						+",taskTag="+taskTag);
				
				
			}
			else{
				LogUtil.log.info("================= cancelTimetask succeed. productApplyId="+productApplyId+",productType="+productType
						+",taskTag="+taskTag);
			}
		}
		catch(Exception e){
			//!!!如果任务未取消，则一定要写故障记录，通知运营人员处理。并尝试进行重试。
			LogUtil.log.info("################ ERROR!!! cancelTimetask exception. productApplyId="+productApplyId+",productType="+productType
					+",taskTag="+taskTag+",error="+e.getMessage());
			
		}
		
		
	}

	/**
	 * 电话咨询修改时间后，重新生成电话提醒任务
	 * @param psa
	 */
	public void recreateTelConsultAlertTimerTask(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		LogUtil.log.info("================= modify telconsulting time and recreate timer task. productApplyId="+psa.getProductApplyId()+",buyer="+psa.getBuyer()+",vendor="+psa.getVendor());
		deleteMonTimerTask(psa.getProductApplyId(),psa.getProductType(),null);//最后参数传入null,不能传入""。
		createTelConsultTimerTask(psa.getProductApplyId()); 
	}

}
