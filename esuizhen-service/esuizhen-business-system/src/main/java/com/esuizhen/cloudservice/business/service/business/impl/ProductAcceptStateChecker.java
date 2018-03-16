package com.esuizhen.cloudservice.business.service.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.westangel.common.util.LogUtil;

/**
 * 产品服务处理状态检查器
 * 一个单例对象(singleton)。
 * 当需要执行某项处理动作时，需要检查其当前状态是否允许执行此动作。
 * 例如，“同意”动作(对应acceptFlag=2)，需要在付款完成之后才会被允许（对应state=1)
 * @author Daloong
 * @date   2016/1/23
 *
 */

public class ProductAcceptStateChecker {
	/*状态：状态。
	0: 未支付
	1：已支付、待医生确认
	2: 医生已接受
	3： 医生已拒绝
	4： 服务进行中
	5： 服务已完成（已关闭）
	6： 服务过期（系统取消）
	7： 服务取消（患者取消）
	8: 患者关闭
	9: 医生关闭
	10：患者未接听
	11: 30分钟仍未拨打或失败
    */
	//维护一个状态允许检查表：即对于某个acceptFlag(动作或状态的改变），其满足的前置state的列表。如果state落在这个列表范围内，则允许，否则拒绝。
	private Map<String,Integer[]> checkTable;
	
	private static  ProductAcceptStateChecker _instance = null;
	
	public  static ProductAcceptStateChecker instance(){
		if(null==_instance)
			_instance = new ProductAcceptStateChecker();
		return _instance;
	}
	
	public  ProductAcceptStateChecker(){
		//初始化checkTable
		checkTable = new HashMap<String,Integer[]>();
		//key:某个当前需要改变的状态（用acceptFlag表示）；value: 满足的前置状态列表；state需要落在这个列表范围中。
		checkTable.put("0", null);
		checkTable.put("1", new Integer[]{0,1});
		checkTable.put("2", new Integer[]{1});//acceptFlag=2:同意。其前置状态必须是1（已支付）
		checkTable.put("3", new Integer[]{1});//acceptFlag=3:拒绝。其前置状态必须是1（已支付）
		checkTable.put("4", new Integer[]{2,4});//acceptFlag=4:服务处理中。其前置状态必须是2（已同意）
		checkTable.put("5", new Integer[]{2,4,10}); //acceptFlag=5:服务自然关闭（成功处理，如拨打电话成功）。前置状态必须是2（已同意）\4(服务处理中）
		checkTable.put("6",new Integer[]{1}); //acceptFlag=6. 系统24小时超时取消。其前置状态必须是1（已支付但未处理）。一旦被处理，则不允许取消。
		checkTable.put("7",new Integer[]{-1});//acceptFlag=7。 客服强制取消。任何状态都允许执行。当正常处理无效或者退款失败时，可以使用强制取消来强制退款。
		checkTable.put("8", new Integer[]{2,4});//acceptFlag=8. 患者关闭（对图文咨询有效）
		checkTable.put("9", new Integer[]{2,4});//acceptFlag=9. 医生总结关闭（对图文咨询有效）
		checkTable.put("10", new Integer[]{2,4}); //acceptFlag=10。患者未接电话
		checkTable.put("11", new Integer[]{2,4,10}); //acceptFlag=11。延误30分钟未拨打电话。
	    //3、6、7、11必然导致退款动作。
		
		
	}
	
	public boolean checkCancelState(int state,int isRefund){
		if(isRefund==1){//完成退款
			switch(state)
			{
				case 5:
				case 8:
				case 9:
					return true;
			}
		}
		switch(state)
		{
			case 3:
			case 6:
			case 7:
			case 11:
				return true;
			 default:
				return false;
		
		}
		
	}
	public  boolean acceptStateCheck(int acceptFlag,int state){
		if(checkTable==null) {
			LogUtil.logError.error("################ ERROR in acceptStateCheck: checkTable not init.");
			return false;
		}
		
		Integer stateList[] = checkTable.get(acceptFlag+"");
		if(stateList==null){
			LogUtil.logError.error("################ ERROR in acceptStateCheck: key not found: "+acceptFlag);
			return false;
		}
		if(stateList.length<=0){
			LogUtil.logError.error("################ ERROR in acceptStateCheck: value null: "+acceptFlag);
			return false;
		}
		for(int i=0;i<stateList.length;i++){
			if(stateList[i]==state){
				LogUtil.log.info("==========acceptStateCheck succeed. acceptFlag="+acceptFlag+",preState="+state);
				return true;
			}
			if(stateList[i]==-1){
				LogUtil.log.info("==========acceptStateCheck succeed. acceptFlag="+acceptFlag+",preState=-1,state="+state);
				return true;
			}
		}
		LogUtil.logError.error("################ acceptStateCheck faile!  acceptFlag="+acceptFlag+",state="+state);

		return false;
	}
}
