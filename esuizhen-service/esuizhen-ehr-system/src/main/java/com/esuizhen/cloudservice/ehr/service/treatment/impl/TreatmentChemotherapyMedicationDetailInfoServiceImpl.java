package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.List;  
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoDosageUnitDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.TreatmentChemotherapyMedicationDetailInfoDao;
import com.esuizhen.cloudservice.ehr.model.meta.MetaInfoDosageUnit;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationDetailInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentChemotherapyMedicationDetailInfoService;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.util.GeneralUtil;

@Service
public class TreatmentChemotherapyMedicationDetailInfoServiceImpl extends CommonServiceImpl<TreatmentChemotherapyMedicationDetailInfo> implements
		TreatmentChemotherapyMedicationDetailInfoService {
	@Autowired
	private TreatmentChemotherapyMedicationDetailInfoDao chemotherapyMedicationDetailInfoDao;
	
	@Autowired
	private MetaInfoDosageUnitDao metaInfoDosageUnitDao;
	
	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;
	
	@Override
	public CommonDao<TreatmentChemotherapyMedicationDetailInfo> getCommonDao() {
		return chemotherapyMedicationDetailInfoDao;
	}

	@Override
	public int saveTreatmentChemotherapyMedicationDetailInfo(TreatmentChemotherapyMedicationInfo chemotherapyMedicationInfo) {
		Long operatorId = chemotherapyMedicationInfo.getOperatorId();
		Integer treatmentSchemeId=null;
		int res = 0;
		List<TreatmentChemotherapyMedicationDetailInfo> chemotherapyMedicationDetailInfos = chemotherapyMedicationInfo.getChemotherapyMedicationDetailInfos();
		if(chemotherapyMedicationDetailInfos != null && chemotherapyMedicationDetailInfos.size() > 0) {
			for(TreatmentChemotherapyMedicationDetailInfo chemotherapyMedicationDetailInfo :chemotherapyMedicationDetailInfos) {
				String measurementUnitName = chemotherapyMedicationDetailInfo.getMeasurementUnitName();
				if("1".equals(chemotherapyMedicationDetailInfo.getConcatFlag())){	
						//add by fanpanwei更新单位类型元数据信息
						UserDefinedMetaData metaData=new UserDefinedMetaData();
						if(org.apache.commons.lang.StringUtils.isNotBlank(chemotherapyMedicationDetailInfo.getMeasurementUnitName())){
							metaData.setCreator(operatorId);
							metaData.setMetaName(chemotherapyMedicationDetailInfo.getMeasurementUnitName());
							
							metaData.setMetaDataTable("ehr_db.meta_info_dosage_unit");
							metaData.setMainKeyField("id");
							metaData.setMetaNameField("name");
							this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
						}
						//add by fanpanwei更新 治疗药物类型元数据信息
						if(org.apache.commons.lang.StringUtils.isNotBlank(chemotherapyMedicationDetailInfo.getMedicationName())){
							metaData=new UserDefinedMetaData();
							metaData.setCreator(operatorId);
							metaData.setMetaName(chemotherapyMedicationDetailInfo.getMedicationName());
							metaData.setParentKey(chemotherapyMedicationDetailInfo.getMedicationType()!=null?chemotherapyMedicationDetailInfo.getMedicationType().toString():"0");
							
							metaData.setMetaDataTable("ehr_db.meta_e_medication");
							metaData.setMainKeyField("medicationId");
							metaData.setMetaNameField("medicationName");
							metaData.setParentKeyField("medicationType");
							metaData.setQueryCondition(" AND medicationType='"+chemotherapyMedicationDetailInfo.getMedicationType()+"'");
							int medicationId = this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
							
							if(treatmentSchemeId==null){
								treatmentSchemeId=chemotherapyMedicationDetailInfo.getTreatmentSchemeId();
								if(treatmentSchemeId==null&&org.apache.commons.lang.StringUtils.isNotBlank(chemotherapyMedicationDetailInfo.getTreatmentName())){
									metaData=new UserDefinedMetaData();
									metaData.setCreator(operatorId);
									metaData.setMetaName(chemotherapyMedicationDetailInfo.getTreatmentName());
									metaData.setParentKey(chemotherapyMedicationDetailInfo.getTreatmentTypeId().toString());
									
									
									metaData.setMetaDataTable("ehr_db.meta_e_treatment_scheme");
									metaData.setMainKeyField("treatmentSchemeId");
									metaData.setMetaNameField("treatmentSchemeName");
									metaData.setParentKeyField("treatmentTypeId");
									metaData.setQueryCondition(" AND treatmentTypeId='"+chemotherapyMedicationDetailInfo.getTreatmentTypeId()+"'");
									treatmentSchemeId = this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
								}
							}
							if(treatmentSchemeId!=null){
								//添加方案药物关联表元数据
								metaData=new UserDefinedMetaData();
								metaData.setCreator(operatorId);
								metaData.setMainKeyCode(treatmentSchemeId.toString());
								metaData.setMetaName(chemotherapyMedicationDetailInfo.getMedicationName());
								metaData.setFlagKey(medicationId);
								//metaData.setParentKey(chemotherapyMedicationDetailInfo.getMedicationType()!=null?chemotherapyMedicationDetailInfo.getMedicationType().toString():"0");
								
								metaData.setMetaDataTable("ehr_db.meta_e_treatment_scheme_item_medication");
								metaData.setMainKeyField("treatmentItemId");
								metaData.setMainKeyCodeField("treatmentSchemeId");
								metaData.setMetaNameField("medicationName");
								metaData.setFlagKeyField("medicationId");
								/*metaData.setParentKeyField("medicationType");*/
								metaData.setQueryCondition(" AND treatmentSchemeId='"+treatmentSchemeId+"'");
								this.metaDataUserDefinedService.addMetaDateInIntKey(metaData);
							}
						}
					}
					//更新业务数据
					Integer id = 0;
					if(!StringUtils.isEmpty(measurementUnitName)){
						id = metaInfoDosageUnitDao.selectMetaInfoDosageUnitByName(measurementUnitName);
						if(!(id != null && id > 0)){
							MetaInfoDosageUnit unit = new MetaInfoDosageUnit();
							unit.setName(measurementUnitName);
							Integer flag = metaInfoDosageUnitDao.insertSelective(unit);
							if(flag > 0 )id = unit.getId();
						}
						chemotherapyMedicationDetailInfo.setMeasurementUnit(String.valueOf(id));
					}
				chemotherapyMedicationDetailInfo.setTreatmentId(chemotherapyMedicationInfo.getTreatmentId());
				chemotherapyMedicationDetailInfo.setChemotherapyMedicationRecordId(chemotherapyMedicationInfo.getChemotherapyMedicationRecordId());
				chemotherapyMedicationDetailInfo.setPatientId(chemotherapyMedicationInfo.getPatientId());
				chemotherapyMedicationDetailInfo.setInhospitalId(chemotherapyMedicationInfo.getInhospitalId());
				chemotherapyMedicationDetailInfo.setClinicMedicalId(chemotherapyMedicationInfo.getClinicMedicalId());
				if(chemotherapyMedicationDetailInfo.getChemotherapyMedicationDetailId() == null) {
					chemotherapyMedicationDetailInfo.setChemotherapyMedicationDetailId(GeneralUtil.generatorUUID("CHMD"));
					res += super.save(chemotherapyMedicationDetailInfo);
				}else {
					res += super.update(chemotherapyMedicationDetailInfo);
				}
			}
		}
		return res;
	}

	@Override
	public void deleteTreatmentChemotherapyMedicationDetailInfo(Map<String,Object> paramsMap) {
		chemotherapyMedicationDetailInfoDao.deleteTreatmentChemotherapyMedicationDetailInfo(paramsMap);
	}
	
}
