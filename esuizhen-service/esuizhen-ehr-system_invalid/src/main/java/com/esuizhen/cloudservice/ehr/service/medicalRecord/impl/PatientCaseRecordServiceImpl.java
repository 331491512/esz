package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.AdverseReactionResultDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.GenenalPhysicalExaminationDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.PhysicalSignsResultDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.QualityoflifeInfoDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PatientCaseRecordService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.util.GeneralUtil;

@Service
public class PatientCaseRecordServiceImpl implements PatientCaseRecordService {

	@Autowired
	private GenenalPhysicalExaminationDao genenalPhysicalExaminationDao;
	
	@Autowired
	private PhysicalSignsResultDao physicalSignsResultDao;
	
	@Autowired
	private QualityoflifeInfoDao qualityoflifeInfoDao;
	
	@Autowired
	private AdverseReactionResultDao adverseReactionResultDao;
	
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

	@Override
	public void saveQualityoflifeInfo(QualityoflifeInfo qualityoflifeInfo) {
		if(UtilValidate.isNotEmpty(qualityoflifeInfo.getIsDelete()) && 1==qualityoflifeInfo.getIsDelete()){
			this.qualityoflifeInfoDao.deleteQualityoflifeInfo(qualityoflifeInfo.getQolId());
		}else if(UtilValidate.isNotEmpty(qualityoflifeInfo.getQolId())){
			this.qualityoflifeInfoDao.updateQualityoflifeInfo(qualityoflifeInfo);
		}else{
			if(UtilValidate.isEmpty(qualityoflifeInfo.getEmrId())){
				qualityoflifeInfo.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
			}
			qualityoflifeInfo.setQolId(GeneralUtil.generateUniqueID("EQOL"));
			this.qualityoflifeInfoDao.insertQualityoflifeInfo(qualityoflifeInfo);
		}

	}

	@Override
	public QualityoflifeInfo queryQualityoflifeInfo(AttendPatientReq req) {
		QualityoflifeInfo result=this.qualityoflifeInfoDao.queryQualityoflifeInfo(req);
		return result;
	}

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
