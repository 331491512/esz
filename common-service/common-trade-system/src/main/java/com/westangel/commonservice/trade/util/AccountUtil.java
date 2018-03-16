/**
 * 
 */
package com.westangel.commonservice.trade.util;

import com.westangel.common.util.GeneralUtil;
import com.westangel.commonservice.trade.model.account.TAccountPublishInfo;

/**
 * @author bigdragon
 * @date  2016-1-5 下午7:24:26
 */
public final class AccountUtil {

	public static String getRoleName(int role){
		
		switch(role){
			case 1: return "patient";
			case 2: return "doctor";
			case 0: return "esuizhen";
			default:
				return "unknown";
		}
	}
	
	public static String getAccountName(int role,int accountClass){
		
		switch(role){
			case 1: 
				if(accountClass==1)
					return "患者易随诊主账户";
				else if(accountClass==2)
					return "患者易随诊支出账户";
				else if(accountClass==4)
					return "患者抵扣券账户";
				break;
			case 2: 
				if(accountClass==1)
					return "医生易随诊主账户";
				else if(accountClass==3)
					return "医生易随诊提现账户";
				else if(accountClass==4)
					return "医生易随诊抵扣券账户";
				break;
		
			case 0: 
				if(accountClass==4)
					return "易随诊平台抵扣券账户";
				return "易随诊平台主账户";
			
			default:
				return "未知账户";
		}
		return "未知账户";
	}

	/**
	 * @param userId
	 * @param role
	 * @param accountClass
	 * @return
	 */
	public static TAccountPublishInfo getAccountPublishInfo(Long userId, int role, int accountClass) {
		// TODO Auto-generated method stub
		TAccountPublishInfo info = new TAccountPublishInfo();
		info.setAccountId(userId);//目前accountId和userId设置成相同
		info.setUserId(userId);
		info.setRole(role);
		info.setAccountClass(accountClass);
		info.setRoleName(getRoleName(role));
		info.setAccountName(getAccountName(role,accountClass));
		info.setAccountNo(GeneralUtil.generatorUUID(12));
		
		return info;
	}
}
