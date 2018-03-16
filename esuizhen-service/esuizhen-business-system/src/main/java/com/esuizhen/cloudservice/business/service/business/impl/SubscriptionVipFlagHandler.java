package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.business.bean.TProductSubscriptionInfo;
import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.dao.business.UserDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.ProductServiceConf;
import com.esuizhen.cloudservice.business.util.BusinessUtil;
import com.westangel.common.bean.user.ServiceSubscriptionInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.LogUtil;

/**
 * 订购关系和vip标识设置
 * 设置到var_patient_business动态信息表中
 * @author DaLoong 
 * @date   2016/1/28
 *
 */
@Component
public class SubscriptionVipFlagHandler {
	@Autowired
	private ProductApplyDao dao;

	@Autowired 
	private UserDao       userDao;

	
	
	public void setVipFlag(ProductServiceApply psa) {
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR)
		{
			try{
				switch(psa.getState()){
				case 2: //设置VIP标识
					setVipFlagTrue(psa);
					break;
					
				case 3://取消
					setVipFlagFalse(psa);
					//再检查和设置一下订购关系
					setSubscriptionFlag(psa);
					break;
				case 5://到期
				case 6:
				case 7:
					setVipFlagExpire(psa);
					//再检查和设置一下订购关系
					setSubscriptionFlag(psa);
					break;
				default:
					LogUtil.logError.error(Constant.LOGTAG.ERR+"setVipFlag failed! unknown state="+psa.getState());
				}
				
			}
			catch(Exception e){
				LogUtil.logError.error(Constant.LOGTAG.ERR+"Update vipFlag failed! err="+e.getMessage());
					
			}
			
		}
		
	}

	
	
	public void setSubscriptionFlag(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		if(!BusinessUtil.isVipSubscriptionFlag(psa.getProductType()))
			return;
		LogUtil.log.info(Constant.LOGTAG.INF+"Begin to setSubscriptionFlag... ");
		TProductSubscriptionInfo resultInfo = new TProductSubscriptionInfo();
		resultInfo.setState(-1);
		try{
			resultInfo = dao.getProductSubcriptionInService(psa.getBuyer(),psa.getVendor(),psa.getProductType(),null);
			if(resultInfo==null){
				resultInfo = new TProductSubscriptionInfo();
				resultInfo.setState(-1);
				
			}
			else
			{
				if(BusinessUtil.isSubscriptionValid(resultInfo.getState()))
						resultInfo.setState(1); //医生已同意
				else if(BusinessUtil.isSubscriptionWaitConfirm(resultInfo.getState()))
					resultInfo.setState(0); //等待医生确认
				else
					resultInfo.setState(-1);
			}
			
			ServiceSubscriptionInfo info = new ServiceSubscriptionInfo();
			info.setDoctorId(userDao.getDoctorId(psa.getVendor()));
			info.setPatientId(userDao.getPatientId(psa.getBuyer()));
			info.setSubscriptionFlag(resultInfo.getState());
			int rt = dao.updateSubscriptionFlag(info);
			if(rt==0){
				//没有更新到记录, 则插入一条
				 dao.insertSubscriptionFlag(info);
				 LogUtil.log.info(Constant.LOGTAG.OK+"Insert subscriptionFlag succeed.");
			}
			else{
				LogUtil.log.info(Constant.LOGTAG.OK+"Update subscriptionFlag succeed.");
			}
		}
		catch(Exception e){
			LogUtil.logError.error(Constant.LOGTAG.ERR+"Update subscriptionFlag failed!  err="+e.getMessage());
			
		}
	}
	
	
	private void doSetVipFlag(ProductServiceApply psa,int vipFlag){
	    // 为私人医生服务，设置VIP标识
		LogUtil.log.info(Constant.LOGTAG.INF+"Set vipFlag for patient userId="+psa.getBuyer()+",doctor userId="+psa.getVendor());
		Long doctorId = userDao.getDoctorId(psa.getVendor());
		Long patientId = userDao.getPatientId(psa.getBuyer());
		ServiceSubscriptionInfo info = dao.queryServiceSubscriptionInfo(doctorId,patientId);
		boolean isExist = true;
		if(info==null)
		{
			isExist = false;
			info = new ServiceSubscriptionInfo();
			info.setDoctorId(doctorId);
			info.setPatientId(patientId);
			info.setSubscriptionFlag(-1);
			info.setVipFlag(0);
		}
		ProductServiceConf conf = dao.getProductServiceConfById(psa.getProductId());
		if(conf==null){
			LogUtil.logError.error(Constant.LOGTAG.ERR+"setVipFlag() failed: getProductServiceConfById error: ProductServiceConf not found. productApplyId="+psa.getProductApplyId()+
					",productId="+psa.getProductId()+",productType="+psa.getProductType()); 
			return;

		}
		info.setPeriodFeeType(conf.getPeriodFeeType());
		if(vipFlag==1){
			info.setSubscriptionFlag(1);
			info.setVipFlag(1);
			info.setVipBeginTime(new Date());
			if(info.getPeriodFeeType()==2){//包月
				info.setVipEndTime(DateUtil.getOffsetDate(30));
			}
			else if(info.getPeriodFeeType()==3){//包年
				info.setVipEndTime(DateUtil.getOffsetDate(365));
			}
			else
				info.setVipEndTime(DateUtil.getOffsetDate(1));
			info.setVipProductName(psa.getOrderTitle());
		}
		else{
			if(info.getVipFlag()==1)//已经订购过
				info.setVipFlag(2);
			else
				info.setVipFlag(vipFlag);
			
		}
				
		if(isExist==true)
		{
			int rt = dao.updateVipFlag(info);
			if(rt==0){
				//没有更新到记录
				LogUtil.log.error(Constant.LOGTAG.ERR+"Update vipFlag failed! patientId="+patientId+",doctorId="+doctorId+",vipFlag="+info.getVipFlag());
				
			}
			else{
				LogUtil.log.info(Constant.LOGTAG.OK+"Update vipFlag succeed.");
			}
		}
		else{
			dao.insertVipFlag(info);
			LogUtil.log.info(Constant.LOGTAG.OK+"Insert vipFlag succeed.");
		}
	}

	private void setVipFlagTrue(ProductServiceApply psa){
	   doSetVipFlag(psa,1);
	}
	
	private void setVipFlagFalse(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		   doSetVipFlag(psa,0);
			
	}
	
	private void setVipFlagExpire(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		   doSetVipFlag(psa,2);
			
	}



	public void setAgentApplyFlag(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		if(psa.getProductType()==Constant.Business.PRODUCT_TYPE_MONITOR_ILLNESS
				||psa.getProductType()==Constant.Business.PRODUCT_TYPE_CONVENIENT
				||psa.getProductType()==Constant.Business.PRODUCT_TYPE_FOLLOWUP_BUSINESS)
			return;
		LogUtil.log.info(Constant.LOGTAG.INF+"Begin to agentApplyFlag... ");
		try{
			
			ServiceSubscriptionInfo info = new ServiceSubscriptionInfo();
			info.setDoctorId(userDao.getDoctorId(psa.getVendor()));
			info.setPatientId(userDao.getPatientId(psa.getBuyer()));
			//根据服务状态来判断订购关系
			if(psa.getSubscriptionFlag()!=-1){
				info.setSubscriptionFlag(1);
			}else{
				info.setSubscriptionFlag(-1);
			}
			int rt = dao.updateAgentApplyFlag(info);
			if(rt==0){
				//没有更新到记录, 则插入一条
				 dao.insertAgentApplyFlag(info);
				 LogUtil.log.info(Constant.LOGTAG.OK+"Insert agentApplyFlag succeed.");
			}
			else{
				LogUtil.log.info(Constant.LOGTAG.OK+"Update agentApplyFlag succeed.");
			}
		}
		catch(Exception e){
			LogUtil.logError.error(Constant.LOGTAG.ERR+"Update agentApplyFlag failed!  err="+e.getMessage());
			
		}
	}
}
