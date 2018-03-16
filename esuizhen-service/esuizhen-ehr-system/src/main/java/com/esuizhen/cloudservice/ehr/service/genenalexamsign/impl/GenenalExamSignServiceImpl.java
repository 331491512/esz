package com.esuizhen.cloudservice.ehr.service.genenalexamsign.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.GenenalPhysicalExaminationDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.PhysicalSignsResultDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;
import com.esuizhen.cloudservice.ehr.service.genenalexamsign.GenenalExamSignService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.util.GeneralUtil;

@Service
public class GenenalExamSignServiceImpl implements GenenalExamSignService {
	@Autowired
	private GenenalPhysicalExaminationDao genenalPhysicalExaminationDao;
	
	@Autowired
	private PhysicalSignsResultDao physicalSignsResultDao;
	
	
	@Transactional
	@Override
	public void saveGenenalExamSignsInfo(GenenalExamSignsInfo genenalExamSigns) {
		GenenalExaminationInfo genenalExamination=genenalExamSigns.getGenenalExamination();
		List<PhysicalSigns> physicalSignsList=genenalExamSigns.getPhysicalSigns();
		
		//保存常规体检信息
		if(UtilValidate.isNotEmpty(genenalExamination.getIsDelete()) && 1==genenalExamination.getIsDelete()){
			this.genenalPhysicalExaminationDao.deleteGenenalPhysicalExamination(genenalExamination.getPhysicalExaminationResultId());
		}if(UtilValidate.isNotEmpty(genenalExamination.getPhysicalExaminationResultId())){
			this.genenalPhysicalExaminationDao.updateGenenalPhysicalExamination(genenalExamination);
		}else{
			genenalExamination.setPhysicalExaminationResultId(GeneralUtil.generateUniqueID("PER"));
			this.genenalPhysicalExaminationDao.insertGenenalPhysicalExamination(genenalExamination);
		}
		
		//保存体征情况
		if(UtilValidate.isNotEmpty(physicalSignsList)){
			for(PhysicalSigns physicalSigns:physicalSignsList){
				if(UtilValidate.isNotEmpty(physicalSigns.getIsDelete()) && 1==physicalSigns.getIsDelete()){
					this.physicalSignsResultDao.deletePhysicalSigns(physicalSigns.getPhysicalSignsResultId());
				}else if(UtilValidate.isNotEmpty(physicalSigns.getPhysicalSignsResultId())){
					this.physicalSignsResultDao.updatePhysicalSigns(physicalSigns);
				}else{
					physicalSigns.setPhysicalSignsResultId(GeneralUtil.generateUniqueID("PSIGN"));
					this.physicalSignsResultDao.insertPhysicalSigns(physicalSigns);
				}
			}
		}
	}

	@Override
	public GenenalExamSignsInfo queryGenenalExamSignsInfo(AttendPatientReq req) {
		GenenalExamSignsInfo result=new GenenalExamSignsInfo();
		
		GenenalExaminationInfo genenalExamination=this.genenalPhysicalExaminationDao.queryGenenalPhysicalExamination(req);
		List<PhysicalSigns> physicalSigns=this.physicalSignsResultDao.queryPhysicalSigns(req);
		
		result.setGenenalExamination(genenalExamination);
		result.setPhysicalSigns(physicalSigns);
		return result;
	}
}
