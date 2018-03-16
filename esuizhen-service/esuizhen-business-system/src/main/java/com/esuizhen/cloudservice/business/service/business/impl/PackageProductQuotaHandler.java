package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.business.dao.business.ProductApplyDao;
import com.esuizhen.cloudservice.business.model.business.ProductServiceApply;
import com.esuizhen.cloudservice.business.model.business.TProductPackageQuotaUsageInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.ProductService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;

/**
 * 套餐产品配额处理
 * @author DaLoong
 * @date   2016/1/22
 */
@Component
public class PackageProductQuotaHandler {
	private Locale locale=Locale.getDefault();

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ProductApplyDao dao;

	@Autowired 
	private ProductService productService; //交易系统的RMI服务
	
	@Autowired 
	private PushInnerService pushInnerService; //交易系统的RMI服务
	

	public void doPackageProductQuota(TOrderPublishInfo  orderInfo, ProductServiceApply psa,boolean isFromTradeSystem) throws Exception {
		 /* 对于套餐父类产品，例如私人医生，需要设置其图文咨询、电话咨询、预约挂号的配额 */
		
		int packageFlag = getPackageFlag(psa);
		if(isPackageProduct(packageFlag)) //判断是否是套餐
		{
			setPackageProductQuota(psa);
			return;
		}
		/* 对于套餐的子产品，如图文咨询等，则需要修改配额的使用量*/
		if(isFromTradeSystem)
		{
			//如果来自交易系统，则一定是单独付过款的了，则无需检查套餐使用情况。因为肯定不在套餐里。
			LogUtil.log.info("=========isFromTradeSystem is true and we do not check package usage.");
			return;
		}
		if(1==psa.getInPackage()){
			//是套餐内子产品
			//仍然检查是否存在套餐标识
			TProductPackageQuotaUsageInfo packageUsageInfo = getPackageQuotaUsageInfo(psa.getBuyer(),psa.getVendor(),psa.getProductType());
			if(packageUsageInfo==null){
				//无套餐。直接返回
				LogUtil.log.info("=========inPacakge=1 but getPackageQuotaUsage return no package. productType="+psa.getProductType()+",productApplyId="+psa.getProductApplyId());
				return ;
			}
			LogUtil.log.info("=========getPackageQuotaUsage Ok! usageAvailable="+packageUsageInfo.getPackageUsageAvailable()+". productType="+psa.getProductType()+",productApplyId="+psa.getProductApplyId());
			int packageUsageAvailable = packageUsageInfo.getPackageUsageAvailable();
			if(packageUsageAvailable>0) //有套餐余额
			{
				int rt = updatePackageProductQuota(packageUsageInfo.getQuotaUsageId(),psa.getProductType());
				if(rt>0)
					LogUtil.log.info("=========updatePackageProductQuota succeed. quotaUsageId="+packageUsageInfo.getQuotaUsageId()+",before update: quato="+packageUsageInfo.getQuota()
					+",usage="+packageUsageInfo.getUsage()+",usageAvailable="+packageUsageAvailable);
				//此时再更新为套餐的tips
				String quato = "共"+packageUsageInfo.getQuota()+"";
				String usage=(packageUsageInfo.getUsage()+1)+""; //此时要加1.
				if(packageUsageInfo.getQuota()==-1 || packageUsageInfo.getQuota()>100000){
					quato="不限";
				}
				String tips = pushInnerService.getMessage(PushContentUtil
						.getBusinessPushContent("tips.service.applynotify.todoctor.package", new Object[] {
								orderInfo.getOrderTitle(), packageUsageInfo.getParentProductName(), usage, quato })); 
				psa.setTips(tips);
				psa.setQuota(packageUsageInfo.getQuota());
				psa.setUsage(packageUsageInfo.getUsage()+1);//此时加1
				psa.setParentProductName(packageUsageInfo.getParentProductName());
				dao.modifyProductServiceApplyTipsAndQuotaUsage(psa); 
				LogUtil.log.info("=========update PackageProduct tips succeed. tips="+tips);
					
			}
			else if(packageUsageAvailable==0)  //无套餐余额了
			{
				//抛出异常
				LogUtil.logError.error("######## the package service reaches to quota limit. productType="+psa.getProductType());
				throw new Exception("########"
						+ "the package service reaches to quota limit.");
			}	
		}
		else{
			LogUtil.log.info("=========inPackage=0. productType="+psa.getProductType()+",productApplyId="+psa.getProductApplyId());
			
		}
			

		
	}
	
	//
	//退还产品配额。取消套餐内产品时调用
	//
	public boolean giveBackPackageProductQuota(long quotaUsageId, Integer productType){
		int result = dao.giveBackPackageProductQuota(quotaUsageId,productType);
		
		if(result==1){
			LogUtil.log.info("=========Ok! giveBackPackageProductQuota succeed. quotaUsageId="+quotaUsageId+",productType="+productType);
			return true;
		}
		else
		{
			//!!这里应该写故障数据库日志
			LogUtil.log.info("######## ERROR!! giveBackPackageProductQuota failed. quotaUsageId="+quotaUsageId+",productType="+productType);
			return true;

		}
	}

	//
	//更新产品配额使用。增1. 创建产品申请(productApply)时调用
	//return: 1: 更新成功
	private int updatePackageProductQuota(long quotaUsageId, Integer productType) {
		// TODO Auto-generated method stub
		return dao.updatePackageProductQuota(quotaUsageId,productType);
	}

	/**
	 * 返回套餐信息
	 * @param psa
	 * @return
	 */
	public TProductPackageQuotaUsageInfo getPackageQuotaUsageInfo(Long buyer,Long vendor,int productType) {
		// TODO Auto-generated method stub
		List<TProductPackageQuotaUsageInfo> list = dao.getProductPackageUsage(buyer,vendor,productType);
		if(null!=list){
			if(list.size()==0) return null;
			if(list.size()==1) {
				TProductPackageQuotaUsageInfo packageUsageInfo = list.get(0);
				LogUtil.log.info("=========getPackageQuotaUsageInfo Ok! return 1. "+list.size()+",productType="+productType+",buyer="+buyer+",vendor="+vendor
						+"quato="+packageUsageInfo.getQuota()
						+",usage="+packageUsageInfo.getUsage()+",usageAvailable="+packageUsageInfo.getPackageUsageAvailable());
				
				return packageUsageInfo; 
			}
			//如果返回多个，则取余额非0的第一个。
			for(TProductPackageQuotaUsageInfo packageUsageInfo:list){
				if(packageUsageInfo.getPackageUsageAvailable()>0){
					
					LogUtil.log.info("=========getPackageQuotaUsageInfo multirecords Ok! return the first. size= "+list.size()+",productType="+productType+",buyer="+buyer+",vendor="+vendor
							+"quato="+packageUsageInfo.getQuota()
							+",usage="+packageUsageInfo.getUsage()+",usageAvailable="+packageUsageInfo.getPackageUsageAvailable());
					
			
					return packageUsageInfo;
				}
			}
			
			return list.get(0); //如果都是0，则取第一个
		}
		LogUtil.log.info("=========getPackageQuotaUsageInfo null. productType="+productType+",buyer="+buyer+",vendor="+vendor);
		return null;
	
	}

	


	private void setPackageProductQuota(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		//创建套餐配额
		LogUtil.log.info("It is package parent product and we set product package quota: productType="+psa.getProductType()+",productApplyId="+psa.getProductApplyId());
		dao.setPackageProductQuota(psa);
		LogUtil.log.info("Ok! set product package quota succeed.productApplyId="+psa.getProductApplyId());
		
	}

	private int getPackageFlag(ProductServiceApply psa) {
		// TODO Auto-generated method stub
		switch(psa.getProductType())
		{
			case Constant.Business.PRODUCT_TYPE_PRIVATE_DOCTOR:
				
				return Constant.Business.PRODUCT_PACKAGE_PARENT;
		
			case Constant.Business.PRODUCT_TYPE_CLINIC:
				return Constant.Business.PRODUCT_PACKAGE_CHILD;
			
			case Constant.Business.PRODUCT_TYPE_RICHTEXT:
			
			case Constant.Business.PRODUCT_TYPE_TEL:
			
			case Constant.Business.PRODUCT_TYPE_MDT:
				return Constant.Business.PRODUCT_PACKAGE_NO;
			
			default:
				
				return productService.getProductPackageFlag(psa.getProductType());
		
		}
		
	}

	private boolean isPackageProduct(int packageFlag) {
		// TODO Auto-generated method stub
		//调用交易系统服务获得产品的套餐标识
		if(Constant.Business.PRODUCT_PACKAGE_PARENT==packageFlag)
			return true;
		else
			return false;
			
	}

}
