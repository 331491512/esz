package com.esuizhen.cloudservice.ehr.service.posttreatment.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.EmedicalRecordDao;
import com.esuizhen.cloudservice.ehr.dao.patient.TreatmentNoteDao;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.EmedicalRecord;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.esuizhen.cloudservice.ehr.service.posttreatment.PastTreatmentService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.PageUtil;

@Service
public class PastTreatmentServiceImpl implements PastTreatmentService {
	@Autowired
	private TreatmentNoteDao treatmentNoteDao;
	@Autowired
	private EmedicalRecordDao emrDao;
	@Autowired
	private MetaDataService metaDataService;
	
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

}
