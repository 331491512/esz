package com.esuizhen.cloudservice.business.service.business.mdt;

import java.util.List;

import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;



/** 
 * @ClassName: MetaMDTService.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
public interface MetaMDTDataUnitService {
	
	public List<MetaMDTProductStateListReq> getMetaMDTProductStateList (Integer mdtRole, Long userId,Integer ruleState,Long mdtFlowStateId); 
}
