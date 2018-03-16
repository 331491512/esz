package com.esuizhen.cloudservice.ehr.service.adversereaction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.AdverseReactionResultDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.service.adversereaction.AdverseReactionService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.util.GeneralUtil;

@Service
public class AdverseReactionServiceImpl implements AdverseReactionService{
	@Autowired
	private AdverseReactionResultDao adverseReactionResultDao;
	
	@Transactional
	@Override
	public void saveAdverseReactionResult(List<AdverseReactionResultInfo> infoList) {
		if(UtilValidate.isNotEmpty(infoList)){
			for(AdverseReactionResultInfo info:infoList){
				if(UtilValidate.isNotEmpty(info.getIsDelete()) && 1==info.getIsDelete()){
					this.adverseReactionResultDao.deleteAdverseReactionResultInfo(info.getAdverseReactionRecordId());
				}else if(UtilValidate.isNotEmpty(info.getAdverseReactionRecordId())){
					this.adverseReactionResultDao.updateAdverseReactionResultInfo(info);
				}else{
					info.setAdverseReactionRecordId(GeneralUtil.generateUniqueID("EARR"));
					this.adverseReactionResultDao.insertAdverseReactionResultInfo(info);
				}
			}
		}
	}

	@Override
	public List<AdverseReactionResultInfo> queryAdverseReactionResult(AttendPatientReq req) {
		List<AdverseReactionResultInfo> infoList=this.adverseReactionResultDao.queryAdverseReactionResult(req);
		return infoList;
	}

}
