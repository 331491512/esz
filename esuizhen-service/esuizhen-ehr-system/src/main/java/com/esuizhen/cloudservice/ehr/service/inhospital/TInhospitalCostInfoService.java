package com.esuizhen.cloudservice.ehr.service.inhospital;

import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;


public interface TInhospitalCostInfoService{
	
	TInhospitalCostInfo queryEiInhospitalCostByInhospitalId(String eiInhospitalCostId);
	
	int updateEiInhospitalCost(TInhospitalDetailInfo inhospitalInfo,TInhospitalCostInfo eiInhospitalCost);
}
