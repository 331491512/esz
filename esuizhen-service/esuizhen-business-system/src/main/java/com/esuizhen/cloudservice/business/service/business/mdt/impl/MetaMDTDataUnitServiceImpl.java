package com.esuizhen.cloudservice.business.service.business.mdt.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.business.bean.MetaMDTProductStateListReq;
import com.esuizhen.cloudservice.business.dao.business.mdt.MetaMDTProductDao;
import com.esuizhen.cloudservice.business.service.business.mdt.MetaMDTDataUnitService;

/** 
 * @ClassName: MetaMDTServiceImpl.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Service
public class MetaMDTDataUnitServiceImpl implements MetaMDTDataUnitService{

	@Autowired
	private MetaMDTProductDao metaMDTProductDao;
	
	@Override
	public List<MetaMDTProductStateListReq> getMetaMDTProductStateList(
			Integer mdtRole, Long userId,Integer ruleState,Long mdtFlowStateId) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hm = new HashMap<String, Object>();
		if(mdtRole!=null)hm.put("mdtRole", mdtRole);
		if(userId!=null)hm.put("userId", userId);
		if(ruleState!=null)hm.put("ruleState", ruleState);
		if(mdtFlowStateId!=null)hm.put("mdtFlowStateId", mdtFlowStateId);
		List<MetaMDTProductStateListReq> list = metaMDTProductDao.getMetaMDTProductStateList(hm);
		return list;
	}

}
