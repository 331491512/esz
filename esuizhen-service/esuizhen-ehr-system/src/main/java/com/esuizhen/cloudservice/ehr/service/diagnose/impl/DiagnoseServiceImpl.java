package com.esuizhen.cloudservice.ehr.service.diagnose.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.TDiagnose;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.patient.DiagnosisDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.service.diagnose.DiagnoseService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.DiagInnerService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PageUtil;

@Service
public class DiagnoseServiceImpl implements DiagnoseService,DiagInnerService{
	@Autowired
	private DiagnosisDao diagnosisDao;
	
	@Autowired
	private EmedicalRecordDao emrDao;
	
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
	
	//获取诊断
	@Override
	public Page<TDiagnose> getPatientDiagnosisList(PatientDiagnosisListReq req) {
		// TODO Auto-generated method stub
		if(req.getPatientId()==null)
			throw new EmptyParamExcption("patientId is null");
		//诊断状态  默认为0
		if(req.getDiagnosisTypeId()==null)
			req.setDiagnosisTypeId(0);
		PageHelper.startPage(req.getPage()+1,req.getNum());
		List<TDiagnose> list =diagnosisDao.queryPatientDiagnosis(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TDiagnose>)list);
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
		
		@Override
		@Transactional
		public void createcreateDiagnosis(PatientDiagnosisReq req){
			createPatientDiagnosis(req);
		}
}
