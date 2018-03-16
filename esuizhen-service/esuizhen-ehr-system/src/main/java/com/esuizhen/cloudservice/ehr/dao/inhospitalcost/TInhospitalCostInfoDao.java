package com.esuizhen.cloudservice.ehr.dao.inhospitalcost;

import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;


public interface TInhospitalCostInfoDao{
	/**
	 * 添加费用信息
	 * @param eiInhospitalCost
	 * @return
	 */
	int insertEiInhospitalCost(TInhospitalCostInfo eiInhospitalCost);
	
	public int updateEiInhospitalCost(TInhospitalCostInfo eiInhospitalCost);
	
	public int deleteEiInhospitalCost(String inhospitalId);
	
	public TInhospitalCostInfo queryEiInhospitalCost(Long eiInhospitalCostId);
	
	TInhospitalCostInfo queryEiInhospitalCostByInhospitalId(String eiInhospitalCostId);
}
