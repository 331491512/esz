/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.service.patient.impl;<br/>  
 * <b>文件名：</b>PatientServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:48:44<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.service.patient.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.PatientSymptomInfo;
import com.esuizhen.cloudservice.ehr.bean.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.bean.TOutHospitalInfo;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.patient.DiagnosisDao;
import com.esuizhen.cloudservice.ehr.dao.patient.InHospitalDao;
import com.esuizhen.cloudservice.ehr.dao.patient.PatientSymptomDao;
import com.esuizhen.cloudservice.ehr.dao.patient.TreatmentNoteDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.esuizhen.cloudservice.ehr.service.patient.PatientService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.bean.UserDefinedMetaData;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.DiagInnerService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: PatientServiceImpl
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午11:48:44  
*/
@Service
public class PatientServiceImpl implements PatientService,DiagInnerService {
	
	@Autowired
	private InHospitalDao inhospitalDao;
	@Autowired
	private DiagnosisDao diagnosisDao;
	@Autowired
	private TreatmentNoteDao treatmentNoteDao;
	@Autowired
	private EmedicalRecordDao emrDao;
	@Autowired
	private MetaDataService metaDataService;
	

	@Autowired
	private PatientSymptomDao patientSymptomDao;
	//患者入院信息
	@Override
	public Page<TInhospitalInfo> getPatienInhospitalList(PatientInHospitalNoteListReq req) {
		// TODO Auto-generated method stub
		if(req==null||req.getPatientId()==null)
			throw new EmptyObjectExcption("patientId is null");
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<TInhospitalInfo> list =inhospitalDao.queryPatientInhospitalInfoByPatientId(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TInhospitalInfo>)list);
	}
	
	@Override
	public List<TOutHospitalInfo> getOutHospitalDateList(Long patientId, Integer hospitalId)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		if(patientId==null)
			throw new EmptyObjectExcption(" patientId is empty");
		if(hospitalId==null)
			throw new EmptyObjectExcption(" hospitalId is empty");
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("patientId", patientId);
		param.put("hospitalId", hospitalId);
		return inhospitalDao.queryPatientOutHospitalDate(param);
	}
	
	//获取诊断
	@Override
	public Page<TDiagnosisInfo> getPatientDiagnosisList(PatientDiagnosisListReq req) {
		// TODO Auto-generated method stub
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		//诊断状态  默认为0
		if(req.getDiagnosisTypeId()==null)
			req.setDiagnosisTypeId(0);
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<TDiagnosisInfo> list =diagnosisDao.queryPatientDiagnosis(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TDiagnosisInfo>)list);
	}
	
	//创建诊断
	@Override
	@Transactional
	public void createPatientDiagnosis(PatientDiagnosisReq req) {
		// TODO Auto-generated method stub
		if(req.getSourceFlag()==null)
			throw new EmptyParamExcption("sourceFlag is null");
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		if(req.getCreatorId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getDiagnosisTypeId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getVisitTime()==null)
			throw new EmptyParamExcption("visitTime is null");
		if(req.getDiagnosisTypeId()==1){
			if(req.getDiseaseCode()==null||req.getDiseaseTypeId()==null)
				throw new EmptyParamExcption("param is error   param："+JsonUtil.toJson(req));
			//if(req.getSourceFlag()==2&&req.getDisagnosisPeriodizationId()==null)
			//	throw new EmptyParamExcption("param is error  disagnosisPeriodizationId is null");
			//主要诊断为原发诊断
			//req.setIsSourceDiagnosis(1);
		}else if(req.getDiagnosisTypeId()==2){
			if(StringUtils.isEmpty(req.getDiagnosis()))
				throw new EmptyParamExcption("param is error   param："+JsonUtil.toJson(req));
		}else if(req.getDiagnosisTypeId()==9){
			if(StringUtils.isEmpty(req.getPathologyDiagnosis()))
				throw new EmptyParamExcption("param is error  pathologyDiagnosis is null");
			if(StringUtils.isEmpty(req.getPathologyDiagnosisCode()))
				throw new EmptyParamExcption("param is error pathologyDiagnosisCode is null");
		}else{
			throw new EmptyParamExcption("param is error   diagnosisTypeId()："+req.getDiagnosisTypeId());
		}
		EmedicalRecord emedicalRecord = createEmedicalRecord(req.getPatientId(), req.getCreatorId(), req.getSourceFlag(), 0);
		emedicalRecord.setEmrType(1);
		emedicalRecord.setEmrSubType(9);
		if(req.getVisitTime()==null)
			req.setVisitTime(new Date());
		//确诊时间
		emedicalRecord.setVisitTime(req.getVisitTime());
		insertEmedicalRecord(emedicalRecord);
		req.setEmrId(emedicalRecord.getEmrId());
		req.setDiagnosisId(GeneralUtil.generateUniqueID("EDIAG"));
		diagnosisDao.createDiagnosis(req);
	}
	
	@Override
	@Transactional
	public void createcreateDiagnosis(PatientDiagnosisReq req){
		createPatientDiagnosis(req);
	}
	//修改诊断
	@Override
	public void modifyPatientDiagnosis(PatientDiagnosisReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getDiagnosisId()))
			throw new EmptyParamExcption("diagnosisId is null");
		if(req.getDiagnosisTypeId()==null)
			throw new EmptyParamExcption("diagnosisTypeId is null");
		if(req.getCreatorId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getVisitTime()==null)
			throw new EmptyParamExcption("visitTime is null");
		if(req.getDiagnosisTypeId()==2){
			if(StringUtils.isEmpty(req.getDiagnosis()))
				throw new EmptyParamExcption("param is error param："+JsonUtil.toJson(req));
		}else if(req.getDiagnosisTypeId()==9){
			if(StringUtils.isEmpty(req.getPathologyDiagnosis()))
				throw new EmptyParamExcption("param is error  pathologyDiagnosis is null");
			if(StringUtils.isEmpty(req.getPathologyDiagnosisCode()))
				throw new EmptyParamExcption("param is error pathologyDiagnosisCode is null");
		}else{
			throw new EmptyParamExcption("param is error   diagnosisTypeId()："+req.getDiagnosisTypeId());
		}
		if(diagnosisDao.modifyDiagnosis(req)==0)
			throw new EmptyObjectExcption("update error param:"+JsonUtil.toJson(req));
	}
	
	//删除患者诊断信息
	@Override
	@Transactional
	public void delPatientDiagnosis(PatientDiagnosisReq req) {
		// TODO Auto-generated method stub
		if (req.getDiagnosisId() == null || req.getCreatorId() == null) {
			throw new EmptyParamExcption(
					"property is null diagnosisId=" + req.getDiagnosisId() + "   createId=" + req.getCreatorId());
		}
		String emrId = diagnosisDao.queryPatientDiagnosisEmrIdByCreatorId(req);
		if (diagnosisDao.delDiagnosis(req) == 0) {
			throw new EmptyObjectExcption("Not check param data  param is :" + JsonUtil.toJson(req));
		}
		// 删除电子病历
		delEmedicalRecord(emrId);
	}
	
	//获取治疗
	@Override
	public Page<TTreatmentInfo> getPatientPastTreatmentList(PatientPastTreatmentListReq req) {
		// TODO Auto-generated method stub
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<TTreatmentInfo> list =treatmentNoteDao.queryPatientTreatment(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TTreatmentInfo>)list);
	}
	
	//新增治疗
	@Override
	@Transactional
	public void addPatientPastTreatment(PatientPastTreatmentReq req) {
		if(req.getSourceFlag()==null)
			throw new EmptyParamExcption("sourceFlag is null");
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		if(req.getCreatorId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getTreatmentBeginTime()==null)
			throw new EmptyParamExcption("treatmentBeginTime is null");
		if(req.getTreatmentTypeId()==null)
			throw new EmptyParamExcption("treatmentTypeId is null");
		if(StringUtils.isEmpty(req.getTreatmentName()))
			throw new EmptyParamExcption("treamtmentName is null");
		if(req.getTreatmentName().length()>500)
			throw new EmptyParamExcption("treamtmentName is to long");
		EmedicalRecord emedicalRecord = createEmedicalRecord(req.getPatientId(), req.getCreatorId(), req.getSourceFlag(), 0);
		emedicalRecord.setEmrType(1);
		emedicalRecord.setEmrSubType(4);
		if(req.getTreatmentBeginTime()!=null)
			emedicalRecord.setVisitTime(req.getTreatmentBeginTime());
		else
			emedicalRecord.setVisitTime(new Date());
		insertEmedicalRecord(emedicalRecord);
		req.setEmrId(emedicalRecord.getEmrId());
		req.setTreatmentId(GeneralUtil.generateUniqueID("ETRE"));
		treatmentNoteDao.createTreatment(req);
	}
	//修改治疗
	@Override
	public void modifyPatientPastTreatment(PatientPastTreatmentReq req) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(req.getTreatmentId()))
			throw new EmptyParamExcption("treatmentId is null");
		if(req.getCreatorId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getTreatmentBeginTime()==null)
			throw new EmptyParamExcption("treatmentBeginTime is null");
		if(req.getTreatmentTypeId()==null)
			throw new EmptyParamExcption("treatmentTypeId is null");
		if(StringUtils.isEmpty(req.getTreatmentName()))
			throw new EmptyParamExcption("treamtmentName is null");
		if(req.getTreatmentName().length()>500)
			throw new EmptyParamExcption("treamtmentName is to long");
		if(treatmentNoteDao.modifyTreatment(req)==0)
			throw new EmptyObjectExcption("update error param:"+JsonUtil.toJson(req));
	}
	
	/**
	 * 删除既往治疗
	 * @author lichenghao
	 * @title :delPatientPastTreatment
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月24日 下午8:30:45
	 */
	@Override
	@Transactional
	public void delPatientPastTreatment(PatientPastTreatmentReq req) {
		// TODO Auto-generated method stub
		if(req.getCreatorId()==null)
			throw new EmptyParamExcption("creatorId is null");
		if(req.getTreatmentId()==null)
			throw new EmptyParamExcption("treatmentId is null");
		String emrId = treatmentNoteDao.queryPatientTreatmentEmrIdByCreatorId(req);
		if(StringUtils.isEmpty(emrId))
			throw new EmptyObjectExcption("treatment is null");
		treatmentNoteDao.delPatientTreatment(req);
		delEmedicalRecord(emrId);
	}
	
	
	/**
	 * 生成emr
	 * @author lichenghao
	 * @title :createEmedicalRecord
	 * @Description:TODO
	 * @return EmedicalRecord
	 * @date 2016年5月25日 上午10:08:37
	 */
	private EmedicalRecord createEmedicalRecord(Long patientId,Long creatorId,Integer sourceFlag,Integer visibleFlag){
		EmedicalRecord emr = new EmedicalRecord();
		emr.setPatientId(patientId);
		emr.setCreatorId(creatorId);
		emr.setSourceFlag(sourceFlag);
		emr.setVisibleFlag(visibleFlag);
		emr.setStructFlag(0);
		return emr;
	}
	/**
	 * 保存电子病历
	 * @author lichenghao
	 * @title :insertEmedicalRecord
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月25日 上午9:54:38
	 */
	private  void insertEmedicalRecord(EmedicalRecord emedicalRecord)
	{
		//保存电子病例主信息
		emedicalRecord.setEmrId(GeneralUtil.generateUniqueID("EMRI"));
		emedicalRecord.setCacheIndex(System.currentTimeMillis());
		emrDao.insertEmedicalRecord(emedicalRecord);
	}
	
	/**
	 * 删除电子病历
	 * @author lichenghao
	 * @title :delEmedicalRecord
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月25日 上午10:02:05
	 */
	private void delEmedicalRecord(String emrId){
		emrDao.deleteEmedicalRecord(emrId);
	}

	@Override
	public List<PatientSymptomInfo> patientSymptomList(Map<String,Object> paramsMap) {
		return patientSymptomDao.patientSymptomList(paramsMap);
	}
	
	@Transactional
	@Override
	public int savePatientSymptom(List<PatientSymptomInfo> patientSymptom) {
		int res = 0;
		if(patientSymptom != null && patientSymptom.size() > 0) {
			if(patientSymptom.get(0).getPatientId() != null) {
				for(PatientSymptomInfo symptom: patientSymptom){
					if(StringUtils.isEmpty(symptom.getSymptomId())) {
						symptom.setSymptomId(GeneralUtil.generateUniqueID("SYMP"));
					}
					//更新检验类型元数据信息
					//String mainKey=symptom.getSymptomTypeId()!=null?symptom.getSymptomTypeId().toString():null;
					if(StringUtils.isNotBlank(symptom.getSymptomName())){
						UserDefinedMetaData metaData=new UserDefinedMetaData();
						metaData.setMainKey(null);
						metaData.setMetaName(symptom.getSymptomName());
						metaData.setCreator(symptom.getOperatorId());
						
						metaData.setMetaDataTable("ehr_db.meta_e_clinic_symptom");
						metaData.setMainKeyField("symptomId");
						metaData.setMetaNameField("symptomName");
						Integer finalKey=this.metaDataService.addMetaDate(metaData);
						symptom.setSymptomTypeId(finalKey);
					}
					//更新业务表信息
					res += patientSymptomDao.insertPatientSymptom(symptom);
				}
			}
		}
		return res;
	}

	@Override
	public int deletePatientSymptom(Map<String, Object> paramsMap) {
		return patientSymptomDao.deletePatientSymptom(paramsMap);
	}
}
