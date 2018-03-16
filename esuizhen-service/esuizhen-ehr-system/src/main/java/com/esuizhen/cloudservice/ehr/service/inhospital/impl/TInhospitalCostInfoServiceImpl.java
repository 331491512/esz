package com.esuizhen.cloudservice.ehr.service.inhospital.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.esuizhen.cloudservice.ehr.dao.inhospitalcost.TInhospitalCostInfoDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;
import com.esuizhen.cloudservice.ehr.service.inhospital.TInhospitalCostInfoService;

@Service("inhospitalCostInfoService")
public class TInhospitalCostInfoServiceImpl implements
		TInhospitalCostInfoService {
	
	@Autowired
	private TInhospitalCostInfoDao inhospitalCostInfoDao;
	
	@Autowired
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;
	
	public int updateEiInhospitalCost(TInhospitalDetailInfo inhospitalInfo,TInhospitalCostInfo eiInhospitalCost) {
		int res = 0;
		if(eiInhospitalCost != null) {
			TInhospitalDetailInfo inhospitalDetail = inhospitalDetailInfoDao.queryInhospitalDetailByInhospitalId(eiInhospitalCost.getInhospitalId());
			if(inhospitalDetail != null) {
				eiInhospitalCost.setPatientid(inhospitalDetail.getPatientId());
				if(eiInhospitalCost.getCostId() == null) {
					res = inhospitalCostInfoDao.insertEiInhospitalCost(eiInhospitalCost);
				}else {
					res = inhospitalCostInfoDao.updateEiInhospitalCost(eiInhospitalCost);
				}
			}
		}
		return res;
	}
	
	public TInhospitalCostInfo queryEiInhospitalCostByInhospitalId(String eiInhospitalCostId) {
		return inhospitalCostInfoDao.queryEiInhospitalCostByInhospitalId(eiInhospitalCostId);
	}
}
